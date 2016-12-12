/*
 * Copyright (C) 2011 Everit Kft. (http://www.everit.org)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.everit.persistence.querydsl.support.ri;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.everit.persistence.querydsl.support.QuerydslCallable;
import org.everit.persistence.querydsl.support.QuerydslRunnable;
import org.everit.persistence.querydsl.support.QuerydslSupport;

import com.querydsl.sql.Configuration;

/**
 * Implementation class of {@link QuerydslSupport}.
 */
public class QuerydslSupportImpl implements QuerydslSupport {

  private Configuration configuration;

  private DataSource dataSource;

  /**
   * Constructor.
   *
   * @param configuration
   *          Querydsl configuration.
   * @param dataSource
   *          DataSource for database connections.
   */
  public QuerydslSupportImpl(final Configuration configuration, final DataSource dataSource) {
    this.configuration = configuration;
    this.dataSource = dataSource;
  }

  @Override
  public <R> R execute(final QuerydslCallable<R> callable) {
    try (Connection connection = dataSource.getConnection()) {
      return callable.call(connection, configuration);
    } catch (SQLException e) {
      throw configuration.translate(e);
    }
  }

  @Override
  public void execute(final QuerydslRunnable runnable) {
    try (Connection connection = dataSource.getConnection()) {
      runnable.run(connection, configuration);
    } catch (SQLException e) {
      throw configuration.translate(e);
    }
  }

  @Override
  public Configuration getConfiguration() {
    return configuration;
  }
}

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
package org.everit.persistence.querydsl.support;

import java.sql.Connection;
import java.sql.SQLException;

import com.querydsl.sql.Configuration;

/**
 * Functional interface to be able to do database operations with the help of Querydsl in the way
 * that {@link SQLException}s are handled by the exception translator of Querydsl.
 *
 * @param <R>
 *          Type of the return value
 */
public interface QuerydslCallable<R> {

  /**
   * Function of the functional interface.
   *
   * @param connection
   *          An opened database connection.
   * @param configuration
   *          The Querydsl configuration that should be used for Querydsl queries.
   * @return An optional return value.
   * @throws SQLException
   *           The exceptions that are thrown from the function calls of connection will be
   *           translated by Querydsl.
   */
  R call(Connection connection, Configuration configuration) throws SQLException;
}

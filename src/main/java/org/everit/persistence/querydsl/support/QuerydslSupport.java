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

/**
 * An OSGi service that implements this interface can be used to write less codes and have less
 * references in the components that do database operations Empty line should be followed by tag on
 * the next line.based on Querydsl.
 * <p>
 * Programmers who use this service should implement {@link QuerydslCallable} interface. That is a
 * functional interface so it can be used with lambda expressions.
 * </p>
 */
public interface QuerydslSupport {

  /**
   * Executing the callback implementation in the way that SQLExceptions are translated by Querydsl.
   *
   * @param callable
   *          The functional interface that should be implemented by the programmer.
   * @param <R>
   *          The type of an optional return value.
   * @return An optional return value.
   */
  <R> R execute(QuerydslCallable<R> callable);
}

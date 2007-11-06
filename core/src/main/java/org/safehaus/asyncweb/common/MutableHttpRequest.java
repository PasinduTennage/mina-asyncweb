/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 *
 */
package org.safehaus.asyncweb.common;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.List;
import java.util.Map;

/**
 * A mutable {@link HttpRequest}.
 * @author trustin
 * @version $Rev$, $Date$
 */
public interface MutableHttpRequest extends MutableHttpMessage, HttpRequest {
  
  /**
   * Sets the cookies of this message by parsing the specified <tt>headerValue</tt>.
   */
  void setCookies(String headerValue);

  /**
   * Adds a query parameter to this request.
   * Adding a query parameter does not cause any existing parameters with the
   * same name to be overwritten
   * 
   * @param name   The header name
   * @param value  The header value
   */
  void addParameter(String name, String value);

  /**
   * Removes all query parameters with the specified name.
   */
  boolean removeParameter(String name);
  
  /**
   * Sets the value of a query parameter.
   * Any existing query parameters with the specified name are removed.
   */
  void setParameter(String name, String value);

  /**
   * Sets query parameters with the specified {@link Map} whose key is a {@link String} and
   * whose value is a {@link List} of {@link String}s.
   */
  void setParameters(Map<String, List<String>> parameters);
  
  /**
   * Sets query parameters from the specified <tt>queryString</tt> which is encoded with UTF-8
   * encoding.
   */
  void setParameters(String queryString);
  
  /**
   * Sets query parameters from the specified <tt>queryString</tt> which is encoded with the
   * specified charset <tt>encoding</tt>.
   */
  void setParameters(String queryString, String encoding) throws UnsupportedEncodingException;
  
  /**
   * Removes all query parameters from this request.
   */
  void clearParameters();
  
  /**
   * Sets the {@link HttpMethod} associated with this request.
   */
  void setMethod(HttpMethod method);
  
  /**
   * Sets the URI of the request.
   */
  void setRequestUri(URI requestUri);
}
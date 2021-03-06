/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package org.apache.ahc.auth;

public class AuthSchemeBase {
        /**
     * Original challenge string as received from the server.
     */
    private String challenge = null;

    /**
     * Constructor for an abstract authetication schemes.
     *
     * @param challenge authentication challenge
     *
     * @throws MalformedChallengeException is thrown if the authentication challenge
     * is malformed
     *
     * @deprecated Use parameterless constructor and {@link AuthScheme#processChallenge(String)}
     *             method
     */
    public AuthSchemeBase(final String challenge)
      throws MalformedChallengeException {
        super();
        if (challenge == null) {
            throw new IllegalArgumentException("Challenge may not be null");
        }
        this.challenge = challenge;
    }

    /**
     * @see java.lang.Object#equals(Object)
     */
    public boolean equals(Object obj) {
        if (obj instanceof AuthSchemeBase) {
            return this.challenge.equals(((AuthSchemeBase) obj).challenge);
        } else {
            return super.equals(obj);
        }
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return this.challenge.hashCode();
    }

    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return this.challenge;
    }
}

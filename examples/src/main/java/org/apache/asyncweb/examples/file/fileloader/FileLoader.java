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

package org.apache.asyncweb.examples.file.fileloader;

import java.io.File;
import java.io.IOException;

import org.apache.mina.common.IoBuffer;

/**
 * Interface for providing IoBuffer to File serving services.
 * @author The Apache MINA Project (dev@mina.apache.org)
 */
public interface FileLoader {
	
	/**
	 * Provide an IoBuffer from a given File
	 * @param file the file to provide
	 * @return a buffer representing the file
	 */
	IoBuffer loadFile(File file) throws IOException;
}
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
package org.apache.asyncweb.examples.file.index;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.apache.asyncweb.examples.file.mimetype.MimeMap;
import org.apache.asyncweb.server.errorReporting.CSS;
import org.apache.mina.common.IoBuffer;

public class DefaultDirectoryIndexGenerator implements DirectoryIndexGenerator {

    public IoBuffer generateIndex(File directory) {
        File[] files = directory.listFiles();

        StringBuilder html = new StringBuilder(1024);
        html.append("<html><head><title>");
        html.append("AsyncWeb Server - ");
        html.append(directory.getName());
        html.append("</title><style><!--");
        CSS.appendTo(html).append("--></style>");
        html.append("</head></body>");
        html.append("<H1>Index of : ").append(directory.getName()).append(
                "</H1>\n");
        html
                .append("<table cellpadding=\"5\"><tr><th>Name</th><th>Type</th><th>Size</th><th>Last-modified</th></tr>");

        for (File file : files) {
            html.append("<tr><td><a href=\"").append(file.getName());
            if(file.isDirectory())
                html.append("/");
            html.append("\">");
            html.append(file.getName());
            if(file.isDirectory())
                html.append("/");
            html.append("</a></td><td>");
            html.append(getType(file));
            html.append("</td><td>");
            html.append(file.length());
            html.append("</td><td>");
            html.append(new Date(file.lastModified()));
            html.append("</td></tr>");
        }
        html.append("</table>");
        html.append("<HR size=\"1\" noshade=\"noshade\">");
        html.append("<H2>AsyncWeb Server</H2></body></html>");
        IoBuffer out = IoBuffer.allocate(html.length());

        // TODO: Need to sort this out when we start dealing with character encodings
        try {
            byte[] bytes = html.toString().getBytes("US-ASCII");
            out.put(bytes);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        return out;
    }
    
    private String getType(File file) {
        if(file.isDirectory())
            return "DIR";
        String extension = MimeMap.getExtension(file.getName());
        if(extension==null)
            return "";
        else
            return extension.toLowerCase();
    }

}

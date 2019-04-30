package org.apache.asyncweb.examples.lightweight;

import java.util.Dictionary;

public class DBHandler extends RequestHandler {
    @Override
    public String handleRequest(Dictionary parameters){
        int id = Integer.parseInt(parameters.get("id").toString());
        return new MysqlCon().getName(id);
    }

}

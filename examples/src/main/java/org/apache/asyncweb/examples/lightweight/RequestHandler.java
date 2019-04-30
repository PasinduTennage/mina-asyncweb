package org.apache.asyncweb.examples.lightweight;

import java.util.Dictionary;

public abstract class RequestHandler {

    public abstract String handleRequest(Dictionary parameters);
}

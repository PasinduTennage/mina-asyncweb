package org.apache.asyncweb.examples.lightweight;

import java.util.Dictionary;

public class CPUHandler extends RequestHandler {

    @Override
    public String handleRequest(Dictionary parameters){
        int number = Integer.parseInt(parameters.get("number").toString());
        return isPrime(number)+"";

    }
    private boolean isPrime(int number){

        for (int i = 2; i< number; i++){
            if(number%i==0){
                return false;
            }


        }
        return true;
    }

}

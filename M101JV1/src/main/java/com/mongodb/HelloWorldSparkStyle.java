package com.mongodb;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
/**
 * Created by rajeshQatar on 10/19/2015.
 */
public class HelloWorldSparkStyle {
    public static void main(String[] args){
    	
    	Spark.get(new Route("/") {			
			@Override
			public Object handle(Request request, Response response) {
				// TODO Auto-generated method stub
				return "Hello world Generic";
			}
		});
    
    	Spark.get(new Route("/test") {			
			@Override
			public Object handle(Request request, Response response) {
				// TODO Auto-generated method stub
				return "Hello world test url of spark project";
			}
		});
    	
    	Spark.get(new Route("/test/:thing") {			
			@Override
			public Object handle(Request request, Response response) {
				// TODO Auto-generated method stub
				return "Test url with wild char or params:: "+request.params(":thing");
			}
		});

    }
}

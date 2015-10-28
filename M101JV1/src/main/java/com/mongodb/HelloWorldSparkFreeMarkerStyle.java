package com.mongodb;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
/**
 * Created by rajeshQatar on 10/19/2015.
 */
public class HelloWorldSparkFreeMarkerStyle {
	
    public static void main(String[] args){
    	
    	final Configuration configuration = new Configuration();
    		configuration.setClassForTemplateLoading(HelloWorldSparkFreeMarkerStyle.class, "/");
    	
    	Spark.get(new Route("/") {			
			@Override
			public Object handle(Request request, Response response) {
				StringWriter stringWriter = new StringWriter();
				try{
					Template helloTemplate = configuration.getTemplate("hello.ftl");
					Map<String, Object> helloMap = new HashMap<String, Object>();
					helloMap.put("name", "FreeMarker");
					helloTemplate.process(helloMap, stringWriter);
				}catch(Exception e){
					halt(500);
					e.printStackTrace();
				}
				return stringWriter;
			}
		});
    

    }
}

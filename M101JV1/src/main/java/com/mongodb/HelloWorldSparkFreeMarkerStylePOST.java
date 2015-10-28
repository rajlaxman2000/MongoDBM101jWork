package com.mongodb;

import java.io.StringWriter;
import java.util.Arrays;
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
public class HelloWorldSparkFreeMarkerStylePOST {
	
    public static void main(String[] args){
    	
    	final Configuration configuration = new Configuration();
    		configuration.setClassForTemplateLoading(HelloWorldSparkFreeMarkerStylePOST.class, "/");
    	
    	Spark.get(new Route("/") {			
			@Override
			public Object handle(Request request, Response response) {				
				
				StringWriter stringWriter = new StringWriter();
				try{					
					Map<String, Object> fruitsMap = new HashMap<String, Object>();
					fruitsMap.put("fruits", Arrays.asList("apple","orange","banna","peach"));
					
					Template fruitPickerTemplate = configuration.getTemplate("fruitPicker.ftl");					
					fruitPickerTemplate.process(fruitsMap, stringWriter);
					
					return stringWriter;
				}catch(Exception e){
					halt(500);
					return null;
				}				
			}
		});
    	
    	Spark.post(new Route("/favorite_fruit") {			
			@Override
			public Object handle(Request request, Response response) {				
				final String fruit = request.queryParams("fruit");
				if(fruit==null){
					return "Why dont you pick one?";
				}else{
					return "Your favorite fruit is :: "+fruit;
				}
			}
		});
    

    }
}

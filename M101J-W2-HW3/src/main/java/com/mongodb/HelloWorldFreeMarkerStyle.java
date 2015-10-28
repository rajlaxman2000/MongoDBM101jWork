package com.mongodb;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class HelloWorldFreeMarkerStyle {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(HelloWorldFreeMarkerStyle.class, "/");
        try {
            Template helloTemplate = configuration.getTemplate("hello.ftl");
            StringWriter stringWriter = new StringWriter();
            Map<String, Object> helloMap = new HashMap<String, Object>();
            helloMap.put("name", "FreeMarker");
            helloTemplate.process(helloMap, stringWriter);
            System.out.println(stringWriter);
        } catch (Exception e) {
            System.err.println("Exception");
            e.printStackTrace();
        }
    }

}

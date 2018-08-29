/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Util;

import com.entities.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author ben
 */
public class RestClient {
    public <T extends Object> T Get(String address, Class<T> valueType) {
        T result = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            String output = SendRequest(address, "GET", null);
            result = mapper.readValue(output, valueType); 
        } catch (IOException e) {
            e.printStackTrace();
	}
        return result;
    }
    
    public String Post(String address, Object content) {
        return Change(address, content, "POST");
    }
    
    public String Put(String address, Object content) {
        return Change(address, content, "PUT");
    }
    
    private String Change(String address, Object content, String method) {
         try {
            ObjectMapper mapper = new ObjectMapper();  
            String body = mapper.writeValueAsString(content);
            return SendRequest(address, method, body);
        } catch (IOException e) {
            e.printStackTrace();
	}
        return "";       
    }
        
    private String SendRequest(String address, String method, String body) {
        String content = "" ,output;
        try {
            URL url = new URL(address);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(method);
            conn.setRequestProperty("Accept", "application/json");
            
            if (body != null) {
                conn.setRequestProperty("Content-Type", "application/json");
                conn.setDoOutput(true);
                OutputStream os = conn.getOutputStream();
		os.write(body.getBytes());
		os.flush();
            }
            
            if (conn.getResponseCode() != 200 && conn.getResponseCode() != 204) {
		throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            while ((output = br.readLine()) != null) {
                content = output;
            }
            conn.disconnect();            
        } catch (MalformedURLException e) {
            e.printStackTrace();
	} catch (IOException e) {
            e.printStackTrace();
	} 
        return content;
    }
}

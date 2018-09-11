package com.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.openu_workshop_client.Config;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RestRequests {
        
    public <T extends Object> T Get(String url, Class<T> valueType) throws IOException {      
        Request request = CreateRequestBuilder(url).build();   
        Response response = SendRequest(request);
        //String body = ExtractBody(response);
        return DeserializeBody(response.body().string(), valueType);
    }  
    
    public void Post(String url, Object content) throws IOException {
        Request request = CreateRequestBuilder(url).post(GetRequestBody(content)).build();
        SendRequest(request);
    }  
    
    public void Put(String url, Object content) throws IOException {
        Request request = CreateRequestBuilder(url).put(GetRequestBody(content)).build();
        SendRequest(request);
    }
    
    public void Delete(String url) throws IOException {
        Request request = CreateRequestBuilder(url).delete().build();
        SendRequest(request);
    }    
    
    private RequestBody GetRequestBody(Object content) throws IOException {    
        String jsonBody = SerializeBody(content);
        return RequestBody.create(MediaType.parse("application/json;"), jsonBody); 
    }       
    
    private Builder CreateRequestBuilder(String url) {
        return new Request.Builder().url(Config.Host + "/" + url);
    }
    
    private Response SendRequest(Request request) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        return call.execute();        
    }
    
    private String ExtractBody(Response response) throws IOException {
        String output = "";
        String content = "";
        BufferedReader br = new BufferedReader(new InputStreamReader((response.body().byteStream())));
        while ((output = br.readLine()) != null) {
            content = output; 
        }  
        return content;
    }
    
    private <T extends Object> T DeserializeBody(String body, Class<T> valueType) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(body, valueType);         
    }
    
    private String SerializeBody(Object content) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(content);         
    }
}

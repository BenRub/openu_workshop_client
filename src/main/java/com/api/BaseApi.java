package com.api;

public abstract class BaseApi {
   protected String url;
   protected RestRequests requests;
   public BaseApi(String url) {
       this.url = url;
       this.requests = new RestRequests();
   }
}

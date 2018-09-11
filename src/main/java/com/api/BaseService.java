package com.api;

public abstract class BaseService {
   protected String url;
   protected RestRequests requests;
   public BaseService(String url) {
       this.url = url;
       this.requests = new RestRequests();
   }
}

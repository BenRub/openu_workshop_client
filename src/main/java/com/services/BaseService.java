package com.services;

import com.Util.RestRequests;

public abstract class BaseService {
   protected String url;
   protected RestRequests requests;
   public BaseService(String url) {
       this.url = url;
       this.requests = new RestRequests();
   }
}

package com.fh.project.designMode.principles.lsp;

import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import sun.net.www.http.HttpClient;

public class Transporter {
    private HttpClient httpClient;
    private String name;

    public Transporter(){
        System.out.println("Transporter 无参构造方法");
    }

    public Transporter(HttpClient httpClient) {
        System.out.println("Transporter 有参构造方法");
        this.httpClient = httpClient;
    }

    public Response sendRequest(Request request) {
        return null;
    }

    public HttpClient getHttpClient() {
        return httpClient;
    }

    public void setHttpClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
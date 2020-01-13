package com.fh.project.designMode.principles.lsp;

import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.apache.commons.lang.StringUtils;
import sun.net.www.http.HttpClient;


public class SecurityTransporter extends Transporter {
    private String appId;
    private String appToken;

    public SecurityTransporter(){
        System.out.println("SecurityTransporter 无参构造方法");
    }

    public SecurityTransporter(HttpClient httpClient, String appId, String appToken) {
        super(httpClient);
        this.appId = appId;
        this.appToken = appToken;
    }

    @Override
    public Response sendRequest(Request request) {

        return super.sendRequest(request);
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppToken() {
        return appToken;
    }

    public void setAppToken(String appToken) {
        this.appToken = appToken;
    }
}

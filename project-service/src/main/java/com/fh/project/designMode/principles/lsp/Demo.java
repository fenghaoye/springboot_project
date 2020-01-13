package com.fh.project.designMode.principles.lsp;

import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;

public class Demo {
    public void demoFunction(Transporter transporter) {
        Request request = new Request(); //...省略设置request中数据值的代码...
        Response response = transporter.sendRequest(request); //...省略其他逻辑...
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        SecurityTransporter securityTransporter = new SecurityTransporter();
        demo.demoFunction(securityTransporter);
        int hashCode = demo.hashCode();
        System.out.println(demo.hashCode());
        System.out.println(Integer.toBinaryString(hashCode));
    }
}

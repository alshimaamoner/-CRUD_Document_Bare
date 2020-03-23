package service;

import javax.xml.ws.Endpoint;
public class PublishWS {
    public static void main(String[] args){
        Endpoint.publish("http://localhost:888/employee",new CrudEmp());
        System.out.println("**** publish WS ****");

    }
}

package client;

import services.*;
import java.util.*;
public class SampleClient {

    public static void main(String[] args) {
        CrudEmpService crudServiceRef = new CrudEmpService();
        CrudEmp crudService = crudServiceRef.getCrudEmpPort();
       User user= crudService.showUser(1);
        user.setName("alyaa");
        user.setPas("124");
        user.setFirstName("alyaa");
        user.setLastName("ali");
        String result=crudService.updateUser(user);
        System.out.println("update user info " + result);
        
       user= crudService.showUser(1);
       System.out.println("show user " + user.getName());
       
        
       
    }

}
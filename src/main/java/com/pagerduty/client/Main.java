package com.pagerduty.client;

import com.pagerduty.client.model.ListUser;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        (new ConsoleAppExample()).run();
        PagerDutyClient client = new PagerDutyClient();
        try {
            List<ListUser> users = client.getUsers();
            users.forEach(user -> {
                System.out.println("User name is: " + user.getName() + " and email is: " + user.getEmail());
                user.getContact_methods().forEach(method -> System.out.println("     The user's contact method type is " + method.getType() + " and the email address is " + method.getAddress()));
            });
        } catch (IOException e) {
            System.out.println("Exception was thrown");

        }
    }
}






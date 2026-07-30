package com.springboot.spring_profile.Notification;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class DemoNotificationProdMode implements Notification {

    @Override
    public void notification(){
        System.out.println("prod notification");

    }
}

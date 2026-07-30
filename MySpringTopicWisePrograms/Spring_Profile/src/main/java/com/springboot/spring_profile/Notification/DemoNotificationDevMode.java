package com.springboot.spring_profile.Notification;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class DemoNotificationDevMode implements Notification {

    @Override
    public void notification(){
        System.out.println("Dev mode notification");
    }
}

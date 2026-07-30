package com.springboot.spring_profile.Services;


import com.springboot.spring_profile.Notification.Notification;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final Notification notification;

    public NotificationService(Notification notification){
        this.notification=notification;
    }

    public void giveNotification(){
        notification.notification();
    }

}

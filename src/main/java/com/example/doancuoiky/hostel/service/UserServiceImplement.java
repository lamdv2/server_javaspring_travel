package com.example.doancuoiky.hostel.service;

import com.example.doancuoiky.hostel.model.*;

import com.example.doancuoiky.hostel.response.ResponseAll;
import com.google.api.client.util.DateTime;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.*;

@Service

public class UserServiceImplement implements IuserService {
    @Autowired
    private FirebaseMessaging firebaseMessaging;
    @Override
    public ResponseAll sendNotificationByToken(NotificationMessaging notificationMessaging){
        Notification notification = Notification.builder()
                .setTitle(notificationMessaging.getTitle())
                .setBody(notificationMessaging.getBody())
                .setImage(notificationMessaging.getImg())
                .build();
        Message message = Message.builder()
                .setToken(notificationMessaging.getToken())
                .setNotification(notification)
                .putAllData(notificationMessaging.getData())
                .build();
        try{
            firebaseMessaging.send(message);
            return new ResponseAll (true,"Success Sending Notification");
        }catch (FirebaseMessagingException exception){
            exception.printStackTrace();
            return new ResponseAll(false, "Error Sending Notification");
        }
    }
}

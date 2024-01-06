package com.example.doancuoiky.hostel.service;

import com.example.doancuoiky.hostel.model.*;

import com.example.doancuoiky.hostel.response.ResponseAll;



public interface IuserService {
    ResponseAll sendNotificationByToken(NotificationMessaging notificationMessaging);
}

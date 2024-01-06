package com.example.doancuoiky.hostel.controller;

import com.example.doancuoiky.hostel.model.*;

import com.example.doancuoiky.hostel.response.ResponseAll;
import com.example.doancuoiky.hostel.service.IuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private IuserService iuserService;

    @PostMapping("/notification")
    public ResponseEntity<?> sendNotification(@RequestBody NotificationMessaging notificationMessaging){
        ResponseAll responseAll =  iuserService.sendNotificationByToken(notificationMessaging);
        if (responseAll.isSuccess()){
           // return ResponseEntity.ok(iuserService.sendNotificationByToken(notificationMessaging));
            return ResponseEntity.ok("ok");
        }
        else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + responseAll.getMessage());
        }
    }
}

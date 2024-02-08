package com.carsale.back.API.Controller;

import com.carsale.back.API.Model.NotificationMessageReponse;
import com.carsale.back.API.Model.NotificationMessageRequest;
import com.carsale.back.API.Service.PushNotificationService;
import org.springframework.http.HttpStatus;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class PushNotificationController {


    private PushNotificationService pushNotificationService;

    public PushNotificationController(PushNotificationService pushNotificationService) {
        this.pushNotificationService = pushNotificationService;
    }

    @PostMapping("/notification/token")
    public ResponseEntity sendTokenNotification(@RequestBody NotificationMessageRequest request) {
        System.out.println("notification/token -----------------------"+request.getToken());
        pushNotificationService.sendPushNotificationToToken(request);
        return new ResponseEntity<>(new NotificationMessageReponse(HttpStatus.OK.value(), "Notification has been sent."), HttpStatus.OK);
    }

}

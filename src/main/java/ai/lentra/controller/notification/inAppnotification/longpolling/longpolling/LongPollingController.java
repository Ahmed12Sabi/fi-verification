package ai.lentra.controller.notification.inAppnotification.longpolling.longpolling;

import ai.lentra.service.notification.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@RestController
public class LongPollingController {
    @Autowired
    private NotificationService service;
    @Autowired
    LongPollingEventSimulator simulator;
    @GetMapping("/test")
    DeferredResult<String> addNotificationToQueue(String username, String message){
        username="abc";
        message="demo msg";
        Long timeOutInMilliSec = 1000L;
        String timeOutResp = "Time Out.";
        DeferredResult<String> deferredResult = new DeferredResult<>(timeOutInMilliSec,timeOutResp);
        String finalUsername = username;
        CompletableFuture.runAsync(()->{
            try {
                //Long pooling task;If task is not completed within 100 sec timeout response retrun for this request
                // Add paused http requests to event queue
                simulator.getPollingQueue().add(new LongPollingSession(finalUsername, deferredResult));
//                saveNotification(username,message);
                getNotifications(finalUsername);
                TimeUnit.SECONDS.sleep(10);
                //set result after completing task to return response to client
                deferredResult.setResult("Task Finished");
            }catch (Exception ex){
            }
        });
        return deferredResult;
    }
    //First savecall save notification to save in db
    //Meassge will be from in app .properties file

    @GetMapping("/saveNotification")
    public String saveNotification( String username, String message) {
        username="abc";
                message="demo msg";
        simulator.simulateIncomingNotification(username, message);
        return "Simulating event for username Id: " + username;
    }
// Get
    public void getNotifications(String username) {
//        if (dbService.containsNotifications(notificationId)) {
//            simulator.simulateOutgoingNotification(dbService.getAndRemoveNotifications(notificationId));
        simulator.simulateOutgoingNotification(service.getNotifications(username));
//        }
    }
}

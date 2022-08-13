package com.jdps.dip;

/*
Created by J.Fırat ©
    Date : 6.08.2022
    Time : 11:21
*/
//DIP - Dependency Inversion Principle
//Üst sınıfların alt sınıflara bağımlı olmamaları gerekir.
//Bu durumda alt sınıfların üst sınıflarının bağımlılığını kontrol etmeleri gerekir.

import java.util.ArrayList;
import java.util.List;

interface MessageSender {
    void sendMessage();
}

class EmailSender implements MessageSender {
    @Override
    public void sendMessage() {
        System.out.println("Email sent");
    }
}

class SMSSender implements MessageSender {
    @Override
    public void sendMessage() {
        System.out.println("SMS sent");
    }
}

/*
* Artık email ve sms sınıflarıyla doğrudan bağlantılı olmayan ve soyut olarak tanımladığımız
* MessageSender arayüzünü kullanan bir yapı haline getirdik.
* Yüksek seviye bir sınıfın alt seviye sınıflara olan bağımlılığını ortadan kaldırarak artık soyut katman üzerinden işlemleri yapabiliyoruz.
* */

class NotificationService{
    private List<MessageSender> messageSenders;
    public NotificationService(List<MessageSender> messageSenders){
        this.messageSenders = messageSenders;
    }
    public void sendNotification(){
        for(MessageSender messageSender : messageSenders){
            messageSender.sendMessage();
        }
    }
}


public class DIPDemo {
    public static void main(String[] args) {
        List<MessageSender> messageSenders = new ArrayList<>();
        messageSenders.add(new EmailSender());
        messageSenders.add(new SMSSender());
        NotificationService notificationService = new NotificationService(messageSenders);
        notificationService.sendNotification();
    }
}

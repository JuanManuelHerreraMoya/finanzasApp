package co.com.finanzas.finanzasapp.controller;

import co.com.finanzas.finanzasapp.model.ChatMessage;
import co.com.finanzas.finanzasapp.service.MessageService;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.messaging.Body;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {
    private MessageService messageService;

    @Autowired
    public void MessageController(MessageService messageService){
        this.messageService = messageService;
    }

    @GetMapping("/health")
    public String getHealth(){
        return "hello world";
    }

    @PostMapping("/reciveMessage")
    public Message reciveMessage(@RequestBody ChatMessage chatMessage){
        return messageService.sendMessageToContact(chatMessage);
    }

    @PostMapping("/sendMessage")
    public Message sendMessage(@RequestBody ChatMessage chatMessage){
        return messageService.receiveMessageFromContact(chatMessage);
    }

}

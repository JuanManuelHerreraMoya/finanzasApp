package co.com.finanzas.finanzasapp.service;

import co.com.finanzas.finanzasapp.model.ChatMessage;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    public static final String ACCOUNT_SID = "AC2628bb4d4d49c76a2485e3e51540fd71";
    public static final String AUTH_TOKEN = "842cf194c214b4d56faf4fb5aabd2d2a";

    public Message sendMessageToContact(ChatMessage chatMessageIncoming){
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("whatsapp:"+chatMessageIncoming.getContactToSend()),
                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
                chatMessageIncoming.getInfo())
                .create();

        System.out.println(message.getSid());
        return  message;
    }

    public Message receiveMessageFromContact(ChatMessage chatMessageIncoming){
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
                        new com.twilio.type.PhoneNumber("whatsapp:"+ chatMessageIncoming.getContactToSend()),
                        chatMessageIncoming.getInfo())
                .create();
        System.out.println(message.getSid());
        return  message;
    }
}

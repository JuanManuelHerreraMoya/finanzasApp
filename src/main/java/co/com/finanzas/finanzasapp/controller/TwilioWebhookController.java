package co.com.finanzas.finanzasapp.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/webhook")
public class TwilioWebhookController {

    @PostMapping
    @ResponseBody
    public void handleIncomingWhatsAppMessage(@RequestBody String requestBody) {
        // El cuerpo de la solicitud contiene los datos del mensaje de WhatsApp
        System.out.println("Solicitud entrante: " + requestBody);

        // Extrae el texto del mensaje
        String messageText = extractMessageText(requestBody);
        System.out.println("Texto del mensaje: " + messageText);

        // Realiza cualquier procesamiento adicional que necesites
    }

    private String extractMessageText(String requestBody) {
        // Aquí debes implementar la lógica para extraer el texto del mensaje
        // La estructura de la solicitud depende de la versión de la API de Twilio que estás utilizando
        // Puedes analizar el JSON de la solicitud para obtener el texto del mensaje
        return "Texto del mensaje extraído";
    }
}

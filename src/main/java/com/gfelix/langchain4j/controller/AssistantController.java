package com.gfelix.langchain4j.controller;

import com.gfelix.langchain4j.config.agents.AssistantAiService;
import dev.langchain4j.service.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/assistant")
public class AssistantController {

    private final AssistantAiService assistantAiService;

    @Value("${twilio.account.sid}")
    private String accountSid;
    @Value("${twilio.auth.token}")
    private String twillioAuth;
    @Value("${twilio.whatsapp.number}")
    private String twillioWhatsappNumber;

    public AssistantController(AssistantAiService assistantAiService) {
        this.assistantAiService = assistantAiService;
    }

    @PostMapping()
    public String askAssistant(@RequestBody String userMessage) {
        int idDoUsuario = 1;
        Result<String> result = assistantAiService.handleRequest("idDoUsuario", userMessage);

        return result.content();
    }

    @PostMapping("/receive")
    public ResponseEntity<String> receiveWhatsAppMessage(@RequestBody MultiValueMap<String, String> body) {
        String fromPhoneNumber = body.getFirst("From");
        String messageBody = body.getFirst("Body");

        Result<String> result = assistantAiService.handleRequest(fromPhoneNumber, messageBody);

        System.out.println("Received message: " + messageBody + " from " + fromPhoneNumber + ": " + result.content());

        return ResponseEntity.ok(result.content());
    }

}

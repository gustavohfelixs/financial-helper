package com.gfelix.langchain4j;

import dev.langchain4j.service.Result;
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
        String from = body.getFirst("From");
        String messageBody = body.getFirst("Body");

        Result<String> result = assistantAiService.handleRequest(from, messageBody);


        // Process the message here (e.g., log, save to DB)
        System.out.println("Received message: " + messageBody + " from " + from);

        return ResponseEntity.ok("Message received");
    }

}

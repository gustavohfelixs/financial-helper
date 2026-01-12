package com.gfelix.langchain4j;

import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.service.AiServices;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AssistantConfig {

    @Value("${gemini.api-key}")
    private String geminiApiKey;

    @Value("${gemini.model}")
    private String geminiModel;

    @Bean
    public GoogleAiGeminiChatModel googleAiGeminiChatModel() {
        return GoogleAiGeminiChatModel.builder()
                .apiKey(geminiApiKey)
                .modelName(geminiModel)
                .build();
    }

    @Bean
    public AssistantAiService assistant(GoogleAiGeminiChatModel googleAiGeminiChatModel, AssistantTools assistantTools, ChatMemoryProvider chatMemoryProvider) {


        return AiServices.builder(AssistantAiService.class)
                .chatModel(googleAiGeminiChatModel)
                .tools(assistantTools)
//                .chatMemory(MessageWindowChatMemory.withMaxMessages())
                .chatMemoryProvider(chatMemoryProvider)
                .build();
    }

    @Bean
    ChatMemoryProvider chatMemoryProvider() {
        PersistentChatMemoryStore store = new PersistentChatMemoryStore();

        return memoryId -> MessageWindowChatMemory.builder()
                .id(memoryId)
                .maxMessages(10)
                .chatMemoryStore(store)
                .build();
    }


}

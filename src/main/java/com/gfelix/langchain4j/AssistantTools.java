package com.gfelix.langchain4j;

import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class AssistantTools {

    private static final Map<String, Double> DAILY_BASE_PRICE = Map.of(
            "economic", 100.0,
            "suv", 150.0,
            "premium", 250.0
    );

    private static final Map<String, Double> INSURANCE_RATE = Map.of(
            "economic", 0.05,
            "suv", 0.08,
            "premium", 0.12
    );

    @Tool("Regitra entradas de valores com base na conta e o valor recebido")
    public String calculateQuotation(String account, double amount) {
        return String.format( "R$ %s adicionado ao saldo da conta %s. Saldo atual de %s" ,amount, account, amount + 100.00);
    }
}

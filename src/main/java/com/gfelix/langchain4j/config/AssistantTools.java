package com.gfelix.langchain4j.config;

import com.gfelix.langchain4j.domain.BankAccount;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class AssistantTools {

    List<BankAccount> bankAccounts = List.of(new BankAccount(42131l, "Itau - Gustavo", BigDecimal.valueOf(20)), new BankAccount(42132l, "Nubak - Gustavo", BigDecimal.valueOf(2230)));


    @Tool("Recupera as contas bancárias do usuário")
    public List<BankAccount> findAllBankAccounts() {
        return bankAccounts;
    }

    @Tool("Faz lançamentos financeiros na conta do usuário usando o ID da conta")
    public String operateMoneyInAccountById(Long accountId, BigDecimal amount) {
        BankAccount bankAccount = bankAccounts.stream()
                .filter(account -> account.getId().equals(accountId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Conta não encontrada"));

        BigDecimal novoSaldo = bankAccount.getBalance().add(amount);
        bankAccount.setBalance(novoSaldo);

        this.bankAccounts.set(bankAccounts.indexOf(bankAccount), bankAccount);

        return String.format(
                "Lançamento de %s realizado com sucesso. Saldo atual: %s",
                amount, novoSaldo
        );
    }
}

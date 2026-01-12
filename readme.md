# Assistente Financeiro para Whatsapp

Este projeto é um chatbot para Telegram que atua como um assistente financeiro. O bot é construído com Java 25, Spring
Boot, LangChain4j e a API do Google Gemini. A aplicação é projetada para ser implantada de forma segura e escalável no
Google Cloud Run.

## Arquitetura da Solução

A interação do usuário começa no Telegram, passa por um webhook seguro, é processada pelo serviço no Cloud Run que
utiliza o Gemini para gerar respostas, e retorna ao usuário.

![Arquitetura da Solução](arq-v1.png)

## Tecnologias Utilizadas

Este projeto integra um conjunto de tecnologias modernas para criar uma solução de IA robusta e escalável:

- **Spring Boot 3.2**: Framework principal para a criação da aplicação web, fornecendo um ecossistema completo com
  injeção de dependências, configuração automática e um servidor web embarcado (Tomcat).
- **LangChain4j 1.7**: O coração da lógica de IA. Este framework facilita a orquestração de chamadas para grandes
  modelos de linguagem (LLMs), gerenciamento de memória de chat e a criação de ferramentas personalizadas.
    - `langchain4j-spring-boot-starter`: Simplifica a integração do LangChain4j com o Spring, permitindo a configuração
      de assistentes e ferramentas através de anotações.
    - `langchain4j-google-ai-gemini-spring-boot-starter`: Provê a integração específica com a família de modelos Gemini
      do Google AI.
- **TelegramBots Spring Boot Starter 6.9**: Biblioteca que facilita a comunicação com a API do Telegram, permitindo a
  criação de bots baseados em Webhook de forma simples e integrada ao Spring.
- **Java 25**: Utiliza a versão mais recente do Java, aproveitando suas melhorias de performance e recursos de
  linguagem.
- **Maven**: Gerenciador de dependências e ferramenta de build do projeto.
- **Docker**: Utilizado para containerizar a aplicação, garantindo um ambiente de execução consistente e facilitando o
  deploy.
- **Google Cloud Run & Artifact Registry**: Plataforma serverless para a execução do contêiner e registro seguro para o
  armazenamento da imagem Docker.

- **GitHub Actions**: Utilizado para a automação do processo de CI/CD (Integração e Entrega Contínua).

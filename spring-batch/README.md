## Visão Geral

O projeto "spring-batch" é uma aplicação Spring Batch projetada para demonstrar os conceitos básicos do framework Spring Batch. Ele contém um job simples que imprime "Olá mundo!" no console.

## Estrutura do Projeto

A estrutura do projeto é a seguinte:

- **src/main/java/br/com/drianodev/springbatch**: Contém arquivos de código-fonte Java.
    - **BatchConfig.java**: Classe de configuração para definir jobs e steps do Spring Batch.

## Dependências

O projeto utiliza as seguintes dependências:

- **Spring Boot Starter Parent**: POM pai para gerenciar dependências e configurações.
- **Spring Boot Starter Batch**: Starter para utilizar o Spring Batch.
- **Spring Boot Starter Test**: Starter para testar aplicações Spring Boot.
- **Spring Batch Test**: Dependências para testar aplicações Spring Batch.
- **H2 Database**: Banco de dados em memória para fins de teste.

## Como Executar

Para executar o projeto, você pode usar qualquer IDE que suporte o Maven ou executar comandos Maven diretamente. Como é uma aplicação Spring Boot, você pode executá-la como uma aplicação Java padrão.

## Uso

O objetivo principal deste projeto é demonstrar a configuração de um job e step simples do Spring Batch. Ele consiste em um job único (`imprimeOlaJob`) que contém um step (`imprimeOlaStep`). Quando o job é executado, ele imprime "Olá mundo!" no console.

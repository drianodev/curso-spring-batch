package br.com.drianodev.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ImprimeWriteConfig {

    @Bean
    public ItemWriter<String> imprimeWrite() {
        return itens -> itens.forEach(System.out::println);
    }
}

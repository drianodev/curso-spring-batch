package br.com.drianodev.writer;


import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArquivoMultiplosFormatosItemWriter {

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Bean
    public ItemWriter leituraArquivoMultiplosFormatosWriter() {
        return items -> items.forEach(System.out::println);
    }
}

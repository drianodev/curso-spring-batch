package br.com.drianodev.writer;


import br.com.drianodev.dominio.Cliente;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LeituraArquivoMultiplosFormatosItemWriter {

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Bean
    public ItemWriter leituraArquivoMultiplosFormatosWriter() {
        return items -> items.forEach(System.out::println);
    }
}

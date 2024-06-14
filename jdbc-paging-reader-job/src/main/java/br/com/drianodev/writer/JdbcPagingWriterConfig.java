package br.com.drianodev.writer;


import br.com.drianodev.dominio.Cliente;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JdbcPagingWriterConfig {

    @Bean
    ItemWriter<Cliente> jdbcPagingWriter() {
        return clientes -> clientes.forEach(System.out::println);
    }
}

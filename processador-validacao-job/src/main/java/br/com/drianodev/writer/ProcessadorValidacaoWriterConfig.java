package br.com.drianodev.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.drianodev.dominio.Cliente;

@Configuration
public class ProcessadorValidacaoWriterConfig {

	@Bean
	ItemWriter<Cliente> processadorValidacaoWriter() {
		return clientes -> clientes.forEach(System.out::println);
	}
}

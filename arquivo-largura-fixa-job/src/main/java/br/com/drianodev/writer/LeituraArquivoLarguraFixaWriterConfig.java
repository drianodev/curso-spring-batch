package br.com.drianodev.writer;

import br.com.drianodev.dominio.Cliente;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;

@Configuration
public class LeituraArquivoLarguraFixaWriterConfig {

    // SAIDA NO CONSOLE
//    @Bean
//    public ItemWriter<Cliente> leituraArquivoLarguraFixaWriter() {
//        return items -> items.forEach(System.out::println);
//    }

    // MODIFICADO PARA ESCREVER EM ARQUIVO DE LARGURA FIXA!
    @StepScope
    @Bean
    public FlatFileItemWriter<Cliente> escritaArquivoLarguraFixaWriter(
            @Value("#{jobParameters['arquivoClientesSaida']}") WritableResource arquivoClientesSaida) {
        return new FlatFileItemWriterBuilder<Cliente>()
                .name("escritaArquivoLarguraFixaWriter")
                .resource(arquivoClientesSaida)
                .formatted()
                .format("%-9s %-9s %-2s %-19s")
                .names("nome", "sobrenome", "idade", "email")
                .build();
    }
}

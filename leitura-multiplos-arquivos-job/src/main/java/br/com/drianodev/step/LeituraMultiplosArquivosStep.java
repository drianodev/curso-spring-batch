package br.com.drianodev.step;

import br.com.drianodev.dominio.Cliente;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class LeituraMultiplosArquivosStep {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private PlatformTransactionManager transactionManager;

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Bean
    Step leituraArquivoDelimitadoStep(
            MultiResourceItemReader<Cliente> multiplosArquivosClienteTransacaoReader,
            ItemWriter leituraMultiplosArquivoItemWriter) {

        return new StepBuilder("leituraArquivoDelimitadoStep", jobRepository)
                .chunk(1, transactionManager)
                .reader(multiplosArquivosClienteTransacaoReader)
                .writer(leituraMultiplosArquivoItemWriter)
                .build();
    }
}

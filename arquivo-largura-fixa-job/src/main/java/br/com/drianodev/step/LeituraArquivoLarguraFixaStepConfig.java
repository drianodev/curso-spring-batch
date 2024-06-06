package br.com.drianodev.step;

import br.com.drianodev.dominio.Cliente;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class LeituraArquivoLarguraFixaStepConfig {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Bean
    Step leituraArquivoLarguraFixaStep(ItemReader<Cliente> leituraArquivoLarguraFixaReader, ItemWriter<Cliente> leituraArquivoLarguraFixaWriter) {
        return new StepBuilder("leituraArquivoLarguraFixaStep", jobRepository)
                .<Cliente, Cliente>chunk(1, transactionManager)
                .reader(leituraArquivoLarguraFixaReader)
                .writer(leituraArquivoLarguraFixaWriter)
                .build();
    }
}

package br.com.drianodev.job;

import br.com.drianodev.step.LeituraArquivoLarguraFixaStepConfig;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(LeituraArquivoLarguraFixaStepConfig.class)
public class ArquivoLarguraFixaJobConfig {

    @Autowired
    private JobRepository jobRepository;

    @Bean
    Job arquivoLarguraFixaJob(Step leituraArquivoLarguraFixaStep) {
        return new JobBuilder("arquivoLarguraFixaJob", jobRepository)
                .start(leituraArquivoLarguraFixaStep)
                .incrementer(new RunIdIncrementer())
                .build();
    }
}

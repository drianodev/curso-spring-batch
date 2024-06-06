package br.com.drianodev.springbatch.job;

import br.com.drianodev.springbatch.step.ImprimeOlaStepConfig;
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
@Import(ImprimeOlaStepConfig.class)
public class ImprimeOlaJobConfig {

    @Autowired
    private JobRepository jobRepository;

    @Bean
    Job imprimeOlaJob(Step imprimeOlaStep) {
        return new JobBuilder("imprimeOlaJob", jobRepository)
                .start(imprimeOlaStep)
                .incrementer(new RunIdIncrementer())
                .build();
    }
}


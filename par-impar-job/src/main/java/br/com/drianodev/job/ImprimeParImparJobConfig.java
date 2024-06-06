package br.com.drianodev.job;

import br.com.drianodev.step.ImprimeParImparStepConfig;
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
@Import(ImprimeParImparStepConfig.class)
public class ImprimeParImparJobConfig {

    @Autowired
    private JobRepository jobRepository;

    @Bean
    Job imprimeParImparJob(Step imprimeParImparStep) {
        return new JobBuilder("imprimeParImparJob", jobRepository)
                .start(imprimeParImparStep)
                .incrementer(new RunIdIncrementer())
                .build();
    }
}

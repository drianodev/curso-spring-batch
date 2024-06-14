package br.com.drianodev.job;

import br.com.drianodev.step.SkipExceptionStepConfig;
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
@Import(SkipExceptionStepConfig.class)
public class SkipExceptionJobConfig {

    @Autowired
    private JobRepository jobRepository;

    @Bean
    Job skipExceptionJob(Step skipExceptionStep) {
        return new JobBuilder("skipExceptionJob", jobRepository)
                .start(skipExceptionStep)
                .incrementer(new RunIdIncrementer())
                .build();
    }
}

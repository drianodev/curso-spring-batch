package br.com.drianodev.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;

public class ImprimeParImparStepConfig {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Bean
    Step imprimeParImparStep(IteratorItemReader<Integer> contadorReader,
                             FunctionItemProcessor<Integer, String> parOuImparProcessor,
                             ItemWriter<String> imprimeWrite) {
        return new StepBuilder("imprimeParImparStep", jobRepository)
                .<Integer, String>chunk(1, transactionManager)
                .reader(contadorReader)
                .processor(parOuImparProcessor)
                .writer(imprimeWrite)
                .build();
    }
}

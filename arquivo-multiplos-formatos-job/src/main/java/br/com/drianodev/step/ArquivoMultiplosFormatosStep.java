package br.com.drianodev.step;

import br.com.drianodev.reader.ArquivoClienteTransacaoReader;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class ArquivoMultiplosFormatosStep {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private PlatformTransactionManager transactionManager;

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Bean
    Step leituraArquivoDelimitadoStep(FlatFileItemReader leituraArquivoMultiplosFormatosReader, ItemWriter leituraArquivoMultiplosFormatosItemWriter) {
        return new StepBuilder("leituraArquivoDelimitadoStep", jobRepository)
                .chunk(1, transactionManager)
                .reader(new ArquivoClienteTransacaoReader(leituraArquivoMultiplosFormatosReader))
                .writer(leituraArquivoMultiplosFormatosItemWriter)
                .build();
    }
}

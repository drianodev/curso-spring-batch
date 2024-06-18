package br.com.drianodev.step;

import br.com.drianodev.dominio.Cliente;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class ProcessadorScriptStepConfig {

	@Autowired
	private JobRepository jobRepository;

	@Autowired
	private PlatformTransactionManager transactionManager;

	@Bean
	Step processadorScriptStep(
			ItemReader<Cliente> processadorScriptReader,
			ItemProcessor<Cliente, Cliente> processadorScriptProcessor,
			ItemWriter<Cliente> processadorScriptWriter) {
		return new StepBuilder("processadorScriptStep", jobRepository)
				.<Cliente, Cliente>chunk(1, transactionManager)
				.reader(processadorScriptReader)
				.processor(processadorScriptProcessor)
				.writer(processadorScriptWriter)
				.build();
	}
}

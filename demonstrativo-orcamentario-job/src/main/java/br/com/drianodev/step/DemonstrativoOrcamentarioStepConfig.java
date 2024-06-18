package br.com.drianodev.step;

import br.com.drianodev.dominio.GrupoLancamento;
import br.com.drianodev.reader.GrupoLancamentoReader;
import br.com.drianodev.writer.DemonstratrivoOrcamentarioRodape;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.file.MultiResourceItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class DemonstrativoOrcamentarioStepConfig {

	@Autowired
	private JobRepository jobRepository;

	@Autowired
	private PlatformTransactionManager transactionManager;

	@Bean
	Step demonstrativoOrcamentarioStep(
			// Esse aqui lê dos arquivos
			// MultiResourceItemReader<GrupoLancamento> demonstrativoOrcamentarioReader,
			// Esse aqui lê do banco de dados
			GrupoLancamentoReader demonstrativoOrcamentarioReader,
			MultiResourceItemWriter<GrupoLancamento> demonstrativoOrcamentarioWriter,
			DemonstratrivoOrcamentarioRodape rodapeCallback) {
		return new StepBuilder("demonstrativoOrcamentarioStep", jobRepository)
				.<GrupoLancamento, GrupoLancamento>chunk(1, transactionManager)
				.reader(demonstrativoOrcamentarioReader)
				.writer(demonstrativoOrcamentarioWriter)
				.listener(rodapeCallback)
				.build();
	}
}

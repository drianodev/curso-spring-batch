package br.com.drianodev.reader;

import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Configuration
public class ContadorReaderConfig {

    @Bean
    public IteratorItemReader<Integer> contadorReader() {
        List<Integer> numeros = IntStream.rangeClosed(1, 1000)
                .boxed()
                .collect(Collectors.toList());
        return new IteratorItemReader<Integer>(numeros.iterator());
    }
}

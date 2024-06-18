package br.com.drianodev.processor;

import br.com.drianodev.dominio.Cliente;
import org.springframework.batch.item.ItemProcessor;

public class ClienteProcessor implements ItemProcessor<Cliente, Cliente> {

  @Override
  public Cliente process(Cliente cliente) throws Exception {
    System.out.println(String.format("\nAplicando regras de negócio no cliente %s", cliente.getEmail()));
    return cliente;
  }
  
}

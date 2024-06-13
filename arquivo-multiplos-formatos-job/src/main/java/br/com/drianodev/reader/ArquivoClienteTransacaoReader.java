package br.com.drianodev.reader;

import br.com.drianodev.dominio.Cliente;
import br.com.drianodev.dominio.Transacao;
import org.springframework.batch.item.*;

import static java.util.Objects.isNull;

public class ArquivoClienteTransacaoReader implements ItemStreamReader<Cliente> {

    private Object objAtual;
    private ItemStreamReader<Object> delegate;

    public ArquivoClienteTransacaoReader(ItemStreamReader<Object> delegate) {
        this.delegate = delegate;
    }

    @Override
    public Cliente read() throws Exception {
        if (objAtual == null)
            objAtual = delegate.read();

        Cliente cliente = (Cliente) objAtual;
        objAtual = null;

        if (cliente != null) {
            while(peek() instanceof Transacao)
                cliente.getTransacoes().add((Transacao) objAtual);
        }
        return cliente;
    }

    private Object peek() throws Exception {
        objAtual = delegate.read();
        return objAtual;
    }

    @Override
    public void open(ExecutionContext executionContext) throws ItemStreamException {
        delegate.open(executionContext);
    }

    @Override
    public void update(ExecutionContext executionContext) throws ItemStreamException {
        delegate.update(executionContext);
    }

    @Override
    public void close() throws ItemStreamException {
        delegate.close();
    }
}

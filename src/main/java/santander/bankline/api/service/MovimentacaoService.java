package santander.bankline.api.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import santander.bankline.api.dto.NovaMovimentacao;
import santander.bankline.api.model.Correntista;
import santander.bankline.api.model.Movimentacao;
import santander.bankline.api.model.MovimentacaoTipo;
import santander.bankline.api.repository.CorrentistaRepository;
import santander.bankline.api.repository.MovimentacaoRepository;

@Service
public class MovimentacaoService {
	@Autowired
	private MovimentacaoRepository repository;
	@Autowired
	private CorrentistaRepository correntistaRepository;
	public void save(NovaMovimentacao novaMovimentacao) {
		Movimentacao movimentacao = new Movimentacao();
		 
		//operador ternario, parecido com um if
		Double valor = novaMovimentacao.getTipo() == MovimentacaoTipo.RECEITA ? novaMovimentacao.getValor() : novaMovimentacao.getValor() * -1;
		
		//Double valor=novaMovimentacao.getValor();
		//if(novaMovimentacao.getTipo()
		   // valor=valor
		 // MovimentacaoTipo.DESPESA) == -1;
		
		movimentacao.setDataHora(LocalDateTime.now());
		movimentacao.setDescricao(novaMovimentacao.getDescricao());
		movimentacao.setIdConta(novaMovimentacao.getIdConta());
		movimentacao.setTipo(novaMovimentacao.getTipo());
		movimentacao.setValor(valor);
		
		//procura o correntista pelo id da conta se nao achar volta null
		Correntista correntista = correntistaRepository.findById(novaMovimentacao.getIdConta()).orElse(null);
		// um iff para caso nao retorne null nos mostrar o saldo com base no id da conta
		if(correntista != null) {
			correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valor);
			correntistaRepository.save(correntista);
		}
		repository.save(movimentacao);
	}
}

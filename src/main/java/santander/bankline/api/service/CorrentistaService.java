package santander.bankline.api.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import santander.bankline.api.dto.NovoCorrentista;
import santander.bankline.api.model.Conta;
import santander.bankline.api.model.Correntista;
import santander.bankline.api.repository.CorrentistaRepository;

@Service
public class CorrentistaService {
	@Autowired
	private CorrentistaRepository repository;
	public void save(NovoCorrentista novoCorrentista) {
		Correntista correntista = new Correntista();
		correntista.setCpf(novoCorrentista.getCpf());
		correntista.setNome(novoCorrentista.getNome());
		
		Conta conta = new Conta();
		conta.setSaldo(0.0);
		conta.setNumero(new Date().getTime());
		
		correntista.setConta(conta);
		repository.save(correntista);
		
	}
}

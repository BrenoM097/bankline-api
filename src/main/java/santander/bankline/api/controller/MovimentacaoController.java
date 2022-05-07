package santander.bankline.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import santander.bankline.api.dto.NovaMovimentacao;
import santander.bankline.api.dto.NovoCorrentista;
import santander.bankline.api.model.Correntista;
import santander.bankline.api.model.Movimentacao;
import santander.bankline.api.repository.CorrentistaRepository;
import santander.bankline.api.repository.MovimentacaoRepository;
import santander.bankline.api.service.CorrentistaService;
import santander.bankline.api.service.MovimentacaoService;
@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {
	@Autowired
	private MovimentacaoRepository repository;
	
	@Autowired
	private MovimentacaoService service;
	
	@GetMapping
	public List<Movimentacao>findAll(){
		return repository.findAll();
		
	}
	@PostMapping
	public void save(@RequestBody NovaMovimentacao movimentacao) {
		service.save(movimentacao);
		
	}
}

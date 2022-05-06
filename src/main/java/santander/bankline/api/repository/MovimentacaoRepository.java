package santander.bankline.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import santander.bankline.api.model.Movimentacao;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer>{

}

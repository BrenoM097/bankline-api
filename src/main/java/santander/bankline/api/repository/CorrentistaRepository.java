package santander.bankline.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import santander.bankline.api.model.Correntista;

public interface CorrentistaRepository extends JpaRepository<Correntista, Integer> {

}

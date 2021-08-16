package com.geraldo.BD.repositories;

import com.geraldo.BD.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<Departamento,Long> {

    Departamento findFirstByOrderByCadastroAsc();

}

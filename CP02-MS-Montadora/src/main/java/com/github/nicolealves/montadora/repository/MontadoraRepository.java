package com.github.nicolealves.montadora.repository;

import com.github.nicolealves.montadora.model.Montadora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MontadoraRepository extends JpaRepository<Montadora, Long> {
}

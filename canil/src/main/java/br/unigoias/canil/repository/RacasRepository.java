package br.unigoias.canil.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import br.unigoias.canil.model.Racas;

//DAO
@Repository
public interface RacasRepository extends JpaRepository<Racas,Integer>{
	
}

package br.unigoias.canil.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import br.unigoias.canil.model.*;


//DAO
@Repository
public interface CaesRepository extends JpaRepository<Caes,Integer> {
	
}

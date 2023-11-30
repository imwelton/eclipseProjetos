package br.unigoias.canil.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.unigoias.canil.model.Racas;
import br.unigoias.canil.repository.RacasRepository;


@Service
public class RacasService {

	@Autowired
	private RacasRepository racaRepository;
	
	public List<Racas> ListarRacas(){
		return racaRepository.findAll();
	}
	
	public Racas SalvarRacas(Racas raca) {
		return racaRepository.save(raca);
	}
	
	public ResponseEntity<Racas> ListarRacaPorID(int id) {
		Optional<Racas> raca = racaRepository.findById(id);
		if(raca.isPresent()) {
			return ResponseEntity.ok(raca.get());
		}else {
			return ResponseEntity.notFound().build();	
		}
	}
	
	public ResponseEntity<Racas> DeletarPorID(int id){
		if(racaRepository.existsById(id)) {
			racaRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	public ResponseEntity<Racas> AtualizarRaca(int id,Racas novaRaca){
		if(racaRepository.existsById(id)) {
			novaRaca.setId(id);
			return ResponseEntity.ok(racaRepository.save(novaRaca));
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}

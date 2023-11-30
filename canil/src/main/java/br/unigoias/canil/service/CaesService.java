package br.unigoias.canil.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.unigoias.canil.model.Caes;
import br.unigoias.canil.repository.CaesRepository;

@Service
public class CaesService {
	@Autowired
	private CaesRepository caesRepository;

	public List<Caes> ListarCaes() {
		return caesRepository.findAll();
	}
	
	public Caes SalvarCaes(Caes cao) {
		return caesRepository.save(cao);
	}
	
	public ResponseEntity<Caes> ListarCaoPorID(int id){
		Optional<Caes>cao = caesRepository.findById(id);
		if(cao.isPresent()) {
			return ResponseEntity.ok(cao.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	public ResponseEntity<Caes> DeletarPorID(int id){
		if(caesRepository.existsById(id)) {
			caesRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	public ResponseEntity<Caes> AtualizarCao(int id,Caes novoCao){
		if(caesRepository.existsById(id)) {
			novoCao.setId(id);
			return ResponseEntity.ok(caesRepository.save(novoCao));
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}

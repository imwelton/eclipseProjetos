package br.unigoias.canil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unigoias.canil.model.Caes;
import br.unigoias.canil.service.CaesService;


@RestController
@RequestMapping("/caes")

public class CaesController {
	@Autowired
	private CaesService caesService;
	
	@GetMapping("/listarCaes")
	public List<Caes> ListarCaes(){
		return caesService.ListarCaes();
	}
	
	@PostMapping("/salvarCaes")
	public Caes SalvarCaes(@RequestBody Caes cao) {
		return caesService.SalvarCaes(cao);
	}
	
	@GetMapping("/listarCaes/{id}")
	public ResponseEntity<Caes> ListarCaoPorID(@PathVariable int id){
		return caesService.ListarCaoPorID(id);
	}
	
	@DeleteMapping("/deletarCaes/{id}")
	public ResponseEntity<Caes> DeletarPorID(@PathVariable int id){
		return caesService.DeletarPorID(id);
	}
	
	@PutMapping("/atualizarCao/{id}")
	public ResponseEntity<Caes> AtualizarCao(@PathVariable int id,@RequestBody Caes novoCao){
		return caesService.AtualizarCao(id, novoCao);
	}
}

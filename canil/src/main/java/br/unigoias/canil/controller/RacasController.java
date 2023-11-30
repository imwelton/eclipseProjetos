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

import br.unigoias.canil.model.Racas;
import br.unigoias.canil.service.RacasService;

@RestController
@RequestMapping("/racas")

public class RacasController {
	
	@Autowired
	private RacasService racasService;
	
	@GetMapping("/listarRacas")
	public List<Racas> ListarRacas() {
		return racasService.ListarRacas();
	}
	
	@PostMapping("/salvarRacas")
	public Racas SalvarRacas(@RequestBody Racas raca) {
		return racasService.SalvarRacas(raca);
	}	
	
	@GetMapping("/listarRacas/{id}")
	public ResponseEntity<Racas> ListarRacasPorID(@PathVariable int id){
		return racasService.ListarRacaPorID(id);
	}
	
	@DeleteMapping("/deletarRacas/{id}")
	public ResponseEntity<Racas> DeletarPorID(@PathVariable int id){
		return racasService.DeletarPorID(id);
	}
	
	@PutMapping("/atualizarRaca/{id}")
	public ResponseEntity<Racas> AtualizarRaca(@PathVariable int id,@RequestBody Racas novaRaca){
		return racasService.AtualizarRaca(id, novaRaca);
	}
}

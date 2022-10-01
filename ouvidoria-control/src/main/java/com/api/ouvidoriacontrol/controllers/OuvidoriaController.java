package com.api.ouvidoriacontrol.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.ouvidoriacontrol.dtos.OuvidoriaDTO;
import com.api.ouvidoriacontrol.models.OuvidoriaModel;
import com.api.ouvidoriacontrol.services.OuvidoriaService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/ouvidoria")

public class OuvidoriaController {
	
	final OuvidoriaService ouvidoriaService;

	public OuvidoriaController(OuvidoriaService ouvidoriaService) {
		this.ouvidoriaService = ouvidoriaService;
	}
	
	@PostMapping
	public ResponseEntity<Object> saveOuvidoria(@RequestBody @Valid OuvidoriaDTO ouvidoriaDTO){
	var ouvidoriaModel = new OuvidoriaModel();
	BeanUtils.copyProperties(ouvidoriaDTO, ouvidoriaModel);
	ouvidoriaModel.setDataRegistro(LocalDateTime.now(ZoneId.of("UTC")));
	return ResponseEntity.status(HttpStatus.CREATED).body(ouvidoriaService.save(ouvidoriaModel));
		}
	@GetMapping
	public ResponseEntity<List<OuvidoriaModel>> getAllOuvidoria(){
		return ResponseEntity.status(HttpStatus.OK).body(ouvidoriaService.findAll());
	} 
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneOuvidoria(@PathVariable(value = "id") UUID id){
		Optional<OuvidoriaModel> ouvidoriaModelOptional = ouvidoriaService.findById(id);
		if(!ouvidoriaModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ouvidoria não encontrada.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(ouvidoriaModelOptional.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteOuvidoria(@PathVariable(value = "id") UUID id){
		Optional<OuvidoriaModel> ouvidoriaModelOptional = ouvidoriaService.findById(id);
		if(!ouvidoriaModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ouvidoria não encontrada.");
		}
		ouvidoriaService.delete(ouvidoriaModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Ouvidoria deletada com sucesso.");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateOuvidoria(@PathVariable(value = "id") UUID id, @RequestBody @Valid OuvidoriaDTO ouvidoriaDTO){
		Optional<OuvidoriaModel> ouvidoriaModelOptional = ouvidoriaService.findById(id);
		if(!ouvidoriaModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ouvidoria não encontrada.");
		}
		var ouvidoriaModel  = ouvidoriaModelOptional.get();
		ouvidoriaModel.setUsuario(ouvidoriaDTO.getUsuario());
		ouvidoriaModel.setCpf(ouvidoriaDTO.getCpf());
		ouvidoriaModel.setTipo(ouvidoriaDTO.getTipo());
		ouvidoriaModel.setDescricao(ouvidoriaDTO.getDescricao());
		ouvidoriaModel.setNomeCurso(ouvidoriaDTO.getNomeCurso());
		return ResponseEntity.status(HttpStatus.OK).body(ouvidoriaService.save(ouvidoriaModel));
	}
} 


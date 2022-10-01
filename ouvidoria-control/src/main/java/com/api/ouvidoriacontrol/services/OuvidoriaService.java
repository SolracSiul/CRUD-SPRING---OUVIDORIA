package com.api.ouvidoriacontrol.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.ouvidoriacontrol.models.OuvidoriaModel;
import com.api.ouvidoriacontrol.repositories.OuvidoriaRepository;

//Nessa parte é implementado as regras de negócio
//Elas serão chamadas no Controller ex: no controller, faça: if(ouvidopriaService(nome da função){execute x}
@Service
public class OuvidoriaService {

	@Autowired
	OuvidoriaRepository ouvidoriaRepository;
	
	@Transactional
	public OuvidoriaModel save(OuvidoriaModel ouvidoriaModel) {
		return ouvidoriaRepository.save(ouvidoriaModel);
	}

	public List<OuvidoriaModel> findAll() {
		return ouvidoriaRepository.findAll();
	}

	public Optional<OuvidoriaModel> findById(UUID id) {
		return ouvidoriaRepository.findById(id);
	}

	@Transactional
	public void delete(OuvidoriaModel ouvidoriaModel) {
		 ouvidoriaRepository.delete(ouvidoriaModel);
		
	}
	
}

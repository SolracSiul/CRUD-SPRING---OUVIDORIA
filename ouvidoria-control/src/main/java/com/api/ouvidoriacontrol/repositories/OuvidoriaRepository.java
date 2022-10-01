package com.api.ouvidoriacontrol.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.ouvidoriacontrol.models.OuvidoriaModel;

@Repository
public interface OuvidoriaRepository extends JpaRepository<OuvidoriaModel, UUID>{
		
	
	
}

/**
 * 
 */
package com.complejoeducaciona.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.complejoeducaciona.models.Apoderado;
import com.complejoeducaciona.repository.IApoderadoRepository;


/**
 * @author Pablo
 *
 */
@Service
public class ApoderadoService {
	@Autowired
	private IApoderadoRepository iApoderadoRepository;
	
	public Apoderado create(Apoderado apoderado) {
		// TODO Auto-generated method stub
		return iApoderadoRepository.save(apoderado);

	}
	
	public Apoderado update(Apoderado apoderado) {
		return iApoderadoRepository.save(apoderado);
	}
	
	public List<Apoderado> getAllApoderado(){
		return iApoderadoRepository.findAll();
	}
	
	public void deleteApoderado( Apoderado apoderado) {
		// TODO Auto-generated method stub
		iApoderadoRepository.delete(apoderado);
	}
	
	public Optional<Apoderado> findById(Long id_apoderado) {
		return iApoderadoRepository.findById(id_apoderado);
	}
}

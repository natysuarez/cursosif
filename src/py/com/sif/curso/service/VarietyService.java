package py.com.sif.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.sif.curso.dto.VarietyDTO;
import py.com.sif.curso.respository.VarietyRepository;

@Service
public class VarietyService {

    @Autowired
    private VarietyRepository varietyRepository; 
    
    
    public VarietyService() {
        super();
    }
    
    
    
    public List<VarietyDTO> findAll() {
        return this.varietyRepository.findAll();
    }

    public VarietyDTO findById(final Integer id) {
        return this.varietyRepository.findById(id);
    }
	
}

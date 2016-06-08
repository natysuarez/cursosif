package py.com.sif.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.sif.curso.dto.SeedStarterDTO;
import py.com.sif.curso.respository.SeedStarterRepository;

@Service
public class SeedStarterService {
    @Autowired
    private SeedStarterRepository seedstarterRepository; 
    
    
    public SeedStarterService() {
        super();
    }
    
    
    
    public List<SeedStarterDTO> findAll() {
        return this.seedstarterRepository.findAll();
    }

    public void add(final SeedStarterDTO seedStarter) {
        this.seedstarterRepository.add(seedStarter);
    }

}

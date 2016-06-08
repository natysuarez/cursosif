package py.com.sif.curso.respository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import py.com.sif.curso.dto.SeedStarterDTO;

@Repository
public class SeedStarterRepository {
    private final List<SeedStarterDTO> seedStarters = new ArrayList<SeedStarterDTO>();
    
    
    
    public SeedStarterRepository() {
        super();
    }
    
    
    
    public List<SeedStarterDTO> findAll() {
        return new ArrayList<SeedStarterDTO>(this.seedStarters);
    }

    
    public void add(final SeedStarterDTO seedStarter) {
        this.seedStarters.add(seedStarter);
    }

}

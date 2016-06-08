package py.com.sif.curso.respository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import py.com.sif.curso.dto.VarietyDTO;

@Repository
public class VarietyRepository {

    private final Map<Integer,VarietyDTO> varietiesById;
    
    
    
    public VarietyRepository() {
        
        super();
        
        this.varietiesById = new LinkedHashMap<Integer,VarietyDTO>();
        
        final VarietyDTO var1 = new VarietyDTO();
        var1.setId(Integer.valueOf(1));
        var1.setName("Thymus vulgaris");
        this.varietiesById.put(var1.getId(), var1);
        
        final VarietyDTO var2 = new VarietyDTO();
        var2.setId(Integer.valueOf(2));
        var2.setName("Thymus x citriodorus");
        this.varietiesById.put(var2.getId(), var2);
        
        final VarietyDTO var3 = new VarietyDTO();
        var3.setId(Integer.valueOf(3));
        var3.setName("Thymus herba-barona");
        this.varietiesById.put(var3.getId(), var3);
        
        final VarietyDTO var4 = new VarietyDTO();
        var4.setId(Integer.valueOf(4));
        var4.setName("Thymus pseudolaginosus");
        this.varietiesById.put(var4.getId(), var4);
        
        final VarietyDTO var5 = new VarietyDTO();
        var5.setId(Integer.valueOf(5));
        var5.setName("Thymus serpyllum");
        this.varietiesById.put(var5.getId(), var5);
        
    }
    
    
    
    public List<VarietyDTO> findAll() {
        return new ArrayList<VarietyDTO>(this.varietiesById.values());
    }
    
    public VarietyDTO findById(final Integer id) {
        return this.varietiesById.get(id);
    }	
}

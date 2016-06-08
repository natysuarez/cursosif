package py.com.sif.curso.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import py.com.sif.curso.service.SeedStarterService;
import py.com.sif.curso.service.VarietyService;
import py.com.sif.curso.constantes.Type;
import py.com.sif.curso.dto.RowDTO;
import py.com.sif.curso.dto.SeedStarterDTO;
import py.com.sif.curso.dto.VarietyDTO;
import py.com.sif.curso.constantes.Feature;

@Controller
@Scope("session")
@SessionAttributes("seedStarter")
@RequestMapping("/main")
public class MainController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -345297429491522653L;

	private final static String CONTROLLER_OBJECT_NAME = "seedStarter";
	private final static String PAGNAME = "ejemplo/main";
	
    @Autowired
    private VarietyService varietyService;
    
    @Autowired
    private SeedStarterService seedStarterService;
    
    private SeedStarterDTO seedStarter;
    
    public MainController() {
    	this.seedStarter = new SeedStarterDTO();
    }

    
    @ModelAttribute(CONTROLLER_OBJECT_NAME)
    public SeedStarterDTO getSeedStarter() {
		return seedStarter;
	}


	public void setSeedStarter(SeedStarterDTO seedStarter) {
		this.seedStarter = seedStarter;
	}



	@ModelAttribute("allTypes")
    public List<Type> populateTypes() {
        return Arrays.asList(Type.ALL);
    }
    
    @ModelAttribute("allFeatures")
    public List<Feature> populateFeatures() {
        return Arrays.asList(Feature.ALL);
    }
    
    @ModelAttribute("allVarieties")
    public List<VarietyDTO> populateVarieties() {
        return this.varietyService.findAll();
    }
    
    @ModelAttribute("allSeedStarters")
    public List<SeedStarterDTO> populateSeedStarters() {
        return this.seedStarterService.findAll();
    }
    
    @RequestMapping()
    public String home(final SeedStarterDTO seedStarter) {
    	seedStarter.setDatePlanted(Calendar.getInstance().getTime());
        return PAGNAME;
    }   
    
    
    @RequestMapping(params={"save"})
    public String saveSeedstarter(@ModelAttribute(CONTROLLER_OBJECT_NAME) SeedStarterDTO seedStarter, final BindingResult bindingResult, final ModelMap model) {
        if (bindingResult.hasErrors()) {
            return PAGNAME;
        }
        this.seedStarterService.add(seedStarter);
        model.clear();
        return "redirect:/main";
    }
    

    
    @RequestMapping(params={"addRow"})
    public String addRow(@ModelAttribute(CONTROLLER_OBJECT_NAME) SeedStarterDTO seedStarter, final BindingResult bindingResult) {
        seedStarter.getRows().add(new RowDTO());
        return PAGNAME;
    }
    
    
    @RequestMapping( params={"removeRow"})
    public String removeRow(@ModelAttribute(CONTROLLER_OBJECT_NAME) SeedStarterDTO seedStarter, final BindingResult bindingResult, final HttpServletRequest req) {
        final Integer rowId = Integer.valueOf(req.getParameter("removeRow"));
        seedStarter.getRows().remove(rowId.intValue());
        return PAGNAME;
    }
	
}

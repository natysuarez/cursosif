package py.com.sif.curso.controller.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import py.com.sif.curso.dto.VarietyDTO;
import py.com.sif.curso.service.VarietyService;

public class VarietyFormatter implements Formatter<VarietyDTO>{
	
    @Autowired
    private VarietyService varietyService;


    public VarietyFormatter() {
        super();
    }

    public VarietyDTO parse(final String text, final Locale locale) throws ParseException {
        final Integer varietyId = Integer.valueOf(text);
        return this.varietyService.findById(varietyId);
    }


    public String print(final VarietyDTO object, final Locale locale) {
        return (object != null ? object.getId().toString() : "");
    }


}

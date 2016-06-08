package py.com.sif.curso.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import py.com.sif.curso.session.SystemInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

@Controller
@Scope("session")
public class HomeController implements Serializable {

	private static final long serialVersionUID = 3901390503767512990L;

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@Autowired
	private SystemInfo systemInfo;

	public HomeController() {
		loadObjects();
	}

	private void loadObjects() {
		
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePage(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("\n==============\nWelcome!\n==============\n");
		return "home";
	}

	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String errorPage(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("\n==============\nError!\n==============\n");
		return "error";
	}

}

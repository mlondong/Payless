package demo.Payless.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import demo.Payless.model.Trader;
import demo.Payless.services.TraderService;;

@Controller
@RequestMapping(path="/demo")
public class HomeController {


	@Autowired(required=true)
	private TraderService traderservice;

	@GetMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody String addNewTrader (@RequestParam("name") String name , @RequestParam("password") String pass, @RequestParam("cuit") int cuit) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		traderservice.create(new Trader(name, pass, cuit,null));
		
		return "Saved";
	}


	
	
	
	
}

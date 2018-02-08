package com.javafasci.examples.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javafasci.examples.model.City;
import com.javafasci.examples.model.CompanyConfig;
import com.javafasci.examples.service.CityService;

@Controller
public class MainController {

	private static final Logger LOG = LogManager.getLogger(MainController.class);
	
	@Autowired
	private CityService cityService;
	
    @RequestMapping(value="/",method = RequestMethod.GET)
    public String homepage(){
        return "index";
    }
    
    
    @RequestMapping(value="/getAllUsers",method = RequestMethod.GET)
    @ResponseBody
    public List<String> getAllUsers(){
        List<String> list = new ArrayList<String>();
        return list;
    }
    
    @RequestMapping(value="/getCompanies",method = RequestMethod.GET)
    @ResponseBody
    public List<String> getCompanies(){
    	LOG.info("In getCompanies");
    	List<String> list = new ArrayList<String>();
        list.add("Keybank");
        list.add("Nationwide");
        list.add("Liberty");
        return list;
    }
    
    @RequestMapping(value="/getCompaniesByProduct",method = RequestMethod.GET)
    @ResponseBody
    public List<String> getCompaniesByProduct(@RequestParam("product") String product){
    	LOG.info("In getCompaniesByProduct: " + product);
    	List<String> list = new ArrayList<String>();
        if("ABC".equals(product)){
			list.add("Keybank");
		    list.add("Nationwide");
		    list.add("Liberty");
        }else{
        	for(int i=1; i<=5000 ; i++){
        		list.add("Futures"+i);
        	}
        }
        return list;
    }
    
    @RequestMapping(value="/getConfigByCompany",method = RequestMethod.GET)
    @ResponseBody
    public List<CompanyConfig> getConfigByCompany(@RequestParam("company") String company){
    	LOG.info("In getConfigByCompany: " + company);
    	List<CompanyConfig> configs = new ArrayList<CompanyConfig>();
    	if("Keybank".equals(company)){
    		configs.add(new CompanyConfig(1, "CompanyA", 200));
    		configs.add(new CompanyConfig(2, "CompanyB", 500));
    	}
    	return configs;
    }
    
    @RequestMapping("/getAllCities")
	@ResponseBody
	public List<City> getAllCities() {
		LOG.info("In getAllCities of Controller");
		return cityService.getAllCities();
	}
}



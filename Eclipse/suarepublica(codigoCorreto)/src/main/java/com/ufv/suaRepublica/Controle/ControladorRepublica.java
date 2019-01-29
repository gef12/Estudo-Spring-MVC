package com.ufv.suaRepublica.Controle;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ufv.suaRepublica.Modelo.Entidade.*;
import com.ufv.suaRepublica.Modelo.Servico.*;

@Controller
@ResponseBody
public class ControladorRepublica {
	@Autowired
	ServicoUsuario userService;
	
	@Autowired
	ServicoRepublica republicaService;
	
	@Autowired
	ServicoVaga vagaService;
	
	@RequestMapping(value = { "/cadastroRepublica" }, method = RequestMethod.GET)
	public ModelAndView cadastrarRepublica() {
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("republica",new Republica());
	    modelAndView.addObject("generos", Genero.values());
	    modelAndView.setViewName("cadastroRepublica");
		return modelAndView;
	}
	
	@RequestMapping(value = {"/cadastroRepublica"}, method = RequestMethod.POST)
	public ModelAndView cadastrarRepublica(@Valid Republica republica, BindingResult bindingResult) {
	
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		user user = userService.findUserByEmail(auth.getName());
		
		ModelAndView modelAndView = new ModelAndView();
		if(republica.getBairro().isEmpty()  && republica.getComplemento().isEmpty() && republica.getEstado().isEmpty() && republica.getLogradouro().isEmpty() && republica.getMunicipio().isEmpty()) {
			bindingResult.rejectValue("endereco","error.republica", "*Favor preencher os campos referentes aos endereços");
		} 
		
		if(republica.getTelefoneAlternativo1().isEmpty() && republica.getTelefoneAlternativo2().isEmpty() && republica.getTelefoneWhatsapp().isEmpty()) {
			bindingResult.rejectValue("telefone","error.republica", "*Favor preencher pelo menos um dos telefones");
		}
		
		if(bindingResult.hasErrors()) {
			modelAndView.addObject("generos", Genero.values());
			modelAndView.setViewName("cadastroRepublica");
		}
		
		else {
			republica.setUser(user);
			user.getRepublicas().add(republica);
			userService.mergeUser(user);
			modelAndView.setViewName("SucessoRepublicaCadastrada");
		}
		
		return modelAndView; 
	}
	
	@RequestMapping(value = { "/gerenciarRepublica" }, method = RequestMethod.GET)
	public ModelAndView gerenciarRepublica() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		user user = userService.findUserByEmail(auth.getName());
		
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("Republicas",user.getRepublicas());
	    //System.out.println(user.getRepublicas().get(0).getId());
	
	    modelAndView.setViewName("gerenciarRepublica");
		return modelAndView;
	}
	
	@RequestMapping(value = { "/republica/{id}/editar" }, method = RequestMethod.GET)
	public ModelAndView editarRepublica(@PathVariable int id) {
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("republica",republicaService.findRepublicaById(id));
	    modelAndView.addObject("generos", Genero.values());
	    modelAndView.setViewName("editar");
		return modelAndView;
	}
	
	@RequestMapping(value = {"/republica/{id}/editar"}, method = RequestMethod.POST)
	public ModelAndView editarRepublica(@Valid Republica republica, BindingResult bindingResult) {
	
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		user user = userService.findUserByEmail(auth.getName());
		
		ModelAndView modelAndView = new ModelAndView();
		if(republica.getTelefoneAlternativo1().isEmpty() && republica.getTelefoneAlternativo2().isEmpty() && republica.getTelefoneWhatsapp().isEmpty()) {
			bindingResult.rejectValue("telefone","error.republica", "*Favor preencher pelo menos um dos telefones");
		}
		if(bindingResult.hasErrors()) {
			modelAndView.addObject("generos", Genero.values());
			modelAndView.setViewName("editar");
		}
		
		else {
			
			
			republicaService.editRepublica(republica);
			modelAndView.setViewName("SucessoRepublicaEditada");
		}
		
		return modelAndView; 
	}
	
	
	
	@RequestMapping(value = {"/adicionarVaga"}, method = RequestMethod.GET)
	public ModelAndView adicinarVaga() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("vaga",new Vaga());
	    modelAndView.addObject("tipodivisao",TipoDivisao.values()); 
	    modelAndView.setViewName("adicionarVaga");
		return modelAndView;
	}
	
	@RequestMapping(value = {"/adicionarVaga"}, method = RequestMethod.POST)
	public ModelAndView adicinarVaga(@Valid Vaga vaga, BindingResult bindingResult) {
	
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(bindingResult.hasErrors()) {
			modelAndView.addObject("tipodivisao",TipoDivisao.values()); 
			modelAndView.setViewName("adicionarVaga");
		}
		
		else {
			vagaService.saveVaga(vaga);
			modelAndView.setViewName("SucessoVagaCadastrada");
		}
		
		return modelAndView; 
	}
	
	
	@RequestMapping(value = { "/gerenciarVagas" }, method = RequestMethod.GET)
	public ModelAndView gerenciarVagas() {
		
		
		ModelAndView modelAndView = new ModelAndView();
		//modelAndView.addObject("Vagas", vagas.getVagas());
	    modelAndView.setViewName("GerenciarVagas");
		return modelAndView;
	}
	
}

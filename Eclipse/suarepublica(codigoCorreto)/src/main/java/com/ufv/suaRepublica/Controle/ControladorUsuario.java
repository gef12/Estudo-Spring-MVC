package com.ufv.suaRepublica.Controle;

import javax.validation.Valid;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ufv.suaRepublica.Modelo.Entidade.*;
import com.ufv.suaRepublica.Modelo.Repositorio.EventosRepository;
import com.ufv.suaRepublica.Modelo.Servico.*;

@Controller
public class ControladorUsuario {
	
	@Autowired
	ServicoUsuario userService;
	
	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public ModelAndView login(RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");

		return modelAndView;
	}
	
	@RequestMapping(value = { "/","/pesquisarVagaNaoAutenticado" }, method = RequestMethod.GET)
	public ModelAndView pesquisarNaoAutenticado(RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("PesquisarVaga");

		return modelAndView;
	}

	@RequestMapping(value = { "/registro" }, method = RequestMethod.GET)
	public ModelAndView cadastroUsuario() {
		user user = new user();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("user",user);
		
		modelAndView.addObject("sexos",Sexo.values());
		modelAndView.setViewName("cadastroUsuario");

		return modelAndView;
	}
	
	@RequestMapping(value = "/registro", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid user user,  BindingResult bindingResult, String confirmarSenha, String confirmarEmail, RedirectAttributes redirectAttributes) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		user userExists = userService.findUserByEmail(user.getEmail());

		if (userExists != null) {
			bindingResult.rejectValue("email", "error.user",
					"*Já existe um usuário com esse email");
		}
		
		if (!user.getSenha().equals(confirmarSenha)) {
			bindingResult.rejectValue("senha", "error.user", "*As senhas não conferem");
		}
		
		if (!user.getEmail().equals(confirmarEmail)) {
			bindingResult.rejectValue("email", "error.user", "*Os emails não conferem");
		}
		
		
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("sexos",Sexo.values());
			System.out.println(user.getEmail());
			System.out.println(user.getDataNascimento());
			System.out.println(user.getSenha());
			System.out.println(user.getNome());
			System.out.println(user.getSexo());
			modelAndView.setViewName("cadastroUsuario");
			System.out.println("Erro");
		} else {
			//user.setConfirmacaoSenha(""); // Não precisa salvar o pass confirmado
			userService.saveUser(user);
//			modelAndView.addObject("successMessage", "Usuario foi registrado com sucesso!");
//			modelAndView.addObject("user", new User());
			redirectAttributes.addFlashAttribute("MensagemSucessoCadastro", "Usuário cadastrado com sucesso");
			modelAndView.setViewName("redirect:/login");
			System.out.println("Cadastrou");
		}
		return modelAndView;
	}
	
	
	
	
	

	@RequestMapping(value = { "/recuperarSenha" }, method = RequestMethod.GET)
	public ModelAndView recuperarSenha() {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("RecuperarSenha");
		
		
		return modelAndView;
	}
	
	

	@RequestMapping(value = { "/recuperarSenha" }, method = RequestMethod.POST)
	@Transactional
	public ModelAndView recuperarSenhaPost(String email, RedirectAttributes redirectAttributes) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		
		if(userService.recuperarSenha(email)) {
			redirectAttributes.addFlashAttribute("MensagemSucesso", "Senha recuperada com sucesso, verifique sua caixa de email");
			modelAndView.setViewName("redirect:/login");
		}else {
			modelAndView.addObject("mensagem","Não foi possível recuperar a senha, verifique o email informado"); 
			modelAndView.setViewName("RecuperarSenha");
		}
		

		return modelAndView;
	}
	
	
}

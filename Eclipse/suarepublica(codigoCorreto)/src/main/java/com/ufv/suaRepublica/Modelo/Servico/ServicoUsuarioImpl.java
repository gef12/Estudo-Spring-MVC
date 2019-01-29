package com.ufv.suaRepublica.Modelo.Servico;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

import javax.mail.MessagingException;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yaml.snakeyaml.emitter.EmitterException;

import com.ufv.suaRepublica.Modelo.Entidade.Role;
import com.ufv.suaRepublica.Modelo.Entidade.user;
import com.ufv.suaRepublica.Modelo.Repositorio.RepositorioUsuario;
import com.ufv.suaRepublica.Modelo.Repositorio.RoleRepository;



@Service
public class ServicoUsuarioImpl implements ServicoUsuario, UserDetailsService{

	@Autowired
	private RepositorioUsuario userRepository;
	@Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Autowired
    private EntityManager entityManager;
    
    @Autowired
	private SmtpMailSender smtpMailSender;
	
    
	@Override
	public user findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	@Override
	public user findUserByUsername(String name) {
		return userRepository.findByNome(name);
	}

	@Override
	public void saveUser(user user) {
		user.setSenha(bCryptPasswordEncoder.encode(user.getSenha()));
		
		 Role userRole = roleRepository.findByRole("ADMIN");
		 if(userRole==null)
		 {
			userRole = new Role();
			userRole.setRole("ADMIN");
			userRole.setId(0);
		 }
        
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userRepository.save(user);
	}
	
	@Override
	@Transactional
	public void editUser(user user) {
		user.setSenha(bCryptPasswordEncoder.encode(user.getSenha()));
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		entityManager.merge(user);
	}

	@Override
	@Transactional
	public void mergeUser(user user) {
		entityManager.merge(user);
	}

	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		user user = userRepository.findByEmail(username);
		
		if(user == null){
			System.out.println("login errado");
			throw new UsernameNotFoundException("Usuario não encontrado!");
		}
		System.out.println("login ok");
		System.out.println(user.getSenha());
		return user;
	}
	@Override
	public boolean recuperarSenha(String email)  {
		 int senha;
		 Random gerador = new Random();
		 user usuario= findUserByEmail(email);
		 System.out.println(email);
		 if(usuario== null) {
			 return false;
		 }
		 senha= gerador.nextInt(10000)+99999;
		 usuario.setSenha(senha+"");
		 
		try {
			smtpMailSender.send(email, "Senha Provisória SuaRepública", "<html><body><p>Utilize esta senha provisória para acessar o SuaRepública:</p><br><b>"+senha+"</b><br><br><p>Equipe SuaRepública, UFV-Campus Florestal.</p></body></html>");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		editUser(usuario);
		
		
		return true;
		
	}
	
}


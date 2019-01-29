package com.ufv.suaRepublica.Modelo.Entidade;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Transient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;





@SuppressWarnings({ "deprecation", "serial" })
@Entity
@Table(name = "user")
public class user implements UserDetails{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int id;
    
	@NotEmpty(message = "*Por favor, informe seu nome")
    private String nome;
	
	@NotNull(message = "*Por favor, informe sua data de nascimento")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataNascimento;
	
	
	@NotNull(message = "*Por favor, informe seu sexo")
	
	//@Enumerated(EnumType.STRING)
    private Sexo sexo;
     
    
    @Column(name = "email")
	@Email(message = "*Por favor, informe um email válido")
	@NotEmpty(message = "*Por favor, informe um email")
	private String email;
	
	@Column(name = "senha")
	@Length(min = 5, message = "*Sua senha deve possuir ao menos 5 caracteres")
	@NotEmpty(message = "*Por favor forneça a sua senha")
	@Transient
	private String senha;
	
	@Column(name = "cofirmacaoSenha")
	@Transient
	private String confirmacaoSenha;
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
//	@JoinColumn(name="user_id")
	private List<Republica> republicas;

	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;
	
    public user(){
        
    }
    
    public user (String nome, Date dataNascimento, String email, 
            String senha, Sexo sexo ) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.senha = senha;
        this.sexo = sexo;
    }
    
    

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getConfirmacaoSenha() {
		return confirmacaoSenha;
	}

	public void setConfirmacaoSenha(String confirmacaoSenha) {
		this.confirmacaoSenha = confirmacaoSenha;
	}

	public List<Republica> getRepublicas() {
		return republicas;
	}

	public void setRepublicas(List<Republica> republicas) {
		this.republicas = republicas;
	}



	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }

    public String getSenha() {
        return this.senha;
    }

    public Date getDataNascimento() { 
        return dataNascimento; 
    }

    public Sexo getSexo() { 
        return sexo; 
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setDataNascimento(Date dataNascimento) { 
        this.dataNascimento = dataNascimento; 
    }

    public void setSexo(Sexo sexo) {
         this.sexo = sexo; 
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return senha;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
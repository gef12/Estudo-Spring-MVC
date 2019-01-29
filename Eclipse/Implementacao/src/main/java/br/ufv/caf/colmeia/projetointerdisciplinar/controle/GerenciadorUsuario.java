package br.ufv.caf.colmeia.projetointerdisciplinar.controle;

import br.ufv.caf.colmeia.projetointerdisciplinar.DAO.DaoUsuario;
import br.ufv.caf.colmeia.projetointerdisciplinar.entidades.Usuario;
import java.util.Random;

public class GerenciadorUsuario {

    private DaoUsuario daoUsuario;

    public GerenciadorUsuario() {
        daoUsuario = new DaoUsuario();

    }

    public int adicionarUsuario(Usuario usuario) {
        Usuario buscaUsuario = daoUsuario.buscar(usuario.getEmail(), "email");
        if (buscaUsuario == null) {
            daoUsuario.salvar(usuario);
            return 1;
        } else {
            return 0;
        }

    }

    public String recuperarSenha(String email) {
        Random rand = new Random();
        char[] chaveRandomica = new char[10];
        String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"; //Posiveis caracteres para a chave
        String novaSenha;
        for (int i = 0; i < 10; i++) {
            chaveRandomica[i] = chars.charAt(rand.nextInt(chars.length()));
        }
        novaSenha = new String(chaveRandomica);
        
        return novaSenha;
    }

}

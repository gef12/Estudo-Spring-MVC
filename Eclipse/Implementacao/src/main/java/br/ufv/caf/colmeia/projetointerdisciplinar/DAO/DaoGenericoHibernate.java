/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.caf.colmeia.projetointerdisciplinar.DAO;

import br.ufv.caf.colmeia.projetointerdisciplinar.util.hibernate.HibernateUtil;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author danilo
 * @param <Entidade>
 */
public class DaoGenericoHibernate<Entidade> {

    private Class<Entidade> classe;

    public DaoGenericoHibernate() {
        this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public boolean salvar(Entidade entidade) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;

        try {
            transacao = sessao.beginTransaction();
            sessao.save(entidade);
            transacao.commit();
        } catch (RuntimeException erro) {
            if (transacao != null) {
                transacao.rollback();
                return false;
            }
            throw erro;
        } finally {
            sessao.close();
        }
        return true;
    }

    public List<Entidade> listar() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Entidade> resultado;
        try {
            Criteria consulta = sessao.createCriteria(classe);
            resultado = consulta.list();
            return resultado;
        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }

    public Entidade buscar(String chave, String atributo) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Entidade resultado = null;
        try {
            Criteria consulta = sessao.createCriteria(classe);
            consulta.add(Restrictions.eq(atributo, chave));
            resultado = (Entidade) consulta.uniqueResult();
            return resultado;
        } catch (RuntimeException erro) {
            System.out.println(erro);
            throw erro;
        } finally {
            sessao.close();
        }
    }

    public void excluir(Entidade entidade) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        try {
            transacao = sessao.beginTransaction();
            sessao.delete(entidade);
            transacao.commit();
        } catch (RuntimeException erro) {
            if (transacao != null) {
                transacao.rollback();
            }
            throw erro;
        } finally {
            sessao.close();
        }
    }

}

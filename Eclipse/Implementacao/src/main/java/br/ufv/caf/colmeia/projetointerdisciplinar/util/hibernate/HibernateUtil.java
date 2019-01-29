/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.caf.colmeia.projetointerdisciplinar.util.hibernate;



/**
 *
 * @author danilo
 */
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Mara
 */
public class HibernateUtil {
    // declare um objeto do tipo SessionFactory
    /* Mas pq o atributo é static?
     * declare como static para que vc possa chamar esse método mesmo sem ter uma instância
     * da classe HibernateUtil, conceito básico de encapsulamento.
     */
    // ops não esqueça de importar do pacote correto heim
    // deve ser o pacote org.hibernate

    private static SessionFactory sessionFactory;

    public HibernateUtil() {
    }
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                AnnotationConfiguration annotation = new AnnotationConfiguration();
                sessionFactory = annotation.configure().buildSessionFactory();

            } catch (Throwable ex) {
                System.out.println("Erro ao inicar o Hibernte " + ex);
                throw new ExceptionInInitializerError(ex);
            }
            // se td der certo retorna a sessao aberta
            return sessionFactory;
            
        } else {
            return sessionFactory;
        }
    }
}

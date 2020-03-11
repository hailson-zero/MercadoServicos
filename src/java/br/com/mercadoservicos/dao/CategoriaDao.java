

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.mercadoservicos.dao;

import br.com.mercadoservicos.domain.Categoria;
import br.com.mercadoservicos.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

public class CategoriaDao {
    
    public List<Categoria> listar(){
       Session session = HibernateUtil.getSessionFactory().getCurrentSession();
       session.beginTransaction();
       try{
           List<Categoria> categorias = session.createQuery("FROM Categoria order by descricao").list();
           session.getTransaction().commit();
           return categorias;
       }catch(Exception e){
           e.printStackTrace();
           session.getTransaction().rollback();
           return null;
       }
    }
    
    public Categoria consultar(Integer id){
       Session session = HibernateUtil.getSessionFactory().getCurrentSession();
       session.beginTransaction();
       try{
           Categoria categoria = (Categoria)session.createQuery("from Categoria where id = " + id).uniqueResult();
           session.beginTransaction().commit();
           return categoria;
       }catch(Exception e){
           e.printStackTrace();
           session.getTransaction().rollback();
           return null;
       }
    }
    
    public boolean inserir(Categoria categoria){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            session.save(categoria);
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            session.getTransaction().rollback();
            return false;
        }
    }
    

    public boolean update(Categoria categoria){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            session.update(categoria);
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            session.getTransaction().rollback();
            return false;
        }
    }
        
    public boolean delete(Categoria categoria){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            session.delete(categoria);
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            session.getTransaction().rollback();
            return false;
        }
    }
}

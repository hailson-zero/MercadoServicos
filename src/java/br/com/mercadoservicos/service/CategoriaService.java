package br.com.mercadoservicos.service;

import br.com.mercadoservicos.dao.CategoriaDao;
import br.com.mercadoservicos.domain.Categoria;
import java.util.List;

public class CategoriaService {
    
    public List<Categoria> listar(){
        CategoriaDao categoriaDao = new CategoriaDao();
        return categoriaDao.listar();
    }
    
    public Categoria consultar(Integer id){
        CategoriaDao categoriaDao = new CategoriaDao();
        return categoriaDao.consultar(id);
    }
    
    public boolean inserir(Categoria categoria){
        CategoriaDao categoriaDao = new CategoriaDao();
        return categoriaDao.inserir(categoria);
    }
    
    public boolean alterar(Categoria categoria){
        CategoriaDao categoriaDao = new CategoriaDao();
        return categoriaDao.update(categoria);
    }
    
    public boolean excluir(Categoria categoria){
        CategoriaDao categoriaDao = new CategoriaDao();
        return categoriaDao.delete(categoria);
    }
}

package br.com.comanda.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.comanda.dao.ComandaDAO;
import br.com.comanda.dto.Comanda;

@Repository("comandaDAO")
@Transactional
public class ComandaDAOImpl implements ComandaDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean adicionar(Comanda comanda) {
		try {
			sessionFactory.getCurrentSession().persist(comanda);
			return true;
		}catch(Exception ex) {
			return false;
		}
	}

	@Override
	public Comanda buscar(Long id) {
		
		return sessionFactory.getCurrentSession().get(Comanda.class, id);
	}

	@Override
	public boolean excluir(Comanda comanda) {
		try {
			sessionFactory.getCurrentSession().delete(comanda);
			return true;
		}catch(Exception ex) {
			return false;
		}
	}

	@Override
	public boolean alterar(Comanda comanda) {
		try {
			sessionFactory.getCurrentSession().update(comanda);
			return true;
		}catch(Exception ex) {
			
		}
		return false;
	}

	@Override
	public List<Comanda> listar() {
		String queryListarComandas = "FROM Comanda";
		Query query = sessionFactory.getCurrentSession().createQuery(queryListarComandas);
		return query.getResultList();
	}

}

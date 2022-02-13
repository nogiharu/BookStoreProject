package jp.ken.bookstore.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import jp.ken.bookstore.entity.Product;

public class ProductDAOImpl implements ProductDAO {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Product> allListOrderBy() {
		Session session = sessionFactory.openSession();
		//Query query = session.createQuery("FROM Product f ORDER BY f.publication_year ASC");
		Query query = session.createQuery("FROM Product ORDER BY publication_year ASC");
		List<Product> list = query.list();
		session.close();
		return list;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Product> likeList(String name) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM Product WHERE product_name LIKE ?");
		query.setParameter(0, "%" + name + "%");
		List<Product> list = query.list();
		session.close();
		return list;
	}
	
}

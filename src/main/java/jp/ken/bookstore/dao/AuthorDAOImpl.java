package jp.ken.bookstore.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import jp.ken.bookstore.entity.Author;
public class AuthorDAOImpl implements AuthorDAO {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	@SuppressWarnings("unchecked")
	public List<Author> allList() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM Author");
		List<Author> list = query.list();
		session.close();
		return list;
	}
}

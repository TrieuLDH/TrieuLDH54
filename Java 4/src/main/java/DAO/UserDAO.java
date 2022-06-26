package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Utils.JpaUtils;
import entities.User;

public class UserDAO {
	private EntityManager em;
	public UserDAO() {
		this.em = JpaUtils.getEntityManager();
	}
	public List<User> all(){
		String jqpl = "SELECT obj FROM User obj";
		TypedQuery<User> query = this.em.createQuery(jqpl, User.class);
		List<User> ds = query.getResultList();
		return ds;
	}
	public User findByEmail(String email) {
		String jpql = "SELECT obj FROM User obj "
				+ "WHERE obj.email = :email";
		TypedQuery<User> query = this.em.createQuery(jpql, User.class);
				
		query.setParameter("email", email);
		return query.getSingleResult();
	}
	public User create(User entity) throws Exception{
		try {
			this.em.getTransaction().begin();
			this.em.persist(entity);
			this.em.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			this.em.getTransaction().rollback();
			throw e;
		}
	}
	public User findById(int id)throws Exception {
		User u = this.em.find(User.class, id);
		if (u == null) {
			throw new Exception("NotFoundException");
		}
		return u;
	}
	public void delete(User entity) throws Exception{
		try {
			this.em.getTransaction().begin();
			this.em.remove(entity);
			this.em.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			this.em.getTransaction().rollback();
			throw e;
		}
	}
	public void update(User entity) throws Exception{
		try {
			this.em.getTransaction().begin();
			this.em.merge(entity);
			this.em.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			this.em.getTransaction().rollback();
			throw e;
		}
	}
}

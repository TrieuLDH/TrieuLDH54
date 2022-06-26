package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Utils.JpaUtils;
import entities.Category;

public class CategoryDAO {
	private EntityManager em;
	public CategoryDAO() {
		this.em = JpaUtils.getEntityManager();
	}
	public List<Category> all(){
		String jqpl = "SELECT obj FROM Category obj";
		TypedQuery<Category> query = this.em.createQuery(jqpl, Category.class);
		List<Category> dsCate = query.getResultList();
		return dsCate;
	}
	
	public Category danhMuc(int id){
		String jpql = "SELECT obj FROM Category obj "
				+ "WHERE obj.id = :id";
		TypedQuery<Category> query = this.em.createQuery(jpql, Category.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}
	public Category findById(int id) throws Exception{
		Category cate = this.em.find(Category.class, id);
		if (cate == null) {
			throw new Exception("NotFoundException");
		}
		return cate;
	}
	

	
	public Category create(Category entity) throws Exception{
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
	public void delete(Category entity) throws Exception{
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
	public void update(Category entity) throws Exception{
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

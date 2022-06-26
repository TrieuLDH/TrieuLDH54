package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Utils.JpaUtils;
import entities.Category;
import entities.Product;
import entities.User;

public class ProductsDAO {
	private EntityManager em;
	public ProductsDAO() {
		this.em = JpaUtils.getEntityManager();
	}
	
	public List<Product> all(){
		String jqpl = "SELECT obj FROM Product obj";
		TypedQuery<Product> query = this.em.createQuery(jqpl, Product.class);
		List<Product> dsPro = query.getResultList();
		return dsPro;
	}
	
	public Product findById(int id) throws Exception{
		Product pro = this.em.find(Product.class, id);
		if (pro == null) {
			throw new Exception("NotFoundException");
		}
		return pro;
	}
	
public List<Product> byCateid(int id){
		
//		String jpql = " SELECT p FROM Product p "
//				+ "where p.cateId.id = :id"; 	
		String jpql = "SELECT p FROM Product p where p.cate.id = :id";
		
		TypedQuery<Product> q = this.em.createQuery(jpql, Product.class);
		q.setParameter("id", id);
		List<Product> ds = q.getResultList();
//		query.getSingleResult();
		return ds;
	}

	public Product create(Product entity) throws Exception{
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
	public void delete(Product entity) throws Exception{
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
	public void update(Product entity) throws Exception{
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

package org.jsp.user_web_app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.user_web_app.dto.User;

public class UserDao {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
	EntityManager em =emf.createEntityManager();
	
	
	public User SaveUser(User User)
	{
		EntityTransaction transaction = em.getTransaction();
		em.persist(User);
		transaction.begin();
		transaction.commit();
		return User;
	}
	  
	  
	  public User updateUser(User user) {
	  EntityTransaction et =em.getTransaction();
	  em.merge(user);
	  et.begin();
	  et.commit();
       return user;
		}
	  
	  
	  public  boolean  deleteUser(int id) {
	  EntityTransaction et =em.getTransaction();
	  User u =em.find(User.class, id);
	  if(u!=null) {
		  em.remove(u);
		  et.begin();
		  et.commit();
		  return true;
	  }
	  return false;
	  } 
	  
	  public User findUserById(int id) {
	  return em.find(User.class, id);
	  }
	  
	  public List<User> findAllUsers(){
		  Query q=em.createQuery("select u from User u");
		  return q.getResultList();
	  }
	  
	  
	  public User verifyUser(long phone,String password) {
	  Query q =em.createQuery("select u from User u where u.phone=?1 and u.password=?2");
	  q.setParameter(1, phone);
	  q.setParameter(2, password);
	  List<User> users=q.getResultList();
	  if(users.size()>0) 
	  return users.get(0);
	  return null;
	  
	  
	  
	  
	 }

}

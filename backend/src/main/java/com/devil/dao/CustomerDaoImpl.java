package com.devil.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.devil.models.Authorities;
import com.devil.models.Customer;
import com.devil.models.User;

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {
	@Autowired
private SessionFactory sessionFactory;
	public void registerCustomer(Customer customer) {
		Session session=sessionFactory.getCurrentSession();
		Authorities authorities=customer.getUser().getAuthorities();
		User user=customer.getUser();
		authorities.setUser(user);
		session.save(customer);

	}
	public boolean isEmailUnique(String email) {
		Session session=sessionFactory.getCurrentSession();
		User user=(User)session.get(User.class, email);
		if(user==null)
			return true;
		else 
			return false;
		
	}

}


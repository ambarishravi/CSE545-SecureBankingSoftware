package com.sbs.group11.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.sbs.group11.model.User;

@Repository("internalUserDaoImpl")
public class InternalUserDaoImpl extends AbstractDao<Integer, User> implements InternalUserDao {

	public void saveInternalUser(User user) {
		persist(user);
	}

	public void deleteInternalUserById(int id) {
		Query query = getSession().createSQLQuery(
				"delete from Employee where EmployeeID = :id");
		query.setInteger(id, id);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllInternalUsers() {
		Criteria criteria = createEntityCriteria();
		return (List<User>) criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public User findUserByID(String ID) {

		List<User> users = new ArrayList<User>();
		
		
		users = getSession()
				.createQuery("from User where CustomerID=?")
				.setParameter(0, ID)
				.list();

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}

	}
	
	@SuppressWarnings("unchecked")
	public User findUserByEmail(String email) {

		List<User> users = new ArrayList<User>();

		users = getSession()
			.createQuery("from User where Email=?")
			.setParameter(0, email)
			.list();

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}

	}

	

}
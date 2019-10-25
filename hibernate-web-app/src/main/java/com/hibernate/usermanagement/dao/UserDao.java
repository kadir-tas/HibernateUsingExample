package com.hibernate.usermanagement.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.usermanagement.dto.UserDto;
import com.hibernate.usermanagement.model.User;
import com.hibernate.usermanagement.utl.HibernateUtil;

public class UserDao {

	public void saveUser(UserDto userDto) {
		Transaction transaction = null;
		User user = new User(userDto);

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public void updateUser(UserDto userDto) {
		Transaction transaction = null;
		User user = new User(userDto);

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.update(user);
			session.getTransaction().commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public void deleteUser(String phone) {
		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			User user = session.get(User.class, phone);
			if (user != null) {
				session.delete(user);
				System.out.println("user is deleted");
			}

			session.getTransaction().commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public UserDto getUser(String phone) {
		Transaction transaction = null;
		UserDto userDto = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			User user = session.get(User.class, phone);
			
			if (user != null) {
				userDto = new UserDto(user);
			}
			session.getTransaction().commit();
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return userDto;
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUser() {

		Transaction transaction = null;
		List<User> listOfUser = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			// start a transaction
			transaction = session.beginTransaction();

			// get an user object
			listOfUser = session.createQuery("from User").getResultList();

			// commit transaction
			session.getTransaction().commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfUser;
	}
}

/**
 * 
 */
package com.csf.mama.repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.csf.mama.exception.AppException;
import com.csf.mama.exception.GolbalExceptionHandler;
import com.csf.mama.exception.Messages;

/**
 * @author TuanDQ
 *
 */
@SuppressWarnings("deprecation")
public class BaseRepository<E, K extends Serializable> {
	public static final Logger LOGGER = LoggerFactory.getLogger(GolbalExceptionHandler.class);
	private Class<E> persistentClass;

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public BaseRepository() {
		this.persistentClass = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	/***
	 * @param E
	 *            entity
	 */
	public K save(E instance) {
		LOGGER.debug("Saving " + persistentClass.getSimpleName() + " instance");
		try {
			@SuppressWarnings("unchecked")
			K id = (K) getSessionFactory().getCurrentSession().save(instance);
			LOGGER.debug("Save successful");
			return id;
		} catch (RuntimeException re) {
			throw new AppException(Messages.EC9001, re);
		}
	}

	/***
	 * @param E
	 *            entity
	 */
	public void update(E instance) {
		LOGGER.debug("Updating " + persistentClass.getSimpleName() + " instance");
		try {
			getSessionFactory().getCurrentSession().update(instance);
			LOGGER.debug("Update successful");
		} catch (RuntimeException re) {
			throw new AppException(Messages.EC9001, re);
		}
	}

	/***
	 * @param E
	 *            entity
	 */
	public void delete(E instance) {
		LOGGER.debug("Deleting " + persistentClass.getSimpleName() + " instance");
		try {
			getSessionFactory().getCurrentSession().delete(instance);
			LOGGER.debug("Delete successful");
		} catch (RuntimeException re) {
			throw new AppException(Messages.EC9001, re);
		}
	}

	/***
	 * @param K
	 *            key
	 */
	public E findById(K id) {
		LOGGER.debug("Getting " + persistentClass.getSimpleName() + " instance with id: " + id);
		try {
			@SuppressWarnings("unchecked")
			E instance = (E) getSessionFactory().getCurrentSession().get(persistentClass.getName(), id);
			if (instance == null) {
				LOGGER.debug("Get successful, no instance found");
			} else {
				LOGGER.debug("Get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			throw new AppException(Messages.EC9001, re);
		}
	}

	/***
	 * @param Criterion
	 *            criterion
	 */
	@SuppressWarnings("unchecked")
	public List<E> findByCriterion(Criterion criterion) {

		try {
			@SuppressWarnings("rawtypes")
			List results = getSessionFactory().getCurrentSession().createCriteria(persistentClass.getName())
					.add(criterion).list();
			LOGGER.debug("Find by criterion successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			throw new AppException(Messages.EC9001, re);
		}
	}

	/***
	 * 
	 * @param String
	 *            query string
	 */
	@SuppressWarnings("rawtypes")
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = SQLException.class)
	public SQLQuery createNativeSQL(String queryString) {

		try {
			SQLQuery sqlQuery = getSessionFactory().getCurrentSession().createSQLQuery(queryString);
			LOGGER.debug("Create query successful");
			return sqlQuery;
		} catch (RuntimeException re) {
			LOGGER.debug(re.getMessage());
			throw new AppException(Messages.EC9001, re);
		}
	}

}

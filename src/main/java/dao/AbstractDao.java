package dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import utils.JpaUtil;

public class AbstractDao<T> {

	public static final EntityManager entityManager = JpaUtil.getEntityManager();

//	@SuppressWarnings("removal")
//	@Override
//	protected void finalize() throws Throwable {
//		// TODO Auto-generated method stub
//		entityManager.close();
//		super.finalize();
//	}

	public T findById(Class<T> clazz, int id) {
		return entityManager.find(clazz, id);
	}

	public List<T> findAll(Class<T> clazz, boolean existIsActive) {
		String entityName = clazz.getSimpleName();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT o FROM ").append(entityName).append(" o");

		// lấy tên của class truyền vào entityName sau đó thêm vào appened để hoàn thành
		// câu lệnh

		// kiểm tra biến existIActive để tiếp tục truyền câu lệnh vào appened
		if (existIsActive == true) {
			sql.append(" WHERE isActive = 1");
		}
		TypedQuery<T> query = entityManager.createQuery(sql.toString(), clazz);
		return query.getResultList();
	}

	public List<T> findAll(Class<T> clazz, boolean existIsActive, int pageNumber, int pageSize) {
		String entityName = clazz.getSimpleName();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT o FROM ").append(entityName).append(" o");

		// lấy tên của class truyền vào entityName sau đó thêm vào appened để hoàn thành
		// câu lệnh

		// kiểm tra biến existIActive để tiếp tục truyền câu lệnh vào appened
		if (existIsActive == true) {
			sql.append(" WHERE isActive = 1");
		}
		TypedQuery<T> query = entityManager.createQuery(sql.toString(), clazz);
		// 1:22
		// -1 trang để số trang thành 1 thay vì 0
		// sau đó nhân với số phần tử của trang muốn đến thì sẽ đến được chính xác vị
		// trí trang
		// ==> để lấy phần tử thứ n-1
		query.setFirstResult((pageNumber - 1) * pageSize);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}

	// Nhận câu lênhj sql sau đó truyền vào các parameters
	// chạy vòng lặp lấy tổng số parameters và truyền vào nó
	// truyền dúng thứ tự các paremeters
	// vd câu lệnh finOne(User.class,sql,"thinhlc","111")
	public T findOne(Class<T> clazz, String sql, Object... params) {
		TypedQuery<T> query = entityManager.createQuery(sql, clazz);

		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		// Tránh trường hợp query null nên dùng list
		List<T> result = query.getResultList();
		if (result.isEmpty()) {
			return null;
		}
		return result.get(0);
	}

	public List<T> findMany(Class<T> clazz, String sql, Object... params) {
		TypedQuery<T> query = entityManager.createQuery(sql, clazz);

		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		return query.getResultList();
	}
@SuppressWarnings("unchecked")
	public List<Object[]> findManyByNativeQuery(Class<T> clazz, String sql, Object... params) {
		Query query = entityManager.createQuery(sql, clazz);

		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		return query.getResultList();
	}

	public T create(T entity) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(entity);
			entityManager.getTransaction().commit();
			System.out.println("tạo thành công");
			return entity;

		} catch (Exception e) {
			// TODO: handle exception
			entityManager.getTransaction().rollback();
			System.out.println("Tạo thất bại");
			throw new RuntimeException(e);
		}
	}

	public T update(T entity) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(entity);
			entityManager.getTransaction().commit();
			System.out.println("Cập Nhật thành công 1");
			return entity;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			System.out.println("Cập Nhật thất bại");
			throw new RuntimeException(e);
		}
	}
	
	public T delete(T entity) {
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
			System.out.println("Xóa thành công");
			return entity;
		} catch (Exception e) {
			// TODO: handle exception
			entityManager.getTransaction().rollback();
			System.out.println("Xóa thất bại");
			throw new RuntimeException(e);
		}
	}

}
package internetshop.dao.hibernate;

import internetshop.annotation.Dao;
import internetshop.dao.OrderDao;
import internetshop.model.Order;
import internetshop.util.HibernateUtil;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

@Dao
public class OrderDaoHibernateImpl implements OrderDao {
    @Override
    public Order create(Order order) {
        Session session = null;
        Transaction transaction = null;
        Long orderId = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            orderId = (Long) session.save(order);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        order.setId(orderId);
        return order;
    }

    @Override
    public Order get(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Order.class, id);
        }
    }

    @Override
    public Order update(Order order) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(order);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return order;
    }

    @Override
    public void delete(Long id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Order order = session.get(Order.class, id);
            session.delete(order);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Order> getAllOrdersByUserId(Long userId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("FROM Order WHERE user.id=:userId");
            query.setParameter("userId", userId);
            return query.getResultList();
        }
    }
}

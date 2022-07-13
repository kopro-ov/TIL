package com.ddd.ex.order.infra;

import com.ddd.ex.order.domain.Order;
import com.ddd.ex.order.domain.OrderNo;
import com.ddd.ex.order.domain.OrderRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class JpaOrderRepository implements OrderRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Order> findById(OrderNo no) {

        Order order = entityManager.find(Order.class, no);
        return order != null ? Optional.of(order) : Optional.empty();
    }

    @Override
    public void save(Order order) {
        entityManager.persist(order);
    }

    @Override
    public List<Order> findByOrderId(String orderId, int startRow, int fetchSize) {

        TypedQuery<Order> query = entityManager.createQuery(
                "select o from Order o " +
                        "where o.order.memberId.id = :orderId " +
                        "order by o.number.number desc",
                Order.class);
        query.setParameter("orderId", orderId);
        query.setFirstResult(startRow);
        query.setMaxResults(fetchSize);

        return query.getResultList();
    }

    @Override
    public void delete(Order order) {
        entityManager.remove(order);
    }

}

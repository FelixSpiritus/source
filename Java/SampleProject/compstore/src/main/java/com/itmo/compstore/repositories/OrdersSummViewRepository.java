package com.itmo.compstore.repositories;

import com.itmo.compstore.models.OrdersSummView;
import com.itmo.compstore.models.SalesView;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersSummViewRepository extends ReadOnlyRepository<OrdersSummView, Long>{


    @Query(nativeQuery = true, value="select order_id,  sum(saleprice*qtyinorder) total" +
            " from order_items group by order_id")
    List<OrdersSummView> OrdersTotal();

    @Query(nativeQuery = true, value="select order_id,  sum(saleprice*qtyinorder) total" +
            " from order_items where order_id=?1 group by order_id")
    OrdersSummView OrderTotal(Long id);

}
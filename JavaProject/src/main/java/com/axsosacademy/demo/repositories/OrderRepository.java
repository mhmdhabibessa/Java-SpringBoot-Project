package com.axsosacademy.demo.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsosacademy.demo.models.Order;
@Repository

public interface OrderRepository extends CrudRepository<Order, Long>{






	}

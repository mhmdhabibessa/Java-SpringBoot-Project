package com.axsosacademy.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsosacademy.demo.models.Painting;


@Repository
public interface PaintingRepository extends CrudRepository<Painting, Long> {
	List<Painting> findAll();
}

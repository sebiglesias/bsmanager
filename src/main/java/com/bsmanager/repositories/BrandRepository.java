package com.bsmanager.repositories;

import com.bsmanager.models.products.Brand;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface BrandRepository extends CrudRepository<Brand, Long> {
}

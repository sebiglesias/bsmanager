package com.bsmanager.repositories;

import com.bsmanager.models.productInfo.Brand;
import org.springframework.data.repository.CrudRepository;

public interface BrandRepository extends CrudRepository<Brand, Long> {
}

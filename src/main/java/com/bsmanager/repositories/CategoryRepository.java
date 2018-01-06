package com.bsmanager.repositories;

import com.bsmanager.models.productInfo.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}

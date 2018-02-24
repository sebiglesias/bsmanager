package com.bsmanager.models.products;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@category")
@Entity
@Table(name="CATEGORIES")
public class Category {

    @GenericGenerator(
            name = "categoriesSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "categoriesSequence"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )

    @Id
    @GeneratedValue(generator = "categoriesSequenceGenerator")
    private long id;
    private String plural_name;
    private String singular_name;
    @JsonBackReference
    @ManyToMany
    @JoinTable(name="PRODUCT_CATEGORY",
            joinColumns = @JoinColumn(name = "PRODUCT_CATEGORY_CATEGORY_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "PRODUCT_CATEGORY_PRODUCT_ID", referencedColumnName = "ID")
    )
    private Set<Product> products = new HashSet<>();

    public Category(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPlural_name() {
        return plural_name;
    }

    public void setPlural_name(String plural_name) {
        this.plural_name = plural_name;
    }

    public String getSingular_name() {
        return singular_name;
    }

    public void setSingular_name(String singular_name) {
        this.singular_name = singular_name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}

package com.bsmanager.models;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name= "STORES")
public class Store {
    @GenericGenerator(
            name = "storesSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "storesSequence"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )

    @Id
    @GeneratedValue(generator = "storesSequenceGenerator")
    private long id;
    @Column(unique=true)
    private String name;
    private String address;
    @ManyToOne
    @JoinColumn(name="USERS_ID")
    private User userid;
    @ManyToMany
    @JoinTable(name="INDIVIDUAL_PRODUCT",
            joinColumns = @JoinColumn(name="INDIVIDUAL_STORE_ID", referencedColumnName = "STORES_ID"),
            inverseJoinColumns = @JoinColumn(name = "INDIVIDUAL_PRODUCT_ID", referencedColumnName = "PRODUCTS_ID")
    )
    private Set<Product> products = new HashSet<>();

    public Store(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

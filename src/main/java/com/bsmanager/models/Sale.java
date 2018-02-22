package com.bsmanager.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@sales")
@Entity
@Table(name="SALES")
public class Sale {
    @GenericGenerator(
            name = "salesSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "salesSequence"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )

    @Id
    @GeneratedValue(generator = "salesSequenceGenerator")
    private long id;
    private long price;
    @ManyToOne
    @JoinColumn(name="USERS_ID")
    private User user;
    @Temporal(value=TemporalType.TIMESTAMP)
    private Date date;
    @ManyToMany
    @JoinTable(name="PRODUCT_SALE",
            joinColumns = @JoinColumn(name = "PRODUCT_SALE_SALE_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "PRODUCT_SALE_PRODUCT_ID", referencedColumnName = "ID")
    )
    private Set<Product> products;
    private String details;

    public Sale(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}

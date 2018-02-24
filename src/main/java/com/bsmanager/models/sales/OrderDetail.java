package com.bsmanager.models.sales;

import com.bsmanager.models.products.Product;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@orderDetails")
@Entity
@Table(name="ODETAILS")
public class OrderDetail {
    @GenericGenerator(
            name = "orderDetailSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "orderDetailSequence"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )

    @Id
    @GeneratedValue(generator = "orderDetailSequenceGenerator")
    private long id;
    @ManyToOne
    @JoinColumn(name = "ORDERS_ID")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "PRODUCTS_ID")
    private Product product;
    private int quantity;
    private int price;

    public OrderDetail(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

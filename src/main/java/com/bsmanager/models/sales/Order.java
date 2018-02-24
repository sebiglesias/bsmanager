package com.bsmanager.models.sales;

import com.bsmanager.models.users.User;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.Date;
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@orders")
@Entity
@Table(name="ORDERS")
public class Order {
    @GenericGenerator(
            name = "ordersSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "ordersSequence"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )

    @Id
    @GeneratedValue(generator = "ordersSequenceGenerator")
    private long id;
    private long price;
    @ManyToOne
    @JoinColumn(name="USERS_ID")
    private User user;
    @Temporal(value=TemporalType.TIMESTAMP)
    private Date date;

    public Order(){}

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
}

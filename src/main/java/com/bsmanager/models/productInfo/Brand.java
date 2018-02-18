package com.bsmanager.models.productInfo;

import com.bsmanager.models.User;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name= "BRANDS")
public class Brand {

    @GenericGenerator(
            name = "brandsSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "brandsSequence"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )

    @Id
    @GeneratedValue(generator = "brandsSequenceGenerator")
    private long id;
    private String name;
    private String infoURL;
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name="USERS_ID")
    private Set<User> suppliers = new HashSet<>();
    private String observations;

    public Brand(){}

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

    public String getInfoURL() {
        return infoURL;
    }

    public void setInfoURL(String infoURL) {
        this.infoURL = infoURL;
    }

    public Set<User> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Set<User> suppliers) {
        this.suppliers = suppliers;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }
}

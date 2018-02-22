package com.bsmanager.models.productInfo;

import com.bsmanager.models.Product;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name= "MEASURES")
public class Measure {

    @GenericGenerator(
            name = "measuresSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "measuresSequence"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )

    @Id
    @GeneratedValue(generator = "measuresSequenceGenerator")
    private long id;
    private String name;
    private String abbreviation;
    @OneToMany(mappedBy = "measure", cascade = CascadeType.ALL)
    private Set<Product> products;

    public Measure(){}

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

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}

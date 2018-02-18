package com.bsmanager.models;

import com.bsmanager.models.productInfo.Brand;
import com.bsmanager.models.productInfo.Category;
import com.bsmanager.models.productInfo.Unit;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="PRODUCTS")
public class Product {
    @GenericGenerator(
            name = "productsSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "productsSequence"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )

    @Id
    @GeneratedValue(generator = "productsSequenceGenerator")
    private long id;
    private String name;
    private String code;
    @OneToOne
    private Brand brand;
    @OneToMany(targetEntity = Category.class)
    private Set<Category> categories = new HashSet<Category>();
    private String model;
    private String series;
    private String infoUrl;
    private String shortDescription;
    private String longDescription;
    private long costBeforeTax;
    private long costAfterTax;
    @OneToOne
    private Unit unit;
    @ManyToMany
    @JoinTable(name="INDIVIDUAL_PRODUCT",
            joinColumns = @JoinColumn(name = "INDIVIDUAL_PRODUCT_ID", referencedColumnName = "PRODUCTS_ID"),
            inverseJoinColumns = @JoinColumn(name="INDIVIDUAL_STORE_ID", referencedColumnName = "STORES_ID")
    )
    private Set<Store> store;

    public Product(){}

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

    public String getCode() {
        return code;
    }

    public void setCodes(String code) {
        this.code = code;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getInfoUrl() {
        return infoUrl;
    }

    public void setInfoUrl(String infoUrl) {
        this.infoUrl = infoUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public long getCostBeforeTax() {
        return costBeforeTax;
    }

    public void setCostBeforeTax(long costBeforeTax) {
        this.costBeforeTax = costBeforeTax;
    }

    public long getCostAfterTax() {
        return costAfterTax;
    }

    public void setCostAfterTax(long costAfterTax) {
        this.costAfterTax = costAfterTax;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}

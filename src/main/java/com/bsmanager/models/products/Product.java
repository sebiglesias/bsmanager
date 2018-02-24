package com.bsmanager.models.products;

import com.bsmanager.models.sales.OrderDetail;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@product")
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
    @ManyToOne
    @JoinColumn(name = "BRANDS_ID")
    private Brand brand;
    @ManyToMany
    @JoinTable(name="PRODUCT_CATEGORY",
        joinColumns = @JoinColumn(name = "PRODUCT_CATEGORY_PRODUCT_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "PRODUCT_CATEGORY_CATEGORY_ID", referencedColumnName = "ID")
    )
    private Set<Category> categories = new HashSet<>();
    private String model;
    private String series;
    private String infoUrl;
    private String shortDescription;
    private String longDescription;
    private long costBeforeTax;
    private long costAfterTax;
    @ManyToOne
    @JoinColumn(name = "MEASURES_ID")
    private Measure measure;
    private int quantity;

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

    public void setCode(String code) {
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

    public Measure getMeasure() {
        return measure;
    }

    public void setMeasure(Measure measure) {
        this.measure = measure;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}

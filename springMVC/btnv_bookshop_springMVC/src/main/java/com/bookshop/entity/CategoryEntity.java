package com.bookshop.entity;

import com.bookshop.model.ProductionModel;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "categories")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "category_name")
    private String categoryName;
    private String description;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
//    @JsonManagedReference
    @JsonBackReference
//    @JsonIgnore
    private Set<ProductionEntity> productions;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<ProductionEntity> getProductions() {
        return productions;
    }

    public void setProductions(Set<ProductionEntity> productions) {
        this.productions = productions;
    }
}

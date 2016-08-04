package com.lyashuk.dto;

/**
 * Created by User on 20.07.2016.
 */
public class ProductGroupDto {
    private Long id;
    private String description;
    /*todo*/

    @Override
    public String toString() {
        return "ProductGroupDto{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

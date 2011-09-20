package com.blogspot.chicchiricco.persistence;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * User Persistent entity.
 */
@Entity
public class TestEntity extends AbstractBaseBean {

    /**
     * the id
     */
    @Id
    private Long id;

    /**
     * @return the unique id
     */
    public Long getId() {
        return id;
    }

    /**
     * sets the unique id
     * @param id the unique id
     */
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TestEntity{" + "id=" + id + '}';
    }
}

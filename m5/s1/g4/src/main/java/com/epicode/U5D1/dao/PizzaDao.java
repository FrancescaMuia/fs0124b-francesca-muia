package com.epicode.U5D1.dao;

import com.epicode.U5D1.entities.Pizza;

public interface PizzaDao {

    public void insert(Pizza pizza); // Create

    public void update(Pizza pizza); // Update

    public void delete(Integer id); // Delete

    public Pizza getById(Integer id); // Read

}

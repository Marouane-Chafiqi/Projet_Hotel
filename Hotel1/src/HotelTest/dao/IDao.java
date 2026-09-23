/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelTest.dao;

import java.util.List;

/**
 *
 * @author Admin
 */
public interface IDao<T> {

    boolean creat(T o);
    boolean update(T o);
    boolean delete(T o);
    T findById(long id);
    List<T> findAll();
    
}

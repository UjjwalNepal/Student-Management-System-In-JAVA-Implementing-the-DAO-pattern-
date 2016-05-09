/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ujjwal.sms.dao;

import java.util.List;
import ujjwal.sms.entity.Student;

/**
 *
 * @author ujjwal
 */
public interface StudentDAO {

    int insert(Student s);

    void update(int id);

    void delete(int id);

    Student getById(int id);

    Student getByName(String name);

    List<Student> getAll();
}

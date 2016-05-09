/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ujjwal.sms.service.impl;

import java.util.ArrayList;
import java.util.List;
import ujjwal.sms.dao.StudentDAO;
import ujjwal.sms.dao.impl.StudentDAOImpl;
import ujjwal.sms.entity.Student;
import ujjwal.sms.service.ServiceDAO;

/**
 *
 * @author ujjwal
 */
public class StudentServiceImpl implements ServiceDAO{

    private StudentDAO studentDAO = new StudentDAOImpl(new ArrayList<>());
    
    
    @Override
    public int insert(Student s) {
        return studentDAO.insert(s);
    }

    @Override
    public void update(int id) {
        studentDAO.update(id);
    }

    @Override
    public void delete(int id) {
        studentDAO.delete(id);
    }

    @Override
    public Student getById(int id) {
        return studentDAO.getById(id);
    }

    @Override
    public Student getByName(String name) {
        return studentDAO.getByName(name);
    }

    @Override
    public List<Student> getAll() {
        return studentDAO.getAll();
    }
    
}

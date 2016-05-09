/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ujjwal.sms.dao.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import ujjwal.sms.dao.StudentDAO;
import ujjwal.sms.entity.Student;

/**
 *
 * @author ujjwal
 */
public class StudentDAOImpl implements StudentDAO{

    private final List<Student> studentList;
    
    public StudentDAOImpl(List<Student> studentList){
        this.studentList = studentList;
    }
    
    
    @Override
    public int insert(Student s) {
       boolean x=  studentList.add(s);
       if(x){
           return 1;
       }
       else
           return 0;
    }

    @Override
    public void update(int id) {
        Student st = studentList.get(id);
        System.out.println(st.toString());
        Scanner sc = new Scanner(System.in);
        System.out.println(st.getId());
        System.out.println("Enter new value for id");
        int x = sc.nextInt();
        st.setId(x);
        
        System.out.println(st.getFirstName());
        System.out.println("Enter new value for firstName");
        String name = sc.next();
        st.setFirstName(name);
        
        System.out.println(st.getLastName());
        System.out.println("Enter new value for lastName");
        String lname = sc.next();
        st.setLastName(lname);
        
        System.out.println(st.getEmail());
        System.out.println("Enter new value for email");
        String email = sc.next();
        st.setEmail(email);
        
        System.out.println(st.getContactNo());
        System.out.println("Enter new value for contactNumber");
        String contact = sc.next();
        st.setContactNo(contact);
        
        System.out.println(st.getAddress());
        System.out.println("Enter new value for Address");
        String address = sc.next();
        st.setAddress(address);
        System.out.println(st.getJoinDate());
        System.out.println("Enter new date");
        try{
            DateFormat df = new SimpleDateFormat("yy/mm/dd");
                    
            st.setJoinDate(df.parse(sc.next()));
            }catch(ParseException pe){
                    System.out.println(pe.getMessage());
            }
        System.out.println(st.getStatus());
        System.out.println("Enter new value for Status");
        boolean bool = sc.nextBoolean();
        st.setStatus(bool);
        
        studentList.add(st);
    }

    @Override
    public void delete(int id) {
        studentList.stream().filter((s) -> (s.getId() == id)).map((s) -> {
            studentList.remove(s);
            return s;
        }).forEach((s) -> {
            System.out.println("Successfully removed "+s.toString());
        });
        
    }

    @Override
    public Student getById(int id) {
        Student student = null;
        for(Student i : studentList){
            if(i.getId() == id)
                student = i;
        }
        return student;
    }

    @Override
    public Student getByName(String name) {
        Student student = null;
        for(Student i : studentList){
            if(i.getFirstName() == null ? name == null : i.getFirstName().equals(name))
                student = i;
        }
        return student;
    }

    @Override
    public List<Student> getAll() {
        return studentList;
    }
    
}

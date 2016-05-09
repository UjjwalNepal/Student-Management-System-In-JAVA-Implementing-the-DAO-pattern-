/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ujjwal.sms;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import ujjwal.sms.entity.Student;
import ujjwal.sms.service.ServiceDAO;
import ujjwal.sms.service.impl.StudentServiceImpl;

/**
 *
 * @author ujjwal
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        ServiceDAO serviceDAO = new StudentServiceImpl();
        Student s = new Student();
        while(true){
            System.out.println("Welcome to the studement Management System");
            System.out.println("===========================================");
            System.out.println("1. Press 1 to Add Student");
            System.out.println("2. Press 2 to Edit Student");
            System.out.println("3. Press 3 to Delete Student");
            System.out.println("4. Press 4 to show all Students");
            System.out.println("5. Press 5 to search by Id");
            System.out.println("6. Press 6 to search by Name");
            System.out.println("7. Press 7 to exit");
            System.out.println("press any number from 1 -7");
            switch(sc.nextInt()){
                case 1:
                    while(true){
                            System.out.println("Enter ID");
                            s.setId(sc.nextInt());
                            System.out.println("Enter first name");
                            s.setFirstName(sc.next());
                            System.out.println("Enter last name");
                            s.setLastName(sc.next());
                            System.out.println("Enter email");
                            s.setEmail(sc.next());
                            System.out.println("contact number");
                            s.setContactNo(sc.next());


                            System.out.println("Enter address");
                            s.setAddress(sc.next());

                            System.out.println("Enter Join Date");

                            try{
                                DateFormat df = new SimpleDateFormat("yy/mm/dd");
                                s.setJoinDate(df.parse(sc.next()));
                            }catch(ParseException pe){
                                System.out.println(pe.getMessage());
                            }

                            System.out.println("Enter status");
                            s.setStatus(sc.nextBoolean());
                            serviceDAO.insert(s);

                            System.out.println("So you want to add another entry");
                            if(sc.next().equalsIgnoreCase("n")){
                                break;
                            }
                        
                    }
                    break;

                case 2:
                    System.out.println("Enter the id of student whose value you want to update");
                    int i = sc.nextInt();
                    serviceDAO.update(i);
                    break;

                case 3:
                    System.out.println("Enter the id which you want to delete");
                    int j = sc.nextInt();
                    serviceDAO.delete(j);
                    break;

                case 4:
                    serviceDAO.getAll().stream().forEach((_item) -> {
                        System.out.println(s);
            });
                    break;

                case 5:
                    System.out.println("Enter the id with which you want to search");
                    System.out.println(serviceDAO.getById(sc.nextInt()));
                    break;

                case 6:
                    System.out.println("Enter the name with which you want to search");
                    System.out.println(serviceDAO.getByName(sc.next()));
                    break;

                case 7:
                    System.exit(0);
            }
          
        }
    }
    
}

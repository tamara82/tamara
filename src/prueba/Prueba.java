/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import hr.Department;
import hr.Employee;
import hr.ExceptionHR;
import hr.HR;
import hr.Location;

/**
 *
 * @author usuario
 */
public class Prueba {
    
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    try{    
        Employee e= new Employee();
        e.setEmployeeId(114);
        Location l= new Location();
        l.setLocationId(1700);
        Department d= new Department(30,"Compras",e,l);
        HR hr=new HR();
        hr.modificarDepartment(30, d);
    }
catch (ExceptionHR ex){
            System.out.println(ex); 
}
}
}

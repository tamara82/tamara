package hr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author usuario
 */
public class HR extends Exception{
    
    //Zona REGION
    public int insertarRegion(Region region){
        return -1;
    }
    
    public int borrarRegion (int regionId){
        return -1;
    }
    
    public int modificarRegion (int regionId, Region region){
        return -1;
    }
    
    public Region leerRegion(int regionId){
        return null;
    }
    
    public ArrayList<Region> leerRegions(){
        return null;
    }
    
    //zona COUNTRY
    public int insertarCountry(Country country){
        return -1;
    }
    
    public int borrarCountry (String countryId) throws ExceptionHR{
            int registrosAfectados=0;
        String dml="";
    try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conexion = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "HR", "kk");
            System.out.println("Creación de un objeto sentencia asociado a dicha conexión");
            Statement sentencia = conexion.createStatement();

            System.out.println("----- Lanzamiento de una sentencia DML");
            dml = "delete from countries where countryId=?";
            PreparedStatement sentenciaPreparada = conexion.prepareStatement(dml);
                    
            registrosAfectados = sentencia.executeUpdate(dml);
            
            
            System.out.println("----- Cerrar la Conexión a la BD");
            sentencia.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Error - Clase no Encontrada: " + ex.getMessage());
        } catch (SQLException ex) {
            ExceptionHR exceptionHR=new ExceptionHR(ex.getErrorCode(),ex.getMessage(),null,dml);

            switch (ex.getErrorCode()) {
                case 2292:  System.out.println("No se puede eliminar este continente porque tiene paises asociados");
                            break;      
                default:    System.out.println("Error en el sistema. Consulta con el administrador ");
                            break;
            }
            throw exceptionHR;
        }
    return 0;
}


    
    public int modificarCountry (String countryId, Country country){
        return -1;
    }
    
    public Country leerCountry(String countryId){
        return null;
    }
    
    public ArrayList<Country> leerCountrys(){
        return null;
    }
    
    //zona DEPARTMENT
    public int insertarDepartment(Department department){
        return -1;
    }
    
    public int borrarDepartment (int departmentId){
        return -1;
    }
    
    
    
    public Department leerDepartment(int departmentId){
        return null;
    }
    
    public ArrayList<Department> leerDepartments(){
        return null;
    }
    
    //zona JOB
    public int insertarJob(Job job){
        return -1;
    }
    
    public int borrarJob (String jobId){
        return -1;
    }
    
    public int modificarJob (String jobId, Job job){
        return -1;
    }
    
    public Job leerJob(String jobId){
        return null;
    }
    
    public ArrayList<Job> leerJobs(){
        return null;
    }
    
    //zona JOBHISTORY
    public int insertarJobHistory(JobHistory jobHistory){
        return -1;
    }
    
    public int borrarJobHistory (int employeeId, Date startDate){
        return -1;
    }
    
    public int modificarJobHistory (int employeeId, Date startDate, JobHistory jobHistory){
        return -1;
    }
    
    public JobHistory leerJobHistory(int employeeId, Date startDate){
        return null;
    }
    
    public ArrayList<JobHistory> leerJobHistorys(){
        return null;
    }
    
    //zona LOCATION
    public int insertarLocation(Location location){
        return -1;
    }
    
    public int borrarLocation (int locationId){
        return -1;
    }
    
    public int modificarLocation (int locationId, Location location){
        return -1;
    }
    
    public Location leerLocation(int locationId){
        return null;
    }
    
    public ArrayList<Location> leerLocations(){
        return null;
    }
    public int insertarEmployee(Employee employee){
        String dml = null;
        int registrosAfectados=0;
        try {
            System.out.println("----- Acciones Previas");
            System.out.println("Carga del driver de Oracle en memoria");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Creación de una conexión a una BD Oracle llamada HR");
            Connection conexion = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "HR", "kk");
            System.out.println("Creación de un objeto sentencia asociado a dicha conexión");
            Statement sentencia = conexion.createStatement();
            PreparedStatement sentenciaPreparada = conexion.prepareStatement(dml);
            System.out.println("----- Lanzamiento de una sentencia DML");
            dml = "insert into employee (employeeId,firstName,lastName,email,phoneNumber,hireDate,job,salary,commissionPct,manager,department), "
                    + " values(207,'Pepe','Lopez','algo@gmail.com','666666666','2016-05-13','SH_CLERK',3000,0,124,50)";
            sentenciaPreparada.setInt(1, 207);
            sentenciaPreparada.setString(2, "Pepe");
            sentenciaPreparada.setString(3, "Lopez");
            sentenciaPreparada.setString(4, "algo@gmail.com");
            sentenciaPreparada.setString(5, "666666666");
            sentenciaPreparada.setString(6, "2016-05-13");
            sentenciaPreparada.setString(7, "SH_CLERK");
            sentenciaPreparada.setInt(8, 3000);
            sentenciaPreparada.setInt(9, 0);
            sentenciaPreparada.setInt(10, 124);
            sentenciaPreparada.setInt(11, 50);
            
            registrosAfectados = sentencia.executeUpdate(dml);
            System.out.println("Registros Afectados: " + registrosAfectados);
            System.out.println("----- Cerrar la Conexión a la BD");
            sentencia.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Error - Clase no Encontrada: " + ex.getMessage());
        } catch (SQLException ex) {
            switch (ex.getErrorCode()) {
                case 1400:  System.out.println("Error: los siguientes datos son obligatorios: identificador de empleado, apellido, email, fecha de contratacion,identificador de empleo");
                            break;
                case 1:     System.out.println("Error: El ID del empleado no puede repetirse");
                            break;
                default:    System.out.println("Error en el sistema. Consulta con el administrador");
                            break;
            }
        }return registrosAfectados;
    }
        
    
    
    public int borrarEmployee (String EmployeeId){
        return -1;
    }
    
    public int modificarEmployee (int EmployeeId, Employee employee){
        return -1;
    }
    
    public Location leerEmployee(int employeeId){
        return null;
    }
    
    public ArrayList<Employee> leerEmployees(){
        return null;
    }


public int modificarDepartment(int departmentId, Department department) throws ExceptionHR{
    int registrosAfectados=0;
    String dml="";
    try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conexion = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "HR", "kk");
            System.out.println("Creación de un objeto sentencia asociado a dicha conexión");
            Statement sentencia = conexion.createStatement();

            System.out.println("----- Lanzamiento de una sentencia DML");
            dml = "update DEPARTMENTS set "
                    + "DEPARTMENT_ID= "+department.getDepartmentId()+","
                    + "DEPARTMENT_NAME= '"+department.getDepartmentName()+"'," 
                    + "MANAGER_ID= "+department.getManager().getEmployeeId()+"," 
                    + "LOCATION_ID= "+department.getLocation().getLocationId()
                    + "where DEPARTMENT_ID= "+departmentId;
                    
            registrosAfectados = sentencia.executeUpdate(dml);
            
            
            System.out.println("----- Cerrar la Conexión a la BD");
            sentencia.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Error - Clase no Encontrada: " + ex.getMessage());
        } catch (SQLException ex) {
            ExceptionHR exceptionHR=new ExceptionHR(ex.getErrorCode(),ex.getMessage(),null,dml);

            switch (ex.getErrorCode()) {
                case 2291:  exceptionHR.setMensajeErrorUsuario("La localidad elegida no existe o el jefe de departamento no es un empleado de la empresa");
                            break;
                case 1407:  exceptionHR.setMensajeErrorUsuario("El identificador de departamento y el nombre de departamento son obligatorios");
                            break;
                case 2292:  exceptionHR.setMensajeErrorUsuario("No se puede modificar el identificador de departamento ya que tiene empleados asociados o datos historicos asociados");
                            break;
                case 1:     exceptionHR.setMensajeErrorUsuario("El identificador de departamento ya existe");
                            break;
                default:    exceptionHR.setMensajeErrorUsuario("Error general del sistema. Consulte con el administrador");
                            break;
            }
            throw exceptionHR;
        }
    return registrosAfectados;
}
}

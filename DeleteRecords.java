import java.io.*;
import java.sql.*;

class DeleteRecords
{
   public static void main(String args[])throws IOException
  {
     DataInputStream dis=new DataInputStream(System.in);
     
     System.out.println("Enter Student Id to be deleted");
     int Student_Id=Integer.parseInt(dis.readLine());

     Connection con=null;

     try
       {
          Class.forName("oracle.jdbc.driver.OracleDriver");
          con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");

          String query="Delete from Student_Info where Student_Id=" + Student_Id;
          Statement stmt=con.createStatement();
          stmt.executeUpdate(query);

          stmt.close();
          con.close();

       }
     catch(Exception e)
       {
         System.out.println(e);
       }
     System.out.println("Record deleted successfully");
  }
}
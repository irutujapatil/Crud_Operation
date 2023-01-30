import java.io.*;
import java.sql.*;

class InsertRecords
{
   public static void main(String args[])throws IOException
  {
     DataInputStream dis=new DataInputStream(System.in);
     
     System.out.println("Enter Student Id");
     int Student_Id=Integer.parseInt(dis.readLine());

     System.out.println("Enter Student name");
     String Student_Name=dis.readLine();

     System.out.println("Enter Student age");
     int Student_Age=Integer.parseInt(dis.readLine());

     System.out.println("Enter Student DOB");
     String Student_DOB=dis.readLine();

     System.out.println("Enter Student class");
     String Student_Class=dis.readLine();

     Connection con=null;

     try
       {
          Class.forName("oracle.jdbc.driver.OracleDriver");
          con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");

          String query="Insert into Student_Info values(" + Student_Id + ",'" + Student_Name + "'," + Student_Age + ",'" + Student_DOB + "','" + Student_Class + "')";

          Statement stmt=con.createStatement();
          stmt.executeUpdate(query);

          stmt.close();
          con.close();

       }
     catch(Exception e)
       {
         System.out.println(e);
       }
     System.out.println("Record inserted successfully");
  }
}
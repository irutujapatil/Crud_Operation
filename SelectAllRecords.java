import java.sql.*;

class SelectAllRecords
{
   public static void main(String args[])
  {
    Connection con=null;

    try
      {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         con=DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:XE","system","admin");
 
         String query="Select * from Student_Info order by Student_Id";

         Statement stmt=con.createStatement();
         ResultSet rs=stmt.executeQuery(query);

         while(rs.next())
         {
            System.out.println(rs.getInt("Student_Id") + " " + rs.getString("Student_Name") + " " + rs.getInt("Student_Age") + " " + rs.getString("Student_DOB") + " " + rs.getString("Student_Class"));
          }

         rs.close();
         stmt.close();
         con.close();
      }
    catch(Exception e)
      {
         System.out.println(e);
      }
  }
}
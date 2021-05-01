/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sqlconnect;

/**
 *
 * @author RAH
 */
//Import required packages
import java.sql.*;

public class SQLConnect
{
static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
static final String DB_URL = "jdbc:mysql://localhost:3306";


static final String USER = "DESKTOP-JPIN1VG\\RAH";
static final String PASS = "hadipc";

public static void main(String[] args)
{
Connection conn = null;
java.sql.Statement stmt = null;
try
{
Class.forName("com.mysql.jdbc.Driver");

//Open a connection
System.out.println("Connecting to database...");
conn = DriverManager.getConnection(DB_URL, USER, PASS);

//Execute queries
System.out.println("Open database examdb");
stmt = conn.createStatement();
  
String sql = "USE examdb";
stmt.executeUpdate(sql);
  
 
//read all data from cities table
ResultSet rs=stmt.executeQuery("select * from Cities;");
           while(rs.next())
           {
               id = rs.getString(1);
               name = rs.getString(2);
               System.out.println(id + " " + name );
           }
}
catch(SQLException se)
{
//Handle errors for JDBC
se.printStackTrace();
}
catch(Exception e)
{
//Handle errors for Class.forName
e.printStackTrace();
}
finally
{
try
{
if(stmt!=null)
stmt.close();
}
catch(SQLException se2)
{
}
try
{
if(conn!=null)
conn.close();
}
catch(SQLException se)
{
se.printStackTrace();
}
}
System.out.println("Goodbye!");
}
}

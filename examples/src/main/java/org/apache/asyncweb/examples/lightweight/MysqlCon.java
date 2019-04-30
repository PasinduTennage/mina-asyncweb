package org.apache.asyncweb.examples.lightweight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class MysqlCon{
    public String getName(int id){
        String name = "";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db_example","pasindu","1234");
//here sonoo is database name, root is username and password  
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select name from emp where id='"+id+"'");

            while(rs.next())
                name = rs.getString(1);
            con.close();
        }catch(Exception e){ System.out.println(e);}
        return name;
    }

}  
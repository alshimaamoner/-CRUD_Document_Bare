package service;
import java.io.*;
import java.sql.*;
public class Dao{
   boolean flag=false;
    private Connection conn = DBConn.getConnection();
    public Dao(){}
public User showUsers(int id){
    User user=null; 
    PreparedStatement pstmt;
     try{
    pstmt = conn.prepareStatement("SELECT * FROM user WHERE id=? ");
    pstmt.setInt(1, id);                       
    ResultSet rs = pstmt.executeQuery();       
   while(rs.next())   {
        user=new User();
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setPas(rs.getString("pass"));
        user.setfirstName(rs.getString("firstName")); 
        user.setlastName(rs.getString("lastName"));  
   }
    }catch(Exception e){
        e.printStackTrace();
    }
    return user;
}
public boolean updateUser(User user){
    PreparedStatement pstmt;
     
    try{
    pstmt = conn.prepareStatement("UPDATE user SET name=? , pass=? , firstName=? , lastName=? WHERE id = ?");   
    pstmt.setString(1, user.getName());
    pstmt.setString(2, user.getPas());
    pstmt.setString(3, user.getfirstName());
    pstmt.setString(4, user.getlastName());
    pstmt.setInt(5, user.getId());
    boolean flag=false;
     if(pstmt.executeUpdate() > 0)      
    return true;
    else
    return false;
     }catch(Exception e){
        System.err.println("message"+e.getMessage());
    }
    return false;
}
public boolean insertUser(User user){
     try{
    PreparedStatement pstmt;
    pstmt = conn.prepareStatement("INSERT into user(id,name,pass,firstName,lastName) VALUES (?,?,?,?,?)");
    pstmt.setInt(1, user.getId());
    pstmt.setString(2, user.getName());
    pstmt.setString(3, user.getPas());   
   pstmt.setString(4, user.getfirstName());   
   pstmt.setString(5, user.getlastName()); 
     if(pstmt.executeUpdate() > 0)      
    flag= true;
    else
        flag= false;
    }catch(Exception e){
        System.err.println("message"+e.getMessage());
    }
    return flag;
}   
public boolean deleteUser(User user){
    try{
    PreparedStatement pstmt;
    pstmt = conn.prepareStatement("DELETE from user WHERE id=?");
    pstmt.setInt(1, user.getId());    
    boolean flag=false;
     if(pstmt.executeUpdate() > 0)      
    flag= true;
    else
    flag= false;  
      }catch(Exception e){
        System.err.println("message"+e.getMessage());
    }
    return flag;
}
}
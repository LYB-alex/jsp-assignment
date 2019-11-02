package logicalService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import myBean.userinfo;

public class DLservice {

	public boolean checkLogin(userinfo DL ) throws SQLException{
		Statement stmt=new connectDB().getConnection();
		ResultSet rt=stmt.executeQuery("select * from login where username='"+DL.getUsername()+"' and password ='"+DL.getPassword()+"'");
		if(rt.next()){
			DL.setId(rt.getInt("id"));//获取用户id;
			return true;
		}
		else return false;
	}
	
	public int register(userinfo DL) throws SQLException{ 
		Statement stmt=new connectDB().getConnection();
		if(DL.getUsername()==null||DL.getPassword()==null){
			return 0;
		}
		ResultSet test=stmt.executeQuery("SELECT * FROM login where username='"+DL.getUsername()+"'");
		if(test.next()){
			return 0;//保证用户不重名
		}
		ResultSet rt=stmt.executeQuery("SELECT * FROM login");
		while(!rt.isLast()){
			rt.next();
		}
		int number=rt.getInt("id");
		number++;
		DL.setId(number);
		int flag=stmt.executeUpdate("INSERT INTO login Values("+number+",'"+DL.getUsername()+"','"+DL.getPassword()+"')");
		return flag;
	}
	
	public userinfo Query(userinfo DL) throws SQLException{
		Statement stmt=new connectDB().getConnection();
		ResultSet rt=stmt.executeQuery("select * from login");
		//List<userinfo> list=DL.getList();
		List<userinfo> list=new ArrayList<userinfo>();
		while(rt.next()){
			userinfo user=new userinfo();
			int userID=rt.getInt("id");
			String username=rt.getString("username");
			String password=rt.getString("password");
			user.setId(userID);
			user.setUsername(username);
			user.setPassword(password);
			list.add(user);
		}
		DL.setList(list);
		return DL;
		
	}
	public userinfo Query(String Querymessage,userinfo DL) throws SQLException{
		Statement stmt=new connectDB().getConnection();
		ResultSet rt=stmt.executeQuery("select * from login where username like'"+Querymessage+"%';");
		List<userinfo> list=new ArrayList<userinfo>();
		while(rt.next()){
			userinfo user=new userinfo();
			int id=rt.getInt("id");
			String username=rt.getString("username");
			String password=rt.getString("password");
			user.setId(id);
			user.setUsername(username);
			user.setPassword(password);
			list.add(user);
		}
		DL.setList(list);
		return DL;
	}
	
	public int del(userinfo DL) throws SQLException{
		Statement stmt=new connectDB().getConnection();
		int flag=stmt.executeUpdate("DELETE FROM login where id='"+DL.getId()+"';");
		return flag;
		
	}
	
	public int modify(userinfo DL) throws SQLException{
		Statement stmt=new connectDB().getConnection();
		int flag=stmt.executeUpdate("UPDATE login SET username='"+DL.getUsername()+"',password='"+DL.getPassword()+"' WHERE id='"+DL.getId()+"';");
		return flag;
	}
	
}

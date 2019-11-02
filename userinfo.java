package myBean;

import java.util.ArrayList;
import java.util.List;

public class userinfo {
private int id=1;
private String password,username;
private List<userinfo> list=new ArrayList<userinfo>();
public List<userinfo> getList() {
	return list;
}
public void setList(List<userinfo> list) {
	this.list = list;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}

}

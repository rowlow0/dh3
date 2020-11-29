package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import dto.Dto;

public class Dao {
StringBuffer query=new StringBuffer();
private int result;
private Connection con;
private PreparedStatement pstmt;
private ResultSet rs;
//lazyholder

public Connection getConnect() {
	try{Class.forName("oracle.jdbc.OracleDriver");
	con=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl","c##system2","1234");}
	catch(ClassNotFoundException e) {e.printStackTrace();}catch(SQLException e) {e.printStackTrace();}catch(Exception e) {e.printStackTrace();}
	return con;
}

public void close(Connection con,PreparedStatement pstmt,ResultSet rs) {
	if(con!=null) {
		try {con.close();
	}catch(SQLException e) {e.printStackTrace();}
}
	if(pstmt!=null) {
		try {pstmt.close();
	}catch(SQLException e) {e.printStackTrace();}
}
	if(rs!=null) {
		try {rs.close();
	}catch(SQLException e) {e.printStackTrace();}
}
}

public void insert(Dto dto) {
	query.append("insert into member_tbl_02 values(?,?,?,?,?,?,?)");
	try {
		con=getConnect();
		pstmt=con.prepareStatement(query.toString());
		pstmt.setInt(1, dto.getCustno());
		pstmt.setString(2, dto.getCustname());
		pstmt.setString(3, dto.getPhone());
		pstmt.setString(4, dto.getAddress());
		pstmt.setString(5, dto.getJoindate());
		pstmt.setString(6, dto.getGrade());
		pstmt.setString(7, dto.getCity());
		pstmt.executeUpdate();
	}catch(SQLException e) {e.printStackTrace();}finally {close(con,pstmt,rs);}
	
}
public void update(Dto dto) {
	query.append("update member_tbl_02 set custname=?,phone=?,address=?,joindate=?,grade=?,city=? where custno=?");
	try {
		con=getConnect();
		pstmt=con.prepareStatement(query.toString());
		pstmt.setString(1, dto.getCustname());
		pstmt.setString(2, dto.getPhone());
		pstmt.setString(3, dto.getAddress());
		pstmt.setString(4, dto.getJoindate());
		pstmt.setString(5, dto.getGrade());
		pstmt.setString(6, dto.getCity());
		pstmt.setInt(7, dto.getCustno());
		pstmt.executeUpdate();
	}catch(SQLException e) {e.printStackTrace();}finally {close(con,pstmt,rs);}
	
}

public List<Dto> select(Dto dto){
	List<Dto> list=new ArrayList<Dto>();
	query.append("select*from member_tbl_02");
	try {
		con=getConnect();
		pstmt=con.prepareStatement(query.toString());
		rs=pstmt.executeQuery();
		while(rs.next()) {
			Dto dtoList=new Dto();
			dtoList.setCustno(rs.getInt(1));
			dtoList.setCustname(rs.getString(2));
			dtoList.setPhone(rs.getString(3));
			dtoList.setAddress(rs.getString(4));
			dtoList.setJoindate(rs.getString(5).substring(0,10));
			dtoList.setGrade(rs.getString(6));
			dtoList.setCity(rs.getString(7));
			list.add(dtoList);
		}
		
	}catch(SQLException e) {e.printStackTrace();}finally {close(con,pstmt,rs);}
return list;}

public List<Dto> selectM(Dto dto){
	List<Dto> list=new ArrayList<Dto>();
	query.append("select me.custno,me.custname,me.grade,sum(mo.price) from member_tbl_02 me,money_tbl_02 mo where me.custno=mo.custno group by me.custno,me.custname,me.grade order by sum(mo.price) desc");
	try {
		con=getConnect();
		pstmt=con.prepareStatement(query.toString());
		rs=pstmt.executeQuery();
		while(rs.next()) {
			Dto dtoList=new Dto();
			dtoList.setCustno(rs.getInt(1));
			dtoList.setCustname(rs.getString(2));
			dtoList.setGrade(rs.getString(3));
			dtoList.setPrice(rs.getInt(4));
			list.add(dtoList);
		}
		
	}catch(SQLException e) {e.printStackTrace();}finally {close(con,pstmt,rs);}
return list;}

public int getInsert(Dto dto) {
	query.append("select max(custno) from member_tbl_02");
	try {
		con=getConnect();
		pstmt=con.prepareStatement(query.toString());
		rs=pstmt.executeQuery();
		while(rs.next()) {
			if(rs.getInt(1)!=0) {result=rs.getInt(1)+1;}
			else {
				result=1;
			}
		}
		
	}catch(SQLException e) {e.printStackTrace();}finally {close(con,pstmt,rs);}
return result;}

}

package com.zensar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class StudentRepository {

	public boolean loginCheck(String susername, String spassword) {
		boolean result = false;
		Connection con = DBUtil.getMysqlDBConnection();
		String addStudentSql = "SELECT * FROM login_form WHERE username=?";
		try {
			PreparedStatement pst = con.prepareStatement(addStudentSql);
			pst.setString(1, susername); 
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				String psswordDB = rs.getString("password");
				if(spassword.equals(psswordDB)) {
					result = true;
				}
			}

		} catch (Exception e) {
			System.out.println("addStudent catch" + e);
		}
		return result;
	}

	public void addStudent(BeanStudent bs) {
		Connection con = DBUtil.getMysqlDBConnection();
		String addStudentSql = "INSERT INTO student_crud VALUES(?,?,?,?,?)";
		try {
			PreparedStatement pst = con.prepareStatement(addStudentSql);
			pst.setInt(1, bs.getSid());
			pst.setString(2, bs.getSname());
			pst.setString(3, bs.getScourse());
			pst.setString(4, bs.getShometown());
			pst.setString(5, bs.getSgender());
			int result = pst.executeUpdate();
			if(result==0) {
				System.out.println("Student Add failed");
			}else {
				System.out.println("Student Added Successfully");
			}
		} catch (Exception e) {
			System.out.println("addStudent catch" + e);
		}
	}// Method addStudent
	public List<BeanStudent> getAllStudent(){
		List<BeanStudent> listOfAllStudents = new ArrayList<BeanStudent>();
		Connection con = DBUtil.getMysqlDBConnection();
		String sql = "SELECT * FROM student_crud";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				int sid = rs.getInt(1);
				String sname = rs.getString(2);
				String scourse = rs.getString(3);
				String shometown = rs.getString(4);
				String sgender = rs.getString(5);
				BeanStudent bs = new BeanStudent(sid, sname, scourse, shometown, sgender);
				listOfAllStudents.add(bs);
			}
		} catch (Exception e) {
			System.out.println("getAllStudent Catch: "+e);
		}
		return listOfAllStudents;
	}// Method  getAllStudents
	public void deleteStudent(int sid) {
		Connection con = DBUtil.getMysqlDBConnection();
		String deleteSql = "DELETE FROM student_crud WHERE s_id=?";
		try {
			PreparedStatement pst = con.prepareStatement(deleteSql);
			pst.setInt(1, sid);
			int result = pst.executeUpdate();
			if(result == 0) {
				System.out.println("Deletion failed");
			}else {
				System.out.println("Deletion successful");
			}
		} catch (Exception e) {
			System.out.println("deleteStudent Catch"+e);
		}
	}
	public BeanStudent getStudent(int sid) {
		BeanStudent beanStudent = null;
		Connection con = DBUtil.getMysqlDBConnection();
		String sql = "SELECT * FROM student_crud WHERE s_id=?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, sid);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {

				String sname = rs.getString("s_name");
				String scourse = rs.getString("s_course");
				String shometown = rs.getString("s_hometown");
				String sgender = rs.getString("s_gender");
				beanStudent =  new BeanStudent(sid, sname, scourse, shometown, sgender);
			}

		} catch (Exception e) {
			System.out.println("getStudent catch"+e);
		}
		return beanStudent;
	}//
	public void updateStudent(BeanStudent bs) {
		String updatesql = "UPDATE student_crud set "
				+ " s_name=?, s_course=?, s_hometown=?,s_gender=? WHERE s_id=?";
		Connection con = DBUtil.getMysqlDBConnection();
		try {
			PreparedStatement pst = con.prepareStatement(updatesql);
			pst.setString(1, bs.getSname());
			pst.setString(2, bs.getScourse());
			pst.setString(3, bs.getShometown());
			pst.setString(4, bs.getSgender());
			pst.setInt(5, bs.getSid());
			pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("updateStudent catch"+e);
		}

	}
}

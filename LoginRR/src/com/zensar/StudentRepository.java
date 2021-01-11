package com.zensar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class StudentRepository {

	public boolean loginCheck(String susername, String spassword) {
		boolean result = false;
		Connection con = DBUtil.getMysqlDBConnection();
		String check = "SELECT * FROM login_form WHERE username=?";
		try {
			PreparedStatement pst = con.prepareStatement(check);
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

}

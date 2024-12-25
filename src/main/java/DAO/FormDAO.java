package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Confact.ConnectionFactory;
import DTO.FormDTO;

public class FormDAO {
	private static String Ins="INSERT INTO details(fname,lname,gender,email,pwd,branch) VALUES(?,?,?,?,?,?)";
	public boolean saveDetails(FormDTO x) throws Exception{
		Connection con=ConnectionFactory.getConnection();
		PreparedStatement pst=con.prepareStatement(Ins);
		pst.setString(1, x.fname);
		pst.setString(2, x.lname);
		pst.setString(3, x.gender);
		pst.setString(4, x.email);
		pst.setString(5, x.pwd);
		pst.setString(6, x.branch);
		int row=pst.executeUpdate();
		return row>0;
	}
}

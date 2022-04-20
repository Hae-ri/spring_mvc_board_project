package com.javatest.MVCboard.dao;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.javatest.MVCboard.dto.BDto;

public class BDao {

	DataSource dataSource;

	public BDao() { // DB ����
		super();
		// TODO Auto-generated constructor stub
		
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<BDto> list() {
		
		ArrayList<BDto> dtos = new ArrayList<BDto>(); // dto ��ü�� �迭 ����
				
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			String query = "select * from MVC_BOARD order by bGroup desc, bStep asc"; //bGroup-��������, bStep-�������� ����
			pstmt = conn.prepareStatement(query); // sql�� ����
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int bID = rs.getInt("bId");
				String bName = rs.getString("bName");
				String bTitle = rs.getString("bTitle");
				String bContent = rs.getString("bContent");
				Timestamp bDate = rs.getTimestamp("bDate");
				int bHit = rs.getInt("bHit");
				int bGroup = rs.getInt("bGroup");
				int bStep = rs.getInt("bStep");
				int bIndent = rs.getInt("bIndent");
				
				BDto dto = new BDto(bID,bName,bTitle,bContent,bDate,bHit,bGroup,bStep,bIndent); // dto ��ü ����
				dtos.add(dto); //dto �迭�� dto ����
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) 
					rs.close();
				if(pstmt != null) 
					pstmt.close();
				if(conn != null) 
					conn.close();					
				}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return dtos;
	}
	
	
	
}

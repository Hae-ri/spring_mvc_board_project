package com.javatest.MVCboard.dao;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	
	public void write(String bName, String bTitle, String bContent) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String query ="INSERT INTO mvc_board(bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) values (mvc_board_seq.nextval, ?, ?, ?, 0, mvc_board_seq.currval, 0, 0)";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(query); // sql�� ����
			
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			
			int dbFlag = pstmt.executeUpdate(); // �����ϸ� 1 ��ȯ
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) pstmt.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public BDto contentView(String strId) {
		
		upHit(strId);
		
		BDto dto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			String query = "select * from MVC_BOARD where bId=?";
			pstmt = conn.prepareStatement(query); // sql�� ����
			pstmt.setInt(1, Integer.parseInt(strId)); // ���ڿ��� strID�� int�� ��ȯ
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
				
				dto = new BDto(bID,bName,bTitle,bContent,bDate,bHit,bGroup,bStep,bIndent); // dto ��ü ����
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
		return dto;
	}
	
	public void modify(String bId, String bName, String bTitle, String bContent) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String query ="update mvc_board set bName=?, bTitle=?, bContent=? where bID=?";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(query); // sql�� ����
			
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setInt(4, Integer.parseInt(bId));
			
			int dbFlag = pstmt.executeUpdate(); // �����ϸ� 1 ��ȯ
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) pstmt.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void delete(String bId) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String query ="delete from mvc_board where bID=?";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(query); // sql�� ����
			
			pstmt.setInt(1, Integer.parseInt(bId));
			
			int dbFlag = pstmt.executeUpdate(); // �����ϸ� 1 ��ȯ
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) pstmt.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public BDto reply_view(String strId) {
		
		BDto dto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			String query = "select * from MVC_BOARD where bId=?";
			pstmt = conn.prepareStatement(query); // sql�� ����
			pstmt.setInt(1, Integer.parseInt(strId)); // ���ڿ��� strID�� int�� ��ȯ
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
				
				dto = new BDto(bID,bName,bTitle,bContent,bDate,bHit,bGroup,bStep,bIndent); // dto ��ü ����
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
		return dto;
	}

	public void reply(String bId, String bName, String bTitle, String bContent, String bGroup, String bStep, String bIndent) {
		
		replyShape(bGroup,bStep);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String query ="INSERT INTO mvc_board(bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) values (mvc_board_seq.nextval, ?, ?, ?, 0, ?, ?, ?)";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(query); // sql�� ����
			
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setInt(4, Integer.parseInt(bGroup)); // ������ bGroup�� �״�� ������
			pstmt.setInt(5, Integer.parseInt(bStep)+1);
			pstmt.setInt(6, Integer.parseInt(bIndent)+1);
			
			int dbFlag = pstmt.executeUpdate(); // �����ϸ� 1 ��ȯ
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) pstmt.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void replyShape(String strGroup, String strStep) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String query ="update mvc_board set bStep = bStep+1 where bGroup = ? and bStep > ?";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(query); // sql�� ����
			
			pstmt.setInt(1, Integer.parseInt(strGroup)); // ������ bGroup�� �״�� ������
			pstmt.setInt(2, Integer.parseInt(strStep));

			
			int dbFlag = pstmt.executeUpdate(); // �����ϸ� 1 ��ȯ
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) pstmt.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void upHit(String strId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String query ="update mvc_board set bHit = bHit + 1 where bId = ?";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(query); // sql�� ����
			
			pstmt.setInt(1, Integer.parseInt(strId));

			int dbFlag = pstmt.executeUpdate(); // �����ϸ� 1 ��ȯ
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) pstmt.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

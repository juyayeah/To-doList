package board;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	
	public BoardDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/univers?useUnicode=true&CharacterEncoding=utf8",
					"root",
					"1234");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<BoardVO> listBoard() {
		List<BoardVO> list = new ArrayList<BoardVO>();
		list.clear();
		try {
			String query = "SELECT * FROM board ORDER BY tdDate";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int bno = rs.getInt("bno");
				String tdText = rs.getString("tdText");
				Date tdDate = rs.getDate("tdDate");
				BoardVO vo = new BoardVO();
				vo.setBno(bno);
				vo.setTdText(tdText);
				vo.setTdDate(tdDate);
				list.add(vo);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void addBoard(BoardVO boardVO) {
		try {
			String tdText = boardVO.getTdText();
			java.util.Date date = boardVO.getTdDate();
			java.sql.Date tdDate = new java.sql.Date(date.getTime());
			String query = "INSERT INTO board (tdtext, tddate) VALUES (?,?)";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, tdText);
			pstmt.setDate(2, tdDate);
			pstmt.executeUpdate();
			pstmt.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delBoard(int bno) {
		try {
			String query = "DELETE FROM board WHERE bno=?";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bno);
			pstmt.executeUpdate();
			pstmt.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}

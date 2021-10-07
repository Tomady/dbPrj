package co.dy.dbPrj.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.dy.dbPrj.DataSource;

public class DevServiceImpl extends DataSource {
	private PreparedStatement psmt;
	private ResultSet rs;
	
//	public List<DevVO> selectList() {
//		DevVO vo;
//		List<DevVO> list = new ArrayList<DevVO>();
//		
//		return list;
//	}
	
	public void selectList() {
		String sql = "select * from dev";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();	//실행구문
			
			while(rs.next()) {
				System.out.print("ID: " + rs.getInt("id") + ", ");
				System.out.print("이름: " + rs.getString("name") + ", ");
				System.out.print("주소: " + rs.getString("address") + ", ");
				System.out.println("나이: " + rs.getInt("age"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}

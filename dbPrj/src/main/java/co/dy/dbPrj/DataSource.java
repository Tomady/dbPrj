package co.dy.dbPrj;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource {
	private String driver; // 사용할 jdbc 드라이버
	private String url; // DBMS가 위치한 주소
	private String user; // 접속할 DB계정
	private String password; // DB계정 패스워드

	public Connection conn; // java에서 DBMS에 연결하는 연결 객체

	public DataSource() {
		getDBproperties(); // 외부 properties 파일을 읽어서 

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("DB연결 성공.");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("DB연결 실패.");
		}
	}

	private void getDBproperties() {
		File path = new File("src/main/resources/db.properties");	//파일을 다루는 객체
		Properties properties = new Properties();

		try {
			FileReader file = new FileReader(path);
			properties.load(file);

			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

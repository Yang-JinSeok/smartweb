import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class insert {
	public static void main(String[] args) {
		String Driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://127.0.0.1:3306/haksa?useUnicode=true&amp;characterEncoding=euckr";
		String user="root";
		String password="1111";
		String aaa;
		String sql;
		
		
		Connection conn=null;
		Statement stmt=null;

	

		try {
				Class.forName(Driver);
				conn=DriverManager.getConnection(url, user, password);
				stmt=conn.createStatement();

			System.out.println("post 테이블에 레코드값을 입력하세요.");					//이 메세지를 봐야 여기서 입력해야하는구나 안다 *사용자 편의를 위해
				
			sql="INSERT INTO post VALUES('209-018', '미남동', '부산시 동래구 미남동', '051')";		//쿼리는 대문자로 적어두는 습관을 가지자 오타확인을위해
			
			
			stmt.executeUpdate(sql);
			
			
		
			
			stmt.close();
			
			conn.close();
		}catch(Exception e){
			System.out.println("아 이러면 곤란한데 " +e);
		}


	}
}

import java.sql.Connection;			//import=불러오기  
import java.sql.DriverManager;		//컨트롤 쉬프트 o 누르면 자동으로 입력됨
import java.sql.ResultSet;
import java.sql.Statement;

			
public class dbconn {
	public static void main(String ar[]) {
		String Driver="com.mysql.jdbc.Driver";  //패키지 경로
		String url="jdbc:mysql://localhost:3306/haksa?useUnicode=true&amp;characterEncoding=euckr";
			String user="root";
			String pwd="1111";			
			String sql;
			
			String post_no, dong, address, ddd;
			
			Connection conn=null;			//DB 연결
			Statement stmt=null;			//입력
			ResultSet rs=null;				//결과 호출
		
		try {
			Class.forName(Driver);
			conn=DriverManager.getConnection(url, user, pwd);
			stmt=conn.createStatement();
			sql="select * from post";
			
			System.out.println("post_no\t dong\t\t address\t\t ddd\t\t");
			System.out.println("=====================================");
			rs=stmt.executeQuery(sql);
			

			while(rs.next()) {					//ages테이블에 정보가 15개 있기때문에 반복문
				post_no=rs.getString("post_no");		//getString - DB에서 값을 가져온다는 것
				dong=rs.getString("post_dong");	
				address=rs.getString("post_address");
				ddd=rs.getString("ddd");
				System.out.printf("%s\t %s\t\t %s\t\t %s\t\t", post_no, dong, address, ddd);	
				System.out.println();
				//printf - c?  %s 문자 %d 숫자  
			}
			
//			System.out.println("DB연결 성공");
			
			rs.close();					//마지막에 쓴걸 먼저 닫아줘야된다
			stmt.close();				
			conn.close();				
		}catch(Exception e){
			System.out.println("DB연결 실패" +e);
		}
	}
}

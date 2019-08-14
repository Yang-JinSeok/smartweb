import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class update {
	public static void main(String[] args) {
		String Driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/haksa?useUnicode=true&amp;characterEncoding=euckr";
		String user="root";
		String password="1111";

		Connection conn=null;
		Statement stmt=null;
		
		String sql, dong, postno;
		
		try {
			Class.forName(Driver);
			conn=DriverManager.getConnection(url, user, password);
			stmt=conn.createStatement();
			Scanner sc=new Scanner(System.in);
			System.out.println("post테이블 레코드값 변경하기");
			System.out.print("변경할 동이름 : ");
			dong=sc.nextLine(); //변경동
			
			System.out.print("변경할 post_no : ");
			postno=sc.nextLine();
			
			sql="UPDATE post SET post_dong='"+dong+"' WHERE post_no='"+postno+"'";  //'"+a+"'   
			System.out.println("변경완료");
			
			stmt.executeUpdate(sql);
			stmt.close();
			conn.close();
			
		}catch(Exception e){
			System.out.println("오류 발생" +e);
			
		}
	}
}

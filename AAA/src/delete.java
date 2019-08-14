import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class delete {
public static void main(String[] args) {
	String Driver="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/haksa?useUnicode=true&amp;characterEncoding=euckr";
	String user="root";
	String password="1111";
	
	Connection conn=null;
	Statement stmt=null;
	
	String sql, postno;
	
	try {
		Class.forName(Driver);
		conn=DriverManager.getConnection(url, user, password);
		stmt=conn.createStatement();
		Scanner sc=new Scanner(System.in);
		System.out.println("컬럼 삭제하기");
		System.out.print("삭제할 컴럼의 post_no : ");
		postno=sc.nextLine();
		
		sql="DELETE FROM post WHERE post_no='"+postno+"'";
		System.out.println("삭제완료");
		
		stmt.executeUpdate(sql);
		stmt.close();
		conn.close();
		
	}catch(Exception e){
		System.out.println("실행오류 : " +e);	
	}
	
	
}
}

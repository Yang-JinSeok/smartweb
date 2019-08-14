import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class prepred_insert {
	public static void main(String[] args) {
		String Driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/haksa?useUncode=true&amp;characterEncoding=euckr";
		String user="root";
		String password="1111";
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		String sql;
		String postno, dong, address;
		
		try {
			Class.forName(Driver);
			conn=DriverManager.getConnection(url, user, password);
			Scanner sc=new Scanner(System.in);		
			System.out.println("post테이블의 레코드값 입력하기");
			
			System.out.print("post_no :");
			postno=sc.nextLine();
			System.out.print("dong :");
			dong=sc.nextLine();
			System.out.print("address :");
			address=sc.nextLine();
			
			sql="INSERT INTO post(post_no, post_dong, post_address) VALUES(?, ?, ?)";
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, postno);
			pstmt.setString(2, dong);
			pstmt.setString(3, address);
			
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
			conn.close();
			
		}catch(Exception e){
			System.out.println("예외:"+e);
		}
		
	}
}

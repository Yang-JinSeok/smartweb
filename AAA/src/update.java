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
			System.out.println("post���̺� ���ڵ尪 �����ϱ�");
			System.out.print("������ ���̸� : ");
			dong=sc.nextLine(); //���浿
			
			System.out.print("������ post_no : ");
			postno=sc.nextLine();
			
			sql="UPDATE post SET post_dong='"+dong+"' WHERE post_no='"+postno+"'";  //'"+a+"'   
			System.out.println("����Ϸ�");
			
			stmt.executeUpdate(sql);
			stmt.close();
			conn.close();
			
		}catch(Exception e){
			System.out.println("���� �߻�" +e);
			
		}
	}
}

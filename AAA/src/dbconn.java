import java.sql.Connection;			//import=�ҷ�����  
import java.sql.DriverManager;		//��Ʈ�� ����Ʈ o ������ �ڵ����� �Էµ�
import java.sql.ResultSet;
import java.sql.Statement;

			
public class dbconn {
	public static void main(String ar[]) {
		String Driver="com.mysql.jdbc.Driver";  //��Ű�� ���
		String url="jdbc:mysql://localhost:3306/haksa?useUnicode=true&amp;characterEncoding=euckr";
			String user="root";
			String pwd="1111";			
			String sql;
			
			String post_no, dong, address, ddd;
			
			Connection conn=null;			//DB ����
			Statement stmt=null;			//�Է�
			ResultSet rs=null;				//��� ȣ��
		
		try {
			Class.forName(Driver);
			conn=DriverManager.getConnection(url, user, pwd);
			stmt=conn.createStatement();
			sql="select * from post";
			
			System.out.println("post_no\t dong\t\t address\t\t ddd\t\t");
			System.out.println("=====================================");
			rs=stmt.executeQuery(sql);
			

			while(rs.next()) {					//ages���̺� ������ 15�� �ֱ⶧���� �ݺ���
				post_no=rs.getString("post_no");		//getString - DB���� ���� �����´ٴ� ��
				dong=rs.getString("post_dong");	
				address=rs.getString("post_address");
				ddd=rs.getString("ddd");
				System.out.printf("%s\t %s\t\t %s\t\t %s\t\t", post_no, dong, address, ddd);	
				System.out.println();
				//printf - c?  %s ���� %d ����  
			}
			
//			System.out.println("DB���� ����");
			
			rs.close();					//�������� ���� ���� �ݾ���ߵȴ�
			stmt.close();				
			conn.close();				
		}catch(Exception e){
			System.out.println("DB���� ����" +e);
		}
	}
}

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

			System.out.println("post ���̺� ���ڵ尪�� �Է��ϼ���.");					//�� �޼����� ���� ���⼭ �Է��ؾ��ϴ±��� �ȴ� *����� ���Ǹ� ����
				
			sql="INSERT INTO post VALUES('209-018', '�̳���', '�λ�� ������ �̳���', '051')";		//������ �빮�ڷ� ����δ� ������ ������ ��ŸȮ��������
			
			
			stmt.executeUpdate(sql);
			
			
		
			
			stmt.close();
			
			conn.close();
		}catch(Exception e){
			System.out.println("�� �̷��� ����ѵ� " +e);
		}


	}
}

package taggr;
//Imports
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

	Connection connection = null;
	Statement statement = null;
	ResultSet resultset;
	
	public DBConnection(){
		try {
			Class.forName("org.h2.Driver");
			try {
				connection = DriverManager.getConnection("jdbc:h2:C:\\Users\\A\\workspace\\taggr\\lib\\db", "sa", "");
				statement = connection.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	void addNewTag(String tagName) throws SQLException{
		String sql = "INSERT INTO TAGS" + "VALUES(" + tagName.hashCode() + ",'" + tagName.toString() + "')";
	
		System.out.println("Tag name: " + tagName.toString());
		resultset = statement.executeQuery(sql);
		//System.out.println();
		//resultset = statement.executeQuery("INSERT INTO FILETAGDB.TAGS(ID,TAGNAME) VALUES (" + tagName.hashCode() + "," + tagName +")");
	}
	
	void getAllTags() throws SQLException{
		resultset = statement.executeQuery("SELECT * FROM TAGS");
		while(resultset.next()){
			System.out.println("Tag name: " + resultset.getCursorName());
			System.out.println("To string: " + resultset.toString());
			System.out.println("Hash code: " + resultset.hashCode());
		}
	}
}

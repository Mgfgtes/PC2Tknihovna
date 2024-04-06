package knihovna;

import java.sql.*;

public class Connect {
	private Connection conn; 
	
	
	
	public Connect() {
		super();
		System.out.println("Pripojeni k databazi" + connect());
	}
	public boolean connect() { 
		conn= null; 
	    try {
	    	conn = DriverManager.getConnection("jdbc:sqlite:KnihovnaDB.db");                       
	    } 
	    catch (SQLException e) { 
	       	System.out.println(e.getMessage());
		    return false;
	    }
	    return true;
	}
	
	public boolean createTable()
	{
	     if (conn==null)
	           return false;
	    String sql = "CREATE TABLE IF NOT EXISTS knihovna (" + "nazev varchar NOT NULL PRIMARY KEY," + "autor varchar NOT NULL,"+ "rok smallint, " + 
	           "roman bit, " + "ucebnice bit, " + "zanr varchar" + "rocnik tinyint, " + ");";
	    try{
	            Statement stmt = conn.createStatement(); 
	            stmt.execute(sql);
	            return true;
	    } 
	    catch (SQLException e) {
	    System.out.println(e.getMessage());
	    }
	    return false;
	}
	
	public void insertRecord(Kniha kniha) {
        String sql = "INSERT INTO zamestnanci(nazev,autor,rok,roman,ucebnice,zanr,rocnik) VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql); 
            pstmt.setString(1, kniha.getNazev());
            pstmt.setString(2, kniha.getAutor());
            pstmt.setInt(3, kniha.getRok());
            pstmt.setBoolean(4, kniha.instanceOfRoman(kniha));
            pstmt.setBoolean(5, kniha.instanceOfUcebnice(kniha));
            pstmt.setString(6, (Roman)kniha.getZanr);
            pstmt.setInt(7, (Ucebnice)kniha.getRocnik);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
	
	public void disconnect() { 
		if (conn != null) {
			try {
		    	conn.close();
		    }
	        catch (SQLException ex) { 
	        	System.out.println(ex.getMessage());
	        }
		}
	}
}

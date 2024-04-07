package knihovna;

import java.sql.*;

public class Connect {
	private Connection conn; 
	
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
	    		"dostupnost bit, " + "roman bit, " + "ucebnice bit, " + "zanr varchar," + "rocnik tinyint" + ");";
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
	
	public DatabazeKnih selectAll(){
		DatabazeKnih mojeDB = new DatabazeKnih();
        String sql = "SELECT nazev,autor,rok,dostupnost,roman,ucebnice,zanr,rocnik FROM knihovna";
        try {
        	Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);
            while (rs.next()) {
            	if (rs.getBoolean("roman")) {
					mojeDB.addRoman(rs.getString("nazev"), rs.getString("autor"), rs.getInt("rok"), 
							Roman.setZanrByString(rs.getString("zanr")), rs.getBoolean("dostupnost"));
				}
            	if (rs.getBoolean("ucebnice")) {
					mojeDB.addUcebnice(rs.getString("nazev"), rs.getString("autor"), rs.getInt("rok"), 
							rs.getInt("rocnik"), rs.getBoolean("dostupnost"));
				}
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return mojeDB;
	}
	
	public void insertRecord(Kniha kniha) {
        String sql = "INSERT INTO knihovna(nazev,autor,rok,dostupnost,roman,ucebnice,zanr,rocnik) VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql); 
            pstmt.setString(1, kniha.getNazev());
            pstmt.setString(2, kniha.getAutor());
            pstmt.setInt(3, kniha.getRok());
            pstmt.setBoolean(4, kniha.getDostupnost());
            pstmt.setBoolean(5, kniha.instanceOfRoman(kniha));
            pstmt.setBoolean(6, kniha.instanceOfUcebnice(kniha));
            if(kniha.instanceOfRoman(kniha)) {
            	Roman roman = (Roman) kniha;
            	pstmt.setString(7, roman.getZanr().toString());
            	pstmt.setInt(8, 0);
            }
            
            if (kniha.instanceOfUcebnice(kniha)) {
				Ucebnice ucebnice = (Ucebnice) kniha;
				pstmt.setString(7, null);
				pstmt.setInt(8, ucebnice.getRocnik());
			}
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
	
	public void delete() {
        String sql = "DROP TABLE knihovna";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
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

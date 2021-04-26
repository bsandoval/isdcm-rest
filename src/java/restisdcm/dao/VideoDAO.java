package restisdcm.dao;

import java.sql.*;
import restisdcm.jdbc.DataSource;

public class VideoDAO {
    
    public void incrementarReproducciones(int id) throws Exception{
        try {
            int reproducciones = getReproducciones(id);
            System.out.println("Reproducciones del video:");
            System.out.println(reproducciones);
            
            DataSource ds = DataSource.getInstance();
            PreparedStatement pstmt = ds.getConnection().prepareStatement("UPDATE MYDB.VIDEO SET REPRODUCCIONES = ? WHERE ID = ?");
            pstmt.setInt(1, ++reproducciones);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            ds.getConnection().close();  
        }
        catch(SQLException e){ 
            System.out.println(e);
            throw new Exception("Error al incrementar reproducciones");
        }
    }
    
    private int getReproducciones(int id){
        int reproducciones = 0;
        try{
            DataSource ds = DataSource.getInstance();
            String sql = "SELECT REPRODUCCIONES FROM MYDB.VIDEO WHERE ID = ?";
            PreparedStatement statement = ds.getConnection().prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet result = statement.executeQuery();
            if (result.next()) {
                reproducciones = result.getInt("reproducciones");
            }
            ds.getConnection().close();
        }
        catch(SQLException e){ System.out.println(e);}
        return reproducciones;
    }
    
    public boolean checkVideoExists(int id){
        try{
            DataSource ds = DataSource.getInstance();
            String sql = "SELECT COUNT(id) FROM MYDB.VIDEO WHERE ID = ?";
            PreparedStatement statement = ds.getConnection().prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet result = statement.executeQuery();
            
            int count = 0;
            if (result.next()) {
                count = result.getInt(1);
            }
            ds.getConnection().close();
            
            return count > 0;
        }
        catch(SQLException e){ System.out.println(e);}
        return false;
    }
}

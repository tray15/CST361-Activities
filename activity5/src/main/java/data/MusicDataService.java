package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Album;

public class MusicDataService implements DataAccessInterface {
	
	private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3307/music";
	private static final String ID = "root";
	private static final String PASS = "root";
	
	private static final String DELETE = "DELETE FROM album WHERE ID=?";
	private static final String FIND_ALL = "SELECT * FROM album ORDER BY ID";
	private static final String FIND_BY = "SELECT * FROM album WHERE ID=? OR TITLE=? OR ARTIST=? OR YEAR=?";
	private static final String FIND_BY_ID = "SELECT * FROM album WHERE id=?";
	private static final String FIND_BY_TITLE = "SELECT * FROM album WHERE TITLE=?";
	private static final String INSERT = "INSERT INTO album(TITLE, ARTIST, YEAR) VALUES(?, ?, ?)";
	private static final String UPDATE = "UPDATE album SET TITLE=?, ARTIST=?, YEAR=? WHERE ID=?";

	
	public Album create(Album album) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, album.getTitle());
			stmt.setString(2, album.getArtist());
			stmt.setInt(3, album.getYear());
			
			int result = stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			
			if (rs.next()) {
				album.setId(rs.getInt(1));
			}
			
			return this.findBy(album);
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(stmt);
			close(conn);
		}
	}


	@Override
	public Album findBy(Album album) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(FIND_BY);
			stmt.setInt(1, album.getId());
			stmt.setString(2,  album.getTitle());
			stmt.setString(3,  album.getArtist());
			stmt.setInt(4,  album.getYear());
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				Album found = new Album();
				found.setId(rs.getInt("ID"));
				found.setTitle(rs.getString("TITLE"));
				found.setArtist(rs.getString("ARTIST"));
				found.setYear(rs.getInt("YEAR"));
				
				return found;
			} else {
				return null;
			}
		} catch (SQLException e) {
			 e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(stmt);
			close(conn);
		}
	}
	
	private Connection getConnection() {
		try {
//			Class.forName(DRIVER_NAME);
			return DriverManager.getConnection(DB_URL, ID, PASS);
		} catch (Exception e) {
			// e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	private static void close(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}
	
	private static void close(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}
}

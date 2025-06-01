package com.example.dao;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.example.model.Teacher;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class LoginDAO extends DBConnect{
	public void addLogin(Login login) {
	    String sql = "INSERT INTO login (id, username, password, deleted, user_id) VALUES (?, ?, ?, ?, ?)";
	    
	    try (PreparedStatement pst = conn.prepareStatement(sql)) {
	        pst.setString(1, login.getId());
	        pst.setString(2, login.getUsername());
	        pst.setString(3, login.getPassword());
	        pst.setBoolean(4, login.isDeleted());
	        pst.setString(5, login.getUsers().getId());
	        
	        pst.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	public void updateLogin(Login login) {
		String sql = "UPDATE login SET username = ?, password = ?, deleted = ? WHERE id = ?";

		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setString(1, login.getUsername());
			pst.setString(2, login.getPassword());
			pst.setBoolean(3, login.isDeleted());
			pst.setString(5, login.getId());

			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public Teacher login(String username, String password) {
		String sql = "SELECT u.*, l.password FROM login l JOIN users u ON l.user_id = u.id WHERE l.username = ? AND l.deleted = 0 AND u.lock_status = 0 AND u.deleted = 0";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				String hashedPassword = rs.getString("password");
				BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), hashedPassword);
				if (result.verified) {
					return new Teacher(
							rs.getString("id"),
							rs.getString("name"),
							rs.getString("phone"),
							rs.getString("email"),
							rs.getString("address"),
							rs.getDate("date_of_birth"),
							rs.getString("type"),
							rs.getString("type_position"),
							rs.getDate("starttime"),
							rs.getDate("endtime"),
							rs.getDate("create_at"),
							rs.getDate("lastmodified"),
							rs.getBoolean("deleted"),
							rs.getBoolean("lock_status")
					);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	public Login getLoginByUserId(String userId) {
		String sql = "SELECT * FROM login WHERE user_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Teacher users = new UserDAO().findById(rs.getString("user_id"));
				Login login = new Login();
				login.setId(rs.getString("id"));
				login.setUsername(rs.getString("username"));
				login.setPassword(rs.getString("password"));
				login.setDeleted(rs.getBoolean("deleted"));
				login.setUsers(users);
				return login;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public void updatePassByUserId(String userId, String password) {
		String sql = "UPDATE login SET password = ? WHERE user_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, userId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

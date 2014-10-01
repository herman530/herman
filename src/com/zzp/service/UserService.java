package com.zzp.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zzp.model.User;
import com.zzp.util.DB;

public class UserService {
	public void add(User c) {
		Connection conn = DB.createConn();
		String sql = "insert into _user values (null, ?, ?)";
		PreparedStatement ps = DB.prepare(conn, sql);
		try {
			ps.setString(1, c.getName());
			ps.setString(2, c.getDescription());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(ps);
		DB.close(conn);
	}

	public List<User> list() throws SQLException {
		Connection conn = DB.createConn();
		String sql = "select * from _user";
		PreparedStatement ps = DB.prepare(conn, sql);
		List<User> users = new ArrayList<User>();
		try {
			ResultSet rs = ps.executeQuery();
			User c = null;
			while (rs.next()) {
				c = new User();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setDescription(rs.getString("description"));
				users.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw (e);
		}
		DB.close(ps);
		DB.close(conn);
		return users;
	}

	public void delete(User c) {
		deleteById(c.getId());
	}

	public void deleteById(int id) {
		Connection conn = DB.createConn();
		String sql = "delete from _user where id = ?";
		PreparedStatement ps = DB.prepare(conn, sql);
		try {
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(ps);
		DB.close(conn);
	}

	public void update(User c) {
		Connection conn = DB.createConn();
		String sql = "update _user set name = ?, description = ? where id = ?";
		PreparedStatement ps = DB.prepare(conn, sql);
		try {
			ps.setString(1, c.getName());
			ps.setString(2, c.getDescription());
			ps.setInt(3, c.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(ps);
		DB.close(conn);
	}

	public User loadById(int id) {
		Connection conn = DB.createConn();
		String sql = "select * from _user where id = ?";
		PreparedStatement ps = DB.prepare(conn, sql);
		User c = null;
		try {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				c = new User();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setDescription(rs.getString("description"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(ps);
		DB.close(conn);
		return c;
	}
}

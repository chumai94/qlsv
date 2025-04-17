package com.example.dao;

import com.example.model.Activity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ActivityDAO extends DBConnect{
    public List<Activity> getAll() {
        List<Activity> activityList = new ArrayList<>();
        String sql = "SELECT * FROM activity WHERE deleted = 0";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Activity activity = new Activity();
                activity.setId(rs.getString("id"));
                activity.setActivity(rs.getString("activity"));
                activity.setDescription(rs.getString("description"));
                activity.setIp(rs.getString("ip"));
                activity.setCreateAt(rs.getDate("created_at"));
                activity.setLasrmodified(rs.getDate("lastmodified"));
                activity.setDeleted(rs.getBoolean("deleted"));
                activityList.add(activity);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return activityList;
    }

    public Activity findById(String id) {
        String sql = "SELECT * FROM activity WHERE id = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Activity activity = new Activity();
                activity.setId(rs.getString("id"));
                activity.setActivity(rs.getString("activity"));
                activity.setDescription(rs.getString("description"));
                activity.setIp(rs.getString("ip"));
                activity.setCreateAt(rs.getDate("created_at"));
                activity.setLasrmodified(rs.getDate("lastmodified"));
                activity.setDeleted(rs.getBoolean("deleted"));
                return activity;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void add(Activity activity, String userId) {
        String sql = "INSERT INTO activity (id, activity, description, ip, created_at, lastmodified, deleted, user_id) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, activity.getId());
            ps.setString(2, activity.getActivity());
            ps.setString(3, activity.getDescription());
            ps.setString(4, activity.getIp());
            ps.setDate(5, new java.sql.Date(activity.getCreateAt().getTime()));
            ps.setDate(6, new java.sql.Date(activity.getLasrmodified().getTime()));
            ps.setBoolean(7, activity.isDeleted());
            ps.setString(8, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Activity activity) {
        String sql = "UPDATE activity SET activity = ?, description = ?, ip = ?, lastmodified = ?, deleted = ? WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, activity.getActivity());
            ps.setString(2, activity.getDescription());
            ps.setString(3, activity.getIp());
            ps.setDate(4, new java.sql.Date(activity.getLasrmodified().getTime()));
            ps.setBoolean(5, activity.isDeleted());
            ps.setString(6, activity.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String activityId) {
        String sql = "UPDATE activity SET deleted = 1 WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, activityId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

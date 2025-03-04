package com.ig.dao;

import com.ig.model.Scholar;
import com.ig.exception.ScholarNotFoundException;
import com.ig.util.DbUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ScholarDao {

    public void addScholar(Scholar scholar) throws SQLException {
        String query = "INSERT INTO Scholar (Rollno, Name, Email, Mobile) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = DbUtil.getConnection().prepareStatement(query)) {
            stmt.setInt(1, scholar.getScholarId());
            stmt.setString(2, scholar.getName());
            stmt.setString(3, scholar.getEmail());
            stmt.setString(4, scholar.getMobile());
            stmt.executeUpdate();
        }
    }

    public List<Scholar> listAllScholars() throws SQLException {
        List<Scholar> scholars = new ArrayList<>();
        String query = "SELECT * FROM Scholar";
        try (Statement stmt = DbUtil.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                scholars.add(new Scholar(rs.getInt("Rollno"), rs.getString("Name"), rs.getString("Email"), rs.getString("Mobile")));
            }
        }
        return scholars;
    }

    public Scholar getOneScholar(int scholarId) throws SQLException, ScholarNotFoundException {
        String query = "SELECT * FROM Scholar WHERE Rollno = ?";
        try (PreparedStatement stmt = DbUtil.getConnection().prepareStatement(query)) {
            stmt.setInt(1, scholarId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Scholar(rs.getInt("Rollno"), rs.getString("Name"), rs.getString("Email"), rs.getString("Mobile"));
            } else {
                throw new ScholarNotFoundException("Scholar with ID " + scholarId + " not found.");
            }
        }
    }

    public void updateScholarEmail(int scholarId, String newEmail) throws SQLException, ScholarNotFoundException {
        String query = "UPDATE Scholar SET Email = ? WHERE Rollno = ?";
        try (PreparedStatement stmt = DbUtil.getConnection().prepareStatement(query)) {
            stmt.setString(1, newEmail);
            stmt.setInt(2, scholarId);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated == 0) {
                throw new ScholarNotFoundException("Scholar with ID " + scholarId + " not found.");
            }
        }
    }

    public void deleteScholarById(int scholarId) throws SQLException, ScholarNotFoundException {
        String query = "DELETE FROM Scholar WHERE Rollno = ?";
        try (PreparedStatement stmt = DbUtil.getConnection().prepareStatement(query)) {
            stmt.setInt(1, scholarId);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted == 0) {
                throw new ScholarNotFoundException("Scholar with ID " + scholarId + " not found.");
            }
        }
    }
}

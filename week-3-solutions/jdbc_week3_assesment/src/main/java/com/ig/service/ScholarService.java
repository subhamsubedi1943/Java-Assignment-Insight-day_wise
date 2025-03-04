package com.ig.service;

import com.ig.dao.ScholarDao;
import com.ig.model.Scholar;
import com.ig.exception.ScholarNotFoundException;
import java.sql.SQLException;

public class ScholarService {
    private ScholarDao scholarDao;

    public ScholarService() {
        scholarDao = new ScholarDao();
    }

    public void addHardcodedScholars() throws SQLException {
        try {
            scholarDao.getOneScholar(101);
        } catch (ScholarNotFoundException e) {
            scholarDao.addScholar(new Scholar(101, "Alice Johnson", "alice@example.com", "9876543210"));
            System.out.println("✅ Scholar 101 added.");
        }

        try {
            scholarDao.getOneScholar(102);
        } catch (ScholarNotFoundException e) {
            scholarDao.addScholar(new Scholar(102, "Bob Smith", "bob@example.com", "8765432109"));
            System.out.println("✅ Scholar 102 added.");
        }
    }

    // Existing methods
    public void addScholar(Scholar scholar) throws SQLException {
        scholarDao.addScholar(scholar);
    }

    public void deleteScholarById(int scholarId) throws SQLException, ScholarNotFoundException {
        scholarDao.deleteScholarById(scholarId);
    }

    public void updateScholarEmail(int scholarId, String newEmail) throws SQLException, ScholarNotFoundException {
        scholarDao.updateScholarEmail(scholarId, newEmail);
    }

    public Scholar getOneScholar(int scholarId) throws SQLException, ScholarNotFoundException {
        return scholarDao.getOneScholar(scholarId);
    }

    public java.util.List<Scholar> listAllScholars() throws SQLException {
        return scholarDao.listAllScholars();
    }
}

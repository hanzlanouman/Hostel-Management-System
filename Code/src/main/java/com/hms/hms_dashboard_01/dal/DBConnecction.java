package com.hms.hms_dashboard_01.dal;

import java.sql.Connection;

public interface DBConnecction {
    public Connection getConnection();
    public void closeConnection(Connection conn);

}

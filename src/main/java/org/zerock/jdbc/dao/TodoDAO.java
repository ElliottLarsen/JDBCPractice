package org.zerock.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TodoDAO {

    String now = null;
    public String getTime() {
        try (Connection connection = ConnectionUtil.INSTANCE.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT now()");
        ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            resultSet.next();
            now = resultSet.getString(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }
}

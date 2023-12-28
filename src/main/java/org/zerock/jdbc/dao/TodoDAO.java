package org.zerock.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import lombok.Cleanup;

public class TodoDAO {
    public String getTime() throws Exception {
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement("SELECT now()");
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();

        String now = resultSet.getString(1);

        return now;
    }
}

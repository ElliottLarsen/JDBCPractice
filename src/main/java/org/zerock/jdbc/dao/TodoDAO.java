package org.zerock.jdbc.dao;

import org.zerock.jdbc.domain.TodoVO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import lombok.Cleanup;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;

public class TodoDAO {
    public String getTime() throws Exception {
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement("SELECT now()");
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();

        String now = resultSet.getString(1);

        return now;
    }

    public void insert(TodoVO vo) throws Exception {
        String sqlQuery = "INSERT INTO tbl_todo (title, dueDate, finished) values (?, ?, ?)";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

        preparedStatement.setString(1, vo.getTitle());
        preparedStatement.setDate(2, Date.valueOf(vo.getDueDate()));
        preparedStatement.setBoolean(3, vo.isFinished());

        preparedStatement.executeUpdate();

    }

    public List<TodoVO> selectAll() throws Exception {
        String sqlQuery = "SELECT * FROM tbl_todo";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        List<TodoVO> list = new ArrayList<>();

        while (resultSet.next()) {
            TodoVO vo = TodoVO.builder()
                    .tno(resultSet.getLong("tno"))
                    .title(resultSet.getString("title"))
                    .dueDate(resultSet.getDate("dueDate").toLocalDate())
                    .finished(resultSet.getBoolean("finished"))
                    .build();

            list.add(vo);
        }

        return list;
    }

    public TodoVO selectOne(Long tno) throws Exception {
        String sqlQuery = "SELECT * FROM tbl_todo WHERE tno = ?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setLong(1, tno);
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();

        TodoVO vo = TodoVO.builder()
                .tno(resultSet.getLong("tno"))
                .title(resultSet.getString("title"))
                .dueDate(resultSet.getDate("dueDate").toLocalDate())
                .finished(resultSet.getBoolean("finished"))
                .build();

        return vo;
    }

    public void deleteOne(Long tno) throws Exception {
        String sqlQuery = "DELETE FROM tbl_todo WHERE tno = ?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setLong(1, tno);
        preparedStatement.executeUpdate();
    }

    public void updateOne(TodoVO todoVo) throws Exception {
        String sqlQuery = "UPDATE tbl_todo SET title = ?, dueDate = ?, finished = ? WHERE tno = ?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, todoVo.getTitle());
        preparedStatement.setDate(2, Date.valueOf(todoVo.getDueDate()));
        preparedStatement.setBoolean(3, todoVo.isFinished());
        preparedStatement.setLong(4, todoVo.getTno());

        preparedStatement.executeUpdate();
    }
}

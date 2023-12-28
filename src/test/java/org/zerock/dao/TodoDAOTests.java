package org.zerock.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.jdbc.dao.TodoDAO;

public class TodoDAOTests {

    private TodoDAO todoDAO;

    @BeforeEach
    public void createTodoDAO() {
        todoDAO = new TodoDAO();
    }

    @Test
    public void testTime() throws Exception {
        System.out.println(todoDAO.getTime());
    }
}

package org.zerock.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.jdbc.dao.TodoDAO;
import org.zerock.jdbc.domain.TodoVO;

import java.time.LocalDate;

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

    @Test
    public void testInsert() throws Exception {
        TodoVO todoVO = TodoVO.builder()
                .title("Sample Title...")
                .dueDate(LocalDate.of(2023, 12, 28))
                .build();

        todoDAO.insert(todoVO);
    }
}

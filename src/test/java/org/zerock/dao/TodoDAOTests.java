package org.zerock.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.jdbc.dao.TodoDAO;
import org.zerock.jdbc.domain.TodoVO;

import java.time.LocalDate;
import java.util.List;

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

    @Test
    public void testList() throws Exception {
        List<TodoVO> list = todoDAO.selectAll();
        System.out.println("LIST");
        list.forEach(vo -> System.out.println(vo));
    }

    @Test
    public void testSelectOne() throws Exception {
        TodoVO vo = todoDAO.selectOne(4L);

        System.out.println(vo);
    }

    @Test
    public void testUpdateOne() throws Exception {
        TodoVO vo = TodoVO.builder()
                .tno(4L)
                .title("UPDATE TITLE")
                .dueDate(LocalDate.of(2023, 12, 30))
                .finished(true)
                .build();
        todoDAO.updateOne(vo);
    }

    @Test
    public void testList1() throws Exception {
        List<TodoVO> list = todoDAO.selectAll();
        System.out.println("After Update");
        list.forEach(vo -> System.out.println(vo));
    }

    @Test
    public void testDeleteOne() throws Exception {
        todoDAO.deleteOne(4L);
        todoDAO.deleteOne(5L);
    }

    @Test
    public void testList2() throws Exception {
        List<TodoVO> list = todoDAO.selectAll();
        System.out.println("After DELETE");
        list.forEach(vo -> System.out.println(vo));
    }
}

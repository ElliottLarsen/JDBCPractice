package org.zerock.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.jdbc.dto.TodoDTO;
import org.zerock.jdbc.service.TodoService;

import java.time.LocalDate;

public class TodoServiceTests {
    private TodoService todoService;

    @BeforeEach
    public void prepare() {
        todoService = TodoService.INSTANCE;
    }

    @Test
    public void testRegister() throws Exception {
        TodoDTO todoDTO = TodoDTO.builder()
                .title("JDBC Test Title")
                .dueDate(LocalDate.now())
                .build();
        todoService.register(todoDTO);
    }
}

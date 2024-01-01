package org.zerock.jdbc.service;

import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.zerock.jdbc.dao.TodoDAO;
import org.zerock.jdbc.domain.TodoVO;
import org.zerock.jdbc.dto.TodoDTO;
import org.zerock.jdbc.util.MapperUtil;

@Log4j2
public enum TodoService {
    INSTANCE;
    private TodoDAO dao;
    private ModelMapper modelMapper;

    TodoService() {
        dao = new TodoDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    public void register(TodoDTO todoDTO) throws Exception {
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        //System.out.println("todoVO: " + todoVO);
        log.info(todoVO);
        dao.insert(todoVO);
    }

}

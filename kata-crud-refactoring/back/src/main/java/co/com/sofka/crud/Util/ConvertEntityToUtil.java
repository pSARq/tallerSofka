package co.com.sofka.crud.Util;

import co.com.sofka.crud.DTO.TodoListDTO;
import co.com.sofka.crud.Models.TodoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;

@Component("ConvertEntityToUtil")
public class ConvertEntityToUtil {

    @Autowired
    private ModelMapper modelMapper;

    //Permite convertir de lista de tareas a un objeto del modelo plano de lista de tareas
    public TodoListDTO convertToDTOTodoList(TodoList todoList){
        TodoListDTO todoListDTO = null;

        if (todoList != null ){
            todoListDTO = modelMapper.map(todoList, TodoListDTO.class);
        }
        return todoListDTO;
    }

}

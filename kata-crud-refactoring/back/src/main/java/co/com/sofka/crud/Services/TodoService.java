package co.com.sofka.crud.Services;

import co.com.sofka.crud.DTO.TodoDTO;
import co.com.sofka.crud.Models.Todo;
import co.com.sofka.crud.Repositories.TodoListRepository;
import co.com.sofka.crud.Repositories.TodoRepository;
import co.com.sofka.crud.Util.ConvertEntityToUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repositoryTodo;
    @Autowired
    private ConvertEntityToUtil convertEntityToUtil;
    @Autowired
    private TodoListRepository repositoryTodoList;

    public List<TodoDTO> list(){
        List<TodoDTO> list = null;
        List<Todo> todo = (List<Todo>) repositoryTodo.findAll();
        list = todo.stream().map(param -> convertEntityToUtil.convertToDTOTodo(param)).collect(Collectors.toList());
        return list;
    }

    public Todo save(TodoDTO todoDTO){
        Todo todo = new Todo();
        todo.setId(todoDTO.getId());
        todo.setName(todoDTO.getName());
        todo.setCompleted(todoDTO.isCompleted());
        repositoryTodo.save(todo);
        return null;
    }

    public List<TodoDTO> get(Long id){
        List<TodoDTO> list = null;
        Optional<Todo> todo = repositoryTodo.findById(id);
        list = todo.stream().map(param -> convertEntityToUtil.convertToDTOTodo(param)).collect(Collectors.toList());
        return list;
    }

    public void deleteTodo(Long id) {
        repositoryTodo.deleteById(id);
    }

    public void deleteTask(Long id){
        repositoryTodoList.deleteById(id);
    }
}

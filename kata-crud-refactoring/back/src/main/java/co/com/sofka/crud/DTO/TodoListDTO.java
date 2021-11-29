package co.com.sofka.crud.DTO;

import java.util.HashSet;
import java.util.Set;

//Se crea modelo plano de lista de tareas
public class TodoListDTO {

    private Long id;
    private String name;
    private Set<TodoDTO> task;

    public TodoListDTO() {
        this.task = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<TodoDTO> getTask() {
        return task;
    }

    public void setTask(Set<TodoDTO> task) {
        this.task = task;
    }
}

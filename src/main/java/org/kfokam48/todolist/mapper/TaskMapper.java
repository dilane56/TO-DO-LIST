package org.kfokam48.todolist.mapper;

import org.kfokam48.todolist.dto.TaskDto;
import org.kfokam48.todolist.model.Task;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {
    private final ModelMapper modelMapper;

    public TaskMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public TaskDto convertTasktoTaskDto(Task task) {
        return modelMapper.map(task, TaskDto.class);
    }
    public Task convertTaskDtoToTask(TaskDto taskDto) {
        return modelMapper.map(taskDto, Task.class);
    }
}

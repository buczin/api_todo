package pl.buczi.todo.list;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class TaskController {

	@Autowired
	private TaskRepository taskRepository;
	
	@RequestMapping("/list")
	public List<Task> getAllTasks() {
		List<Task> task = new ArrayList<>();
		taskRepository.findAll().forEach(task::add);
		return task;
	}
	
}

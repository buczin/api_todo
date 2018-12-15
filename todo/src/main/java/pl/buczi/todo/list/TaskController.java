package pl.buczi.todo.list;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class TaskController {

	@Autowired
	private TaskRepository taskRepository;
	
//	get list of all tasks
	@RequestMapping("/list")
	public List<Task> getAllTasks() {
		List<Task> task = new ArrayList<>();
		taskRepository.findAll().forEach(task::add);
		return task;
	}
	
//	get task by id
	@RequestMapping("/list/{id}")
	public Task getTask(@PathVariable Long id) {
		return taskRepository.findById(id).get();
	}
	
//	add task to database
	@RequestMapping(method=RequestMethod.POST, value="/list")
	public void addTask(@RequestBody Task task) {
		taskRepository.save(task);
	}
	
//	update task
	@RequestMapping(method=RequestMethod.PUT, value="/list/{id}")
	public void updateTask(@RequestBody Task task, @PathVariable Long id) {
		taskRepository.save(task);
	}
	
//	delete task by id
	@RequestMapping(method=RequestMethod.DELETE, value="/list/{id}")
	public void deleteTask(@PathVariable Long id) {
		taskRepository.deleteById(id);
	}
	
}

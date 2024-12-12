package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Task;
import com.example.demo.service.TaskService;

import java.util.List;

@Controller
@RequestMapping("/") // Root URL mapped here
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String getTasks(Model model) {
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks"; // Render tasks.html
    }

    @PostMapping
    public String createTask(@RequestParam String title) {
        taskService.CreateTask(title);
        return "redirect:/"; // Redirect back to the task list
    }

    @PostMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id) {
        taskService.DeleteTask(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable Long id) {
        taskService.toggleTask(id);
        return "redirect:/";
    }
}

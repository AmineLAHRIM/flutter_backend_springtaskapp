package com.am1ne.springtaskapp.api;

import com.am1ne.springtaskapp.beans.Task;
import com.am1ne.springtaskapp.beans.User;
import com.am1ne.springtaskapp.beans.UserTaskDetail;
import com.am1ne.springtaskapp.services.UserTaskDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("taskapp/userTaskDetail")
public class UserTaskDetailRest {

    @Autowired
    private UserTaskDetailService userTaskDetailService;

    @GetMapping("/")
    public List<UserTaskDetail> findAll() {
        return this.userTaskDetailService.findAll();
    }

    @GetMapping("/{id}")
    public UserTaskDetail findById(@PathVariable Long id) {
        return this.userTaskDetailService.findById(id);
    }

    @GetMapping("/taskId/{taskId}")
    public List<User> findAllByTask_Id(@PathVariable Long taskId) {
        return this.userTaskDetailService.findAllByTask_Id(taskId);
    }

    @GetMapping("/userId/{userId}")
    public List<Task> findAllByUser_Id(@PathVariable Long userId) {
        return this.userTaskDetailService.findAllByUser_Id(userId);
    }

    @PostMapping("/")
    public UserTaskDetail save(@RequestBody UserTaskDetail userTaskDetail) {
        return this.userTaskDetailService.save(userTaskDetail);
    }

    @PutMapping("/{id}")
    public UserTaskDetail update(@PathVariable Long id, @RequestBody UserTaskDetail userTaskDetail) {
        return this.userTaskDetailService.update(id, userTaskDetail);
    }

    @DeleteMapping("/{id}")
    public int deleteById(@PathVariable Long id) {
        return this.userTaskDetailService.deleteById(id);
    }

    @DeleteMapping("/userId/{taskId}")
    public int deleteAllByTask_Id(@PathVariable Long taskId) {
        return this.userTaskDetailService.deleteAllByTask_Id(taskId);
    }

    @DeleteMapping("/userId/{userId}")
    public int deleteAllByUser_Id(@PathVariable Long userId) {
        return this.userTaskDetailService.deleteAllByUser_Id(userId);
    }


}

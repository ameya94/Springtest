package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.AppModel;
import com.example.demo.repository.AppRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AppController {
    @Autowired
    AppRepo mAppRepo;
    @GetMapping("/getcall")
    public List<AppModel> getAppDetails(){
        return mAppRepo.findAll();
    }
    @PostMapping("/postcall")
    public AppModel postCall(@Valid @RequestBody AppModel appModel){
        return mAppRepo.save(appModel);
    }

    @GetMapping("/find/{id}")
    public AppModel getEmpById(@PathVariable(value = "id") Long empId) {
        return mAppRepo.findById(empId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", empId));
    }

    @PutMapping("/emp/{id}")
    public AppModel updateAppModel(@PathVariable(value = "id") Long empId,
                           @Valid @RequestBody AppModel empDetails) {

        AppModel appModel = mAppRepo.findById(empId)
                .orElseThrow(() -> new ResourceNotFoundException("employee", "id", empId));

        appModel.setFirstname(empDetails.getFirstname());
        appModel.setLastname(empDetails.getLastname());

        return mAppRepo.save(appModel);
    }
    @DeleteMapping("/emp/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long eId) {
        AppModel employee = mAppRepo.findById(eId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", eId));

        mAppRepo.delete(employee);

        return ResponseEntity.ok().build();
    }
}

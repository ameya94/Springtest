package com.example.demo.repository;

import com.example.demo.model.AppModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRepo extends JpaRepository<AppModel,Long> {

}

package com.example.issuemanagement.repository;

import com.example.issuemanagement.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface ProjectRepository extends JpaRepository <Project,Long> {

    List<Project> getAllByProjectCode(String projectCode);//parametre verdiğim proje kodu ile git bana o kayıtları getir
    List<Project> getByProjectCodeContains(String projectCode);//projectCode u içeren
    Page<Project> findAll (Pageable pageable);//sayfalama yapabilmek için

    List<Project> findAll (Sort sort);


}

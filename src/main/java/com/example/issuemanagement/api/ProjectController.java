package com.example.issuemanagement.api;

import com.example.issuemanagement.dto.ProjectDto;
import com.example.issuemanagement.entity.Project;
import com.example.issuemanagement.service.imp.ProjectServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project")
public class ProjectController {

    /*
    tüm controllerlar içerisinde http metodlarını bağlıycaz
    Get Post Put Delete
     */

    //ilgili servisi impleent etme
    private final ProjectServiceImpl projectServiceImp;
     //ilgili servisi import edip contsructor ile injection yaptık
    public ProjectController(ProjectServiceImpl projectServiceImp)
    {
        this.projectServiceImp=projectServiceImp;
    }

      @GetMapping("/{id}")       //metodu web restfull servi metodu haline getirmek için
    public ResponseEntity<ProjectDto> getById(@PathVariable("id") Long id){//ResponseEntity: api metodlarımızın veya
         // tüm web servislerimiz içerisinde geiştireceğimiz metodlarımızın ve apilerimizin dışarıda
        // ortak bir imzaya sahip olması için kullanılır geri doneceğimiz tipi paremetre olarak alır(ProjectDto)
       // aslında entity şeması dönmemiz gerekir ancak entittyi dışarı kapatıp dış tarafla dtolar üzerinden konuşacağız.

        ProjectDto projectDto = projectServiceImp.getById(id);//idsi bir olan long tipindeki değişkeni dönsün
        return ResponseEntity.ok(projectDto);
    }

    @PostMapping()
    public ResponseEntity<ProjectDto> createProject(@RequestBody ProjectDto project){//RequestBody:nesnenin requestbodysini otomatik gönderir
        return ResponseEntity.ok(projectServiceImp.save(project));
    }







}

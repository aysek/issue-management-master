package com.example.issuemanagement.service.imp;

import com.example.issuemanagement.dto.ProjectDto;
import com.example.issuemanagement.entity.Project;
import com.example.issuemanagement.repository.ProjectRepository;
import com.example.issuemanagement.service.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository,ModelMapper modelMapper){
        this.projectRepository = projectRepository;
        this.modelMapper=modelMapper;
    }




    @Override
    public ProjectDto save(ProjectDto project) {

        Project projectCheck = projectRepository.getByProjectCode(project.getProjectCode());
        if(projectCheck!=null){
            throw new IllegalArgumentException("project code already exist");
        }

        Project p = modelMapper.map(project,Project.class);
        p=projectRepository.save(p);
        project.setId(p.getId());
        return project;
    }

    @Override
    public ProjectDto getById(Long id) {
        Project p = projectRepository.getOne(id);
        return modelMapper.map(p,ProjectDto.class);//p yi projectdto ya çevirsin ve return et

    }

    @Override
    public Project getByProjectCode(String projectCode) {
        return null;
    }

    @Override
    public List<Project> getByProjectCodeContains(String projectCode) {
        return null;
    }

    @Override
    public Page<Project> getAllPageable(Pageable pageable) {
        return null;
    }

    @Override
    public Boolean delete(Project project) {
        return null;
    }
}

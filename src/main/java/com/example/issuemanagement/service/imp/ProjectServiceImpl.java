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
    public Project save(Project project) {

        if(project.getProjectCode()==null){
            throw new IllegalArgumentException("project code cannot be null!");
        }

        return projectRepository.save(project);
    }

    @Override
    public ProjectDto getById(Long id) {
        Project p = projectRepository.getOne(id);
        return modelMapper.map(p,ProjectDto.class);//p yi projectdto ya çevirsin ve return et

    }

    @Override
    public List<Project> getByProjectCode(String projectCode) {
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

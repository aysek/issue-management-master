package com.example.issuemanagement.dto;

import com.example.issuemanagement.entity.IssueStatus;
import lombok.Data;

import java.util.Date;
//Entity dışarı kapatıp entitiy yerine dış tarafla dtolar üzeinden konuşacağız

@Data

public class IssueDto {

    private Long id;
    private String description;//başlık
    private String details;
    private Date date;
    private IssueStatus issueStatus;
    private UserDto assignee;
    private ProjectDto project;


}

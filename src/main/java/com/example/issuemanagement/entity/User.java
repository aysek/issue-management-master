package com.example.issuemanagement.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")//user keyworde denk geldiği için users yapıldı
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class User extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "uname",length = 100 ,unique = true)
    private String username;

    @Column(name = "pwd",length = 200)
    private String password;

    @Column(name = "name_surname",length = 100)
    private String nameSurname;

    @Column(name = "email",length = 100)
    private String email;

    @JoinColumn(name = "assignee_user_id")
    @OneToMany(fetch = FetchType.LAZY) //Bir kullanıcıya birden çok iş bağlanabilir
    private List<Issue> issues;

}

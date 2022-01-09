package com.example.issuemanagement.entity;

import lombok.*;

import javax.persistence.*;


@Data //getter setter için
@NoArgsConstructor //Nesnenin boş bir constructrını oluşturuyor --- public Issue() {   }
@AllArgsConstructor // Tüm fieldlar kullanılarak oluşturan bir constructır oluşturur.
@ToString //toString metodunu override ediyor
@EqualsAndHashCode //Equels ve hashcode metodunu override ediyor
@Entity //veri tabanında bir tabloya karşılık gelecegi için
@Table(name = "issue_history")
public class IssueHistory extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(name = "issue_id")
    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    private Issue issue;

    @JoinColumn(name = "assignee_user_id")
    @ManyToOne(optional = true,fetch = FetchType.LAZY)//
    private User assignee;      //kime atanmış


}

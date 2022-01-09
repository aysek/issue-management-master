package com.example.issuemanagement.entity;


import lombok.*;

import javax.persistence.*;
import java.util.Date;
@Data //getter setter için
@NoArgsConstructor //Nesnenin boş bir constructrını oluşturuyor --- public Issue() {   }
@AllArgsConstructor // Tüm fieldlar kullanılarak oluşturan bir constructır oluşturur.
@ToString //toString metodunu override ediyor
@EqualsAndHashCode //Equels ve hashcode metodunu override ediyor
@Entity //veri tabanında bir tabloya karşılık gelecegi için
@Table(name = "issue")
public class Issue extends BaseEntity{
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO) //aoutoGenerate olmasını sağlamak sayısal ve
    // artan otomatik bir değer verir
    private Long id;   //intten buyuk long

    @Column(name = "description",length = 1000)
    private String description;     //işin tanımı

    @Column(name = "details",length = 4000)
    private String details;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;               //iş ne zaman açılmış

    @Column(name = "issue_status")
   @Enumerated(EnumType.STRING)
    private IssueStatus issueStatus;//işin durumunu belirlemek için yapıldı(open,closed...)


    @JoinColumn(name = "assignee_user_id")
    @ManyToOne(optional = true,fetch = FetchType.LAZY )//birçok issue classı bir tane usera bağlanabilir
    private User assignee;

    @JoinColumn(name = "project_id")
    @ManyToOne(optional = true,fetch = FetchType.LAZY)//lazy ihtiyaç olduğunda yüklemesi için
    private Project project;


}

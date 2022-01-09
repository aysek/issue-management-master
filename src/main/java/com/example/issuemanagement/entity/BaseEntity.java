package com.example.issuemanagement.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

//@Data//içerdeki fieldların getter ve setterlarını oluşturuyor
@Getter @Setter //data yerine getter setter kullanıldı
@MappedSuperclass //bütün tablolarda ortak olmasını sağlayan anotation
// -bu anatosyon sayesinde bu class diğer tüm classlarda extend edilebilir hale geliyor.
public class BaseEntity implements Serializable {//Serializable nesnenin networkden taşınabilmesi veya
        // diske yazılabilmesi için kullanıldı
    //Bu classta olan bazı propertyler tüm tablolarda yer alsın istiyorum
        // -Bu yüzden ortak bir class olarak geliştirildi
    //Bu classın bazı özellikleri override edilmek istenebilir ve metod badisi bulundurmak istenebilir
        // bu yüzden class abstract class yapıldı.

        @Column(name = "created_at")
        @Temporal(TemporalType.TIMESTAMP)//tarihi alış şeklini belirler ms ye kadar alabilmek için
        private Date createdAt; //ne zaman eklendi

        @Column(name = "created_by",length = 100)
         private String createdBy; //kim ekledi

        @Column(name = "updated_at")
        private Date updatedAt; //ne zaman güncellendi

        @Column(name = "updated_by")
        private String updatedBy; //kim güncelledi

        @Column(name = "status")
        private Boolean status; // kayıt aktif veya değil


}

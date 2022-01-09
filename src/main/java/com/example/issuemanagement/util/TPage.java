package com.example.issuemanagement.util;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

public class TPage<T>{

    private int number;     //kaçıncı sayfa
    private int size;       //kayıtları kaçarlı görmek istiyor
    private Sort sort;      //herhangi bir kolona tıklayıp onu sıralıyor
    private int totalPages; //toplamda kaç sayfa oluştu
    private Long totalElements; //toplamda kaç kayıt oluştu
    private List<T> content;    //döneceğim data gösterilecek


    public void setStat(Page page, List<T> list){

        this.number = page.getNumber();
        this.size=page.getSize();
        this.sort=page.getSort();
        this.totalPages=page.getTotalPages();
        this.totalElements = page.getTotalElements();
    }

}

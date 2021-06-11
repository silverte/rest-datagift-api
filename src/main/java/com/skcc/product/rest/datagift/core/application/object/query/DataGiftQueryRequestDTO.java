package com.skcc.product.rest.datagift.core.application.object.query;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.domain.PageRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class DataGiftQueryRequestDTO {

    final static int DEFAULT_SIZE = 10;
    final static int MAX_SIZE = 50;
    
    //조회 조건
    @NotEmpty
    private String svcMgmtNum;
    private String fromDate;
    private String toDate;

    //페이징 조건
    private int page = 1;
    private int size = DEFAULT_SIZE;

    //페이지 Default 처리
    public void setPage(int page) {
        this.page = page <= 0 ? 1 : page;
    }

    //페이지 사이즈 Default 처리
    public void setSize(int size) {
        this.size = size > MAX_SIZE ? DEFAULT_SIZE : size;
    }

    //페이징 객체 반환 
    public PageRequest of() {
        return PageRequest.of(page -1, size);
    }

}
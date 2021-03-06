package com.skcc.product.rest.datagift.core.application.object.command;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DataGiftCommandApiRequestDTO {

    // Using fields with DB
    @NotEmpty
    private String id;
    private String sampleData1;
    private String sampleData2;

    // Using fields with External System
    boolean isExternalError = false;
    String externalSystemType = "A";
}
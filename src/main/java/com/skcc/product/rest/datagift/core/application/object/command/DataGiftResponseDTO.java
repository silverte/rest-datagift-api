package com.skcc.product.rest.datagift.core.application.object.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DataGiftResponseDTO {
 
    protected long id; 
    private String sampleData1;
    private String sampleData2;
    
}
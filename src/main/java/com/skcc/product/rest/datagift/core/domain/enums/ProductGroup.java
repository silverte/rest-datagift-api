package com.skcc.product.rest.datagift.core.domain.enums;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum ProductGroup {

    UNLIMITED("T-가족결합", Arrays.asList("2133")),
    FAMILY_VIP("온가족그룹+요금제그룹", Arrays.asList("NA00005958", "NA00005959", "NA00006157", "NA00006404", "NA00006538", "NA00006538", "NA00006539")),
    FAMILY("온가족그룹", Arrays.asList("2059", "2087", "2053", "2172", "2193", "2198", "2231")),
    GENERAL("미가입", Collections.EMPTY_LIST);

    private String title;
    private List<String> productList;

    ProductGroup(String title, List<String> productList) {
        this.title = title;
        this.productList = productList;
    }

    public static ProductGroup findByProductCode(String code){
        return Arrays.stream(ProductGroup.values())
                .filter(productGroup -> productGroup.hasProductCode(code))
                .findAny()
                .orElse(GENERAL);
    }

    public boolean hasProductCode(String code){
        return productList.stream()
                .anyMatch(product -> product.equals(code));
    }
    
    public String getTitle() {
        return title;
    }
}

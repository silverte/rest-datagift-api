package com.skcc.product.rest.datagift;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import com.skcc.product.rest.datagift.core.domain.enums.ProductGroup;

public class ProductGroupTest {
    @Test
    public void ProductGroup에게어떤그룹인지물어보기_문자열 () throws Exception {
        String productCode = selectProductCode();
        ProductGroup productGroup = ProductGroup.findByProductCode(productCode);

        assertThat(productGroup.name(), is("FAMILY_VIP"));
        assertThat(productGroup.getTitle(), is("온가족그룹+요금제그룹"));
    }


    private String selectProductCode(){
        return "NA00005959";
    }

}

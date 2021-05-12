package com.skcc.product.rest.datagift;

import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.is;
//import static org.junit.Assert.assertThat;

import com.skcc.product.rest.datagift.core.domain.enums.ProductGroup;

public class ProductGroupTest {
    @Test
    public void PayGroup에게_직접_결제종류_물어보기_문자열 () throws Exception {
        String payCode = selectPayCode();
      //  ProductGroup productGroup = ProductGroup.findByPayCode(payCode);

        //assertThat(productGroup.name(), is("CARD"));
        //assertThat(productGroup.getTitle(), is("카드"));
    }


    private String selectPayCode(){
        return "BAEMIN_PAY";
    }

}

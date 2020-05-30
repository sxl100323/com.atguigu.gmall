package com.atguigu.gulimall.product.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 2级分类Vo
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Catelog2Vo {
    private String catalog1Id;
    public  List<Catelog3Vo> catalog3List;
    private String id;
    private String name;


    /**
     * 3级分类vo
     */

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Catelog3Vo{
        private String catalog2Id; //父分类，2级分类id
        private String id;
        private String name;

    }
}

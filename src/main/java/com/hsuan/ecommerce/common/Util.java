package com.hsuan.ecommerce.common;

public class Util {

    public static int defaultPageNo(Integer pageNo) {
        int finalPageNo = pageNo;
        if (pageNo < 0) {
            finalPageNo = 0;
        }
        return finalPageNo;
    }

    public static int defaultPageSize(Integer pageSize) {
        int finalPageSize = pageSize;
        if (pageSize < 1) {
            finalPageSize = 1;
        }
        return finalPageSize;
    }
}

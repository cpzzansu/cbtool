package com.ksmart47.cbtool.dto;

import lombok.Data;

import java.util.List;

@Data
public class ChangeOrderData {
    private List<BrainstormingOrder> orderAddDataArr;
    private List<BrainstormingOrder> orderModifyDataArr;
}


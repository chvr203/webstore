package com.everyday.models;

import lombok.Data;

@Data
public abstract class Category {
    protected long itemCode;
    protected String itemName;
    protected  long unitPrice;
    protected int quantity;
}

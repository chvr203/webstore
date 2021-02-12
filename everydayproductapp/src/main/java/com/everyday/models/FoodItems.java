package com.everyday.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class FoodItems extends Category{
    private LocalDate dom;
    private LocalDate doe;
    private boolean vegetarian;
}

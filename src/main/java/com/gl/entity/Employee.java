package com.gl.entity;


import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Employee {
    @NotBlank(message = "不能为空")
    private String name;
    private String age;
}

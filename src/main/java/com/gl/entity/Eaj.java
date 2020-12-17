package com.gl.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author 郭亮
 * @date 2020/9/23 10:01 
 **/
@Data
@ToString
@Entity(name = "EAJ")
public class Eaj implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ahdm")
    @NotBlank
    private String ahdm;
    private String ah;
    private String jzxh;

    @Transient
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
}

package com.gl.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 郭亮
 * @date 2020/9/23 10:01
 **/
@Data
@ToString
@Entity(name = "EAJ")
@XmlRootElement
@XmlAccessorType(value = XmlAccessType.FIELD)
public class Eaj implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ahdm")
    @NotBlank
    @XmlElement
    private String ahdm;
    @XmlElement
    private String ah;
    @XmlElement
    private String jzxh;

    @XmlElement
    @Transient
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @XmlElementWrapper
    @XmlElement(name = "test")
    private List<Test> tests;
}

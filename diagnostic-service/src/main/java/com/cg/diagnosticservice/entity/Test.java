package com.cg.diagnosticservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Test {

    @Id
    @GeneratedValue()
    Long id;
    String testName;

//    @OneToMany(cascade = CascadeType.ALL)
//    List<TestAttributes> testAttributes;

}

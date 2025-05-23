package org.example.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Builder
@ToString
public class Person {
    private String personId;
    private String personName;


}

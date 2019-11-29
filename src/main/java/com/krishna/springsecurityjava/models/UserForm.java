package com.krishna.springsecurityjava.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
public class UserForm {
    @NotEmpty private String fullName;
    @NotEmpty @Id private String userName;
    @NotEmpty private String email;
    @NotEmpty private String pass;
    @NotEmpty private String conPass;
}

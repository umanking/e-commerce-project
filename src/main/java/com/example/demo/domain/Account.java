package com.example.demo.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/**
 * @author Geonguk Han
 * @since 2020-06-18
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Email
    private String email;

    @NotNull(message = "must not be null")
    private String password;

    @NotNull(message = "must not be null")
    private String name;

    // todo: @Pattern
    @NotNull(message = "must not be null")
    private String phoneNumber;

    public void updateAccount(final Account newAccount) {
        if (newAccount.getEmail() != null) {
            this.email = newAccount.getEmail();
        }

        if (newAccount.getName() != null) {
            this.name = newAccount.getName();
        }

        if (newAccount.getPhoneNumber() != null) {
            this.phoneNumber = newAccount.getPhoneNumber();
        }
    }
}
package com.okancezik.Flight.Search.API.auth.token;

import com.okancezik.Flight.Search.API.auth.entity.User;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tokens")
public class Token {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "token")
    private String token;

    @Enumerated(EnumType.STRING)
    @Column(name = "token_type")
    private TokenType tokenType;

    @Column(name = "expired")
    private boolean expired;

    @Column(name = "revoked")
    private boolean revoked;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

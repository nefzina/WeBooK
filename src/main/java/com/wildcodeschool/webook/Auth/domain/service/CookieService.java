package com.wildcodeschool.webook.Auth.domain.service;

import com.wildcodeschool.webook.Auth.domain.entity.Token;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Service;

@Service
public class CookieService {
    public ResponseCookie createCookie(Token token) {
        return ResponseCookie.from("token", token.getToken())
                .httpOnly(true)   // Marquer le cookie comme HttpOnly pour la sécurité
                //.secure(true)     // Marquer le cookie comme sécurisé (transmis uniquement via HTTPS)
                .path("/")        // Le cookie est accessible pour l'ensemble du domaine
                .maxAge(60 * 60) // Définir la durée de vie du cookie (exemple : 24 heures)
                .sameSite("Strict") // Politique SameSite pour le cookie
                .build();
    }
}

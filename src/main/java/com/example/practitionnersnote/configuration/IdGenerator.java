package com.example.practitionnersnote.configuration;

import java.util.concurrent.atomic.AtomicLong;
//classe pour genérer automatiquement l'Id du patHistory
public class IdGenerator {
    private static AtomicLong compteur = new AtomicLong(0);

    public static Long incrementAndGetValue() {
        return compteur.incrementAndGet();
    }
}

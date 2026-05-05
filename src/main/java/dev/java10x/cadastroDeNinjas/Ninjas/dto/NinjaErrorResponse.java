package dev.java10x.cadastroDeNinjas.Ninjas.dto;

import java.time.Instant;

public record NinjaErrorResponse(String error, Instant timestamp) {}
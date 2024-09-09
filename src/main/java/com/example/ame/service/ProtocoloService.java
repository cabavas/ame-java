package com.example.ame.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ProtocoloService {
    private final AtomicInteger counter = new AtomicInteger();

    public String generateProtocol() {
        Integer protocolNumber = counter.incrementAndGet();
        return protocolNumber.toString();
    }
}

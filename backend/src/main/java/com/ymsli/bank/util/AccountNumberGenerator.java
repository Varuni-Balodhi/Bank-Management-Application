package com.ymsli.bank.util;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.time.Year;

/**
 * Generates unique, readable bank account numbers.
 */
@Component
public class AccountNumberGenerator {

    private static final SecureRandom RANDOM = new SecureRandom();

    /**
     * Format:
     *  ACC-YYYY-XXXXXX
     *  Example: ACC-2026-483920
     */
    public String generate() {

        int currentYear = Year.now().getValue();
        int randomSixDigit = 100000 + RANDOM.nextInt(900000);

        return "ACC-" + currentYear + "-" + randomSixDigit;
    }
}

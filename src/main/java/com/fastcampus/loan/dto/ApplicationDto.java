package com.fastcampus.loan.dto;

import ch.qos.logback.classic.pattern.LineOfCallerConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ApplicationDto implements Serializable {

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    public static class Request{

        private Long applicationId;

        private String name;

        private String cellPhone;

        private String email;

        private BigDecimal hopeAmount;
    }
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    public static class Response{

        private Long applicationId;

        private String name;

        private String cellPhone;

        private String email;

        private BigDecimal hopeAmount;

        private LocalDateTime createAt;

        private LocalDateTime updatedAt;
    }
}

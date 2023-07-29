package com.fastcampus.loan.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.fastcampus.loan.domain.Application;
import com.fastcampus.loan.dto.ApplicationDto;
import com.fastcampus.loan.repository.ApplicationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ApplicationServiceTest {

    @InjectMocks
    ApplicationServiceImpl applicationService;

    @Mock
    private ApplicationRepository applicationRepository;
    @Spy
    private ModelMapper modelMapper;

    @Test
    void Should_ReturnResponseOfNewApplicationEntity_When_RequestCreateApplication(){
        Application entity = Application.builder()
                .name("Chang")
                .cellPhone("010-1234-1234")
                .email("asd@asd.com")
                .hopeAmount(BigDecimal.valueOf(50000000))
                .build();

        ApplicationDto.Request request = ApplicationDto.Request.builder()
                .name("Chang")
                .cellPhone("010-1234-1234")
                .email("asd@asd.com")
                .hopeAmount(BigDecimal.valueOf(50000000))
                .build();

        when(applicationRepository.save(ArgumentMatchers.any(Application.class))).thenReturn(entity);

        ApplicationDto.Response actual = applicationService.create(request);

        assertThat(actual.getHopeAmount()).isSameAs(entity.getApplicationId());
    }
    @Test
    void Should_ReturnResponseOfExistApplicationEntity_When_RequestExistApplicationId(){
        Long findId = 1L;

        Application entity = Application.builder()
                .applicationId(1L)
                .build();

        when(applicationRepository.findById(findId)).thenReturn(Optional.ofNullable(entity));

        ApplicationDto.Response actual = applicationService.get(findId);
        assertThat(actual.getApplicationId()).isSameAs((findId));
    }

    @Test
    void Should_ReturnUpdateOfExistApplicationEntity_When_RequestExistApplicationInfo(){
        Long findId = 1L;
        BigDecimal loan = BigDecimal.valueOf(500);

        ApplicationDto.Request request = ApplicationDto.Request.builder()
                .hopeAmount(loan)
                .build();

        Application entity = Application.builder()
                .applicationId(1L)
                .hopeAmount(loan)
                .build();
        when(applicationRepository.save(ArgumentMatchers.any(Application.class))).thenReturn(entity);
        when(applicationRepository.findById(findId)).thenReturn(Optional.ofNullable(entity));

        ApplicationDto.Response actual = applicationService.update(findId,request);
        assertThat(actual.getApplicationId()).isSameAs(findId);
        assertThat(actual.getHopeAmount()).isSameAs(loan);
    }
}


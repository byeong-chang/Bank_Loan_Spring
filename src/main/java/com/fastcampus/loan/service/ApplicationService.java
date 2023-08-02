package com.fastcampus.loan.service;

import com.fastcampus.loan.dto.ApplicationDto;
import com.fastcampus.loan.dto.ApplicationDto.Response;

public interface ApplicationService {

    Response create(ApplicationDto.Request request);
    Response get(Long applicationId);
    Response update(Long applicationId, ApplicationDto.Request request);
    void delete(Long applicationId);

}

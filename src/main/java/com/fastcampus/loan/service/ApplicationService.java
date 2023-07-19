package com.fastcampus.loan.service;

import com.fastcampus.loan.dto.ApplicationDto;

public interface ApplicationService {

    ApplicationDto.Response create(Object request);

}

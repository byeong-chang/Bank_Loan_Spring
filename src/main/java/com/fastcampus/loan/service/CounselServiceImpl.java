package com.fastcampus.loan.service;

import com.fastcampus.loan.domain.Counsel;
import com.fastcampus.loan.dto.CounselDTO.Response;
import com.fastcampus.loan.dto.CounselDTO.Request;
import com.fastcampus.loan.exception.BaseException;
import com.fastcampus.loan.exception.ResultType;
import com.fastcampus.loan.repository.CounselRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CounselServiceImpl implements CounselService{

    private final CounselRepository counselRepository;
    private final ModelMapper modelMapper;

    @Override
    public Response create(Request request) {
        Counsel counsel = modelMapper.map(request, Counsel.class);
        counsel.setAppliedAt(LocalDateTime.now());

        Counsel created = counselRepository.save(counsel);
        return modelMapper.map(created, Response.class);
    }

    @Override
    public Response get(Long counselId) {
        Counsel counsel = counselRepository.findById(counselId).orElseThrow(()->{
            throw new BaseException(ResultType.SYSTEM_ERROR);
            //BaseException은 미리 구현해둔 공통 에러처리 방식이다.
        });
        return modelMapper.map(counsel,Response.class);
    }

    @Override
    public Response update(Long counselId, Request reqeust) {
        Counsel counsel = counselRepository.findById(counselId).orElseThrow(()->{
            throw new BaseException(ResultType.SYSTEM_ERROR);
            //BaseException은 미리 구현해둔 공통 에러처리 방식이다.
        });

        counsel.setName(reqeust.getName());
        counsel.setCellPhone(reqeust.getCellPhone());
        counsel.setEmail(reqeust.getEmail());
        counsel.setMemo(reqeust.getMemo());
        counsel.setAddress(reqeust.getAddress());
        counsel.setAddressDetail(reqeust.getAddressDetail());
        counsel.setZipCode(reqeust.getZipCode());

        counselRepository.save(counsel);
        return modelMapper.map(counsel,Response.class);
    }

    @Override
    public void delete(long counselId) {
        Counsel counsel = counselRepository.findById(counselId).orElseThrow(()-> {
            throw new BaseException(ResultType.SYSTEM_ERROR);
        });
        counsel.setIsDeleted(true);
        counselRepository.save(counsel);
    }
}

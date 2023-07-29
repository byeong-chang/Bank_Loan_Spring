package com.fastcampus.loan.controller;

import com.fastcampus.loan.dto.ApplicationDto;
import com.fastcampus.loan.dto.ResponseDTO;
import com.fastcampus.loan.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/applications")
public class ApplicationController extends AbstractController{

    private final ApplicationService applicationService;

    @PostMapping
    public ResponseDTO<ApplicationDto.Response> create(@RequestBody ApplicationDto.Request request){
        return ok(applicationService.create(request));
    }
    @GetMapping("/{applicationId}")
    public ResponseDTO<ApplicationDto.Response> get(@PathVariable Long applicationId){
        return ok(applicationService.get(applicationId));
    }
    @PutMapping("/{applicationId}")
    public ResponseDTO<ApplicationDto.Response> update(@PathVariable Long applicationId, @RequestBody ApplicationDto.Request request){
        System.out.println(request.getHopeAmount());
        return ok(applicationService.update(applicationId,request));
    }
}

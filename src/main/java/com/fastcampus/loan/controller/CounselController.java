package com.fastcampus.loan.controller;

import com.fastcampus.loan.dto.CounselDTO;
import com.fastcampus.loan.dto.CounselDTO.Response;
import com.fastcampus.loan.dto.CounselDTO.Request;
import com.fastcampus.loan.dto.ResponseDTO;
import com.fastcampus.loan.service.CounselService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/counsels")
public class CounselController extends AbstractController{
    //AbstactController는 Contoller가 동일하게 응답값을 내려주기 위해 만들어둔 추상 클래스

    private final CounselService counselService;

    @PostMapping
    public ResponseDTO<Response> create(@RequestBody Request request){
        return ok(counselService.create(request));
        //ok는 AbstactController에 정의되어 있음
    }

    @GetMapping("/{counselId}")
    public ResponseDTO<Response> create(@PathVariable Long counselId){
        return ok(counselService.get(counselId));
    }

    @PutMapping("/{counselId}")
    public ResponseDTO<Response> update(@PathVariable Long counselId, @RequestBody Request request){
        return ok(counselService.update(counselId,request));
    }

    @DeleteMapping("/{counselId}")
    public ResponseDTO<Response> delete(@PathVariable Long counselId){
        counselService.delete(counselId);
        return ok();
    }
}

package com.i.controller.redis;

import com.i.api.enums.StatusCode;
import com.i.api.response.BaseResponse;
import com.i.dto.RedPacketDto;
import com.i.service.redis.RedPacketServcie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.math.BigDecimal;

@RestController
public class RedPacketController {
    private static final Logger log = LoggerFactory.getLogger(RedPacketController.class);

    private static final String prefix = "red/packet";

    @Autowired
    private RedPacketServcie redPacketServcie;
@RequestMapping(value = prefix+"/hand/out",method = RequestMethod.POST,
consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse handOut(@Validated @RequestBody RedPacketDto dto, BindingResult result){
        if (result.hasErrors()) {
            return new BaseResponse(StatusCode.InvalidParams);
        }
        BaseResponse response = new BaseResponse(StatusCode.Success);


        try {
            String   redId = redPacketServcie.handOut(dto);
            response.setData(redId);
        } catch (Exception e) {
           log.error("发红包发生异常：dto={}",dto,e.fillInStackTrace());
            response = new BaseResponse(StatusCode.Fail.getCode(), e.getMessage());
        }
        return response;



    }

    /**
     * 抢
     * @param userId
     * @param redId
     * @return
     */
    @RequestMapping(value = prefix+"/rob",method = RequestMethod.GET)
    public BaseResponse rob(@RequestParam Integer userId,@RequestParam String redId){
        BaseResponse response = new BaseResponse(StatusCode.Success);

        try {
            BigDecimal result = redPacketServcie.rob(userId, redId);
            if (result!=null) {
                response.setData(result);
            }else{
                response = new BaseResponse(StatusCode.Fail.getCode(), "红包已被抢完！");
            }
        } catch (Exception e) {
            log.error("抢红包发生异常：userId={} redId={}",userId,redId,e.fillInStackTrace());
            response = new BaseResponse(StatusCode.Fail.getCode(), e.getMessage());
        }
        return response;
    }


}

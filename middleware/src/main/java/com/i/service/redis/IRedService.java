package com.i.service.redis;

import com.i.dto.RedPacketDto;

import java.math.BigDecimal;
import java.util.List;

/**
 * 红包记录服务
 */
public interface IRedService {
    void redcordRedPacket(RedPacketDto dto, String redId, List<Integer> list)throws Exception;
    void recordRobRedPacket(Integer userId, String redId, BigDecimal amount)throws Exception;
}

package com.i.service.redis;

import com.i.dto.RedPacketDto;
import com.i.entity.RedDetail;
import com.i.entity.RedRecord;
import com.i.entity.RedRobRecord;
import com.i.mapper.RedDetailMapper;
import com.i.mapper.RedRecordMapper;
import com.i.mapper.RedRobRecordMapper;
import org.apache.jute.Record;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class RedService  implements IRedService {

    private static final Logger log = LoggerFactory.getLogger(RedService.class);

    @Autowired
    private RedRecordMapper redRecordMapper;

    @Autowired
    private RedDetailMapper redDetailMapper;

    @Autowired
    private RedRobRecordMapper redRobRecordMapper;

    /**
     * 发红包记录
     * @param dto
     * @param redId
     * @param list
     * @throws Exception
     */
    @Override
    @Async
    @Transactional(rollbackFor = Exception.class)
    public void redcordRedPacket(RedPacketDto dto, String redId, List<Integer> list) throws Exception {
        RedRecord redRecord = new RedRecord();
        redRecord.setUserId(dto.getUserId());
        redRecord.setRedPacket(redId);
        redRecord.setTotal(dto.getTotal());
        redRecord.setAmount(BigDecimal.valueOf(dto.getAmount()));
        redRecordMapper.insertSelective(redRecord);

        RedDetail detail;
        for (Integer i : list) {
            detail = new RedDetail();
            detail.setRecordId(redRecord.getId());
            detail.setAmount(BigDecimal.valueOf(i));
            redDetailMapper.insertSelective(detail);

        }
    }

    /**
     * 抢红包记录
     * @param userId
     * @param redId
     * @param amount
     * @throws Exception
     */
    @Override
    @Async
    public void recordRobRedPacket(Integer userId, String redId, BigDecimal amount) throws Exception {
        RedRobRecord redRobRecord=new RedRobRecord();
        redRobRecord.setUserId(userId);
        redRobRecord.setRedPacket(redId);
        redRobRecord.setAmount(amount);
        redRobRecord.setRobTime(new Date());
        redRobRecordMapper.insertSelective(redRobRecord);

    }
}

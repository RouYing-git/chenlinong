package cln.rhy.service.Impl;

import cln.rhy.entity.IaSyncUserRecord;
import cln.rhy.service.ITestService;
import cln.rhy.service.IaSyncUserRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: 15262726991
 * @since: 2024/1/1
 */
@Service
@Slf4j
public class TestServiceImpl implements ITestService {
    @Autowired
    private IaSyncUserRecordService iaSyncUserRecordService;

    @Override
    public void dd() throws Exception {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        for(Integer i : integerList) {
            System.out.println("循环中第" + i);
            try {
                iaSyncUserRecordService.processAnalyst();
            } catch (Exception e) {
                log.error("异常了了了了", e);
            } finally {
                IaSyncUserRecord iaSyncUserRecord = new IaSyncUserRecord(null, 123L, "controller中的finally", 1, LocalDateTime.now(), 2);
                iaSyncUserRecordService.save(iaSyncUserRecord);
            }
        }

    }
}

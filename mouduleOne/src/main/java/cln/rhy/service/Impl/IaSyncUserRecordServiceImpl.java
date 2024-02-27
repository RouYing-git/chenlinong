package cln.rhy.service.Impl;

import cln.rhy.entity.IaSyncUserRecord;
import cln.rhy.exception.ServiceException;
import cln.rhy.mapper.IaSyncUserRecordMapper;
import cln.rhy.service.IFileService;
import cln.rhy.service.IaMeetingConfigService;
import cln.rhy.service.IaSyncUserRecordService;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

/**
 * <p>
 * 用户同步数据记录表 服务实现类
 * </p>
 *
 * @author renhongying
 * @since 2023-12-26
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class IaSyncUserRecordServiceImpl extends ServiceImpl<IaSyncUserRecordMapper, IaSyncUserRecord> implements IaSyncUserRecordService {

    private final IaMeetingConfigService iaMeetingConfigService;
    private final IFileService iFileService;


    @Override
//    @Transactional(rollbackFor = ServiceException.class)
    public void processAnalyst() {
        this.handleSyncAnalystData();
        syncIaAnalystData();
        iFileService.delete();
    }

    @Override
    public void handleSyncAnalystData() {
//        try {
            List<IaSyncUserRecord> list = lambdaQuery().orderByAsc(IaSyncUserRecord::getId).list();
            removeById(list.get(0).getId());
            insert();
//        } catch (Exception e) {
////            System.out.println("123yichangla");//任何都不会回滚
////            log.error("yichangle", e);// 只写这一行 任何都不会回滚
////             throw new RuntimeException(e);//会回滚（finally也会）
//            //同时写上面的两行也会回滚
//            throw new ServiceException("500", "yihcangle");//会回滚（finally也会）
//        } finally {
//            IaSyncUserRecord iaSyncUserRecord = new IaSyncUserRecord(null, 123L, "finally", 1, LocalDateTime.now(), 2);
//            save(iaSyncUserRecord);
//        }
    }
    @Override
    public void syncIaAnalystData() {
        iaMeetingConfigService.selectMeetingConfig();
    }

//    @Override
    private void insert() {
        IaSyncUserRecord iaSyncUserRecord = new IaSyncUserRecord(null, 123L, "新增", 1, LocalDateTime.now(), 1);
        save(iaSyncUserRecord);
        throw new RuntimeException("手动异常");
    }

}

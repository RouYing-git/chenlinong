package cln.rhy.service;

import cln.rhy.entity.IaSyncUserRecord;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;


@Service
/**
 * <p>
 * 用户同步数据记录表 服务类
 * </p>
 *
 * @author renhongying
 * @since 2023-12-26
 */

public interface IaSyncUserRecordService extends IService<IaSyncUserRecord> {
    void processAnalyst();
    void handleSyncAnalystData();

    void syncIaAnalystData();
//    void insert();

}

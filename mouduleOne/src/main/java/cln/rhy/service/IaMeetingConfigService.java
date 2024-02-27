package cln.rhy.service;

import cln.rhy.entity.IaMeetingConfig;
import com.baomidou.mybatisplus.extension.service.IService;


import java.util.List;

/**
 * <p>
 * 会议签到配置表 服务类
 * </p>
 *
 * @author author
 * @since 2023-05-09
 */
public interface IaMeetingConfigService extends IService<IaMeetingConfig> {

    /**
     * 获取会议签到配置
     * @return
     */
    void selectMeetingConfig();

    void selectMeetingConfig2();
}

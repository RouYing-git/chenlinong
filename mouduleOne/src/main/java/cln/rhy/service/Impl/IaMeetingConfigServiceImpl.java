package cln.rhy.service.Impl;

import cln.rhy.entity.IaMeetingConfig;
import cln.rhy.mapper.IaMeetingConfigMapper;
import cln.rhy.service.IaMeetingConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 会议签到配置表 服务实现类
 * </p>
 *
 * @author author
 * @since 2023-05-09
 */
@Service
public class IaMeetingConfigServiceImpl extends ServiceImpl<IaMeetingConfigMapper, IaMeetingConfig> implements IaMeetingConfigService {

    @Override
    public void selectMeetingConfig() {
        List<IaMeetingConfig> list = lambdaQuery().orderByAsc(IaMeetingConfig::getId).list();
        removeById(list.get(0).getId());
        IaMeetingConfig iaMeetingConfig = new IaMeetingConfig(null, "新新新新新", "新新新新新", 3);
        save(iaMeetingConfig);
//        throw new RuntimeException("手动异常");
    }

    @Override
    public void selectMeetingConfig2() {
        List<IaMeetingConfig> list = lambdaQuery().orderByDesc(IaMeetingConfig::getId).list();
        removeById(list.get(0).getId());
        IaMeetingConfig iaMeetingConfig = new IaMeetingConfig(null, "新新22222", "新新新22222", 3);
        save(iaMeetingConfig);
        throw new RuntimeException("手动异常");
    }

}

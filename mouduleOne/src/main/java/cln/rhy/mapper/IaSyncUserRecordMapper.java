package cln.rhy.mapper;

import cln.rhy.entity.IaSyncUserRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户同步数据记录表 Mapper 接口
 * </p>
 *
 * @author renhongying
 * @since 2023-12-26
 */
@Mapper
public interface IaSyncUserRecordMapper extends BaseMapper<IaSyncUserRecord> {

}

package cln.rhy.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import lombok.*;
/**
 * <p>
 * 用户同步数据记录表
 * </p>
 *
 * @author renhongying
 * @since 2023-12-26
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("ia_sync_user_record")
public class IaSyncUserRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 上游用户唯一标识
     */
    private Long objId;

    /**
     * 本次同步数据源详细信息
     */
    private String syncMessage;

    /**
     * 角色 1-分析师；2-销售；3-其他员工；4-白名单
     */
    private Integer roleType;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 状态：1-有效 0-无效
     */
    private Integer status;


}

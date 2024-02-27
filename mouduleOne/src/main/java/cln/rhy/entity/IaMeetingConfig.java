package cln.rhy.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 会议签到配置表
 * </p>
 *
 * @author author
 * @since 2023-05-09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("ia_meeting_config2")
public class IaMeetingConfig implements Serializable {

    private static final long serialVersionUID = 456465786975743L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String attribute;

    private String value;

    private Integer status;


}

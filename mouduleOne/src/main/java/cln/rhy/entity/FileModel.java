package cln.rhy.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@TableName("ia_file")
public class FileModel {

    @TableId(type = IdType.AUTO)
    private Integer id;

    // 文件名
    @TableField(value = "file_name")
    private String fileName;

    // 全路径
    @TableField(value = "full_Path")
    private String fullPath;

    // 全量 Hash
    @TableField(value = "content_hash")
    private String contentHash;

    // 文件大小
    @TableField(value = "fileSize")
    private Long fileSize;

    // 文件当前状态
    // todo 考虑多用户上传同一个文件问题
    @TableField(value = "status")
    private Integer status;

    public FileModel() {}

    public FileModel(String fileName, String fullPath, String contentHash, Long fileSize, Integer status) {
        this.fileName = fileName;
        this.fullPath = fullPath;
        this.contentHash = contentHash;
        this.fileSize = fileSize;
        this.status = status;
    }
}

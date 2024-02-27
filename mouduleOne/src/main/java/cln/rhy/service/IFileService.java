package cln.rhy.service;

import cln.rhy.entity.FileModel;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.io.InputStream;
@Service
public interface IFileService extends IService<FileModel> {
    void delete();

}

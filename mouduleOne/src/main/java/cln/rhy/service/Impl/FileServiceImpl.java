package cln.rhy.service.Impl;

import cln.rhy.entity.FileModel;
import cln.rhy.mapper.FileMapper;
import cln.rhy.service.IFileService;
import cln.rhy.service.IaMeetingConfigService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class FileServiceImpl extends ServiceImpl<FileMapper, FileModel> implements IFileService {
    private final IaMeetingConfigService iaMeetingConfigService;

    @Override
    public void delete(){
        save(new FileModel("q", "w", "e", 8888L, 1));
        iaMeetingConfigService.selectMeetingConfig2();
    }



}

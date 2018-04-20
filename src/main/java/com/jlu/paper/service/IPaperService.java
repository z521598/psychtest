package com.jlu.paper.service;

import com.jlu.paper.bean.PaperBean;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/19.
 */
public interface IPaperService {

    PaperBean dealPaperInfo(Map<String, String[]> parameterMap);

    void savePaper(PaperBean paperBean);

    String uploadFile(HttpServletRequest request, MultipartFile conclusionFilePath) throws IOException;

    PaperBean getPaperBean(Long paperId);
}

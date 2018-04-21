package com.jlu.paper.service;

import com.jlu.paper.bean.PaperBean;
import com.jlu.paper.model.Paper;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/19.
 */
public interface IPaperService {

    PaperBean dealPaperInfo(Map<String, String[]> parameterMap);

    void savePaper(PaperBean paperBean);

    void update(PaperBean paperBean);

    String uploadFile(HttpServletRequest request, MultipartFile conclusionFilePath) throws IOException;

    PaperBean getPaperBean(Long paperId);

    List<Paper> getAll();

    Paper get(Long paperId);

    void save(Paper paper);

    void delete(Long paperId);

    void deleteQuestion(Long paperId);
}

package org.example.bootapi.service;

import org.example.bootapi.model.entity.Diary;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DiaryService {
    List<Diary> getAllDiaryList() throws Exception;

    Diary createDiary(Diary diary) throws Exception;
}

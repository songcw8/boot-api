package org.example.bootapi.service;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.example.bootapi.model.entity.Diary;
import org.example.bootapi.model.repository.DiaryReposotory;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DiaryServiceImpl implements DiaryService {

    private final DiaryReposotory diaryReposotory;

    @Override
    public List<Diary> getAllDiaryList() throws Exception {
        // 최신순으로 해버리기~
        return diaryReposotory.findAll().stream()
                .sorted(Comparator.comparing(Diary::getCreatedAt).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public Diary createDiary(Diary diary) throws Exception {
        if(diary.getTitle() == null || diary.getTitle().isEmpty()) {
            throw new BadRequestException("제목이 없습니다.");
        }
        if(diary.getContent() == null || diary.getContent().isEmpty()) {
            throw new BadRequestException("내용이 없습니다.");
        }
        return diaryReposotory.save(diary);
    }
}

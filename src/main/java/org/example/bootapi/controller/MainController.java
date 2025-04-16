package org.example.bootapi.controller;

import lombok.RequiredArgsConstructor;
import org.example.bootapi.model.entity.Diary;
import org.example.bootapi.model.form.DiaryForm;
import org.example.bootapi.service.DiaryService;
import org.example.bootapi.service.StorageService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final StorageService storageService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("title", "AI 뿡다닥");
        model.addAttribute("message", "AI 메모");
        return "index";
    }

    @GetMapping("/file/{filename}")
    public ResponseEntity<byte[]> file(@PathVariable String filename) {
        try {
            byte[] fileBytes = storageService.download(filename); // 버킷 -> 파일 이름 요청

            // 페이지(템플릿)로 응답하지 않고, 데이터로 응답하겠다
            return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"").contentType(MediaType.APPLICATION_OCTET_STREAM).body(fileBytes);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
package org.example.bootapi.service;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

    // 1. 파일명만 준다. 왜? 나머지는 서버가 관리
    // 2. 아예 url을 저장. 왜? 서버를 거쳐서 부담을 주지 말고 바로 가자
    String upload(MultipartFile file);
}

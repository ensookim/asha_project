package com.asha.springboot.domain.user.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asha.springboot.domain.user.dto.UserSignUpDTO;
import com.asha.springboot.domain.user.service.UserService;

import lombok.RequiredArgsConstructor;

// 1️⃣ Next.js (프론트) → POST /signup 요청
// 2️⃣ Spring Boot UserController에서 요청 수신
// 3️⃣ DTO (UserSignUpDTO)로 데이터 변환
// 4️⃣ 서비스 (UserService)에서 비즈니스 로직 처리
// 5️⃣ Repository (UserRepository)에서 DB 저장
// 6️⃣ 결과 응답 → Next.js가 UI에 반영
/**
 * 
 * 
 * 사용자에 관한 모든 API를 처리하는 컨트롤러
 */

@RestController // @Controller + @ResponseBody 로 restfulAPI를 위해 사용
@RequiredArgsConstructor // final로 선언된 필드를 생성자로 만들어줌
public class UserController {

    private final UserService userService;

    /**
     * 회원가입을 위한 API
     * 
     * @param userSignUpDTO
     * @return String
     */
    @PostMapping("/signup")
    public String signup(@RequestBody UserSignUpDTO userSignUpDTO) {

        // 회원가입 정보를 받아서 DB에 저장하기
        String result = userService.createUser(userSignUpDTO);

        return result;
    }

}

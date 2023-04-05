package com.example.shortproject.service;

import com.example.shortproject.dto.LoginDto;
import com.example.shortproject.entity.Professor;
import com.example.shortproject.entity.Student;
import com.example.shortproject.jwt.JwtUtil;
import com.example.shortproject.repository.ProfessorRepository;
import com.example.shortproject.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final ProfessorRepository professorRepository;
    private final StudentRepository studentRepository;
    private final JwtUtil jwtUtil;

    //    private final TokenProvider tokenProvider;
//    private final AuthenticationManagerBuilder authenticationManagerBuilder;
//    private final ProfessorRepository professorRepository;
//    private final StudentRepository studentRepository;
//    public LoginDto.ResponseDto login(LoginDto.RequestDto requestDto, HttpServletResponse httpServletResponse) {
//        UsernamePasswordAuthenticationToken authenticationToken =
//                new UsernamePasswordAuthenticationToken(requestDto.getLoginId(), requestDto.getPassword());
//
//        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        String accessToken = tokenProvider.createToken(authentication);
//
//        httpServletResponse.addHeader(JwtFilter.AUTHORIZATION_HEADER, accessToken);
//
//        return new LoginDto.ResponseDto(accessToken);
//    }
    public void professorLogin(LoginDto.RequestDto requestDto, HttpServletResponse httpServletResponse) {
        String loginId = requestDto.getLoginId();
        String password = requestDto.getPassword();

        // 사용자 확인
        Professor professor = professorRepository.findByLoginId(loginId).orElseThrow(
                () -> new IllegalArgumentException("등록된 사용자가 없습니다.")
        );
        // 비밀번호 확인
        if (!professor.getPassword().equals(password)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        httpServletResponse.addHeader(JwtUtil.AUTHORIZATION_HEADER, jwtUtil.createToken(professor.getLoginId(), professor.getMemberRole()));
    }


    public void studentLogin(LoginDto.RequestDto requestDto, HttpServletResponse httpServletResponse) {
        String loginId = requestDto.getLoginId();
        String password = requestDto.getPassword();

        // 사용자 확인
        Student student = studentRepository.findByLoginId(loginId).orElseThrow(
                () -> new IllegalArgumentException("등록된 사용자가 없습니다.")
        );
        // 비밀번호 확인
        if (!student.getPassword().equals(password)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        httpServletResponse.addHeader(JwtUtil.AUTHORIZATION_HEADER, jwtUtil.createToken(student.getLoginId(), student.getMemberRole()));
    }
}

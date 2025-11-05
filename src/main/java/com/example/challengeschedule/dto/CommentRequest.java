package com.example.challengeschedule.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CommentRequest {
    @Size(max=100)//댓글 내용 최대 100글자까지 제한
    @NotBlank(message = "댓글 내용은 필수 입력 값입니다.")//한 글자라도 입력이 안되면 "댓글 내용은 필수 입력 값입니다."반환(필수값 설정)
    private String commentContent;//댓글 내용
    @NotBlank(message = "작성자명은 필수 입력 값입니다.")//한 글자라도 입력이 안되면 "댓글 작성자명은 필수 입력 값입니다."반환(필수값 설정)
    private String commentName;//댓글 작성자명
    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")//한 글자라도 입력이 안되면 "댓글 비밀번호는 필수 입력 값입니다."반환(필수값 설정)
    private String commentPassword;//댓글 비밀번호

}

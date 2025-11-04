package com.example.challengeschedule.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CommentRequest {
    @Size(max=100)
    @NotBlank(message = "댓글 내용은 필수 입력 값입니다.")
    private String commentContent;
    @NotBlank(message = "작성자명은 필수 입력 값입니다.")
    private String commentName;
    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    private String commentPassword;

}

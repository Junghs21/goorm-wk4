package goorm.week4.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

    @Min(value = 1000000000L, message = "학번은 10자리 형태의 숫자여야 합니다.")
    @Max(value = 9999999999L, message = "학번은 10자리 형태의 숫자여야 합니다.")
    private Long studentId;

    @NotBlank(message = "학생 이름은 비워둘 수 없습니다.")
    @Size(min = 3, max = 9, message = "이름은 3~9글자여야 합니다.")
    private String studentName;

    @NotBlank(message = "학과는 비워둘 수 없습니다.")
    @Size(min = 2, max = 20, message = "학과 이름은 2~20자여야 합니다.")
    private String major;

    @NotBlank(message = "이메일은 비워둘 수 없습니다.")
    @Email(message = "유효한 이메일 주소를 입력하세요.")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@khu\\.ac\\.kr$", message = "학교 이메일 주소는 @khu.ac.kr 형태의 도메인이어야 합니다.")
    private String email;

    @NotBlank(message = "전화번호는 비워둘 수 없습니다.")
    @Pattern(regexp = "^010\\d{8}$", message = "전화번호는 010xxxxxxxx로 입력해주세요.")
    private String phoneNumber;
}

package goorm.week4.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {

    private Long courseId;

    @NotBlank(message = "수업 이름은 비워둘 수 없습니다.")
    @Size(min = 2, max = 50, message = "수업 이름은 2~50자 사이여야 합니다.")
    private String courseName;
}

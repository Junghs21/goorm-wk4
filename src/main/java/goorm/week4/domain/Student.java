package goorm.week4.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Student {

    @Id
    @Min(value = 1000000000L)
    @Max(value = 9999999999L)
    private Long studentId;    //학번

    @NotBlank
    @Size(min = 3, max = 9)
    private String studentName;

    @NotBlank
    @Size(min = 2, max = 20)
    private String major;   //학과

    @NotBlank
    @Email
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@khu\\.ac\\.kr$")
    private String email;   //학교 이메일

    @NotBlank
    @Pattern(regexp = "^010\\d{8}$")
    private String phoneNumber;

    @OneToMany(mappedBy = "student")
    private List<StudentCourse> studentCourses = new ArrayList<>(); //수업 정보와의 관계

    public Student(Long studentId, String studentName, String major, String email, String phoneNumber) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.major = major;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}

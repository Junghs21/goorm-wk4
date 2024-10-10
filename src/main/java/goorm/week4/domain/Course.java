package goorm.week4.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId; //수업 ID

    @NotBlank
    @Size(min = 2, max = 50)
    private String courseName; //수업 이름

    @OneToMany(mappedBy = "course")
    private List<StudentCourse> studentCourses = new ArrayList<>(); //학생 정보와의 관계

    public Course(String courseName) {
        this.courseName = courseName;
    }
}

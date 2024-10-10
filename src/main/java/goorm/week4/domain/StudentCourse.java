package goorm.week4.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@IdClass(StudentCourseId.class) //복합 키 사용
public class StudentCourse {

    @Id
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;    //학생 정보

    @Id
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;  //수업 정보

    public StudentCourse(Student student, Course course) {
        this.student = student;
        this.course = course;
    }
}

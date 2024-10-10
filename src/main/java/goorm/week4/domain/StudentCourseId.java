package goorm.week4.domain;

import java.io.Serializable;
import java.util.Objects;

public class StudentCourseId implements Serializable {

    private Long student;  //Student 엔티티의 ID
    private Long course;   //Course 엔티티의 ID

    /**
     * StudentCourseId 클래스에서는 student와 course 필드의 값이 동일한지 비교하여 두 객체가 같은지 판단
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        StudentCourseId that = (StudentCourseId) o;

        return Objects.equals(student, that.student) && Objects.equals(course, that.course);
    }

    /**
     * StudentCourseId 클래스에서는 student와 course 필드의 값을 기반으로 해시 코드를 생성하여 객체를 식별
     */
    @Override
    public int hashCode() {
        return Objects.hash(student, course);
    }
}

package goorm.week4.repository;

import goorm.week4.domain.StudentCourse;
import goorm.week4.domain.StudentCourseId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, StudentCourseId> {
    List<StudentCourse> findByStudentStudentId(Long studentId);
    List<StudentCourse> findByCourseCourseId(Long courseId);
}

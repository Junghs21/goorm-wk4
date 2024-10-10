package goorm.week4.service;

import goorm.week4.domain.Course;
import goorm.week4.domain.Student;
import goorm.week4.domain.StudentCourse;
import goorm.week4.dto.StudentCourseDto;
import goorm.week4.repository.CourseRepository;
import goorm.week4.repository.StudentCourseRepository;
import goorm.week4.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentCourseService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final StudentCourseRepository studentCourseRepository;

    public StudentCourseService(StudentRepository studentRepository, CourseRepository courseRepository, StudentCourseRepository studentCourseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.studentCourseRepository = studentCourseRepository;
    }

    public List<StudentCourseDto> findStudentCoursesByStudentId(Long studentId) {
        return studentCourseRepository.findByStudentStudentId(studentId)
                .stream()
                .map(sc -> new StudentCourseDto(sc.getStudent().getStudentId(), sc.getCourse().getCourseId()))
                .collect(Collectors.toList());
    }

    public List<Long> findStudentsByCourseId(Long courseId) {
        return studentCourseRepository.findByCourseCourseId(courseId)
                .stream()
                .map(sc -> sc.getStudent().getStudentId()) //학생 학번만 반환
                .collect(Collectors.toList());
    }

    public StudentCourseDto saveStudentCourse(StudentCourseDto studentCourseDto) {
        Student student = studentRepository.findById(studentCourseDto.getStudentId()).orElseThrow();
        Course course = courseRepository.findById(studentCourseDto.getCourseId()).orElseThrow();

        StudentCourse studentCourse = new StudentCourse(student, course);
        studentCourseRepository.save(studentCourse);

        return studentCourseDto;
    }
}

package goorm.week4.controller;

import goorm.week4.dto.StudentCourseDto;
import goorm.week4.service.StudentCourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/studentcourse")
public class StudentCourseController {

    private final StudentCourseService studentCourseService;

    //학생 ID로 수강 정보 조회 후 DTO 반환
    @GetMapping("/student/{studentId}")
    public ResponseEntity<?> getStudentCoursesByStudentId(@PathVariable Long studentId) {
        List<StudentCourseDto> studentCourses = studentCourseService.findStudentCoursesByStudentId(studentId);

        if (studentCourses.isEmpty()) {
            //학생 수강 정보가 없을 경우 404와 함께 메시지 반환
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("해당 학생에 대한 수강 정보가 없습니다: 학번(Student Id) = " + studentId);
        }

        return ResponseEntity.ok(studentCourses);
    }

    //수업 ID로 수강 중인 학생 학번 조회
    @GetMapping("/course/{courseId}")
    public ResponseEntity<?> getStudentsByCourseId(@PathVariable Long courseId) {
        List<Long> studentIds = studentCourseService.findStudentsByCourseId(courseId);

        if (studentIds.isEmpty()) {
            //수업에 수강 중인 학생 정보가 없을 경우 404와 함께 메시지 반환
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("해당 수업에 대한 학생 정보가 없습니다: Course Id = " + courseId);
        }

        return ResponseEntity.ok(studentIds);
    }

    /**
     * TODO
     * StudentCourse 엔티티 생성을 위한 POST 요청 처리 로직 구현
     */
    @PostMapping
    public ResponseEntity<?> createStudentCourse(/*구현 필요*/) {
        //학생 또는 수업 정보가 없을 경우 404 메시지 반환
        try {

        } catch (IllegalArgumentException e) {

        }
    }
}

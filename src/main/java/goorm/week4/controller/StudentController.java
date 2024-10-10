package goorm.week4.controller;

import goorm.week4.dto.StudentDto;
import goorm.week4.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    //학생 ID로 학생 정보 조회 후 DTO 반환
    @GetMapping("/{studentId}")
    public ResponseEntity<?> getStudentById(@PathVariable Long studentId) {
        Optional<StudentDto> student = studentService.findStudentById(studentId);

        if (student.isPresent()) {
            return ResponseEntity.ok(student.get());
        } else {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "해당 학번의 학생이 존재하지 않습니다: 학번(Student Id) = " + studentId);

            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * TODO
     * Student 엔티티 생성을 위한 POST 요청 처리 로직 구현
     */
    @PostMapping
    public ResponseEntity<?> createStudent(/*구현 필요*/) {

        StudentDto savedStudent = studentService.saveStudent(studentDto);

        return ResponseEntity.ok(savedStudent);
    }
}

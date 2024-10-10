package goorm.week4.controller;

import goorm.week4.dto.StudentDto;
import goorm.week4.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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

    @PostMapping
    public ResponseEntity<?> createStudent(@Valid @RequestBody StudentDto studentDto, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            result.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

            return ResponseEntity.badRequest().body(errors);  //유효성 검사 실패 시 에러 메시지 반환
        }

        StudentDto savedStudent = studentService.saveStudent(studentDto);

        return ResponseEntity.ok(savedStudent);
    }
}

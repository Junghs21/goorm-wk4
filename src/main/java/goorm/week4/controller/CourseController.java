package goorm.week4.controller;

import goorm.week4.dto.CourseDto;
import goorm.week4.service.CourseService;
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
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;

    //수업 ID로 수업 정보 조회 후 DTO 반환
    @GetMapping("/{courseId}")
    public ResponseEntity<?> getCourseById(@PathVariable Long courseId) {
        Optional<CourseDto> course = courseService.findCourseById(courseId);

        if (course.isPresent()) {
            return ResponseEntity.ok(course.get());
        } else {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "해당 수업이 존재하지 않습니다: Course Id = " + courseId);

            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> createCourse(@Valid @RequestBody CourseDto courseDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> {
                errors.put(error.getField(), error.getDefaultMessage());
            });

            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }

        CourseDto savedCourse = courseService.saveCourse(courseDto);

        return ResponseEntity.ok(savedCourse);
    }
}

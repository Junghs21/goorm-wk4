package goorm.week4.service;

import goorm.week4.domain.Course;
import goorm.week4.dto.CourseDto;
import goorm.week4.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Optional<CourseDto> findCourseById(Long courseId) {
        return courseRepository.findById(courseId)
                .map(course -> new CourseDto(
                        course.getCourseId(),
                        course.getCourseName()));
    }

    public CourseDto saveCourse(CourseDto courseDto) {
        Course course = new Course(courseDto.getCourseName());
        Course savedCourse = courseRepository.save(course);

        return new CourseDto(savedCourse.getCourseId(), savedCourse.getCourseName());
    }
}

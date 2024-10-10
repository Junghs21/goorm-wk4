package goorm.week4.service;

import goorm.week4.domain.Student;
import goorm.week4.dto.StudentDto;
import goorm.week4.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Optional<StudentDto> findStudentById(Long studentId) {
        return studentRepository.findById(studentId)
                .map(student -> new StudentDto(
                        student.getStudentId(),
                        student.getStudentName(),
                        student.getMajor(),
                        student.getEmail(),
                        student.getPhoneNumber()));
    }

    public StudentDto saveStudent(StudentDto studentDto) {
        Student student = new Student(
                studentDto.getStudentId(),
                studentDto.getStudentName(),
                studentDto.getMajor(),
                studentDto.getEmail(),
                studentDto.getPhoneNumber()
        );

        studentRepository.save(student);

        return studentDto;
    }
}

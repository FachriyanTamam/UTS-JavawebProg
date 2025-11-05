package com.example.Courseapi;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private List<Course> courses = new ArrayList<>();
    private int nextId = 1;

    // GET /courses → menampilkan semua data
    @GetMapping
    public List<Course> getAllCourses() {
        return courses;
    }

    // POST /courses → menambah data baru
    @PostMapping
    public Object addCourse(@RequestBody Map<String, String> body) {
        String name = body.get("name");
        String description = body.get("description");
        String instructor = body.get("instructor");

        // Validasi: semua field harus diisi
        if (name == null || name.isEmpty() ||
            description == null || description.isEmpty() ||
            instructor == null || instructor.isEmpty()) {
            return Map.of("error", "Semua field wajib diisi");
        }

        Course newCourse = new Course(nextId++, name, description, instructor);
        courses.add(newCourse);
        return newCourse;
    }

    // DELETE /courses/{id} → hapus data berdasarkan ID
    @DeleteMapping("/{id}")
    public Object deleteCourse(@PathVariable int id) {
        Optional<Course> course = courses.stream()
                .filter(c -> c.getId() == id)
                .findFirst();

        if (course.isPresent()) {
            courses.remove(course.get());
            return Map.of("message", "Course deleted successfully");
        } else {
            return Map.of("error", "Course not found");
        }
    }
}

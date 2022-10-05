package controllers;

import general.enums.Gender;
import general.exceptions.DuplicateStudentCodeException;
import models.StudentModel;

import java.util.*;
import java.util.stream.Collectors;

public class StudentController {
    // READ
    public static List<StudentModel> getAll() {
        return StudentModel.studentList;
    }

    public static List<StudentModel> searchByName(String searchText) {
        return StudentModel.studentList.stream()
                                .filter(studentModel -> studentModel.name.contains(searchText))
                                .collect(Collectors.toList());
    }

    public static List<StudentModel> getAllSortByBirthday() {
        List<StudentModel> cloneList = new ArrayList<>(StudentModel.studentList);

        cloneList.sort(new Comparator<StudentModel>() {
            @Override
            public int compare(StudentModel std1, StudentModel std2) {
                return std1.birthday.compareTo(std2.birthday);
            }
        });

        return cloneList;
    }


    // CREATE
    public static Optional<StudentModel> create(String code, String name, Date birthday, Gender gender) {
        try {
            return Optional.of(new StudentModel(code, name, birthday, gender).save());
        } catch (DuplicateStudentCodeException e) {
            System.out.print(e.getMessage());
            return Optional.empty();
        }
    }


    // UPDATE
    public static Optional<StudentModel> update(int id, String name, Date birthday, Gender gender) {
        var thatStudent = StudentModel.studentList.stream()
                                                            .filter(student -> student.id == id)
                                                            .findAny()
                                                            .orElse(null);

        if (thatStudent == null) return Optional.empty();

        if (name != null) thatStudent.name = name;
        if (birthday != null) thatStudent.birthday = birthday;
        if (gender != null) thatStudent.gender = gender;

        return Optional.of(thatStudent);
    }


    // DELETE
    public static boolean delete(int id) {
        var thatStudent = StudentModel.studentList.stream()
                .filter(student -> student.id == id)
                .findAny()
                .orElse(null);

        if (thatStudent == null) return false;

        StudentModel.studentList.remove(thatStudent);

        return true;
    }
}

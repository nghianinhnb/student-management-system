package models;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import general.enums.Gender;
import general.exceptions.DuplicateStudentCodeException;


public final class StudentModel {
    public static List<StudentModel> studentList;

    private static int idCount = 10;

    public final int id;
    public final String code;
    public String name;
    public Date birthday;
    public Gender gender;

    // MARK: --- init ---
    static {
        try {
            JsonReader reader = new JsonReader(new FileReader("src/main/java/models/students list.json"));

            Gson gson = new Gson();

            final Type Student_List_Type = new TypeToken<ArrayList<StudentModel>>() {}.getType();
            studentList = gson.fromJson(reader, Student_List_Type);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    //

    public StudentModel(String code, String name, Date birthday, Gender gender) throws NullPointerException {
        id = idCount;
        this.code = Objects.requireNonNull(code, "Chưa nhập mã số sinh viên");
        this.name = Objects.requireNonNullElse(name, "No name");
        this.gender = gender;
        this.birthday = birthday;
    }

    public StudentModel save() throws DuplicateStudentCodeException {
        var conflict = studentList.stream().anyMatch(student -> student.code == this.code);

        if (conflict) throw new DuplicateStudentCodeException("Trùng mã số sinh viên");

        studentList.add(this);

        ++idCount;
        return this;
    }

    @Override
    public String toString() {
        return String.format("\nId: %d, Code: %s, Name: %s, Birthday: %s, Gender: %s", id, code, name, birthday.toString(), gender);
    }
}

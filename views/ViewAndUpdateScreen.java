package views;

import controllers.StudentController;
import general.enums.Gender;
import models.StudentModel;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ViewAndUpdateScreen {
    public static void show(List<StudentModel> list) {
        Scanner sc = new Scanner(System.in);

        System.out.println(list);

        while (true) {
            System.out.println("Nhập Id sinh viên muốn sửa, 0 để quay lại:  ");

            try {
                var id = Integer.parseInt(sc.nextLine());

                if (id == 0) break;

                System.out.println("Nhập tên hoặc 'del' để xóa:  ");
                var name = sc.nextLine();
                if (name.equals("del")) {
                    System.out.println( StudentController.delete(id) );
                    continue;
                }

                System.out.println("Nhập ngày sinh (MM/dd/yyyy):  ");
                DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                Date birthday = df.parse(sc.nextLine());

                System.out.println("Nhập giới tính (Nam, Nữ):  ");
                var gender = Gender.valueOf(sc.nextLine());

                System.out.println( StudentController.update(id, name, birthday, gender) );

            } catch (Exception e) {
                System.out.println("Nhập sai, hãy nhập lại");
            }
        }
    }
}

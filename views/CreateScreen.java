package views;

import controllers.StudentController;
import general.enums.Gender;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CreateScreen {
    public static void show() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Nhập thông tin sinh viên muốn thêm:  ");

            try {
                System.out.println("Nhập mã số sinh viên, '0' để quay lại:  ");
                var code = sc.nextLine();
                if (code.equals("0")) break;

                System.out.println("Nhập tên:  ");
                var name = sc.nextLine();

                System.out.println("Nhập ngày sinh (MM/dd/yyyy):  ");
                DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                Date birthday = df.parse(sc.nextLine());

                System.out.println("Nhập giới tính (Nam, Nữ):  ");
                var gender = Gender.valueOf(sc.nextLine());

                System.out.println( StudentController.create(code, name, birthday, gender) );

            } catch (Exception e) {
                System.out.println("Nhập sai, hãy nhập lại");
            }
        }
    }
}

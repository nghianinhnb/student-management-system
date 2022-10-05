package views;

import controllers.StudentController;

import java.util.Scanner;

public class MainScreen {
    public static void show() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println(
                "1. Hiển thị tất cả sinh viên \n" +
                "2. Sắp xếp theo ngày sinh \n" +
                "3. Tìm kiếm theo tên \n" +
                "4. Thêm sinh viên \n" +
                "Số bất kỳ khác để thoát \n"
            );

            var cmd = sc.nextInt();

            if (cmd == 1)       ViewAndUpdateScreen.show(StudentController.getAll());
            else if (cmd == 2)  ViewAndUpdateScreen.show(StudentController.getAllSortByBirthday());
            else if (cmd == 3)  SearchScreen.show();
            else if (cmd == 4)  CreateScreen.show();
            else break;
        }

        sc.close();
    }
}

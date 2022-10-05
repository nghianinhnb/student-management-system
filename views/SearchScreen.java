package views;

import controllers.StudentController;

import java.util.Scanner;

public class SearchScreen {
    public static void show() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Nhập để tìm kiếm theo tên, 0 để quay lại:  ");

            var searchText = sc.nextLine();

            if (searchText.equals("0")) break;

            if (searchText.length() > 0) System.out.println(StudentController.searchByName(searchText));
        }

    }
}

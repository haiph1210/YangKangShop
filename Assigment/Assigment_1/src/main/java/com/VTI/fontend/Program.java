package com.VTI.fontend;

import java.util.Scanner;

public class Program {
    private static Scanner scanner = new Scanner(System.in);
    private static FunctionProgram function = new FunctionProgram();
    public static void main(String[] args) {
        while (true){
            System.out.println("==================Menu======================");
            System.out.println("=1.Show All                                =");
            System.out.println("=2.Create Group                            =");
            System.out.println("=3.Update Group                            =");
            System.out.println("=4.Delete Group                            =");
            System.out.println("=5.FindByID                                =");
            System.out.println("=6.FindByName                              =");
            System.out.println("=7.Exit                                    =");
            System.out.println("============================================");
            int choose = scanner.nextInt();
            switch (choose){
                case 1:
                    function.showAll();
                    break;
                case 2:
                    function.createGroup();
                    break;
                case 3:
                    function.updateGroup();
                    break;
                case 4:
                    function.deleteGroup();
                    break;
                case 5:
                    function.showByID();
                    break;
                case 6:
                    function.showByName();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Nhập sai");
                    break;
            }
        }



    }
}

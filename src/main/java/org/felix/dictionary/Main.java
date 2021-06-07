package org.felix.dictionary;

import org.felix.dictionary.business.BusinessLogic;
import org.felix.dictionary.model.City;
import org.felix.dictionary.utils.Parser;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
//    public static void clearScreen()
//    {
//        System.out.print("\033[H\033[2J");
//        System.out.flush();
//    }
    public static void main(String[] args) throws IOException, SQLException {
        BusinessLogic business = new BusinessLogic();
        Scanner userScan = new Scanner(System.in);
        Parser.menu();
        int i = 1;
        while(i != 0){
            i = userScan.nextInt();
            switch (i) {
                case 0:
                    i = 0;
                    break;
                case 1:
                    business.display(business.getCities());
                    break;
                case 2:
                    business.sorter(business.getCities());
                    break;
                case 3:
                    business.maxPop(business.getCities());
                    break;
                case 4:
                    business.kolNameInReg(business.getCities());
                    break;
                case 5:
                    Parser.menu();
                    break;
                case 6:
                    userScan.nextLine();
                    String str = userScan.nextLine();
                    business = new BusinessLogic(str);
                    break;
                case 7:
                    business.createTable();
                    break;
                case 8:
                    business.insertInTable();
                    break;
                case 9:
                    business.updateInTable();
                    break;
                case 10:
                    business.deleteInTable();
                    break;
                case 11:
                    business.readFromTable();
                    break;
                default:
                    System.out.println("Не могу это выполнить, у меня лапки");
            }
        }
    }
}

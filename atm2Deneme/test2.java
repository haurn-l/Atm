package atm2Deneme;

import java.util.Scanner;

public class test2 {
    static QueryIMPL queryIMPL = new QueryIMPL();
    static Scanner sc = new Scanner(System.in);
    static String accountPassword;
    static int balance;

    public static void main(String[] args) {
        queryIMPL.connection();
        System.out.println("Hoşgeldiniz");
        System.out.print("Lütfen hesap şifrenizi giriniz: ");
        accountPassword = sc.next();
        int option;
        do {
            menu();
            option = selectOption();
            optionControl(option);
            if (option != 7) {
                returnMenu();
            }
        } while (option != 7);

        queryIMPL.updateBalance(accountPassword, balance);
        queryIMPL.close();
    }

    public static void menu() {
        System.out.println("MENU");
        System.out.println("1- BAKİYE SORGULAMA");
        System.out.println("2- PARA YATIRMA");
        System.out.println("3- PARA ÇEKME");
        System.out.println("4- TELEFON NUMARASI GÜNCELLEME");
        System.out.println("5- ŞİFRE GÜNCELLEME");
        System.out.println("6- HESAP SİL");
        System.out.println("7- ÇIKIŞ");
    }

    public static int selectOption() {
        System.out.print("Yapmak istediğiniz işlem numarasını giriniz: ");
        return sc.nextInt();
    }

    public static void returnMenu() {
        System.out.println("Ana menüye dönmek için bir tuşa basınız.");
        sc.nextLine();
        sc.nextLine();
    }

    public static void optionControl(int option) {
        switch (option) {
            case 1:
                balance = queryIMPL.costumerInfoBalance(accountPassword);
                System.out.println(balance);
                break;
            case 2:
                System.out.print("Yatırılacak miktarı giriniz: ");
                int deposit = sc.nextInt();
                balance += deposit;
                queryIMPL.updateBalance(accountPassword, balance);
                break;
            case 3:
                System.out.print("Çekilecek miktarı giriniz: ");
                int withdraw = sc.nextInt();
                if (balance >= withdraw) {
                    balance -= withdraw;
                    queryIMPL.updateBalance(accountPassword, balance);
                } else {
                    System.out.println("Yetersiz bakiye.");
                }
                break;
            case 4:
                System.out.print("Yeni telefon numarasını giriniz: ");
                String newPhoneNumber = sc.next();
                queryIMPL.updatePhoneNumber(accountPassword, newPhoneNumber);
                break;
            case 5:
                System.out.print("Yeni şifrenizi giriniz: ");
                String newPassword = sc.next();
                queryIMPL.updateAccountPassword(accountPassword, newPassword);
                break;
            case 6:
                queryIMPL.removeCostumer(accountPassword);
                break;
            case 7:
                System.out.println("Çıkılıyor...");
                break;
            default:
                System.out.println("Geçersiz işlem!");
                break;
        }
    }
}

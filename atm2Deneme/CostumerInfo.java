package atm2Deneme;

public class CostumerInfo {
    private String accountPassword;
    private String name;
    private String surname;
    private int year;
    private String phoneNumber;
    private int balance;


    public CostumerInfo() {
    }

    public CostumerInfo(String accountPassword, String name, String surname, int year, String phoneNumber, int balance) {
        this.accountPassword = accountPassword;
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "CostumerInfo{" +
                "accountPassword='" + accountPassword + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", year=" + year +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", balance=" + balance +
                '}';
    }
}

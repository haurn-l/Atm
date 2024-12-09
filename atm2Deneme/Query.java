package atm2Deneme;

public interface Query {
        void connection();
        void removeCostumer(String accountPassword);
        void costumerInfo(int account_id);
        int costumerInfoBalance(String accountPassword);
        void updateBalance(String accountPassword, int newBalance);
        void updateAccountPassword(String accPassword, String newPassword);
        void updatePhoneNumber(String accPassword, String newPhoneNumber);
        void close();


}

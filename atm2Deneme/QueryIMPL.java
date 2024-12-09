package atm2Deneme;

import java.sql.*;

public class QueryIMPL implements Query {
    static Connection connection = null;
    static PreparedStatement pStatement = null;
    static ResultSet resultSet = null;

    @Override
    public void connection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Bağlanılıyor...");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver'a bağlanılamadı. Hata: " + e.getMessage());
        }

        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost/uygulama", "root", "2024123011Qk!");
            System.out.println("Connection bağlantısı başarılı.");
        } catch (SQLException e) {
            System.out.println("Connection bağlantısı yapılamadı. Hata: " + e.getMessage());
        }
    }

    @Override
    public void removeCostumer(String accountPassword) {
        String query = "DELETE FROM Costumer WHERE ACCOUNT_PASSWORD=?";
        try {
            pStatement = connection.prepareStatement(query);
            pStatement.setString(1, accountPassword);
            pStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Hesap silinirken hata oluştu. Hata: " + e.getMessage());
        }
    }

    @Override
    public void costumerInfo(int account_id) {
        String query = "SELECT * FROM Costumer WHERE id=?";
        try {
            pStatement = connection.prepareStatement(query);
            pStatement.setInt(1, account_id);
            resultSet = pStatement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("NAME");
                String surname = resultSet.getString("SURNAME");
                int year = resultSet.getInt("YEAR");
                String phoneNumber = resultSet.getString("PHONE_NUMBER");
                int balance = resultSet.getInt("BALANCE");
                System.out.println("ID: " + id + ", Name: " + name + ", Surname: " + surname + ", Year: " + year + ", Phone: " + phoneNumber + ", Balance: " + balance);
            } else {
                System.err.println("Hesap bulunamadı.");
            }
        } catch (SQLException e) {
            System.err.println("Müşteri bilgilerini alırken hata oluştu. Hata: " + e.getMessage());
        }
    }

    @Override
    public int costumerInfoBalance(String accountPassword) {
        String query = "SELECT * FROM Costumer WHERE ACCOUNT_PASSWORD=?";
        try {
            pStatement = connection.prepareStatement(query);
            pStatement.setString(1, accountPassword);
            resultSet = pStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("BALANCE");
            } else {
                System.err.println("Hesap bulunamadı.");
                return 0;
            }
        } catch (SQLException e) {
            System.err.println("Bakiye sorgulama hatası: " + e.getMessage());
            return 0;
        }
    }

    @Override
    public void updateBalance(String accountPassword, int newBalance) {
        String query = "UPDATE Costumer SET BALANCE=? WHERE ACCOUNT_PASSWORD=?";
        try {
            pStatement = connection.prepareStatement(query);
            pStatement.setInt(1, newBalance);
            pStatement.setString(2, accountPassword);
            pStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Bakiye güncellenirken hata oluştu. Hata: " + e.getMessage());
        }
    }

    @Override
    public void updateAccountPassword(String accPassword, String newPassword) {
        String query = "UPDATE Costumer SET ACCOUNT_PASSWORD=? WHERE ACCOUNT_PASSWORD=?";
        try {
            pStatement = connection.prepareStatement(query);
            pStatement.setString(1, newPassword);
            pStatement.setString(2, accPassword);
            pStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Şifre güncellenirken hata oluştu. Hata: " + e.getMessage());
        }
    }

    @Override
    public void updatePhoneNumber(String accPassword, String newPhoneNumber) {
        String query = "UPDATE Costumer SET PHONE_NUMBER=? WHERE ACCOUNT_PASSWORD=?";
        try {
            pStatement = connection.prepareStatement(query);
            pStatement.setString(1, newPhoneNumber);
            pStatement.setString(2, accPassword);
            pStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Telefon numarası güncellenirken hata oluştu. Hata: " + e.getMessage());
        }
    }

    @Override
    public void close() {
        if (pStatement!=null){
            try {
                pStatement.close();
                System.out.println("pStatment basarılı bir sekilde kapatıldı");
            } catch (SQLException e) {
                System.err.println("pStatement kapatılırken bir sorun olustu");
                System.out.println(e.getMessage());
            }
        }
        if (connection!=null){
            try {
                connection.close();
                System.out.println("Connection basarılı bir sekilde kapatıldı.");
            } catch (SQLException e) {
                System.err.println("Connection kapatılırken hata olusutu.Hata : "+e.getMessage());
            }
        }
        if (resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                System.err.println("resultSet kapatılırken bir hata oluştu. HATA : "+e.getMessage());
            }
        }
    }
}

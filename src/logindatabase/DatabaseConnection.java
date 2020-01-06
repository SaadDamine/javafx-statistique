package logindatabase;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import logindatabase.models.GetElement;
import logindatabase.models.moy_math_info;

/**
 *
 * @author dell
 */
public class DatabaseConnection {

    private static Connection connection;

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                try {
                    DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/datam", "root", "");
                } catch (SQLException ex) {
                }
            }
            return connection;
        } catch (SQLException ex) {
            return null;
        }
    }

    public static ObservableList<Integer> getYear() {
        Statement statement = null;
        String sql = "SELECT scholar_year from dim_bac GROUP BY scholar_year;";
        try {
            statement = DatabaseConnection.getConnection().createStatement();

            ObservableList<Integer> ol;
            try (ResultSet result = statement.executeQuery(sql)) {
                ol = FXCollections.observableArrayList();
                while (result.next()) {
                    ol.add(result.getInt(1));
                }
            }
            return ol;
        } catch (SQLException ex) {
            System.out.println("[failed]");
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                }
            }
            try {
                DatabaseConnection.getConnection().close();
            } catch (SQLException ex) {
            }
        }
    }

    public static ObservableList<Integer> getYearModl() {
        Statement statement = null;
        String sql = "SELECT scholar_year from  dim_modl_moy GROUP BY scholar_year;";
        try {
            statement = DatabaseConnection.getConnection().createStatement();

            ObservableList<Integer> ol;
            try (ResultSet result = statement.executeQuery(sql)) {
                ol = FXCollections.observableArrayList();
                while (result.next()) {
                    ol.add(result.getInt(1));
                }
            }
            return ol;
        } catch (SQLException ex) {
            System.out.println("[failed]");
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                }
            }
            try {
                DatabaseConnection.getConnection().close();
            } catch (SQLException ex) {
            }
        }
    }

    public static ObservableList<GetElement> getGender(int y, String m, String s) {
        Statement statement = null;
        String sql = "SELECT gender,COUNT(*) from dim_student where id_student in(SELECT id_student from fact where `status`='" + m + "' and id_semester in (SELECT id_semester from dim_semester where semester in (SELECT semester from year_std where year_std.title_branch='" + s + "'))  and id_date in (SELECT id_date from dim_bac where dim_bac.scholar_year=" + y + "))GROUP BY gender;";
        try {
            statement = DatabaseConnection.getConnection().createStatement();

            ObservableList<GetElement> ol;
            try (ResultSet result = statement.executeQuery(sql)) {
                ol = FXCollections.observableArrayList();
                while (result.next()) {
                    ol.add(new GetElement(result.getString(1), result.getInt(2)));
                }
            }
            return ol;
        } catch (SQLException ex) {
            System.out.println("[failed]");
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                }
            }
            try {
                DatabaseConnection.getConnection().close();
            } catch (SQLException ex) {
            }
        }
    }

    public static ObservableList<GetElement> getGender(int y, String s) {
        Statement statement = null;
        String sql = "SELECT gender,COUNT(*) from dim_student where id_student in(SELECT id_student from fact where id_semester in (SELECT id_semester from dim_semester where semester in (SELECT semester from year_std where year_std.title_branch='" + s + "'))  and id_date in (SELECT id_date from dim_bac where dim_bac.scholar_year=" + y + "))GROUP BY gender;";
        try {
            statement = DatabaseConnection.getConnection().createStatement();

            ObservableList<GetElement> ol;
            try (ResultSet result = statement.executeQuery(sql)) {
                ol = FXCollections.observableArrayList();
                while (result.next()) {
                    ol.add(new GetElement(result.getString(1), result.getInt(2)));
                }
            }
            return ol;
        } catch (SQLException ex) {
            System.out.println("[failed]");
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                }
            }
            try {
                DatabaseConnection.getConnection().close();
            } catch (SQLException ex) {
            }
        }
    }

    public static ObservableList<moy_math_info> getStudent(int y) {
        Statement statement = null;
        String sql = "SELECT id_student,moyMath,moyInfo from sp_std where scholar_year=" + y + ";";
        try {
            statement = DatabaseConnection.getConnection().createStatement();

            ObservableList<moy_math_info> ol;
            try (ResultSet result = statement.executeQuery(sql)) {
                ol = FXCollections.observableArrayList();
                while (result.next()) {
                    ol.add(new moy_math_info(result.getBigDecimal(1), result.getFloat(2), result.getFloat(3)));
                }
            }
            return ol;
        } catch (SQLException ex) {
            System.out.println("[failed]");
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                }
            }
            try {
                DatabaseConnection.getConnection().close();
            } catch (SQLException ex) {
            }
        }
    }

    public static ObservableList<GetElement> getNationality(int y, String m, String s) {
        Statement statement = null;
        String sql = "SELECT nationality,COUNT(*) from dim_student where id_student in(SELECT id_student from fact where `status`='" + m + "' and id_semester in (SELECT id_semester from dim_semester where semester in (SELECT semester from year_std where year_std.title_branch='" + s + "'))  and id_date in (SELECT id_date from dim_bac where dim_bac.scholar_year=" + y + "))GROUP BY nationality;";
        try {
            statement = DatabaseConnection.getConnection().createStatement();

            ObservableList<GetElement> ol;
            try (ResultSet result = statement.executeQuery(sql)) {
                ol = FXCollections.observableArrayList();
                while (result.next()) {
                    ol.add(new GetElement(result.getString(1), result.getInt(2)));
                }
            }
            return ol;
        } catch (SQLException ex) {
            System.out.println("[failed]");
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                }
            }
            try {
                DatabaseConnection.getConnection().close();
            } catch (SQLException ex) {
            }
        }
    }

    public static ObservableList<GetElement> getNationality(int y, String s) {
        Statement statement = null;
        String sql = "SELECT nationality,COUNT(*) from dim_student where id_student in(SELECT id_student from fact where id_semester in (SELECT id_semester from dim_semester where semester in (SELECT semester from year_std where year_std.title_branch='" + s + "'))  and id_date in (SELECT id_date from dim_bac where dim_bac.scholar_year=" + y + "))GROUP BY nationality;";
        try {
            statement = DatabaseConnection.getConnection().createStatement();

            ObservableList<GetElement> ol;
            try (ResultSet result = statement.executeQuery(sql)) {
                ol = FXCollections.observableArrayList();
                while (result.next()) {
                    ol.add(new GetElement(result.getString(1), result.getInt(2)));
                }
            }
            return ol;
        } catch (SQLException ex) {
            System.out.println("[failed]");
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                }
            }
            try {
                DatabaseConnection.getConnection().close();
            } catch (SQLException ex) {
            }
        }
    }

    public static ObservableList<GetElement> OriginCity(int y, String m, String s) {
        Statement statement = null;
        String sql = "SELECT bac_wilaya,COUNT(*) from dim_bac where id_date in(SELECT id_date from fact where `status`='" + m + "' and id_semester in (SELECT id_semester from dim_semester where semester in (SELECT semester from year_std where year_std.title_branch='" + s + "'))  and id_date in (SELECT id_date from dim_bac where dim_bac.scholar_year=" + y + "))GROUP BY bac_wilaya;";
        try {
            statement = DatabaseConnection.getConnection().createStatement();

            ObservableList<GetElement> ol;
            try (ResultSet result = statement.executeQuery(sql)) {
                ol = FXCollections.observableArrayList();
                while (result.next()) {
                    ol.add(new GetElement(result.getString(1), result.getInt(2)));
                }
            }
            return ol;
        } catch (SQLException ex) {
            System.out.println("[failed]");
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                }
            }
            try {
                DatabaseConnection.getConnection().close();
            } catch (SQLException ex) {
            }
        }
    }

    public static ObservableList<GetElement> OriginCity(int y, String s) {
        Statement statement = null;
        String sql = "SELECT bac_wilaya,COUNT(*) from dim_bac where id_date in(SELECT id_date from fact where id_semester in (SELECT id_semester from dim_semester where semester in (SELECT semester from year_std where year_std.title_branch='" + s + "'))  and id_date in (SELECT id_date from dim_bac where dim_bac.scholar_year=" + y + "))GROUP BY bac_wilaya;";
        try {
            statement = DatabaseConnection.getConnection().createStatement();

            ObservableList<GetElement> ol;
            try (ResultSet result = statement.executeQuery(sql)) {
                ol = FXCollections.observableArrayList();
                while (result.next()) {
                    ol.add(new GetElement(result.getString(1), result.getInt(2)));
                }
            }
            return ol;
        } catch (SQLException ex) {
            System.out.println("[failed]");
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                }
            }
            try {
                DatabaseConnection.getConnection().close();
            } catch (SQLException ex) {
            }
        }
    }

    public static ObservableList<GetElement> ModulesAdmin(int y) {
        Statement statement = null;
        String sql = "SELECT id_course,COUNT(*) from  dim_modl_moy where average>=10 and scholar_year=" + y + " GROUP  BY id_course,scholar_year;";
        try {
            statement = DatabaseConnection.getConnection().createStatement();

            ObservableList<GetElement> ol;
            try (ResultSet result = statement.executeQuery(sql)) {
                ol = FXCollections.observableArrayList();
                while (result.next()) {
                    ol.add(new GetElement(result.getString(1), result.getInt(2)));
                }
            }
            return ol;
        } catch (SQLException ex) {
            System.out.println("[failed]");
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                }
            }
            try {
                DatabaseConnection.getConnection().close();
            } catch (SQLException ex) {
            }
        }
    }

    public static ObservableList<GetElement> ModulesAjourné(int y) {
        Statement statement = null;
        String sql = "SELECT id_course,COUNT(*) from  dim_modl_moy where average<10 and scholar_year=" + y + " GROUP  BY id_course,scholar_year;";
        try {
            statement = DatabaseConnection.getConnection().createStatement();

            ObservableList<GetElement> ol;
            try (ResultSet result = statement.executeQuery(sql)) {
                ol = FXCollections.observableArrayList();
                while (result.next()) {
                    ol.add(new GetElement(result.getString(1), result.getInt(2)));
                }
            }
            return ol;
        } catch (SQLException ex) {
            System.out.println("[failed]");
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                }
            }
            try {
                DatabaseConnection.getConnection().close();
            } catch (SQLException ex) {
            }
        }
    }

    public static ObservableList<GetElement> ModulesAdminEx(int y) {
        Statement statement = null;
        String sql = "SELECT id_course,COUNT(*) from  dim_modl_moy where exam>=10 and scholar_year=" + y + " and exam!='null' GROUP  BY id_course,scholar_year;";
        try {
            statement = DatabaseConnection.getConnection().createStatement();

            ObservableList<GetElement> ol;
            try (ResultSet result = statement.executeQuery(sql)) {
                ol = FXCollections.observableArrayList();
                while (result.next()) {
                    ol.add(new GetElement(result.getString(1), result.getInt(2)));
                }
            }
            return ol;
        } catch (SQLException ex) {
            System.out.println("[failed]");
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                }
            }
            try {
                DatabaseConnection.getConnection().close();
            } catch (SQLException ex) {
            }
        }
    }

    public static ObservableList<GetElement> ModulesAjournéEx(int y) {
        Statement statement = null;
        String sql = "SELECT id_course,COUNT(*) from  dim_modl_moy where exam<10 and scholar_year=" + y + " and exam!='null' GROUP  BY id_course,scholar_year;";
        try {
            statement = DatabaseConnection.getConnection().createStatement();

            ObservableList<GetElement> ol;
            try (ResultSet result = statement.executeQuery(sql)) {
                ol = FXCollections.observableArrayList();
                while (result.next()) {
                    ol.add(new GetElement(result.getString(1), result.getInt(2)));
                }
            }
            return ol;
        } catch (SQLException ex) {
            System.out.println("[failed]");
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                }
            }
            try {
                DatabaseConnection.getConnection().close();
            } catch (SQLException ex) {
            }
        }
    }

    public static ObservableList<GetElement> ModulesAdminTd(int y) {
        Statement statement = null;
        String sql = "SELECT id_course,COUNT(*) from  dim_modl_moy where td>=10 and scholar_year=" + y + " and td!='null' GROUP  BY id_course,scholar_year;";
        try {
            statement = DatabaseConnection.getConnection().createStatement();

            ObservableList<GetElement> ol;
            try (ResultSet result = statement.executeQuery(sql)) {
                ol = FXCollections.observableArrayList();
                while (result.next()) {
                    ol.add(new GetElement(result.getString(1), result.getInt(2)));
                }
            }
            return ol;
        } catch (SQLException ex) {
            System.out.println("[failed]");
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                }
            }
            try {
                DatabaseConnection.getConnection().close();
            } catch (SQLException ex) {
            }
        }
    }

    public static ObservableList<GetElement> ModulesAjournéTd(int y) {
        Statement statement = null;
        String sql = "SELECT id_course,COUNT(*) from  dim_modl_moy where td<10 and scholar_year=" + y + " and td!='null' GROUP  BY id_course,scholar_year;";
        try {
            statement = DatabaseConnection.getConnection().createStatement();

            ObservableList<GetElement> ol;
            try (ResultSet result = statement.executeQuery(sql)) {
                ol = FXCollections.observableArrayList();
                while (result.next()) {
                    ol.add(new GetElement(result.getString(1), result.getInt(2)));
                }
            }
            return ol;
        } catch (SQLException ex) {
            System.out.println("[failed]");
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                }
            }
            try {
                DatabaseConnection.getConnection().close();
            } catch (SQLException ex) {
            }
        }
    }

    public static ObservableList<GetElement> ModulesAdminTp(int y) {
        Statement statement = null;
        String sql = "SELECT id_course,COUNT(*) from  dim_modl_moy where tp>=10 and scholar_year=" + y + " and tp!='null' GROUP  BY id_course,scholar_year;";
        try {
            statement = DatabaseConnection.getConnection().createStatement();

            ObservableList<GetElement> ol;
            try (ResultSet result = statement.executeQuery(sql)) {
                ol = FXCollections.observableArrayList();
                while (result.next()) {
                    ol.add(new GetElement(result.getString(1), result.getInt(2)));
                }
            }
            return ol;
        } catch (SQLException ex) {
            System.out.println("[failed]");
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                }
            }
            try {
                DatabaseConnection.getConnection().close();
            } catch (SQLException ex) {
            }
        }
    }

    public static ObservableList<GetElement> ModulesAjournéTp(int y) {
        Statement statement = null;
        String sql = "SELECT id_course,COUNT(*) from  dim_modl_moy where tp<10 and scholar_year=" + y + " and tp!='null' GROUP  BY id_course,scholar_year;";
        try {
            statement = DatabaseConnection.getConnection().createStatement();

            ObservableList<GetElement> ol;
            try (ResultSet result = statement.executeQuery(sql)) {
                ol = FXCollections.observableArrayList();
                while (result.next()) {
                    ol.add(new GetElement(result.getString(1), result.getInt(2)));
                }
            }
            return ol;
        } catch (SQLException ex) {
            System.out.println("[failed]");
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                }
            }
            try {
                DatabaseConnection.getConnection().close();
            } catch (SQLException ex) {
            }
        }
    }

    public static void main(String[] args) {
        
    }
}

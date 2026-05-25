package banco.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    public static Connection conectar() {
        try {
            Class.forName("org.sqlite.JDBC");

            String caminho = System.getProperty("user.dir") + "/banco/data";

            new java.io.File(caminho).mkdirs();

            String url = "jdbc:sqlite:" + caminho + "/banco.db";

            return DriverManager.getConnection(url);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
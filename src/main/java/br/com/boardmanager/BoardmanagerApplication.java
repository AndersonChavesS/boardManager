package br.com.boardmanager;

import br.com.boardmanager.persistence.migration.MigrationStrategy;
import br.com.boardmanager.ui.MainMenu;


import java.sql.SQLException;

import static br.com.boardmanager.persistence.config.ConnectionConfig.getConnection;


public class BoardmanagerApplication {

    public static void main(String[] args) throws SQLException {
        try (var connection = getConnection()) {
            new MigrationStrategy(connection).executeMigration();
        }
        new MainMenu().execute();
    }

}

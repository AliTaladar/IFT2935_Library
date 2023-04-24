package com.postgresqltutorial;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Query {
    private String command;
    private String[] columns;
    private Connection c;

    public Query(String command, String[] columns) {
        this.command = command;
        this.columns = columns;
        this.c = PostgreSQLJDBC.connection();
    }

    public String runQuery() {
        try {
            ResultSet rs = getResults();
            String result = resultToString(rs);
            rs.getStatement().close();
            c.close();
            return result;
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    private ResultSet getResults() throws SQLException {
        if (c == null) {
            throw new SQLException("Connection is null");
        }
        Statement statement = c.createStatement();
        String SQL = command;
        return statement.executeQuery(SQL);
    }

    private String resultToString(ResultSet resultSet) throws SQLException {
        StringBuilder sb = new StringBuilder();

        while (resultSet.next()) {
            for (int i = 0; i < columns.length; i++) {
                sb.append(resultSet.getString(columns[i]));
                if (i != columns.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}

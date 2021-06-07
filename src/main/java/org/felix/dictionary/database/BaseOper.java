package org.felix.dictionary.database;

import java.sql.SQLException;

public interface BaseOper<City> {
    public void createCity() throws SQLException;
    void updateCity( ) throws SQLException;
    void deleteCity( )throws SQLException;
    void readCity( ) throws SQLException;
    void insertCity( ) throws SQLException;
}

package com.company;

import com.sun.deploy.util.StringUtils;
import org.neo4j.jdbc.Driver;
import org.neo4j.jdbc.Neo4jConnection;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by deeshu on 09/06/14.
 */
public class OrganizerInterface {
    public OrganizerInterface() {
        Connector connector = new Connector("localhost", 7474);
        try {
            connector.addPart("GPU", "'Sapphire HD7950'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        while (true) {
//
//        }
    }
}

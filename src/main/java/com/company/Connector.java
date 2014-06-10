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
 * Created by deeshu on 10/06/14.
 */
public class Connector {
    String address;
    int port;

    public Connector(String address, int port) {
        this.address = address;
        this.port = port;
    }

    public void addPart(String type, String model) throws SQLException {
        Neo4jConnection connect = null;

        connect = new Driver().
                connect("jdbc:neo4j://"+address+":"+port, new Properties());


//        connect.prepareStatement("CREATE ");

//        List<String> dataLoad = new ArrayList<String>();
        connect.createStatement().executeQuery("CREATE (n:"+type+" { model: "+model+" })");
//        dataLoad.add("CREATE (person2 { personId: 2, started: 1361708546, left: 1371708646 })");
//        dataLoad.add("CREATE (company { companyId: 1 })");
//
//        connect.createStatement().executeQuery(StringUtils.join(dataLoad, "\n"));

        ResultSet resultSet = null;
        resultSet = connect.createStatement().
                executeQuery("MATCH (person1  {personId:1}) RETURN person1");

        if (resultSet.next())

        {
            Map<String, Object> e = (Map<String, Object>) resultSet.getObject("person1");


            System.out.println("personId: " + e.get("personId") + ", started: " + e.get("started"));
        }
            connect.close();
    }



    public List<String> getPartsByModel(String model) {
        return null;
    }
}

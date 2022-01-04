import org.h2.tools.RunScript;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainTest {
    Connection connection;
    PreparedStatement ps;
    String line;
    List<String> dataToEnter = new ArrayList<>();

    @Before
    public void setUp(){
        try {
            Class.forName("org.h2.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:h2:~/test;MODE=PostgreSQL;DATABASE_TO_LOWER=TRUE", "sa", "");

//            RunScript.execute(connection, new FileReader("resources/createAllTables.sql"));
//            RunScript.execute(connection, new FileReader("resources/deleteAllTables.sql"));
            RunScript.execute(connection, new FileReader("resources/deleteAllData.sql"));
            RunScript.execute(connection, new FileReader("resources/resetIDCount.sql"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sthing(){
    }

    private ResultSet insertAccommodationData(BufferedReader reader) throws IOException, SQLException {
        while ((line = reader.readLine()) != null) {
            dataToEnter.addAll(Arrays.asList(line.split("\"")));

            ps = connection.prepareStatement("INSERT INTO accommodation(type, bed_type,max_guests, description) VALUES (?,?,?,?)");
            ps.setString(1, dataToEnter.get(1));
            ps.setString(2, dataToEnter.get(3));
            ps.setInt(3, Integer.parseInt(dataToEnter.get(5)));
            ps.setString(4, dataToEnter.get(7));
            ps.executeUpdate();

            dataToEnter.clear();
        }
        return connection.createStatement().executeQuery("SELECT * from accommodation");
    }

    private ResultSet insertRoomFareData(BufferedReader reader) throws IOException, SQLException {
        while ((line = reader.readLine()) != null) {
            dataToEnter.addAll(Arrays.asList(line.split("\"")));

            ps = connection.prepareStatement("INSERT INTO room_fare(value,season) VALUES (?,?)");
            ps.setDouble(1, Double.parseDouble(dataToEnter.get(1)));
            ps.setString(2, dataToEnter.get(3));
            ps.executeUpdate();

            dataToEnter.clear();
        }
        return connection.createStatement().executeQuery("SELECT * from room_fare");
    }

    private ResultSet insertAccommodationRoomRelationData(BufferedReader reader) throws IOException, SQLException {

        while ((line = reader.readLine()) != null) {
            dataToEnter.addAll(Arrays.asList(line.split("\"")));

            ps = connection.prepareStatement("INSERT INTO accommodation_fare_relation(id_accommodation,id_room_fare) VALUES (?,?)");
            ps.setInt(1, Integer.parseInt(dataToEnter.get(1)));
            ps.setInt(2, Integer.parseInt(dataToEnter.get(3)));
            ps.executeUpdate();

            dataToEnter.clear();
        }
        return connection.createStatement().executeQuery("SELECT * from accommodation_fare_relation");
    }

    @Test
    public void testInsertRelationData() throws IOException, SQLException {
        insertAccommodationData(Files.newBufferedReader(new File("resources/dataAccommodation.csv").toPath()));
        insertRoomFareData(Files.newBufferedReader(new File("resources/dataRoomFare.csv").toPath()));

        ResultSet rs = insertAccommodationRoomRelationData(Files.newBufferedReader(new File("resources/dataAccommodationRoomFareRelation.csv").toPath()));

        String format = "%5s%20s%10s\n";
        boolean hasResults = rs.next();
        if (hasResults) {
            System.out.format(format, "ID", "Accommodation_id", "Room_id");
            do {
                System.out.format(format, rs.getInt("id"),
                        rs.getInt("id_accommodation"),
                        rs.getInt("id_room_fare"));
            } while (rs.next());
        } else {
            System.out.println("No results");
        }
        connection.close();
    }

    @Test
    public void testInsertAccommodationData() throws IOException, SQLException {
        ResultSet rs = insertAccommodationData(Files.newBufferedReader(new File("resources/dataAccommodation.csv").toPath()));

        String format = "%5s%15s%35s%10s%s\n";
        boolean hasResults = rs.next();
        if (hasResults) {
            System.out.format(format, "ID", "Type", "Bed type", "\tMax guests", "\tDescription");
            do {
                System.out.format(format, rs.getInt("id"),
                        rs.getString("type"),
                        rs.getString("bed_type"),
                        "\t" + rs.getInt("max_guests"),
                        "\t" + rs.getString("description").substring(0, 70));
            } while (rs.next());
        } else {
            System.out.println("No results");
        }
        connection.close();
    }

    @Test
    public void testInsertRoomFareData() throws IOException, SQLException {
        ResultSet rs = insertRoomFareData(Files.newBufferedReader(new File("resources/dataRoomFare.csv").toPath()));

        String format = "%5s%10s%s\n";
        boolean hasResults = rs.next();
        if (hasResults) {
            System.out.format(format, "ID", "Price", "\tSeason");
            do {
                System.out.format(format, rs.getInt("id"),
                        rs.getDouble("value"),
                        "\t" + rs.getString("season"));
            } while (rs.next());
        } else {
            System.out.println("No results");
        }
        connection.close();
    }

    @Test
    public void testListAllRoomData() throws IOException, SQLException {
        insertAccommodationData(Files.newBufferedReader(new File("resources/dataAccommodation.csv").toPath()));
        insertRoomFareData(Files.newBufferedReader(new File("resources/dataRoomFare.csv").toPath()));
        insertAccommodationRoomRelationData(Files.newBufferedReader(new File("resources/dataAccommodationRoomFareRelation.csv").toPath()));

        ResultSet rs = connection.createStatement().executeQuery("Select a.type, a.bed_type, a.max_guests, r.value, r.season " +
                "from accommodation a " +
                "inner join accommodation_fare_relation af " +
                "on  a.id = af.id_accommodation " +
                "inner join room_fare r " +
                "on r.id = af.id_room_fare " +
                "order by r.value");

        String format = "%15s%35s%12s%10s%15s\n";
        boolean hasResults = rs.next();
        if (hasResults) {
            System.out.format(format, "Type", "Beds available", "Max Guests", "Price", "Season");
            do {
                System.out.format(format, rs.getString("type"),
                        rs.getString("bed_type"),
                        rs.getInt("max_guests"),
                        new DecimalFormat("0.00").format(rs.getDouble("value")),
                        rs.getString("season"));
            } while (rs.next());
        } else {
            System.out.println("No results");
        }
        connection.close();
    }

    @Test
    public void testListResultsByMinPriceByRoom() throws SQLException, IOException {
        insertAccommodationData(Files.newBufferedReader(new File("resources/dataAccommodation.csv").toPath()));
        insertRoomFareData(Files.newBufferedReader(new File("resources/dataRoomFare.csv").toPath()));
        insertAccommodationRoomRelationData(Files.newBufferedReader(new File("resources/dataAccommodationRoomFareRelation.csv").toPath()));

        ResultSet rs = connection.createStatement().executeQuery("select a.type,a.bed_type,a.max_guests, r1.value, season from room_fare r1\n" +
                "join (select min(r.value) as minv ,af.id_accommodation from room_fare r\n" +
                "join accommodation_fare_relation af\n" +
                " on r.id = af.id_room_fare\n" +
                "group by af.id_accommodation) as st\n" +
                "on r1.value = minv\n" +
                "join accommodation a\n" +
                "on st.id_accommodation = a.id " +
                "order by r1.value");

//        ResultSetMetaData rsmd = rs.getMetaData();
//        System.out.println(rsmd.getColumnName(1));

        String format = "%15s%35s%12s%10s%12s\n";
        boolean hasResults = rs.next();
        if (hasResults) {
            System.out.format(format, "Type", "Beds available","Max Guests", "Price","Season");
            do {
                System.out.format(format, rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        new DecimalFormat("0.00").format(rs.getDouble(4)),
                        rs.getString(5));
            } while (rs.next());
        } else {
            System.out.println("No results");
        }
        connection.close();
    }
}
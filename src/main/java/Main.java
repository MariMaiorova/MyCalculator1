import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Arrays;
import java.util.Properties;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        /*DB Teil */
        String url = "jdbc:postgresql://localhost/Calculator?user=postgres&password=Admin";
        try {
            Connection conn = DriverManager.getConnection(url);
            System.out.println("Connect!");
            Statement st = conn.createStatement();
            ResultSet resultSet= st.executeQuery("Select * from public.\"Results\" order by 1");
            while (resultSet.next()) {
                System.out.print(resultSet.getString(2) + " = " + resultSet.getString(3)+" ");
                LocalDateTime localDate = resultSet.getObject(4, LocalDateTime.class);
                System.out.println(localDate.getDayOfMonth() + "." + localDate.getMonthValue() + "." + localDate.getYear() + " " + localDate.getHour() + ":" + localDate.getMinute());
            }
            resultSet.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
            //tets
        }

        //  Scanner sc = new Scanner(System.in);
        //  String calcText = sc.nextLine();

    }
}



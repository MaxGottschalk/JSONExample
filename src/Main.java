import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        System.out.println("Hello world!");
        System.out.println("This is an example");

        //Skapa ett JSON objekt
        JSONObject jsonOb = new JSONObject();

        //Spara värden i JSON Object
        jsonOb.put("namn", "Sebbe");
        jsonOb.put("age", 22);

        //Skriva ut värden
        System.out.println("Mitt namn är: " + jsonOb.get("namn"));
        System.out.println("Jag är " + jsonOb.get("age") + " år gammal");

        fetchJsonFromFile();
        fetchJsonFromAPI();
    }

    static void fetchJsonFromFile() throws IOException, ParseException {
        String filePath = "C:\\Users\\maxjo\\OneDrive\\Skrivbord\\JSON\\data.json";
        //Hämta data från JSON fil
        //Konvertera data till ett JSONObject
        JSONObject fetchData = (JSONObject) new JSONParser().parse(new FileReader(filePath));

        JSONObject p1 = (JSONObject) fetchData.get("p1");
        JSONObject p2 = (JSONObject) fetchData.get("p2");

        //Hämta och skriv ut data
        String nameP1 = (String) p1.get("name"), nameP2 = (String) p2.get("name");
        int ageP1= Integer.parseInt(p1.get("age").toString()), ageP2= Integer.parseInt(p2.get("age").toString());

        System.out.println("Mitt namn är " + nameP1 + " jag är " + ageP1 + " år");
        System.out.println("Mitt namn är " + nameP2 + " jag är " + ageP2 + " år");
    }

    static void fetchJsonFromAPI() throws IOException, ParseException {
        //Spara URl till api
        URL url = new URL("https://api.wheretheiss.at/v1/satellites/25544");

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        if(conn.getResponseCode() == 200){
            System.out.println("Koppling lyckades");
            StringBuilder strData = new StringBuilder();
            Scanner scanner = new Scanner(url.openStream());
            while (scanner.hasNext()) {
                strData.append(scanner.nextLine());
            }
            scanner.close();
            JSONObject dataObject = (JSONObject) new JSONParser().parse(String.valueOf(strData));
            System.out.println(dataObject);
            System.out.println(dataObject.get("solar_lat"));
        }
        else{
            System.out.println("Error");
        }
    }
}
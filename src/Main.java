import org.json.simple.JSONObject;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println("This is an example");

        //Skapa ett JSON objekt
        JSONObject jsonOb = new JSONObject();

        //Spara värden i JSON Object
        jsonOb.put("namn", "Sebbe");
        jsonOb.put("age", 22);

        //Skriva ut värden
        System.out.println("Mitt namn är: " + jsonOb.get("namn"));
        System.out.printf("Jag är " + jsonOb.get("age") + " år gammal");


    }
}
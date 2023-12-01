package daniel.Cabrera.classes;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;
import java.net.URL;

import java.nio.charset.Charset;
import java.io.FileReader;


public class App {
    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    private static JSONObject JSONReadFromFile(String fitxerTest) throws JSONException {
        JSONObject json = null;
        try {
            json = new JSONObject(new JSONTokener(new FileReader(fitxerTest)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return json;
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is,
                    Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            return new JSONObject(jsonText);
        } finally {
            is.close();
        }
    }

    public static void header() throws IOException, JSONException {
        JSONObject json =
                readJsonFromUrl("http://header.jsontest.com/");
        System.out.println(json.toString());
    }

    public static void date() throws IOException, JSONException {
        JSONObject json =
                readJsonFromUrl("http://date.jsontest.com/");
        System.out.println(json.toString());
    }

    public static void parellClau(String fitxerAGuardar) throws IOException, JSONException {
        JSONObject json =
                readJsonFromUrl("http://echo.jsontest.com/AD/M06");
        System.out.println(json);
        json.put("ED", "M05");
        System.out.println(json);
        File file = new File(fitxerAGuardar);
        if (!file.getParentFile().exists())
                file.getParentFile().mkdirs();
        if (!file.exists()) {
            file.createNewFile();
        } else {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(json.toString());
            fileWriter.close();
        }
    }

    public static void llegeixFitxer(String fitxerTest) throws IOException, JSONException {
        JSONObject json =
                JSONReadFromFile(fitxerTest);
        System.out.println(json.toString());
    }
}
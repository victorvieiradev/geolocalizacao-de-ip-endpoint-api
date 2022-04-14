import java.io.BufferedReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class App {
    public static void main(String[] args) {
        try{
            String url = "http://ip-api.com/json/?fields=status,message,country,countryCode";
            HttpURLConnection conectar = (HttpURLConnection) new URL(url).openConnection();
            conectar.setRequestMethod("GET");
            conectar.setRequestProperty("accept", "application/json");
            if(conectar.getResponseCode() != 200){
                System.out.println("Erro " + conectar.getResponseCode() + " ao obter dados da URL " + url);
            }
            BufferedReader br = new BufferedReader(new InputStreamReader((conectar.getInputStream())));
            String saida = "";
            String linha;
            while((linha = br.readLine()) != null){
                saida += linha;
            }
            conectar.disconnect();
            Gson gson = new Gson();
            Dados dados = gson.fromJson(new String(saida.getBytes()), Dados.class);
            System.out.println("Status: "+dados.getStatus());
            System.out.println("Menssage: "+dados.getMessage());
            System.out.println("Country: "+dados.getCountry());
            System.out.println("Country code: "+dados.getCountryCode());
        }catch(IOException ex){
            //Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
}
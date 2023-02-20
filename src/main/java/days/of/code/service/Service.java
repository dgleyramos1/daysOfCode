package days.of.code.service;

import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import com.google.gson.Gson;

import days.of.code.model.DataReturn;
import days.of.code.model.Item;

import java.io.InputStreamReader;

public class Service {
    private String urlParaChamada;
    private int codigoSucesso = 200;

    public Service(String urlParaChamada) {
        this.urlParaChamada = urlParaChamada;
    }

    public List<Item> searcheMovies() throws Exception {

        Gson gson = new Gson(); // Instanciar Gson

        try {
            URL url = new URL(urlParaChamada);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            conexao.setRequestMethod("GET");

            if (conexao.getResponseCode() != codigoSucesso)
                throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());

            BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
            String output, retorno = "";
            while ((output = resposta.readLine()) != null) {
                retorno += output;
            }
            DataReturn dataReturn = gson.fromJson(retorno, DataReturn.class);
            resposta.close();

            return dataReturn.getItems();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

}

package com.p4;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;

import javax.management.Attribute;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TargetLangStore {

    private String localStorePath = System.getProperty("user.dir");
    private String url = "https://cstar.libdom.net/data.json";
    private File store;
    private HashMap<String, Attribute> functions;

    public TargetLangStore(){
        store = new File(localStorePath+"/language-meta.json");
        functions = new HashMap<>();
        download();
    }

    public void getStore(){
        try{
            Gson gson = new Gson();
            JsonReader reader = new JsonReader(new FileReader(store));
            
            HashMap<String, ArrayList<String>> json = gson.fromJson(reader, HashMap.class);

            for(Map.Entry<String, ArrayList<String>> entry : json.entrySet()) {
                String key = entry.getKey();


                if(key.equals("functions")){
                    ArrayList<String> value = entry.getValue();
                    for(String val: value){
                        //ExtFunc func = gson.fromJson(val, ExtFunc.class);
                        System.out.println(val);
                    }
                }

                //System.out.println(value);
                // do what you have to do here
                // In your case, another loop.
            }


        }catch(Exception e){
            System.out.println(e);
        }
    }

    private void download(){
        boolean shouldDownload = false;
        Response head = request(this.url, Connection.Method.HEAD);

        if(store.exists() && store.isFile()
                && Objects.requireNonNull(head).hasHeader("last-modified")){

            try{
                String dateString = head.header("last-modified");
                SimpleDateFormat format = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz");
                Date srv_last_modified = format.parse(dateString);

                shouldDownload = (srv_last_modified.getTime() > store.lastModified());

            }catch (ParseException e){
                shouldDownload = true;
            }
        }else{
            shouldDownload = true;
        }

        if(shouldDownload){
            Response response = request(url);
            try (FileOutputStream fos = new FileOutputStream(store)) {
                fos.write(response.bodyAsBytes());
            }catch (Exception e){
                System.out.println("Failed to download store");
            }
        }
    }


    private Response request(String url){
        return request(url, Connection.Method.GET);
    }

    private Response request(String url, Connection.Method method){
        try{
            return Jsoup.connect(this.url)
                    .ignoreContentType(true)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
                    .timeout(5000)
                    .method(method)
                    .maxBodySize(0)
                    .execute();
        }catch(IOException e){
            System.out.println(e);
        }

        return null;
    }

}


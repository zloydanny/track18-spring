package ru.track;


import org.apache.commons.lang3.StringUtils;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;



public class App2 {

        public static String url = "https://guarded-mesa-31536.herokuapp.com/track";
        public static String name = "name";
        public static String git = "git";
        public static String email = "email";

    public static void main(String[] args) throws Exception{
        HttpResponse<JsonNode> r = Unirest.post(url)
                .field(name,"Danny")
                .field(git,"zloydanny")
                .field(email, "dan.abdrakhimov@yandex.ru")
                .asJson();

        System.out.println(r.getBody().getObject().get("success"));
    }
}

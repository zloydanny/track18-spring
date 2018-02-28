package ru.track;



import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;



public class App2 {

        public static final String url = "https://guarded-mesa-31536.herokuapp.com/track";
        public static final String name = "name";
        public static final String git = "github";
        public static final String email = "email";

    public static void main(String[] args) throws Exception{
        HttpResponse<JsonNode> r = Unirest.post(url)
                .field(name,"Danny")
                .field(git,"zloydanny")
                .field(email, "dan.abdrakhimov@yandex.ru")
                .asJson();

        System.out.println(r);


    }
}

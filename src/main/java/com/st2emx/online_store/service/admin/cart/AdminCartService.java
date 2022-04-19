package com.st2emx.online_store.service.admin.cart;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.st2emx.online_store.dto.cart.CartDto;
import com.st2emx.online_store.service.BaseService;
import com.st2emx.online_store.utils.BaseUtils;
import org.json.JSONObject;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

/**
 * created by Elyor Ergashov
 *
 * @Author : elyor
 * @Date : 02/04/22
 * @Project : CazoStoreSite
 */
@Service
public class AdminCartService implements BaseService {


    public List<CartDto> getCards() {
        String url = "http://localhost:8080/api/v1/auth/cart/carts";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("size",20);
        jsonObject.put("page",0);
        ResponseEntity<String> response  = BaseUtils.sendUrl(url, HttpMethod.GET, MediaType.APPLICATION_JSON,jsonObject);
        Type type = new TypeToken<List<CartDto>>(){
        }.getType();
        return new Gson().fromJson(response.getBody(), type);
    }

    public String sumCartPrice() {
        String url = "http://localhost:8080/api/v1/auth/cart/sumCartPrices";
        ResponseEntity<String> response =  BaseUtils.sendUrl(url,HttpMethod.GET,MediaType.APPLICATION_JSON);
        Type type = new TypeToken<String>(){

        }.getType();
        return new Gson().fromJson(response.getBody(),type);
    }

    public Boolean delete(Long id) {
        String url = "http://localhost:8080/api/v1/auth/cart/delete/"+id;
       return  BaseUtils.sendUrl(url,HttpMethod.DELETE,MediaType.APPLICATION_JSON).getStatusCode().is2xxSuccessful();
    }

    public String getUserName(Long id) {
        String url = "http://localhost:8080/api/v1/auth/userName/"+id;
        ResponseEntity<String> response =  BaseUtils.sendUrl(url,HttpMethod.GET,MediaType.APPLICATION_JSON);
        Type type = new TypeToken<String>(){

        }.getType();
        return new Gson().fromJson(response.getBody(),type);
    }
}

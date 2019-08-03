package com.fh.shop.util.httpClient;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HttpClient {

    public static String setGet(String url){
        CloseableHttpClient httpClient = null;
        HttpGet httpGet = null;
        CloseableHttpResponse response = null;
        String request = null;
        try {
            httpClient = HttpClientBuilder.create().build();
            httpGet = new HttpGet(url);
            response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            request = EntityUtils.toString(entity, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if(null != response){
                try {
                    response.close();
                    response = null;
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
            if(null != httpGet){
                httpGet.releaseConnection();;
            }
            if(null != httpClient){
                try {
                    httpClient.close();
                    httpClient = null;
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }
        return request;
    }


    public static String setPost(String url, Map<String ,String > params, Map<String ,String > handers){
        CloseableHttpClient httpClient = null;
        HttpPost httpPost = null;
        CloseableHttpResponse execute = null;
        String toString = "";
        try {
            httpClient = HttpClientBuilder.create().build();
            httpPost = new HttpPost(url);
            if(null != params && params.size() >0){
                Iterator<Map.Entry<String, String>> iterator = params.entrySet().iterator();
                List<NameValuePair> nameValuePairList = new ArrayList<>();
                while (iterator.hasNext()){
                    Map.Entry<String, String> next = iterator.next();
                    String nextKey = next.getKey();
                    String nextValue = next.getValue();
                    nameValuePairList.add(new BasicNameValuePair(nextKey, nextValue));
                }
                httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairList,"utf-8"));
            }
            if(null != handers && handers.size() > 0){
                Iterator<Map.Entry<String, String>> iterator = handers.entrySet().iterator();
                while (iterator.hasNext()){
                    Map.Entry<String, String> next = iterator.next();
                    String key = next.getKey();
                    String value = next.getValue();
                    httpPost.addHeader(key, value);
                }
            }
            execute = httpClient.execute(httpPost);
            HttpEntity httpEntity = execute.getEntity();
            toString = EntityUtils.toString(httpEntity, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if(null != execute){
                try {
                    execute.close();
                    execute = null;
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
            if(null != httpPost){
                httpPost.releaseConnection();
            }
            if(null != httpClient){
                try {
                    httpClient.close();
                    httpClient = null;
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }

        return toString;
    }

}

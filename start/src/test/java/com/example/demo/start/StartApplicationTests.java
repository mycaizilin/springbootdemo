package com.example.demo.start;

import com.example.demo.api.request.InsertGoodRequest;
import com.example.demo.api.result.BaseResult;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class StartApplicationTests {

    @Autowired
    private WebTestClient webClient;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testHomeController() {
        Assert.assertTrue(this.webClient.get().uri("/index").exchange().expectStatus().isOk()
                .expectBody(BaseResult.class).returnResult().getResponseBody().isSuccess());

        Assert.assertTrue(this.webClient.get().uri("/good/list/苹果").exchange().expectStatus().isOk()
                .expectBody(BaseResult.class).returnResult().getResponseBody().isSuccess());

        InsertGoodRequest goodRequest=new InsertGoodRequest();
        goodRequest.setName("苹果");
        goodRequest.setPrice(new BigDecimal(10.68));

        Assert.assertTrue(this.webClient.post().uri("/good/insert").syncBody(goodRequest).accept(MediaType.APPLICATION_JSON_UTF8).exchange().expectStatus().isOk()
                .expectBody(BaseResult.class).returnResult().getResponseBody().isSuccess());
    }
}

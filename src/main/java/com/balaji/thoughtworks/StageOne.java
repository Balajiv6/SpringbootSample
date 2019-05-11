package com.balaji.thoughtworks;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Collections;

import static org.springframework.http.MediaType.APPLICATION_JSON;

/**
 * Created by Balaji Vijakumar on 5/20/2018.
 *
 */
@RestController
@RequestMapping(path = "/thoughtworks")
@Api(tags = "thoughtWorks")
public class StageOne {

    private static final Logger logger = LoggerFactory.getLogger(StageOne.class);

    @Bean
    private RestTemplate rest() {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();

        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy.tcs.com", 8080));
        requestFactory.setProxy(proxy);

        return new RestTemplate(requestFactory);
    }


    @RequestMapping(path = "/stageone", method = RequestMethod.GET)
    @ApiOperation(value = "This API is for interview", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 404, message = "The resource not found")
    })
    public String performStageOne() {
        logger.info("Entered performStageOne");
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(APPLICATION_JSON));
        headers.setContentType(APPLICATION_JSON);
        headers.set("userId", "B1Z8zcARG");

        HttpEntity entityReq = new HttpEntity(headers);

        String serviceURL = "https://http-hunt.thoughtworks-labs.net/challenge";
        final String uri = serviceURL + "/input";
        RestTemplate restTemplate = rest();
        ResponseEntity<String> respEntity = restTemplate.exchange(uri, HttpMethod.GET, entityReq, String.class);

        logger.info(respEntity.getStatusCode().toString());

        logger.info("Existing performStageOne");
        return "Success";

    }

}

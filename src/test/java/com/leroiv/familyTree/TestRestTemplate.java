package com.leroiv.familyTree;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public class TestRestTemplate {
  /*  @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void givenMemUsers_whenGetPingWithValidUser_thenOk() {
        ResponseEntity<String> result
                = makeRestCallToGetPing("memuser", "pass");

        Assert.assertThat(result.getStatusCodeValue()).200);

        Assert.assertThat(result.getBody()).isEqualTo("OK");
    }

    @Test
    public void givenExternalUsers_whenGetPingWithValidUser_thenOK() {
        ResponseEntity<String> result
                = makeRestCallToGetPing("externaluser", "pass");

        Assert.assertThat(result.getStatusCodeValue()).isEqualTo(200);
        Assert.assertThat(result.getBody()).isEqualTo("OK");
    }

    @Test
    public void givenAuthProviders_whenGetPingWithNoCred_then401() {
        ResponseEntity<String> result = makeRestCallToGetPing();

        Assert.assertThat(result.getStatusCodeValue()).isEqualTo(401);
    }

    @Test
    public void givenAuthProviders_whenGetPingWithBadCred_then401() {
        ResponseEntity<String> result
                = makeRestCallToGetPing("user", "bad_password");

        Assert.assertThat(result.getStatusCodeValue()).isEqualTo(401);
    }

    private ResponseEntity<String>
    makeRestCallToGetPing(String username, String password) {
        return restTemplate.withBasicAuth(username, password)
                .getForEntity("/api/ping", String.class, Collections.emptyMap());
    }

    private ResponseEntity<String> makeRestCallToGetPing() {
        return restTemplate
                .getForEntity("/api/ping", String.class, Collections.emptyMap());
    }*/
}

package org.example.admin;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class AdminApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void genJwt() {
        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put("id", 1);
        claims.put("username", "Tom");
        String jwt = Jwts.builder()
                .setClaims(claims) //自定义内容(载荷)
                .signWith(SignatureAlgorithm.HS256, "stank") //签名算法
                .setExpiration(new Date(System.currentTimeMillis() +
                        24 * 3600 * 1000)) //有效期
                .compact();
        System.out.println(jwt);
    }

}

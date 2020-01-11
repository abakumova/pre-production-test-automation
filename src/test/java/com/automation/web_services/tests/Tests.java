package com.automation.web_services.tests;

import com.automation.web_services.GetEntity;
import com.automation.web_services.PostEntity;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Tests {

    private static RequestSpecification specification;

    @BeforeAll
    public static void before() {
        specification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("http://jsonplaceholder.typicode.com")
                .build();
    }

    @Test
    public void testGetFirstUser() {
        given()
                .spec(specification)
                .when()
                .get("/posts")
                .then()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .body("userId[0]", equalTo(1))
                .body("id[0]", equalTo(1))
                .body("title[0]", equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"))
                .body("body[0]", equalTo("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"));
    }

    @Test
    public void testGetOneUser() {
        final GetEntity getEntity = given()
                .spec(specification)
                .when()
                .get("/posts/1")
                .then()
                .extract().as(GetEntity.class);

        Assertions.assertEquals(1, getEntity.getUserId());
        Assertions.assertEquals(1, getEntity.getId());
        Assertions.assertEquals("sunt aut facere repellat provident occaecati excepturi optio reprehenderit", getEntity.getTitle());
        Assertions.assertEquals("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto", getEntity.getBody());
    }

    @Test
    public void testPost() {
        final PostEntity[] postEntity = given()
                .spec(specification)
                .when()
                .get("/comments?postId=1")
                .then()
                .extract().as(PostEntity[].class);
        Set<PostEntity> postEntitySet = new HashSet<>();
        postEntitySet.add(new PostEntity(1, 1, "id labore ex et quam laborum", "Eliseo@gardner.biz", "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium"));
        postEntitySet.add(new PostEntity(1, 2, "quo vero reiciendis velit similique earum", "Jayne_Kuhic@sydney.com", "est natus enim nihil est dolore omnis voluptatem numquam\net omnis occaecati quod ullam at\nvoluptatem error expedita pariatur\nnihil sint nostrum voluptatem reiciendis et"));

        Assertions.assertEquals(postEntity[0], postEntitySet.toArray()[0]);
        Assertions.assertEquals(postEntity[1], postEntitySet.toArray()[1]);
    }
}

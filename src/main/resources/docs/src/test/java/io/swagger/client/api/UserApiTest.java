/*
 * Rest_API_Cloud
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 0.0.1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.client.api;

import io.swagger.client.model.Error;
import io.swagger.client.model.User;
import io.swagger.client.model.Users;
import org.junit.Test;
import org.junit.Ignore;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * API tests for UserApi
 */
@Ignore
public class UserApiTest {

    private final UserApi api = new UserApi();

    /**
     * CreteUser
     *
     * 
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void createUserTest() throws Exception {
        User body = null;
        String response = api.createUser(body);

        // TODO: test validations
    }
    /**
     * DeleteUser
     *
     * 
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void deleteUserTest() throws Exception {
        String id = null;
        String response = api.deleteUser(id);

        // TODO: test validations
    }
    /**
     * Get_ALL_User
     *
     * 
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void getAllUserTest() throws Exception {
        Users response = api.getAllUser();

        // TODO: test validations
    }
    /**
     * UpdateUser
     *
     * 
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void updateUserTest() throws Exception {
        User body = null;
        String response = api.updateUser(body);

        // TODO: test validations
    }
}
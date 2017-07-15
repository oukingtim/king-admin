package com.oukingtim.web

import com.alibaba.fastjson.JSONObject
import com.jayway.restassured.RestAssured
import com.jayway.restassured.response.ValidatableResponse
import com.oukingtim.KingAdminKotlinApplication
import org.apache.commons.collections.map.HashedMap
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

/**
 * Created by oukingtim
 */
@RunWith(SpringJUnit4ClassRunner::class)
@SpringBootTest(classes = arrayOf(KingAdminKotlinApplication::class), webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RestTest {

    @Value("\${local.server.port}")
    internal var port: Int = 0

    @Before
    fun doBefore() {
        RestAssured.port = port
    }

    @Test
    fun create() {
        val param = JSONObject()
        param.put("text", "testKotlin")
        postTest(param, "/admin/todo")
    }
    @Test
    fun update() {
        val param = JSONObject()
        param.put("text", "testKotlin1")
        param.put("id","8a8586015cf1f5a5015cf1f5c9430000")
        putTest(param, "/admin/todo")
    }
    @Test
    fun delele() {
        val param = JSONObject()
        deleteTest(param, "/admin/todo/8a8586015cf1f5a5015cf1f5c9430000")
    }
    @Test
    fun list() {
        val param = JSONObject()
        val pagination = HashedMap()
        pagination.put("start", 0)
        pagination.put("number", 5)
        val sort = HashedMap()
        var search = HashedMap()
//        search.put("text","sss")
        param.put("pagination", pagination)
        param.put("sort", sort)
        param.put("search", search)
        postTest(param, "/sys/calendar/getSmartData")
    }
    private fun postTest(param: JSONObject, url: String) {
        println(param)
        print("param:$param")

        val response = RestAssured.given().contentType("application/json;charset=utf-8")
                .request().body(param.toJSONString())
                .`when`().post(url).then() as ValidatableResponse

        val json = JSONObject.parseObject(response.extract().asString())//获取返回的json数据(2)
        print("result:$json")
    }
    private fun putTest(param: JSONObject, url: String) {
        println(param)
        print("param:$param")

        val response = RestAssured.given().contentType("application/json;charset=utf-8")
                .request().body(param.toJSONString())
                .`when`().put(url).then() as ValidatableResponse

        val json = JSONObject.parseObject(response.extract().asString())//获取返回的json数据(2)
        print("result:$json")
    }
    private fun deleteTest(param: JSONObject, url: String) {
        println(param)
        print("param:$param")

        val response = RestAssured.given().contentType("application/json;charset=utf-8")
                .request().body(param.toJSONString())
                .`when`().delete(url).then() as ValidatableResponse

        val json = JSONObject.parseObject(response.extract().asString())//获取返回的json数据(2)
        print("result:$json")
    }


}
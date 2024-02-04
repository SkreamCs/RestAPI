# EventApi

All URIs are relative to *http://localhost:8080/RestAPI_war_exploded/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteEvent**](EventApi.md#deleteEvent) | **DELETE** /event/{id} | DeleteEvent
[**getAllEvent**](EventApi.md#getAllEvent) | **GET** /event | Get_ALL_Event
[**updateEvent**](EventApi.md#updateEvent) | **PUT** /event | UpdateEvent

<a name="deleteEvent"></a>
# **deleteEvent**
> String deleteEvent(id)

DeleteEvent

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.EventApi;


EventApi apiInstance = new EventApi();
String id = "id_example"; // String | 
try {
    String result = apiInstance.deleteEvent(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling EventApi#deleteEvent");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json

<a name="getAllEvent"></a>
# **getAllEvent**
> Events getAllEvent()

Get_ALL_Event

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.EventApi;


EventApi apiInstance = new EventApi();
try {
    Events result = apiInstance.getAllEvent();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling EventApi#getAllEvent");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Events**](Events.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateEvent"></a>
# **updateEvent**
> String updateEvent(body)

UpdateEvent

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.EventApi;


EventApi apiInstance = new EventApi();
Event body = new Event(); // Event | 
try {
    String result = apiInstance.updateEvent(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling EventApi#updateEvent");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Event**](Event.md)|  |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: text/plain, application/json


# FileApi

All URIs are relative to *http://localhost:8080/RestAPI_war_exploded/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createFile**](FileApi.md#createFile) | **POST** /file | CreteFile
[**deleteFile**](FileApi.md#deleteFile) | **DELETE** /file/{id} | DeleteFile
[**getAllFile**](FileApi.md#getAllFile) | **GET** /file | Get_ALL_File
[**updateFile**](FileApi.md#updateFile) | **PUT** /file | UpdateFile

<a name="createFile"></a>
# **createFile**
> String createFile(body)

CreteFile

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.FileApi;


FileApi apiInstance = new FileApi();
java.io.File body = new java.io.File(); // java.io.File | 
try {
    String result = apiInstance.createFile(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FileApi#createFile");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**java.io.File**](java.io.File.md)|  |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: text/plain, application/json

<a name="deleteFile"></a>
# **deleteFile**
> String deleteFile(id)

DeleteFile

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.FileApi;


FileApi apiInstance = new FileApi();
String id = "id_example"; // String | 
try {
    String result = apiInstance.deleteFile(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FileApi#deleteFile");
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

<a name="getAllFile"></a>
# **getAllFile**
> Files getAllFile()

Get_ALL_File

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.FileApi;


FileApi apiInstance = new FileApi();
try {
    Files result = apiInstance.getAllFile();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FileApi#getAllFile");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Files**](Files.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateFile"></a>
# **updateFile**
> String updateFile(body)

UpdateFile

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.FileApi;


FileApi apiInstance = new FileApi();
java.io.File body = new java.io.File(); // java.io.File | 
try {
    String result = apiInstance.updateFile(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FileApi#updateFile");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**java.io.File**](java.io.File.md)|  |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: text/plain, application/json


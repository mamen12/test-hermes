
# Test Hermes

## untuk soal no 1 
bisa menjalankan class Test
``` 
TestApplicationTests.java 
```

## Untuk test method 
```
 ApiCallWrapperTest.java 
```
- Post method (testLocal()) - contoh local menggunakan HTTP manual
- Post method (testLocalRestTemplate()) - contoh local menggunakan library RestTemplate
- test no 2 (testHookbNo2()) - menggunakan HTTP manual
- test no 3 (testHookbNo3)() - menggunakan HTTP manual

**untuk testLocal() & testLocalRestTemplate()**
- POST http://localhost:8091/employee/detail

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `id_employee` | `Long` | id employee |




  **untuk test testHookbNo2()**
  - POST https://hookb.in/yDEEW3KjymTG9yjj9830


| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `name`      | `String` | nama kandidat |
| `address`      | `String` | alamat kandidat |


 **untuk test testHookbNo3()**
  - POST https://hookb.in/yDEEW3KjymTG9yjj9830


| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `nid`      | `int` | number id |
| `officeId`      | `int` | office id |

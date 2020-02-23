spring boot + shiro + Mybatis + Jwts 学生信息管理系统后端  
## /druid
druid监控页面，用户名：admin，密码：123456
## /api/token
### method:POST  
请求
```json
{
  "username": "6104119059",
  "password": "123456"
}
```  
响应  
成功
```json
{
    "message": "登录成功",
    "data": "eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE1ODIwMTAyNDEsImp0aSI6IjYxMDQxMTkwNTkiLCJzdWIiOiI2MTA0MTE5MDU5IiwiaWF0IjoxNTgyMDAzMDQxfQ.D1t9ni2lxaNDQ7p8M1kjflDAtDGZpRvGrtZ0qNAabm3QvKcLwxpCbow7t3rL_ouC91JxywKW35KzZh9vVCt5kA",
    "status": 1
}
```
失败  
```json
{
    "message": "登录失败",
    "data": null,
    "status": 0
}
```  
# 学生
## /user/info
### method:GET  
####请求头
Authorization:eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE1ODIwMTA3NTAsImp0aSI6IjYxMDQxMTkwNTIiLCJzdWIiOiI2MTA0MTE5MDUyIiwiaWF0IjoxNTgyMDAzNTUwfQ.ZKuyspLvpSmC4WHSLiyHqkRO26JOyx17h5274XW-GvCOWjYDw2u5e_aCWORDbKp-S7PX-hY5BYRzYzQ1qQVCwA  
####响应
```json
{
    "message": "获取成功",
    "data": {
        "username": "6104119052",
        "name": "user1",
        "sex": "男",
        "telephone": "111",
        "qq": "111111",
        "weChat": "111111",
        "idCard": "1113414",
        "province": "jiangxi",
        "city": "xiny",
        "address": "aefofeaf",
        "familyMembers": [
            {
                "id": "1",
                "studentUsername": "6104119052",
                "name": "1aaaaa",
                "relation": "父",
                "job": "job1111",
                "telephone": "111"
            },
            {
                "id": "2",
                "studentUsername": "6104119052",
                "name": "b",
                "relation": "母",
                "job": "无",
                "telephone": "123"
            }
        ]
    },
    "status": 1
}
```
#### 没有个人信息或用户不存在
```json
{
    "message": "该用户不存在",
    "data": null,
    "status": 0
}
```
## /student/info
```json
{
    "message": "获取成功",
    "data": {
        "username": "6104119052",
        "institute": "信息工程学院1",
        "major": "电气工程及其自动化",
        "grade": "2018",
        "number": "1",
        "instructor": {
            "username": "6104119053",
            "name": "user2",
            "sex": "男",
            "telephone": "12113",
            "qq": "13134",
            "weChat": "13413"
        }
    },
    "status": 1
}
```
## /student/classmates
```json
{
    "message": "获取成功",
    "data": [
        {
            "username": "6104119052",
            "name": "user1",
            "sex": "男",
            "telephone": "111",
            "qq": "111111",
            "weChat": "111111"
        },
        {
            "username": "6104119055",
            "name": "user3",
            "sex": "男",
            "telephone": "1111111",
            "qq": "124124",
            "weChat": "12412"
        }
    ],
    "status": 1
}
```
# 辅导员
## /instructor/clazz
### method:GET
```json
{
    "message": "获取成功",
    "data": [
        {
            "id": "1",
            "number": "1",
            "studentNumber": "3",
            "grade": "2018",
            "major": "1"
        },
        {
            "id": "2",
            "number": "2",
            "studentNumber": "1",
            "grade": "2018",
            "major": "1"
        }
    ],
    "status": 1
}
```  
## /instructor/student/info
### method:PUT
请求  
除了username属性外，其他属性可以选择填写最少1个，如
```json
{
    "username":"6104119052",
    "name":"sww1"
}
```
只会更新name为"sww1"  
```json
{
    "username":"6104119052",
    "name":"sww",
    "sex":"男",
    "telephone":"1111111111111",
    "qq":"111111111111111",
    "weChat":"1111111",
    "idCard":"111111111111111111111",
    "province":"jx",
    "city":"xinyu",
    "address":"1111111"
}
```
格式错误  
```json
{
    "message": "格式错误",
    "data": "手机号格式错误",
    "status": 0
}
```
成功
```json
{
    "message": "修改成功",
    "data": null,
    "status": 1
}
```
## /instructor/student/info/{username}
### method:GET  
/instructor/student/info/6104119052  
成功
```json
{
    "message": "获取成功",
    "data": {
        "username": "6104119052",
        "name": "sww1",
        "sex": "男",
        "telephone": "111",
        "qq": "111111111",
        "weChat": "1111111",
        "idCard": "1111111111111111",
        "province": "jx",
        "city": "xinyu",
        "address": "1111111",
        "familyMembers": [
            {
                "id": "1",
                "studentUsername": "6104119052",
                "name": "1aaaaa",
                "relation": "父",
                "job": "job1111",
                "telephone": "111"
            },
            {
                "id": "2",
                "studentUsername": "6104119052",
                "name": "b",
                "relation": "母",
                "job": "无",
                "telephone": "123"
            }
        ]
    },
    "status": 1
}
```  
失败
```json
{
    "message": "无权访问",
    "data": null,
    "status": 0
}
```
## /instructor/student/family
### method:PUT  
请求
```json
{
    "id":"7",
    "studentUsername":"6104119052",
    "name":"string",
    "job":"string",
    "relation":"string",
    "telephone":"1414124124"
}
```
成功  
```json
{
    "message": "修改成功",
    "data": null,
    "status": 1
}
```
失败  
```json
{
    "message": "属性不存在",
    "data": null,
    "status": 0
}
```
## /instructor/student/info?name=string&page=int
### method:GET
示例 /instructor/student/info?name=s&page=1， 将返回该辅导员管理的所有姓名带有"s"的学生的列表的第一页
```json
{
    "message": "获取成功",
    "data": [
        {
            "username": "6104119052",
            "name": "sww1"
        },
        {
            "username": "6104119055",
            "name": "user3"
        }
    ],
    "status": 1
}
```
# 管理员
## /institute/{id}
### method:GET
示例 /institute/1
```json
{
    "message": " 获取成功",
    "data": {
        "id": "1",
        "name": "信息工程学院1"
    },
    "status": 1
}
```
## /institute
### method: PUT
请求
```json
{
    "id":"1",
    "name":"信息工程学院"
}
```
响应
```json
{
    "message": "修改成功",
    "data": null,
    "status": 1
}
```
## /institute
### method: GET
```json
{
    "message": "获取成功",
    "data": [
        {
            "id": "1",
            "name": "信息工程学院"
        },
        {
            "id": "2",
            "name": "机电工程学院"
        }
    ],
    "status": 1
}
```
## /insitute
### method: POST
请求
```json
{
    "id":"3",
    "name":"学院3"
}
```
响应
```json
{
    "message": "添加成功",
    "data": null,
    "status": 1
}
```
## /institute/{id}
### method: DELETE
示例
/institute/3
成功
```json
{
    "message": "删除成功",
    "data": null,
    "status": 1
}
```
失败
```json
{
    "message": "无法删除",
    "data": "无法删除非空的学院",
    "status": 0
}
```
## /major
### method: POST
```json
{
    "id":"10",
    "name":"major10",
    "instituteId":"2"
}
```
响应
```json
{
    "message": "添加成功",
    "data": null,
    "status": 1
}
```
### method: PUT
```json
{
    "id":"10",
    "instituteId":"1"
}
```
```json
{
    "message": "修改成功",
    "data": null,
    "status": 1
}
```
## /major/{page}
### method: GET
示例 /major/1
```json
{
    "message": "获取成功",
    "data": [
        {
            "id": "1",
            "name": "电气工程及其自动化",
            "instituteId": null
        },
        {
            "id": "10",
            "name": "major10",
            "instituteId": null
        },
        {
            "id": "2",
            "name": "自动化",
            "instituteId": null
        }
    ],
    "status": 1
}
```
## /major/{id}
### method: DELETE
```json
{
    "message": "删除成功",
    "data": null,
    "status": 1
}
```
## /class/{pageNumber}
### method: GET
```json
{
    "message": "获取成功",
    "data": [
        {
            "id": "1",
            "number": "1",
            "studentNumber": "3",
            "grade": "2018",
            "instructor": "user2",
            "major": "电气工程及其自动化",
            "majorId": "1"
        },
        {
            "id": "2",
            "number": "2",
            "studentNumber": "1",
            "grade": "2018",
            "instructor": "user2",
            "major": "电气工程及其自动化",
            "majorId": "1"
        },
        {
            "id": "3",
            "number": "1",
            "studentNumber": "0",
            "grade": "2019",
            "instructor": "user2",
            "major": "自动化",
            "majorId": "2"
        }
    ],
    "status": 1
}
```
## /class
### method: PUT
```json
{
    "id":"1",
    "number":"1",
    "majorId":"2",
    "grade":"2019",
    "instructor":"6104119053"
}
```
响应
```json
{
    "message": "更新成功",
    "data": null,
    "status": 1
}
```

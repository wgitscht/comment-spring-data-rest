### Spring Rest Data - Comment Service with less than

This is a very simple example how powerful spring-rest-data may be.

Send this header to get just links:
`Accept: application/x-spring-data-compact+json`

Send this header to get nothing embedded but directly:
`Accept: application/x-spring-data-verbose+json`


use this url for spring rest data:
http://127.0.0.1:8082/rest-data/


post a comment:
```
{
  "author" : "wgitscht",
  "title" : "a title",
  "text" : "a text message",
  "articleId" : 1
}
```

post a comment to a parent:
```
{
  "author" : "wgitscht",
  "title" : "a title",
  "text" : "a text message",
  "articleId" : 1,
  "parent" :"http://127.0.0.1:8082/rest-data/comments/1"
}
```
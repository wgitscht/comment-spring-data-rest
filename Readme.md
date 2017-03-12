### Spring Rest Data - Comment Service

with less than 100 lines of (server side) code.

This is a very simple example on how powerful spring-rest-data may be.
In a real world application some effort would be made in checking for authorization (can
e.g. be done with spring-security and json web tokens) data sanitizing (client and server side)
and some nice event handling (e.g. checking for profanity) or posting to a message queue where others may listen.

Send this header to get just links:
`Accept: application/x-spring-data-compact+json`

Send this header to get nothing embedded but directly:
`Accept: application/x-spring-data-verbose+json`


use this url for spring rest data (the traverson browser is on the classpath).
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
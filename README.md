# spring-security-java
A Spring based application which demonstrates how to authorize user.
## Prerequisite
Mysql server with table named *users* as follows.

| id | user | password | active | roles |
|----|------|----------|--------|-------|
|1|user1|pass|1|ROLE_USER,ROLE_ADMIN|
|2|user2|pass|1|ROLE_USER|
## Description
Class _User_ is mapped with table _users_ in Mysql server and This contains data agains which a user will be authenticated. Class _JPAUserDetailService_ implements UserDetailDervice and it connects with _JPARepository_ to authenticate an user.

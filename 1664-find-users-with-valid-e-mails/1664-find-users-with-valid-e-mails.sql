# Write your MySQL query statement below
SELECT * from Users WHERE
REGEXP_like(mail,'^[a-zA-Z][a-zA-Z0-9_.-]*@leetcode\\.com$','c');
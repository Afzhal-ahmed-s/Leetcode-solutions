# Please write a DELETE statement and DO NOT write a SELECT statement.
# Write your MySQL query statement below
DELETE P1 FROM Person P1 JOIN Person P2 ON P1.email = P2.email
WHERE P1.id > P2.id;

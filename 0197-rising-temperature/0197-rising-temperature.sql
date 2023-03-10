# Write your MySQL query statement below

SELECT W2.id 
FROM Weather W1 INNER JOIN Weather W2 
ON DATEDIFF(W2.recordDate, W1.recordDate)=1 AND W2.temperature > W1.temperature
ORDER BY 1 ASC;


# Write your MySQL query statement below
SELECT (SELECT DISTINCT salary FROM Employee GROUP BY salary ORDER BY salary DESC LIMIT 1,1)AS 'SecondHighestSalary';

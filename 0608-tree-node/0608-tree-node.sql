# Write your MySQL query statement below

SELECT DISTINCT T1.id,
(
CASE    
    WHEN T1.p_id IS NULL THEN 'Root'
    WHEN T1.p_id IS NOT NULL AND T2.id IS NOT NULL THEN 'Inner'
    WHEN T1.p_id IS NOT NULL AND T2.id IS  NULL THEN 'Leaf'
    END
)
AS 'type'
FROM Tree T1 LEFT JOIN TREE T2 ON T1.id = T2.p_id
ORDER BY 1 ASC;

# Write your MySQL query statement below
SELECT S.name
FROM SalesPerson AS S
LEFT JOIN 
(
    SELECT O.sales_id AS sales_id
    FROM Orders AS O
    JOIN Company AS C ON C.com_id = O.com_id
    WHERE C.name = 'RED'
) AS red_orders ON S.sales_id = red_orders.sales_id
WHERE red_orders.sales_id IS NULL;
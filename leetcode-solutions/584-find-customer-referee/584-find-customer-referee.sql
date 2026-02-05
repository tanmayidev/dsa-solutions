-- Write your PostgreSQL query statement below
SELECT name FROM Customer
WHERE referee_id is distinct from 2

-- SELECT name FROM Customer
-- WHERE referee_id != 2 OR referee_id is NULL

-- SELECT name FROM Customer 
-- WHERE coalesce(referee_id, 0) != 2

-- https://www.postgresql.org/docs/current/functions-comparison.html

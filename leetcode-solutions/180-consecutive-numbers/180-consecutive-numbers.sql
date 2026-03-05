WITH Temp as (
SELECT
num,
id,
id - ROW_NUMBER() OVER (
    PARTITION BY num
    ORDER BY id
) AS run_id
FROM Logs
)

SELECT DISTINCT(t.num) as ConsecutiveNums
FROM Temp t
GROUP BY (t.num, t.run_id)
HAVING COUNT(*) >= 3;

SELECT 
    r.contest_id,
    ROUND(
        COUNT(r.user_id)::decimal 
        / (SELECT COUNT(*) FROM Users) * 100,
        2
    ) AS percentage
FROM Register r
GROUP BY r.contest_id
ORDER BY percentage DESC, r.contest_id ASC;

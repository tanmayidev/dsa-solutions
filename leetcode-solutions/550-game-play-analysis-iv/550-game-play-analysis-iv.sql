SELECT ROUND(
    1.0 * COUNT(player_id) / 
    (SELECT COUNT(DISTINCT player_id)
    FROM Activity), 2) AS fraction
FROM Activity
WHERE (player_id, event_date) IN (
    SELECT player_id, MIN(event_date) + 1
    FROM Activity
    GROUP BY player_id
)

-- #############################
-- WITH first_login AS (
--     SELECT 
--         player_id,
--         MIN(event_date) AS first_date
--     FROM Activity
--     GROUP BY player_id
-- ),
-- next_day_login AS (
--     SELECT f.player_id
--     FROM first_login f
--     JOIN Activity a
--         ON a.player_id = f.player_id
--        AND a.event_date = f.first_date + INTERVAL '1 day'
-- )

-- SELECT 
--     ROUND(
--         COUNT(DISTINCT n.player_id)::decimal
--         / COUNT(DISTINCT f.player_id),
--         2
--     ) AS fraction
-- FROM first_login f
-- LEFT JOIN next_day_login n
--     ON f.player_id = n.player_id;

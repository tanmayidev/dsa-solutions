-- Write your PostgreSQL query statement below

-- Runtime = 330 ms
SELECT DISTINCT(author_id) as id
FROM Views
WHERE author_id = viewer_id
ORDER BY author_id;

-- Runtime = 482 ms
-- SELECT DISTINCT(author_id) as id
-- FROM Views
-- WHERE author_id = viewer_id;

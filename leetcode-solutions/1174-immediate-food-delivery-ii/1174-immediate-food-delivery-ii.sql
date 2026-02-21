WITH first_orders AS (
    SELECT DISTINCT ON (customer_id)
        customer_id,
        order_date,
        customer_pref_delivery_date
    FROM Delivery
    ORDER BY customer_id, order_date
)

SELECT 
    ROUND(
        COUNT(*) FILTER (
            WHERE order_date = customer_pref_delivery_date
        )::decimal
        / COUNT(*) * 100,
        2
    ) AS immediate_percentage
FROM first_orders;

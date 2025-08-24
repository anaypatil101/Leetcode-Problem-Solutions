SELECT e.employee_id
FROM Employees e
WHERE salary < 30000 AND manager_id IS NOT NULL 
AND NOT EXISTS(
        SELECT 1 FROM Employees m WHERE m.employee_id = e.manager_id
)
ORDER BY e.employee_id;
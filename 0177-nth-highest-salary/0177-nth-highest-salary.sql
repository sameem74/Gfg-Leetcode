CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
    WITH
      Employee AS (SELECT *, DENSE_RANK() OVER (ORDER BY salary DESC) AS `rank` FROM Employee)
    SELECT MAX(salary) AS getNthHighestSalary FROM Employee WHERE `rank` = N
  );
END
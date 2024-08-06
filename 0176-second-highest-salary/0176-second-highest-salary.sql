# Write your MySQL query statement below
select max(salary) As SecondHighestSalary from Employee where salary  < (select max(salary) from Employee)

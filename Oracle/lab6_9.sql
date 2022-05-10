select job_id "Job",
nvl(sum(decode(department_id,20,salary)),0) "Dept20",
nvl(sum(decode(department_id,50,salary)),0) "Dept50",
nvl(sum(decode(department_id,80,salary)),0) "Dept80",
nvl(sum(decode(department_id,90,salary)),0) "Dept90",
nvl(sum(decode(department_id,20,salary)),0)+nvl(sum(decode(department_id,50,salary)),0)+nvl(sum(decode(department_id,80,salary)),0)+
nvl(sum(decode(department_id,90,salary)),0) "Total" from employees group by job_id;
StudentRegistration

Application allows to create students list, 
add new students, 
delete students, 
get all students and clean the list.

Start application and use commands:
- To get list of students: **g**
- To add new student: **a <_First_name_> <_Last_name_> <_age_>**  
- To delete student: **d <_student_id_>**
- To clean list of students: **c** 

Also you can previously fill the list with mock data.
_(Like this: "Student №1: FirstName1 LastName1 18 year old".)_


To do it: 
open file application.properties
and set properties as follows:
- app.students.init=**_true_**
- app.students.num=**_<necessary_num_of_students>_**


If you don't need mock data, set:
- app.students.init=**_false_**
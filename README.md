# Hibernate
This repository have application data persisted in MySQL using Hibernate 

Build a java application which admits a student into the system. The student record will include student id, first name, last name, email and admission status(by default on waiting list). The application will allow student to enter other details like his course degree and semester depending upon his choice. A student can enroll for many sports and application can be queried to know for a given sport how many students have registered.

Application Design

To retreive and persist the student's data in MySQL database we use Hibernate. Entities as per the problem are Student,StudentDetails and Sports. Student and StudentDetails have one to one mapping with cascading of all operations as if we delete a student's entry from database there is no use of keeping the record for StudentDetails. With Sports entity student will have one to many with cascading of all operations not delete because even though one student leave and sport can be played by other students. 

The design patterns used are Facade pattern for service layer which sits between the application and Hibernate to save and query each entity and it's corresponding relationship with other entities.

To manage entities lifecycle(CRUD operations) and events(Serach opeartion) we have used DAO pattern.

The hibernate session factory is heavyobject hence initialized using singleton pattern.

To run application :- run MainApp as a java application

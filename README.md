# Spring-Data-Mongo-POC
Repo for POC to Access data in MongoDB using Spring Data

* An Employee will have Below Details
  
    * EmployeeID
    * firstName
    * lastName
    * Department
    * Salary
    
* Expose POST endpoint to create employee
* GET endpoint to get all Employees in a Specific Department
* GET endpoint to get a Employee details from Employee ID.



* Install MongoDB
  
    * brew install mongodb  [INSTALL MONGO]
    * mkdir -p data/db  [DATA DIRECTORY PATH]
    * chmod 777 data [GIVE PERMISSION]
    * chmod 777 db [GIVE PERMISSION]
    * mongod --dbpath <path to data directory> --port portID [START MONGODB SERVER]
    * mongod --dbpath /Users/gopal/PracticeWorkspace/Spring-Data-Mongo-POC/data/db --port 27017 [EXAMPLE]
    * mongo [launch Mongo shell] 

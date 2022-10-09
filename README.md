## Just a short DEMO for now
- for testing h2 database
- using docker Mysql as application's database
- using flyway as version manager for database
- need to be refactored and implemented later
### Swagger
- **@EnableOpenApi** to open the swagger(not required)
seems that swagger will catch any class with @RestController annotation,
and you can still use **@Tag**(swagger 3.0) to explicitly describe the name and 
description of the controller.  
- use **@Operation(summary = ** )** above the method to describe the function  

*issue*:
should use low-case and combine the controller name with dash in **@Tag**
> such as 
> `@Tag(name = "hello-controller", description = "To show greetings")`
> 
If using different name, the swagger may think the tag and controller are two
different things and in the http://localhost:8080/swagger-ui/index.html#/, it will show 
two tags.
### H2 Database
a memory database for unit test   
a **yml** file to declare database source and driver, and path to schema
and sql operation  
a **schema.sql** file to crate table,
and table's name needs to be the same as the **@Entity** name  
a **data_**.sql** file to operate table, such as INSERT, UPDATE, DELETE etc.
### Question
What is the difference between **@Entity** and **@Table** and when should
they be used?
#### Search in the Internet
**@Entity** specifies that the class is an entity. This annotation is applied to the entity class.
**@Table** specifies the primary table for the annotated entity. 
Additional tables may be specified using SecondaryTable or SecondaryTables annotation. 
If no Table annotation is specified for an entity class, the default values apply.
(low-case of entity name)
### A little tips
When you want to line feed in Markdown, you need to manually input two spaces  
and press enter, which a little different between txt.
### FlyWay
Name Principle:
1. only execute once: "V + number with . and _" __ "file_name"
2. execute repeatable : "R__" + "file_name"  
V is primary than R
3. strictly follow sql grammar in flyway file
4. use **baseline-on-migrate: true** when show error
### Docker
Use docker(Colima) for my MySql database, with command line  
**`docker run --name user-service -e MYSQL_ROOT_PASSWORD=password -p 3308:3306 -d mysql`**
### Tips
When there are multiple yml file, may need to specify with annotation **@ActiveProfiles**
### Puzzles
- What's the different between **findById()** and **getById()** ?  
When I use **getById()** there is an exception, and it's kind of complicated
to use **findById** because it returns an **Optional&lt;Task>** value
*judged by the real situation*
- Seems that **asserThat().isEqual()** can not judge every field in Task,
which means it only judge if the **id** matches(by my test), and how can I test
whether the whole task is equal or not?  
*need to view the source code*
Solution I did: use **get** method and test each filed one by one.
### Rename module
module name need to be renamed as **user-serivce**
### @DirtiesContext
may influence the test efficiency because it will **NOT** save the application context
and will initialize a new context for each test class/method
### @Sql annotation
to keep test more efficient and fast
use **@Sql** annotation before each test class/method to initialize/reset database for
different function, may faster than **@DirtiesContext**
### @Pageable
**@PageDefault** to set the default properties of page, contains:
**page** : number of pages  
**size** : number displayed per page  
**sort** : sort direction and sort properties  
**However**,when only use @PageDefault annotation without **@RequestParam**, when ever the
request parameter is ,it only displays the default value  
_**Question:**_
Why we can not use **PageRequest**?  
Use **PageRequest.of** to build a **Pageable** variable
Use **pageImpl** to convert **List** to **Page** variable
### **@Transactional(Deprecated)**
Use **@Transactional** to roll back database in the unit test  
Be aware that it will **NOT** reset the primary key
And seems It will reset userRepository
### ERD(Entity Relationship Diagram)
**Entity** : shown as a rectangle,A definable thing, that can have data stored about it  
**Relationship** shown as diamonds or labels directly on the connecting lines, 
define how entities act upon each other or are associated with each other  
**Cardinality** Defines the numerical attributes of the relationship between two entities or entity sets
mainly contains **one-to-one**, **one-to-many**, **many-to-many**  
**Encrypt**
use @Converter to automatically encrypt and decrypt password when interact with database
use javax package/cipher to choose the algorithms  
**JWT**  
Json web token, structure:  
**HEADER**.**PAYLOAD**.**SIGNATURE**  
**filter**
Java web component
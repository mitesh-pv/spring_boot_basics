# Spring Boot

<p align="justify">It lets us to bootstrap a spring application. Creating stand alone, production based spring based ready to run. Building a spring application means building a war file that can be deployed in any server. Spring boot provides a stand alone application that does not need any container to be deployed.

Working with spring requires us to manage the dependencies. We have to import the jar files that are required to create the project. This work is carried out by a dependency management tool called maven. All the dependencies are enlisted in a file called pom.xml, maven looks into the file and automatically builds all the jar files required to the class path automatically.<p>

What happens as and when a spring application runs? 
    It sets up default configuration.
    starts spring application context.
    performs class path scan.
    start the server.

**Bills of materials:** the preset list of combinations of all jar files that are defined and approved by spring framework suitable for application development is called Bills of materials.

The Spring controller contains 3 piece of information
    1. URI: uniform resource identifier
    2. HTTP Method. 
    3. Java functionality.

Rest controller always does the conversions of response values to json objects.

Rest api deals with resources. Nouns are usually dealt as resources. 

    GET /topics ==> get all the topics
    GET /topics/id ==> get the particular topic
    POST /topics ==> create a new topic
    PUT /topics/id ==> update the topic
    DELETE /topics/id ==> remove the particular topic

Creating business services in springs: 
**@Service** ==> annotation used to create a business service
After creating the business service in spring, its needs its dependency to be injected to the controller class and this is done by the annotation **@Autowired**

```java
@RequestMapping("/topics/{id}")
public Topics getTopic(@PathVariable String id) {
	return topicService.getTopic(id);
}
```

this can also be done by using another name for path variable

```java
@RequestMapping("/topics/{name}")
public Topics getTopic(@PathVariable("name") String id) {
	return topicService.getTopic(id);
}
```

```java
@RequestMapping(method=RequestMethod.POST, value="/topics/{topicid}/courses/{id}")
public void addCourse(@RequestBody Courses topic) {
	courseService.addCourse(topic);
}
```
@RequestBody object has a task to convert the incoming json object into the corresponding POJO object or xml object into POJO object.

**Methods to start a spring project:**
1. Spring Initializr: The graphical user interface to create the interface. 
This is done @ https://start.spring.io

2. Spring CLI 

    1. download the starter zip file from spring cli 
    2. unzip the directory
    3. go to bin folder 
    4. write the groovy script app.groovy as an example given below
    

```groovy
@SpringBootApplication
class AppCtrl{
    @RequestMapping("/")
    String app(){
        "First Spring Project"
    }
}
```
5. start the application by run command

## `./spring run app.groovy`

3. Spring project using IDE

Eclipse
Intelli J
STS: spring tool suit

Project can be created using create project -> spring starter project

4. Using create maven project and create the files and packages manually.

**Changing the configurations of a spring application**

This is done using application.properties file which resides on /src/main/resources/ folder
add the following line to the application.properties file

```groovy
server.port=9000
```

Several  configurations can be updated like SMTP, HTTP configutations and many more.


## Java Persistence API
Allows us to do object relational mapping(ORM)

ORM maps the classes with the database tables.

To make the table of out of the POJO class, we use the annotation 
```java
@Entity
```

To create a primary key we use annotation
```java
@Id
```

Spring data JPA has a default repository that is called a CrudRepository. This contains the logic of any type of operations related to the resoure such as 

```java
GET
POST
PUT 
DELETE 
```
etc.

CrudRepository takes following arguments into its generic types

```java
CrudRepository<Entity_Class, ID_of_Entity_class>

// example
CrudRepository<Topics, String>
```
Following configurations needs to be updated on applications.properties file in the resources directory of the project

```groovy
# PROFILES
spring.profiles.active=dev
# JPA (JpaBaseConfiguration, HibernateJpaAutoConfiguration)
spring.jpa.generate-ddl=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database=default
spring.jpa.show-sql=true
# DATASOURCE (DataSourceAutoConfiguration & DataSourceProperties)
spring.datasource.continue-on-error=false
spring.datasource.generate-unique-name=false
```

To reference a foreign key for a many to one relation from one entity type to another there is a java.persistance annotation which is called
```java
@ManyToOne
```


**To make a custom search from the CrudRepository class following structure of the method needs to be followed**

Declare this method inside the Repository interface to find the course by name.
```java 
public List<Course> findByName(name);
```

Declare this method inside the Repository interface to find the course by Description.
```java 
public List<Course> findByDescription(name);
```


**Get the deployeable unit of application and installing the jar files**

```shell
mvn clean install
```
this makes the jar file in the target/jarname___

run the jar file

java -jar target/jar_name

Instead of jar file, war can also be generated by replacing the jar in the pom.xml file with war

## More light on JPA

JPA provides the mapping of application class to tables. It also provides JPQL and criteria API to query the database. 

```java
@Table 
```
Maps the object to tables.


Example: Mapping a class to a table.

```java
@Entity
@Table(name="Task")
public class Task{

    @Id  // primary key is declared by @Id annotation
    @GeneratedValue // It defines that this field is not defined by the user but is automatically generated
    private int id;

    @Column(name="description")
    private String description;

    @Column(name="target_date")
    private Date targetDate;

    @Column(name="is_done")
    private boolean isDone;
}
```


Estabilishing many to many relation between two entities. 

```java

public class Employee{

    @ManyToMany
    private List<Task> tasks;
}

public class Task{

    @ManToMany(mappedBy="tasks")
    private List<Employee> employees;
}
```

Inheritance mapping.

```java
@Entity
@Inheritance(strategy=InheritanceType.SINGLE)
@DiscriminatorColumn(name="EMPLOYEE_TYPE")
public class Employee{
    // other employee attributes
}

public class FullTimeEmployee extends Employee{
    protected double salary;
}

public class PartTimeEmployee extends Employee{
    protected double hourlyWages;
}

```

## What is difference between JPA and hybernate?

JPA is an interface or specification and hybernate implements JPA.
Hybernate provides implememntations to those JPA specifications.
Hybernate is a ORM framwrork.
JPA is an API which tells how to: 
    define entities
    map attributes
    map relationships beween entities
    managing entities

Whatever is defined by the JPA, Hybernate implements it.
Hybernate understands the mapping between objects and tables.
It ensures that data is stored and retrieved from the database based on the mapping.


EntityManager: save data to the database.
**@Repository**: that interacts with the database
Transaction management is avoided here by using the declarative transaction by using the annotation **@Transactional**. This indicates each method will be involved in a transaction process.
**@CrossOrigin**: CORS (Cross-origin resource sharing) allows a webpage to request additional resources into browser from other domains e.g. fonts, CSS or static images from CDNs. CORS helps in serving web content from multiple domains into browsers who usually have the same-origin security policy.

## Difference between @NotNull, @NotBlank, @NotEmpty
1. String name = null;
    @NotNull: false
    @NotEmpty: false
    @NotBlank: false

2. String name = "";
    @NotNull: true
    @NotEmpty: false
    @NotBlank: false

3. String name = " ";
    @NotNull: true
    @NotEmpty: true
    @NotBlank: false

4. String name = "Great answer!";
    @NotNull: true
    @NotEmpty: true
    @NotBlank: true


**ResponseEntity<T>**: ResponseEntity represents an HTTP response, including headers, body, and status. 

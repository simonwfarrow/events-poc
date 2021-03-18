# Event processing POC

## Disclaimer

This project is meant to be used as a POC for structure and design.  
Adapters should NOT be used as-is in any production-like environment, should NOT be copy-pasted from this codebase.  
Interfaces on the other hand can be reused, and reasoned about in any way you feel appropriate (after slight adjustment to exception types where necessary)

## What this project is

This small project is meant to be an implementation of a minimalistic 
event processing consumer and publisher to demo a few concepts, such as 
hexagonal architectures, separation of concerns, containerization, and probably a few others

This project contains 2 main packages
- "events": contains all the interfaces and adapters
- "application": meant to be the userspace application (aka YOUR app)

There are no cross dependencies in the project, other than the application depending on interfaces.
There are no technological dependencies in the application either

## What this project isn't

- perfect
- finished
- fully parameterized
- production grade
- secure

## Known issues / improvements

- Publishing is direct and not buffered
- Some values are hardcoded
- Some configuration is hardcoded
- package internal structure (directories) could be better
- app docker container should be parameterized with vars for configuration
- service docker containers should be using docker volumes instead of mounted directories 
- kafka topic initialization should be based on configuration and not be hardcoded
- rabbitmq queue/exchange/binding initialization should be based on configuration and not be hardcoded
- should remove the unneccesary gson class for serialization/deserialization
- tests should be better structured into directories and not just all in one directory
- actual implementation for consumers and publishes are a 100% copy-paste from example code and could use massive improvements
- docker compose files could use an overhaul

### This project
- might not be the most optimally set up based on java project setup "best practices"
- is using c# style interface naming and zero annotations in the main application *bite me*
- is missing some formatting
- might not be implemented *the java way*

## Pre-requisites

First and foremost you will need GNU make.  
If you have that you can run ``make check-deps`` for a rudementary dependency check.   
This will check for things you need (not for specific versions though just yet)

You will definitely need the following things:
- java 8 (tested with openJDK version 1.8.0_282)
- docker (tested with 12.03.13)
- docker-compose (tested with 1.25.0)
- maven (tested with 3.6.3)

## How to set the project up

This looks long and complicated, but don't worry, it is really just a few commands to run and a few values to change (if you want to), the rest is just explanation.

1. Check that you have everything with ``make check-deps``
2. Go into the ``docker`` directory inside the project, you will find 3 other directories (kafka, rabbitmq and elk) with ``.env.example`` files in them.  
   These files are provided for your convenience. Make a copy of each of them in the same directory, named ``.env``. The only thing you should change in the copied ``.env`` files at this point is the HOME directory for each service. These define where the persistent data generated by these services is stored (otherwise all data would be lost when the container shuts down).  
   I'd recommend changing them to somewhere outside the project directory, for example "/srv/docker-data/whatever-servicename" (Please note, that you cannot use "~" or "$HOME" in the path, these should be absolute paths, and you should have a unique one for each service)
3. Run ``make init``. This will create the common network the docker containers use, and create the persistent data mounts for the docker containers
4. Run ``make rabbitmq-start``   
   This will start up the rabbitmq container. You can visit "http://localhost15672" to see the rabbitmq management ui (the default username is 'admin', and the default password is 'admin123') to verify that it's up and running. You should also be able to see the containers running in ``docker ps`` (RabbitMQ should have 1 container) 
5. Run ``make rabbitmq-setup``   
   This will initialize the queues and topics for rabbitmq
6. Run ``make kafka-start``   
   This will start up the kafka containers. You can visit "http://localhost:9000" to view KafDrop (no user/pass required) to verify that it's up and running. You should also be able to see 3 containers running for Kafka in ``docker ps`` (1 for kafka, 1 for zookeeper, and 1 for kafdrop)
7. Run ``make kafka-setup``   
   This will initialize the topics for kafka
8. Run ``make elk-start``   
   This start the elk containers. You can visit "http://localhost:5601" to open kibana (you might need to give it a minute, this one is quite slow to start up). You should also be able to see 3 containers running for ELK (1 for elasticsearch, 1 for logstash, and 1 for kibana)
    
Note:   
You can run ``make start-services`` to start the rabbitmq server, the kafka server and the entire ELK stack at the same time.  
In order to shut them down, run ``make stop-services``, or ``make rabbitmq-stop``, ``make kafka-stop`` and ``make elk-stop``

You should be good to go at this point.

## Setting up kibana

There is a bonus step for setting up the index for kibana, this can only be done after at least 1 message got published
Once that's done (you can verify the message in KafDrop or rabbitMQ management), you should:
1. Visit "http://localhost:5601"
2. Click the big box titled "Kibana" (on the right side)
3. Click "Add your data"
4. Click "Create Index Pattern"
5. You should see a source in the list titles "message-<date>"
6. Type in "messages-*" into the "index pattern name" box and click "Next"
7. Select either "@timestamp" or "occurred_at" from the dropdown menu and click Done 

You should be able to see messages coming through now if you select "Discover" from the hamburger menu on the top left side (Under Analytics) 

## How to build the project

This one is easy, just run ``make`` (or ``make build``)

## How to run the tests

Also easy, just run ``make test``

## How to run the project

There are 2 ways of running the code, by hand/from your IDE, or as a docker container

### Running the code by hand

After building the project, you should be able to run the main application by running ``java -jar target/gs-maven-0.1.0.jar``
This will start the currently configured consumer

### Running the code from your IDE

1. Set the project up in your favorite IDE
2. Make sure you define these in your ``/etc/hosts``:  
``127.0.0.1 kafka``  
``127.0.0.1 rabbitmq``  
3. Click run in your IDE

You can run 3 scripts this way, "MyApplication" will run the consumer (whichever one is configured in the container).   
The other 2 are "Example1" and "Example2":  
- Example1 will just simply publish a ``transaction_cleared`` event that will act as a trigger for the consumer to handle it.  
- Example2 will publish 3 versions of an event, and let a consumer direct it to a handler that will interpret all of them as version 2

### Running the code as a docker container

In order to run the project in a docker container:
1. Build the container by running ``make container``
2. Run ``docker run --network=poc-events events-poc`` (or simply run ``docker-compose up`` from the project root directory)

## How does the processing work / what should I see?

### Example1

In the first example, the application cares about 2 messages ``transaction_cleared`` and ``calculate_charges``
In the current setup, there is a single handler listening to ``transaction_cleared`` and publishing ``calculate_charges`` as a consequence, therefore in order for you to see anything happening you should kick the process off by publishing a ``transaction_cleared`` event.
You can publish this message either by hand in the web UI, or use a small script was provided for your convenience called "Example1" in the main application (just run Example1.java from you IDE)

Once the ``transaction_cleared`` event is published, (and the consumer is running, or started up after) you should see it processing the event, handling it, and publishing the ``calculate_charges`` command as a response to it.
What exactly happens depends on which consumer is configured, it's a difference of how the 2 are set up.

__Kafka__:
 
---publish transaction_cleared event to---> (T)testtopic   
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---consumed by---> MyApplication   
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---publish calculate_charges to---> (T)othertopic   
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---> END 

(T): Topic

Both "testtopic" and "othertopic" is also consumed by elk

__RabbitMQ__:

---publish transaction_cleared event to ---> (X)events  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--- gets routed to ---> (Q)logging AND  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--- gets routed to ---> (Q)testqueue  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---consumed by---> MyApplication  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---publish calculate_charges to---> (X)commands  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--- gets routed to ---> (Q)logging AND    
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--- gets routed to ---> (Q)testqueue  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---consumed by---> MyApplication  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---> END 

(X): Exchange  
(Q): Queue

the "logging" queue is consumed by elk

### Example2

Example 2 is for message versioning, you can use the "Example2" script to publish 3 different versions of the same message ``transaction_cancelled``.
Once it did a handler will pick that up, and act like this application is interested about version 2 of this message (only), but will still consume v1 and v3 messages just fine.

## How to change consumers

Currently the consumer/publisher in use is simply a value in the DI config (src/main/resources/applicationContext.xml).  
The correct values are:

Kafka:  
``<alias name="splitKafkaPublisher" alias="messagePublisher" />``  
``<alias name="kafkaConsumer" alias="messageConsumer" />``

RabbitMQ:  
``<alias name="splitRabbitPublisher" alias="messagePublisher" />``  
``<alias name="rabbitConsumer" alias="messageConsumer" />``

Change one for the other if you want to switch technologies 

## Message formats 

Generic AVRO serialization was added. From now on, the deserializer is picked dynamically based on the message header,  
while serialization remains controlled by the DI container configuration (as expected).

In order to change between publish formats, just alias your preferred serializer as "serializer"  
(both are provided in the applicationContext.xml - one commented and one active)

rjs1:  
``<alias name="decoratedRjs1Serializer" alias="serializer"/>``  

hav1:  
``<alias name="hav1Serializer" alias="serializer"/>``  

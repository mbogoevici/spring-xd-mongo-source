Mongo Source for Spring XD
==========================

What is this?
-------------

This is a deployable MongoDB source for Spring XD.

How can I use it?
-----------------

Build it:

    ./gradlew clean buildModule
     
Unzip the library

    unzip build/distributions/mongo-1.0-SNAPSHOT.zip -d $XD_HOME/modules/sources/mongo

Stream data

    xd:>stream create --name mongodump --definition "mongo --host=localhost --port=27017 --databaseName=test --collection=testData --query={'something':{$gt:0}} | log" --deploy

Known issues
------------

A query parameter must be specified, lest a NPE occurs (to be fixed).
    
What's next?
------------

- document cleanup support
- tailable cursor streaming
- tests

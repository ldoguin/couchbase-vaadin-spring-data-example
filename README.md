# Accessing Couchbase database

An integration example how to access data from Couchbase database using a 
Spring Boot application using Vaadin UI.

## Preparations

[Install and run Couchbase](http://www.couchbase.com/download) 
locally (or configure the app to connect to a non localhost address). The app 
connects to the "default" bucket. Make you create the approprite indexes first.

### Customer all View Index

To use Couchbase Spring Data repositories, you need to define views. For a Customer repsitory, your design document should be named "customer' and your view should be named 'all'. This view must returns every Customer documents.

    function (doc, meta) {
      if (doc._class == "hello.Customer") {
        emit(meta.id, null);
      }
    }

More details on view creations can be found on our [documentation](http://developer.couchbase.com/documentation/server/4.1/indexes/mapreduce-view-creation.html).

### N1QL Primary index

To create a Primary index on N1QL, run the following query:

    cbq> CREATE PRIMARY INDEX ON `default`;
    {
        "requestID": "8278f5a9-9e26-4bfc-bce5-fe491f0c2c25",
        "signature": null,
        "results": [
         ],
        "status": "success",
        "metrics": {
            "elapsedTime": "1.132893089s",
            "executionTime": "1.132844591s",
            "resultCount": 0,
            "resultSize": 0
        }
    }

More details can be found on our [documentation](http://developer.couchbase.com/documentation/server/4.1/n1ql/index.html).

## Execute the app

As this is an integration example, you probably want to run this from IDE 
and play with it. Just import the project properly to your favorite IDE 
and execute the main method from Application class. If you are new to Maven, see 
[these instructions](https://vaadin.com/blog/-/blogs/the-maven-essentials-for-the-impatient-developer).

Once the application starts up, a demo table (customer) is created and 
some demo data inserted. A simple Vaadin based UI can be used with browser from
 http://localhost:8080/


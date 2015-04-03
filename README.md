# Fluent Pivotal

A fluent Java 8 library to access the [Pivotal Tracker API](https://www.pivotaltracker.com/help/api/rest/v5#top), released under the LGPL by [OneSpot](http://onespot.com/).

```java
  PivotalTracker pivotalTracker = new PivotalTracker(PIVOTAL_API_TOKEN);

  List<Story> stories = pivotalTracker.projects().id(PROJECT_ID)
                .stories()
                .withFields(owners, accepted_at, estimate)
                .acceptedAfter(now().minus(2 * 30 * 24, HOURS))
                .getAll();
  
  stories.forEach((s) -> {
      System.out.println(s.getName());
  });
```

This is **pre-alpha quality**.  The API is perhaps only 10% supported so far, however it is probably the most useful 10%.

### Usage

For Maven/Gradle repository see [JitPack.io](https://jitpack.io/#onespot/pivotal/).

### Contributing

Contributions to support more of the API are very welcome, the basic framework is fairly nice to build upon, and you should be able to get a good idea of how to extend the API with just a few minutes looking at the codebase.

* [onespot.pivotal.api.resources](https://github.com/onespot/pivotal/tree/master/src/main/java/onespot/pivotal/api/resources) - Java POJOs that map directly to [resources](https://www.pivotaltracker.com/help/api/rest/v5#Resources) in the Pivotal API
* [onespot.pivotal.api.dao](https://github.com/onespot/pivotal/tree/master/src/main/java/onespot/pivotal/api/dao) - Classes that correspond roughly to [endpoints](https://www.pivotaltracker.com/help/api/rest/v5#Endpoints) in the Pivotal API
* [onespot.pivotal.rest](https://github.com/onespot/pivotal/tree/master/src/main/java/onespot/pivotal/rest) - The REST machinery (uses [Google Gson](https://code.google.com/p/google-gson/) for POJO-JSON mapping)




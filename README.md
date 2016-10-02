# Fluent Pivotaltracker java client

A fluent Java 8 library to access the [Pivotal Tracker API](https://www.pivotaltracker.com/help/api/rest/v5#top), initially created by OneSpot](http://onespot.com/) and released under the LGPL, now maintained by [Ian Clarke](http://blog.locut.us/).

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

The library is far from complete, the API is perhaps only 10% supported so far, however it is probably the most useful 10%.  Adding support for new parts of the API is very easy (see below), and pull requests will be most welcome.

### Dependency Management tools

This library is available via Gradle, Maven, SBT, Leiningen and compatible dependency management tools through the excellent JitPack:

[![Release](https://jitpack.io/v/sanity/pivotal.svg)](https://jitpack.io/#sanity/pivotal)

Note that we follow the [Semantic Versioning](http://semver.org/) convention for version numbers.

### Contributing

Contributions to support more of the API are very welcome, the basic framework is fairly nice to build upon, and you should be able to get a good idea of how to extend the API with just a few minutes looking at the codebase.

* [onespot.pivotal.api.resources](https://github.com/onespot/pivotal/tree/master/src/main/java/onespot/pivotal/api/resources) - Java POJOs that map directly to [resources](https://www.pivotaltracker.com/help/api/rest/v5#Resources) in the Pivotal API
* [onespot.pivotal.api.dao](https://github.com/onespot/pivotal/tree/master/src/main/java/onespot/pivotal/api/dao) - Classes that correspond roughly to [endpoints](https://www.pivotaltracker.com/help/api/rest/v5#Endpoints) in the Pivotal API
* [onespot.pivotal.rest](https://github.com/onespot/pivotal/tree/master/src/main/java/onespot/pivotal/rest) - The REST machinery (uses [Google Gson](https://code.google.com/p/google-gson/) for POJO-JSON mapping)




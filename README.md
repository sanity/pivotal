# Pivotal

A fluent Java 8 interface to the [Pivotal Tracker API](https://www.pivotaltracker.com/help/api/rest/v5#top).  

This is **pre-alpha quality**.  The API is perhaps only 10% supported so far, however it is probably the most useful 10%.

Contributions to support more of the API are very welcome, the basic framework is fairly nice to build upon, and you should be able to get a good idea of how to extend the API with just a few minutes looking at the codebase.

A few pointers:

* [onespot.pivotal.api.resources](https://github.com/onespot/pivotal/tree/master/src/main/java/onespot/pivotal/api/resources) - Java POJOs that map directly to [resources](https://www.pivotaltracker.com/help/api/rest/v5#Resources) in the Pivotal API
* [onespot.pivotal.api.dao](https://github.com/onespot/pivotal/tree/master/src/main/java/onespot/pivotal/api/dao) - Classes that correspond roughly to [endpoints](https://www.pivotaltracker.com/help/api/rest/v5#Endpoints) in the Pivotal API
* [onespot.pivotal.rest](https://github.com/onespot/pivotal/tree/master/src/main/java/onespot/pivotal/rest) - The REST 

For Maven/Gradle repository see [JitPack.io](https://jitpack.io/#onespot/pivotal/).

Example:

```java
  PivotalTracker pivotalTracker = new PivotalTracker(PIVOTAL_API_TOKEN);

  List<Story> startedRefactoringStories = pivotalTracker.projects().get(PROJECT_ID)
          .stories()
          .withLabel("refactoring")
          .withState(Story.StoryState.started)
          .getAll();
  
  startedRefactoringStories.forEach((s) -> {
      System.out.println(s.name);
  });
```

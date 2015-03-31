# Pivotal

A fluent Java interface to the Pivotal Tracker API.  Alpha quality.

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

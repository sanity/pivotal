package onespot.pivotal;

import onespot.pivotal.api.PivotalTracker;
import onespot.pivotal.api.resources.Story;

import static onespot.pivotal.api.resources.Story.StoryState.started;

/**
 * Created by ian on 3/23/15.
 */
public class PivotalApp {

    public static final int ONESPOT_PROJECT_ID = 1078980;

    public static void main(String[] args) throws Exception {
        PivotalTracker pivotalTracker = new PivotalTracker("d907ecf7854bca720229600c5d64dcba");

        double startedPoints = pivotalTracker.projects().get(ONESPOT_PROJECT_ID)
                .stories()
                .withState(started)
                .getAll()
                .stream()
                .mapToDouble(Story::getEstimate)
                .sum();

        double startedRefactoringPoints = pivotalTracker.projects().get(ONESPOT_PROJECT_ID)
                .stories()
                .withState(started)
                .withLabel("refactoring")
                .getAll()
                .stream()
                .mapToDouble(Story::getEstimate)
                .sum();

        System.out.println("Of "+startedPoints+" points started, "+startedRefactoringPoints+" are refactoring");
    }
}

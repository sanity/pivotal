package onespot.pivotal.api.resources;

/**
 * Created by ian on 3/28/15.
 */
public class StoryCounts {
    public CountsByStoryState numberOfZeroPointStoriesByState, sumOfStoryEstimatesByState, numberOfStoriesByState;
    public String kind;

    public static class CountsByStoryState {
        public Integer delivered, unscheduled, rejected, finished, unstarted, planned, accepted, started;
        public String kind;
    }
}

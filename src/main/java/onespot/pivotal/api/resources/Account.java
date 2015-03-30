package onespot.pivotal.api.resources;

import java.time.Instant;
import java.util.List;

/**
 * Created by ian on 3/28/15.
 */
public class Account {
    public Integer id;
    public String name;
    public String plan;
    public Status status;
    public Integer daysLeft;
    public Boolean overTheLimit;
    public Instant createdAt, updatedAt;
    public List<Integer> projectIds;
    public String kind;

    public enum Status {
        active, suspended, delinquent, deleted, limited
    }
}

package onespot.pivotal.api.resources;

import java.time.Instant;

/**
 * Created by ian on 3/28/15.
 */
public class Label {
    public Integer id;
    public Integer projectId;
    public String name;
    public Instant createdAt, updatedAt;
    public StoryCounts counts;

}

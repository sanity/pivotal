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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Label label = (Label) o;

        if (!id.equals(label.id)) return false;
        return projectId.equals(label.projectId);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + projectId.hashCode();
        return result;
    }

    public enum LabelFieldNames {
        id,project_id,name,created_at,updated_at,counts
    }
}

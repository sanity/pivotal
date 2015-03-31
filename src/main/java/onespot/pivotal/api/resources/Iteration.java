package onespot.pivotal.api.resources;

import java.time.Instant;
import java.util.List;

/**
 * Created by ian on 3/30/15.
 */
public class Iteration {
    public Integer number, projectId, length;
    public Float teamStrength;
    public List<Integer> story_ids;
    public List<Story> stories;
    public Instant start, finish;
    public String kind;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Float getTeamStrength() {
        return teamStrength;
    }

    public void setTeamStrength(Float teamStrength) {
        this.teamStrength = teamStrength;
    }

    public List<Story> getStories() {
        return stories;
    }

    public void setStories(List<Story> stories) {
        this.stories = stories;
    }

    public Instant getStart() {
        return start;
    }

    public void setStart(Instant start) {
        this.start = start;
    }

    public Instant getFinish() {
        return finish;
    }

    public void setFinish(Instant finish) {
        this.finish = finish;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
}

package onespot.pivotal.api.resources;

import java.time.Instant;
import java.util.List;

/**
 * Created by ian on 3/28/15.
 */
public class Me {
    public Integer id;
    public String name, initials, username;
    public TimeZone timeZone;
    public String apiToken;
    public Boolean hasGoogleIdentity;
    public List<Integer> projectIds, workspaceIds;
    public String email;
    public Boolean receivesInAppNotifications;
    public Instant createdAt, updatedAt;
    public String kind;

    @Override
    public String toString() {
        return "Me{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", initials='" + initials + '\'' +
                ", username='" + username + '\'' +
                ", timeZone=" + timeZone +
                ", apiToken='" + apiToken + '\'' +
                ", hasGoogleIdentity=" + hasGoogleIdentity +
                ", projectIds=" + projectIds +
                ", workspaceIds=" + workspaceIds +
                ", email='" + email + '\'' +
                ", receivesInAppNotifications=" + receivesInAppNotifications +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", kind='" + kind + '\'' +
                '}';
    }
}

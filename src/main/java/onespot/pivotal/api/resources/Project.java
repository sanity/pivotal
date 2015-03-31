package onespot.pivotal.api.resources;

import com.google.gson.annotations.SerializedName;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by ian on 3/28/15.
 */
public class Project {
    public Integer id;
    public String name;
    public Integer version;
    public Integer iterationLength;
    public DayOfWeek weekStartDay;
    public String poIntegerScale;
    public Boolean poIntegerScaleIsCustom;
    public Boolean bugsAndChoresAreEstimatable;
    public Boolean automaticPlanning;
    public Boolean enableFollowing;
    public Boolean enableTasks;
    public LocalDate startDate;
    public TimeZone timeZone;
    public Integer velocityAveragedOver;
    public Instant shownIterationsStartTime;
    public Instant startTime;
    public Integer numberOfDoneIterationsToShow;
    public Boolean hasGoogleDomain;
    public String description;
    public String profileContent;
    public Boolean enableIncomingEmails;
    public Integer initialVelocity;
    public String projectType;

    @SerializedName("public")
    public Boolean isPublic;
    public Boolean atomEnabled;
    public Integer currentIterationNumber;
    public Integer currentVelocity;
    public Integer accountId;
    public AccountingType accountingType;
    public Boolean featured;
    public List<Integer> storyIds, epicIds, membershipIds, labelIds, integrationIds, iterationOverrideNumbers;
    public Instant createdAt;
    public Instant updatedAt;
    public String kind;


    public enum DayOfWeek {
        Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday
    }

    public enum AccountingType {
        unbillable, billable, overhead
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", version=" + version +
                ", iterationLength=" + iterationLength +
                ", weekStartDay=" + weekStartDay +
                ", poIntegerScale='" + poIntegerScale + '\'' +
                ", poIntegerScaleIsCustom=" + poIntegerScaleIsCustom +
                ", bugsAndChoresAreEstimatable=" + bugsAndChoresAreEstimatable +
                ", automaticPlanning=" + automaticPlanning +
                ", enableFollowing=" + enableFollowing +
                ", enableTasks=" + enableTasks +
                ", startDate=" + startDate +
                ", timeZone=" + timeZone +
                ", velocityAveragedOver=" + velocityAveragedOver +
                ", shownIterationsStartTime=" + shownIterationsStartTime +
                ", startTime=" + startTime +
                ", numberOfDoneIterationsToShow=" + numberOfDoneIterationsToShow +
                ", hasGoogleDomain=" + hasGoogleDomain +
                ", description='" + description + '\'' +
                ", profileContent='" + profileContent + '\'' +
                ", enableIncomingEmails=" + enableIncomingEmails +
                ", initialVelocity=" + initialVelocity +
                ", projectType='" + projectType + '\'' +
                ", isPublic=" + isPublic +
                ", atomEnabled=" + atomEnabled +
                ", currentIterationNumber=" + currentIterationNumber +
                ", currentVelocity=" + currentVelocity +
                ", accountId=" + accountId +
                ", accountingType=" + accountingType +
                ", featured=" + featured +
                ", storyIds=" + storyIds +
                ", epicIds=" + epicIds +
                ", membershipIds=" + membershipIds +
                ", labelIds=" + labelIds +
                ", integrationIds=" + integrationIds +
                ", iterationOverrideNumbers=" + iterationOverrideNumbers +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", kind='" + kind + '\'' +
                '}';
    }

    public enum ProjectFieldNames {
        id,name,version,iteration_length,week_start_day,po_integer_scale,po_integer_scale_is_custom,bugs_and_chores_are_estimatable,automatic_planning,enable_following,enable_tasks,start_date,time_zone,velocity_averaged_over,shown_iterations_start_time,start_time,number_of_done_iterations_to_show,has_google_domain,description,profile_content,enable_incoming_emails,initial_velocity,project_type,is_public,atom_enabled,current_iteration_number,current_velocity,account_id,accounting_type,featured,story_ids,epic_ids,membership_ids,label_ids,integration_ids,iteration_override_numbers,created_at,updated_at,kind
    }
}

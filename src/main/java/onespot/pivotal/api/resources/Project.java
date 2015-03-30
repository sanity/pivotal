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
}

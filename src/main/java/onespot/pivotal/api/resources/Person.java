package onespot.pivotal.api.resources;

/**
 * Created by ian on 3/28/15.
 */
public class Person {
    public Integer id;
    public String name;
    public String email;
    public String initials;
    public String username;
    public String kind;

    public enum PersonFieldNames {
        id,name,email,initials,username,kind
    }
}

package teambuilder.model.team;

//import static teambuilder.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Set;

import teambuilder.model.person.Name;
import teambuilder.model.person.Person;

//import teambuilder.model.tag.Tag;

//import java.util.Collections;
//import java.util.HashSet;
//import java.util.Objects;

/**
 * Team clas
 */
public class Team {
    private final Name teamName;
    //    private final int sizeLimit;
    //  private Set<Tag>; TODO: in future feature updates
    private final Set<Person> members;

    /**
     * Initiates teams class.
     * @param teamName name of the team
     * @param sizeLimit max number of members in the team
     * @param members
     */
    public Team(Name teamName, Integer sizeLimit, Set<Person> members) {
        this.teamName = teamName;
        this.members = members;

    }

    public Name getName() {
        return teamName;
    }

    /**
     * Returns true if both persons have the same name.
     * This defines a weaker notion of equality between two persons.
     */
    public boolean isSamePerson(Team otherTeam) {
        if (otherTeam == this) {
            return true;
        }

        return otherTeam != null
                && otherTeam.getName().equals(getName());
    }

}

package teambuilder.logic.commands;

import teambuilder.logic.commands.exceptions.CommandException;
import teambuilder.model.Model;
import teambuilder.model.person.Person;
import teambuilder.model.team.Team;

import static java.util.Objects.requireNonNull;
import static teambuilder.logic.parser.CliSyntax.*;
import static teambuilder.logic.parser.CliSyntax.PREFIX_TAG;

public class CreateCommand extends Command {

    public static final String COMMAND_WORD = "create";

    // @formatter:off
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Creates a new team. "
            + "Parameters: "
            + PREFIX_TEAMNAME + "TEAMNAME "
            + PREFIX_TEAMDESC + "TEAMDESC "
            + "[" + PREFIX_TAG + "TAG]...\n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_TEAMNAME + "Team A "
            + PREFIX_TEAMDESC + "Team for upcoming hackathon "
            + PREFIX_TAG + "Python "
            + PREFIX_TAG + "ReactNative";

    public static final String MESSAGE_SUCCESS = "New team created: %1$s";

    public static final String MESSAGE_DUPLICATE_TEAM = "This team already exists in TeamBuilder";

    private final Team toCreate;

    /**
     * Creates an CreateCommand to add the specified
     */
    public CreateCommand(Team team) {
        requireNonNull(team);
        toCreate = team;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

//        if (model.hasTeam(toCreate)) {
//            throw new CommandException(MESSAGE_DUPLICATE_TEAM);
//        }
//
//        model.addTeam(toCreate);

        return new CommandResult(String.format(MESSAGE_SUCCESS, toCreate));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof CreateCommand // instanceof handles nulls
                && toCreate.equals(((CreateCommand) other).toCreate));
    }

}

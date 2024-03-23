package seedu.address.logic.commands;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_BOOKLIST;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;

import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.BookList;
import seedu.address.model.person.Person;

/**
 * Adds a book to the book list to the specific borrower.
 */
public class BorrowCommand extends Command {
    public static final String COMMAND_WORD = "borrow";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Edits the book list of the person identified "
            + "by the index number used in the last person listing. "
            + "Existing borrow will be overwritten by the input.\n"
            + "Parameters: INDEX (must be a positive integer) "
            + PREFIX_BOOKLIST + "[borrow]\n"
            + "Example: " + COMMAND_WORD + " 1 "
            + PREFIX_BOOKLIST + "Likes to swim.";

    public static final String MESSAGE_ADD_BORROW_SUCCESS = "Added book to Person: %1$s";

    private final Index index;
    private final BookList bookTitle;

    /**
     * @param index     of the person in the filtered person list to edit the
     *                  bookTitle
     * @param bookTitle of the person to be updated to
     */
    public BorrowCommand(Index index, BookList bookTitle) {
        requireAllNonNull(index, bookTitle);
        this.index = index;
        this.bookTitle = bookTitle;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        List<Person> lastShownList = model.getFilteredPersonList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        if (bookTitle.equals(new BookList(""))) {
            throw new CommandException(Messages.MESSAGE_EMPTY_BOOK_INPUT_FIELD);
        }

        Person personToEdit = lastShownList.get(index.getZeroBased());

        // Checks whether personToEdit has sufficient merit score
        if (personToEdit.getMeritScore().getMeritScoreInt() <= 0) {
            throw new CommandException(Messages.MESSAGE_INSUFFICIENT_MERIT_SCORE);
        }

        // This is for checking, only borrows when the attribute bookTitle is not empty
        // This shall be deleted soon when we implement multiple books in the BookList
        if (!personToEdit.getBookList().getBook().bookTitle.isEmpty()) {
            throw new CommandException(Messages.MESSAGE_FILLED_BOOKLIST_FIELD);
        }

        Person editedPerson = new Person(personToEdit.getName(), personToEdit.getPhone(), personToEdit.getEmail(),
                personToEdit.getAddress(), personToEdit.getMeritScore().decrementScore(),
                bookTitle, personToEdit.getTags());

        model.setPerson(personToEdit, editedPerson);
        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);

        return new CommandResult(generateSuccessMessage(editedPerson));
    }

    /**
     * Formats and returns the borrow success message.
     * {@code personToEdit}.
     */
    private String generateSuccessMessage(Person personToEdit) {
        return String.format(MESSAGE_ADD_BORROW_SUCCESS, personToEdit);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof BorrowCommand)) {
            return false;
        }

        BorrowCommand e = (BorrowCommand) other;
        return index.equals(e.index)
                && bookTitle.equals(e.bookTitle);
    }
}

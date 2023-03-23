package tfifteenfour.clipboard.model;

import java.nio.file.Path;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import tfifteenfour.clipboard.commons.core.GuiSettings;
import tfifteenfour.clipboard.logic.commands.Command;
import tfifteenfour.clipboard.model.course.Course;
import tfifteenfour.clipboard.model.student.Student;

/**
 * The API of the Model component.
 */
public interface Model {
    /** {@code Predicate} that always evaluate to true */
    Predicate<Student> PREDICATE_SHOW_ALL_PERSONS = unused -> true;

    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' address book file path.
     */
    Path getRosterFilePath();

    /**
     * Sets the user prefs' address book file path.
     */
    void setRosterFilePath(Path addressBookFilePath);

    /**
     * Replaces address book data with the data in {@code roster}.
     */
    void setRoster(ReadOnlyRoster roster);

    /** Returns the Roster */
    ReadOnlyRoster getRoster();

    /**
     * Returns true if a student with the same identity as {@code student} exists in the address book.
     */
    boolean hasStudent(Student student);

    boolean hasCourse(Course course);

    /**
     * Deletes the given student.
     * The student must exist in the address book.
     */
    void deleteStudent(Student target);

    /**
     * Adds the given student.
     * {@code student} must not already exist in the address book.
     */
    void addStudent(Student student);

    void addCourse(Course course);

    /**
     * Replaces the given student {@code target} with {@code editedStudent}.
     * {@code target} must exist in the address book.
     * The student identity of {@code editedStudent} must not be the same as another
     * existing student in the address book.
     */
    void setStudent(Student target, Student editedStudent);

    /** Returns an unmodifiable view of the filtered student list */
    ObservableList<Student> getUnmodifiableFilteredStudentList();

    ObservableList<Student> getModifiableFilteredStudentList();

    ObservableList<Course> getModifiableFilteredCourseList();

    /**
     * Updates the filter of the filtered student list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredStudentList(Predicate<Student> predicate);

    //=========== Viewed Student Accessors =============================================================
    ObservableList<Student> getViewedStudent();

    void updateViewedStudent(Predicate<Student> predicate);
    /**
     * Makes a copy of the model
     */
    Model copy();

    public void setCommandTextExecuted(String commandText);

    public String getCommandTextExecuted();

    public void setCommandExecuted(Command command);

    public Command getCommandExecuted();
}

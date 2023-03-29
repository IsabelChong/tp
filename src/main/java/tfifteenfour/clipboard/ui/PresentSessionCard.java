package tfifteenfour.clipboard.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import tfifteenfour.clipboard.MainApp;
import tfifteenfour.clipboard.commons.core.LogsCenter;

import java.util.logging.Logger;

public class PresentSessionCard extends UiPart<Region> {
    private static final String FXML = "AttendanceListCard.fxml";
    private static final Logger logger = LogsCenter.getLogger(MainApp.class);

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final SessionWithAttendance session;

    @FXML
    private HBox cardPane;
    @FXML
    private Label name;
    @FXML
    private Label id;

    public PresentSessionCard(SessionWithAttendance session, int displayedIndex) {
        super(FXML);
        this.session = session;
        id.setText(displayedIndex + ". ");
        name.setText(session.getSessionName());
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof PresentSessionCard)) {
            return false;
        }

        // state check
        PresentSessionCard card = (PresentSessionCard) other;
        return id.getText().equals(card.id.getText())
                && session.equals(card.session);
    }
}

package tfifteenfour.clipboard.logic.parser;

import static tfifteenfour.clipboard.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static tfifteenfour.clipboard.logic.parser.CommandParserTestUtil.assertParseFailure;
import static tfifteenfour.clipboard.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static tfifteenfour.clipboard.testutil.TypicalIndexes.INDEX_FIRST_PERSON;

import org.junit.jupiter.api.Test;

import tfifteenfour.clipboard.logic.commands.deletecommand.DeleteStudentCommand;

/**
 * As we are only doing white-box testing, our test cases do not cover path variations
 * outside of the DeleteStudentCommand code. For example, inputs "1" and "1 abc" take the
 * same path through the DeleteStudentCommand, and therefore we test only one of them.
 * The path variation for those two cases occur inside the ParserUtil, and
 * therefore should be covered by the ParserUtilTest.
 */
public class DeleteCommandParserTest {

    private DeleteCommandParser parser = new DeleteCommandParser();

    @Test
    public void parse_validArgs_returnsDeleteStudentCommand() {
        assertParseSuccess(parser, "1", new DeleteStudentCommand(INDEX_FIRST_PERSON));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        assertParseFailure(parser, "a",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteStudentCommand.MESSAGE_USAGE));
    }
}

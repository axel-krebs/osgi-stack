package players;

import static org.junit.Assert.assertEquals;

import java.util.stream.IntStream;

import org.junit.Test;

/**
 * Player test class.
 * 
 * @author akrebs
 *
 */
public class PlayersTest{

    /** Requirement: Number of messages is 10 */
    static final int NR_OF_MESSAGES = 1000000;

    /** Requirement: Message must be concatenable */
    static final String MESSAGE = "hello";

    @Test
    public void testSameProcess() {
	Player initiator = new Player();
	Player receiver = new Player();
	while (initiator.nrReceived != NR_OF_MESSAGES) {
	    String response = receiver.receive(MESSAGE);
	    initiator.receive(response);
	}
	assertEquals(NR_OF_MESSAGES, initiator.nrReceived);
    }

    @Test
    public void testSeparateProcess() {
	Player initiator = new Player();
	Player receiver = new Player();
	IntStream range = IntStream.rangeClosed(1, NR_OF_MESSAGES);
	range.parallel().forEach(i -> initiator.receive(receiver.receive(MESSAGE)));
	assertEquals(NR_OF_MESSAGES, initiator.nrReceived);
    }
}

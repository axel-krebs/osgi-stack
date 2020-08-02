package players;

/**
 * class Player.
 */
public class Player {

    int nrReceived = 0;

    /**
     * Receive a message. Synchronization necessary for execution in stream.
     * 
     * @param message
     * @return The received message concatenated with the counter value of a counter
     *         holding the number of messages this player already sent.
     */
    public synchronized String receive(String message) {
	String response = message + ++nrReceived;
	return response;
    }

}

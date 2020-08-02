package players;

import java.util.stream.IntStream;

public class Main {

    private static final int NR_OF_MESSAGES = 10;
    private static final String MESSAGE = "hallo";

    public static void main(String[] args) {
	System.out.println("Starting players parallel in stream of Integer..");
	Player initiator = new Player();
	Player receiver = new Player();
	IntStream range = IntStream.rangeClosed(1, NR_OF_MESSAGES);
	range.parallel().forEach(i -> initiator.receive(receiver.receive(MESSAGE)));
	System.out.println(
		"# of messages sent: " + NR_OF_MESSAGES + ", # of messages received: " + initiator.nrReceived);
    }
}

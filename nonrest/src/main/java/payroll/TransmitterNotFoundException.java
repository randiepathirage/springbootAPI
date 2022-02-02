package payroll;

class TransmitterNotFoundException extends RuntimeException {

	TransmitterNotFoundException(Long id) {
		super("Could not find transmitter " + id);
	}
}

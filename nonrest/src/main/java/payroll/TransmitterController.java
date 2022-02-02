package payroll;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class TransmitterController {

	private final TransmitterRepository repository;

	TransmitterController(TransmitterRepository repository) {
		this.repository = repository;
	}


	// Aggregate root
	// tag::get-aggregate-root[]
	@GetMapping("/transmitter")
	List<Transmitter> all() {
		return repository.findAll();
	}
	// end::get-aggregate-root[]

	@PostMapping("/transmitter")
	Transmitter newTransmitter(@RequestBody Transmitter newTransmitter) {
		return repository.save(newTransmitter);
	}

	// Single item
	
	@GetMapping("/transmitter/{id}")
	Transmitter one(@PathVariable Long id) {
		
		return repository.findById(id)
			.orElseThrow(() -> new TransmitterNotFoundException(id));
	}

	@PutMapping("/transmitter/{id}")
	Transmitter replaceTransmitter(@RequestBody Transmitter newTransmitter, @PathVariable Long id) {
		
		return repository.findById(id)
			.map(transmitter -> {
				transmitter.setIssuer(newTransmitter.getIssuer());
				transmitter.setJwks_uri(newTransmitter.getJwks_uri());
				return repository.save(transmitter);
			})
			.orElseGet(() -> {
				newTransmitter.setId(id);
				return repository.save(newTransmitter);
			});
	}

	@DeleteMapping("/transmitter/{id}")
	void deleteTransmitter(@PathVariable Long id) {
		repository.deleteById(id);
	}
}


package com.mentorondemand.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentorondemand.model.Trainings;
import com.mentorondemand.repo.TrainingRepository;

@CrossOrigin(origins = "http://localhost:4321")
@RestController
@RequestMapping("/api")
public class TrainingController {
	@Autowired
	TrainingRepository trainingRepo;
	
	@PostMapping(value = "/mentor/addtrainings")
	public Trainings postCustomer(@RequestBody Trainings trainings) {

		Trainings trainingInsert = trainingRepo.save(new Trainings(trainings.getSkillId(),trainings.getMentorId(),trainings.getStartTime(),trainings.getEndTime()));
		return trainingInsert;
	
	}
}
























/*
 * package com.mentorondemand.controller;
 * 
 * import java.util.ArrayList; import java.util.Iterator; import java.util.List;
 * import java.util.Optional;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.CrossOrigin; import
 * org.springframework.web.bind.annotation.DeleteMapping; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.PutMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.mentorondemand.model.Trainings; import
 * com.mentorondemand.repo.TrainingRepository;
 * 
 * @CrossOrigin(origins = "http://localhost:4321")
 * 
 * @RestController
 * 
 * @RequestMapping("/api") public class TrainingController {
 * 
 * @Autowired TrainingRepository trainingRepo;
 * 
 * @GetMapping("/getTrainingDetails/{id}") public Optional<Trainings>
 * getAllCustomers(@PathVariable long id) {
 * System.out.println("Get all trainings details...");
 * 
 * Optional<Trainings> trainings = trainingRepo.findById(id);
 * 
 * return trainings; }
 * 
 * @GetMapping(value = "getCompletedTrainings/{status}") public List<Trainings>
 * findByStatus(@PathVariable String status) {
 * 
 * List<Trainings> trainings = trainingRepo.findByStatus(status); return
 * trainings; }
 * 
 * @GetMapping(value = "getUnderProgressTrainings/{userId}") public
 * List<Trainings> findByProgress(@PathVariable long userId) {
 * 
 * List<Trainings> trainings = trainingRepo.findByUserId(userId);
 * List<Trainings> trainingList = new ArrayList(); Iterator itr =
 * trainings.iterator(); while (itr.hasNext()) { Trainings training =
 * (Trainings) itr.next(); if (training.getStatus().equals("inprogress")) {
 * trainingList.add(training); }
 * 
 * } return trainingList; }
 * 
 * @GetMapping(value = "proposedTrainings/{userId}") public List<Trainings>
 * findByProposal(@PathVariable long userId) {
 * 
 * List<Trainings> trainings = trainingRepo.findByUserId(userId);
 * List<Trainings> trainingList = new ArrayList(); Iterator itr =
 * trainings.iterator(); while (itr.hasNext()) { Trainings training =
 * (Trainings) itr.next(); if (training.getStatus().equals("proposed")) {
 * training.setStatus("approved"); trainingList.add(training); }
 * 
 * } return trainingList; }
 * 
 * @GetMapping(value = "finalizeTraining/amount/{amountReceived}") public
 * List<Trainings> findByPayment(@PathVariable String amountReceived) {
 * List<Trainings> trainings =
 * trainingRepo.findByAmountReceived(amountReceived); return trainings; }
 * 
 * 
 * @PostMapping(value = "/trainings/create") public Customer
 * postCustomer(@RequestBody Customer customer) {
 * 
 * Customer _customer = repository.save(new Customer(customer.getName(),
 * customer.getAge())); return _customer; }
 * 
 * @DeleteMapping("/customers/{id}") public ResponseEntity<String>
 * deleteCustomer(@PathVariable("id") long id) {
 * System.out.println("Delete Customer with ID = " + id + "...");
 * 
 * repository.deleteById(id);
 * 
 * return new ResponseEntity<>("Customer has been deleted!", HttpStatus.OK); }
 * 
 * @DeleteMapping("/customers/delete") public ResponseEntity<String>
 * deleteAllCustomers() { System.out.println("Delete All Customers...");
 * 
 * repository.deleteAll();
 * 
 * return new ResponseEntity<>("All customers have been deleted!",
 * HttpStatus.OK); }
 * 
 * @GetMapping(value = "customers/age/{age}") public List<Customer>
 * findByAge(@PathVariable int age) {
 * 
 * List<Customer> customers = repository.findByAge(age); return customers; }
 * 
 * @GetMapping(value = "customers/mobile_number/{mobile_number}") public
 * List<Customer> findByAge(@PathVariable String mobile_number) {
 * 
 * List<Customer> customers = repository.findByMob(mobile_number); return
 * customers; }
 * 
 * 
 * @PutMapping("/customers/{id}") public ResponseEntity<Customer>
 * updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer) {
 * System.out.println("Update Customer with ID = " + id + "...");
 * 
 * Optional<Customer> customerData = repository.findById(id);
 * 
 * if (customerData.isPresent()) { Customer _customer = customerData.get();
 * _customer.setName(customer.getName()); _customer.setAge(customer.getAge());
 * _customer.setActive(customer.isActive()); return new
 * ResponseEntity<>(repository.save(_customer), HttpStatus.OK); } else { return
 * new ResponseEntity<>(HttpStatus.NOT_FOUND); } }
 * 
 * }
 */
package com.brk.CarShare;


import com.brk.CarShare.Entities.*;
import com.brk.CarShare.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableMongoRepositories
public class CarShareApplication implements CommandLineRunner {

	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final ISupportTicketRepository supportTicketRepository;
	private final ITripRepository tripRepository;
	private final IVehicleRepository vehicleRepository;

	@Autowired
	public CarShareApplication(UserRepository userRepository, RoleRepository roleRepository, ISupportTicketRepository supportTicketRepository, ITripRepository tripRepository, IVehicleRepository vehicleRepository){
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.supportTicketRepository = supportTicketRepository;
		this.tripRepository = tripRepository;
		this.vehicleRepository = vehicleRepository;
	}
	public static void main(String[] args) {
		SpringApplication.run(CarShareApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		if(userRepository.findAll().isEmpty()){
			Role userRole = new Role(ERole.ROLE_USER);
			Role adminRole = new Role(ERole.ROLE_ADMIN);
			Role moderatorRole = new Role(ERole.ROLE_MODERATOR);
			roleRepository.save(userRole);
			roleRepository.save(adminRole);
			roleRepository.save(moderatorRole);
			Set<Role> roles = new HashSet<>();
			Set<Role> roles2 = new HashSet<>();
			Set<Role> roles3 = new HashSet<>();
			roles.add(userRole);
			roles2.add(adminRole);
			roles3.add(moderatorRole);
			userRepository.save(new User("Gandalf","gandalf123@gmail.com","password123",roles));
			userRepository.save(new User("Perosaurus","perosaurus@gmail.com","password123",roles));
			userRepository.save(new User("Nickname","nickname@gmail.com","password123",roles));
			userRepository.save(new User("Adminsaurus","adminsaurus@gmail.com","password123",roles2));
			userRepository.save(new User("userinho","userinho@gmail.com","password123",roles));
			userRepository.save(new User("moderatinho","moderatorinho@gmail.com","password123",roles3));
		}

		if(supportTicketRepository.findAll().isEmpty()){
			SupportTicket ticket1 = new SupportTicket();
			ticket1.setTitle("Ticket 1");
			ticket1.setDescription("Ticket 1 description");
			ticket1.setIsClosed(false);
			ticket1.setStatus("Open");
			supportTicketRepository.save(ticket1);

			SupportTicket ticket2 = new SupportTicket();
			ticket2.setTitle("Ticket 2");
			ticket2.setDescription("Ticket 2 description");
			ticket2.setIsClosed(true);
			ticket2.setStatus("Closed");
			supportTicketRepository.save(ticket2);

			SupportTicket ticket3 = new SupportTicket();
			ticket3.setTitle("Ticket 3");
			ticket3.setDescription("Ticket 3 description");
			ticket3.setIsClosed(false);
			ticket3.setStatus("Open");
			supportTicketRepository.save(ticket3);

		}

		if (tripRepository.findAll().isEmpty()) {
			Trip trip1 = new Trip();
			trip1.setUserId("userId1");
			trip1.setVehicleId("vehicleId1");
			trip1.setStatus("Completed");
			trip1.setStartLocation("Ul. Domovinskog rata 12");
			trip1.setStartTime("2022-01-01 10:00:00");
			trip1.setEndLocation("Los Angeles");
			trip1.setEndTime("2022-01-01 12:00:00");
			trip1.setDuration("2h");
			tripRepository.save(trip1);

			Trip trip2 = new Trip();
			trip2.setUserId("userId2");
			trip2.setVehicleId("vehicleId2");
			trip2.setStatus("In Progress");
			trip2.setStartLocation("Ul. Ivana Kukuljevića Sakcinskog 4");
			trip2.setStartTime("2022-01-02 8:00:00");
			trip2.setEndLocation("");
			trip2.setEndTime("");
			trip2.setDuration("");
			tripRepository.save(trip2);

			Trip trip3 = new Trip();
			trip3.setUserId("userId3");
			trip3.setVehicleId("vehicleId3");
			trip3.setStatus("Cancelled");
			trip3.setStartLocation("Put Skalica 44");
			trip3.setStartTime("2022-01-03 6:00:00");
			trip3.setEndLocation("");
			trip3.setEndTime("");
			trip3.setDuration("");
			tripRepository.save(trip3);

		}

		if (vehicleRepository.findAll().isEmpty()) {
			Vehicle vehicle1 = new Vehicle();
			vehicle1.setMake("Tesla");
			vehicle1.setModel("Model 3");
			vehicle1.setFuelType("Electric");
			vehicle1.setModelYear("2020");
			vehicle1.setRegistration("ABC123");
			vehicle1.setVin("123ABC456DEF789GHI");
			vehicle1.setStatus("Available");
			vehicle1.setSubscriptionTier("Premium");
			vehicle1.setLocation("Split, Ul. Ivana Gundulića 7");
			vehicleRepository.save(vehicle1);

			Vehicle vehicle2 = new Vehicle();
			vehicle2.setMake("Chevrolet");
			vehicle2.setModel("Bolt");
			vehicle2.setFuelType("Electric");
			vehicle2.setModelYear("2019");
			vehicle2.setRegistration("DEF456");
			vehicle2.setVin("456DEF789GHI123ABC");
			vehicle2.setStatus("Unavailable");
			vehicle2.setSubscriptionTier("Standard");
			vehicle2.setLocation("Split, Ul. Table 19 ");
			vehicleRepository.save(vehicle2);

			Vehicle vehicle3 = new Vehicle();
			vehicle3.setMake("Nissan");
			vehicle3.setModel("Leaf");
			vehicle3.setFuelType("Electric");
			vehicle3.setModelYear("2018");
			vehicle3.setRegistration("GHI789");
			vehicle3.setVin("789GHI123ABC456DEF");
			vehicle3.setStatus("Available");
			vehicle3.setSubscriptionTier("Basic");
			vehicle3.setLocation("Split, Mažuranićevo šetalište 32");
			vehicleRepository.save(vehicle3);
		}

		System.out.println("SEED DUNDO MAROJE");


	}
}

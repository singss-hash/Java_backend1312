package net.java.springboot;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import net.java.springboot.SpringbootBackendApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootBackendApplication.class, args);
    }
//@Autowired
//private EmployeeRepository employeeRepository;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		Employee employee = new Employee();
//        employee.setFirstName("Ramesh");
//        employee.setLastName("Fadatare");
//        employee.setEmailId("ramesh@gmail.com");
//        employeeRepository.save(employee);
		
		
		
	}
}
//    @Autowired
//    private EmployeeRepository employeeRepository;
//
//    @Autowired
//    private ProjectInfoRepository projectInfoRepository;
//
//    @Override
//    public void run(String[] args) throws Exception {
//        // Initialize Employee data
//        Employee employee = new Employee();
//        employee.setFirstName("Ramesh");
//        employee.setLastName("Fadatare");
//        employee.setEmailId("ramesh@gmail.com");
//        employeeRepository.save(employee);
//
////        Employee employee1 = new Employee();
////        employee1.setFirstName("John");
////        employee1.setLastName("Cena");
////        employee1.setEmailId("cena@gmail.com");
////        employeeRepository.save(employee1);
////        
//        // Initialize ProjectInfo data
////        ProjectInfo projectInfo = new ProjectInfo();
////        projectInfo.setProjectName("Project Alpha");
////        projectInfo.setDepartment("Development");
////        projectInfo.setLocation("New York");
////        projectInfo.setClients("Client A, Client B");
////        projectInfo.setProjectStartDate(LocalDateTime.now());
////        projectInfo.setProjectExpirationTime(LocalDateTime.now().plusMonths(6));
////        projectInfoRepository.save(projectInfo);
////        
////        projectInfo.setProjectName("Project Beta");
////        projectInfo.setDepartment("AWS");
////        projectInfo.setLocation("Las Vegas");
////        projectInfo.setClients("Client Germany");
////        projectInfo.setProjectStartDate(LocalDateTime.now());
////        projectInfo.setProjectExpirationTime(LocalDateTime.now().plusMonths(9));
////        projectInfoRepository.save(projectInfo);
//        
//        
//    }
//}
//

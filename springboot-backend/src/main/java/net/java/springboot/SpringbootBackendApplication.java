package net.java.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import net.java.springboot.model.Employee;
import net.java.springboot.model.ProjectInfo;
import net.java.springboot.repository.EmployeeRepository;
import net.java.springboot.repository.ProjectInfoRepository;

import java.time.LocalDateTime;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootBackendApplication.class, args);
    }

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ProjectInfoRepository projectInfoRepository;

    @Override
    public void run(String... args) throws Exception {
        // Initialize Employee data
        Employee employee = new Employee();
        employee.setFirstName("Ramesh");
        employee.setLastName("Fadatare");
        employee.setEmailId("ramesh@gmail.com");
        employeeRepository.save(employee);

        Employee employee1 = new Employee();
        employee1.setFirstName("John");
        employee1.setLastName("Cena");
        employee1.setEmailId("cena@gmail.com");
        employeeRepository.save(employee1);
        
        // Initialize ProjectInfo data
        ProjectInfo projectInfo = new ProjectInfo();
        projectInfo.setProjectName("Project Alpha");
        projectInfo.setDepartment("Development");
        projectInfo.setLocation("New York");
        projectInfo.setClients("Client A, Client B");
        projectInfo.setProjectStartDate(LocalDateTime.now());
        projectInfo.setProjectExpirationTime(LocalDateTime.now().plusMonths(6));
        projectInfoRepository.save(projectInfo);
    }
}


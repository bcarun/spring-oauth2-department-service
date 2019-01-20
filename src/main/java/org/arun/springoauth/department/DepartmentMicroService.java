package org.arun.springoauth.department;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class,
                                  UserDetailsServiceAutoConfiguration.class})
public class DepartmentMicroService {

  public static void main(String[] args) {
    SpringApplication.run(DepartmentMicroService.class, args);
  }

  @RestController
  @RequestMapping("/api/departments")
  public static class DepartmentRestController {

    @GetMapping(path = "/1")
    @PreAuthorize("hasAnyAuthority('ROLE_READ_DEPARTMENT')")
    public String getDepartment() {
      return "Software Product Engineering";
    }
  }

}


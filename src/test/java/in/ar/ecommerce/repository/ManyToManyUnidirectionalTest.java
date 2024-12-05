package in.ar.ecommerce.repository;

import in.ar.ecommerce.entity.Role;
import in.ar.ecommerce.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

@SpringBootTest
public class ManyToManyUnidirectionalTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void saveUserData() {

        User user = new User();
        user.setFirstName("Pavan Kumar");
        user.setLastName("Reddy");
        user.setEmail("pavankumar@gmail.com");
        user.setPassword("Pavan@1234");

        Role role1 = new Role();
        role1.setName("Software");

        Role role2 = new Role();
        role2.setName("Developer");
        user.setRoles(Set.of(role1,role2));

        userRepository.save(user);
    }

    @Test
    void updateUser(){
    User user =  userRepository.findById(1L).get();
    user.setFirstName("Buggana Naga Pavan");

    Role role = new Role();
    role.setName("ROLE_USER");

    user.getRoles().add(role);
    userRepository.save(user);
    }

    @Test
    void fecthUser(){
     User user = userRepository.findById(1L).get();
        System.out.println(user.getEmail());
        user.getRoles().forEach((r) -> {
            System.out.println(r.getName());
        });
    }
}

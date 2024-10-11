package fr.hb.jordan_gadet.examen_spring_jordan_gadet.service;

import fr.hb.jordan_gadet.examen_spring_jordan_gadet.dto.UserRegisterDTO;
import fr.hb.jordan_gadet.examen_spring_jordan_gadet.entity.User;
import fr.hb.jordan_gadet.examen_spring_jordan_gadet.exception.UpgradedEntityNotFoundException;
import fr.hb.jordan_gadet.examen_spring_jordan_gadet.repository.UserRepository;
import fr.hb.jordan_gadet.examen_spring_jordan_gadet.service.interfaces.ServiceInterfaceCR;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
@AllArgsConstructor
public class UserService implements ServiceInterfaceCR<User,String, UserRegisterDTO>, UserDetailsService {

    private UserRepository repository;
    private BCryptPasswordEncoder passwordEncoder;

    public User findUser(Principal principal) {
        return repository.findByEmail(principal.getName()).orElseThrow(UpgradedEntityNotFoundException::new);
    }


    @Override
    public User create(UserRegisterDTO o) {

        User u = new User();
        u.setEmail(o.getEmail());

        if(o.getPassword().equals(o.getPassword2())){
            u.setPassword(passwordEncoder.encode(o.getPassword()));
        } else return null;

        u.setBirthedAt(o.getBirthedAt());
        u.setUsername(o.getUsername());
        u.setRoles("[\"ROLE_USER\"]");
        u.setAvatar(o.getAvatar());

        u.setCreatedAt(LocalDateTime.now());

        return repository.saveAndFlush(u);
    }

    @Override
    public User findOneById(String id) {
        return repository.findById(id).orElseThrow(UpgradedEntityNotFoundException::new);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = repository.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException("L'éléphant est dans le magasin porcelaine"));

        return new org.springframework.security.core.userdetails.User(u.getEmail(),u.getPassword(),userGrantedAuthorities(u.getRoles()));
    }

    private List<GrantedAuthority> userGrantedAuthorities(String jsonRoles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        // jsonRoles = ["ROLE_USER"] ou ["ROLE_USER", "ROLE_ADMIN"]
        //List<String> roles = Collections.singletonList(jsonRoles);
        //roles.forEach(r -> {
        // r => "ROLE_USER" puis "ROLE_ADMIN"
        //authorities.add(new SimpleGrantedAuthority(r));
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        if (jsonRoles.contains("ADMIN")) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        //});
        return authorities;
    }
}
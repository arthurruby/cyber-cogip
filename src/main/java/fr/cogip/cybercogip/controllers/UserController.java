package fr.cogip.cybercogip.controllers;

import fr.cogip.cybercogip.models.User;
import fr.cogip.cybercogip.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/users")
@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGEMENT')")
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public String getAllUsers(Model model){
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "user/all-users";
    }

    @GetMapping("/{userId}")
    public String getUserDetail(Model model, @PathVariable Long userId){
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("Invalid User Id:" + userId)
        );
        model.addAttribute("user", user);
        return "user/user-detail";
    }

    @GetMapping("/new")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getNewUserForm(@ModelAttribute("user") User user){
        return "user/user-add-form";
    }

    @PostMapping("/new")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String postNewUser(@Valid @ModelAttribute("user") User newUser, BindingResult result, Model model){
        if (result.hasErrors()){
            model.addAttribute("errors", result.getAllErrors());
            return "user/user-add-form";
        }
        userRepository.save(newUser);
        return "redirect:/users";
    }

    @GetMapping("/{userId}/update")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getUpdateUserForm(@PathVariable Long userId, Model model){
        User userToUpdate = userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("Invalid User Id:" + userId)
        );
        model.addAttribute("user", userToUpdate);
        return "user/user-update-form";
    }

    @PostMapping("/{userId}/update")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String postUpdatedUser(@Valid @ModelAttribute("user") User updatedUser, @PathVariable Long userId,
                                  BindingResult result, Model model){
        if (result.hasErrors()){
            model.addAttribute("errors", result.getAllErrors());
            return "user/user-update-form";
        }

        User userToUpdate = userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("Invalid User Id:" + userId)
        );
        userToUpdate.setUsername(updatedUser.getUsername());
        userToUpdate.setPassword(updatedUser.getPassword());
        userToUpdate.setEmail(updatedUser.getEmail());
        userToUpdate.setFirstName(updatedUser.getFirstName());
        userToUpdate.setLastName(updatedUser.getLastName());
        userToUpdate.setRole(updatedUser.getRole());
        userToUpdate.setActive(updatedUser.getActive());

        userRepository.save(userToUpdate);

        return "redirect:/users/" + userId;
    }

    @PostMapping("/{userId}/delete")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String postDeletedUser(@PathVariable Long userId, BindingResult result, Model model){
        if (result.hasErrors()){
            model.addAttribute("errors", result.getAllErrors());
            return "user/user-update-form";
        }

        User userToDelete = userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("Invalid User Id:" + userId)
        );
        userRepository.delete(userToDelete);
        return "redirect:/users";
    }
}

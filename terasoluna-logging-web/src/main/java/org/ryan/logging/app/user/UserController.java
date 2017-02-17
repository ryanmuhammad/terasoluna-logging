package org.ryan.logging.app.user;

import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.ryan.logging.domain.model.User;
import org.ryan.logging.domain.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.terasoluna.gfw.web.token.transaction.TransactionTokenCheck;
import org.terasoluna.gfw.web.token.transaction.TransactionTokenType;

import javax.inject.Inject;

/**
 * Created by Iriyanto.Perkasa on 1/23/2017.
 */
@Slf4j
@Controller
public class UserController {

    @Inject
    UserService userService;

    @Inject
    Mapper beanMapper;

    /**
     * pre-initialization of form backed bean
     * @return
     */
    @ModelAttribute
    public UserForm setUpUserForm() {
        UserForm form = new UserForm();
        log.debug("populate form {}", form);
        return form;
    }

    /**
     * shows screen registering a new user
     * @return
     */
    @TransactionTokenCheck(value = "save", type = TransactionTokenType.BEGIN)
    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String displayForm() {

        return "user/userForm";
    }

    /**
     * registering a new user
     * @param form
     * @param result
     * @return
     */
    @TransactionTokenCheck(value = "save", type = TransactionTokenType.IN)
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String register(@Validated UserForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "user/userForm";
        }

        User user = beanMapper.map(form,User.class);
        if(user.getUserId()==null) userService.register(user);
            else userService.modify(user);

        return "redirect:/";
    }

    /**
     * shows screen modify a user
     * @return
     */
    @TransactionTokenCheck(value = "save", type = TransactionTokenType.BEGIN)
    @RequestMapping(value = "modify", method = RequestMethod.GET)
    public String displayModifyForm(@RequestParam("userId") String userId, Model model) {

        User user = userService.findOne(userId);
        model.addAttribute("userForm", user);

        return "user/userForm";
    }

    /**
     * delete user
     * @param userId
     * @return
     */
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String deleteUser(@RequestParam("userId") String userId) {

        userService.delete(userId);

        return "redirect:/";
    }

}

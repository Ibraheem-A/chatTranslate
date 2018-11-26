package translate.useCases.userAccount;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserAccountController {
    UserAccountService userAccountService = new UserAccountService();

    @RequestMapping (path = "userAccount", method = RequestMethod.POST)
    public void postUserAccount(@RequestBody LoginDetailsDTO loginDetailsDTO){
        userAccountService.addToCurrentUserAccount(loginDetailsDTO.toLogin());
    }


}

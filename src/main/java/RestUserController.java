
import java.util.ArrayList;
import org.springframework.samples.petclinic.user.User;
import org.springframework.samples.petclinic.user.UserRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author donaldoherr
 */
@RestController
public class RestUserController {
    
    
    @RequestMapping(method = RequestMethod.GET, path = "users")
    public String getUsers(){
        return "hola ";
    }
    
    
    
    
    
}

package com.example.demo.controler;

import com.example.demo.config.UserUrl;
import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;

@RestController
public class UserControler {

    @Autowired
    UserService userService;

    @RequestMapping(value = UserUrl.USER_EXPENSES, method = RequestMethod.GET)
    public UserDTO getUserExpenses(@RequestParam(value = "userName") String userName){
        BigDecimal totalExpenses = userService.getTotalExpensesByUser(userName);
        if(totalExpenses!= null )
            return UserDTO.builder().totalExpenses(userService.getTotalExpensesByUser(userName)).build();
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not Found");
    }
}

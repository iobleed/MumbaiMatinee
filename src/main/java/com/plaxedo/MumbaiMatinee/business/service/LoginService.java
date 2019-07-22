package com.plaxedo.MumbaiMatinee.business.service;

import com.plaxedo.MumbaiMatinee.data.entity.Member;
import com.plaxedo.MumbaiMatinee.data.enums.Enums;
import com.plaxedo.MumbaiMatinee.data.repository.MemberRepository;
import com.plaxedo.MumbaiMatinee.web.cli.CliController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private AdminService adminService;

    public void loginUser(){
        System.out.println("");
        System.out.println("Select Option\n1. Login\n2. SignUp\n: ");
        String choice = CliController.scanner.next();
        if(choice.equals("1")){
            verifyUser();
        } else if(choice.equals("2")){
            signUpUser();
        }else {
            System.out.println("Incorrect Choice");
        }
    }

    public void verifyUser(){
        System.out.println("Enter Username");
        String userName = CliController.scanner.next();
        Member member = memberRepository.findByUserName(userName);
        if(member == null){
            System.out.println("User Not found");
            return;
        }
        System.out.println("Enter Password");
        String pass = CliController.scanner.next();
        if(!pass.equals(member.getPassword())){
            System.out.println("Incorrect Password");
            return;
        }
        System.out.println("Login Successful");

        if(member.getAccount_type()== Enums.ACCOUNT_TYPE.ADMIN){
            //AdminService adminService = new AdminService();
            adminService.run();
            return;
        } else if (member.getAccount_status() == Enums.ACCOUNT_STATUS.ACTIVE) {
           // CustomerService customerService = new CustomerService();
            customerService.run();
            return;
        }
        System.out.println("Cannot Login Customer: Account " + member.getAccount_status());

    }

    public void signUpUser(){
        Member member = new Member();
        System.out.println("Enter First Name: ");
        String firstName = CliController.scanner.next();
        member.setFirstName(firstName);

        System.out.println("Enter Last Name: ");
        String lastName = CliController.scanner.next();
        member.setLastName(lastName);

        System.out.println("Enter User Name: ");
        String userName = CliController.scanner.next();
        member.setUserName(userName);

        System.out.println("Enter Password: ");
        String pass = CliController.scanner.next();
        member.setPassword(pass);

        System.out.println("Are you an admin? [y/n]");
        String admin = CliController.scanner.next();
        if(admin.equals("y")){
            member.setAccount_type(Enums.ACCOUNT_TYPE.ADMIN);
        }

        memberRepository.save(member);
        System.out.println("SignUp Success");
    }
}

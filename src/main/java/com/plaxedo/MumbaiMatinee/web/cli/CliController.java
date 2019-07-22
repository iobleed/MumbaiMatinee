package com.plaxedo.MumbaiMatinee.web.cli;

import com.plaxedo.MumbaiMatinee.business.service.LoginService;
import com.plaxedo.MumbaiMatinee.business.service.MovieService;
import com.plaxedo.MumbaiMatinee.data.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CliController {

    public static Scanner scanner;

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private MovieService movieService;
    @Autowired
    private LoginService loginService;

    public void run() throws Exception{

        scanner = new Scanner(System.in);
        System.out.println("Welcome to Movie Booking System");

        System.out.println("Enter Q to exit");

        String choice = "";
        do {
            System.out.println("Select the mode you want to enter:\n" +
                    "1. Login\n" +
                    "2. Guest\n: ");
            choice = scanner.next();
            if(choice.equals("1")){
                loginService.loginUser();
            } else if (choice.equals("2")){
                movieService.listMovies();
            }

        }while (!choice.equals("q"));
        System.out.println("Exit");
    }
}

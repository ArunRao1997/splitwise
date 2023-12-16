package com.scaler.splitwise;

import com.scaler.splitwise.commands.CommandExecutor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Scanner;

@EnableJpaAuditing
@SpringBootApplication
public class SplitwiseApplication implements CommandLineRunner {
    private CommandExecutor commandExecutor;
    private final Scanner scanner = new Scanner(System.in);

    public SplitwiseApplication(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

    public static void main(String[] args) {
        SpringApplication.run(SplitwiseApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        while (true) {
            String input = scanner.next();
            commandExecutor.execute(input);
        }
    }
}

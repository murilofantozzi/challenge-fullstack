package com.example.marsrobo.service;

import com.example.marsrobo.model.Robo;
import org.springframework.stereotype.Service;

@Service
public class RoboService {
    private static final int MAX_X = 5;
    private static final int MAX_Y = 5;

    public String processCommands(String commands) {
        Robo robo = new Robo();
        for (char command : commands.toCharArray()) {
            if (command == 'L' || command == 'R') {
                turn(robo, command);
            } else if (command == 'M') {
                move(robo);
            } else {
                throw new IllegalArgumentException("Invalid command");
            }
        }
        return String.format("(%d, %d, %c)", robo.getX(), robo.getY(), robo.getDirection());
    }

    private void turn(Robo robo, char turnDirection) {
        switch (robo.getDirection()) {
            case 'N':
                robo.setDirection((turnDirection == 'L') ? 'W' : 'E');
                break;
            case 'E':
                robo.setDirection((turnDirection == 'L') ? 'N' : 'S');
                break;
            case 'S':
                robo.setDirection((turnDirection == 'L') ? 'E' : 'W');
                break;
            case 'W':
                robo.setDirection((turnDirection == 'L') ? 'S' : 'N');
                break;
        }
    }

    private void move(Robo robo) {
        switch (robo.getDirection()) {
            case 'N':
                if (robo.getY() < MAX_Y) robo.setY(robo.getY() + 1);
                else throw new IllegalArgumentException("Out of bounds");
                break;
            case 'E':
                if (robo.getX() < MAX_X) robo.setX(robo.getX() + 1);
                else throw new IllegalArgumentException("Out of bounds");
                break;
            case 'S':
                if (robo.getY() > 0) robo.setY(robo.getY() - 1);
                else throw new IllegalArgumentException("Out of bounds");
                break;
            case 'W':
                if (robo.getX() > 0) robo.setX(robo.getX() - 1);
                else throw new IllegalArgumentException("Out of bounds");
                break;
        }
    }
}

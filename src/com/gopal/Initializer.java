package com.gopal;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Initializer {

    private static int noOfPlayers;
    private static GetLaddersSnackesUsers instance;

    public static void main(String[] args) throws Exception {
        instance = GetLaddersSnackesUsers.getInstance();
        Scanner scanner = new Scanner(System.in);
        prepareLadders(scanner);
        prepareSnakes(scanner);
        prepareUsers(scanner);
        System.out.println("main - instance - " + instance);
        scanner.close();

        startPlay();
    }

    private static void startPlay() {
        Dice dice = new Dice(6);

        List<Ladder> ladders = instance.getLadders();
        List<Snake> snakes = instance.getSnakes();

        int iteration = -1;
        User player = null;
        String message = "";
        do {
            iteration++;
            if (iteration >= noOfPlayers) {
                iteration = 0;
            }
            player = instance.getUsers().get(iteration);
            int diceNumber = dice.generateRandom(), sumNumber = player.getPosition() + diceNumber;
            message = player.getName() + " got " + diceNumber;
            printAndInsertMessage(player, message);
            if (sumNumber > 100) {
                message = player.getName() + " reached out of 100 with " + diceNumber;
            } else {
                Optional<Ladder> ladderOptionalObject = ladders.stream()
                        .filter(ladder -> ladder.getStart() == sumNumber).findAny();
                if (ladderOptionalObject.isPresent()) {
                    ladderClimbing(player, ladderOptionalObject.get());
                } else {
                    Optional<Snake> snakeOptionalObject = snakes.stream()
                            .filter(ladder -> ladder.getStart() == sumNumber).findAny();
                    if (snakeOptionalObject.isPresent()) {
                        snakeDinner(player, snakeOptionalObject.get());
                    } else {
                        player.setPosition(sumNumber);
                        message = player.getName() + " reached " + sumNumber;
                        printAndInsertMessage(player, message);
                    }
                }
            }
            printAndInsertMessage(player, message);
        } while (player.getPosition() < 100);
        System.out.println("player - " + player);
        System.out.println("instance - " + instance);

    }

    private static void snakeDinner(User player, Snake snake) {
        String message = player.getName() + " got snake dinner at " + snake.getStart() + ", reaching to "
                + snake.getDownPosition();
        player.setPosition(snake.getDownPosition());
        printAndInsertMessage(player, message);
    }

    private static void ladderClimbing(User player, Ladder ladder) {
        String message = player.getName() + " got ladder at " + ladder.getStart() + ", reaching to "
                + ladder.getUpPosition();
        player.setPosition(ladder.getUpPosition());
        printAndInsertMessage(player, message);
    }

    private static void printAndInsertMessage(User player, String message) {
        player.getHistory().add(message);
        System.out.println(message);
    }

    private static void prepareUsers(Scanner scanner) {
        System.out.println("Enter number of players");
        noOfPlayers = scanner.nextInt();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < noOfPlayers; i++) {
            System.out.println("Enter player " + i + "'s name");
            String name = sc.nextLine();
            User user = new User(i, name);
            instance.getUsers().add(user);
        }
        sc.close();
    }

    private static void prepareSnakes(Scanner scanner) {
        System.out.println("Enter number of Snakes");
        int noOfSnakes = scanner.nextInt();
        for (int i = 0; i < noOfSnakes; i++) {
            System.out.println("Enter snake" + i + "'s start position");
            int downPosition = scanner.nextInt();

            System.out.println("Enter snake" + i + "'s end position");
            int endPosition = scanner.nextInt();
            try {
                Snake snake = new Snake(downPosition, endPosition, instance);
                instance.getSnakes().add(snake);
            } catch (Exception e) {
                System.out.println("" + e.getMessage());
                System.out.println("Snake not insrted..., Kindly insert again...");
                i--;
            }

        }
    }

    private static void prepareLadders(Scanner scanner) {
        System.out.println("Enter number of Ladders");
        int noOfLadders = scanner.nextInt();
        for (int i = 0; i < noOfLadders; i++) {
            System.out.println("Enter ladder" + i + "'s start position");
            int upPosition = scanner.nextInt();

            System.out.println("Enter ladder" + i + "'s end position");
            int endPosition = scanner.nextInt();
            try {
                Ladder ladder = new Ladder(upPosition, endPosition, instance);
                instance.getLadders().add(ladder);
            } catch (Exception e) {
                System.out.println("" + e.getMessage());
                System.out.println("Ladder not insrted..., Kindly insert again...");
                i--;
            }
        }
    }
}
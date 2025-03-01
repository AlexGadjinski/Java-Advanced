package footballteamgenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Team> teams = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] tokens = input.split(";");
            switch (tokens[0]) {
                case "Team" -> {
                    try {
                        teams.add(new Team(tokens[1]));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case "Add" -> {
                    if (teamExists(teams, tokens[1])) {
                        addPlayerToTeam(teams, tokens);
                    }
                }
                case "Remove" -> {
                    if (teamExists(teams, tokens[1])) {
                        removePlayerFromTeam(teams, tokens);
                    }
                }
                case "Rating" -> {
                    if (teamExists(teams, tokens[1])) {
                        showRating(teams, tokens[1]);
                    }
                }
            }
            input = scanner.nextLine();
        }
    }

    private static void showRating(List<Team> teams, String teamName) {
        Team team = getTeam(teams, teamName);
        System.out.printf("%s - %d\n", team.getName(), Math.round(team.getRating()));
    }

    private static boolean teamExists(List<Team> teams, String teamName) {
        if (teams.isEmpty() || teams.stream().noneMatch(t -> t.getName().equals(teamName))) {
            System.out.printf("Team %s does not exist.\n", teamName);
            return false;
        }
        return true;
    }

    private static void removePlayerFromTeam(List<Team> teams, String[] tokens) {
        Team team = getTeam(teams, tokens[1]);
        try {
            team.removePlayer(tokens[2]);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void addPlayerToTeam(List<Team> teams, String[] tokens) {
        Team team = getTeam(teams, tokens[1]);
        try {
            Player player = createPlayer(tokens);
            team.addPlayer(player);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static Player createPlayer(String[] tokens) {
        String playerName = tokens[2];
        int endurance = Integer.parseInt(tokens[3]);
        int sprint = Integer.parseInt(tokens[4]);
        int dribble = Integer.parseInt(tokens[5]);
        int passing = Integer.parseInt(tokens[6]);
        int shooting = Integer.parseInt(tokens[7]);
        return new Player(playerName, endurance, sprint, dribble, passing, shooting);
    }

    private static Team getTeam(List<Team> teams, String teamName) {
        return teams.stream().filter(t -> t.getName().equals(teamName)).findFirst().orElse(null);
    }
}

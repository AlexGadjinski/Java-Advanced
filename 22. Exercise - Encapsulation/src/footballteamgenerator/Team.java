package footballteamgenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        setName(name);
        this.players = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(String name) {
        if (players.isEmpty() || players.stream().noneMatch(p -> p.getName().equals(name))) {
            String message = "Player %s is not in %s team.".formatted(name, this.name);
            throw new IllegalArgumentException(message);
        }
        Player playerToRemove = players.stream().filter(p -> p.getName().equals(name)).findFirst().get();
        players.remove(playerToRemove);
    }

    public double getRating() {
        if (players.size() == 0) {
            return 0;
        }
        return players.stream().mapToDouble(Player::overallSkillLevel).sum() / players.size();
    }
}

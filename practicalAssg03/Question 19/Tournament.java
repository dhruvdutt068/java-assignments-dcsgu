import java.util.*;

class Team {
    private String teamName;
    private int matchesPlayed;
    private int wins;
    private int losses;
    private int points;

    public Team(String teamName) {
        this.teamName = teamName;
        this.matchesPlayed = 0;
        this.wins = 0;
        this.losses = 0;
        this.points = 0;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getPoints() {
        return points;
    }

    // Call when this team wins a match
    public void teamWin() {
        wins++;
        matchesPlayed++;
        points += 2; // awarding 2 points for a win
    }

    // Call when this team loses a match
    public void teamLoss() {
        losses++;
        matchesPlayed++;
        // no points awarded for loss (commonly 0)
        // if you want negative points, change this line:
        // points -= 2;
    }

    public void display() {
        System.out.println("====================================");
        System.out.println("Team:        " + teamName);
        System.out.println("Matches:     " + matchesPlayed);
        System.out.println("Wins:        " + wins + "    Losses: " + losses + "    Points: " + points);
		System.out.println("====================================");
    }
}

public class Tournament {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Team> teamList = new ArrayList<>();
        int choice;

        do {
            System.out.println("\nEnter your Choice");
            System.out.println("1. Create new Team");
            System.out.println("2. Details of All Teams");
            System.out.println("3. Match Update (enter winner and loser)");
            System.out.println("4. Sort Teams by Points (desc) and display table");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            // read int and consume newline
            while (!scanner.hasNextInt()) {
                System.out.print("Please enter a valid number: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Team Name: ");
                    String name = scanner.nextLine().trim();
                    if (name.isEmpty()) {
                        System.out.println("Team name cannot be empty.");
                        break;
                    }
                    if (findTeam(teamList, name) != null) {
                        System.out.println("Team with this name already exists.");
                        break;
                    }
                    Team t = new Team(name);
                    teamList.add(t);
                    System.out.println("Team created:");
                    t.display();
                    break;

                case 2:
                    if (teamList.isEmpty()) {
                        System.out.println("No teams available.");
                    } else {
                        System.out.println("\nAll Teams:");
                        for (Team team : teamList) {
                            team.display();
                        }
                    }
                    break;

                case 3:
                    if (teamList.size() < 2) {
                        System.out.println("Need at least two teams to update a match.");
                        break;
                    }
                    System.out.print("Enter Winning Team Name: ");
                    String winnerName = scanner.nextLine().trim();
                    System.out.print("Enter Losing Team Name: ");
                    String loserName = scanner.nextLine().trim();

                    Team winner = findTeam(teamList, winnerName);
                    Team loser = findTeam(teamList, loserName);

                    if (winner == null) {
                        System.out.println("Winner team not found: " + winnerName);
                        break;
                    }
                    if (loser == null) {
                        System.out.println("Loser team not found: " + loserName);
                        break;
                    }
                    if (winner == loser) {
                        System.out.println("Winner and loser cannot be the same team.");
                        break;
                    }

                    // update both teams
                    winner.teamWin();
                    loser.teamLoss();
                    System.out.println("Match updated: " + winner.getTeamName() + " beat " + loser.getTeamName());
                    break;

                case 4:
                    if (teamList.isEmpty()) {
                        System.out.println("No teams to sort.");
                        break;
                    }
                    // sort descending by points, then by wins, then by name
                    teamList.sort(Comparator.comparingInt(Team::getPoints).reversed()
                            .thenComparing(Comparator.comparingInt(Team::getWins).reversed())
                            .thenComparing(t2 -> t2.getTeamName().toLowerCase()));

                    System.out.println("\nPoints Table (sorted):");
                    System.out.printf("%-20s %8s %8s %8s %8s%n", "Team", "Matches", "Wins", "Losses", "Points");
                    System.out.println("--------------------------------------------------------------");
                    for (Team team : teamList) {
                        System.out.printf("%-20s %8d %8d %8d %8d%n",
                                team.getTeamName(),
                                team.getMatchesPlayed(),
                                team.getWins(),
                                team.getLosses(),
                                team.getPoints());
                    }
                    break;

                case 0:
                    System.out.println("Thank you. Exiting.");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 0);

        scanner.close();
    }

    // helper to find a team by name (case-insensitive)
    private static Team findTeam(List<Team> list, String name) {
        for (Team t : list) {
            if (t.getTeamName().equalsIgnoreCase(name)) {
                return t;
            }
        }
        return null;
    }
}

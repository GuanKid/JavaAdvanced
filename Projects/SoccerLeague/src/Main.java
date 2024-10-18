import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

public class Main {

    public static void main(String[] args) {
        HashMap<String, Integer> teamPoints = new HashMap<>();
        String filePath = "C:\\Bootcamp\\Java Bootcamp\\Java\\Advanced\\SoccerLeague\\src\\soccer.txt";
        processMatchResults(filePath, teamPoints);
    }

    public static void processMatchResults(String filePath, HashMap<String, Integer> teamPoints) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                boolean teamAKey = false;
                boolean teamBKey = false;
                int teamAValue = 0;
                int teamBValue = 0;

                String[] parts = line.split(",");
                String partBeforeComma = parts[0].trim();
                String partAfterComma = parts[1].trim();

                String teamA = partBeforeComma.split(" ")[0].trim();
                int scoreA = Integer.parseInt(partBeforeComma.split(" ")[1].trim());

                String teamB = partAfterComma.split(" ")[0].trim();
                int scoreB = Integer.parseInt(partAfterComma.split(" ")[1].trim());

                // Determine points for each team
                if (scoreA > scoreB) {
                    teamAValue = 3; // Team A wins
                } else if (scoreA == scoreB) {
                    teamAValue = 1; // Draw
                    teamBValue = 1;
                } else {
                    teamBValue = 3; // Team B wins
                }

                // Update points in the HashMap for Team A
                teamAKey = teamPoints.containsKey(teamA);
                if (teamAKey) {
                    teamPoints.put(teamA, teamPoints.get(teamA) + teamAValue);
                } else {
                    teamPoints.put(teamA, teamAValue);
                }

                // Update points in the HashMap for Team B
                teamBKey = teamPoints.containsKey(teamB);
                if (teamBKey) {
                    teamPoints.put(teamB, teamPoints.get(teamB) + teamBValue);
                } else {
                    teamPoints.put(teamB, teamBValue);
                }

                // Debug information
//                System.out.println(teamA + ": " + teamAValue + " " + teamAKey);
//                System.out.println(teamB + ": " + teamBValue + " " + teamBKey);
//                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print the final scoreboard sorted in descending order
        printSortedScoreboard(teamPoints);
    }

    public static void printSortedScoreboard(HashMap<String, Integer> teamPoints) {
        // Create a list from the entries of the HashMap
        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(teamPoints.entrySet());

        // Sort the list in descending order by value (points)
        sortedEntries.sort((entry1, entry2) -> {
            int valueComparison = entry2.getValue().compareTo(entry1.getValue());
            // If values are equal, sort alphabetically by key
            return valueComparison != 0 ? valueComparison : entry1.getKey().compareTo(entry2.getKey());
        });

        // Print the sorted scoreboard
        int index = 1;
        for (Entry<String, Integer> entry : sortedEntries) {
            String team = entry.getKey();
            Integer points = entry.getValue();
            System.out.println(index + ". " + team + ":");
            System.out.println("                    "+points);
            System.out.println();
            index++;
        }
    }
}

/*
 * Name: Prajwal Khatiwada
 * Homework 8 - File Data Analyzer
 */

import java.io.*;
import java.util.ArrayList;

public class ScoreAnalysisTool {

    public static void main(String[] args) {
        ArrayList<Double> allScores = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("students_scores.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("results.txt"));

            String line;

            // Read every line from the input file
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue; // skip blank lines

                String[] parts = line.split(",");

                // Name is two words in the file (first & last)
                String name = parts[0].trim() + " " + parts[1].trim();
                int age = Integer.parseInt(parts[2].trim());

                double[] scores = extractScores(parts);
                double avg = calculateAverage(scores);

                // collect all scores for overall avg
                for (double s : scores) {
                    allScores.add(s);
                }

                writer.write(name + " (Age " + age + "): ");
                writeScores(writer, scores);
                writer.write(" Average: " + String.format("%.2f", avg));
                writer.newLine();
            }

            double overall = calculateOverallAverage(allScores);

            writer.newLine();
            writer.write("Overall Average Score: " + String.format("%.2f", overall));

            reader.close();
            writer.close();

        } catch (IOException e) {
            System.out.println("File read/write error.");
        }
    }

    // Extract scores from the line
    private static double[] extractScores(String[] parts) {
        double[] scores = new double[parts.length - 3];
        int idx = 0;

        for (int i = 3; i < parts.length; i++) {
            scores[idx] = Double.parseDouble(parts[i].trim());
            idx++;
        }
        return scores;
    }

    // Calculate average of one student
    private static double calculateAverage(double[] scores) {
        double sum = 0;
        for (double s : scores) sum += s;
        return sum / scores.length;
    }

    // Write scores into the file
    private static void writeScores(BufferedWriter writer, double[] scores) throws IOException {
        for (int i = 0; i < scores.length; i++) {
            writer.write((int) scores[i] + "");
            if (i < scores.length - 1) writer.write(", ");
        }
    }

    // Calculate overall average of all scores
    private static double calculateOverallAverage(ArrayList<Double> allScores) {
        double sum = 0;
        for (double s : allScores) sum += s;
        return sum / allScores.size();
    }
}

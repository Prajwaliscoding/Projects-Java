// TextFileAnalyzer.java

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextFileAnalyzer {

    public static void main(String[] args) {
        String inputFileName = "input.txt";
        String outputFileName = "report.txt";
        String keyword = "Java";

        System.out.println("Starting analysis...");

        try {
            List<String> lines = readLines(inputFileName);
            String report = buildReport(lines, keyword);
            writeReport(outputFileName, report);
            System.out.println("Analysis complete. Report written to " + outputFileName);
        } catch (FileNotFoundException e) {
            System.out.println("Error: input file not found.");
        } catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        }
    }

    // Reads all lines from inputFileName into a List<String>
    // Uses java.io classes and try-with-resources
    public static List<String> readLines(String inputFileName) throws IOException {
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }

        return lines;
    }

    // Builds a multi-line report string with:
    // - total lines
    // - total words (split on whitespace)
    // - total characters (sum of line.length())
    // - number of lines containing the keyword (case-sensitive "Java")
    public static String buildReport(List<String> lines, String keyword) {
        int totalLines = lines.size();
        int totalWords = 0;
        int totalCharacters = 0;
        int linesWithKeyword = 0;

        for (String line : lines) {
            if (line == null) {
                continue;
            }

            // Count words (split on whitespace)
            String trimmed = line.trim();
            if (!trimmed.isEmpty()) {
                String[] words = trimmed.split("\\s+");
                totalWords += words.length;
            }

            // Count characters (including spaces in the line)
            totalCharacters += line.length();

            // Case-sensitive keyword match: only counts exact "Java"
            if (line.contains(keyword)) {
                linesWithKeyword++;
            }
        }

        String lineSep = System.lineSeparator();
        StringBuilder sb = new StringBuilder();

        sb.append("Text File Analysis Report").append(lineSep);
        sb.append("-------------------------").append(lineSep);
        sb.append("Total lines: ").append(totalLines).append(lineSep);
        sb.append("Total words: ").append(totalWords).append(lineSep);
        sb.append("Total characters: ").append(totalCharacters).append(lineSep);
        sb.append("Lines containing keyword \"")
          .append(keyword)
          .append("\": ")
          .append(linesWithKeyword)
          .append(lineSep);

        return sb.toString();
    }

    // Writes the full report String to outputFileName
    public static void writeReport(String outputFileName, String report) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            writer.write(report);
        }
    }
}

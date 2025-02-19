package by.it.karmyzov.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    public static void main(String[] args) {

        String stringPath = PathFinder.getStringPath(TaskB.class, "Poem.txt");
        String text = readText(stringPath);
        int words = getCount(text, "[а-яА-ЯёЁ]+");
        text = text.replace("...",".");
        int punctuation = getCount(text, "[!?,.:-]");
        System.out.printf("words=%d, punctuation marks=%d%n", words,punctuation);
        String resultTaskB = PathFinder.getStringPath(TaskB.class,"resultTaskB.txt");
        writeResult(words,punctuation,resultTaskB);

    }
    private static void writeResult (int words, int punctuation, String resultTaskB) {
        try (PrintWriter printWriter = new PrintWriter(resultTaskB)) {
            printWriter.printf("words=%d, punctuation marks=%d%n", words,punctuation);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static String readText(String stringPath)  {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(
                new FileReader(stringPath))) {
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                stringBuilder.append(line).append("\n");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder.toString();
    }

    private static int getCount(String text, String pattern) {
        int count = 0;
        Matcher wordMatcher = Pattern.compile(pattern).matcher(text);
        while ((wordMatcher.find())) {
            count++;
        }
        return count;
    }
}


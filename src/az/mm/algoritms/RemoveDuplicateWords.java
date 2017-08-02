package az.mm.algoritms;

import java.util.Arrays;

public class RemoveDuplicateWords {

    public static void main(String[] args) {
        String[] jobTitles = {"Android Developer Android Developer",
            "Android Developer Android Developer",
            "Android Developer Android Developer",
            "Android Developer Android Developer",
            "Android Developer Android Developer",
            "Android Developer Android Developer",
            "Android Developer Android Developer",
            "Android Developer Android Developer",
            "Android Developer Android Developer",
            "Android Developer Android Developer"
        };

        removeDuplicateWords(jobTitles);
        System.out.println(Arrays.toString(jobTitles));

    }

    public static void removeDuplicateWords(String[] arr) {
        for (String jobTitle : arr) {
            String firstWord = jobTitle.split(" ")[0];
            int middleIndex = jobTitle.indexOf(firstWord, firstWord.length());

            String firstPart = jobTitle.substring(0, middleIndex).trim();
            String secondPart = jobTitle.substring(middleIndex).trim();
            System.out.println(firstPart + " <> " + secondPart + " --> " + firstPart.equals(secondPart));
        }
    }

}

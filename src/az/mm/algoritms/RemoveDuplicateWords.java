package az.mm.algoritms;

public class RemoveDuplicateWords {

    public static void main(String[] args) {
        String[] jobTitles = {
            "DataBase Solution Developer",
            "Java Developer",
            "C#.NET Developer",
            "Senior iOS Developer",
            "Application Developer for Application Development Division",
            "Senior Software Developer Senior Software Developer",
            "Senior Java Developer / Architect Senior Java Developer / Architect",
            "Lead C#.NET Software Engineer (Hyde Park) Lead C#.NET Software Engineer (Hyde Park)",
            "VB.NET Software Developer VB.NET Software Developer",
            "Android Developer Android Developer"
        };
        
        System.out.println("----- Before -----");
        print(jobTitles);
        
        removeDuplicateWords(jobTitles);
        
        System.out.println("\n----- After -----");
        print(jobTitles);
    }

    public static void removeDuplicateWords(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            String firstWord = arr[i].split(" ")[0];
            int middleIndex = arr[i].indexOf(firstWord, firstWord.length());

            if (middleIndex == -1) continue;
            String firstPart = arr[i].substring(0, middleIndex).trim();
            String secondPart = arr[i].substring(middleIndex).trim();
            if (firstPart.equals(secondPart)) 
                arr[i] = firstPart;
        }
    }

    private static void print(String[] arr) {
        for (String text : arr) 
            System.out.println(text);
    }

}


/*
UPDATE all_vacancies SET job_title = TRIM(SUBSTR(job_title, 1, INSTR(job_title, ' '|| SUBSTR(job_title, 1, INSTR(job_title,' ')-1))))
WHERE id IN (
SELECT id
FROM (
SELECT id, TRIM(SUBSTR(job_title, 1, middle)) AS FIRST, TRIM(SUBSTR(job_title, middle)) AS SECOND
FROM (
SELECT id, job_title, INSTR(job_title, ' '|| SUBSTR(job_title, 1, INSTR(job_title,' ')-1)) AS middle
FROM all_vacancies)) v
WHERE v.first=v.second
);
*/

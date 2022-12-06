package day4;

import java.util.stream.Stream;

public class Day4 {

    public static void main(String[] args) {
        System.out.println("PART 1");
        day4_1();

        System.out.println();

        System.out.println("PART 2");
        day4_2();
    }

    public static void day4_1() {
        String input = getInput();
        String[] elfPairs = input.split("\n");

        long totalOverlaps = Stream.of(elfPairs)
                .filter(Day4::overlapExists)
                .count();

        System.out.println(totalOverlaps);
    }

    private static boolean overlapExists(String elfPair) {
        String[] split = elfPair.split(",");
        String[] elf1 = split[0].split("-");
        String[] elf2 = split[1].split("-");

        int e1Start = Integer.parseInt(elf1[0]);
        int e1End = Integer.parseInt(elf1[1]);
        int e2Start = Integer.parseInt(elf2[0]);
        int e2End = Integer.parseInt(elf2[1]);

        return (e1Start <= e2Start && e1End >= e2End) ||
                (e2Start <= e1Start && e2End >= e1End);
    }

    public static void day4_2() {

    }

    private static String getInputExample() {
        return "2-4,6-8\n" +
                "2-3,4-5\n" +
                "5-7,7-9\n" +
                "2-8,3-7\n" +
                "6-6,4-6\n" +
                "2-6,4-8";
    }

    private static String getInput() {
        return "13-53,17-82\n" +
                "32-32,32-42\n" +
                "85-85,8-86\n" +
                "78-80,79-91\n" +
                "60-71,59-70\n" +
                "91-92,4-90\n" +
                "90-90,1-90\n" +
                "35-49,38-50\n" +
                "31-51,31-52\n" +
                "78-80,81-81\n" +
                "85-86,86-94\n" +
                "52-95,96-97\n" +
                "1-39,1-40\n" +
                "8-68,7-24\n" +
                "83-89,58-78\n" +
                "96-98,98-99\n" +
                "26-27,26-74\n" +
                "9-43,8-44\n" +
                "3-8,9-89\n" +
                "3-77,7-26\n" +
                "1-88,2-2\n" +
                "30-53,31-52\n" +
                "3-47,46-86\n" +
                "8-78,7-9\n" +
                "53-92,6-52\n" +
                "84-97,49-97\n" +
                "38-67,38-68\n" +
                "13-13,12-95\n" +
                "7-13,52-87\n" +
                "18-18,17-79\n" +
                "65-65,64-64\n" +
                "12-92,11-91\n" +
                "67-67,2-68\n" +
                "14-89,13-92\n" +
                "13-44,12-14\n" +
                "20-42,21-24\n" +
                "9-47,7-11\n" +
                "99-99,32-97\n" +
                "22-37,21-36\n" +
                "24-98,24-99\n" +
                "62-76,62-77\n" +
                "49-50,49-98\n" +
                "92-98,26-79\n" +
                "5-10,9-95\n" +
                "24-92,24-91\n" +
                "13-13,14-30\n" +
                "56-97,5-97\n" +
                "8-33,9-34\n" +
                "18-76,18-75\n" +
                "16-80,12-17\n" +
                "8-99,8-95\n" +
                "4-97,3-96\n" +
                "11-12,11-86\n" +
                "5-90,1-89\n" +
                "32-71,31-84\n" +
                "12-96,14-91\n" +
                "9-9,12-71\n" +
                "13-93,8-92\n" +
                "4-77,78-93\n" +
                "4-6,5-89\n" +
                "18-52,17-51\n" +
                "35-65,11-64\n" +
                "76-77,1-76\n" +
                "24-24,26-43\n" +
                "4-8,7-48\n" +
                "85-85,5-86\n" +
                "1-86,4-85\n" +
                "10-44,10-45\n" +
                "19-91,36-79\n" +
                "63-95,75-98\n" +
                "59-86,59-87\n" +
                "87-91,42-90\n" +
                "49-98,48-96\n" +
                "2-28,2-27\n" +
                "4-91,4-90\n" +
                "93-98,28-91\n" +
                "5-91,90-90\n" +
                "67-77,82-85\n" +
                "98-98,66-94\n" +
                "19-36,33-46\n" +
                "6-54,6-53\n" +
                "52-82,87-90\n" +
                "94-99,1-94\n" +
                "2-2,1-96\n" +
                "43-46,42-45\n" +
                "20-23,25-30\n" +
                "7-93,6-92\n" +
                "18-56,17-19\n" +
                "40-95,39-96\n" +
                "35-90,91-99\n" +
                "15-17,15-19\n" +
                "29-31,37-99\n" +
                "2-91,6-92\n" +
                "11-28,7-7\n" +
                "10-50,9-11\n" +
                "27-89,10-26\n" +
                "33-60,33-61\n" +
                "66-68,55-67\n" +
                "11-11,10-90\n" +
                "10-20,9-11\n" +
                "73-96,20-98\n" +
                "6-85,6-86\n" +
                "7-82,6-8\n" +
                "37-54,10-57\n" +
                "36-87,35-86\n" +
                "46-86,86-93\n" +
                "4-68,7-69\n" +
                "25-26,20-26\n" +
                "99-99,2-89\n" +
                "1-10,3-17\n" +
                "6-92,5-5\n" +
                "29-87,1-30\n" +
                "7-74,12-74\n" +
                "26-36,25-97\n" +
                "29-83,16-84\n" +
                "13-97,13-98\n" +
                "34-72,35-72\n" +
                "55-62,61-61\n" +
                "24-95,59-95\n" +
                "4-38,4-37\n" +
                "62-73,8-77\n" +
                "5-35,2-2\n" +
                "79-79,4-78\n" +
                "18-51,18-50\n" +
                "10-12,9-9\n" +
                "44-83,6-44\n" +
                "71-81,95-98\n" +
                "36-98,26-97\n" +
                "67-74,19-74\n" +
                "81-89,40-80\n" +
                "26-81,53-94\n" +
                "64-64,26-63\n" +
                "34-67,11-75\n" +
                "13-56,14-56\n" +
                "55-55,44-56\n" +
                "3-51,3-97\n" +
                "76-80,75-77\n" +
                "5-66,77-89\n" +
                "49-70,18-49\n" +
                "32-53,14-33\n" +
                "30-30,30-31\n" +
                "3-7,14-47\n" +
                "33-33,1-33\n" +
                "7-9,11-95\n" +
                "92-92,37-92\n" +
                "40-90,4-90\n" +
                "33-79,7-46\n" +
                "50-64,26-49\n" +
                "3-94,37-94\n" +
                "32-68,68-77\n" +
                "5-17,1-6\n" +
                "6-86,3-6\n" +
                "26-46,21-76\n" +
                "14-74,38-75\n" +
                "3-86,20-85\n" +
                "60-70,60-69\n" +
                "10-32,11-33\n" +
                "43-43,11-43\n" +
                "17-96,9-95\n" +
                "36-96,37-95\n" +
                "11-94,87-95\n" +
                "9-94,8-94\n" +
                "60-61,45-60\n" +
                "25-58,24-58\n" +
                "46-81,45-92\n" +
                "37-77,38-80\n" +
                "95-95,2-96\n" +
                "57-71,56-70\n" +
                "28-93,59-94\n" +
                "16-88,15-90\n" +
                "12-38,12-22\n" +
                "13-88,87-99\n" +
                "7-38,7-37\n" +
                "3-70,4-69\n" +
                "44-77,45-76\n" +
                "4-69,2-98\n" +
                "45-79,44-78\n" +
                "39-91,2-33\n" +
                "33-78,33-77\n" +
                "91-91,16-90\n" +
                "63-94,95-97\n" +
                "1-97,1-97\n" +
                "19-38,3-19\n" +
                "95-95,91-96\n" +
                "53-77,15-78\n" +
                "8-53,7-53\n" +
                "20-41,28-42\n" +
                "5-7,7-90\n" +
                "55-86,85-87\n" +
                "2-92,9-80\n" +
                "17-79,79-89\n" +
                "43-77,44-78\n" +
                "61-66,60-60\n" +
                "8-76,5-8\n" +
                "40-83,39-83\n" +
                "69-79,79-80\n" +
                "51-51,50-92\n" +
                "29-99,18-99\n" +
                "18-75,17-18\n" +
                "17-39,8-59\n" +
                "9-35,34-79\n" +
                "8-52,7-53\n" +
                "51-95,75-94\n" +
                "94-94,1-94\n" +
                "37-55,32-56\n" +
                "6-84,1-6\n" +
                "19-19,18-40\n" +
                "95-97,28-95\n" +
                "89-99,82-92\n" +
                "11-47,46-47\n" +
                "4-98,4-99\n" +
                "12-16,23-94\n" +
                "18-50,17-49\n" +
                "37-72,35-57\n" +
                "23-77,22-24\n" +
                "54-65,6-54\n" +
                "61-74,39-73\n" +
                "83-94,52-90\n" +
                "13-99,2-14\n" +
                "10-98,11-99\n" +
                "30-98,29-99\n" +
                "38-90,37-90\n" +
                "63-66,64-68\n" +
                "49-93,49-95\n" +
                "84-88,79-88\n" +
                "11-35,35-83\n" +
                "2-59,3-59\n" +
                "42-64,57-64\n" +
                "14-62,15-88\n" +
                "52-54,53-71\n" +
                "37-66,38-67\n" +
                "20-96,21-92\n" +
                "5-82,4-6\n" +
                "13-52,13-52\n" +
                "10-69,4-21\n" +
                "5-69,26-98\n" +
                "41-57,40-42\n" +
                "8-94,9-93\n" +
                "6-27,26-61\n" +
                "27-65,27-66\n" +
                "97-98,1-97\n" +
                "46-85,45-86\n" +
                "43-48,38-43\n" +
                "5-49,48-48\n" +
                "14-59,12-58\n" +
                "30-97,7-96\n" +
                "62-70,64-69\n" +
                "31-79,12-78\n" +
                "10-18,9-17\n" +
                "74-76,72-76\n" +
                "29-69,29-70\n" +
                "15-93,93-95\n" +
                "66-68,67-73\n" +
                "2-89,1-2\n" +
                "2-95,9-96\n" +
                "4-89,6-45\n" +
                "98-98,28-99\n" +
                "16-77,4-77\n" +
                "16-86,87-87\n" +
                "17-17,18-83\n" +
                "18-82,29-81\n" +
                "21-99,7-98\n" +
                "36-85,1-85\n" +
                "9-70,70-90\n" +
                "38-95,60-94\n" +
                "94-94,24-95\n" +
                "4-63,3-63\n" +
                "40-72,73-88\n" +
                "3-4,3-99\n" +
                "1-27,3-93\n" +
                "15-26,16-27\n" +
                "10-89,20-34\n" +
                "16-18,6-39\n" +
                "34-48,28-34\n" +
                "5-83,6-6\n" +
                "37-49,38-50\n" +
                "39-86,9-38\n" +
                "12-74,74-75\n" +
                "16-80,15-81\n" +
                "26-67,24-85\n" +
                "5-7,12-19\n" +
                "40-68,69-69\n" +
                "17-79,80-95\n" +
                "17-63,16-18\n" +
                "69-72,16-75\n" +
                "15-24,48-89\n" +
                "12-12,13-96\n" +
                "4-4,6-89\n" +
                "79-84,5-39\n" +
                "23-25,24-61\n" +
                "26-97,6-96\n" +
                "4-97,5-97\n" +
                "55-91,56-91\n" +
                "25-80,80-81\n" +
                "52-76,53-75\n" +
                "45-61,44-61\n" +
                "65-81,64-82\n" +
                "65-74,3-64\n" +
                "4-73,72-72\n" +
                "54-54,53-57\n" +
                "51-51,29-50\n" +
                "1-14,3-36\n" +
                "93-95,57-92\n" +
                "85-86,6-85\n" +
                "3-98,3-15\n" +
                "21-21,20-54\n" +
                "18-72,19-73\n" +
                "27-49,47-53\n" +
                "20-77,21-78\n" +
                "52-76,38-76\n" +
                "82-87,14-87\n" +
                "3-79,1-4\n" +
                "1-97,1-1\n" +
                "39-40,40-91\n" +
                "6-11,5-10\n" +
                "5-98,4-6\n" +
                "36-36,9-37\n" +
                "6-69,7-7\n" +
                "77-93,76-95\n" +
                "41-94,26-93\n" +
                "70-81,7-70\n" +
                "1-72,71-72\n" +
                "30-90,29-98\n" +
                "68-76,12-76\n" +
                "28-42,15-19\n" +
                "76-96,39-77\n" +
                "30-32,46-90\n" +
                "83-98,83-92\n" +
                "1-98,9-98\n" +
                "17-93,16-92\n" +
                "17-89,3-8\n" +
                "61-67,62-67\n" +
                "19-63,18-20\n" +
                "51-53,52-98\n" +
                "20-21,20-58\n" +
                "5-86,6-87\n" +
                "23-85,24-84\n" +
                "34-54,22-53\n" +
                "20-67,20-68\n" +
                "26-88,26-26\n" +
                "26-94,27-94\n" +
                "27-29,29-84\n" +
                "42-73,2-42\n" +
                "68-72,56-71\n" +
                "13-85,16-84\n" +
                "54-87,88-95\n" +
                "26-29,32-35\n" +
                "2-21,20-45\n" +
                "18-18,19-48\n" +
                "91-98,31-88\n" +
                "5-59,41-60\n" +
                "94-96,70-94\n" +
                "8-85,86-89\n" +
                "3-97,98-99\n" +
                "89-90,16-92\n" +
                "13-44,43-74\n" +
                "6-87,25-99\n" +
                "5-5,6-53\n" +
                "3-85,1-84\n" +
                "25-94,35-87\n" +
                "17-95,17-64\n" +
                "12-85,13-85\n" +
                "2-4,4-75\n" +
                "7-25,8-24\n" +
                "47-96,24-96\n" +
                "95-96,94-94\n" +
                "94-94,93-93\n" +
                "22-77,3-90\n" +
                "17-77,78-83\n" +
                "35-42,48-75\n" +
                "12-12,13-97\n" +
                "13-19,18-77\n" +
                "32-83,26-83\n" +
                "31-78,3-32\n" +
                "3-17,17-95\n" +
                "45-61,44-61\n" +
                "73-81,13-80\n" +
                "2-99,6-93\n" +
                "80-88,33-74\n" +
                "45-86,3-44\n" +
                "39-75,39-93\n" +
                "2-96,95-96\n" +
                "10-64,9-65\n" +
                "4-76,5-5\n" +
                "72-96,72-73\n" +
                "78-85,77-79\n" +
                "20-94,19-98\n" +
                "14-87,3-15\n" +
                "21-35,35-53\n" +
                "2-87,88-93\n" +
                "15-90,15-87\n" +
                "3-99,2-99\n" +
                "9-95,9-96\n" +
                "5-89,1-90\n" +
                "6-73,3-74\n" +
                "52-76,6-51\n" +
                "5-52,66-69\n" +
                "17-19,18-36\n" +
                "8-43,2-9\n" +
                "56-72,63-73\n" +
                "73-91,66-92\n" +
                "4-89,5-89\n" +
                "95-99,9-93\n" +
                "91-98,92-99\n" +
                "18-78,6-7\n" +
                "11-71,71-94\n" +
                "1-99,3-97\n" +
                "7-90,1-8\n" +
                "5-87,5-88\n" +
                "46-48,47-97\n" +
                "3-92,7-91\n" +
                "33-33,32-73\n" +
                "39-95,38-98\n" +
                "35-82,36-81\n" +
                "41-90,86-95\n" +
                "21-45,44-44\n" +
                "5-5,6-49\n" +
                "49-67,50-66\n" +
                "8-76,8-77\n" +
                "15-17,29-73\n" +
                "35-95,20-34\n" +
                "29-64,30-64\n" +
                "11-45,11-46\n" +
                "14-87,4-13\n" +
                "38-69,37-37\n" +
                "11-76,6-9\n" +
                "70-98,62-97\n" +
                "17-99,16-18\n" +
                "2-82,5-81\n" +
                "15-93,4-94\n" +
                "56-57,56-57\n" +
                "1-6,6-88\n" +
                "48-93,48-49\n" +
                "7-75,39-74\n" +
                "1-3,2-90\n" +
                "27-31,28-31\n" +
                "10-10,9-63\n" +
                "11-64,65-79\n" +
                "57-57,56-69\n" +
                "50-50,49-88\n" +
                "43-43,2-44\n" +
                "15-59,11-59\n" +
                "28-44,7-28\n" +
                "5-39,37-42\n" +
                "88-95,95-95\n" +
                "2-63,63-63\n" +
                "5-91,14-98\n" +
                "7-89,6-98\n" +
                "16-36,36-56\n" +
                "40-80,81-83\n" +
                "4-99,2-98\n" +
                "70-70,2-71\n" +
                "6-45,7-46\n" +
                "9-97,10-96\n" +
                "34-79,33-34\n" +
                "51-55,50-55\n" +
                "27-72,58-79\n" +
                "9-65,8-64\n" +
                "3-5,4-99\n" +
                "17-43,11-16\n" +
                "9-29,10-28\n" +
                "23-91,24-90\n" +
                "13-80,10-14\n" +
                "47-85,86-86\n" +
                "9-25,4-8\n" +
                "43-92,43-92\n" +
                "89-90,76-89\n" +
                "32-88,4-31\n" +
                "33-52,32-51\n" +
                "3-97,1-99\n" +
                "39-91,40-51\n" +
                "19-92,22-92\n" +
                "4-89,23-92\n" +
                "5-6,6-66\n" +
                "6-99,7-78\n" +
                "8-93,92-93\n" +
                "5-95,58-97\n" +
                "2-96,99-99\n" +
                "34-39,35-35\n" +
                "92-92,3-93\n" +
                "38-54,11-53\n" +
                "45-59,59-87\n" +
                "55-78,54-54\n" +
                "42-66,42-66\n" +
                "19-91,22-92\n" +
                "39-46,38-91\n" +
                "42-89,41-41\n" +
                "33-66,34-65\n" +
                "7-71,6-70\n" +
                "7-80,30-61\n" +
                "58-91,57-90\n" +
                "30-95,88-95\n" +
                "4-97,96-99\n" +
                "12-99,12-95\n" +
                "39-41,40-50\n" +
                "34-87,35-87\n" +
                "14-86,2-12\n" +
                "14-87,15-86\n" +
                "7-97,96-96\n" +
                "7-36,31-46\n" +
                "6-75,7-49\n" +
                "29-29,28-81\n" +
                "58-67,68-68\n" +
                "18-97,18-91\n" +
                "17-31,27-30\n" +
                "39-46,51-96\n" +
                "68-89,69-69\n" +
                "15-57,15-57\n" +
                "24-24,16-77\n" +
                "40-92,91-93\n" +
                "43-61,41-76\n" +
                "49-49,42-48\n" +
                "34-76,15-75\n" +
                "2-73,74-74\n" +
                "16-98,16-97\n" +
                "7-80,6-80\n" +
                "23-66,24-65\n" +
                "39-81,40-82\n" +
                "74-99,33-37\n" +
                "81-93,64-93\n" +
                "19-86,86-95\n" +
                "97-97,9-98\n" +
                "45-70,62-71\n" +
                "54-67,20-53\n" +
                "85-85,18-85\n" +
                "11-79,28-76\n" +
                "40-96,12-40\n" +
                "19-79,35-80\n" +
                "3-91,1-92\n" +
                "5-90,5-89\n" +
                "42-93,43-92\n" +
                "40-70,34-38\n" +
                "12-43,11-12\n" +
                "22-22,3-21\n" +
                "53-90,7-65\n" +
                "22-90,11-15\n" +
                "24-24,24-36\n" +
                "3-3,5-55\n" +
                "53-54,53-53\n" +
                "53-53,26-54\n" +
                "3-9,9-97\n" +
                "43-58,58-59\n" +
                "31-64,17-64\n" +
                "34-36,35-35\n" +
                "4-11,10-48\n" +
                "12-39,15-40\n" +
                "44-44,43-92\n" +
                "9-68,68-68\n" +
                "20-95,20-81\n" +
                "6-27,45-62\n" +
                "7-91,7-91\n" +
                "2-3,5-88\n" +
                "11-77,22-61\n" +
                "8-95,30-77\n" +
                "85-97,86-97\n" +
                "3-60,8-18\n" +
                "14-70,13-69\n" +
                "34-81,61-82\n" +
                "42-82,43-82\n" +
                "9-99,10-10\n" +
                "2-75,19-53\n" +
                "26-77,69-86\n" +
                "82-97,27-81\n" +
                "17-92,9-93\n" +
                "5-6,5-5\n" +
                "46-46,45-47\n" +
                "21-67,21-68\n" +
                "36-95,17-36\n" +
                "41-88,41-89\n" +
                "6-81,11-80\n" +
                "26-45,45-46\n" +
                "4-75,2-4\n" +
                "27-36,24-35\n" +
                "49-64,50-97\n" +
                "86-86,40-85\n" +
                "5-5,5-92\n" +
                "81-82,6-82\n" +
                "14-92,93-93\n" +
                "28-36,35-65\n" +
                "12-17,18-27\n" +
                "28-68,6-68\n" +
                "47-93,48-48\n" +
                "20-99,11-97\n" +
                "32-75,9-18\n" +
                "53-96,96-96\n" +
                "33-64,32-63\n" +
                "79-83,3-78\n" +
                "38-46,47-79\n" +
                "3-88,4-98\n" +
                "6-97,96-96\n" +
                "68-68,42-69\n" +
                "24-99,23-23\n" +
                "27-98,65-99\n" +
                "9-94,5-5\n" +
                "22-30,23-23\n" +
                "71-72,23-71\n" +
                "2-97,2-96\n" +
                "6-58,7-57\n" +
                "44-88,45-74\n" +
                "2-97,98-99\n" +
                "27-30,9-27\n" +
                "10-89,48-89\n" +
                "19-99,18-88\n" +
                "95-95,15-78\n" +
                "10-30,10-31\n" +
                "10-97,11-79\n" +
                "5-97,1-98\n" +
                "17-99,1-99\n" +
                "27-29,28-95\n" +
                "90-90,33-90\n" +
                "64-65,3-64\n" +
                "34-98,35-97\n" +
                "23-62,22-63\n" +
                "76-85,85-85\n" +
                "56-97,57-98\n" +
                "43-43,43-43\n" +
                "17-83,16-18\n" +
                "4-15,6-15\n" +
                "18-70,66-70\n" +
                "62-63,9-62\n" +
                "81-85,32-80\n" +
                "35-95,24-90\n" +
                "6-62,7-62\n" +
                "17-19,18-29\n" +
                "24-38,37-37\n" +
                "2-42,2-43\n" +
                "11-50,10-12\n" +
                "20-50,19-51\n" +
                "22-22,2-22\n" +
                "54-54,8-53\n" +
                "27-47,46-46\n" +
                "11-97,5-6\n" +
                "47-99,1-99\n" +
                "31-46,32-45\n" +
                "8-56,2-39\n" +
                "57-95,10-96\n" +
                "17-17,25-75\n" +
                "44-46,10-45\n" +
                "30-33,29-32\n" +
                "1-94,24-95\n" +
                "31-32,8-32\n" +
                "19-21,20-49\n" +
                "34-34,19-35\n" +
                "33-79,86-96\n" +
                "12-98,12-97\n" +
                "27-35,26-36\n" +
                "37-89,90-90\n" +
                "2-5,4-81\n" +
                "29-38,38-39\n" +
                "3-88,58-82\n" +
                "5-8,7-65\n" +
                "6-14,13-73\n" +
                "57-98,90-99\n" +
                "29-53,30-54\n" +
                "1-78,59-60\n" +
                "34-34,24-35\n" +
                "4-12,11-11\n" +
                "41-84,9-83\n" +
                "5-88,6-6\n" +
                "1-78,8-75\n" +
                "80-80,19-81\n" +
                "95-97,72-96\n" +
                "13-85,84-84\n" +
                "31-81,28-32\n" +
                "53-58,37-45\n" +
                "13-69,62-82\n" +
                "11-69,10-69\n" +
                "46-46,45-74\n" +
                "60-93,77-98\n" +
                "14-58,14-59\n" +
                "73-73,11-72\n" +
                "3-91,32-91\n" +
                "4-6,5-87\n" +
                "11-85,16-78\n" +
                "2-99,89-97\n" +
                "21-88,20-87\n" +
                "4-52,51-51\n" +
                "22-22,1-21\n" +
                "21-76,8-94\n" +
                "4-6,5-40\n" +
                "97-97,5-93\n" +
                "22-85,11-23\n" +
                "6-74,5-5\n" +
                "67-91,66-92\n" +
                "24-99,16-98\n" +
                "2-58,1-1\n" +
                "21-52,20-52\n" +
                "71-82,76-96\n" +
                "5-65,5-64\n" +
                "4-6,9-70\n" +
                "73-75,68-88\n" +
                "39-52,38-40\n" +
                "29-32,29-31\n" +
                "65-65,37-66\n" +
                "3-69,2-68\n" +
                "36-97,36-85\n" +
                "52-68,15-69\n" +
                "3-42,42-43\n" +
                "19-25,25-58\n" +
                "9-28,8-27\n" +
                "23-99,24-99\n" +
                "21-98,22-95\n" +
                "6-12,12-13\n" +
                "42-93,41-99\n" +
                "57-83,58-84\n" +
                "91-91,90-94\n" +
                "71-72,71-88\n" +
                "2-97,1-3\n" +
                "9-12,11-49\n" +
                "75-81,38-82\n" +
                "38-75,16-52\n" +
                "16-18,17-91\n" +
                "29-72,30-71\n" +
                "83-83,45-82\n" +
                "17-56,19-57\n" +
                "50-52,51-78\n" +
                "17-67,66-66\n" +
                "3-81,3-80\n" +
                "20-48,49-65\n" +
                "17-51,10-18\n" +
                "1-9,2-10\n" +
                "49-49,46-48\n" +
                "95-96,55-96\n" +
                "27-89,28-74\n" +
                "47-76,28-82\n" +
                "9-95,10-96\n" +
                "87-88,5-88\n" +
                "27-74,28-47\n" +
                "74-93,46-92\n" +
                "3-95,98-98\n" +
                "49-50,26-50\n" +
                "28-79,27-79\n" +
                "15-53,14-93\n" +
                "17-36,17-18\n" +
                "7-72,64-75\n" +
                "7-96,32-99\n" +
                "87-99,21-77\n" +
                "12-98,13-97\n" +
                "14-79,2-79\n" +
                "2-2,2-3\n" +
                "38-73,73-74\n" +
                "11-82,4-7\n" +
                "67-67,68-71\n" +
                "86-87,13-84\n" +
                "52-80,51-52\n" +
                "71-97,71-96\n" +
                "4-5,5-87\n" +
                "14-31,31-73\n" +
                "28-28,27-55\n" +
                "3-3,2-28\n" +
                "37-67,65-73\n" +
                "79-80,73-79\n" +
                "16-95,17-94\n" +
                "7-77,8-76\n" +
                "16-82,18-82\n" +
                "34-34,33-93\n" +
                "13-84,88-88\n" +
                "37-98,9-97\n" +
                "16-40,7-59\n" +
                "3-96,1-3\n" +
                "3-95,30-99\n" +
                "1-84,2-85\n" +
                "2-3,4-56\n" +
                "5-54,6-55\n" +
                "69-93,36-93\n" +
                "31-89,44-88\n" +
                "5-88,23-87\n" +
                "5-87,4-88\n" +
                "85-90,42-84\n" +
                "44-72,33-37\n" +
                "7-11,21-99\n" +
                "32-91,31-91\n" +
                "99-99,61-99\n" +
                "5-79,10-44\n" +
                "59-94,58-84\n" +
                "4-6,5-99\n" +
                "24-29,28-82\n" +
                "23-41,23-40\n" +
                "6-95,95-96\n" +
                "18-99,17-53\n" +
                "87-95,32-85\n" +
                "28-66,28-67\n" +
                "4-94,99-99\n" +
                "22-97,22-98\n" +
                "30-96,14-31\n" +
                "30-70,31-69\n" +
                "56-74,3-89\n" +
                "4-85,86-86\n" +
                "57-97,58-97\n" +
                "41-95,41-96\n" +
                "78-79,37-78\n" +
                "25-70,70-75\n" +
                "92-92,4-93\n" +
                "46-65,66-73\n" +
                "18-20,19-23\n" +
                "32-90,32-89\n" +
                "38-73,38-95\n" +
                "30-69,31-68\n" +
                "49-68,1-78\n" +
                "18-98,10-97\n" +
                "25-65,14-22\n" +
                "14-46,12-45\n" +
                "19-48,20-32\n" +
                "52-83,29-52\n" +
                "57-95,57-94\n" +
                "4-97,4-96\n" +
                "35-91,90-92\n" +
                "5-99,4-99\n" +
                "4-26,4-27\n" +
                "54-73,6-54\n" +
                "6-98,7-99\n" +
                "63-81,7-80\n" +
                "58-85,59-59\n" +
                "1-2,1-88\n" +
                "71-85,51-93\n" +
                "5-65,6-6\n" +
                "3-49,33-93\n" +
                "44-84,5-84\n" +
                "49-62,48-61\n" +
                "35-98,36-99\n" +
                "2-3,10-64\n" +
                "95-95,43-95\n" +
                "2-55,3-56\n" +
                "20-53,20-52\n" +
                "15-97,11-13\n" +
                "81-81,3-81\n" +
                "40-45,1-44\n" +
                "1-3,5-73\n" +
                "4-97,97-98\n" +
                "91-92,12-91\n" +
                "31-64,30-63\n" +
                "18-55,17-54\n" +
                "35-40,34-35\n" +
                "3-6,5-95\n" +
                "26-70,79-94\n" +
                "4-97,8-97\n" +
                "6-63,28-63\n" +
                "28-95,11-21\n" +
                "5-81,1-6\n" +
                "38-41,39-40\n" +
                "49-96,48-88\n" +
                "59-77,58-77\n" +
                "29-40,28-40\n" +
                "45-75,46-46\n" +
                "3-87,4-67\n" +
                "58-99,4-92\n" +
                "47-57,46-47\n" +
                "24-84,15-80\n" +
                "85-92,38-85\n" +
                "55-89,88-90\n" +
                "32-68,67-67\n" +
                "7-89,8-89\n" +
                "14-92,13-92\n" +
                "29-41,30-41\n" +
                "5-92,4-92\n" +
                "9-29,19-41\n" +
                "65-89,90-99\n" +
                "91-91,60-91\n" +
                "5-70,21-68\n" +
                "11-95,35-92\n" +
                "25-65,14-26\n" +
                "52-93,88-94\n" +
                "52-89,51-90\n" +
                "74-87,86-86\n" +
                "32-96,99-99\n" +
                "5-97,4-6\n" +
                "19-91,20-91\n" +
                "65-76,64-77\n" +
                "36-90,37-90\n" +
                "37-82,25-92\n" +
                "76-78,77-84\n" +
                "5-66,5-66\n" +
                "4-9,12-50\n" +
                "2-52,10-52\n" +
                "15-99,14-98\n" +
                "18-96,6-18\n" +
                "3-81,4-33\n" +
                "21-66,15-71\n" +
                "49-49,27-67\n" +
                "4-4,5-94\n" +
                "50-50,9-51\n" +
                "31-95,30-94\n" +
                "82-91,87-93\n" +
                "61-96,17-95\n" +
                "2-95,17-95\n" +
                "34-37,7-35\n" +
                "2-94,7-85\n" +
                "96-96,49-95\n" +
                "41-41,42-59\n" +
                "2-97,3-97\n" +
                "22-97,22-98\n" +
                "33-95,34-82\n" +
                "33-47,47-72\n" +
                "32-93,33-93\n" +
                "36-58,35-35\n" +
                "10-58,52-58\n" +
                "77-89,60-67\n" +
                "3-13,12-81\n" +
                "14-98,40-98\n" +
                "11-94,7-12\n" +
                "51-63,43-63\n" +
                "22-82,2-81\n" +
                "31-34,35-60\n" +
                "8-79,8-42\n" +
                "67-67,66-88\n" +
                "64-81,4-64\n" +
                "16-96,15-97\n" +
                "22-65,23-65\n" +
                "59-97,60-96\n" +
                "18-89,90-99\n" +
                "2-2,3-97\n" +
                "12-63,11-63\n" +
                "12-42,41-59\n" +
                "36-37,31-36\n" +
                "45-91,2-59\n" +
                "7-89,6-8\n" +
                "21-49,21-50\n" +
                "13-13,12-87\n" +
                "48-89,47-90\n" +
                "3-22,2-55\n" +
                "19-19,20-41\n" +
                "48-67,47-94\n" +
                "11-13,12-83\n" +
                "16-62,16-61\n" +
                "11-35,12-41\n" +
                "71-78,5-71\n" +
                "66-67,67-87\n" +
                "22-71,14-71\n" +
                "19-72,15-72\n" +
                "20-42,21-41\n" +
                "8-94,7-93\n" +
                "97-98,19-96\n" +
                "3-98,2-98\n" +
                "33-71,72-73\n" +
                "33-35,34-81\n" +
                "18-98,18-97\n" +
                "85-85,24-86\n" +
                "7-97,26-96\n" +
                "47-47,46-49\n" +
                "5-14,3-3\n" +
                "1-83,14-83\n" +
                "10-91,3-75\n" +
                "62-62,32-63\n" +
                "16-84,83-84\n" +
                "52-53,52-70\n" +
                "2-47,2-47\n" +
                "8-93,8-24\n" +
                "56-97,97-97\n" +
                "8-84,27-84\n" +
                "71-89,89-89\n" +
                "96-98,30-96\n" +
                "11-92,49-92\n" +
                "66-66,19-67\n" +
                "55-57,54-56\n" +
                "3-69,3-70\n" +
                "5-99,4-6\n" +
                "1-40,1-39\n" +
                "1-87,88-89\n" +
                "11-98,20-96\n" +
                "22-92,21-94\n" +
                "5-88,5-86\n" +
                "79-98,79-97\n" +
                "34-88,82-88\n" +
                "67-80,66-79\n" +
                "16-87,9-17\n" +
                "78-91,92-92\n" +
                "46-57,35-57\n" +
                "45-64,44-44\n" +
                "77-82,12-81\n" +
                "3-98,1-3\n" +
                "42-62,62-89\n" +
                "2-70,95-95\n" +
                "62-63,61-63\n" +
                "39-97,38-98\n" +
                "3-99,6-98\n" +
                "26-84,83-83\n" +
                "18-27,17-28\n" +
                "52-58,7-52\n" +
                "25-82,1-82\n" +
                "29-66,67-67\n" +
                "43-72,21-71\n" +
                "23-29,5-28\n" +
                "43-90,43-44\n" +
                "42-68,42-67\n" +
                "67-69,66-70\n" +
                "19-40,18-57\n" +
                "1-1,8-9\n" +
                "56-89,97-99\n" +
                "87-98,25-86\n" +
                "88-98,10-88\n" +
                "2-93,2-96\n" +
                "3-82,82-89\n" +
                "7-14,8-14\n" +
                "3-37,36-56\n" +
                "51-52,4-51\n" +
                "38-88,37-96\n" +
                "74-81,22-81\n" +
                "69-83,68-70\n" +
                "2-91,38-91\n" +
                "2-90,91-96";
    }
}
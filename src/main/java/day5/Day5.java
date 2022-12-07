package day5;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Day5 {

    public static void main(String[] args) {
        System.out.println("PART 1");
        day5_1();

        System.out.println();

        System.out.println("PART 2");
        day5_2();
    }

    private static void day5_1() {
        String input = getInput();
        String[] split = input.split("\n\n");
        List<Stack<Character>> stacks = parseStacks(split[0].split("\n"));
        Instruction[] instructions = parseInstructions(split[1].split("\n"));

        for (Instruction instr : instructions) {
            for (int i = 0; i < instr.moveCount; i++) {
                Character crate = stacks.get(instr.from - 1).pop();
                stacks.get(instr.to - 1).push(crate);
            }
        }

        StringBuilder topCrates = new StringBuilder();
        for (Stack<Character> s : stacks) {
            Character peek = s.peek();
            topCrates.append(peek);
        }
        System.out.println(topCrates);
    }

    private static void day5_2() {
        String input = getInput();
        String[] split = input.split("\n\n");
        List<Stack<Character>> stacks = parseStacks(split[0].split("\n"));
        Instruction[] instructions = parseInstructions(split[1].split("\n"));

        for (Instruction instr : instructions) {
            Stack<Character> toMove = new Stack<>();
            for (int i = 0; i < instr.moveCount; i++) {
                Character crate = stacks.get(instr.from - 1).pop();
                toMove.push(crate);
            }

            while (!toMove.isEmpty()) {
                Character crate = toMove.pop();
                stacks.get(instr.to - 1).push(crate);
            }
        }

        StringBuilder topCrates = new StringBuilder();
        for (Stack<Character> s : stacks) {
            Character peek = s.peek();
            topCrates.append(peek);
        }
        System.out.println(topCrates);
    }

    private static Instruction[] parseInstructions(String[] instructionStr) {
        Instruction[] instructions = new Instruction[instructionStr.length];
        for (int i = 0; i < instructions.length; i++) {
            String[] instruction = instructionStr[i].split(" ");
            int moveCount = Integer.parseInt(instruction[1]);
            int from = Integer.parseInt(instruction[3]);
            int to = Integer.parseInt(instruction[5]);
            instructions[i] = (new Instruction(from, to, moveCount));
        }
        return instructions;
    }

    private static List<Stack<Character>> parseStacks(String[] stackStr) {
        String stackNumbers = stackStr[stackStr.length - 1];
        int numOfStacks = stackNumbers.charAt(stackNumbers.length() - 2) - '0';
        List<Stack<Character>> stacks = new ArrayList<>();
        for (int i = 0; i < numOfStacks; i++) {
            stacks.add(new Stack<>());
        }

        for (int i = stackStr.length - 2; i >= 0; i--) {
            String crateString = stackStr[i];
            List<Integer> crateIndexes = new ArrayList<>();

            int index = crateString.indexOf('[');
            while (index > -1) {
                crateIndexes.add(index + 1);
                index = crateString.indexOf('[', index + 1);
            }

            for (int crateIndex : crateIndexes) {
                int stackIndex = crateIndex / 4;
                stacks.get(stackIndex).push(crateString.charAt(crateIndex));
            }
        }

        return stacks;
    }

    private static class Instruction {
        public Instruction(int from, int to, int moveCount) {
            this.from = from;
            this.to = to;
            this.moveCount = moveCount;
        }

        int from;
        int to;
        int moveCount;
    }

    private static String getInputExample() {
        return  "    [D]    \n" +
                "[N] [C]    \n" +
                "[Z] [M] [P]\n" +
                " 1   2   3 \n" +
                "\n" +
                "move 1 from 2 to 1\n" +
                "move 3 from 1 to 3\n" +
                "move 2 from 2 to 1\n" +
                "move 1 from 1 to 2";
    }

    private static String getInput() {
        return  "[N]         [C]     [Z]            \n" +
                "[Q] [G]     [V]     [S]         [V]\n" +
                "[L] [C]     [M]     [T]     [W] [L]\n" +
                "[S] [H]     [L]     [C] [D] [H] [S]\n" +
                "[C] [V] [F] [D]     [D] [B] [Q] [F]\n" +
                "[Z] [T] [Z] [T] [C] [J] [G] [S] [Q]\n" +
                "[P] [P] [C] [W] [W] [F] [W] [J] [C]\n" +
                "[T] [L] [D] [G] [P] [P] [V] [N] [R]\n" +
                " 1   2   3   4   5   6   7   8   9 \n" +
                "\n" +
                "move 6 from 2 to 1\n" +
                "move 4 from 6 to 3\n" +
                "move 1 from 6 to 5\n" +
                "move 8 from 3 to 8\n" +
                "move 13 from 8 to 2\n" +
                "move 2 from 7 to 6\n" +
                "move 10 from 1 to 6\n" +
                "move 3 from 2 to 8\n" +
                "move 5 from 4 to 2\n" +
                "move 15 from 6 to 5\n" +
                "move 1 from 1 to 4\n" +
                "move 2 from 7 to 3\n" +
                "move 2 from 4 to 2\n" +
                "move 12 from 5 to 1\n" +
                "move 4 from 8 to 9\n" +
                "move 15 from 1 to 3\n" +
                "move 10 from 9 to 7\n" +
                "move 1 from 5 to 1\n" +
                "move 1 from 4 to 8\n" +
                "move 3 from 7 to 6\n" +
                "move 8 from 2 to 6\n" +
                "move 1 from 9 to 8\n" +
                "move 5 from 2 to 3\n" +
                "move 1 from 4 to 1\n" +
                "move 16 from 3 to 1\n" +
                "move 2 from 2 to 7\n" +
                "move 13 from 1 to 6\n" +
                "move 1 from 2 to 4\n" +
                "move 2 from 2 to 9\n" +
                "move 1 from 4 to 7\n" +
                "move 2 from 8 to 2\n" +
                "move 2 from 2 to 9\n" +
                "move 1 from 6 to 8\n" +
                "move 2 from 3 to 8\n" +
                "move 2 from 1 to 9\n" +
                "move 1 from 3 to 9\n" +
                "move 1 from 3 to 2\n" +
                "move 5 from 5 to 1\n" +
                "move 2 from 9 to 3\n" +
                "move 1 from 2 to 3\n" +
                "move 2 from 1 to 3\n" +
                "move 3 from 3 to 2\n" +
                "move 1 from 5 to 7\n" +
                "move 2 from 7 to 6\n" +
                "move 2 from 8 to 3\n" +
                "move 1 from 8 to 9\n" +
                "move 6 from 3 to 4\n" +
                "move 3 from 9 to 6\n" +
                "move 8 from 6 to 4\n" +
                "move 1 from 2 to 3\n" +
                "move 1 from 2 to 6\n" +
                "move 1 from 2 to 9\n" +
                "move 1 from 3 to 9\n" +
                "move 5 from 9 to 5\n" +
                "move 7 from 7 to 4\n" +
                "move 14 from 4 to 6\n" +
                "move 1 from 5 to 3\n" +
                "move 5 from 1 to 9\n" +
                "move 4 from 5 to 4\n" +
                "move 1 from 1 to 7\n" +
                "move 1 from 3 to 8\n" +
                "move 1 from 8 to 4\n" +
                "move 4 from 9 to 7\n" +
                "move 6 from 6 to 5\n" +
                "move 10 from 4 to 6\n" +
                "move 1 from 9 to 6\n" +
                "move 1 from 4 to 3\n" +
                "move 1 from 3 to 6\n" +
                "move 1 from 4 to 2\n" +
                "move 35 from 6 to 3\n" +
                "move 1 from 2 to 3\n" +
                "move 4 from 5 to 8\n" +
                "move 2 from 5 to 4\n" +
                "move 3 from 8 to 2\n" +
                "move 2 from 4 to 8\n" +
                "move 26 from 3 to 8\n" +
                "move 3 from 2 to 9\n" +
                "move 6 from 3 to 5\n" +
                "move 3 from 5 to 7\n" +
                "move 3 from 7 to 4\n" +
                "move 3 from 4 to 5\n" +
                "move 1 from 9 to 5\n" +
                "move 6 from 5 to 1\n" +
                "move 2 from 8 to 6\n" +
                "move 11 from 8 to 5\n" +
                "move 9 from 5 to 4\n" +
                "move 1 from 9 to 7\n" +
                "move 2 from 7 to 9\n" +
                "move 3 from 1 to 4\n" +
                "move 1 from 5 to 7\n" +
                "move 8 from 6 to 1\n" +
                "move 5 from 7 to 9\n" +
                "move 7 from 9 to 2\n" +
                "move 3 from 2 to 9\n" +
                "move 3 from 7 to 1\n" +
                "move 4 from 9 to 8\n" +
                "move 2 from 5 to 6\n" +
                "move 2 from 2 to 8\n" +
                "move 2 from 6 to 9\n" +
                "move 13 from 8 to 1\n" +
                "move 1 from 2 to 8\n" +
                "move 3 from 3 to 5\n" +
                "move 1 from 9 to 8\n" +
                "move 3 from 5 to 4\n" +
                "move 1 from 9 to 3\n" +
                "move 1 from 2 to 3\n" +
                "move 4 from 8 to 2\n" +
                "move 3 from 2 to 4\n" +
                "move 19 from 1 to 2\n" +
                "move 8 from 1 to 8\n" +
                "move 1 from 4 to 3\n" +
                "move 1 from 4 to 1\n" +
                "move 7 from 2 to 1\n" +
                "move 1 from 3 to 1\n" +
                "move 2 from 3 to 1\n" +
                "move 15 from 4 to 5\n" +
                "move 1 from 1 to 7\n" +
                "move 11 from 2 to 8\n" +
                "move 2 from 2 to 9\n" +
                "move 1 from 3 to 5\n" +
                "move 2 from 9 to 4\n" +
                "move 12 from 8 to 3\n" +
                "move 16 from 5 to 1\n" +
                "move 3 from 4 to 3\n" +
                "move 1 from 7 to 5\n" +
                "move 2 from 8 to 6\n" +
                "move 1 from 5 to 4\n" +
                "move 1 from 4 to 9\n" +
                "move 18 from 1 to 9\n" +
                "move 8 from 3 to 8\n" +
                "move 9 from 8 to 2\n" +
                "move 4 from 9 to 2\n" +
                "move 8 from 1 to 2\n" +
                "move 2 from 6 to 4\n" +
                "move 17 from 2 to 1\n" +
                "move 1 from 4 to 5\n" +
                "move 3 from 2 to 6\n" +
                "move 1 from 2 to 9\n" +
                "move 2 from 6 to 1\n" +
                "move 3 from 3 to 6\n" +
                "move 1 from 4 to 6\n" +
                "move 2 from 3 to 2\n" +
                "move 16 from 9 to 5\n" +
                "move 14 from 5 to 4\n" +
                "move 3 from 5 to 8\n" +
                "move 1 from 2 to 4\n" +
                "move 4 from 8 to 6\n" +
                "move 1 from 2 to 8\n" +
                "move 1 from 3 to 9\n" +
                "move 1 from 3 to 9\n" +
                "move 2 from 9 to 1\n" +
                "move 10 from 8 to 7\n" +
                "move 7 from 6 to 9\n" +
                "move 16 from 1 to 5\n" +
                "move 7 from 4 to 3\n" +
                "move 1 from 8 to 4\n" +
                "move 5 from 4 to 2\n" +
                "move 1 from 5 to 9\n" +
                "move 5 from 9 to 1\n" +
                "move 5 from 1 to 2\n" +
                "move 2 from 9 to 7\n" +
                "move 1 from 1 to 7\n" +
                "move 1 from 6 to 8\n" +
                "move 4 from 4 to 5\n" +
                "move 1 from 6 to 9\n" +
                "move 9 from 2 to 1\n" +
                "move 11 from 5 to 6\n" +
                "move 2 from 9 to 2\n" +
                "move 4 from 3 to 4\n" +
                "move 4 from 4 to 6\n" +
                "move 1 from 3 to 4\n" +
                "move 11 from 7 to 4\n" +
                "move 9 from 4 to 7\n" +
                "move 11 from 7 to 2\n" +
                "move 2 from 3 to 5\n" +
                "move 2 from 4 to 8\n" +
                "move 7 from 5 to 2\n" +
                "move 1 from 8 to 3\n" +
                "move 1 from 5 to 1\n" +
                "move 1 from 3 to 7\n" +
                "move 6 from 2 to 9\n" +
                "move 1 from 8 to 9\n" +
                "move 6 from 9 to 2\n" +
                "move 15 from 6 to 2\n" +
                "move 1 from 7 to 2\n" +
                "move 31 from 2 to 7\n" +
                "move 22 from 7 to 3\n" +
                "move 2 from 5 to 1\n" +
                "move 3 from 7 to 4\n" +
                "move 1 from 4 to 9\n" +
                "move 3 from 4 to 3\n" +
                "move 1 from 8 to 6\n" +
                "move 1 from 9 to 6\n" +
                "move 15 from 1 to 5\n" +
                "move 1 from 9 to 5\n" +
                "move 1 from 1 to 8\n" +
                "move 2 from 6 to 8\n" +
                "move 1 from 8 to 4\n" +
                "move 1 from 4 to 6\n" +
                "move 1 from 6 to 9\n" +
                "move 10 from 3 to 1\n" +
                "move 1 from 9 to 7\n" +
                "move 2 from 7 to 8\n" +
                "move 10 from 5 to 1\n" +
                "move 12 from 1 to 4\n" +
                "move 1 from 3 to 8\n" +
                "move 11 from 4 to 8\n" +
                "move 1 from 8 to 3\n" +
                "move 5 from 5 to 8\n" +
                "move 1 from 5 to 8\n" +
                "move 6 from 8 to 6\n" +
                "move 3 from 2 to 1\n" +
                "move 1 from 6 to 2\n" +
                "move 5 from 1 to 6\n" +
                "move 3 from 1 to 4\n" +
                "move 3 from 2 to 8\n" +
                "move 1 from 2 to 9\n" +
                "move 8 from 3 to 5\n" +
                "move 2 from 1 to 3\n" +
                "move 3 from 7 to 5\n" +
                "move 2 from 3 to 5\n" +
                "move 3 from 5 to 2\n" +
                "move 1 from 7 to 9\n" +
                "move 2 from 9 to 1\n" +
                "move 1 from 6 to 9\n" +
                "move 2 from 4 to 8\n" +
                "move 5 from 6 to 5\n" +
                "move 1 from 6 to 7\n" +
                "move 1 from 9 to 8\n" +
                "move 3 from 6 to 5\n" +
                "move 7 from 8 to 9\n" +
                "move 5 from 9 to 1\n" +
                "move 2 from 4 to 8\n" +
                "move 11 from 5 to 9\n" +
                "move 3 from 2 to 3\n" +
                "move 2 from 5 to 8\n" +
                "move 4 from 3 to 7\n" +
                "move 11 from 9 to 5\n" +
                "move 3 from 7 to 5\n" +
                "move 1 from 3 to 5\n" +
                "move 8 from 1 to 4\n" +
                "move 5 from 3 to 9\n" +
                "move 15 from 5 to 4\n" +
                "move 8 from 4 to 1\n" +
                "move 12 from 8 to 1\n" +
                "move 4 from 5 to 8\n" +
                "move 12 from 4 to 5\n" +
                "move 3 from 7 to 2\n" +
                "move 11 from 5 to 7\n" +
                "move 8 from 8 to 7\n" +
                "move 7 from 9 to 8\n" +
                "move 2 from 5 to 7\n" +
                "move 4 from 7 to 8\n" +
                "move 9 from 8 to 4\n" +
                "move 11 from 4 to 5\n" +
                "move 6 from 7 to 8\n" +
                "move 9 from 8 to 7\n" +
                "move 18 from 7 to 5\n" +
                "move 1 from 8 to 1\n" +
                "move 4 from 1 to 5\n" +
                "move 1 from 7 to 2\n" +
                "move 6 from 1 to 9\n" +
                "move 1 from 2 to 4\n" +
                "move 1 from 4 to 3\n" +
                "move 3 from 1 to 7\n" +
                "move 1 from 4 to 2\n" +
                "move 3 from 2 to 5\n" +
                "move 2 from 9 to 5\n" +
                "move 1 from 2 to 6\n" +
                "move 4 from 7 to 8\n" +
                "move 1 from 6 to 2\n" +
                "move 1 from 2 to 4\n" +
                "move 4 from 8 to 5\n" +
                "move 3 from 9 to 7\n" +
                "move 1 from 9 to 5\n" +
                "move 1 from 4 to 3\n" +
                "move 2 from 3 to 8\n" +
                "move 2 from 7 to 4\n" +
                "move 28 from 5 to 8\n" +
                "move 1 from 8 to 9\n" +
                "move 1 from 9 to 3\n" +
                "move 6 from 5 to 6\n" +
                "move 5 from 5 to 2\n" +
                "move 1 from 3 to 4\n" +
                "move 1 from 7 to 4\n" +
                "move 1 from 5 to 6\n" +
                "move 16 from 8 to 3\n" +
                "move 7 from 1 to 8\n" +
                "move 4 from 4 to 9\n" +
                "move 1 from 2 to 4\n" +
                "move 3 from 2 to 3\n" +
                "move 6 from 6 to 8\n" +
                "move 10 from 3 to 8\n" +
                "move 1 from 2 to 7\n" +
                "move 1 from 6 to 7\n" +
                "move 11 from 8 to 5\n" +
                "move 2 from 7 to 8\n" +
                "move 1 from 1 to 9\n" +
                "move 5 from 9 to 5\n" +
                "move 4 from 3 to 2\n" +
                "move 1 from 4 to 2\n" +
                "move 1 from 3 to 8\n" +
                "move 3 from 8 to 2\n" +
                "move 19 from 8 to 7\n" +
                "move 6 from 7 to 6\n" +
                "move 4 from 5 to 2\n" +
                "move 9 from 7 to 5\n" +
                "move 1 from 7 to 1\n" +
                "move 5 from 6 to 9\n" +
                "move 1 from 7 to 4\n" +
                "move 1 from 6 to 7\n" +
                "move 1 from 4 to 7\n" +
                "move 1 from 1 to 2\n" +
                "move 2 from 7 to 3\n" +
                "move 6 from 5 to 9\n" +
                "move 9 from 9 to 1\n" +
                "move 17 from 5 to 4\n" +
                "move 2 from 3 to 1\n" +
                "move 13 from 4 to 7\n" +
                "move 3 from 3 to 5\n" +
                "move 7 from 1 to 4\n" +
                "move 1 from 5 to 8\n" +
                "move 2 from 5 to 2\n" +
                "move 6 from 7 to 3\n" +
                "move 1 from 5 to 7\n" +
                "move 1 from 9 to 1\n" +
                "move 2 from 3 to 2\n" +
                "move 1 from 9 to 3\n" +
                "move 9 from 7 to 3\n" +
                "move 10 from 3 to 5\n" +
                "move 8 from 4 to 2\n" +
                "move 1 from 4 to 1\n" +
                "move 13 from 2 to 4\n" +
                "move 5 from 4 to 3\n" +
                "move 1 from 5 to 9\n" +
                "move 1 from 7 to 2\n" +
                "move 6 from 4 to 2\n" +
                "move 4 from 1 to 8\n" +
                "move 3 from 4 to 6\n" +
                "move 9 from 8 to 9\n" +
                "move 17 from 2 to 3\n" +
                "move 2 from 8 to 6\n" +
                "move 1 from 4 to 3\n" +
                "move 2 from 6 to 3\n" +
                "move 2 from 1 to 3\n" +
                "move 13 from 3 to 4\n" +
                "move 8 from 9 to 8\n" +
                "move 7 from 4 to 6\n" +
                "move 3 from 5 to 6\n" +
                "move 5 from 8 to 2\n" +
                "move 9 from 6 to 1\n" +
                "move 7 from 2 to 4\n" +
                "move 2 from 6 to 9\n" +
                "move 1 from 1 to 5\n" +
                "move 18 from 3 to 8\n" +
                "move 5 from 1 to 3\n" +
                "move 1 from 6 to 1\n" +
                "move 9 from 4 to 7\n" +
                "move 11 from 8 to 7\n" +
                "move 5 from 7 to 5\n" +
                "move 2 from 4 to 5\n" +
                "move 1 from 6 to 2\n" +
                "move 13 from 7 to 8\n" +
                "move 1 from 4 to 9\n" +
                "move 1 from 9 to 6\n" +
                "move 4 from 1 to 5\n" +
                "move 1 from 7 to 6\n" +
                "move 9 from 5 to 7\n" +
                "move 8 from 5 to 6\n" +
                "move 10 from 7 to 2\n" +
                "move 1 from 5 to 7\n" +
                "move 1 from 7 to 1\n" +
                "move 17 from 8 to 2\n" +
                "move 9 from 6 to 7\n" +
                "move 6 from 7 to 1\n" +
                "move 2 from 7 to 2\n" +
                "move 1 from 4 to 2\n" +
                "move 12 from 2 to 8\n" +
                "move 7 from 1 to 2\n" +
                "move 6 from 8 to 6\n" +
                "move 3 from 8 to 2\n" +
                "move 1 from 7 to 2\n" +
                "move 2 from 3 to 4\n" +
                "move 1 from 4 to 9\n" +
                "move 2 from 3 to 5\n" +
                "move 2 from 3 to 7\n" +
                "move 1 from 4 to 6\n" +
                "move 2 from 7 to 1\n" +
                "move 7 from 2 to 7\n" +
                "move 6 from 7 to 1\n" +
                "move 1 from 5 to 2\n" +
                "move 6 from 8 to 4\n" +
                "move 4 from 9 to 7\n" +
                "move 1 from 5 to 2\n" +
                "move 3 from 8 to 1\n" +
                "move 1 from 9 to 4\n" +
                "move 1 from 7 to 8\n" +
                "move 1 from 8 to 1\n" +
                "move 4 from 7 to 8\n" +
                "move 1 from 4 to 2\n" +
                "move 3 from 6 to 9\n" +
                "move 2 from 9 to 7\n" +
                "move 1 from 9 to 3\n" +
                "move 2 from 4 to 3\n" +
                "move 2 from 8 to 3\n" +
                "move 5 from 3 to 4\n" +
                "move 4 from 6 to 2\n" +
                "move 8 from 2 to 9\n" +
                "move 1 from 6 to 5\n" +
                "move 10 from 2 to 3\n" +
                "move 2 from 8 to 3\n" +
                "move 8 from 9 to 3\n" +
                "move 9 from 2 to 5\n" +
                "move 1 from 2 to 4\n" +
                "move 1 from 2 to 3\n" +
                "move 7 from 5 to 6\n" +
                "move 1 from 5 to 7\n" +
                "move 13 from 3 to 4\n" +
                "move 2 from 7 to 8\n" +
                "move 5 from 3 to 1\n" +
                "move 1 from 5 to 3\n" +
                "move 1 from 8 to 5\n" +
                "move 1 from 2 to 8\n" +
                "move 1 from 7 to 9\n" +
                "move 1 from 4 to 2\n" +
                "move 15 from 4 to 8\n" +
                "move 6 from 4 to 7\n" +
                "move 6 from 7 to 8\n" +
                "move 1 from 6 to 5\n" +
                "move 1 from 4 to 6\n" +
                "move 1 from 9 to 6\n" +
                "move 2 from 5 to 2\n" +
                "move 6 from 6 to 4\n" +
                "move 6 from 1 to 8\n" +
                "move 6 from 4 to 9\n" +
                "move 2 from 6 to 1\n" +
                "move 1 from 2 to 9\n" +
                "move 26 from 8 to 1\n" +
                "move 4 from 3 to 7\n" +
                "move 2 from 2 to 5\n" +
                "move 16 from 1 to 4\n" +
                "move 3 from 9 to 8\n" +
                "move 3 from 8 to 7\n" +
                "move 3 from 5 to 1\n" +
                "move 2 from 9 to 2\n" +
                "move 1 from 9 to 7\n" +
                "move 1 from 9 to 1\n" +
                "move 8 from 4 to 1\n" +
                "move 4 from 4 to 9\n" +
                "move 1 from 2 to 3\n" +
                "move 1 from 3 to 7\n" +
                "move 2 from 8 to 2\n" +
                "move 3 from 4 to 2\n" +
                "move 1 from 4 to 7\n" +
                "move 9 from 7 to 5\n" +
                "move 1 from 9 to 8\n" +
                "move 2 from 9 to 8\n" +
                "move 5 from 5 to 7\n" +
                "move 1 from 9 to 5\n" +
                "move 6 from 2 to 6\n" +
                "move 1 from 8 to 2\n" +
                "move 5 from 6 to 5\n" +
                "move 1 from 7 to 4\n" +
                "move 3 from 8 to 9\n" +
                "move 3 from 9 to 7\n" +
                "move 1 from 6 to 4\n" +
                "move 2 from 4 to 1\n" +
                "move 2 from 5 to 8\n" +
                "move 1 from 2 to 9\n" +
                "move 2 from 8 to 9\n" +
                "move 3 from 9 to 3\n" +
                "move 8 from 7 to 3\n" +
                "move 4 from 5 to 8\n" +
                "move 1 from 3 to 9\n" +
                "move 3 from 5 to 8\n" +
                "move 1 from 5 to 3\n" +
                "move 6 from 8 to 6\n" +
                "move 3 from 3 to 9\n" +
                "move 5 from 3 to 2\n" +
                "move 5 from 6 to 4\n" +
                "move 14 from 1 to 5\n" +
                "move 8 from 5 to 6\n" +
                "move 2 from 3 to 2\n" +
                "move 4 from 9 to 1\n" +
                "move 1 from 8 to 7\n" +
                "move 7 from 2 to 3\n" +
                "move 6 from 3 to 7\n" +
                "move 3 from 5 to 3\n" +
                "move 1 from 3 to 9\n" +
                "move 12 from 1 to 5\n" +
                "move 1 from 9 to 7\n" +
                "move 2 from 3 to 1\n" +
                "move 1 from 7 to 8\n" +
                "move 1 from 8 to 7\n" +
                "move 2 from 3 to 6\n" +
                "move 2 from 1 to 9\n" +
                "move 2 from 5 to 6\n" +
                "move 2 from 9 to 7\n" +
                "move 9 from 7 to 3\n" +
                "move 7 from 1 to 5\n" +
                "move 5 from 5 to 2\n" +
                "move 8 from 6 to 8\n" +
                "move 5 from 8 to 9";
    }
}

package org.scars.VoteSystem;

import java.util.*;

public class VotingSystem {
    private Map<String, Integer> candidates;
    private Map<String, Voter> voters;

    public VotingSystem() {
        candidates = new HashMap<>();

        candidates.put("Alice", 0);
        candidates.put("Black", 0);
        candidates.put("Carl", 0);
        candidates.put("David", 0);
        candidates.put("Easter", 0);

        voters = new HashMap<>();
    }

    public boolean vote(Voter voter, String[] choices) {
        if (choices.length != 3) {
            System.out.println("每人最多可以投3票！");
            return false;
        }

        Set<String> uniqueChoices = new HashSet<>();
        for (String choice : choices) {
            uniqueChoices.add(choice);
            if (!candidates.containsKey(choice)) {
                System.out.println("候选人" + choice + "不存在");
                return false;
            }
        }

        if (uniqueChoices.size() != 3) {
            System.out.println("需要投给3个不同的候选人！");
            return false;
        }

        for (String choice : choices) {
            candidates.put(choice, candidates.get(choice) + 1);
        }

        voters.put(voter.getId(), voter);
        return true;
    }

    public void displayResults() {
        System.out.println("投票结果：");
        for (Map.Entry<String, Integer> entry : candidates.entrySet()) {
            System.out.println("候选人：" + entry.getKey() + "票数：" + entry.getValue());
        }
    }

    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();
        Scanner scanner = new Scanner(System.in);
        int counter = 0;

        while (counter < 100) {
            System.out.println("请输入您的ID");
            String voterID = scanner.nextLine();

            Voter voter;
            if (votingSystem.voters.containsKey(voterID)) {
                voter = votingSystem.voters.get(voterID);
            } else {
                voter = new Voter(voterID);
            }

            System.out.println("请你输入要投票的3个候选人的名称（用逗号分隔）");
            String choiceStr = scanner.nextLine();
            String[] choices = choiceStr.split(",");

            voter.vote(votingSystem, choices);
            ++counter;

            System.out.println("继续投票吗？（y/n）");
            String continueVoting = scanner.nextLine();
            if ("n".equalsIgnoreCase(continueVoting)) {
                break;
            }
        }

        votingSystem.displayResults();
    }
}

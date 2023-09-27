package org.scars.VoterWithoutStaticVariable;

public class VoteSystemWithoutStaticVariable {
    private final int MAX_COUNT = 100;
    private int count = 0;

    public int getCount() {
        return count;
    }

    private Voter[] voters = new Voter[MAX_COUNT];

    public void vote(Voter voter, String answer) {
        if (!containsVoter(voter)) {
            System.out.println(voter.getName() + "，请勿重复投票！");
            return;
        }
        voter.setAnswer(answer);
        voters[count++] = voter;
        System.out.println(voter.getName() + " 感谢你的投票。");
    }

    public boolean containsVoter(Voter voter) {
        for (int i = 0; i < count; i++) {
            if (voters[i].equals(voter)) {
                return false;
            }
        }
        return true;
    }

    public void printResult() {
        for (int i = 0; i < count; i++) {
            System.out.println(voters[i].getName() + " 意见 " + voters[i].getAnswer());
        }
    }

    public static void main(String[] args) {
        VoteSystemWithoutStaticVariable votingSystem = new VoteSystemWithoutStaticVariable();

        votingSystem.vote(new Voter("Tom"), "是");
        votingSystem.vote(new Voter("Tom"), "是");
        votingSystem.vote(new Voter("Jack"), "是");
        votingSystem.vote(new Voter("Mike"), "是");

        System.out.println("当前投票数" + votingSystem.getCount());

        votingSystem.printResult();
    }
}

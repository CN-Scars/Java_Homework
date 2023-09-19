package org.scars;

import java.util.Objects;

public class Voter {
    private String name;
    private String answer;
    private static final int MAX_COUNT = 100;
    private static int count = 0;
    private static Voter[] voters = new Voter[MAX_COUNT];

    @Override
    public String toString() {
        return "Voter{" +
                "name='" + name + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voter voter = (Voter) o;
        return Objects.equals(name, voter.name) &&
                Objects.equals(answer, voter.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, answer);
    }

    public Voter(String name) {
        this.name = name;
    }

    public static void voteFor(String name) {
        Voter voter = new Voter(name);
        voter.answer = "是";
        if (!containsVoter(voter)) {
            System.out.println(voter.name + "，请勿重复投票！");
            return;
        }
        voters[count++] = voter;
        System.out.println(voter.name + " 感谢你的投票。");
    }

    public static boolean containsVoter(Voter voter) {
        for (int i = 0; i < count; ++i) {
            if (voters[i].equals(voter)) {
                return false;
            }
        }
        return true;
    }

    public static void printVolterResult() {
        for (int i = 0; i < count; ++i){
            System.out.println(voters[i].name + " 意见 " + voters[i].answer);
        }
    }

    public static void main(String[] args) {
        voteFor("Tom");
        voteFor("Tom");
        voteFor("Jack");
        voteFor("Mike");

        System.out.println("当前投票数" + count);

        printVolterResult();
    }
}

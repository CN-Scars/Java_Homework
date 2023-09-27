package org.scars.VoteSystem;

public class Voter {
    private String id;
    private boolean hasVoted;

    public Voter(String id) {
        this.id = id;
        this.hasVoted = hasVoted;
    }

    public String getId() {
        return id;
    }

    public boolean hasVoted() {
        return hasVoted;
    }

    public void vote(VotingSystem system, String[] choices) {
        if (hasVoted) {
            System.out.println("您已经投过票了");
            return;
        }
        if (system.vote(this, choices)) {
            hasVoted = true;
        }
    }
}

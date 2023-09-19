package org.scars.VoterWithoutStaticVariable;

import java.util.Objects;

public class Voter {
    private String name;
    private String answer;

    public Voter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voter voter = (Voter) o;
        return Objects.equals(name, voter.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

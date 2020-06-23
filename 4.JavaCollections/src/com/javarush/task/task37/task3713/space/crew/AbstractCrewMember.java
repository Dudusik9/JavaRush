package com.javarush.task.task37.task3713.space.crew;

public abstract class AbstractCrewMember {

    protected CompetencyLevel competencyLevel;

    protected AbstractCrewMember nextCrewMember;

    public void handleRequest(CompetencyLevel competencyLevel, String request) {
        if (this.competencyLevel == competencyLevel) {
            doTheJob(request);
            return;
        }

        if (this.competencyLevel.ordinal() < competencyLevel.ordinal()) {
            nextCrewMember.handleRequest(competencyLevel, request);
        }
    }

    public void setNextCrewMember(AbstractCrewMember nextCrewMember) {
        this.nextCrewMember = nextCrewMember;
    }

    protected abstract void doTheJob(String request);

    public enum CompetencyLevel {
        NOVICE,
        INTERMEDIATE,
        ADVANCED,
        EXPERT
    }

}

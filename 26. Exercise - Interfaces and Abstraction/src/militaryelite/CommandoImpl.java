package militaryelite;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {
    private Set<Mission> missionSet;

    public CommandoImpl(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.missionSet = new LinkedHashSet<>();
    }

    public void addMission(Mission mission) {
        missionSet.add(mission);
    }

    @Override
    public Collection<Mission> getMissions() {
        return Collections.unmodifiableCollection(missionSet);
    }

    @Override
    public String toString() {
        String missions = missionSet.isEmpty()
                ? ""
                : "\n" + missionSet.stream()
                .map(m -> String.format("\t%s",m.toString()))
                .collect(Collectors.joining(System.lineSeparator()));

        return "%s\nMissions:%s".formatted(super.toString(), missions);
    }
}

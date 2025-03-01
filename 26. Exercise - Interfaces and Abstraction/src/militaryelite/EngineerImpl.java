package militaryelite;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {
    private Set<Repair> repairSet;

    public EngineerImpl(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairSet = new LinkedHashSet<>();
    }

    public void addRepair(Repair repair) {
        repairSet.add(repair);
    }

    @Override
    public Collection<Repair> getRepairs() {
        return Collections.unmodifiableCollection(repairSet);
    }

    @Override
    public String toString() {
        String repairs = repairSet.isEmpty()
                ? ""
                : "\n" + repairSet.stream()
                .map(r -> String.format("\t%s",r.toString()))
                .collect(Collectors.joining(System.lineSeparator()));

        return "%s\nRepairs:%s".formatted(super.toString(), repairs);
    }
}

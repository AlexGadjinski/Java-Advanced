package militaryelite;

import java.util.*;
import java.util.stream.Collectors;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {
    //Set<PrivateImpl> ???
    private Set<PrivateImpl> privateImplsSet;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privateImplsSet = new LinkedHashSet<>();
    }

    public void addPrivate(Private priv) {
        privateImplsSet.add((PrivateImpl) priv);
    }

    @Override
    public Collection<Private> getPrivateImpls() {
        return Collections.unmodifiableCollection(privateImplsSet);
    }

    @Override
    public String toString() {
        String privates = privateImplsSet.isEmpty()
                ? ""
                : "\n" + privateImplsSet.stream()
                .sorted(Comparator.comparing(SoldierImpl::getId).reversed())
                .map(p -> String.format("\t%s", p))
                .collect(Collectors.joining(System.lineSeparator()));

        return "%s\nPrivates:%s".formatted(super.toString(), privates);
    }
}

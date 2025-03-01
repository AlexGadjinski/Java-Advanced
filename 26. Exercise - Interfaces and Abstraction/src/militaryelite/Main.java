package militaryelite;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Soldier> soldiers = new ArrayList<>();
        Map<Integer, Private> privates = new HashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] tokens = input.split(" ");
            String role = tokens[0];
            int id = Integer.parseInt(tokens[1]);
            String firstName = tokens[2];
            String lastName = tokens[3];

            switch (role) {
                case "Private" -> {
                    privates.put(id, new PrivateImpl(id, firstName, lastName, Double.parseDouble(tokens[4])));
                    soldiers.add(new PrivateImpl(id, firstName, lastName, Double.parseDouble(tokens[4])));
                }
                case "LieutenantGeneral" -> {
                    LieutenantGeneralImpl lieutenantGeneral =
                            new LieutenantGeneralImpl(id, firstName, lastName, Double.parseDouble(tokens[4]));
                    soldiers.add(lieutenantGeneral);
                    for (int i = 5; i < tokens.length; i++) {
                        int privateId = Integer.parseInt(tokens[i]);
                        if (privates.containsKey(privateId)) {
                            lieutenantGeneral.addPrivate(privates.get(privateId));
                        }
                    }
                }
                case "Engineer" -> {
                    try {
                        EngineerImpl engineer = new EngineerImpl(id, firstName, lastName, Double.parseDouble(tokens[4]), tokens[5]);
                        soldiers.add(engineer);
                        for (int i = 6; i < tokens.length; i += 2) {
                            String partName = tokens[i];
                            int hours = Integer.parseInt(tokens[i + 1]);
                            engineer.addRepair(new Repair(partName, hours));
                        }
                    } catch (IllegalArgumentException ignored) {

                    }
                }
                case "Commando" -> {
                    try {
                        CommandoImpl commando = new CommandoImpl(id, firstName, lastName, Double.parseDouble(tokens[4]), tokens[5]);
                        soldiers.add(commando);
                        for (int i = 6; i < tokens.length; i += 2) {
                            String codeName = tokens[i];
                            String state = tokens[i + 1];
                            try {
                                commando.addMission(new Mission(codeName, state));
                            } catch (IllegalArgumentException ignored) {

                            }
                        }
                    } catch (IllegalArgumentException ignored) {

                    }
                }
                case "Spy" -> {
                    SpyImpl spy = new SpyImpl(id, firstName, lastName, tokens[4]);
                    soldiers.add(spy);
                }
            }
            input = scanner.nextLine();
        }

        soldiers.forEach(System.out::println);
    }
}

package model;

import java.util.ArrayList;
import java.util.List;

public class Group extends Component {
    private String boss;
    private List<Component> members = new ArrayList<>();

    public Group(String name, String boss) {
        super(name);
        this.boss = boss;
    }

    @Override
    public void add(Component c) {
        members.add(c);
    }

    @Override
    public void remove(Component c) {
        members.removeIf(member -> member.getName().equals(c.getName()));
    }

    public boolean removeWorkerByName(String fullName) {
        for (int i = 0; i < members.size(); i++) {
            Component c = members.get(i);
            if (c instanceof Worker && c.getName().equals(fullName)) {
                members.remove(i);
                return true;
            } else if (c instanceof Group) {
                if (((Group) c).removeWorkerByName(fullName)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void print(int indent) {
        System.out.println("  ".repeat(indent) + "Group: " + name + ", boss's name: " + boss);

    for (int i = 0; i < members.size(); i++) {
        Component member = members.get(i);

        if (member instanceof Worker) {
            System.out.println("  ".repeat(indent + 1) + "Worker: " + member.getName());
        } else {
            System.out.println(); // blank line before each subgroup
            member.print(indent + 1);
        }
    }
}


    public List<Component> getMembers() {
        return members;
    }
}

package Main;

import model.Group;
import model.Worker;
import model.Component;
import exceptions.InvalidInputException;

import java.util.Scanner;

public class OrganizationApp {

    private static Group root = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice;

        while (true) {
            printMenu();
            choice = scanner.nextLine().trim();

            switch (choice.toLowerCase()) {
                case "1":
                    createOrganization();
                    root.print(0);
                    break;
                case "2":
                    if (root == null) {
                        System.out.println("Please create the organization first (option 1).\n");
                        break;
                    }
                    handleAddPerson(scanner);
                    break;
                case "3":
                    if (root == null) {
                        System.out.println("Please create the organization first (option 1).\n");
                        break;
                    }
                    handleRemovePerson(scanner);
                    break;
                case "q":
                    System.out.println("Quitting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.\n");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nOrganization management system");
        System.out.println("------------------------------");
        System.out.println("1. Create and print hard coded organization");
        System.out.println("2. Print organization, add person to it and finally print it");
        System.out.println("3. Print organization, remove person from it and finally print it");
        System.out.println("Q. Quit the application\n");
        System.out.print("Your choice: ");
    }

    private static void createOrganization() {
        root = new Group("Top management", "Scrooge McDuck");

        Group marketing = new Group("Marketing", "Donald Duck");
        marketing.add(new Worker("Gus Goose"));

        Group softwareDev = new Group("Software Development", "Daisy Duck");
        softwareDev.add(new Worker("Huey Duck"));
        softwareDev.add(new Worker("Dewey Duck"));
        softwareDev.add(new Worker("Louie Duck"));

        Group customerSupport = new Group("Customer Support", "Gladstone Gander");
        customerSupport.add(new Worker("Gyro Gearloose"));
        customerSupport.add(new Worker("Magica De Spell"));
        customerSupport.add(new Worker("Launchpad McQuack"));

        root.add(new Worker("Grandma Duck (secretary)"));
        root.add(marketing);
        root.add(softwareDev);
        root.add(customerSupport);
    }

    private static void handleAddPerson(Scanner scanner) {
        try {
            root.print(0);
            System.out.print("\nGive group name: ");
            String groupName = scanner.nextLine().trim();

            Group targetGroup = findGroup(root, groupName);
            if (targetGroup == null) {
                throw new InvalidInputException("ERROR: Group not found.");
            }

            System.out.print("Give person name: ");
            String personName = scanner.nextLine().trim();

            if (!personName.matches("[A-Z][a-z]+ [A-Z][a-z]+")) {
                throw new InvalidInputException("ERROR: Invalid name. Please enter a valid name like John Smith.");
            }

            targetGroup.add(new Worker(personName));
            System.out.println("\nPerson added successfully. Updated organization:\n");
            root.print(0);
        } catch (InvalidInputException e) {
            System.out.println("\n" + e.getMessage() + "\n");
        }
    }

    private static void handleRemovePerson(Scanner scanner) {
        try {
            root.print(0);
            System.out.print("\nGive person name: ");
            String personName = scanner.nextLine().trim();

            if (!personName.matches("[A-Z][a-z]+ [A-Z][a-z]+")) {
                throw new InvalidInputException("ERROR: Invalid name. Please enter a valid name like John Smith.");
            }

            boolean removed = root.removeWorkerByName(personName);
            if (!removed) {
                throw new InvalidInputException("ERROR: Person not found or is a boss. Only workers can be removed.");
            }

            System.out.println("\nPerson removed successfully. Updated organization:\n");
            root.print(0);
        } catch (InvalidInputException e) {
            System.out.println("\n" + e.getMessage() + "\n");
        }
    }

    private static Group findGroup(Group group, String groupName) {
        if (group.getName().equals(groupName)) {
            return group;
        }
        for (Component member : group.getMembers()) {
            if (member instanceof Group) {
                Group found = findGroup((Group) member, groupName);
                if (found != null) return found;
            }
        }
        return null;
    }
}

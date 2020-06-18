package GBJ2.J2.Marathon;


public class Main {
    public static void main(String[] args) {
        Team team1 = new Team("Урал-грейт", new Human("Боб"), new Cat("Барсик"), new Dog("Бобик"));
        team1.getTeamMembers();
        Course course = new Course(new Cross(80), new Water(5), new Wall(1), new Cross(120));
        course.start(team1);
        team1.getTeamSuccessfulMembers();
    }
}
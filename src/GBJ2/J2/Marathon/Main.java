package GBJ2.J2.Marathon;


public class Main {
    public static void main(String[] args) {
        Team team1 = new Team("Урал-грейт", new Human("Боб"), new Cat("Барсик"), new Dog("Бобик"));
        team1.getTeamMembers();


//        Obstacle[] course = {new Cross(80), new Water(5), new Wall(1), new Cross(120)};
//        for (Competitor c : competitors) {
//            for (Obstacle o : course) {
//                o.doIt(c);
//                if (!c.isOnDistance()) break;
//            }
//        }
//        for (Competitor c : competitors) {
//            c.info();
//        }
    }
}
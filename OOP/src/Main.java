public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello, World!");
        /*Human human = new Human("Montana", "Antonio", 25);
        System.out.println(human);

        Student student = new Student("Pinkman", "Jessie", 22, "Chemistry", "WW_220", 95, 96);
        System.out.println(student);

        Teacher teacher = new Teacher("White", "Walter", 50, "Chemistry", 25);
        System.out.println(teacher);*/

        Human[] group = new Human[]
                {
                        new Human("Montana", "Antonio", 25),
                        new Student("Pinkman", "Jessie", 22, "Chemistry", "WW_220", 95, 96),
                        new Teacher("White", "Walter", 50, "Chemistry", 25)
                };
        for(Human h : group)
        {
            System.out.println(h);
        }
    }
}
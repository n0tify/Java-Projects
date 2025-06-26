public class User {
    private String name;
    private int userId;

    public User(String name, int userId) {
        this.name = name;
        this.userId = userId;
    }

    public void displayUser() {
        System.out.println("User ID: " + userId + ", Name: " + name);
    }
}

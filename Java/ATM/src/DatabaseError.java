public class DatabaseError extends RuntimeException{

    private static final String message="Database Error !";

    public DatabaseError() {
        super(message);
    }
}

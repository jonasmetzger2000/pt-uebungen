package orders;

public class NotAPositiveNumberException extends Exception
{
    public NotAPositiveNumberException(String message) {
        super(message);
    }
}

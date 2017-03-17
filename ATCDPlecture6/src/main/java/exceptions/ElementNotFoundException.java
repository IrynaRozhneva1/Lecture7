package exceptions;

public class ElementNotFoundException extends RuntimeException
{
	private static final long serialVersionUID = 1L;


    public ElementNotFoundException(String errorMessage) {
        super( errorMessage );
    }

    public ElementNotFoundException(String message, Throwable cause) {
        super( message, cause );
    }
}

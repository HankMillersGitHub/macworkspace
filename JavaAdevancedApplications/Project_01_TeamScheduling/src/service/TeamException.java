package service;

public class TeamException extends Exception{
    static final long serialVersionUID = -3387516993124228L;
    public TeamException() {
    }

    public TeamException(String message) {
        super(message);
    }
}

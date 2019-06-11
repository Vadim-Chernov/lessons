package cvr.otus.exception;

public class ObjectNotFoundException extends RuntimeException {
    public ObjectNotFoundException(String objId) {
        super("Object was not found with id " +objId);
    }
}

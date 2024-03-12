package MyExceptions;

/**
 *
 * @author m.e.morse39757
 */
public class TitleDuplicate extends RuntimeException {

    private String msg;

    public TitleDuplicate(String msg) {
        this.msg = msg;
    }
    
    @Override
    public String getMessage(){
        return msg;
    }
}
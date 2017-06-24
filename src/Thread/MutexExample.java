package Thread;

/**
 * Created by sumitachauhan on 6/23/17.
 */
public class MutexExample {

    private final String str ;

    public MutexExample(String str) {
        this.str = new String("A");
    }

    public void aMethod() {
        NeedsSynchronization needsSynchronization = new NeedsSynchronization();
    }

    public static final class NeedsSynchronization {

        public void thisIsAMethod() {

        }
    }
}

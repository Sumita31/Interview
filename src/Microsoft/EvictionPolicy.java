package Microsoft;

/**
 * Created by sumitachauhan on 6/29/17.
 */
public interface EvictionPolicy<T> {
    /**
     * This method is called to test if an idle object in the pool should be
     * evicted or not.
     *
     * @param config    The pool configuration settings related to eviction
     * @param underTest The pooled object being tested for eviction
     * @param idleCount The current number of idle objects in the pool including
     *                      the object under test
     * @return <code>true</code> if the object should be evicted, otherwise
     *             <code>false</code>
     */
    boolean evict(EvictionConfig config, int idleCount, EvictionObject underTest);
}

class EvictionConfig{

}
class EvictionObject{

}
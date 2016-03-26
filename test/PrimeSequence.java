package test;
//
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * Represents a sequence of prime numbers starting from a given value.
 * 
 * @author Stephan Jamieson
 * @version 20/3/2016
 */
public class PrimeSequence {

    private List<Integer> primes;
    
    /**
     * Create a PrimeGenerator such that the first number returned is greater or equal to <code>start</code>.
     * <p>
     * The value of <code>start</code> should be greater than one.
     */
    public PrimeSequence(int start) {
        assert(start>1);
        primes=new ArrayList<Integer>();
        primes.add(1);
        primes.add(2);
        while (this.last()<start) {
            this.generateNext();
        }
    }
    
    private int last() { return primes.get(primes.size()-1); }

    private void generateNext() {
        int candidate = last()==2 ? 3 : last()+2;
        while (!isPrime(candidate)) {
            candidate=candidate+2;
        }
        primes.add(candidate);
    }
    
    private boolean isPrime(final int candidate) {
        final int maxFactor = (int)Math.sqrt(candidate);
        Iterator<Integer> iterator = primes.iterator();
        iterator.next();
        while(iterator.hasNext()) {
            int prime=iterator.next();
            if (candidate%prime==0) {
                return false;
            }
            if (prime>maxFactor) { 
                return true;
            }
        }
        throw new IllegalStateException("PrimeGenerator: logic error.");
    }

    /**
     * Obtain the next prime number in the sequence.
     */
    public int next() {
        this.generateNext();
        return primes.get(primes.size()-2); 
    }
}

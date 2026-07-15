package QueueQuestions;

public class Main {
    public static void main(String[] args) {
        LruCache cache=new LruCache(2);
        cache.put(1,2);
        System.out.println( cache.get(1));
        cache.put(3,8);
        System.out.println(cache.get(3));
    }
}

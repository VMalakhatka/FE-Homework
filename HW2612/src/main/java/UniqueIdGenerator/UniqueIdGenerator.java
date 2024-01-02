package UniqueIdGenerator;

import java.util.concurrent.atomic.AtomicLong;

class UniqueIdGenerator {
    private static final ThreadLocal<AtomicLong> uniqueIdCounter = ThreadLocal.withInitial(AtomicLong::new);

    public static long generateUniqueId() {
        return uniqueIdCounter.get().incrementAndGet();
    }
}

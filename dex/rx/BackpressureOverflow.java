package rx;

import rx.exceptions.MissingBackpressureException;

public final class BackpressureOverflow {
    public static final Strategy ON_OVERFLOW_ERROR = Error.INSTANCE;
    public static final Strategy ON_OVERFLOW_DEFAULT = ON_OVERFLOW_ERROR;
    public static final Strategy ON_OVERFLOW_DROP_OLDEST = DropOldest.INSTANCE;
    public static final Strategy ON_OVERFLOW_DROP_LATEST = DropLatest.INSTANCE;

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public interface Strategy {
        boolean mayAttemptDrop() throws MissingBackpressureException;
    }

    private BackpressureOverflow() {
        throw new IllegalStateException("No instances!");
    }

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    static final class DropOldest implements Strategy {
        static final DropOldest INSTANCE = new DropOldest();

        private DropOldest() {
        }

        @Override // rx.BackpressureOverflow.Strategy
        public boolean mayAttemptDrop() {
            return true;
        }
    }

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    static final class DropLatest implements Strategy {
        static final DropLatest INSTANCE = new DropLatest();

        private DropLatest() {
        }

        @Override // rx.BackpressureOverflow.Strategy
        public boolean mayAttemptDrop() {
            return false;
        }
    }

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    static final class Error implements Strategy {
        static final Error INSTANCE = new Error();

        private Error() {
        }

        @Override // rx.BackpressureOverflow.Strategy
        public boolean mayAttemptDrop() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }
}
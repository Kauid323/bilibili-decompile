package rx.schedulers;

public class TimeInterval<T> {
    private final long intervalInMilliseconds;
    private final T value;

    public TimeInterval(long intervalInMilliseconds, T value) {
        this.value = value;
        this.intervalInMilliseconds = intervalInMilliseconds;
    }

    public long getIntervalInMilliseconds() {
        return this.intervalInMilliseconds;
    }

    public T getValue() {
        return this.value;
    }

    public int hashCode() {
        int result = (31 * 1) + ((int) (this.intervalInMilliseconds ^ (this.intervalInMilliseconds >>> 32)));
        return (31 * result) + (this.value == null ? 0 : this.value.hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TimeInterval<?> other = (TimeInterval) obj;
        if (this.intervalInMilliseconds != other.intervalInMilliseconds) {
            return false;
        }
        if (this.value == null) {
            if (other.value != null) {
                return false;
            }
        } else if (!this.value.equals(other.value)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "TimeInterval [intervalInMilliseconds=" + this.intervalInMilliseconds + ", value=" + this.value + "]";
    }
}
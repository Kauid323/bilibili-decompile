package io.reactivex.rxjava3.schedulers;

import j$.util.Objects;
import java.util.concurrent.TimeUnit;

public final class Timed<T> {
    final long time;
    final TimeUnit unit;
    final T value;

    public Timed(T value, long time, TimeUnit unit) {
        this.value = (T) Objects.requireNonNull(value, "value is null");
        this.time = time;
        this.unit = (TimeUnit) Objects.requireNonNull(unit, "unit is null");
    }

    public T value() {
        return this.value;
    }

    public TimeUnit unit() {
        return this.unit;
    }

    public long time() {
        return this.time;
    }

    public long time(TimeUnit unit) {
        return unit.convert(this.time, this.unit);
    }

    public boolean equals(Object other) {
        if (other instanceof Timed) {
            Timed<?> o = (Timed) other;
            return Objects.equals(this.value, o.value) && this.time == o.time && Objects.equals(this.unit, o.unit);
        }
        return false;
    }

    public int hashCode() {
        int h = this.value.hashCode();
        return (((h * 31) + ((int) ((this.time >>> 31) ^ this.time))) * 31) + this.unit.hashCode();
    }

    public String toString() {
        return "Timed[time=" + this.time + ", unit=" + this.unit + ", value=" + this.value + "]";
    }
}
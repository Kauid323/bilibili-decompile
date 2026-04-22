package nl.adaptivity.xmlutil.core.impl;

import java.io.Reader;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.DebugKt;

/* compiled from: CharsequenceReader.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0019\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\rH\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\u0010\u0010\t\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0005H\u0016J \u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lnl/adaptivity/xmlutil/core/impl/CharsequenceReader;", "Ljava/io/Reader;", "sequence", "", "dummy", "", "<init>", "(Ljava/lang/CharSequence;I)V", "pos", "mark", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "close", "", "read", "skip", "", "n", "ready", "", "reset", "markSupported", "readAheadLimit", "cbuf", "", DebugKt.DEBUG_PROPERTY_VALUE_OFF, "len", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CharsequenceReader extends Reader {
    private final ReentrantLock lock;
    private int mark;
    private int pos;
    private final CharSequence sequence;

    public CharsequenceReader(CharSequence sequence, int dummy) {
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        this.sequence = sequence;
        this.lock = new ReentrantLock();
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Lock $this$invoke$iv = this.lock;
        $this$invoke$iv.lock();
        try {
            this.pos = -1;
            Unit unit = Unit.INSTANCE;
        } finally {
            $this$invoke$iv.unlock();
        }
    }

    @Override // java.io.Reader
    public int read() {
        char charAt;
        Lock $this$invoke$iv = this.lock;
        $this$invoke$iv.lock();
        try {
            if (this.pos < 0) {
                throw new IllegalStateException("Reader closed");
            }
            if (this.pos >= this.sequence.length()) {
                charAt = 65535;
            } else {
                charAt = this.sequence.charAt(this.pos);
                this.pos++;
            }
            return charAt;
        } finally {
            $this$invoke$iv.unlock();
        }
    }

    @Override // java.io.Reader
    public long skip(long n) {
        Lock $this$invoke$iv = this.lock;
        $this$invoke$iv.lock();
        try {
            int origPos = this.pos;
            this.pos = RangesKt.coerceAtMost(this.pos + ((int) n), this.sequence.length());
            return this.pos - origPos;
        } finally {
            $this$invoke$iv.unlock();
        }
    }

    @Override // java.io.Reader
    public boolean ready() {
        Lock $this$invoke$iv = this.lock;
        $this$invoke$iv.lock();
        try {
            int length = this.sequence.length();
            int i = this.pos;
            boolean z = false;
            if (i >= 0 && i < length) {
                z = true;
            }
            return z;
        } finally {
            $this$invoke$iv.unlock();
        }
    }

    @Override // java.io.Reader
    public void reset() {
        Lock $this$invoke$iv = this.lock;
        $this$invoke$iv.lock();
        try {
            this.pos = this.mark;
            Unit unit = Unit.INSTANCE;
        } finally {
            $this$invoke$iv.unlock();
        }
    }

    @Override // java.io.Reader
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.Reader
    public void mark(int readAheadLimit) {
        Lock $this$invoke$iv = this.lock;
        $this$invoke$iv.lock();
        try {
            this.mark = this.pos;
            Unit unit = Unit.INSTANCE;
        } finally {
            $this$invoke$iv.unlock();
        }
    }

    @Override // java.io.Reader
    public int read(char[] cbuf, int off, int len) {
        Intrinsics.checkNotNullParameter(cbuf, "cbuf");
        Lock $this$invoke$iv = this.lock;
        $this$invoke$iv.lock();
        try {
            if (this.pos < this.sequence.length()) {
                int origPos = this.pos;
                int coerceAtMost = RangesKt.coerceAtMost(len, this.sequence.length() - this.pos) + off;
                for (int i = off; i < coerceAtMost; i++) {
                    cbuf[i] = this.sequence.charAt(this.pos);
                    this.pos++;
                }
                int i2 = this.pos;
                return i2 - origPos;
            }
            $this$invoke$iv.unlock();
            return -1;
        } finally {
            $this$invoke$iv.unlock();
        }
    }
}
package nl.adaptivity.xmlutil.core.impl;

import java.io.Writer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;
import nl.adaptivity.xmlutil.core.internal.CharArraySequence;

/* compiled from: AppendableWriter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\r\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0016J \u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u0010\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0014H\u0016J \u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\fH\u0016J\b\u0010\u0019\u001a\u00020\nH\u0016J\b\u0010\u001a\u001a\u00020\nH\u0016R\u0012\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lnl/adaptivity/xmlutil/core/impl/AppendableWriter;", "Ljava/io/Writer;", "appendable", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "<init>", "(Ljava/lang/Appendable;)V", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "write", "", "c", "", "cbuf", "", DebugKt.DEBUG_PROPERTY_VALUE_OFF, "len", "str", "", "append", "", "csq", "", "start", "end", "flush", "close", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppendableWriter extends Writer {
    private final Appendable appendable;
    private final ReentrantLock lock;

    public AppendableWriter(Appendable appendable) {
        Intrinsics.checkNotNullParameter(appendable, "appendable");
        this.appendable = appendable;
        this.lock = new ReentrantLock();
    }

    @Override // java.io.Writer
    public void write(int c) {
        Lock $this$invoke$iv = this.lock;
        $this$invoke$iv.lock();
        try {
            this.appendable.append((char) c);
            Unit unit = Unit.INSTANCE;
        } finally {
            $this$invoke$iv.unlock();
        }
    }

    @Override // java.io.Writer
    public void write(char[] cbuf, int off, int len) {
        Intrinsics.checkNotNullParameter(cbuf, "cbuf");
        Lock $this$invoke$iv = this.lock;
        $this$invoke$iv.lock();
        try {
            this.appendable.append(new CharArraySequence(cbuf, off, len));
            Unit unit = Unit.INSTANCE;
        } finally {
            $this$invoke$iv.unlock();
        }
    }

    @Override // java.io.Writer
    public void write(String str, int off, int len) {
        Intrinsics.checkNotNullParameter(str, "str");
        Lock $this$invoke$iv = this.lock;
        $this$invoke$iv.lock();
        try {
            this.appendable.append(str, off, off + len);
            Unit unit = Unit.INSTANCE;
        } finally {
            $this$invoke$iv.unlock();
        }
    }

    @Override // java.io.Writer, java.lang.Appendable
    public AppendableWriter append(char c) {
        AppendableWriter $this$append_u24lambda_u244 = this;
        Lock $this$invoke$iv = $this$append_u24lambda_u244.lock;
        $this$invoke$iv.lock();
        try {
            $this$append_u24lambda_u244.appendable.append(c);
            Unit unit = Unit.INSTANCE;
            $this$invoke$iv.unlock();
            return this;
        } catch (Throwable th) {
            $this$invoke$iv.unlock();
            throw th;
        }
    }

    @Override // java.io.Writer, java.lang.Appendable
    public AppendableWriter append(CharSequence csq, int start, int end) {
        Intrinsics.checkNotNullParameter(csq, "csq");
        AppendableWriter $this$append_u24lambda_u246 = this;
        Lock $this$invoke$iv = $this$append_u24lambda_u246.lock;
        $this$invoke$iv.lock();
        try {
            $this$append_u24lambda_u246.appendable.append(csq, start, end);
            Unit unit = Unit.INSTANCE;
            $this$invoke$iv.unlock();
            return this;
        } catch (Throwable th) {
            $this$invoke$iv.unlock();
            throw th;
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
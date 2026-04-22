package nl.adaptivity.xmlutil.util;

import java.io.IOException;
import java.io.Reader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;

/* compiled from: CombiningReader.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0003\"\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\bH\u0016J\b\u0010\u0015\u001a\u00020\u000fH\u0016R\u0018\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lnl/adaptivity/xmlutil/util/CombiningReader;", "Ljava/io/Reader;", "sources", "", "<init>", "([Ljava/io/Reader;)V", "[Ljava/io/Reader;", "currentSource", "", "read", "cbuf", "", DebugKt.DEBUG_PROPERTY_VALUE_OFF, "len", "close", "", "ready", "", "mark", "", "readAheadLimit", "reset", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CombiningReader extends Reader {
    private int currentSource;
    private final Reader[] sources;

    public CombiningReader(Reader... sources) {
        Intrinsics.checkNotNullParameter(sources, "sources");
        this.sources = sources;
    }

    @Override // java.io.Reader
    public int read(char[] cbuf, int off, int len) {
        Intrinsics.checkNotNullParameter(cbuf, "cbuf");
        if (this.currentSource >= this.sources.length) {
            return -1;
        }
        Reader source = this.sources[this.currentSource];
        int i = source.read(cbuf, off, len);
        if (i < 0) {
            source.close();
            this.currentSource++;
            return read(cbuf, off, len);
        }
        return i;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        for (Reader reader : this.sources) {
            reader.close();
        }
    }

    @Override // java.io.Reader
    public boolean ready() {
        if (this.currentSource >= this.sources.length) {
            return false;
        }
        return this.sources[this.currentSource].ready();
    }

    @Override // java.io.Reader
    public Void mark(int readAheadLimit) {
        throw new IOException("Mark not supported");
    }

    @Override // java.io.Reader
    public void reset() {
        for (int i = this.currentSource; -1 < i; i--) {
            this.sources[i].reset();
            this.currentSource = i;
        }
    }
}
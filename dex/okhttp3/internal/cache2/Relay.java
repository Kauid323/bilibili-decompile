package okhttp3.internal.cache2;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

final class Relay {
    private static final long FILE_HEADER_SIZE = 32;
    static final ByteString PREFIX_CLEAN = ByteString.encodeUtf8("OkHttp cache v1\n");
    static final ByteString PREFIX_DIRTY = ByteString.encodeUtf8("OkHttp DIRTY :(\n");
    private static final int SOURCE_FILE = 2;
    private static final int SOURCE_UPSTREAM = 1;
    final long bufferMaxSize;
    boolean complete;
    RandomAccessFile file;
    private final ByteString metadata;
    int sourceCount;
    Source upstream;
    long upstreamPos;
    Thread upstreamReader;
    final Buffer upstreamBuffer = new Buffer();
    final Buffer buffer = new Buffer();

    private Relay(RandomAccessFile file, Source upstream, long upstreamPos, ByteString metadata, long bufferMaxSize) {
        this.file = file;
        this.upstream = upstream;
        this.complete = upstream == null;
        this.upstreamPos = upstreamPos;
        this.metadata = metadata;
        this.bufferMaxSize = bufferMaxSize;
    }

    public static Relay edit(File file, Source upstream, ByteString metadata, long bufferMaxSize) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        Relay result = new Relay(randomAccessFile, upstream, 0L, metadata, bufferMaxSize);
        randomAccessFile.setLength(0L);
        result.writeHeader(PREFIX_DIRTY, -1L, -1L);
        return result;
    }

    public static Relay read(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        FileOperator fileOperator = new FileOperator(randomAccessFile.getChannel());
        Buffer header = new Buffer();
        fileOperator.read(0L, header, FILE_HEADER_SIZE);
        ByteString prefix = header.readByteString(PREFIX_CLEAN.size());
        if (!prefix.equals(PREFIX_CLEAN)) {
            throw new IOException("unreadable cache file");
        }
        long upstreamSize = header.readLong();
        long metadataSize = header.readLong();
        Buffer metadataBuffer = new Buffer();
        fileOperator.read(upstreamSize + FILE_HEADER_SIZE, metadataBuffer, metadataSize);
        ByteString metadata = metadataBuffer.readByteString();
        return new Relay(randomAccessFile, null, upstreamSize, metadata, 0L);
    }

    private void writeHeader(ByteString prefix, long upstreamSize, long metadataSize) throws IOException {
        Buffer header = new Buffer();
        header.write(prefix);
        header.writeLong(upstreamSize);
        header.writeLong(metadataSize);
        if (header.size() != FILE_HEADER_SIZE) {
            throw new IllegalArgumentException();
        }
        FileOperator fileOperator = new FileOperator(this.file.getChannel());
        fileOperator.write(0L, header, FILE_HEADER_SIZE);
    }

    private void writeMetadata(long upstreamSize) throws IOException {
        Buffer metadataBuffer = new Buffer();
        metadataBuffer.write(this.metadata);
        FileOperator fileOperator = new FileOperator(this.file.getChannel());
        fileOperator.write(FILE_HEADER_SIZE + upstreamSize, metadataBuffer, this.metadata.size());
    }

    void commit(long upstreamSize) throws IOException {
        writeMetadata(upstreamSize);
        this.file.getChannel().force(false);
        writeHeader(PREFIX_CLEAN, upstreamSize, this.metadata.size());
        this.file.getChannel().force(false);
        synchronized (this) {
            this.complete = true;
        }
        Util.closeQuietly(this.upstream);
        this.upstream = null;
    }

    boolean isClosed() {
        return this.file == null;
    }

    public ByteString metadata() {
        return this.metadata;
    }

    public Source newSource() {
        synchronized (this) {
            if (this.file == null) {
                return null;
            }
            this.sourceCount++;
            return new RelaySource();
        }
    }

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    class RelaySource implements Source {
        private FileOperator fileOperator;
        private long sourcePos;
        private final Timeout timeout = new Timeout();

        RelaySource() {
            this.fileOperator = new FileOperator(Relay.this.file.getChannel());
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x0050, code lost:
            if (r7 != 2) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0052, code lost:
            r4 = java.lang.Math.min(r23, r7 - r21.sourcePos);
            r21.fileOperator.read(r21.sourcePos + okhttp3.internal.cache2.Relay.FILE_HEADER_SIZE, r22, r4);
            r21.sourcePos += r4;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x006b, code lost:
            return r4;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x006d, code lost:
            r13 = r21.this$0.upstream.read(r21.this$0.upstreamBuffer, r21.this$0.bufferMaxSize);
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x007f, code lost:
            if (r13 != (-1)) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0081, code lost:
            r21.this$0.commit(r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0087, code lost:
            r8 = r21.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0089, code lost:
            monitor-enter(r8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x008a, code lost:
            r21.this$0.upstreamReader = null;
            r21.this$0.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0093, code lost:
            monitor-exit(r8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0094, code lost:
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0098, code lost:
            r5 = java.lang.Math.min(r13, r23);
            r21.this$0.upstreamBuffer.copyTo(r22, 0, r5);
            r21.sourcePos += r5;
            r21.fileOperator.write(r7 + okhttp3.internal.cache2.Relay.FILE_HEADER_SIZE, r21.this$0.upstreamBuffer.clone(), r13);
            r8 = r21.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00c4, code lost:
            monitor-enter(r8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x00c5, code lost:
            r21.this$0.buffer.write(r21.this$0.upstreamBuffer, r13);
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x00e0, code lost:
            if (r21.this$0.buffer.size() <= r21.this$0.bufferMaxSize) goto L46;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x00e2, code lost:
            r21.this$0.buffer.skip(r21.this$0.buffer.size() - r21.this$0.bufferMaxSize);
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00f6, code lost:
            r21.this$0.upstreamPos += r13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x00fd, code lost:
            monitor-exit(r8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00ff, code lost:
            r4 = r21.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x0101, code lost:
            monitor-enter(r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0102, code lost:
            r21.this$0.upstreamReader = null;
            r21.this$0.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x010c, code lost:
            monitor-exit(r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x010d, code lost:
            return r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x0111, code lost:
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x0114, code lost:
            monitor-exit(r8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x0115, code lost:
            throw r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x0116, code lost:
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x0118, code lost:
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x011b, code lost:
            monitor-enter(r21.this$0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x011c, code lost:
            r21.this$0.upstreamReader = null;
            r21.this$0.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x0127, code lost:
            throw r0;
         */
        @Override // okio.Source
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public long read(Buffer sink, long byteCount) throws IOException {
            int source;
            if (this.fileOperator == null) {
                throw new IllegalStateException("closed");
            }
            synchronized (Relay.this) {
                while (true) {
                    long j = this.sourcePos;
                    long upstreamPos = Relay.this.upstreamPos;
                    if (j != upstreamPos) {
                        long bufferPos = upstreamPos - Relay.this.buffer.size();
                        if (this.sourcePos >= bufferPos) {
                            long bytesToRead = Math.min(byteCount, upstreamPos - this.sourcePos);
                            Relay.this.buffer.copyTo(sink, this.sourcePos - bufferPos, bytesToRead);
                            this.sourcePos += bytesToRead;
                            return bytesToRead;
                        }
                        source = 2;
                    } else if (!Relay.this.complete) {
                        if (Relay.this.upstreamReader == null) {
                            Relay.this.upstreamReader = Thread.currentThread();
                            source = 1;
                            break;
                        }
                        this.timeout.waitUntilNotified(Relay.this);
                    } else {
                        return -1L;
                    }
                }
            }
        }

        @Override // okio.Source
        public Timeout timeout() {
            return this.timeout;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.fileOperator == null) {
                return;
            }
            this.fileOperator = null;
            RandomAccessFile fileToClose = null;
            synchronized (Relay.this) {
                Relay relay = Relay.this;
                relay.sourceCount--;
                if (Relay.this.sourceCount == 0) {
                    fileToClose = Relay.this.file;
                    Relay.this.file = null;
                }
            }
            if (fileToClose != null) {
                Util.closeQuietly(fileToClose);
            }
        }
    }
}
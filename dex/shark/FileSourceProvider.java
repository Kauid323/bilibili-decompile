package shark;

import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSource;
import okio.Okio;
import shark.RandomAccessSource;
import shark.SharkLog;

/* compiled from: FileSourceProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lshark/FileSourceProvider;", "Lshark/DualSourceProvider;", "file", "Ljava/io/File;", "(Ljava/io/File;)V", "openRandomAccessSource", "Lshark/RandomAccessSource;", "openStreamingSource", "Lokio/BufferedSource;", "shark-hprof"}, k = 1, mv = {1, 4, 1})
public final class FileSourceProvider implements DualSourceProvider {
    private final File file;

    public FileSourceProvider(File file) {
        Intrinsics.checkParameterIsNotNull(file, "file");
        this.file = file;
    }

    @Override // shark.StreamingSourceProvider
    public BufferedSource openStreamingSource() {
        BufferedSource buffer = Okio.buffer(Okio.source(new FileInputStream(this.file)));
        Intrinsics.checkExpressionValueIsNotNull(buffer, "Okio.buffer(Okio.source(file.inputStream()))");
        return buffer;
    }

    @Override // shark.RandomAccessSourceProvider
    public RandomAccessSource openRandomAccessSource() {
        final RandomAccessFile randomAccessFile = new RandomAccessFile(this.file, "r");
        final byte[] arrayBuffer = new byte[500000];
        return new RandomAccessSource() { // from class: shark.FileSourceProvider$openRandomAccessSource$1
            @Override // shark.RandomAccessSource
            public BufferedSource asStreamingSource() {
                return RandomAccessSource.DefaultImpls.asStreamingSource(this);
            }

            @Override // shark.RandomAccessSource
            public long read(Buffer sink, long position, long byteCount) {
                Intrinsics.checkParameterIsNotNull(sink, "sink");
                int byteCountInt = (int) byteCount;
                randomAccessFile.seek(position);
                int totalBytesRead = 0;
                int maxRead = arrayBuffer.length;
                while (true) {
                    if (totalBytesRead >= byteCount) {
                        break;
                    }
                    int toRead = Math.min(byteCountInt - totalBytesRead, maxRead);
                    int bytesRead = randomAccessFile.read(arrayBuffer, 0, toRead);
                    if (bytesRead == -1) {
                        if (!(totalBytesRead != 0)) {
                            throw new IllegalStateException("Did not expect to reach end of file after reading 0 bytes".toString());
                        }
                    } else {
                        sink.write(arrayBuffer, 0, bytesRead);
                        totalBytesRead += bytesRead;
                    }
                }
                return totalBytesRead;
            }

            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    randomAccessFile.close();
                } catch (Throwable ignored) {
                    SharkLog this_$iv = SharkLog.INSTANCE;
                    SharkLog.Logger logger$iv = this_$iv.getLogger();
                    if (logger$iv != null) {
                        logger$iv.d(ignored, "Failed to close file, ignoring");
                    }
                }
            }
        };
    }
}
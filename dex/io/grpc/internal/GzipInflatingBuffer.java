package io.grpc.internal;

import com.google.common.base.Preconditions;
import java.io.Closeable;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import java.util.zip.ZipException;

/* JADX INFO: Access modifiers changed from: package-private */
public class GzipInflatingBuffer implements Closeable {
    private static final int GZIP_HEADER_MIN_SIZE = 10;
    private static final int GZIP_MAGIC = 35615;
    private static final int GZIP_TRAILER_SIZE = 8;
    private static final int HEADER_COMMENT_FLAG = 16;
    private static final int HEADER_CRC_FLAG = 2;
    private static final int HEADER_EXTRA_FLAG = 4;
    private static final int HEADER_NAME_FLAG = 8;
    private static final int INFLATE_BUFFER_SIZE = 512;
    private static final int UNSIGNED_SHORT_SIZE = 2;
    private long expectedGzipTrailerIsize;
    private int gzipHeaderFlag;
    private int headerExtraToRead;
    private Inflater inflater;
    private int inflaterInputEnd;
    private int inflaterInputStart;
    private final CompositeReadableBuffer gzippedData = new CompositeReadableBuffer();
    private final CRC32 crc = new CRC32();
    private final GzipMetadataReader gzipMetadataReader = new GzipMetadataReader();
    private final byte[] inflaterInput = new byte[512];
    private State state = State.HEADER;
    private boolean closed = false;
    private int bytesConsumed = 0;
    private int deflatedBytesConsumed = 0;
    private boolean isStalled = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public enum State {
        HEADER,
        HEADER_EXTRA_LEN,
        HEADER_EXTRA,
        HEADER_NAME,
        HEADER_COMMENT,
        HEADER_CRC,
        INITIALIZE_INFLATER,
        INFLATING,
        INFLATER_NEEDS_INPUT,
        TRAILER
    }

    static /* synthetic */ int access$112(GzipInflatingBuffer x0, int x1) {
        int i2 = x0.inflaterInputStart + x1;
        x0.inflaterInputStart = i2;
        return i2;
    }

    static /* synthetic */ int access$512(GzipInflatingBuffer x0, int x1) {
        int i2 = x0.bytesConsumed + x1;
        x0.bytesConsumed = i2;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public class GzipMetadataReader {
        private GzipMetadataReader() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int readUnsignedByte() {
            int b;
            int bytesRemainingInInflaterInput = GzipInflatingBuffer.this.inflaterInputEnd - GzipInflatingBuffer.this.inflaterInputStart;
            if (bytesRemainingInInflaterInput > 0) {
                b = GzipInflatingBuffer.this.inflaterInput[GzipInflatingBuffer.this.inflaterInputStart] & 255;
                GzipInflatingBuffer.access$112(GzipInflatingBuffer.this, 1);
            } else {
                b = GzipInflatingBuffer.this.gzippedData.readUnsignedByte();
            }
            GzipInflatingBuffer.this.crc.update(b);
            GzipInflatingBuffer.access$512(GzipInflatingBuffer.this, 1);
            return b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void skipBytes(int length) {
            int bytesToSkip = length;
            int bytesRemainingInInflaterInput = GzipInflatingBuffer.this.inflaterInputEnd - GzipInflatingBuffer.this.inflaterInputStart;
            if (bytesRemainingInInflaterInput > 0) {
                int bytesToGetFromInflaterInput = Math.min(bytesRemainingInInflaterInput, bytesToSkip);
                GzipInflatingBuffer.this.crc.update(GzipInflatingBuffer.this.inflaterInput, GzipInflatingBuffer.this.inflaterInputStart, bytesToGetFromInflaterInput);
                GzipInflatingBuffer.access$112(GzipInflatingBuffer.this, bytesToGetFromInflaterInput);
                bytesToSkip -= bytesToGetFromInflaterInput;
            }
            if (bytesToSkip > 0) {
                byte[] buf = new byte[512];
                int total = 0;
                while (total < bytesToSkip) {
                    int toRead = Math.min(bytesToSkip - total, buf.length);
                    GzipInflatingBuffer.this.gzippedData.readBytes(buf, 0, toRead);
                    GzipInflatingBuffer.this.crc.update(buf, 0, toRead);
                    total += toRead;
                }
            }
            GzipInflatingBuffer.access$512(GzipInflatingBuffer.this, length);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int readableBytes() {
            return (GzipInflatingBuffer.this.inflaterInputEnd - GzipInflatingBuffer.this.inflaterInputStart) + GzipInflatingBuffer.this.gzippedData.readableBytes();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean readBytesUntilZero() {
            while (readableBytes() > 0) {
                if (readUnsignedByte() == 0) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int readUnsignedShort() {
            return readUnsignedByte() | (readUnsignedByte() << 8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long readUnsignedInt() {
            long s = readUnsignedShort();
            return (readUnsignedShort() << 16) | s;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isStalled() {
        Preconditions.checkState(!this.closed, "GzipInflatingBuffer is closed");
        return this.isStalled;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasPartialData() {
        Preconditions.checkState(!this.closed, "GzipInflatingBuffer is closed");
        return (this.gzipMetadataReader.readableBytes() == 0 && this.state == State.HEADER) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addGzippedBytes(ReadableBuffer buffer) {
        Preconditions.checkState(!this.closed, "GzipInflatingBuffer is closed");
        this.gzippedData.addBuffer(buffer);
        this.isStalled = false;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.closed) {
            this.closed = true;
            this.gzippedData.close();
            if (this.inflater != null) {
                this.inflater.end();
                this.inflater = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getAndResetBytesConsumed() {
        int savedBytesConsumed = this.bytesConsumed;
        this.bytesConsumed = 0;
        return savedBytesConsumed;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getAndResetDeflatedBytesConsumed() {
        int savedDeflatedBytesConsumed = this.deflatedBytesConsumed;
        this.deflatedBytesConsumed = 0;
        return savedDeflatedBytesConsumed;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int inflateBytes(byte[] b, int offset, int length) throws DataFormatException, ZipException {
        boolean z = true;
        Preconditions.checkState(!this.closed, "GzipInflatingBuffer is closed");
        int bytesRead = 0;
        boolean madeProgress = true;
        while (madeProgress) {
            int missingBytes = length - bytesRead;
            if (missingBytes > 0) {
                switch (this.state) {
                    case HEADER:
                        madeProgress = processHeader();
                        break;
                    case HEADER_EXTRA_LEN:
                        madeProgress = processHeaderExtraLen();
                        break;
                    case HEADER_EXTRA:
                        madeProgress = processHeaderExtra();
                        break;
                    case HEADER_NAME:
                        madeProgress = processHeaderName();
                        break;
                    case HEADER_COMMENT:
                        madeProgress = processHeaderComment();
                        break;
                    case HEADER_CRC:
                        madeProgress = processHeaderCrc();
                        break;
                    case INITIALIZE_INFLATER:
                        madeProgress = initializeInflater();
                        break;
                    case INFLATING:
                        bytesRead += inflate(b, offset + bytesRead, missingBytes);
                        if (this.state == State.TRAILER) {
                            madeProgress = processTrailer();
                            break;
                        } else {
                            madeProgress = true;
                            break;
                        }
                    case INFLATER_NEEDS_INPUT:
                        madeProgress = fill();
                        break;
                    case TRAILER:
                        madeProgress = processTrailer();
                        break;
                    default:
                        throw new AssertionError("Invalid state: " + this.state);
                }
            } else {
                if (madeProgress && (this.state != State.HEADER || this.gzipMetadataReader.readableBytes() >= 10)) {
                    z = false;
                }
                this.isStalled = z;
                return bytesRead;
            }
        }
        if (madeProgress) {
            z = false;
        }
        this.isStalled = z;
        return bytesRead;
    }

    private boolean processHeader() throws ZipException {
        if (this.gzipMetadataReader.readableBytes() >= 10) {
            if (this.gzipMetadataReader.readUnsignedShort() == GZIP_MAGIC) {
                if (this.gzipMetadataReader.readUnsignedByte() == 8) {
                    this.gzipHeaderFlag = this.gzipMetadataReader.readUnsignedByte();
                    this.gzipMetadataReader.skipBytes(6);
                    this.state = State.HEADER_EXTRA_LEN;
                    return true;
                }
                throw new ZipException("Unsupported compression method");
            }
            throw new ZipException("Not in GZIP format");
        }
        return false;
    }

    private boolean processHeaderExtraLen() {
        if ((this.gzipHeaderFlag & 4) == 4) {
            if (this.gzipMetadataReader.readableBytes() >= 2) {
                this.headerExtraToRead = this.gzipMetadataReader.readUnsignedShort();
                this.state = State.HEADER_EXTRA;
                return true;
            }
            return false;
        }
        this.state = State.HEADER_NAME;
        return true;
    }

    private boolean processHeaderExtra() {
        if (this.gzipMetadataReader.readableBytes() >= this.headerExtraToRead) {
            this.gzipMetadataReader.skipBytes(this.headerExtraToRead);
            this.state = State.HEADER_NAME;
            return true;
        }
        return false;
    }

    private boolean processHeaderName() {
        if ((this.gzipHeaderFlag & 8) == 8) {
            if (!this.gzipMetadataReader.readBytesUntilZero()) {
                return false;
            }
            this.state = State.HEADER_COMMENT;
            return true;
        }
        this.state = State.HEADER_COMMENT;
        return true;
    }

    private boolean processHeaderComment() {
        if ((this.gzipHeaderFlag & 16) == 16) {
            if (!this.gzipMetadataReader.readBytesUntilZero()) {
                return false;
            }
            this.state = State.HEADER_CRC;
            return true;
        }
        this.state = State.HEADER_CRC;
        return true;
    }

    private boolean processHeaderCrc() throws ZipException {
        if ((this.gzipHeaderFlag & 2) == 2) {
            if (this.gzipMetadataReader.readableBytes() < 2) {
                return false;
            }
            int desiredCrc16 = ((int) this.crc.getValue()) & 65535;
            if (desiredCrc16 != this.gzipMetadataReader.readUnsignedShort()) {
                throw new ZipException("Corrupt GZIP header");
            }
            this.state = State.INITIALIZE_INFLATER;
            return true;
        }
        this.state = State.INITIALIZE_INFLATER;
        return true;
    }

    private boolean initializeInflater() {
        if (this.inflater == null) {
            this.inflater = new Inflater(true);
        } else {
            this.inflater.reset();
        }
        this.crc.reset();
        int bytesRemainingInInflaterInput = this.inflaterInputEnd - this.inflaterInputStart;
        if (bytesRemainingInInflaterInput > 0) {
            this.inflater.setInput(this.inflaterInput, this.inflaterInputStart, bytesRemainingInInflaterInput);
            this.state = State.INFLATING;
        } else {
            this.state = State.INFLATER_NEEDS_INPUT;
        }
        return true;
    }

    private int inflate(byte[] b, int off, int len) throws DataFormatException, ZipException {
        Preconditions.checkState(this.inflater != null, "inflater is null");
        try {
            int inflaterTotalIn = this.inflater.getTotalIn();
            int n = this.inflater.inflate(b, off, len);
            int bytesConsumedDelta = this.inflater.getTotalIn() - inflaterTotalIn;
            this.bytesConsumed += bytesConsumedDelta;
            this.deflatedBytesConsumed += bytesConsumedDelta;
            this.inflaterInputStart += bytesConsumedDelta;
            this.crc.update(b, off, n);
            if (this.inflater.finished()) {
                this.expectedGzipTrailerIsize = this.inflater.getBytesWritten() & 4294967295L;
                this.state = State.TRAILER;
            } else if (this.inflater.needsInput()) {
                this.state = State.INFLATER_NEEDS_INPUT;
            }
            return n;
        } catch (DataFormatException e2) {
            throw new DataFormatException("Inflater data format exception: " + e2.getMessage());
        }
    }

    private boolean fill() {
        Preconditions.checkState(this.inflater != null, "inflater is null");
        Preconditions.checkState(this.inflaterInputStart == this.inflaterInputEnd, "inflaterInput has unconsumed bytes");
        int bytesToAdd = Math.min(this.gzippedData.readableBytes(), 512);
        if (bytesToAdd == 0) {
            return false;
        }
        this.inflaterInputStart = 0;
        this.inflaterInputEnd = bytesToAdd;
        this.gzippedData.readBytes(this.inflaterInput, this.inflaterInputStart, bytesToAdd);
        this.inflater.setInput(this.inflaterInput, this.inflaterInputStart, bytesToAdd);
        this.state = State.INFLATING;
        return true;
    }

    private boolean processTrailer() throws ZipException {
        if (this.inflater != null && this.gzipMetadataReader.readableBytes() <= 18) {
            this.inflater.end();
            this.inflater = null;
        }
        if (this.gzipMetadataReader.readableBytes() >= 8) {
            if (this.crc.getValue() != this.gzipMetadataReader.readUnsignedInt() || this.expectedGzipTrailerIsize != this.gzipMetadataReader.readUnsignedInt()) {
                throw new ZipException("Corrupt GZIP trailer");
            }
            this.crc.reset();
            this.state = State.HEADER;
            return true;
        }
        return false;
    }
}
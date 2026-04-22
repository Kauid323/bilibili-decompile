package tv.danmaku.android.log.cache;

import com.bilibili.lib.IOUtilsKt;
import com.bilibili.lib.blkv.MapByteBuffer;
import com.bilibili.lib.blkv.MapFile;
import com.bilibili.lib.blkv.MapFileKt;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: DayExpiredCache.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 #2\u00020\u0001:\u0002\"#B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\u0010\rJ\u000e\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u000bJ\u000e\u0010 \u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u000bJ\u0006\u0010!\u001a\u00020\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00038B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00038B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0018¨\u0006$"}, d2 = {"Ltv/danmaku/android/log/cache/Meta;", "", "blockAmount", "", "pageAmountInBlock", "file", "Ljava/io/File;", "useLollipopAPI", "", "blockConsumer", "Lkotlin/Function1;", "Ltv/danmaku/android/log/cache/Meta$Block;", "", "(IILjava/io/File;ZLkotlin/jvm/functions/Function1;)V", "getBlockAmount", "()I", "getBlockConsumer", "()Lkotlin/jvm/functions/Function1;", "buffer", "Lcom/bilibili/lib/blkv/MapByteBuffer;", "value", "id", "getId", "setId", "(I)V", "queue", "Ljava/util/concurrent/LinkedBlockingQueue;", "submitId", "getSubmitId", "setSubmitId", "onBlockFlush", "block", "recycle", "take", "Block", "Companion", "blog_android_release"}, k = 1, mv = {1, 9, 0}, xi = BR.badgeVisibility)
public final class Meta {
    private final int blockAmount;
    private final Function1<Block, Unit> blockConsumer;
    private final MapByteBuffer buffer;
    private final LinkedBlockingQueue<Block> queue;
    public static final Companion Companion = new Companion(null);
    private static final byte[] MAGIC = {66, 76, 79, 71};
    private static final int HEAD_SIZE = MapByteBuffer.Companion.getPAGE_SIZE();

    /* JADX WARN: Multi-variable type inference failed */
    public Meta(int blockAmount, int pageAmountInBlock, File file, boolean useLollipopAPI, Function1<? super Block, Unit> function1) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(function1, "blockConsumer");
        this.blockAmount = blockAmount;
        this.blockConsumer = function1;
        this.queue = new LinkedBlockingQueue<>();
        int blockSize = Companion.computeBlockSize(pageAmountInBlock);
        int metaSize = (this.blockAmount * blockSize) + HEAD_SIZE;
        MapFile mapFile = (Closeable) MapFileKt.toMapFile$default(file, false, 1, (Object) null);
        try {
            MapFile it = mapFile;
            int sz = it.getSize();
            if (sz < metaSize) {
                try {
                    it.allocate(sz, metaSize - sz, useLollipopAPI);
                } catch (Throwable th) {
                    th = th;
                    IOUtilsKt.closeQuietly(mapFile);
                    throw th;
                }
            }
            MapByteBuffer map$default = MapFile.map$default(it, 0, metaSize, false, 4, (Object) null);
            IOUtilsKt.closeQuietly(mapFile);
            this.buffer = map$default;
            this.buffer.clear().write(MAGIC);
            int id = getId();
            int submitId = getSubmitId();
            if (id == submitId) {
                int i = this.blockAmount;
                int i2 = 0;
                while (i2 < i) {
                    int blockId = (i2 + id) % this.blockAmount;
                    int offset = HEAD_SIZE + (blockId * blockSize);
                    this.queue.offer(new Block(blockId, offset, blockSize, this.buffer, this));
                    i2++;
                    metaSize = metaSize;
                }
                return;
            }
            while (true) {
                int blockId2 = id;
                int offset2 = HEAD_SIZE + (blockId2 * blockSize);
                this.queue.offer(new Block(blockId2, offset2, blockSize, this.buffer, this));
                id = (id + 1) % this.blockAmount;
                if (id == submitId) {
                    break;
                }
            }
            while (true) {
                int blockId3 = submitId;
                int offset3 = HEAD_SIZE + (blockId3 * blockSize);
                int id2 = id;
                this.blockConsumer.invoke(new Block(blockId3, offset3, blockSize, this.buffer, this));
                submitId = (submitId + 1) % this.blockAmount;
                if (submitId == id) {
                    return;
                }
                id = id2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final int getBlockAmount() {
        return this.blockAmount;
    }

    public final Function1<Block, Unit> getBlockConsumer() {
        return this.blockConsumer;
    }

    private final int getId() {
        int value = this.buffer.readInt(4);
        boolean z = false;
        if (value >= 0 && value < this.blockAmount) {
            z = true;
        }
        if (!z) {
            return 0;
        }
        return value;
    }

    private final void setId(int value) {
        this.buffer.writeInt(4, value);
    }

    private final int getSubmitId() {
        int value = this.buffer.readInt(8);
        boolean z = false;
        if (value >= 0 && value < this.blockAmount) {
            z = true;
        }
        if (!z) {
            return getId();
        }
        return value;
    }

    private final void setSubmitId(int value) {
        this.buffer.writeInt(8, value);
    }

    public final void onBlockFlush(Block block) {
        Intrinsics.checkNotNullParameter(block, "block");
        setId(block.getId() + 1);
        this.blockConsumer.invoke(block);
    }

    public final void recycle(Block block) {
        Intrinsics.checkNotNullParameter(block, "block");
        setSubmitId(block.getId() + 1);
        block.reset();
        this.queue.offer(block);
    }

    public final Block take() {
        Block poll = this.queue.poll(300L, TimeUnit.MILLISECONDS);
        Block $this$take_u24lambda_u241 = poll;
        if ($this$take_u24lambda_u241 != null) {
            Intrinsics.checkNotNullExpressionValue(poll, "apply(...)");
            return poll;
        }
        throw new IOException("poll over 300ms, skip it");
    }

    /* compiled from: DayExpiredCache.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004J:\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0018"}, d2 = {"Ltv/danmaku/android/log/cache/Meta$Companion;", "", "()V", "HEAD_SIZE", "", "getHEAD_SIZE", "()I", "MAGIC", "", "getMAGIC", "()[B", "computeBlockSize", "pageAmountInBlock", "newMeta", "Ltv/danmaku/android/log/cache/Meta;", "blockAmount", "file", "Ljava/io/File;", "useLollipopAPI", "", "blockConsumer", "Lkotlin/Function1;", "Ltv/danmaku/android/log/cache/Meta$Block;", "", "blog_android_release"}, k = 1, mv = {1, 9, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final byte[] getMAGIC() {
            return Meta.MAGIC;
        }

        public final int getHEAD_SIZE() {
            return Meta.HEAD_SIZE;
        }

        public final int computeBlockSize(int pageAmountInBlock) {
            return MapByteBuffer.Companion.getPAGE_SIZE() * pageAmountInBlock;
        }

        public final Meta newMeta(int blockAmount, int pageAmountInBlock, File file, boolean useLollipopAPI, Function1<? super Block, Unit> function1) {
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(function1, "blockConsumer");
            return new Meta(blockAmount, pageAmountInBlock, file, useLollipopAPI, function1);
        }
    }

    /* compiled from: DayExpiredCache.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001e\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001bJ\u000e\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u0010J\u0006\u0010\u001f\u001a\u00020\u001bJ\b\u0010 \u001a\u00020!H\u0016R\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0012¨\u0006\""}, d2 = {"Ltv/danmaku/android/log/cache/Meta$Block;", "", "id", "", "offset", "length", "buffer", "Lcom/bilibili/lib/blkv/MapByteBuffer;", "owner", "Ltv/danmaku/android/log/cache/Meta;", "(IIILcom/bilibili/lib/blkv/MapByteBuffer;Ltv/danmaku/android/log/cache/Meta;)V", "allBytes", "", "getAllBytes", "()[B", "externalLock", "Ljava/util/concurrent/CountDownLatch;", "getId", "()I", "position", "remaining", "getRemaining", "append", "b", "off", "len", "recycle", "", "reset", "setLatch", "flushLock", "syncSize", "toString", "", "blog_android_release"}, k = 1, mv = {1, 9, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Block {
        private final MapByteBuffer buffer;
        private CountDownLatch externalLock;
        private final int id;
        private final int length;
        private final int offset;
        private final Meta owner;
        private int position;

        public Block(int id, int offset, int length, MapByteBuffer buffer, Meta owner) {
            Intrinsics.checkNotNullParameter(buffer, "buffer");
            Intrinsics.checkNotNullParameter(owner, "owner");
            this.id = id;
            this.offset = offset;
            this.length = length;
            this.buffer = buffer;
            this.owner = owner;
            this.position = 8;
            boolean z = true;
            this.buffer.writeInt(this.offset, 1);
            int sz = this.buffer.readInt(this.offset + 4);
            if ((sz < 0 || sz > this.length - 8) ? false : z) {
                this.position += sz;
            } else {
                reset();
            }
        }

        public final int getId() {
            return this.id;
        }

        public final byte[] getAllBytes() {
            byte[] $this$_get_allBytes__u24lambda_u240 = new byte[this.position - 8];
            this.buffer.read(this.offset + 8, $this$_get_allBytes__u24lambda_u240);
            return $this$_get_allBytes__u24lambda_u240;
        }

        public final int getRemaining() {
            return this.length - this.position;
        }

        public final void setLatch(CountDownLatch flushLock) {
            Intrinsics.checkNotNullParameter(flushLock, "flushLock");
            this.externalLock = flushLock;
        }

        public final void recycle() {
            this.owner.recycle(this);
            CountDownLatch it = this.externalLock;
            if (it != null) {
                it.countDown();
                this.externalLock = null;
            }
        }

        public final int append(byte[] b, int off, int len) {
            Intrinsics.checkNotNullParameter(b, "b");
            int doWrite = Math.min(getRemaining(), len);
            if (doWrite > 0) {
                this.buffer.write(this.offset + this.position, b, off, doWrite);
                this.position += doWrite;
            }
            return doWrite;
        }

        public final void syncSize() {
            this.buffer.writeInt(this.offset + 4, this.position - 8);
        }

        public String toString() {
            return "Block(id=" + this.id + ",remain=" + getRemaining() + ')';
        }

        public final void reset() {
            this.position = 8;
            this.buffer.writeInt(this.offset + 4, 0);
        }
    }
}
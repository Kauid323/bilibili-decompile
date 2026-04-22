package kotlinx.serialization.protobuf.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationException;

/* compiled from: ProtobufTaggedBase.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\f\u0010\u0010\u001a\u00060\u0004j\u0002`\u0005H\u0004J\f\u0010\u0011\u001a\u00060\u0004j\u0002`\u0005H\u0004J\u0014\u0010\u0012\u001a\u00020\u000f2\n\u0010\u0013\u001a\u00060\u0004j\u0002`\u0005H\u0004J1\u0010\u0014\u001a\u0002H\u0015\"\u0004\b\u0000\u0010\u00152\n\u0010\u0013\u001a\u00060\u0004j\u0002`\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0017H\u0084\bø\u0001\u0000¢\u0006\u0002\u0010\u0018R\u0018\u0010\u0003\u001a\u00060\u0004j\u0002`\u00058DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00060\u0004j\u0002`\u00058DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0012\u0010\n\u001a\u00020\u000b8\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0019"}, d2 = {"Lkotlinx/serialization/protobuf/internal/ProtobufTaggedBase;", "", "()V", "currentTag", "", "Lkotlinx/serialization/protobuf/internal/ProtoDesc;", "getCurrentTag", "()J", "currentTagOrDefault", "getCurrentTagOrDefault", "stackSize", "", "tagsStack", "", "expand", "", "popTag", "popTagOrDefault", "pushTag", "tag", "tagBlock", "E", "block", "Lkotlin/Function0;", "(JLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "kotlinx-serialization-protobuf"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class ProtobufTaggedBase {
    private long[] tagsStack = new long[8];
    protected int stackSize = -1;

    /* JADX INFO: Access modifiers changed from: protected */
    public final long getCurrentTag() {
        return this.tagsStack[this.stackSize];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long getCurrentTagOrDefault() {
        return this.stackSize == -1 ? ProtobufTaggedBaseKt.MISSING_TAG : this.tagsStack[this.stackSize];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long popTagOrDefault() {
        if (this.stackSize == -1) {
            return ProtobufTaggedBaseKt.MISSING_TAG;
        }
        long[] jArr = this.tagsStack;
        int i = this.stackSize;
        this.stackSize = i - 1;
        return jArr[i];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void pushTag(long tag) {
        if (tag == ProtobufTaggedBaseKt.MISSING_TAG) {
            return;
        }
        this.stackSize++;
        int idx = this.stackSize;
        if (this.stackSize >= this.tagsStack.length) {
            expand();
        }
        this.tagsStack[idx] = tag;
    }

    private final void expand() {
        long[] copyOf = Arrays.copyOf(this.tagsStack, this.tagsStack.length * 2);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        this.tagsStack = copyOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long popTag() {
        if (this.stackSize >= 0) {
            long[] jArr = this.tagsStack;
            int i = this.stackSize;
            this.stackSize = i - 1;
            return jArr[i];
        }
        throw new SerializationException("No tag in stack for requested element");
    }

    protected final <E> E tagBlock(long tag, Function0<? extends E> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        pushTag(tag);
        return block.invoke();
    }
}
package kotlinx.serialization.json.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.StructureKind;

/* compiled from: JsonPath.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\rJ\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0002J\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\rJ\b\u0010\u0014\u001a\u00020\rH\u0002J\b\u0010\u0015\u001a\u00020\u000bH\u0016J\u0010\u0010\u0016\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001J\u000e\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lkotlinx/serialization/json/internal/JsonPath;", "", "()V", "currentDepth", "", "currentObjectPath", "", "[Ljava/lang/Object;", "indicies", "", "getPath", "", "popDescriptor", "", "prettyString", "it", "pushDescriptor", "sd", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "resetCurrentMapKey", "resize", "toString", "updateCurrentMapKey", "key", "updateDescriptorIndex", "index", "Tombstone", "kotlinx-serialization-json"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class JsonPath {
    private int currentDepth;
    private Object[] currentObjectPath = new Object[8];
    private int[] indicies;

    public JsonPath() {
        int[] iArr = new int[8];
        for (int i = 0; i < 8; i++) {
            iArr[i] = -1;
        }
        this.indicies = iArr;
        this.currentDepth = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: JsonPath.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lkotlinx/serialization/json/internal/JsonPath$Tombstone;", "", "()V", "kotlinx-serialization-json"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Tombstone {
        public static final Tombstone INSTANCE = new Tombstone();

        private Tombstone() {
        }
    }

    public final void pushDescriptor(SerialDescriptor sd) {
        Intrinsics.checkNotNullParameter(sd, "sd");
        this.currentDepth++;
        int depth = this.currentDepth;
        if (depth == this.currentObjectPath.length) {
            resize();
        }
        this.currentObjectPath[depth] = sd;
    }

    public final void updateDescriptorIndex(int index) {
        this.indicies[this.currentDepth] = index;
    }

    public final void updateCurrentMapKey(Object key) {
        if (this.indicies[this.currentDepth] != -2) {
            this.currentDepth++;
            if (this.currentDepth == this.currentObjectPath.length) {
                resize();
            }
        }
        this.currentObjectPath[this.currentDepth] = key;
        this.indicies[this.currentDepth] = -2;
    }

    public final void resetCurrentMapKey() {
        if (this.indicies[this.currentDepth] == -2) {
            this.currentObjectPath[this.currentDepth] = Tombstone.INSTANCE;
        }
    }

    public final void popDescriptor() {
        int depth = this.currentDepth;
        if (this.indicies[depth] == -2) {
            this.indicies[depth] = -1;
            this.currentDepth--;
        }
        if (this.currentDepth != -1) {
            this.currentDepth--;
        }
    }

    public final String getPath() {
        StringBuilder $this$getPath_u24lambda_u241 = new StringBuilder();
        $this$getPath_u24lambda_u241.append("$");
        int i = this.currentDepth + 1;
        for (int i2 = 0; i2 < i; i2++) {
            int it = i2;
            Object element = this.currentObjectPath[it];
            if (element instanceof SerialDescriptor) {
                if (Intrinsics.areEqual(((SerialDescriptor) element).getKind(), StructureKind.LIST.INSTANCE)) {
                    if (this.indicies[it] != -1) {
                        $this$getPath_u24lambda_u241.append("[");
                        $this$getPath_u24lambda_u241.append(this.indicies[it]);
                        $this$getPath_u24lambda_u241.append("]");
                    }
                } else {
                    int idx = this.indicies[it];
                    if (idx >= 0) {
                        $this$getPath_u24lambda_u241.append(".");
                        $this$getPath_u24lambda_u241.append(((SerialDescriptor) element).getElementName(idx));
                    }
                }
            } else if (element != Tombstone.INSTANCE) {
                $this$getPath_u24lambda_u241.append("[");
                $this$getPath_u24lambda_u241.append("'");
                $this$getPath_u24lambda_u241.append(element);
                $this$getPath_u24lambda_u241.append("'");
                $this$getPath_u24lambda_u241.append("]");
            }
        }
        String sb = $this$getPath_u24lambda_u241.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "StringBuilder().apply(builderAction).toString()");
        return sb;
    }

    private final String prettyString(Object it) {
        String serialName;
        SerialDescriptor serialDescriptor = it instanceof SerialDescriptor ? (SerialDescriptor) it : null;
        return (serialDescriptor == null || (serialName = serialDescriptor.getSerialName()) == null) ? String.valueOf(it) : serialName;
    }

    private final void resize() {
        int newSize = this.currentDepth * 2;
        Object[] copyOf = Arrays.copyOf(this.currentObjectPath, newSize);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        this.currentObjectPath = copyOf;
        int[] copyOf2 = Arrays.copyOf(this.indicies, newSize);
        Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(this, newSize)");
        this.indicies = copyOf2;
    }

    public String toString() {
        return getPath();
    }
}
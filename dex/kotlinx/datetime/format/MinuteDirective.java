package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.UnsignedFieldSpec;
import kotlinx.datetime.internal.format.UnsignedIntFieldFormatDirective;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LocalTimeFormat.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkotlinx/datetime/format/MinuteDirective;", "Lkotlinx/datetime/internal/format/UnsignedIntFieldFormatDirective;", "Lkotlinx/datetime/format/TimeFieldContainer;", "padding", "Lkotlinx/datetime/format/Padding;", "(Lkotlinx/datetime/format/Padding;)V", "builderRepresentation", "", "getBuilderRepresentation", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MinuteDirective extends UnsignedIntFieldFormatDirective<TimeFieldContainer> {
    private final Padding padding;

    /* compiled from: LocalTimeFormat.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Padding.values().length];
            try {
                iArr[Padding.ZERO.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MinuteDirective(Padding padding) {
        super(r0, width$iv, padding == Padding.SPACE ? 2 : null);
        Intrinsics.checkNotNullParameter(padding, "padding");
        UnsignedFieldSpec<TimeFieldContainer> minute = TimeFields.INSTANCE.getMinute();
        int width$iv = padding != Padding.ZERO ? 1 : 2;
        this.padding = padding;
    }

    @Override // kotlinx.datetime.internal.format.FieldFormatDirective
    public String getBuilderRepresentation() {
        return WhenMappings.$EnumSwitchMapping$0[this.padding.ordinal()] == 1 ? "minute()" : "minute(" + DateTimeFormatKt.toKotlinCode(this.padding) + ')';
    }

    public boolean equals(Object other) {
        return (other instanceof MinuteDirective) && this.padding == ((MinuteDirective) other).padding;
    }

    public int hashCode() {
        return this.padding.hashCode();
    }
}
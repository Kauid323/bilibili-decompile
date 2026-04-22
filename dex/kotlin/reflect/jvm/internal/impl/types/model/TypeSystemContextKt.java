package kotlin.reflect.jvm.internal.impl.types.model;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* compiled from: TypeSystemContext.kt */
public final class TypeSystemContextKt {

    /* compiled from: TypeSystemContext.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Variance.values().length];
            try {
                iArr[Variance.INVARIANT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Variance.IN_VARIANCE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[Variance.OUT_VARIANCE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final TypeVariance convertVariance(Variance $this$convertVariance) {
        Intrinsics.checkNotNullParameter($this$convertVariance, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[$this$convertVariance.ordinal()]) {
            case 1:
                return TypeVariance.INV;
            case 2:
                return TypeVariance.IN;
            case 3:
                return TypeVariance.OUT;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
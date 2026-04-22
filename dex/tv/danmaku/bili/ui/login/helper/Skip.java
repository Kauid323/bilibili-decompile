package tv.danmaku.bili.ui.login.helper;

import BottomSheetItemData$;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tv.danmaku.bili.BR;

/* compiled from: QuickLoginHelper.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087@\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0014"}, d2 = {"Ltv/danmaku/bili/ui/login/helper/Skip;", "", "value", "", "constructor-impl", "(Z)Z", "getValue", "()Z", "equals", "other", "equals-impl", "(ZLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Z)I", "toString", "", "toString-impl", "(Z)Ljava/lang/String;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@JvmInline
public final class Skip {
    private final boolean value;

    /* renamed from: box-impl */
    public static final /* synthetic */ Skip m1805boximpl(boolean z) {
        return new Skip(z);
    }

    /* renamed from: constructor-impl */
    public static boolean m1806constructorimpl(boolean z) {
        return z;
    }

    /* renamed from: equals-impl */
    public static boolean m1808equalsimpl(boolean z, Object obj) {
        return (obj instanceof Skip) && z == ((Skip) obj).m1812unboximpl();
    }

    /* renamed from: equals-impl0 */
    public static final boolean m1809equalsimpl0(boolean z, boolean z2) {
        return z == z2;
    }

    /* renamed from: hashCode-impl */
    public static int m1810hashCodeimpl(boolean z) {
        return BottomSheetItemData$.ExternalSyntheticBackport0.m(z);
    }

    /* renamed from: toString-impl */
    public static String m1811toStringimpl(boolean z) {
        return "Skip(value=" + z + ")";
    }

    public boolean equals(Object obj) {
        return m1808equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1810hashCodeimpl(this.value);
    }

    public String toString() {
        return m1811toStringimpl(this.value);
    }

    /* renamed from: unbox-impl */
    public final /* synthetic */ boolean m1812unboximpl() {
        return this.value;
    }

    private /* synthetic */ Skip(boolean value) {
        this.value = value;
    }

    /* renamed from: constructor-impl$default */
    public static /* synthetic */ boolean m1807constructorimpl$default(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            z = false;
        }
        return m1806constructorimpl(z);
    }

    public final boolean getValue() {
        return this.value;
    }
}
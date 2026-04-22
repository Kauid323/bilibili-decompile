package tv.danmaku.bili.freedata.internal.track;

import com.bilibili.lib.tf.TfTypeExt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;

/* compiled from: TfTrackModelAdapter.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"getTypeString", "", "typeExt", "Lcom/bilibili/lib/tf/TfTypeExt;", "network-ignet-ctr_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class TfTrackModelAdapterKt {

    /* compiled from: TfTrackModelAdapter.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TfTypeExt.values().length];
            try {
                iArr[TfTypeExt.U_CARD.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[TfTypeExt.U_PKG.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[TfTypeExt.C_CARD.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[TfTypeExt.C_PKG.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[TfTypeExt.T_CARD.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[TfTypeExt.T_PKG.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final String getTypeString(TfTypeExt typeExt) {
        Intrinsics.checkNotNullParameter(typeExt, "typeExt");
        switch (WhenMappings.$EnumSwitchMapping$0[typeExt.ordinal()]) {
            case 1:
                return "uc";
            case 2:
                return FavoritesConstsKt.CLEAR_INVALID_UP;
            case 3:
                return "mc";
            case 4:
                return "mp";
            case 5:
                return "tc";
            case 6:
                return "tp";
            default:
                return "unknown";
        }
    }
}
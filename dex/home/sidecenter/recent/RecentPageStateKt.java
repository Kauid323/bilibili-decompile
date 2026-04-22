package home.sidecenter.recent;

import com.bapis.bilibili.app.home.v1.KRecType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RecentPageState.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"titleFirst", "", "Lcom/bapis/bilibili/app/home/v1/KRecType;", "getTitleFirst", "(Lcom/bapis/bilibili/app/home/v1/KRecType;)Z", "sidecenter_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class RecentPageStateKt {
    public static final boolean getTitleFirst(KRecType $this$titleFirst) {
        Intrinsics.checkNotNullParameter($this$titleFirst, "<this>");
        if (Intrinsics.areEqual($this$titleFirst, KRecType.REC_TYPE_UGC.INSTANCE) || Intrinsics.areEqual($this$titleFirst, KRecType.REC_TYPE_OGV.INSTANCE)) {
            return true;
        }
        return (Intrinsics.areEqual($this$titleFirst, KRecType.REC_TYPE_SEASON.INSTANCE) || Intrinsics.areEqual($this$titleFirst, KRecType.REC_TYPE_FAV_FOLDER.INSTANCE)) ? false : true;
    }
}
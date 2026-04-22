package tv.danmaku.bili.ui.main2.mine.modularvip;

import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: MineVipModel.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0000H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/modularvip/IMineVipEnumModel;", "", "controlledByFrequency", "", "getControlledByFrequency", "()Z", "onRollback", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface IMineVipEnumModel {
    boolean getControlledByFrequency();

    IMineVipEnumModel onRollback();
}
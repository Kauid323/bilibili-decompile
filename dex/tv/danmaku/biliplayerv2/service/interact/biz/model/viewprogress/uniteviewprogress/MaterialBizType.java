package tv.danmaku.biliplayerv2.service.interact.biz.model.viewprogress.uniteviewprogress;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: VideoGuide.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/model/viewprogress/uniteviewprogress/MaterialBizType;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "ACTIVITY", "BGM", "EFFECT", "SHOOT_SAME", "SHOOT_TOGETHER", "ACTIVITY_ICON", "NEW_BGM", "GENERAL_TYPE", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public enum MaterialBizType {
    NONE,
    ACTIVITY,
    BGM,
    EFFECT,
    SHOOT_SAME,
    SHOOT_TOGETHER,
    ACTIVITY_ICON,
    NEW_BGM,
    GENERAL_TYPE;
    
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<MaterialBizType> getEntries() {
        return $ENTRIES;
    }
}
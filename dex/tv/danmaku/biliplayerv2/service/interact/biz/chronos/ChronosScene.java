package tv.danmaku.biliplayerv2.service.interact.biz.chronos;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkCpuInfo;

/* compiled from: ChronosScene.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/ChronosScene;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "SCENE_UNKNOWN", "SCENE_UGC_DETAIL_OLD", "SCENE_DETAIL", "SCENE_PEGASUS_INLINE_OLD", "SCENE_PEGASUS_INLINE_NEW", "SCENE_BAIKE_INLINE", "SCENE_DYNAMIC_INLINE_OLD", "SCENE_DYNAMIC_INLINE_NEW", "SCENE_VIDEO_PLAYLIST", "SCENE_SEARCH_INLINE", "SCENE_OGV_INLINE", "SCENE_STORY", "SCENE_STORY_SHORTCUT", "SCENE_OFFLINE", "SCENE_TOPIC", "SCENE_RECORD", "SCENE_TOGETHER_WATCH", "SCENE_GAME_FEED", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public enum ChronosScene {
    SCENE_UNKNOWN(0),
    SCENE_UGC_DETAIL_OLD(10),
    SCENE_DETAIL(11),
    SCENE_PEGASUS_INLINE_OLD(20),
    SCENE_PEGASUS_INLINE_NEW(21),
    SCENE_BAIKE_INLINE(22),
    SCENE_DYNAMIC_INLINE_OLD(30),
    SCENE_DYNAMIC_INLINE_NEW(31),
    SCENE_VIDEO_PLAYLIST(40),
    SCENE_SEARCH_INLINE(50),
    SCENE_OGV_INLINE(60),
    SCENE_STORY(70),
    SCENE_STORY_SHORTCUT(71),
    SCENE_OFFLINE(80),
    SCENE_TOPIC(90),
    SCENE_RECORD(100),
    SCENE_TOGETHER_WATCH(IjkCpuInfo.CPU_PART_SNAPDRAGON_S4_PRO),
    SCENE_GAME_FEED(130);
    
    private final int value;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<ChronosScene> getEntries() {
        return $ENTRIES;
    }

    ChronosScene(int value) {
        this.value = value;
    }

    public final int getValue() {
        return this.value;
    }
}
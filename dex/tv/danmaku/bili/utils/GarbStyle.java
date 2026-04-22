package tv.danmaku.bili.utils;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: GarbExtensions.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bp\u0018\u00002\u00020\u0001:\u0001\u0002ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0003À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/utils/GarbStyle;", "", "Mine", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface GarbStyle {

    /* compiled from: GarbExtensions.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Ltv/danmaku/bili/utils/GarbStyle$Mine;", "", "<init>", "(Ljava/lang/String;I)V", "PURE_WHITE", "COLORFUL", "NIGHT_NO_DRESS", "DAY_DRESS_LIGHT", "DAY_DRESS_DARK", "NIGHT_DRESS_LIGHT", "NIGHT_DRESS_DARK", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public enum Mine {
        PURE_WHITE,
        COLORFUL,
        NIGHT_NO_DRESS,
        DAY_DRESS_LIGHT,
        DAY_DRESS_DARK,
        NIGHT_DRESS_LIGHT,
        NIGHT_DRESS_DARK;
        
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<Mine> getEntries() {
            return $ENTRIES;
        }
    }
}
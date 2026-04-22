package tv.danmaku.bili.ui.garb;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tv.danmaku.bili.BR;

/* compiled from: NftCardDialog.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Ltv/danmaku/bili/ui/garb/NftCardFromType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "DETAIL", "SEE", "DRAW", "SCAN", "EXCHANGE", "COMMENT_BG", "TASK", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public enum NftCardFromType {
    DETAIL(-1),
    SEE(0),
    DRAW(1),
    SCAN(2),
    EXCHANGE(3),
    COMMENT_BG(4),
    TASK(5);
    
    private final int type;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);
    public static final Companion Companion = new Companion(null);

    public static EnumEntries<NftCardFromType> getEntries() {
        return $ENTRIES;
    }

    NftCardFromType(int type) {
        this.type = type;
    }

    public final int getType() {
        return this.type;
    }

    /* compiled from: NftCardDialog.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/ui/garb/NftCardFromType$Companion;", "", "<init>", "()V", "toType", "Ltv/danmaku/bili/ui/garb/NftCardFromType;", "type", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final NftCardFromType toType(int type) {
            switch (type) {
                case -1:
                    return NftCardFromType.DETAIL;
                case 0:
                default:
                    return NftCardFromType.SEE;
                case 1:
                    return NftCardFromType.DRAW;
                case 2:
                    return NftCardFromType.SCAN;
                case 3:
                    return NftCardFromType.EXCHANGE;
                case 4:
                    return NftCardFromType.COMMENT_BG;
                case 5:
                    return NftCardFromType.TASK;
            }
        }
    }
}
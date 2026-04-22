package kntr.app.game.bean;

import java.util.Iterator;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SteamDetailBean.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\u0081\u0002\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0017B\u001b\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0012\u001a\u00020\u0005J\u0006\u0010\u0013\u001a\u00020\u0005J\u0006\u0010\u0014\u001a\u00020\u0005J\u0006\u0010\u0015\u001a\u00020\u0005J\u0006\u0010\u0016\u001a\u00020\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0018"}, d2 = {"Lkntr/app/game/bean/SteamGameListSortType;", RoomRecommendViewModel.EMPTY_CURSOR, "type", RoomRecommendViewModel.EMPTY_CURSOR, "asc", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;IIZ)V", "getType", "()I", "getAsc", "()Z", "TotalTime", "Last2Weeks", "Achievements", "TotalTimeASC", "Last2WeeksASC", "AchievementsASC", "isAsc", "isTotalTime", "isLast2Weeks", "isAchievements", "opposite", "Companion", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum SteamGameListSortType {
    TotalTime(1, false),
    Last2Weeks(2, false),
    Achievements(3, false),
    TotalTimeASC(1, true),
    Last2WeeksASC(2, true),
    AchievementsASC(3, true);
    
    private final boolean asc;
    private final int type;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);
    public static final Companion Companion = new Companion(null);

    public static EnumEntries<SteamGameListSortType> getEntries() {
        return $ENTRIES;
    }

    SteamGameListSortType(int type, boolean asc) {
        this.type = type;
        this.asc = asc;
    }

    /* synthetic */ SteamGameListSortType(int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? false : z);
    }

    public final int getType() {
        return this.type;
    }

    public final boolean getAsc() {
        return this.asc;
    }

    public final boolean isAsc() {
        return this.asc;
    }

    public final boolean isTotalTime() {
        return this.type == 1;
    }

    public final boolean isLast2Weeks() {
        return this.type == 2;
    }

    public final boolean isAchievements() {
        return this.type == 3;
    }

    public final SteamGameListSortType opposite() {
        return Companion.fromInt(this.type, !this.asc);
    }

    /* compiled from: SteamDetailBean.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lkntr/app/game/bean/SteamGameListSortType$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "fromInt", "Lkntr/app/game/bean/SteamGameListSortType;", "value", RoomRecommendViewModel.EMPTY_CURSOR, "asc", RoomRecommendViewModel.EMPTY_CURSOR, "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ SteamGameListSortType fromInt$default(Companion companion, int i, boolean z, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                z = false;
            }
            return companion.fromInt(i, z);
        }

        public final SteamGameListSortType fromInt(int value, boolean asc) {
            Object element$iv;
            boolean z;
            Iterable $this$firstOrNull$iv = SteamGameListSortType.getEntries();
            Iterator it = $this$firstOrNull$iv.iterator();
            while (true) {
                if (it.hasNext()) {
                    element$iv = it.next();
                    SteamGameListSortType it2 = (SteamGameListSortType) element$iv;
                    if (it2.getType() == value && it2.getAsc() == asc) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (z) {
                        break;
                    }
                } else {
                    element$iv = null;
                    break;
                }
            }
            SteamGameListSortType steamGameListSortType = (SteamGameListSortType) element$iv;
            return steamGameListSortType == null ? SteamGameListSortType.TotalTime : steamGameListSortType;
        }
    }
}
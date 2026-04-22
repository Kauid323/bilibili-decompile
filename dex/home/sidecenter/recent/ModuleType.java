package home.sidecenter.recent;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* compiled from: Content.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lhome/sidecenter/recent/ModuleType;", "", "recommendType", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getRecommendType$annotations", "()V", "getRecommendType", "()Ljava/lang/String;", "Video", "ToView", "Fav", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum ModuleType {
    Video("unfinished"),
    ToView("watchlater"),
    Fav("favorite");
    
    private final String recommendType;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<ModuleType> getEntries() {
        return $ENTRIES;
    }

    public static /* synthetic */ void getRecommendType$annotations() {
    }

    ModuleType(String recommendType) {
        this.recommendType = recommendType;
    }

    public final String getRecommendType() {
        return this.recommendType;
    }
}
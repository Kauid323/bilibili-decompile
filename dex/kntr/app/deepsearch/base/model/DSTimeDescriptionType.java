package kntr.app.deepsearch.base.model;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* compiled from: DSTimeDescription.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lkntr/app/deepsearch/base/model/DSTimeDescriptionType;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;I)V", "Null", "Today", "Week", "Month", "Earlier", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum DSTimeDescriptionType {
    Null,
    Today,
    Week,
    Month,
    Earlier;
    
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<DSTimeDescriptionType> getEntries() {
        return $ENTRIES;
    }
}
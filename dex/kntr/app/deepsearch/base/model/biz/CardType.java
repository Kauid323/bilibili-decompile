package kntr.app.deepsearch.base.model.biz;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* compiled from: CardType.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0011\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/CardType;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;I)V", "UnKnow", "Greet", "ThinkNavigation", "ThinkContent", "Query", "Author", "Video", "Text", "Picture", "Embed", "Retry", "AnswerStop", "SessionEndTimeLine", "Placeholder", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum CardType {
    UnKnow,
    Greet,
    ThinkNavigation,
    ThinkContent,
    Query,
    Author,
    Video,
    Text,
    Picture,
    Embed,
    Retry,
    AnswerStop,
    SessionEndTimeLine,
    Placeholder;
    
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<CardType> getEntries() {
        return $ENTRIES;
    }
}
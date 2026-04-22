package kntr.app.im.chat.di.module.personal;

import ComposableSingletons$CustomBottomSheetKt$;
import im.base.model.SessionId;
import kntr.app.im.chat.di.module.assistant.Assistant;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PersonalChat.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0001H\u0016J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lkntr/app/im/chat/di/module/personal/PersonalChat;", "Lim/base/model/SessionId;", "talkerUid", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(J)V", "getTalkerUid", "()J", "checkSameId", RoomRecommendViewModel.EMPTY_CURSOR, "other", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PersonalChat implements SessionId {
    public static final int $stable = 0;
    private final long talkerUid;

    public static /* synthetic */ PersonalChat copy$default(PersonalChat personalChat, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j2 = personalChat.talkerUid;
        }
        return personalChat.copy(j2);
    }

    public final long component1() {
        return this.talkerUid;
    }

    public final PersonalChat copy(long j2) {
        return new PersonalChat(j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PersonalChat) && this.talkerUid == ((PersonalChat) obj).talkerUid;
    }

    public int hashCode() {
        return ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.talkerUid);
    }

    public String toString() {
        return "PersonalChat(talkerUid=" + this.talkerUid + ")";
    }

    public PersonalChat(long talkerUid) {
        this.talkerUid = talkerUid;
    }

    public final long getTalkerUid() {
        return this.talkerUid;
    }

    public boolean checkSameId(SessionId other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (SessionId.-CC.$default$checkSameId(this, other)) {
            return true;
        }
        Assistant assistant = other instanceof Assistant ? (Assistant) other : null;
        return assistant != null && (assistant.getAssistantId() > this.talkerUid ? 1 : (assistant.getAssistantId() == this.talkerUid ? 0 : -1)) == 0;
    }
}
package kntr.app.im.chat.di.module.assistant;

import ComposableSingletons$CustomBottomSheetKt$;
import com.bapis.bilibili.app.im.v1.KAssistantType;
import im.base.model.SessionId;
import kntr.app.im.chat.di.module.personal.PersonalChat;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Assistant.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0001H\u0016J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lkntr/app/im/chat/di/module/assistant/Assistant;", "Lim/base/model/SessionId;", "type", "Lcom/bapis/bilibili/app/im/v1/KAssistantType;", "assistantId", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Lcom/bapis/bilibili/app/im/v1/KAssistantType;J)V", "getType", "()Lcom/bapis/bilibili/app/im/v1/KAssistantType;", "getAssistantId", "()J", "checkSameId", RoomRecommendViewModel.EMPTY_CURSOR, "other", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Assistant implements SessionId {
    public static final int $stable = 0;
    private final long assistantId;
    private final KAssistantType type;

    public static /* synthetic */ Assistant copy$default(Assistant assistant, KAssistantType kAssistantType, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            kAssistantType = assistant.type;
        }
        if ((i & 2) != 0) {
            j2 = assistant.assistantId;
        }
        return assistant.copy(kAssistantType, j2);
    }

    public final KAssistantType component1() {
        return this.type;
    }

    public final long component2() {
        return this.assistantId;
    }

    public final Assistant copy(KAssistantType kAssistantType, long j2) {
        Intrinsics.checkNotNullParameter(kAssistantType, "type");
        return new Assistant(kAssistantType, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Assistant) {
            Assistant assistant = (Assistant) obj;
            return Intrinsics.areEqual(this.type, assistant.type) && this.assistantId == assistant.assistantId;
        }
        return false;
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.assistantId);
    }

    public String toString() {
        KAssistantType kAssistantType = this.type;
        return "Assistant(type=" + kAssistantType + ", assistantId=" + this.assistantId + ")";
    }

    public Assistant(KAssistantType type, long assistantId) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.assistantId = assistantId;
    }

    public final KAssistantType getType() {
        return this.type;
    }

    public final long getAssistantId() {
        return this.assistantId;
    }

    public boolean checkSameId(SessionId other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (SessionId.-CC.$default$checkSameId(this, other)) {
            return true;
        }
        PersonalChat personalChat = other instanceof PersonalChat ? (PersonalChat) other : null;
        return personalChat != null && (personalChat.getTalkerUid() > this.assistantId ? 1 : (personalChat.getTalkerUid() == this.assistantId ? 0 : -1)) == 0;
    }
}
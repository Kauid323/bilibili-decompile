package kntr.app.im.chat.db.entity;

import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.im.chat.db.model.InputBoxContent;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;

/* compiled from: DraftEntity.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000e\u0010\u0011\u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\b\u0012J\u001d\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001b"}, d2 = {"Lkntr/app/im/chat/db/entity/DraftEntity;", RoomRecommendViewModel.EMPTY_CURSOR, "sessionId", "Lkntr/app/im/chat/db/entity/SessionIdEntity;", "contentJson", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Lkntr/app/im/chat/db/entity/SessionIdEntity;Ljava/lang/String;)V", "getSessionId", "()Lkntr/app/im/chat/db/entity/SessionIdEntity;", "getContentJson$db_debug", "()Ljava/lang/String;", "getContent", "Lkntr/app/im/chat/db/model/InputBoxContent;", "json", "Lkotlinx/serialization/json/Json;", "component1", "component2", "component2$db_debug", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "Companion", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DraftEntity {
    public static final Companion Companion = new Companion(null);
    private final String contentJson;
    private final SessionIdEntity sessionId;

    public static /* synthetic */ DraftEntity copy$default(DraftEntity draftEntity, SessionIdEntity sessionIdEntity, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            sessionIdEntity = draftEntity.sessionId;
        }
        if ((i & 2) != 0) {
            str = draftEntity.contentJson;
        }
        return draftEntity.copy(sessionIdEntity, str);
    }

    public final SessionIdEntity component1() {
        return this.sessionId;
    }

    public final String component2$db_debug() {
        return this.contentJson;
    }

    public final DraftEntity copy(SessionIdEntity sessionIdEntity, String str) {
        Intrinsics.checkNotNullParameter(sessionIdEntity, "sessionId");
        Intrinsics.checkNotNullParameter(str, "contentJson");
        return new DraftEntity(sessionIdEntity, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DraftEntity) {
            DraftEntity draftEntity = (DraftEntity) obj;
            return Intrinsics.areEqual(this.sessionId, draftEntity.sessionId) && Intrinsics.areEqual(this.contentJson, draftEntity.contentJson);
        }
        return false;
    }

    public int hashCode() {
        return (this.sessionId.hashCode() * 31) + this.contentJson.hashCode();
    }

    public String toString() {
        SessionIdEntity sessionIdEntity = this.sessionId;
        return "DraftEntity(sessionId=" + sessionIdEntity + ", contentJson=" + this.contentJson + ")";
    }

    public DraftEntity(SessionIdEntity sessionId, String contentJson) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(contentJson, "contentJson");
        this.sessionId = sessionId;
        this.contentJson = contentJson;
    }

    public final SessionIdEntity getSessionId() {
        return this.sessionId;
    }

    public final String getContentJson$db_debug() {
        return this.contentJson;
    }

    /* compiled from: DraftEntity.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"Lkntr/app/im/chat/db/entity/DraftEntity$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", ReportBuildInParam.BUILD, "Lkntr/app/im/chat/db/entity/DraftEntity;", "json", "Lkotlinx/serialization/json/Json;", "sessionId", "Lkntr/app/im/chat/db/entity/SessionIdEntity;", "inputBoxContent", "Lkntr/app/im/chat/db/model/InputBoxContent;", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DraftEntity build(Json json, SessionIdEntity sessionId, InputBoxContent inputBoxContent) {
            Intrinsics.checkNotNullParameter(json, "json");
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            Intrinsics.checkNotNullParameter(inputBoxContent, "inputBoxContent");
            return new DraftEntity(sessionId, json.encodeToString(InputBoxContent.Companion.serializer(), inputBoxContent));
        }
    }

    public final InputBoxContent getContent(Json json) {
        Intrinsics.checkNotNullParameter(json, "json");
        return (InputBoxContent) json.decodeFromString(InputBoxContent.Companion.serializer(), this.contentJson);
    }
}
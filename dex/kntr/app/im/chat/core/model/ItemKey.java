package kntr.app.im.chat.core.model;

import ComposableSingletons$CustomBottomSheetKt$;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Instant;

/* compiled from: ItemKey.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/core/model/ItemKey;", RoomRecommendViewModel.EMPTY_CURSOR, "TimeDescription", "Message", "Sending", "Lkntr/app/im/chat/core/model/ItemKey$Message;", "Lkntr/app/im/chat/core/model/ItemKey$Sending;", "Lkntr/app/im/chat/core/model/ItemKey$TimeDescription;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ItemKey {

    /* compiled from: ItemKey.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/im/chat/core/model/ItemKey$TimeDescription;", "Lkntr/app/im/chat/core/model/ItemKey;", "timestamp", "Lkotlinx/datetime/Instant;", "<init>", "(Lkotlinx/datetime/Instant;)V", "getTimestamp", "()Lkotlinx/datetime/Instant;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class TimeDescription implements ItemKey {
        public static final int $stable = 8;
        private final Instant timestamp;

        public static /* synthetic */ TimeDescription copy$default(TimeDescription timeDescription, Instant instant, int i, Object obj) {
            if ((i & 1) != 0) {
                instant = timeDescription.timestamp;
            }
            return timeDescription.copy(instant);
        }

        public final Instant component1() {
            return this.timestamp;
        }

        public final TimeDescription copy(Instant instant) {
            Intrinsics.checkNotNullParameter(instant, "timestamp");
            return new TimeDescription(instant);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof TimeDescription) && Intrinsics.areEqual(this.timestamp, ((TimeDescription) obj).timestamp);
        }

        public int hashCode() {
            return this.timestamp.hashCode();
        }

        public String toString() {
            return "TimeDescription(timestamp=" + this.timestamp + ")";
        }

        public TimeDescription(Instant timestamp) {
            Intrinsics.checkNotNullParameter(timestamp, "timestamp");
            this.timestamp = timestamp;
        }

        public final Instant getTimestamp() {
            return this.timestamp;
        }
    }

    /* compiled from: ItemKey.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/im/chat/core/model/ItemKey$Message;", "Lkntr/app/im/chat/core/model/ItemKey;", "databaseKey", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(J)V", "getDatabaseKey", "()J", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Message implements ItemKey {
        public static final int $stable = 0;
        private final long databaseKey;

        public static /* synthetic */ Message copy$default(Message message, long j2, int i, Object obj) {
            if ((i & 1) != 0) {
                j2 = message.databaseKey;
            }
            return message.copy(j2);
        }

        public final long component1() {
            return this.databaseKey;
        }

        public final Message copy(long j2) {
            return new Message(j2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Message) && this.databaseKey == ((Message) obj).databaseKey;
        }

        public int hashCode() {
            return ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.databaseKey);
        }

        public String toString() {
            return "Message(databaseKey=" + this.databaseKey + ")";
        }

        public Message(long databaseKey) {
            this.databaseKey = databaseKey;
        }

        public final long getDatabaseKey() {
            return this.databaseKey;
        }
    }

    /* compiled from: ItemKey.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/app/im/chat/core/model/ItemKey$Sending;", "Lkntr/app/im/chat/core/model/ItemKey;", "token", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;)V", "getToken", "()Ljava/lang/String;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Sending implements ItemKey {
        public static final int $stable = 0;
        private final String token;

        public static /* synthetic */ Sending copy$default(Sending sending, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sending.token;
            }
            return sending.copy(str);
        }

        public final String component1() {
            return this.token;
        }

        public final Sending copy(String str) {
            Intrinsics.checkNotNullParameter(str, "token");
            return new Sending(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Sending) && Intrinsics.areEqual(this.token, ((Sending) obj).token);
        }

        public int hashCode() {
            return this.token.hashCode();
        }

        public String toString() {
            return "Sending(token=" + this.token + ")";
        }

        public Sending(String token) {
            Intrinsics.checkNotNullParameter(token, "token");
            this.token = token;
        }

        public final String getToken() {
            return this.token;
        }
    }
}
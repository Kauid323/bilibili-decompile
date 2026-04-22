package kntr.app.im.chat.service;

import java.util.List;
import kntr.app.im.chat.core.model.MessageId;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FusionFetchMessagesServiceImpl.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/service/FetchMessagesAction;", RoomRecommendViewModel.EMPTY_CURSOR, "LoadLater", "LoadEarlier", "UpdateMessages", "Lkntr/app/im/chat/service/FetchMessagesAction$LoadEarlier;", "Lkntr/app/im/chat/service/FetchMessagesAction$LoadLater;", "Lkntr/app/im/chat/service/FetchMessagesAction$UpdateMessages;", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface FetchMessagesAction {

    /* compiled from: FusionFetchMessagesServiceImpl.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/im/chat/service/FetchMessagesAction$LoadLater;", "Lkntr/app/im/chat/service/FetchMessagesAction;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class LoadLater implements FetchMessagesAction {
        public static final int $stable = 0;
        public static final LoadLater INSTANCE = new LoadLater();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LoadLater) {
                LoadLater loadLater = (LoadLater) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1949803915;
        }

        public String toString() {
            return "LoadLater";
        }

        private LoadLater() {
        }
    }

    /* compiled from: FusionFetchMessagesServiceImpl.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/im/chat/service/FetchMessagesAction$LoadEarlier;", "Lkntr/app/im/chat/service/FetchMessagesAction;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class LoadEarlier implements FetchMessagesAction {
        public static final int $stable = 0;
        public static final LoadEarlier INSTANCE = new LoadEarlier();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LoadEarlier) {
                LoadEarlier loadEarlier = (LoadEarlier) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1219943657;
        }

        public String toString() {
            return "LoadEarlier";
        }

        private LoadEarlier() {
        }
    }

    /* compiled from: FusionFetchMessagesServiceImpl.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lkntr/app/im/chat/service/FetchMessagesAction$UpdateMessages;", "Lkntr/app/im/chat/service/FetchMessagesAction;", "messageIds", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/core/model/MessageId;", "<init>", "(Ljava/util/List;)V", "getMessageIds", "()Ljava/util/List;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class UpdateMessages implements FetchMessagesAction {
        public static final int $stable = 8;
        private final List<MessageId> messageIds;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ UpdateMessages copy$default(UpdateMessages updateMessages, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = updateMessages.messageIds;
            }
            return updateMessages.copy(list);
        }

        public final List<MessageId> component1() {
            return this.messageIds;
        }

        public final UpdateMessages copy(List<MessageId> list) {
            Intrinsics.checkNotNullParameter(list, "messageIds");
            return new UpdateMessages(list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UpdateMessages) && Intrinsics.areEqual(this.messageIds, ((UpdateMessages) obj).messageIds);
        }

        public int hashCode() {
            return this.messageIds.hashCode();
        }

        public String toString() {
            return "UpdateMessages(messageIds=" + this.messageIds + ")";
        }

        public UpdateMessages(List<MessageId> list) {
            Intrinsics.checkNotNullParameter(list, "messageIds");
            this.messageIds = list;
        }

        public final List<MessageId> getMessageIds() {
            return this.messageIds;
        }
    }
}
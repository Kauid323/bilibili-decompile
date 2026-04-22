package kntr.app.im.chat.core.model;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.photonic.aphro.core.AphroState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatPageData.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/core/model/InputBoxSelectState;", RoomRecommendViewModel.EMPTY_CURSOR, "Idle", "Gallery", "InputField", "EMOJI", "Lkntr/app/im/chat/core/model/InputBoxSelectState$EMOJI;", "Lkntr/app/im/chat/core/model/InputBoxSelectState$Gallery;", "Lkntr/app/im/chat/core/model/InputBoxSelectState$Idle;", "Lkntr/app/im/chat/core/model/InputBoxSelectState$InputField;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface InputBoxSelectState {

    /* compiled from: ChatPageData.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/im/chat/core/model/InputBoxSelectState$Idle;", "Lkntr/app/im/chat/core/model/InputBoxSelectState;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Idle implements InputBoxSelectState {
        public static final int $stable = 0;
        public static final Idle INSTANCE = new Idle();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Idle) {
                Idle idle = (Idle) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 311727452;
        }

        public String toString() {
            return "Idle";
        }

        private Idle() {
        }
    }

    /* compiled from: ChatPageData.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/im/chat/core/model/InputBoxSelectState$Gallery;", "Lkntr/app/im/chat/core/model/InputBoxSelectState;", "aphroState", "Lkntr/common/photonic/aphro/core/AphroState;", "<init>", "(Lkntr/common/photonic/aphro/core/AphroState;)V", "getAphroState", "()Lkntr/common/photonic/aphro/core/AphroState;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Gallery implements InputBoxSelectState {
        public static final int $stable = 0;
        private final AphroState aphroState;

        public static /* synthetic */ Gallery copy$default(Gallery gallery, AphroState aphroState, int i, Object obj) {
            if ((i & 1) != 0) {
                aphroState = gallery.aphroState;
            }
            return gallery.copy(aphroState);
        }

        public final AphroState component1() {
            return this.aphroState;
        }

        public final Gallery copy(AphroState aphroState) {
            Intrinsics.checkNotNullParameter(aphroState, "aphroState");
            return new Gallery(aphroState);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Gallery) && Intrinsics.areEqual(this.aphroState, ((Gallery) obj).aphroState);
        }

        public int hashCode() {
            return this.aphroState.hashCode();
        }

        public String toString() {
            return "Gallery(aphroState=" + this.aphroState + ")";
        }

        public Gallery(AphroState aphroState) {
            Intrinsics.checkNotNullParameter(aphroState, "aphroState");
            this.aphroState = aphroState;
        }

        public final AphroState getAphroState() {
            return this.aphroState;
        }
    }

    /* compiled from: ChatPageData.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/im/chat/core/model/InputBoxSelectState$InputField;", "Lkntr/app/im/chat/core/model/InputBoxSelectState;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class InputField implements InputBoxSelectState {
        public static final int $stable = 0;
        public static final InputField INSTANCE = new InputField();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof InputField) {
                InputField inputField = (InputField) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1499510488;
        }

        public String toString() {
            return "InputField";
        }

        private InputField() {
        }
    }

    /* compiled from: ChatPageData.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/im/chat/core/model/InputBoxSelectState$EMOJI;", "Lkntr/app/im/chat/core/model/InputBoxSelectState;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class EMOJI implements InputBoxSelectState {
        public static final int $stable = 0;
        public static final EMOJI INSTANCE = new EMOJI();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof EMOJI) {
                EMOJI emoji = (EMOJI) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1069208510;
        }

        public String toString() {
            return "EMOJI";
        }

        private EMOJI() {
        }
    }
}
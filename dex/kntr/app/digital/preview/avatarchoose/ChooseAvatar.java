package kntr.app.digital.preview.avatarchoose;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.komponent.KomponentScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* compiled from: AvatarChooser.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001:\u0001\fJ-\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH¦\u0002¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lkntr/app/digital/preview/avatarchoose/ChooseAvatar;", RoomRecommendViewModel.EMPTY_CURSOR, "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lkntr/app/digital/preview/avatarchoose/ChooseAvatar$State;", "komponentScope", "Lkntr/common/komponent/KomponentScope;", RoomRecommendViewModel.EMPTY_CURSOR, "showDigital", RoomRecommendViewModel.EMPTY_CURSOR, "digitalText", RoomRecommendViewModel.EMPTY_CURSOR, "State", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ChooseAvatar {
    Flow<State> invoke(KomponentScope<? super Unit> komponentScope, boolean z, String str);

    /* compiled from: AvatarChooser.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lkntr/app/digital/preview/avatarchoose/ChooseAvatar$State;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "Uploading", "Success", "Failed", "Lkntr/app/digital/preview/avatarchoose/ChooseAvatar$State$Failed;", "Lkntr/app/digital/preview/avatarchoose/ChooseAvatar$State$Success;", "Lkntr/app/digital/preview/avatarchoose/ChooseAvatar$State$Uploading;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static abstract class State {
        public static final int $stable = 0;

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: AvatarChooser.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/digital/preview/avatarchoose/ChooseAvatar$State$Uploading;", "Lkntr/app/digital/preview/avatarchoose/ChooseAvatar$State;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class Uploading extends State {
            public static final int $stable = 0;
            public static final Uploading INSTANCE = new Uploading();

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Uploading) {
                    Uploading uploading = (Uploading) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return 725920078;
            }

            public String toString() {
                return "Uploading";
            }

            private Uploading() {
                super(null);
            }
        }

        private State() {
        }

        /* compiled from: AvatarChooser.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/digital/preview/avatarchoose/ChooseAvatar$State$Success;", "Lkntr/app/digital/preview/avatarchoose/ChooseAvatar$State;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class Success extends State {
            public static final int $stable = 0;
            public static final Success INSTANCE = new Success();

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Success) {
                    Success success = (Success) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return 1671957072;
            }

            public String toString() {
                return "Success";
            }

            private Success() {
                super(null);
            }
        }

        /* compiled from: AvatarChooser.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lkntr/app/digital/preview/avatarchoose/ChooseAvatar$State$Failed;", "Lkntr/app/digital/preview/avatarchoose/ChooseAvatar$State;", "errorCode", RoomRecommendViewModel.EMPTY_CURSOR, "msg", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(ILjava/lang/String;)V", "getErrorCode", "()I", "getMsg", "()Ljava/lang/String;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class Failed extends State {
            public static final int $stable = 0;
            private final int errorCode;
            private final String msg;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Failed(int errorCode, String msg) {
                super(null);
                Intrinsics.checkNotNullParameter(msg, "msg");
                this.errorCode = errorCode;
                this.msg = msg;
            }

            public final int getErrorCode() {
                return this.errorCode;
            }

            public final String getMsg() {
                return this.msg;
            }
        }
    }
}
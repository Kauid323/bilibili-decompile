package video.biz.offline.list.logic.statemachine;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: OfflineResloveStateMachine.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0001\u0002\u0082\u0001\u0001\u0003¨\u0006\u0004À\u0006\u0003"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineResultPageUiEvent;", "", "ShowToast", "Lvideo/biz/offline/list/logic/statemachine/OfflineResultPageUiEvent$ShowToast;", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface OfflineResultPageUiEvent {

    /* compiled from: OfflineResloveStateMachine.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ$\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineResultPageUiEvent$ShowToast;", "Lvideo/biz/offline/list/logic/statemachine/OfflineResultPageUiEvent;", "toast", "", "duration", "", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getToast", "()Ljava/lang/String;", "getDuration", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lvideo/biz/offline/list/logic/statemachine/OfflineResultPageUiEvent$ShowToast;", "equals", "", "other", "", "hashCode", "toString", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class ShowToast implements OfflineResultPageUiEvent {
        public static final int $stable = 0;
        private final Integer duration;
        private final String toast;

        public static /* synthetic */ ShowToast copy$default(ShowToast showToast, String str, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                str = showToast.toast;
            }
            if ((i & 2) != 0) {
                num = showToast.duration;
            }
            return showToast.copy(str, num);
        }

        public final String component1() {
            return this.toast;
        }

        public final Integer component2() {
            return this.duration;
        }

        public final ShowToast copy(String str, Integer num) {
            Intrinsics.checkNotNullParameter(str, "toast");
            return new ShowToast(str, num);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ShowToast) {
                ShowToast showToast = (ShowToast) obj;
                return Intrinsics.areEqual(this.toast, showToast.toast) && Intrinsics.areEqual(this.duration, showToast.duration);
            }
            return false;
        }

        public int hashCode() {
            return (this.toast.hashCode() * 31) + (this.duration == null ? 0 : this.duration.hashCode());
        }

        public String toString() {
            String str = this.toast;
            return "ShowToast(toast=" + str + ", duration=" + this.duration + ")";
        }

        public ShowToast(String toast, Integer duration) {
            Intrinsics.checkNotNullParameter(toast, "toast");
            this.toast = toast;
            this.duration = duration;
        }

        public /* synthetic */ ShowToast(String str, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : num);
        }

        public final String getToast() {
            return this.toast;
        }

        public final Integer getDuration() {
            return this.duration;
        }
    }
}
package video.biz.offline.list.logic.statemachine;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: OfflineSDDiagnosePageStore.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0001\u0002\u0082\u0001\u0001\u0003¨\u0006\u0004À\u0006\u0003"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineSDDiagnosePageEvent;", "", "TriggerTest", "Lvideo/biz/offline/list/logic/statemachine/OfflineSDDiagnosePageEvent$TriggerTest;", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface OfflineSDDiagnosePageEvent {

    /* compiled from: OfflineSDDiagnosePageStore.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineSDDiagnosePageEvent$TriggerTest;", "Lvideo/biz/offline/list/logic/statemachine/OfflineSDDiagnosePageEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class TriggerTest implements OfflineSDDiagnosePageEvent {
        public static final int $stable = 0;
        public static final TriggerTest INSTANCE = new TriggerTest();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof TriggerTest) {
                TriggerTest triggerTest = (TriggerTest) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -946193274;
        }

        public String toString() {
            return "TriggerTest";
        }

        private TriggerTest() {
        }
    }
}
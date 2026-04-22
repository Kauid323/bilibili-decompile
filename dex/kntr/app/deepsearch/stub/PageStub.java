package kntr.app.deepsearch.stub;

import android.app.Activity;
import java.lang.ref.WeakReference;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PageStub.android.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lkntr/app/deepsearch/stub/PageStub;", RoomRecommendViewModel.EMPTY_CURSOR, "activityRef", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "sessionId", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/ref/WeakReference;Ljava/lang/String;)V", "getActivityRef", "()Ljava/lang/ref/WeakReference;", "getSessionId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "common-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PageStub {
    public static final int $stable = 8;
    private final WeakReference<Activity> activityRef;
    private final String sessionId;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PageStub copy$default(PageStub pageStub, WeakReference weakReference, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            weakReference = pageStub.activityRef;
        }
        if ((i & 2) != 0) {
            str = pageStub.sessionId;
        }
        return pageStub.copy(weakReference, str);
    }

    public final WeakReference<Activity> component1() {
        return this.activityRef;
    }

    public final String component2() {
        return this.sessionId;
    }

    public final PageStub copy(WeakReference<Activity> weakReference, String str) {
        Intrinsics.checkNotNullParameter(weakReference, "activityRef");
        Intrinsics.checkNotNullParameter(str, "sessionId");
        return new PageStub(weakReference, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PageStub) {
            PageStub pageStub = (PageStub) obj;
            return Intrinsics.areEqual(this.activityRef, pageStub.activityRef) && Intrinsics.areEqual(this.sessionId, pageStub.sessionId);
        }
        return false;
    }

    public int hashCode() {
        return (this.activityRef.hashCode() * 31) + this.sessionId.hashCode();
    }

    public String toString() {
        WeakReference<Activity> weakReference = this.activityRef;
        return "PageStub(activityRef=" + weakReference + ", sessionId=" + this.sessionId + ")";
    }

    public PageStub(WeakReference<Activity> weakReference, String sessionId) {
        Intrinsics.checkNotNullParameter(weakReference, "activityRef");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        this.activityRef = weakReference;
        this.sessionId = sessionId;
    }

    public final WeakReference<Activity> getActivityRef() {
        return this.activityRef;
    }

    public final String getSessionId() {
        return this.sessionId;
    }
}
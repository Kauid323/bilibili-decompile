package tv.danmaku.bili.push.pushsetting.system;

import androidx.appcompat.app.AppCompatActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SystemPushDialogHelper.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\b\u0082\b\u0018\u00002\u00020\u0001B;\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\nHÖ\u0001J\t\u0010 \u001a\u00020\bHÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013¨\u0006!"}, d2 = {"Ltv/danmaku/bili/push/pushsetting/system/DialogInfoSnapshot;", "", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "", AudioIntentHelper.FROM_ACTIVITY, "Landroidx/appcompat/app/AppCompatActivity;", "showFrom", "", "step", "", FavoritesConstsKt.SPMID, "<init>", "(Lkotlinx/coroutines/CancellableContinuation;Landroidx/appcompat/app/AppCompatActivity;Ljava/lang/String;ILjava/lang/String;)V", "getContinuation", "()Lkotlinx/coroutines/CancellableContinuation;", "getActivity", "()Landroidx/appcompat/app/AppCompatActivity;", "getShowFrom", "()Ljava/lang/String;", "getStep", "()I", "getSpmid", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DialogInfoSnapshot {
    private final AppCompatActivity activity;
    private final CancellableContinuation<Boolean> continuation;
    private final String showFrom;
    private final String spmid;
    private final int step;

    public static /* synthetic */ DialogInfoSnapshot copy$default(DialogInfoSnapshot dialogInfoSnapshot, CancellableContinuation cancellableContinuation, AppCompatActivity appCompatActivity, String str, int i, String str2, int i2, Object obj) {
        CancellableContinuation<Boolean> cancellableContinuation2 = cancellableContinuation;
        if ((i2 & 1) != 0) {
            cancellableContinuation2 = dialogInfoSnapshot.continuation;
        }
        if ((i2 & 2) != 0) {
            appCompatActivity = dialogInfoSnapshot.activity;
        }
        AppCompatActivity appCompatActivity2 = appCompatActivity;
        if ((i2 & 4) != 0) {
            str = dialogInfoSnapshot.showFrom;
        }
        String str3 = str;
        if ((i2 & 8) != 0) {
            i = dialogInfoSnapshot.step;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            str2 = dialogInfoSnapshot.spmid;
        }
        return dialogInfoSnapshot.copy(cancellableContinuation2, appCompatActivity2, str3, i3, str2);
    }

    public final CancellableContinuation<Boolean> component1() {
        return this.continuation;
    }

    public final AppCompatActivity component2() {
        return this.activity;
    }

    public final String component3() {
        return this.showFrom;
    }

    public final int component4() {
        return this.step;
    }

    public final String component5() {
        return this.spmid;
    }

    public final DialogInfoSnapshot copy(CancellableContinuation<? super Boolean> cancellableContinuation, AppCompatActivity appCompatActivity, String str, int i, String str2) {
        Intrinsics.checkNotNullParameter(appCompatActivity, AudioIntentHelper.FROM_ACTIVITY);
        Intrinsics.checkNotNullParameter(str, "showFrom");
        return new DialogInfoSnapshot(cancellableContinuation, appCompatActivity, str, i, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DialogInfoSnapshot) {
            DialogInfoSnapshot dialogInfoSnapshot = (DialogInfoSnapshot) obj;
            return Intrinsics.areEqual(this.continuation, dialogInfoSnapshot.continuation) && Intrinsics.areEqual(this.activity, dialogInfoSnapshot.activity) && Intrinsics.areEqual(this.showFrom, dialogInfoSnapshot.showFrom) && this.step == dialogInfoSnapshot.step && Intrinsics.areEqual(this.spmid, dialogInfoSnapshot.spmid);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((this.continuation == null ? 0 : this.continuation.hashCode()) * 31) + this.activity.hashCode()) * 31) + this.showFrom.hashCode()) * 31) + this.step) * 31) + (this.spmid != null ? this.spmid.hashCode() : 0);
    }

    public String toString() {
        CancellableContinuation<Boolean> cancellableContinuation = this.continuation;
        AppCompatActivity appCompatActivity = this.activity;
        String str = this.showFrom;
        int i = this.step;
        return "DialogInfoSnapshot(continuation=" + cancellableContinuation + ", activity=" + appCompatActivity + ", showFrom=" + str + ", step=" + i + ", spmid=" + this.spmid + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DialogInfoSnapshot(CancellableContinuation<? super Boolean> cancellableContinuation, AppCompatActivity activity, String showFrom, int step, String spmid) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        Intrinsics.checkNotNullParameter(showFrom, "showFrom");
        this.continuation = cancellableContinuation;
        this.activity = activity;
        this.showFrom = showFrom;
        this.step = step;
        this.spmid = spmid;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ DialogInfoSnapshot(CancellableContinuation cancellableContinuation, AppCompatActivity appCompatActivity, String str, int i, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(cancellableContinuation, appCompatActivity, str, i, r5);
        String str3;
        if ((i2 & 16) == 0) {
            str3 = str2;
        } else {
            str3 = null;
        }
    }

    public final CancellableContinuation<Boolean> getContinuation() {
        return this.continuation;
    }

    public final AppCompatActivity getActivity() {
        return this.activity;
    }

    public final String getShowFrom() {
        return this.showFrom;
    }

    public final int getStep() {
        return this.step;
    }

    public final String getSpmid() {
        return this.spmid;
    }
}
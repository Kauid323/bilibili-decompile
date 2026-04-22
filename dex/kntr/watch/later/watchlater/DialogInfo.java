package kntr.watch.later.watchlater;

import bili.resource.common.CommonRes;
import bili.resource.common.String0_commonMainKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WatcherLaterScreen.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003JS\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000e¨\u0006\""}, d2 = {"Lkntr/watch/later/watchlater/DialogInfo;", "", "title", "", "message", "onConfirm", "Lkotlin/Function0;", "", "onCacnel", "cancelText", "confirmText", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getMessage", "getOnConfirm", "()Lkotlin/jvm/functions/Function0;", "getOnCacnel", "getCancelText", "getConfirmText", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "watch_later_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DialogInfo {
    public static final int $stable = 0;
    private final String cancelText;
    private final String confirmText;
    private final String message;
    private final Function0<Unit> onCacnel;
    private final Function0<Unit> onConfirm;
    private final String title;

    public static /* synthetic */ DialogInfo copy$default(DialogInfo dialogInfo, String str, String str2, Function0 function0, Function0 function02, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = dialogInfo.title;
        }
        if ((i & 2) != 0) {
            str2 = dialogInfo.message;
        }
        String str5 = str2;
        Function0<Unit> function03 = function0;
        if ((i & 4) != 0) {
            function03 = dialogInfo.onConfirm;
        }
        Function0 function04 = function03;
        Function0<Unit> function05 = function02;
        if ((i & 8) != 0) {
            function05 = dialogInfo.onCacnel;
        }
        Function0 function06 = function05;
        if ((i & 16) != 0) {
            str3 = dialogInfo.cancelText;
        }
        String str6 = str3;
        if ((i & 32) != 0) {
            str4 = dialogInfo.confirmText;
        }
        return dialogInfo.copy(str, str5, function04, function06, str6, str4);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.message;
    }

    public final Function0<Unit> component3() {
        return this.onConfirm;
    }

    public final Function0<Unit> component4() {
        return this.onCacnel;
    }

    public final String component5() {
        return this.cancelText;
    }

    public final String component6() {
        return this.confirmText;
    }

    public final DialogInfo copy(String str, String str2, Function0<Unit> function0, Function0<Unit> function02, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(function0, "onConfirm");
        Intrinsics.checkNotNullParameter(function02, "onCacnel");
        Intrinsics.checkNotNullParameter(str3, "cancelText");
        Intrinsics.checkNotNullParameter(str4, "confirmText");
        return new DialogInfo(str, str2, function0, function02, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DialogInfo) {
            DialogInfo dialogInfo = (DialogInfo) obj;
            return Intrinsics.areEqual(this.title, dialogInfo.title) && Intrinsics.areEqual(this.message, dialogInfo.message) && Intrinsics.areEqual(this.onConfirm, dialogInfo.onConfirm) && Intrinsics.areEqual(this.onCacnel, dialogInfo.onCacnel) && Intrinsics.areEqual(this.cancelText, dialogInfo.cancelText) && Intrinsics.areEqual(this.confirmText, dialogInfo.confirmText);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.title.hashCode() * 31) + (this.message == null ? 0 : this.message.hashCode())) * 31) + this.onConfirm.hashCode()) * 31) + this.onCacnel.hashCode()) * 31) + this.cancelText.hashCode()) * 31) + this.confirmText.hashCode();
    }

    public String toString() {
        String str = this.title;
        String str2 = this.message;
        Function0<Unit> function0 = this.onConfirm;
        Function0<Unit> function02 = this.onCacnel;
        String str3 = this.cancelText;
        return "DialogInfo(title=" + str + ", message=" + str2 + ", onConfirm=" + function0 + ", onCacnel=" + function02 + ", cancelText=" + str3 + ", confirmText=" + this.confirmText + ")";
    }

    public DialogInfo(String title, String message, Function0<Unit> function0, Function0<Unit> function02, String cancelText, String confirmText) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(function0, "onConfirm");
        Intrinsics.checkNotNullParameter(function02, "onCacnel");
        Intrinsics.checkNotNullParameter(cancelText, "cancelText");
        Intrinsics.checkNotNullParameter(confirmText, "confirmText");
        this.title = title;
        this.message = message;
        this.onConfirm = function0;
        this.onCacnel = function02;
        this.cancelText = cancelText;
        this.confirmText = confirmText;
    }

    public /* synthetic */ DialogInfo(String str, String str2, Function0 function0, Function0 function02, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, function0, function02, (i & 16) != 0 ? CommonRes.INSTANCE.getString(String0_commonMainKt.getCommon_global_string_238(CommonRes.INSTANCE.getString())) : str3, (i & 32) != 0 ? CommonRes.INSTANCE.getString(String0_commonMainKt.getCommon_global_string_113(CommonRes.INSTANCE.getString())) : str4);
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getMessage() {
        return this.message;
    }

    public final Function0<Unit> getOnConfirm() {
        return this.onConfirm;
    }

    public final Function0<Unit> getOnCacnel() {
        return this.onCacnel;
    }

    public final String getCancelText() {
        return this.cancelText;
    }

    public final String getConfirmText() {
        return this.confirmText;
    }
}
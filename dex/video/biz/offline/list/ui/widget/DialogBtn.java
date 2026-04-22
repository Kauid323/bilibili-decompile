package video.biz.offline.list.ui.widget;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: OfflineCommonDialog.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u000eJ\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J4\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001f"}, d2 = {"Lvideo/biz/offline/list/ui/widget/DialogBtn;", "", RankRouter.BundleKey.ACTION_PARAM_TITLE, "", "color", "Landroidx/compose/ui/graphics/Color;", "action", "Lkotlin/Function0;", "", "<init>", "(Ljava/lang/String;JLkotlin/jvm/functions/Function0;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getTitle", "()Ljava/lang/String;", "getColor-0d7_KjU", "()J", "J", "getAction", "()Lkotlin/jvm/functions/Function0;", "component1", "component2", "component2-0d7_KjU", "component3", "copy", "copy-bw27NRU", "(Ljava/lang/String;JLkotlin/jvm/functions/Function0;)Lvideo/biz/offline/list/ui/widget/DialogBtn;", "equals", "", "other", "hashCode", "", "toString", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DialogBtn {
    public static final int $stable = 0;
    private final Function0<Unit> action;
    private final long color;
    private final String title;

    public /* synthetic */ DialogBtn(String str, long j, Function0 function0, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, function0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: copy-bw27NRU$default  reason: not valid java name */
    public static /* synthetic */ DialogBtn m2915copybw27NRU$default(DialogBtn dialogBtn, String str, long j, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = dialogBtn.title;
        }
        if ((i & 2) != 0) {
            j = dialogBtn.color;
        }
        if ((i & 4) != 0) {
            function0 = dialogBtn.action;
        }
        return dialogBtn.m2917copybw27NRU(str, j, function0);
    }

    public final String component1() {
        return this.title;
    }

    /* renamed from: component2-0d7_KjU  reason: not valid java name */
    public final long m2916component20d7_KjU() {
        return this.color;
    }

    public final Function0<Unit> component3() {
        return this.action;
    }

    /* renamed from: copy-bw27NRU  reason: not valid java name */
    public final DialogBtn m2917copybw27NRU(String str, long j, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, RankRouter.BundleKey.ACTION_PARAM_TITLE);
        Intrinsics.checkNotNullParameter(function0, "action");
        return new DialogBtn(str, j, function0, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DialogBtn) {
            DialogBtn dialogBtn = (DialogBtn) obj;
            return Intrinsics.areEqual(this.title, dialogBtn.title) && Color.equals-impl0(this.color, dialogBtn.color) && Intrinsics.areEqual(this.action, dialogBtn.action);
        }
        return false;
    }

    public int hashCode() {
        return (((this.title.hashCode() * 31) + Color.hashCode-impl(this.color)) * 31) + this.action.hashCode();
    }

    public String toString() {
        String str = this.title;
        String str2 = Color.toString-impl(this.color);
        return "DialogBtn(title=" + str + ", color=" + str2 + ", action=" + this.action + ")";
    }

    private DialogBtn(String title, long color, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(title, RankRouter.BundleKey.ACTION_PARAM_TITLE);
        Intrinsics.checkNotNullParameter(function0, "action");
        this.title = title;
        this.color = color;
        this.action = function0;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ DialogBtn(String str, long j, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, r4, null);
        Function0 function02;
        if ((i & 4) == 0) {
            function02 = function0;
        } else {
            function02 = new Function0() { // from class: video.biz.offline.list.ui.widget.DialogBtn$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit unit;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            };
        }
    }

    public final String getTitle() {
        return this.title;
    }

    /* renamed from: getColor-0d7_KjU  reason: not valid java name */
    public final long m2918getColor0d7_KjU() {
        return this.color;
    }

    public final Function0<Unit> getAction() {
        return this.action;
    }
}
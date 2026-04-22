package kntr.common.share.common.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.ImageBitmap;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShareMenuItem.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B \u0001\u0012A\b\u0002\u0010\u0002\u001a;\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0003¢\u0006\u0002\b\u000b\u0012(\b\u0002\u0010\u0006\u001a\"\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0002\b\u000b\u0012*\b\u0002\u0010\r\u001a$\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0002\b\u000b¢\u0006\u0004\b\u000e\u0010\u000fJG\u0010\u0017\u001a;\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0003¢\u0006\u0002\b\u000bHÆ\u0003¢\u0006\u0002\u0010\u0011J.\u0010\u0018\u001a\"\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0002\b\u000bHÆ\u0003¢\u0006\u0002\u0010\u0014J0\u0010\u0019\u001a$\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0002\b\u000bHÆ\u0003¢\u0006\u0002\u0010\u0014J§\u0001\u0010\u001a\u001a\u00020\u00002A\b\u0002\u0010\u0002\u001a;\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0003¢\u0006\u0002\b\u000b2(\b\u0002\u0010\u0006\u001a\"\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0002\b\u000b2*\b\u0002\u0010\r\u001a$\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0002\b\u000bHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\bHÖ\u0001RL\u0010\u0002\u001a;\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0003¢\u0006\u0002\b\u000b¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R3\u0010\u0006\u001a\"\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0002\b\u000b¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R5\u0010\r\u001a$\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0002\b\u000b¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0014¨\u0006\""}, d2 = {"Lkntr/common/share/common/ui/ShareMenuItemSlot;", "", "icon", "Lkotlin/Function2;", "Landroidx/compose/ui/graphics/ImageBitmap;", "Lkotlin/ParameterName;", "name", "bitmap", "", "iconUrl", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/Function1;", "corner", "<init>", "(Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;)V", "getIcon", "()Lkotlin/jvm/functions/Function4;", "Lkotlin/jvm/functions/Function4;", "getName", "()Lkotlin/jvm/functions/Function3;", "Lkotlin/jvm/functions/Function3;", "getCorner", "component1", "component2", "component3", "copy", "(Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;)Lkntr/common/share/common/ui/ShareMenuItemSlot;", "equals", "", "other", "hashCode", "", "toString", "common-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ShareMenuItemSlot {
    public static final int $stable = 0;
    private final Function3<String, Composer, Integer, Unit> corner;
    private final Function4<ImageBitmap, String, Composer, Integer, Unit> icon;
    private final Function3<String, Composer, Integer, Unit> name;

    public ShareMenuItemSlot() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ShareMenuItemSlot copy$default(ShareMenuItemSlot shareMenuItemSlot, Function4 function4, Function3 function3, Function3 function32, int i, Object obj) {
        if ((i & 1) != 0) {
            function4 = shareMenuItemSlot.icon;
        }
        if ((i & 2) != 0) {
            function3 = shareMenuItemSlot.name;
        }
        if ((i & 4) != 0) {
            function32 = shareMenuItemSlot.corner;
        }
        return shareMenuItemSlot.copy(function4, function3, function32);
    }

    public final Function4<ImageBitmap, String, Composer, Integer, Unit> component1() {
        return this.icon;
    }

    public final Function3<String, Composer, Integer, Unit> component2() {
        return this.name;
    }

    public final Function3<String, Composer, Integer, Unit> component3() {
        return this.corner;
    }

    public final ShareMenuItemSlot copy(Function4<? super ImageBitmap, ? super String, ? super Composer, ? super Integer, Unit> function4, Function3<? super String, ? super Composer, ? super Integer, Unit> function3, Function3<? super String, ? super Composer, ? super Integer, Unit> function32) {
        Intrinsics.checkNotNullParameter(function4, "icon");
        Intrinsics.checkNotNullParameter(function3, "name");
        Intrinsics.checkNotNullParameter(function32, "corner");
        return new ShareMenuItemSlot(function4, function3, function32);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ShareMenuItemSlot) {
            ShareMenuItemSlot shareMenuItemSlot = (ShareMenuItemSlot) obj;
            return Intrinsics.areEqual(this.icon, shareMenuItemSlot.icon) && Intrinsics.areEqual(this.name, shareMenuItemSlot.name) && Intrinsics.areEqual(this.corner, shareMenuItemSlot.corner);
        }
        return false;
    }

    public int hashCode() {
        return (((this.icon.hashCode() * 31) + this.name.hashCode()) * 31) + this.corner.hashCode();
    }

    public String toString() {
        Function4<ImageBitmap, String, Composer, Integer, Unit> function4 = this.icon;
        Function3<String, Composer, Integer, Unit> function3 = this.name;
        return "ShareMenuItemSlot(icon=" + function4 + ", name=" + function3 + ", corner=" + this.corner + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ShareMenuItemSlot(Function4<? super ImageBitmap, ? super String, ? super Composer, ? super Integer, Unit> function4, Function3<? super String, ? super Composer, ? super Integer, Unit> function3, Function3<? super String, ? super Composer, ? super Integer, Unit> function32) {
        Intrinsics.checkNotNullParameter(function4, "icon");
        Intrinsics.checkNotNullParameter(function3, "name");
        Intrinsics.checkNotNullParameter(function32, "corner");
        this.icon = function4;
        this.name = function3;
        this.corner = function32;
    }

    public /* synthetic */ ShareMenuItemSlot(Function4<ImageBitmap, String, Composer, Integer, Unit> function4, Function3<String, Composer, Integer, Unit> function3, Function3<String, Composer, Integer, Unit> function32, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? ComposableSingletons$ShareMenuItemKt.INSTANCE.m2360getLambda$927578050$common_ui_debug() : function4, (i & 2) != 0 ? ComposableSingletons$ShareMenuItemKt.INSTANCE.m2359getLambda$720573138$common_ui_debug() : function3, (i & 4) != 0 ? ComposableSingletons$ShareMenuItemKt.INSTANCE.getLambda$1298894840$common_ui_debug() : function32);
    }

    public final Function4<ImageBitmap, String, Composer, Integer, Unit> getIcon() {
        return this.icon;
    }

    public final Function3<String, Composer, Integer, Unit> getName() {
        return this.name;
    }

    public final Function3<String, Composer, Integer, Unit> getCorner() {
        return this.corner;
    }
}
package kntr.app.appwidget.guide.model;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import java.util.List;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WidgetGuidePopupParams.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\b\u0081\b\u0018\u00002\u00020\u0001By\u0012\u0010\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010'\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0004HÆ\u0003J\t\u0010)\u001a\u00020\u0004HÆ\u0003J\t\u0010*\u001a\u00020\bHÆ\u0003J\t\u0010+\u001a\u00020\nHÆ\u0003J\t\u0010,\u001a\u00020\fHÆ\u0003J\t\u0010-\u001a\u00020\bHÆ\u0003J\t\u0010.\u001a\u00020\nHÆ\u0003J\u0015\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0003J\u000f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013HÆ\u0003J\u0089\u0001\u00101\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\n2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00110\u00102\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013HÆ\u0001J\u0013\u00102\u001a\u00020\b2\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u00020\nHÖ\u0001J\t\u00105\u001a\u00020\u0004HÖ\u0001R\u001b\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\r\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u0011\u0010\u000e\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001eR\u001d\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&¨\u00066"}, d2 = {"Lkntr/app/appwidget/guide/model/WidgetGuidePopupParams;", RoomRecommendViewModel.EMPTY_CURSOR, "avatar", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "title", "subtitle", "outsideTouchable", RoomRecommendViewModel.EMPTY_CURSOR, "offset", RoomRecommendViewModel.EMPTY_CURSOR, "duration", RoomRecommendViewModel.EMPTY_CURSOR, "forceDark", "style", "dismiss", "Lkotlin/Function1;", RoomRecommendViewModel.EMPTY_CURSOR, "performAction", "Lkotlin/Function0;", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ZIJZILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "getAvatar", "()Ljava/util/List;", "getTitle", "()Ljava/lang/String;", "getSubtitle", "getOutsideTouchable", "()Z", "getOffset", "()I", "getDuration", "()J", "getForceDark", "getStyle", "getDismiss", "()Lkotlin/jvm/functions/Function1;", "getPerformAction", "()Lkotlin/jvm/functions/Function0;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", "toString", "guide_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class WidgetGuidePopupParams {
    public static final int $stable = 8;
    private final List<String> avatar;
    private final Function1<Boolean, Unit> dismiss;
    private final long duration;
    private final boolean forceDark;
    private final int offset;
    private final boolean outsideTouchable;
    private final Function0<Unit> performAction;
    private final int style;
    private final String subtitle;
    private final String title;

    public final List<String> component1() {
        return this.avatar;
    }

    public final Function0<Unit> component10() {
        return this.performAction;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.subtitle;
    }

    public final boolean component4() {
        return this.outsideTouchable;
    }

    public final int component5() {
        return this.offset;
    }

    public final long component6() {
        return this.duration;
    }

    public final boolean component7() {
        return this.forceDark;
    }

    public final int component8() {
        return this.style;
    }

    public final Function1<Boolean, Unit> component9() {
        return this.dismiss;
    }

    public final WidgetGuidePopupParams copy(List<String> list, String str, String str2, boolean z, int i, long j2, boolean z2, int i2, Function1<? super Boolean, Unit> function1, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "subtitle");
        Intrinsics.checkNotNullParameter(function1, "dismiss");
        Intrinsics.checkNotNullParameter(function0, "performAction");
        return new WidgetGuidePopupParams(list, str, str2, z, i, j2, z2, i2, function1, function0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WidgetGuidePopupParams) {
            WidgetGuidePopupParams widgetGuidePopupParams = (WidgetGuidePopupParams) obj;
            return Intrinsics.areEqual(this.avatar, widgetGuidePopupParams.avatar) && Intrinsics.areEqual(this.title, widgetGuidePopupParams.title) && Intrinsics.areEqual(this.subtitle, widgetGuidePopupParams.subtitle) && this.outsideTouchable == widgetGuidePopupParams.outsideTouchable && this.offset == widgetGuidePopupParams.offset && this.duration == widgetGuidePopupParams.duration && this.forceDark == widgetGuidePopupParams.forceDark && this.style == widgetGuidePopupParams.style && Intrinsics.areEqual(this.dismiss, widgetGuidePopupParams.dismiss) && Intrinsics.areEqual(this.performAction, widgetGuidePopupParams.performAction);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((this.avatar == null ? 0 : this.avatar.hashCode()) * 31) + this.title.hashCode()) * 31) + this.subtitle.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.outsideTouchable)) * 31) + this.offset) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.duration)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.forceDark)) * 31) + this.style) * 31) + this.dismiss.hashCode()) * 31) + this.performAction.hashCode();
    }

    public String toString() {
        List<String> list = this.avatar;
        String str = this.title;
        String str2 = this.subtitle;
        boolean z = this.outsideTouchable;
        int i = this.offset;
        long j2 = this.duration;
        boolean z2 = this.forceDark;
        int i2 = this.style;
        Function1<Boolean, Unit> function1 = this.dismiss;
        return "WidgetGuidePopupParams(avatar=" + list + ", title=" + str + ", subtitle=" + str2 + ", outsideTouchable=" + z + ", offset=" + i + ", duration=" + j2 + ", forceDark=" + z2 + ", style=" + i2 + ", dismiss=" + function1 + ", performAction=" + this.performAction + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetGuidePopupParams(List<String> list, String title, String subtitle, boolean outsideTouchable, int offset, long duration, boolean forceDark, int style, Function1<? super Boolean, Unit> function1, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics.checkNotNullParameter(function1, "dismiss");
        Intrinsics.checkNotNullParameter(function0, "performAction");
        this.avatar = list;
        this.title = title;
        this.subtitle = subtitle;
        this.outsideTouchable = outsideTouchable;
        this.offset = offset;
        this.duration = duration;
        this.forceDark = forceDark;
        this.style = style;
        this.dismiss = function1;
        this.performAction = function0;
    }

    public /* synthetic */ WidgetGuidePopupParams(List list, String str, String str2, boolean z, int i, long j2, boolean z2, int i2, Function1 function1, Function0 function0, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, str, str2, z, i, (i3 & 32) != 0 ? 10000L : j2, (i3 & 64) != 0 ? false : z2, (i3 & 128) != 0 ? 0 : i2, function1, function0);
    }

    public final List<String> getAvatar() {
        return this.avatar;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final boolean getOutsideTouchable() {
        return this.outsideTouchable;
    }

    public final int getOffset() {
        return this.offset;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final boolean getForceDark() {
        return this.forceDark;
    }

    public final int getStyle() {
        return this.style;
    }

    public final Function1<Boolean, Unit> getDismiss() {
        return this.dismiss;
    }

    public final Function0<Unit> getPerformAction() {
        return this.performAction;
    }
}
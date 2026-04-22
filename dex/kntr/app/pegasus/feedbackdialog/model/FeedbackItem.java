package kntr.app.pegasus.feedbackdialog.model;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import com.bilibili.lib.brouter.uri.Uri;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.router.UrisKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: FeedbackModel.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b-\b\u0087\b\u0018\u00002\u00020\u0001B\u00ad\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\u0014\b\u0002\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\t\u00100\u001a\u00020\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00103\u001a\u00020\bHÆ\u0003J\t\u00104\u001a\u00020\bHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00107\u001a\u00020\rHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00109\u001a\u00020\bHÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010;\u001a\u00020\u0012HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0015\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00160\u0015HÆ\u0003J¯\u0001\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000f\u001a\u00020\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0014\b\u0002\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00160\u0015HÆ\u0001J\u0013\u0010?\u001a\u00020\u00122\b\u0010@\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010A\u001a\u00020\bHÖ\u0001J\t\u0010B\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001cR\u0011\u0010\u000f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001cR\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010(R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001cR\u001d\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010,\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b-\u0010\u001fR\u0011\u0010.\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b/\u0010(¨\u0006C"}, d2 = {"Lkntr/app/pegasus/feedbackdialog/model/FeedbackItem;", "", "id", "", "icon", "", "iconNight", "iconWidth", "", "iconHeight", "title", "subtitle", "type", "Lkntr/app/pegasus/feedbackdialog/model/FeedbackItemType;", "toast", "value", "extend", "isLightPanel", "", "link", "onClick", "Lkotlin/Function1;", "", "<init>", "(JLjava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Lkntr/app/pegasus/feedbackdialog/model/FeedbackItemType;Ljava/lang/String;ILjava/lang/String;ZLjava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getId", "()J", "getIcon", "()Ljava/lang/String;", "getIconNight", "getIconWidth", "()I", "getIconHeight", "getTitle", "getSubtitle", "getType", "()Lkntr/app/pegasus/feedbackdialog/model/FeedbackItemType;", "getToast", "getValue", "getExtend", "()Z", "getLink", "getOnClick", "()Lkotlin/jvm/functions/Function1;", "displayStyle", "getDisplayStyle", "displayValid", "getDisplayValid", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "equals", "other", "hashCode", "toString", "feedbackdialog_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class FeedbackItem {
    public static final int $stable = 0;
    private final String extend;
    private final String icon;
    private final int iconHeight;
    private final String iconNight;
    private final int iconWidth;
    private final long id;
    private final boolean isLightPanel;
    private final String link;
    private final Function1<FeedbackItem, Unit> onClick;
    private final String subtitle;
    private final String title;
    private final String toast;
    private final FeedbackItemType type;
    private final int value;

    public FeedbackItem() {
        this(0L, null, null, 0, 0, null, null, null, null, 0, null, false, null, null, 16383, null);
    }

    public final long component1() {
        return this.id;
    }

    public final int component10() {
        return this.value;
    }

    public final String component11() {
        return this.extend;
    }

    public final boolean component12() {
        return this.isLightPanel;
    }

    public final String component13() {
        return this.link;
    }

    public final Function1<FeedbackItem, Unit> component14() {
        return this.onClick;
    }

    public final String component2() {
        return this.icon;
    }

    public final String component3() {
        return this.iconNight;
    }

    public final int component4() {
        return this.iconWidth;
    }

    public final int component5() {
        return this.iconHeight;
    }

    public final String component6() {
        return this.title;
    }

    public final String component7() {
        return this.subtitle;
    }

    public final FeedbackItemType component8() {
        return this.type;
    }

    public final String component9() {
        return this.toast;
    }

    public final FeedbackItem copy(long j, String str, String str2, int i, int i2, String str3, String str4, FeedbackItemType feedbackItemType, String str5, int i3, String str6, boolean z, String str7, Function1<? super FeedbackItem, Unit> function1) {
        Intrinsics.checkNotNullParameter(feedbackItemType, "type");
        Intrinsics.checkNotNullParameter(function1, "onClick");
        return new FeedbackItem(j, str, str2, i, i2, str3, str4, feedbackItemType, str5, i3, str6, z, str7, function1);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FeedbackItem) {
            FeedbackItem feedbackItem = (FeedbackItem) obj;
            return this.id == feedbackItem.id && Intrinsics.areEqual(this.icon, feedbackItem.icon) && Intrinsics.areEqual(this.iconNight, feedbackItem.iconNight) && this.iconWidth == feedbackItem.iconWidth && this.iconHeight == feedbackItem.iconHeight && Intrinsics.areEqual(this.title, feedbackItem.title) && Intrinsics.areEqual(this.subtitle, feedbackItem.subtitle) && this.type == feedbackItem.type && Intrinsics.areEqual(this.toast, feedbackItem.toast) && this.value == feedbackItem.value && Intrinsics.areEqual(this.extend, feedbackItem.extend) && this.isLightPanel == feedbackItem.isLightPanel && Intrinsics.areEqual(this.link, feedbackItem.link) && Intrinsics.areEqual(this.onClick, feedbackItem.onClick);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.id) * 31) + (this.icon == null ? 0 : this.icon.hashCode())) * 31) + (this.iconNight == null ? 0 : this.iconNight.hashCode())) * 31) + this.iconWidth) * 31) + this.iconHeight) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.subtitle == null ? 0 : this.subtitle.hashCode())) * 31) + this.type.hashCode()) * 31) + (this.toast == null ? 0 : this.toast.hashCode())) * 31) + this.value) * 31) + (this.extend == null ? 0 : this.extend.hashCode())) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isLightPanel)) * 31) + (this.link != null ? this.link.hashCode() : 0)) * 31) + this.onClick.hashCode();
    }

    public String toString() {
        long j = this.id;
        String str = this.icon;
        String str2 = this.iconNight;
        int i = this.iconWidth;
        int i2 = this.iconHeight;
        String str3 = this.title;
        String str4 = this.subtitle;
        FeedbackItemType feedbackItemType = this.type;
        String str5 = this.toast;
        int i3 = this.value;
        String str6 = this.extend;
        boolean z = this.isLightPanel;
        String str7 = this.link;
        return "FeedbackItem(id=" + j + ", icon=" + str + ", iconNight=" + str2 + ", iconWidth=" + i + ", iconHeight=" + i2 + ", title=" + str3 + ", subtitle=" + str4 + ", type=" + feedbackItemType + ", toast=" + str5 + ", value=" + i3 + ", extend=" + str6 + ", isLightPanel=" + z + ", link=" + str7 + ", onClick=" + this.onClick + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FeedbackItem(long id, String icon, String iconNight, int iconWidth, int iconHeight, String title, String subtitle, FeedbackItemType type, String toast, int value, String extend, boolean isLightPanel, String link, Function1<? super FeedbackItem, Unit> function1) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(function1, "onClick");
        this.id = id;
        this.icon = icon;
        this.iconNight = iconNight;
        this.iconWidth = iconWidth;
        this.iconHeight = iconHeight;
        this.title = title;
        this.subtitle = subtitle;
        this.type = type;
        this.toast = toast;
        this.value = value;
        this.extend = extend;
        this.isLightPanel = isLightPanel;
        this.link = link;
        this.onClick = function1;
    }

    public /* synthetic */ FeedbackItem(long j, String str, String str2, int i, int i2, String str3, String str4, FeedbackItemType feedbackItemType, String str5, int i3, String str6, boolean z, String str7, Function1 function1, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0L : j, (i4 & 2) != 0 ? null : str, (i4 & 4) != 0 ? null : str2, (i4 & 8) != 0 ? 20 : i, (i4 & 16) == 0 ? i2 : 20, (i4 & 32) != 0 ? null : str3, (i4 & 64) != 0 ? null : str4, (i4 & 128) != 0 ? FeedbackItemType.DEFAULT : feedbackItemType, (i4 & 256) != 0 ? null : str5, (i4 & 512) != 0 ? 0 : i3, (i4 & 1024) != 0 ? null : str6, (i4 & 2048) == 0 ? z : false, (i4 & 4096) == 0 ? str7 : null, (i4 & 8192) != 0 ? new Function1() { // from class: kntr.app.pegasus.feedbackdialog.model.FeedbackItem$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = FeedbackItem._init_$lambda$0((FeedbackItem) obj);
                return _init_$lambda$0;
            }
        } : function1);
    }

    public final long getId() {
        return this.id;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getIconNight() {
        return this.iconNight;
    }

    public final int getIconWidth() {
        return this.iconWidth;
    }

    public final int getIconHeight() {
        return this.iconHeight;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final FeedbackItemType getType() {
        return this.type;
    }

    public final String getToast() {
        return this.toast;
    }

    public final int getValue() {
        return this.value;
    }

    public final String getExtend() {
        return this.extend;
    }

    public final boolean isLightPanel() {
        return this.isLightPanel;
    }

    public final String getLink() {
        return this.link;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(FeedbackItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    public final Function1<FeedbackItem, Unit> getOnClick() {
        return this.onClick;
    }

    public final int getDisplayStyle() {
        Uri uri;
        String str = this.link;
        return Intrinsics.areEqual((str == null || (uri = UrisKt.toUri(str)) == null) ? null : uri.getQueryParameter("showy_style"), "1") ? 1 : 0;
    }

    public final boolean getDisplayValid() {
        String str = this.title;
        if (!(str != null && (StringsKt.isBlank(str) ^ true))) {
            String str2 = this.icon;
            if (!(str2 != null && (StringsKt.isBlank(str2) ^ true))) {
                return false;
            }
        }
        return true;
    }
}
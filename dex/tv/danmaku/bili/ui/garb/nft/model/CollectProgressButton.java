package tv.danmaku.bili.ui.garb.nft.model;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import com.bilibili.bson.common.Bson;
import com.bilibili.droid.DimenUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: DLCCardRewardModel.kt */
@Bson
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0003J5\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006$"}, d2 = {"Ltv/danmaku/bili/ui/garb/nft/model/CollectProgressButton;", "", "text", "", "uiType", "", "action", "Ltv/danmaku/bili/ui/garb/nft/model/ActionVo;", "report", "Ltv/danmaku/bili/ui/garb/nft/model/ReportVo;", "<init>", "(Ljava/lang/String;ILtv/danmaku/bili/ui/garb/nft/model/ActionVo;Ltv/danmaku/bili/ui/garb/nft/model/ReportVo;)V", "getText", "()Ljava/lang/String;", "getUiType", "()I", "getAction", "()Ltv/danmaku/bili/ui/garb/nft/model/ActionVo;", "getReport", "()Ltv/danmaku/bili/ui/garb/nft/model/ReportVo;", "textColor", "getTextColor", "backgroundDrawable", "Landroid/graphics/drawable/Drawable;", "getBackgroundDrawable", "()Landroid/graphics/drawable/Drawable;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class CollectProgressButton {
    public static final int $stable = 8;
    private final ActionVo action;
    private final transient Drawable backgroundDrawable;
    private final ReportVo report;
    private final String text;
    private final transient int textColor;
    private final int uiType;

    public static /* synthetic */ CollectProgressButton copy$default(CollectProgressButton collectProgressButton, String str, int i, ActionVo actionVo, ReportVo reportVo, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = collectProgressButton.text;
        }
        if ((i2 & 2) != 0) {
            i = collectProgressButton.uiType;
        }
        if ((i2 & 4) != 0) {
            actionVo = collectProgressButton.action;
        }
        if ((i2 & 8) != 0) {
            reportVo = collectProgressButton.report;
        }
        return collectProgressButton.copy(str, i, actionVo, reportVo);
    }

    public final String component1() {
        return this.text;
    }

    public final int component2() {
        return this.uiType;
    }

    public final ActionVo component3() {
        return this.action;
    }

    public final ReportVo component4() {
        return this.report;
    }

    public final CollectProgressButton copy(String str, int i, ActionVo actionVo, ReportVo reportVo) {
        Intrinsics.checkNotNullParameter(str, "text");
        return new CollectProgressButton(str, i, actionVo, reportVo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CollectProgressButton) {
            CollectProgressButton collectProgressButton = (CollectProgressButton) obj;
            return Intrinsics.areEqual(this.text, collectProgressButton.text) && this.uiType == collectProgressButton.uiType && Intrinsics.areEqual(this.action, collectProgressButton.action) && Intrinsics.areEqual(this.report, collectProgressButton.report);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.text.hashCode() * 31) + this.uiType) * 31) + (this.action == null ? 0 : this.action.hashCode())) * 31) + (this.report != null ? this.report.hashCode() : 0);
    }

    public String toString() {
        String str = this.text;
        int i = this.uiType;
        ActionVo actionVo = this.action;
        return "CollectProgressButton(text=" + str + ", uiType=" + i + ", action=" + actionVo + ", report=" + this.report + ")";
    }

    public CollectProgressButton(String text, int uiType, ActionVo action, ReportVo report) {
        int parseColor;
        GradientDrawable gradientDrawable;
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
        this.uiType = uiType;
        this.action = action;
        this.report = report;
        switch (this.uiType) {
            case 0:
                parseColor = Color.parseColor("#4DFFFFFF");
                break;
            case 1:
                parseColor = Color.parseColor("#FFF5BD");
                break;
            case 2:
                parseColor = Color.parseColor("#99FFFFFF");
                break;
            case 3:
                parseColor = Color.parseColor("#FFF5BD");
                break;
            case 4:
                parseColor = Color.parseColor("#FFFFFF");
                break;
            default:
                parseColor = Color.parseColor("#FFFFFF");
                break;
        }
        this.textColor = parseColor;
        switch (this.uiType) {
            case 0:
                GradientDrawable $this$backgroundDrawable_u24lambda_u240 = new GradientDrawable();
                $this$backgroundDrawable_u24lambda_u240.setCornerRadius(100.0f);
                $this$backgroundDrawable_u24lambda_u240.setColor(0);
                $this$backgroundDrawable_u24lambda_u240.setStroke(DimenUtilsKt.dpToPx(0.5f), Color.parseColor("#4DFFFFFF"));
                $this$backgroundDrawable_u24lambda_u240.setCornerRadius(100.0f);
                gradientDrawable = $this$backgroundDrawable_u24lambda_u240;
                break;
            case 1:
                GradientDrawable $this$backgroundDrawable_u24lambda_u241 = new GradientDrawable();
                $this$backgroundDrawable_u24lambda_u241.setCornerRadius(100.0f);
                $this$backgroundDrawable_u24lambda_u241.setColor(0);
                $this$backgroundDrawable_u24lambda_u241.setStroke(DimenUtilsKt.dpToPx(0.5f), Color.parseColor("#B3FFF5BD"));
                gradientDrawable = $this$backgroundDrawable_u24lambda_u241;
                break;
            case 2:
                GradientDrawable $this$backgroundDrawable_u24lambda_u242 = new GradientDrawable();
                $this$backgroundDrawable_u24lambda_u242.setCornerRadius(100.0f);
                $this$backgroundDrawable_u24lambda_u242.setColor(0);
                $this$backgroundDrawable_u24lambda_u242.setStroke(DimenUtilsKt.dpToPx(0.5f), Color.parseColor("#B3FFFFFF"));
                gradientDrawable = $this$backgroundDrawable_u24lambda_u242;
                break;
            case 3:
                GradientDrawable $this$backgroundDrawable_u24lambda_u243 = new GradientDrawable();
                $this$backgroundDrawable_u24lambda_u243.setCornerRadius(100.0f);
                $this$backgroundDrawable_u24lambda_u243.setColor(Color.parseColor("#26FFF5BD"));
                gradientDrawable = $this$backgroundDrawable_u24lambda_u243;
                break;
            case 4:
                GradientDrawable $this$backgroundDrawable_u24lambda_u244 = new GradientDrawable();
                $this$backgroundDrawable_u24lambda_u244.setCornerRadius(100.0f);
                $this$backgroundDrawable_u24lambda_u244.setColor(Color.parseColor("#2EFFFFFF"));
                $this$backgroundDrawable_u24lambda_u244.setStroke(DimenUtilsKt.dpToPx(0.5f), Color.parseColor("#80FFFFFF"));
                gradientDrawable = $this$backgroundDrawable_u24lambda_u244;
                break;
            default:
                gradientDrawable = new ColorDrawable(0);
                break;
        }
        this.backgroundDrawable = gradientDrawable;
    }

    public /* synthetic */ CollectProgressButton(String str, int i, ActionVo actionVo, ReportVo reportVo, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, (i2 & 4) != 0 ? null : actionVo, (i2 & 8) != 0 ? null : reportVo);
    }

    public final String getText() {
        return this.text;
    }

    public final int getUiType() {
        return this.uiType;
    }

    public final ActionVo getAction() {
        return this.action;
    }

    public final ReportVo getReport() {
        return this.report;
    }

    public final int getTextColor() {
        return this.textColor;
    }

    public final Drawable getBackgroundDrawable() {
        return this.backgroundDrawable;
    }
}
package tv.danmaku.bili.ui.main2.mine.modularvip;

import ComposableSingletons$CustomBottomSheetKt$;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;
import tv.danmaku.bili.splash.ad.config.BusinessSplashDefineKt;
import tv.danmaku.bili.ui.main2.api.AccountMine;

/* compiled from: MineVipModel.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Bi\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+H\u0002J\f\u0010,\u001a\b\u0012\u0004\u0012\u00020+0-J\u0010\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0007HÆ\u0003J\t\u00101\u001a\u00020\tHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\rHÆ\u0003J\t\u00104\u001a\u00020\u000fHÆ\u0003J\t\u00105\u001a\u00020\u0011HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0013HÆ\u0003Jp\u00107\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÆ\u0001¢\u0006\u0002\u00108J\u0013\u00109\u001a\u00020\u00032\b\u0010:\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010;\u001a\u00020<HÖ\u0001J\t\u0010=\u001a\u00020>HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0002\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'¨\u0006?"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipModel;", "", "isVip", "", "mid", "", BusinessSplashDefineKt.SPLASH_OPEN_EVENT_BACKGROUND, "Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipBackgroundModel;", "button", "Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipButtonModel;", "buttonIcon", "Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipButtonIconModel;", "logo", "Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipLogoModel;", ReportUtilKt.POS_TITLE, "Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipTitleModel;", "subtitle", "Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipSubtitleModel;", "trackParams", "Ltv/danmaku/bili/ui/main2/api/AccountMine$ModularVipTrackParams;", "<init>", "(Ljava/lang/Boolean;JLtv/danmaku/bili/ui/main2/mine/modularvip/MineVipBackgroundModel;Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipButtonModel;Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipButtonIconModel;Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipLogoModel;Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipTitleModel;Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipSubtitleModel;Ltv/danmaku/bili/ui/main2/api/AccountMine$ModularVipTrackParams;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMid", "()J", "getBackground", "()Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipBackgroundModel;", "getButton", "()Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipButtonModel;", "getButtonIcon", "()Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipButtonIconModel;", "getLogo", "()Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipLogoModel;", "getTitle", "()Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipTitleModel;", "getSubtitle", "()Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipSubtitleModel;", "getTrackParams", "()Ltv/danmaku/bili/ui/main2/api/AccountMine$ModularVipTrackParams;", "getModelByPosition", "Ltv/danmaku/bili/ui/main2/mine/modularvip/IMineVipEnumModel;", "positionType", "Ltv/danmaku/bili/ui/main2/mine/modularvip/PositionType;", "getToReportPositions", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Boolean;JLtv/danmaku/bili/ui/main2/mine/modularvip/MineVipBackgroundModel;Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipButtonModel;Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipButtonIconModel;Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipLogoModel;Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipTitleModel;Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipSubtitleModel;Ltv/danmaku/bili/ui/main2/api/AccountMine$ModularVipTrackParams;)Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipModel;", "equals", "other", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MineVipModel {
    public static final int $stable = 8;
    private final MineVipBackgroundModel background;
    private final MineVipButtonModel button;
    private final MineVipButtonIconModel buttonIcon;
    private final Boolean isVip;
    private final MineVipLogoModel logo;
    private final long mid;
    private final MineVipSubtitleModel subtitle;
    private final MineVipTitleModel title;
    private final AccountMine.ModularVipTrackParams trackParams;

    /* compiled from: MineVipModel.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PositionType.values().length];
            try {
                iArr[PositionType.BACKGROUND.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[PositionType.BUTTON.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[PositionType.ICON.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[PositionType.TITLE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[PositionType.SUBTITLE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[PositionType.LOGO.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[PositionType.NONE.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public MineVipModel() {
        this(null, 0L, null, null, null, null, null, null, null, BR.roleTitle, null);
    }

    public final Boolean component1() {
        return this.isVip;
    }

    public final long component2() {
        return this.mid;
    }

    public final MineVipBackgroundModel component3() {
        return this.background;
    }

    public final MineVipButtonModel component4() {
        return this.button;
    }

    public final MineVipButtonIconModel component5() {
        return this.buttonIcon;
    }

    public final MineVipLogoModel component6() {
        return this.logo;
    }

    public final MineVipTitleModel component7() {
        return this.title;
    }

    public final MineVipSubtitleModel component8() {
        return this.subtitle;
    }

    public final AccountMine.ModularVipTrackParams component9() {
        return this.trackParams;
    }

    public final MineVipModel copy(Boolean bool, long j, MineVipBackgroundModel mineVipBackgroundModel, MineVipButtonModel mineVipButtonModel, MineVipButtonIconModel mineVipButtonIconModel, MineVipLogoModel mineVipLogoModel, MineVipTitleModel mineVipTitleModel, MineVipSubtitleModel mineVipSubtitleModel, AccountMine.ModularVipTrackParams modularVipTrackParams) {
        Intrinsics.checkNotNullParameter(mineVipBackgroundModel, BusinessSplashDefineKt.SPLASH_OPEN_EVENT_BACKGROUND);
        Intrinsics.checkNotNullParameter(mineVipButtonModel, "button");
        Intrinsics.checkNotNullParameter(mineVipTitleModel, ReportUtilKt.POS_TITLE);
        Intrinsics.checkNotNullParameter(mineVipSubtitleModel, "subtitle");
        return new MineVipModel(bool, j, mineVipBackgroundModel, mineVipButtonModel, mineVipButtonIconModel, mineVipLogoModel, mineVipTitleModel, mineVipSubtitleModel, modularVipTrackParams);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MineVipModel) {
            MineVipModel mineVipModel = (MineVipModel) obj;
            return Intrinsics.areEqual(this.isVip, mineVipModel.isVip) && this.mid == mineVipModel.mid && Intrinsics.areEqual(this.background, mineVipModel.background) && Intrinsics.areEqual(this.button, mineVipModel.button) && Intrinsics.areEqual(this.buttonIcon, mineVipModel.buttonIcon) && Intrinsics.areEqual(this.logo, mineVipModel.logo) && Intrinsics.areEqual(this.title, mineVipModel.title) && Intrinsics.areEqual(this.subtitle, mineVipModel.subtitle) && Intrinsics.areEqual(this.trackParams, mineVipModel.trackParams);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((this.isVip == null ? 0 : this.isVip.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.mid)) * 31) + this.background.hashCode()) * 31) + this.button.hashCode()) * 31) + (this.buttonIcon == null ? 0 : this.buttonIcon.hashCode())) * 31) + (this.logo == null ? 0 : this.logo.hashCode())) * 31) + this.title.hashCode()) * 31) + this.subtitle.hashCode()) * 31) + (this.trackParams != null ? this.trackParams.hashCode() : 0);
    }

    public String toString() {
        Boolean bool = this.isVip;
        long j = this.mid;
        MineVipBackgroundModel mineVipBackgroundModel = this.background;
        MineVipButtonModel mineVipButtonModel = this.button;
        MineVipButtonIconModel mineVipButtonIconModel = this.buttonIcon;
        MineVipLogoModel mineVipLogoModel = this.logo;
        MineVipTitleModel mineVipTitleModel = this.title;
        MineVipSubtitleModel mineVipSubtitleModel = this.subtitle;
        return "MineVipModel(isVip=" + bool + ", mid=" + j + ", background=" + mineVipBackgroundModel + ", button=" + mineVipButtonModel + ", buttonIcon=" + mineVipButtonIconModel + ", logo=" + mineVipLogoModel + ", title=" + mineVipTitleModel + ", subtitle=" + mineVipSubtitleModel + ", trackParams=" + this.trackParams + ")";
    }

    public MineVipModel(Boolean isVip, long mid, MineVipBackgroundModel background, MineVipButtonModel button, MineVipButtonIconModel buttonIcon, MineVipLogoModel logo, MineVipTitleModel title, MineVipSubtitleModel subtitle, AccountMine.ModularVipTrackParams trackParams) {
        Intrinsics.checkNotNullParameter(background, BusinessSplashDefineKt.SPLASH_OPEN_EVENT_BACKGROUND);
        Intrinsics.checkNotNullParameter(button, "button");
        Intrinsics.checkNotNullParameter(title, ReportUtilKt.POS_TITLE);
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        this.isVip = isVip;
        this.mid = mid;
        this.background = background;
        this.button = button;
        this.buttonIcon = buttonIcon;
        this.logo = logo;
        this.title = title;
        this.subtitle = subtitle;
        this.trackParams = trackParams;
    }

    public /* synthetic */ MineVipModel(Boolean bool, long j, MineVipBackgroundModel mineVipBackgroundModel, MineVipButtonModel mineVipButtonModel, MineVipButtonIconModel mineVipButtonIconModel, MineVipLogoModel mineVipLogoModel, MineVipTitleModel mineVipTitleModel, MineVipSubtitleModel mineVipSubtitleModel, AccountMine.ModularVipTrackParams modularVipTrackParams, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? 0L : j, (i & 4) != 0 ? new MineVipBackgroundModel(null, null, false, 7, null) : mineVipBackgroundModel, (i & 8) != 0 ? new MineVipButtonModel(null, null, null, null, null, false, 63, null) : mineVipButtonModel, (i & 16) != 0 ? null : mineVipButtonIconModel, (i & 32) != 0 ? null : mineVipLogoModel, (i & 64) != 0 ? new MineVipTitleModel(null, null, null, false, 15, null) : mineVipTitleModel, (i & BR.cover) != 0 ? new MineVipSubtitleModel(null, null, false, 7, null) : mineVipSubtitleModel, (i & BR.hallEnterHotText) == 0 ? modularVipTrackParams : null);
    }

    public final Boolean isVip() {
        return this.isVip;
    }

    public final long getMid() {
        return this.mid;
    }

    public final MineVipBackgroundModel getBackground() {
        return this.background;
    }

    public final MineVipButtonModel getButton() {
        return this.button;
    }

    public final MineVipButtonIconModel getButtonIcon() {
        return this.buttonIcon;
    }

    public final MineVipLogoModel getLogo() {
        return this.logo;
    }

    public final MineVipTitleModel getTitle() {
        return this.title;
    }

    public final MineVipSubtitleModel getSubtitle() {
        return this.subtitle;
    }

    public final AccountMine.ModularVipTrackParams getTrackParams() {
        return this.trackParams;
    }

    private final IMineVipEnumModel getModelByPosition(PositionType positionType) {
        switch (WhenMappings.$EnumSwitchMapping$0[positionType.ordinal()]) {
            case 1:
                return this.background;
            case 2:
                return this.button;
            case 3:
                return this.buttonIcon;
            case 4:
                return this.title;
            case 5:
                return this.subtitle;
            case 6:
                return this.logo;
            case 7:
                return null;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final List<PositionType> getToReportPositions() {
        Iterable $this$filter$iv = PositionType.getEntries();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            PositionType it = (PositionType) element$iv$iv;
            IMineVipEnumModel modelByPosition = getModelByPosition(it);
            boolean z = false;
            if (modelByPosition != null && modelByPosition.getControlledByFrequency()) {
                z = true;
            }
            if (z) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return (List) destination$iv$iv;
    }
}
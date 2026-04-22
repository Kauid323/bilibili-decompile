package tv.danmaku.bili.ui.main2.mine.modularvip;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CancellableContinuation;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main2.api.AccountMine;

/* compiled from: MineVipExtentions.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u000e\u0010\u0003\u001a\u0004\u0018\u00010\u0004*\u00020\u0005H\u0000\u001a#\u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\t2\u0006\u0010\n\u001a\u0002H\b¢\u0006\u0002\u0010\u000b\u001a\u001e\u0010\f\u001a\u00020\u0007\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\t2\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u000f"}, d2 = {"getMineVipModel", "Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipModel;", "Ltv/danmaku/bili/ui/main2/api/AccountMine;", "toColorResource", "Ltv/danmaku/bili/ui/main2/mine/modularvip/ColorResource;", "Ltv/danmaku/bili/ui/main2/api/AccountMine$ModularVipStyle;", "resumeIfActive", "", "T", "Lkotlinx/coroutines/CancellableContinuation;", "value", "(Lkotlinx/coroutines/CancellableContinuation;Ljava/lang/Object;)V", "resumeExceptionIfActive", "e", "", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MineVipExtentionsKt {
    public static final MineVipModel getMineVipModel(AccountMine $this$getMineVipModel) {
        AccountMine.ModularVipSection modular;
        MineVipBackgroundModel mineVipBackgroundModel;
        MineVipButtonModel mineVipButtonModel;
        MineVipLogoModel mineVipLogoModel;
        MineVipButtonIconModel mineVipButtonIconModel;
        MineVipTitleModel mineVipTitleModel;
        MineVipSubtitleModel mineVipSubtitleModel;
        ColorResource fallbackSubtitleColor;
        ColorResource fallbackTitleColor;
        Object obj;
        MineVipButtonIconType mineVipButtonIconType;
        ImageResource imageResource;
        ColorResource fallbackButtonSolidColor;
        ColorResource fallbackButtonTextColor;
        ColorResource fallbackBackgroundColor;
        Boolean isVip = $this$getMineVipModel != null ? Boolean.valueOf($this$getMineVipModel.isEffectiveVip()) : null;
        if ($this$getMineVipModel != null && (modular = $this$getMineVipModel.modularVipSection) != null) {
            long j = $this$getMineVipModel.mid;
            AccountMine.ModularVipBackground it = modular.background;
            if (it != null) {
                String str = it.image;
                if (str == null) {
                    str = "";
                }
                boolean z = it.frequencyControl;
                AccountMine.ModularVipStyle modularVipStyle = it.colorLayer;
                if (modularVipStyle == null || (fallbackBackgroundColor = toColorResource(modularVipStyle)) == null) {
                    fallbackBackgroundColor = MineVipModelKt.getFallbackBackgroundColor();
                }
                mineVipBackgroundModel = new MineVipBackgroundModel(fallbackBackgroundColor, str, z);
            } else {
                mineVipBackgroundModel = new MineVipBackgroundModel(null, null, false, 7, null);
            }
            AccountMine.ModularVipButton it2 = modular.button;
            if (it2 != null) {
                AccountMine.ModularVipStyle modularVipStyle2 = it2.backgroundStyle;
                if (modularVipStyle2 == null || (fallbackButtonSolidColor = toColorResource(modularVipStyle2)) == null) {
                    fallbackButtonSolidColor = MineVipModelKt.getFallbackButtonSolidColor();
                }
                ColorResource colorResource = fallbackButtonSolidColor;
                AccountMine.ModularVipStyle modularVipStyle3 = it2.textStyle;
                if (modularVipStyle3 == null || (fallbackButtonTextColor = toColorResource(modularVipStyle3)) == null) {
                    fallbackButtonTextColor = MineVipModelKt.getFallbackButtonTextColor();
                }
                ColorResource colorResource2 = fallbackButtonTextColor;
                boolean z2 = it2.frequencyControl;
                String str2 = it2.text;
                String str3 = str2 == null ? "" : str2;
                String str4 = it2.url;
                mineVipButtonModel = new MineVipButtonModel(colorResource, it2.style == 1 ? MineVipButtonStyle.STROKE : MineVipButtonStyle.FILL, str3, colorResource2, str4 == null ? "" : str4, z2);
            } else {
                mineVipButtonModel = new MineVipButtonModel(null, null, null, null, null, false, 63, null);
            }
            AccountMine.ModularVipLogo it3 = modular.logo;
            if (it3 != null) {
                boolean z3 = it3.frequencyControl;
                String str5 = it3.lightIcon;
                if (str5 != null && (StringsKt.isBlank(str5) ^ true)) {
                    String str6 = it3.nightIcon;
                    if (str6 != null && (StringsKt.isBlank(str6) ^ true)) {
                        String str7 = it3.lightIcon;
                        Intrinsics.checkNotNull(str7);
                        String str8 = it3.nightIcon;
                        Intrinsics.checkNotNull(str8);
                        imageResource = new ImageResource(str7, str8);
                        mineVipLogoModel = new MineVipLogoModel(imageResource, z3);
                    }
                }
                String str9 = it3.lightIcon;
                if (str9 != null && (StringsKt.isBlank(str9) ^ true)) {
                    String str10 = it3.lightIcon;
                    Intrinsics.checkNotNull(str10);
                    String str11 = it3.lightIcon;
                    Intrinsics.checkNotNull(str11);
                    imageResource = new ImageResource(str10, str11);
                } else {
                    imageResource = null;
                }
                mineVipLogoModel = new MineVipLogoModel(imageResource, z3);
            } else {
                mineVipLogoModel = null;
            }
            AccountMine.ModularVipButtonIcon it4 = modular.buttonIcon;
            if (it4 != null) {
                boolean z4 = false;
                boolean z5 = it4.frequencyControl;
                String str12 = it4.url;
                if (str12 == null) {
                    str12 = "";
                }
                Iterator it5 = MineVipButtonIconType.getEntries().iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it5.next();
                    MineVipButtonIconType e = (MineVipButtonIconType) obj;
                    boolean z6 = z4;
                    if (e.getValue() == it4.iconType) {
                        break;
                    }
                    z4 = z6;
                }
                MineVipButtonIconType mineVipButtonIconType2 = (MineVipButtonIconType) obj;
                if (mineVipButtonIconType2 != null) {
                    mineVipButtonIconType = mineVipButtonIconType2;
                } else {
                    mineVipButtonIconType = MineVipButtonIconType.NONE;
                }
                mineVipButtonIconModel = new MineVipButtonIconModel(mineVipButtonIconType, str12, z5);
            } else {
                mineVipButtonIconModel = null;
            }
            AccountMine.ModularVipTitle it6 = modular.title;
            if (it6 != null) {
                boolean z7 = it6.frequencyControl;
                String str13 = it6.text;
                if (str13 == null) {
                    str13 = "";
                }
                String str14 = it6.url;
                if (str14 == null) {
                    str14 = "";
                }
                AccountMine.ModularVipStyle modularVipStyle4 = it6.style;
                if (modularVipStyle4 == null || (fallbackTitleColor = toColorResource(modularVipStyle4)) == null) {
                    fallbackTitleColor = MineVipModelKt.getFallbackTitleColor();
                }
                mineVipTitleModel = new MineVipTitleModel(str13, fallbackTitleColor, str14, z7);
            } else {
                mineVipTitleModel = new MineVipTitleModel(null, null, null, false, 15, null);
            }
            AccountMine.ModularVipSubtitle it7 = modular.subtitle;
            if (it7 != null) {
                boolean z8 = it7.frequencyControl;
                String str15 = it7.text;
                String str16 = str15 != null ? str15 : "";
                AccountMine.ModularVipStyle modularVipStyle5 = it7.style;
                if (modularVipStyle5 == null || (fallbackSubtitleColor = toColorResource(modularVipStyle5)) == null) {
                    fallbackSubtitleColor = MineVipModelKt.getFallbackSubtitleColor();
                }
                mineVipSubtitleModel = new MineVipSubtitleModel(str16, fallbackSubtitleColor, z8);
            } else {
                mineVipSubtitleModel = new MineVipSubtitleModel(null, null, false, 7, null);
            }
            AccountMine.ModularVipExtra modularVipExtra = modular.extra;
            return new MineVipModel(isVip, j, mineVipBackgroundModel, mineVipButtonModel, mineVipButtonIconModel, mineVipLogoModel, mineVipTitleModel, mineVipSubtitleModel, modularVipExtra != null ? modularVipExtra.trackParams : null);
        }
        return new MineVipModel(isVip, $this$getMineVipModel != null ? $this$getMineVipModel.mid : 0L, null, null, null, null, null, null, null, BR.roleList, null);
    }

    public static final ColorResource toColorResource(AccountMine.ModularVipStyle $this$toColorResource) {
        Integer color;
        Integer color2;
        Intrinsics.checkNotNullParameter($this$toColorResource, "<this>");
        ColorConfig colorConfig = $this$toColorResource.light;
        Long light = (colorConfig == null || (color2 = colorConfig.getColor()) == null) ? null : Long.valueOf(color2.intValue());
        ColorConfig colorConfig2 = $this$toColorResource.dark;
        Long night = (colorConfig2 == null || (color = colorConfig2.getColor()) == null) ? null : Long.valueOf(color.intValue());
        if (light == null || night == null) {
            return null;
        }
        return new ColorResource(light.longValue(), night.longValue());
    }

    public static final <T> void resumeIfActive(CancellableContinuation<? super T> cancellableContinuation, T t) {
        Intrinsics.checkNotNullParameter(cancellableContinuation, "<this>");
        if (cancellableContinuation.isActive()) {
            Result.Companion companion = Result.Companion;
            ((Continuation) cancellableContinuation).resumeWith(Result.constructor-impl(t));
        }
    }

    public static final <T> void resumeExceptionIfActive(CancellableContinuation<? super T> cancellableContinuation, Throwable e) {
        Intrinsics.checkNotNullParameter(cancellableContinuation, "<this>");
        Intrinsics.checkNotNullParameter(e, "e");
        if (cancellableContinuation.isActive()) {
            Result.Companion companion = Result.Companion;
            ((Continuation) cancellableContinuation).resumeWith(Result.constructor-impl(ResultKt.createFailure(e)));
        }
    }
}
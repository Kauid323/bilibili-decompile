package tv.danmaku.bili.ui.main2.mine.widgets;

import android.graphics.drawable.Drawable;
import com.bilibili.app.comm.list.widget.image.ImageResource;
import com.bilibili.app.comm.list.widget.image.ImageResourceKt;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.lib.image2.bean.BitmapTransformation;
import com.bilibili.lib.image2.bean.ImageLoadingListener;
import com.bilibili.lib.image2.bean.ScaleType;
import com.bilibili.lib.ui.garb.Garb;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.config.BusinessSplashDefineKt;
import tv.danmaku.bili.ui.main2.api.AccountMine;
import tv.danmaku.bili.ui.main2.api.VIPSectionStyle;
import tv.danmaku.bili.ui.main2.api.VIPSectionStyles;
import tv.danmaku.bili.utils.GarbExtensionsKt;
import tv.danmaku.bili.utils.GarbStyle;

/* compiled from: MineVipEntranceViewColor.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u001d*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0013H\u0000\u001a&\u0010\"\u001a\u00020#*\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010$\u001a\u00020%2\u0006\u0010!\u001a\u00020\u0013H\u0000\u001a+\u0010&\u001a\u0004\u0018\u00010#*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010'\u001a\u00020%2\u0006\u0010(\u001a\u00020%H\u0007¢\u0006\u0002\u0010)\u001a(\u0010*\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010'\u001a\u00020%2\u0006\u0010(\u001a\u00020%2\u0006\u0010$\u001a\u00020%H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"3\u0010\u0011\u001a\u001a\u0012\u0004\u0012\u00020\u0013\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u00120\u00128@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016\"3\u0010\u0019\u001a\u001a\u0012\u0004\u0012\u00020\u0013\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u00120\u00128@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001a\u0010\u0016¨\u0006+"}, d2 = {"VIP_DAY_NO_DRESS_DEF", "", "DAY_NO_DRESS_DEF", "VIP_NIGHT_NO_DRESS_DEF", "NIGHT_NO_DRESS_DEF", "VIP_DAY_DRESS_DEF", "DAY_DRESS_DEF", "VIP_NIGHT_DRESS_DEF", "NIGHT_DRESS_DEF", "VIP_DAY_NO_DRESS_TEXT_DEF", "DAY_NO_DRESS_TEXT_DEF", "VIP_NIGHT_NO_DRESS_TEXT_DEF", "NIGHT_NO_DRESS_TEXT_DEF", "VIP_DAY_DRESS_TEXT_DEF", "DAY_DRESS_TEXT_DEF", "VIP_NIGHT_DRESS_TEXT_DEF", "NIGHT_DRESS_TEXT_DEF", "fallbackNotVipColors", "", "Ltv/danmaku/bili/ui/main2/mine/widgets/VIPSectionPosition;", "Ltv/danmaku/bili/utils/GarbStyle$Mine;", "getFallbackNotVipColors", "()Ljava/util/Map;", "fallbackNotVipColors$delegate", "Lkotlin/Lazy;", "fallbackVipColors", "getFallbackVipColors", "fallbackVipColors$delegate", "getImageResource", "Lcom/bilibili/app/comm/list/widget/image/ImageResource;", "Ltv/danmaku/bili/ui/main2/api/AccountMine$VIPSectionRevision;", "garb", "Lcom/bilibili/lib/ui/garb/Garb;", "position", "getColor", "", "isVIP", "", "getLegacyColor", "isNight", BusinessSplashDefineKt.SPLASH_OPEN_EVENT_BACKGROUND, "(Ltv/danmaku/bili/ui/main2/api/AccountMine$VIPSectionRevision;Lcom/bilibili/lib/ui/garb/Garb;ZZ)Ljava/lang/Integer;", "getLegacyFallbackColor", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MineVipEntranceViewColorKt {
    private static final long DAY_DRESS_DEF = 4294962417L;
    private static final long DAY_DRESS_TEXT_DEF = 4294928025L;
    private static final long DAY_NO_DRESS_DEF = 4294962417L;
    private static final long DAY_NO_DRESS_TEXT_DEF = 4294928025L;
    private static final long NIGHT_DRESS_DEF = 4294633967L;
    private static final long NIGHT_DRESS_TEXT_DEF = 4292103805L;
    private static final long NIGHT_NO_DRESS_DEF = 4294633967L;
    private static final long NIGHT_NO_DRESS_TEXT_DEF = 4292103805L;
    private static final long VIP_DAY_DRESS_DEF = 4294962417L;
    private static final long VIP_DAY_DRESS_TEXT_DEF = 4294928025L;
    private static final long VIP_DAY_NO_DRESS_DEF = 4294928025L;
    private static final long VIP_DAY_NO_DRESS_TEXT_DEF = 4294967295L;
    private static final long VIP_NIGHT_DRESS_DEF = 4294633967L;
    private static final long VIP_NIGHT_DRESS_TEXT_DEF = 4292103805L;
    private static final long VIP_NIGHT_NO_DRESS_DEF = 4292103805L;
    private static final long VIP_NIGHT_NO_DRESS_TEXT_DEF = 4294967295L;
    private static final Lazy fallbackNotVipColors$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.main2.mine.widgets.MineVipEntranceViewColorKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            Map fallbackNotVipColors_delegate$lambda$0;
            fallbackNotVipColors_delegate$lambda$0 = MineVipEntranceViewColorKt.fallbackNotVipColors_delegate$lambda$0();
            return fallbackNotVipColors_delegate$lambda$0;
        }
    });
    private static final Lazy fallbackVipColors$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.main2.mine.widgets.MineVipEntranceViewColorKt$$ExternalSyntheticLambda1
        public final Object invoke() {
            Map fallbackVipColors_delegate$lambda$0;
            fallbackVipColors_delegate$lambda$0 = MineVipEntranceViewColorKt.fallbackVipColors_delegate$lambda$0();
            return fallbackVipColors_delegate$lambda$0;
        }
    });

    /* compiled from: MineVipEntranceViewColor.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VIPSectionPosition.values().length];
            try {
                iArr[VIPSectionPosition.TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[VIPSectionPosition.SUB_TEXT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[VIPSectionPosition.BUTTON_BACKGROUND.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[VIPSectionPosition.BUTTON_TEXT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[VIPSectionPosition.BACKGROUND.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[VIPSectionPosition.VIP_LOGO.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final Map<VIPSectionPosition, Map<GarbStyle.Mine, Long>> getFallbackNotVipColors() {
        return (Map) fallbackNotVipColors$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map fallbackNotVipColors_delegate$lambda$0() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(VIPSectionPosition.TEXT, MapsKt.mapOf(new Pair[]{TuplesKt.to(GarbStyle.Mine.COLORFUL, 4294928025L), TuplesKt.to(GarbStyle.Mine.PURE_WHITE, 4294928025L), TuplesKt.to(GarbStyle.Mine.NIGHT_NO_DRESS, 4294967295L), TuplesKt.to(GarbStyle.Mine.DAY_DRESS_LIGHT, 4294928025L), TuplesKt.to(GarbStyle.Mine.DAY_DRESS_DARK, 4294928025L), TuplesKt.to(GarbStyle.Mine.NIGHT_DRESS_LIGHT, 4294967295L), TuplesKt.to(GarbStyle.Mine.NIGHT_DRESS_DARK, 4294967295L)})), TuplesKt.to(VIPSectionPosition.SUB_TEXT, MapsKt.mapOf(new Pair[]{TuplesKt.to(GarbStyle.Mine.COLORFUL, 2568493340L), TuplesKt.to(GarbStyle.Mine.PURE_WHITE, 2568493340L), TuplesKt.to(GarbStyle.Mine.NIGHT_NO_DRESS, 3439329279L), TuplesKt.to(GarbStyle.Mine.DAY_DRESS_LIGHT, 2568493340L), TuplesKt.to(GarbStyle.Mine.DAY_DRESS_DARK, 2568493340L), TuplesKt.to(GarbStyle.Mine.NIGHT_DRESS_LIGHT, 3439329279L), TuplesKt.to(GarbStyle.Mine.NIGHT_DRESS_DARK, 3439329279L)})), TuplesKt.to(VIPSectionPosition.BUTTON_BACKGROUND, MapsKt.mapOf(new Pair[]{TuplesKt.to(GarbStyle.Mine.COLORFUL, 4294967295L), TuplesKt.to(GarbStyle.Mine.PURE_WHITE, 4294967295L), TuplesKt.to(GarbStyle.Mine.NIGHT_NO_DRESS, 3690987519L), TuplesKt.to(GarbStyle.Mine.DAY_DRESS_LIGHT, 4294967295L), TuplesKt.to(GarbStyle.Mine.DAY_DRESS_DARK, 4294967295L), TuplesKt.to(GarbStyle.Mine.NIGHT_DRESS_LIGHT, 3690987519L), TuplesKt.to(GarbStyle.Mine.NIGHT_DRESS_DARK, 3690987519L)})), TuplesKt.to(VIPSectionPosition.BUTTON_TEXT, MapsKt.mapOf(new Pair[]{TuplesKt.to(GarbStyle.Mine.COLORFUL, 4294928025L), TuplesKt.to(GarbStyle.Mine.PURE_WHITE, 4294928025L), TuplesKt.to(GarbStyle.Mine.NIGHT_NO_DRESS, 4292103805L), TuplesKt.to(GarbStyle.Mine.DAY_DRESS_LIGHT, 4294928025L), TuplesKt.to(GarbStyle.Mine.DAY_DRESS_DARK, 4294928025L), TuplesKt.to(GarbStyle.Mine.NIGHT_DRESS_LIGHT, 4292103805L), TuplesKt.to(GarbStyle.Mine.NIGHT_DRESS_DARK, 4292103805L)})), TuplesKt.to(VIPSectionPosition.BACKGROUND, MapsKt.mapOf(new Pair[]{TuplesKt.to(GarbStyle.Mine.COLORFUL, 4294962417L), TuplesKt.to(GarbStyle.Mine.PURE_WHITE, 4294962417L), TuplesKt.to(GarbStyle.Mine.NIGHT_NO_DRESS, 4281803564L), TuplesKt.to(GarbStyle.Mine.DAY_DRESS_LIGHT, 4294962417L), TuplesKt.to(GarbStyle.Mine.DAY_DRESS_DARK, 4294962417L), TuplesKt.to(GarbStyle.Mine.NIGHT_DRESS_LIGHT, 4281803564L), TuplesKt.to(GarbStyle.Mine.NIGHT_DRESS_DARK, 4281803564L)}))});
    }

    public static final Map<VIPSectionPosition, Map<GarbStyle.Mine, Long>> getFallbackVipColors() {
        return (Map) fallbackVipColors$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map fallbackVipColors_delegate$lambda$0() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(VIPSectionPosition.TEXT, MapsKt.mapOf(new Pair[]{TuplesKt.to(GarbStyle.Mine.COLORFUL, 4294928025L), TuplesKt.to(GarbStyle.Mine.PURE_WHITE, 4294928025L), TuplesKt.to(GarbStyle.Mine.NIGHT_NO_DRESS, 4294928025L), TuplesKt.to(GarbStyle.Mine.DAY_DRESS_LIGHT, 4294928025L), TuplesKt.to(GarbStyle.Mine.DAY_DRESS_DARK, 4294928025L), TuplesKt.to(GarbStyle.Mine.NIGHT_DRESS_LIGHT, 4294928025L), TuplesKt.to(GarbStyle.Mine.NIGHT_DRESS_DARK, 4294928025L)})), TuplesKt.to(VIPSectionPosition.SUB_TEXT, MapsKt.mapOf(new Pair[]{TuplesKt.to(GarbStyle.Mine.COLORFUL, 4284573293L), TuplesKt.to(GarbStyle.Mine.PURE_WHITE, 4284573293L), TuplesKt.to(GarbStyle.Mine.NIGHT_NO_DRESS, 4284573293L), TuplesKt.to(GarbStyle.Mine.DAY_DRESS_LIGHT, 4284573293L), TuplesKt.to(GarbStyle.Mine.DAY_DRESS_DARK, 4284573293L), TuplesKt.to(GarbStyle.Mine.NIGHT_DRESS_LIGHT, 4284573293L), TuplesKt.to(GarbStyle.Mine.NIGHT_DRESS_DARK, 4284573293L)})), TuplesKt.to(VIPSectionPosition.BUTTON_BACKGROUND, MapsKt.mapOf(new Pair[]{TuplesKt.to(GarbStyle.Mine.COLORFUL, 4294967295L), TuplesKt.to(GarbStyle.Mine.PURE_WHITE, 4294967295L), TuplesKt.to(GarbStyle.Mine.NIGHT_NO_DRESS, 4294967295L), TuplesKt.to(GarbStyle.Mine.DAY_DRESS_LIGHT, 4294967295L), TuplesKt.to(GarbStyle.Mine.DAY_DRESS_DARK, 4294967295L), TuplesKt.to(GarbStyle.Mine.NIGHT_DRESS_LIGHT, 4294967295L), TuplesKt.to(GarbStyle.Mine.NIGHT_DRESS_DARK, 4294967295L)})), TuplesKt.to(VIPSectionPosition.BUTTON_TEXT, MapsKt.mapOf(new Pair[]{TuplesKt.to(GarbStyle.Mine.COLORFUL, 4294928025L), TuplesKt.to(GarbStyle.Mine.PURE_WHITE, 4294928025L), TuplesKt.to(GarbStyle.Mine.NIGHT_NO_DRESS, 4294928025L), TuplesKt.to(GarbStyle.Mine.DAY_DRESS_LIGHT, 4294928025L), TuplesKt.to(GarbStyle.Mine.DAY_DRESS_DARK, 4294928025L), TuplesKt.to(GarbStyle.Mine.NIGHT_DRESS_LIGHT, 4294928025L), TuplesKt.to(GarbStyle.Mine.NIGHT_DRESS_DARK, 4294928025L)})), TuplesKt.to(VIPSectionPosition.BACKGROUND, MapsKt.mapOf(new Pair[]{TuplesKt.to(GarbStyle.Mine.COLORFUL, 4294962417L), TuplesKt.to(GarbStyle.Mine.PURE_WHITE, 4294962417L), TuplesKt.to(GarbStyle.Mine.NIGHT_NO_DRESS, 4281803564L), TuplesKt.to(GarbStyle.Mine.DAY_DRESS_LIGHT, 4294962417L), TuplesKt.to(GarbStyle.Mine.DAY_DRESS_DARK, 4294962417L), TuplesKt.to(GarbStyle.Mine.NIGHT_DRESS_LIGHT, 4281803564L), TuplesKt.to(GarbStyle.Mine.NIGHT_DRESS_DARK, 4281803564L)}))});
    }

    public static final ImageResource getImageResource(AccountMine.VIPSectionRevision $this$getImageResource, Garb garb, VIPSectionPosition position) {
        VIPSectionStyles revision;
        VIPSectionStyle styleByGarb;
        String value;
        String it;
        ImageResource imageResource;
        Integer color;
        Intrinsics.checkNotNullParameter($this$getImageResource, "<this>");
        Intrinsics.checkNotNullParameter(garb, "garb");
        Intrinsics.checkNotNullParameter(position, "position");
        switch (WhenMappings.$EnumSwitchMapping$0[position.ordinal()]) {
            case 1:
                revision = $this$getImageResource.mainTextColor;
                break;
            case 2:
                revision = $this$getImageResource.subTextColor;
                break;
            case 3:
                revision = $this$getImageResource.buttonBackground;
                break;
            case 4:
                revision = $this$getImageResource.buttonTextColor;
                break;
            case 5:
                revision = $this$getImageResource.background;
                break;
            case 6:
                revision = $this$getImageResource.vipLogo;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        ImageResource.PureColor pureColor = null;
        VIPSectionStyle style = revision != null ? revision.getStyleByGarb(garb) : null;
        Integer valueOf = style != null ? Integer.valueOf(style.getType()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            VIPSectionStyle styleByGarb2 = revision.getStyleByGarb(garb);
            if (styleByGarb2 != null && (color = styleByGarb2.getColor()) != null) {
                pureColor = new ImageResource.PureColor(color.intValue(), 0, 2, (DefaultConstructorMarker) null);
            }
            return (ImageResource) pureColor;
        } else if (valueOf == null || valueOf.intValue() != 1 || (styleByGarb = revision.getStyleByGarb(garb)) == null || (value = styleByGarb.getValue()) == null || (it = ListExtentionsKt.takeIfNotBlank(value)) == null) {
            return null;
        } else {
            ImageResource netImage = new ImageResource.NetImage(it, (String) null, (ImageResource) null, (ScaleType) null, (ScaleType) null, (BitmapTransformation) null, (Drawable) null, (Drawable) null, (ImageLoadingListener) null, (int) BR.roleName, (DefaultConstructorMarker) null);
            if (style.getAlpha() != null) {
                if (!Intrinsics.areEqual(style.getAlpha(), 1.0f)) {
                    Float alpha = style.getAlpha();
                    imageResource = (ImageResource) new ImageResource.TransparentImage(alpha != null ? alpha.floatValue() : 1.0f, netImage);
                    return imageResource;
                }
            }
            imageResource = netImage;
            return imageResource;
        }
    }

    public static final int getColor(AccountMine.VIPSectionRevision $this$getColor, Garb garb, boolean isVIP, VIPSectionPosition position) {
        Long l;
        ImageResource imageResource;
        Integer colorInt;
        Intrinsics.checkNotNullParameter(garb, "garb");
        Intrinsics.checkNotNullParameter(position, "position");
        if ($this$getColor == null || (imageResource = getImageResource($this$getColor, garb, position)) == null || (colorInt = ImageResourceKt.getColorInt(imageResource)) == null) {
            GarbStyle.Mine mineStyle = GarbExtensionsKt.getMineStyle(garb);
            Map<GarbStyle.Mine, Long> map = (isVIP ? getFallbackVipColors() : getFallbackNotVipColors()).get(position);
            if (map == null || (l = map.get(mineStyle)) == null) {
                return 0;
            }
            return (int) l.longValue();
        }
        return colorInt.intValue();
    }

    public static final Integer getLegacyColor(AccountMine.VIPSectionRevision $this$getLegacyColor, Garb garb, boolean isNight, boolean background) {
        String str;
        Intrinsics.checkNotNullParameter($this$getLegacyColor, "<this>");
        Intrinsics.checkNotNullParameter(garb, "garb");
        if (garb.isPure()) {
            if (!isNight) {
                if (background) {
                    AccountMine.VIPSectionRevisionBgColor vIPSectionRevisionBgColor = $this$getLegacyColor.bgColor;
                    if (vIPSectionRevisionBgColor != null) {
                        str = vIPSectionRevisionBgColor.dayNoDress;
                    }
                    str = null;
                } else {
                    AccountMine.VIPSectionRevisionTextColor vIPSectionRevisionTextColor = $this$getLegacyColor.textColor;
                    if (vIPSectionRevisionTextColor != null) {
                        str = vIPSectionRevisionTextColor.dayNoDress;
                    }
                    str = null;
                }
            } else if (background) {
                AccountMine.VIPSectionRevisionBgColor vIPSectionRevisionBgColor2 = $this$getLegacyColor.bgColor;
                if (vIPSectionRevisionBgColor2 != null) {
                    str = vIPSectionRevisionBgColor2.nightNoDress;
                }
                str = null;
            } else {
                AccountMine.VIPSectionRevisionTextColor vIPSectionRevisionTextColor2 = $this$getLegacyColor.textColor;
                if (vIPSectionRevisionTextColor2 != null) {
                    str = vIPSectionRevisionTextColor2.nightNoDress;
                }
                str = null;
            }
        } else if (!isNight) {
            if (background) {
                AccountMine.VIPSectionRevisionBgColor vIPSectionRevisionBgColor3 = $this$getLegacyColor.bgColor;
                if (vIPSectionRevisionBgColor3 != null) {
                    str = vIPSectionRevisionBgColor3.dayDress;
                }
                str = null;
            } else {
                AccountMine.VIPSectionRevisionTextColor vIPSectionRevisionTextColor3 = $this$getLegacyColor.textColor;
                if (vIPSectionRevisionTextColor3 != null) {
                    str = vIPSectionRevisionTextColor3.dayDress;
                }
                str = null;
            }
        } else if (background) {
            AccountMine.VIPSectionRevisionBgColor vIPSectionRevisionBgColor4 = $this$getLegacyColor.bgColor;
            if (vIPSectionRevisionBgColor4 != null) {
                str = vIPSectionRevisionBgColor4.nightDress;
            }
            str = null;
        } else {
            AccountMine.VIPSectionRevisionTextColor vIPSectionRevisionTextColor4 = $this$getLegacyColor.textColor;
            if (vIPSectionRevisionTextColor4 != null) {
                str = vIPSectionRevisionTextColor4.nightDress;
            }
            str = null;
        }
        return ListExtentionsKt.toColorOrNull$default(str, (Integer) null, 1, (Object) null);
    }

    public static final int getLegacyFallbackColor(Garb garb, boolean isNight, boolean background, boolean isVIP) {
        Intrinsics.checkNotNullParameter(garb, "garb");
        long j = 4294962417L;
        if (garb.isPure()) {
            if (!isNight) {
                if (isVIP) {
                    j = background ? 4294928025L : 4294967295L;
                } else if (!background) {
                    j = 4294928025L;
                }
            } else if (isVIP) {
                j = background ? 4292103805L : 4294967295L;
            } else {
                j = background ? 4294633967L : 4292103805L;
            }
        } else if (!isNight) {
            if (isVIP) {
                if (!background) {
                    j = 4294928025L;
                }
            } else if (!background) {
                j = 4294928025L;
            }
        } else if (isVIP) {
            j = background ? 4294633967L : 4292103805L;
        } else {
            j = background ? 4294633967L : 4292103805L;
        }
        return (int) j;
    }
}
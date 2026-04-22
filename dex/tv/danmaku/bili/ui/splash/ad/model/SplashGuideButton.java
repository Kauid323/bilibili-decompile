package tv.danmaku.bili.ui.splash.ad.model;

import android.content.Context;
import android.graphics.Color;
import androidx.core.content.ContextCompat;
import com.alibaba.fastjson.annotation.JSONField;
import com.bilibili.app.comm.baseres.R;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.splash.ad.button.model.SplashButtonMaterialType;
import tv.danmaku.bili.ui.splash.ad.util.BusinessSplashResHelper;
import tv.danmaku.bili.videopage.common.performance.PerformanceConstants;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* compiled from: SplashGuideButton.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0010\b\n\u0002\b8\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\"\b\u0007\u0018\u0000 Ì\u00012\u00020\u0001:\u0002Ì\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010¡\u0001\u001a\u00030¢\u0001J\b\u0010\u001a\u001a\u00020WH\u0007J\t\u0010©\u0001\u001a\u00020WH\u0007J\u001d\u0010\u0015\u001a\u00020W2\b\u0010ª\u0001\u001a\u00030«\u00012\t\b\u0002\u0010¬\u0001\u001a\u00020WH\u0007J\t\u0010\u00ad\u0001\u001a\u00020\u000bH\u0007J\t\u0010®\u0001\u001a\u00020\u000bH\u0007J\t\u0010¯\u0001\u001a\u00020\u000bH\u0007J\t\u0010°\u0001\u001a\u00020\u000bH\u0007J\u0014\u0010±\u0001\u001a\u00020W2\t\b\u0002\u0010¬\u0001\u001a\u00020WH\u0007J\u0014\u0010²\u0001\u001a\u00020W2\t\b\u0002\u0010¬\u0001\u001a\u00020WH\u0007J\u0014\u0010³\u0001\u001a\u00020W2\t\b\u0002\u0010¬\u0001\u001a\u00020WH\u0007J\t\u0010´\u0001\u001a\u00020\u000bH\u0007J\t\u0010µ\u0001\u001a\u00020\u000bH\u0007J\u001d\u0010¶\u0001\u001a\u00020W2\t\u0010·\u0001\u001a\u0004\u0018\u00010\u00142\u0007\u0010¬\u0001\u001a\u00020WH\u0002J\b\u0010¸\u0001\u001a\u00030¢\u0001J\b\u0010¹\u0001\u001a\u00030¢\u0001J\u0012\u0010º\u0001\u001a\u00030¢\u00012\b\u0010»\u0001\u001a\u00030¢\u0001J\b\u0010¼\u0001\u001a\u00030¢\u0001J\b\u0010½\u0001\u001a\u00030¢\u0001J\u0012\u0010¾\u0001\u001a\u00030¢\u00012\b\u0010»\u0001\u001a\u00030¢\u0001J\b\u0010¿\u0001\u001a\u00030¢\u0001J\u0012\u0010À\u0001\u001a\u00030¢\u00012\b\u0010»\u0001\u001a\u00030¢\u0001J\b\u0010Á\u0001\u001a\u00030¢\u0001J\n\u0010Â\u0001\u001a\u00030¢\u0001H\u0002J\b\u0010Ã\u0001\u001a\u00030¢\u0001J\b\u0010Ä\u0001\u001a\u00030¢\u0001J\u0012\u0010Å\u0001\u001a\u00030¢\u00012\b\u0010»\u0001\u001a\u00030¢\u0001J\b\u0010Æ\u0001\u001a\u00030¢\u0001J\u0012\u0010Ç\u0001\u001a\u00030¢\u00012\b\u0010»\u0001\u001a\u00030¢\u0001J\b\u0010È\u0001\u001a\u00030¢\u0001J\b\u0010É\u0001\u001a\u00030¢\u0001J\u0012\u0010Ê\u0001\u001a\u00030¢\u00012\b\u0010»\u0001\u001a\u00030¢\u0001J\u0012\u0010Ë\u0001\u001a\u00030¢\u00012\b\u0010»\u0001\u001a\u00030¢\u0001R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR \u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R \u0010\u001c\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R \u0010\u001f\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\u0018R \u0010\"\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R \u0010%\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0016\"\u0004\b'\u0010\u0018R&\u0010(\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001e\u0010/\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\r\"\u0004\b1\u0010\u000fR\u001e\u00102\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\r\"\u0004\b4\u0010\u000fR \u00105\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0016\"\u0004\b7\u0010\u0018R \u00108\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0016\"\u0004\b:\u0010\u0018R \u0010;\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0016\"\u0004\b=\u0010\u0018R \u0010>\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0016\"\u0004\b@\u0010\u0018R \u0010A\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u0016\"\u0004\bC\u0010\u0018R&\u0010D\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010)8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010,\"\u0004\bF\u0010.R&\u0010G\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010)8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010,\"\u0004\bI\u0010.R\u001e\u0010J\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\r\"\u0004\bL\u0010\u000fR\u001e\u0010M\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\r\"\u0004\bO\u0010\u000fR \u0010P\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u0016\"\u0004\bR\u0010\u0018R \u0010S\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\u0016\"\u0004\bU\u0010\u0018R\u001e\u0010V\u001a\u00020W8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R \u0010\\\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010\u0016\"\u0004\b^\u0010\u0018R \u0010_\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\u0016\"\u0004\ba\u0010\u0018R\u001e\u0010b\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010\r\"\u0004\bd\u0010\u000fR \u0010e\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010\u0016\"\u0004\bg\u0010\u0018R \u0010h\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010\u0016\"\u0004\bj\u0010\u0018R \u0010k\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010\u0016\"\u0004\bm\u0010\u0018R \u0010n\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010\u0016\"\u0004\bp\u0010\u0018R \u0010q\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010\u0016\"\u0004\bs\u0010\u0018R\u001e\u0010t\u001a\u00020W8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010Y\"\u0004\bv\u0010[R\u001e\u0010w\u001a\u00020W8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010Y\"\u0004\by\u0010[R \u0010z\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010\u0016\"\u0004\b|\u0010\u0018R \u0010}\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u0010\u0016\"\u0004\b\u007f\u0010\u0018R\u001f\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0081\u0001\u0010\u0016\"\u0005\b\u0082\u0001\u0010\u0018R\u001f\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0084\u0001\u0010\u0016\"\u0005\b\u0085\u0001\u0010\u0018R!\u0010\u0086\u0001\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0087\u0001\u0010\r\"\u0005\b\u0088\u0001\u0010\u000fR!\u0010\u0089\u0001\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008a\u0001\u0010\r\"\u0005\b\u008b\u0001\u0010\u000fR!\u0010\u008c\u0001\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008d\u0001\u0010\r\"\u0005\b\u008e\u0001\u0010\u000fR&\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u0090\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001\"\u0006\b\u0093\u0001\u0010\u0094\u0001R!\u0010\u0095\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0096\u0001\u0010\u0007\"\u0005\b\u0097\u0001\u0010\tR!\u0010\u0098\u0001\u001a\u00020W8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0099\u0001\u0010Y\"\u0005\b\u009a\u0001\u0010[R#\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009c\u0001\u0010\u0016\"\u0005\b\u009d\u0001\u0010\u0018R#\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009f\u0001\u0010\u0016\"\u0005\b \u0001\u0010\u0018R\u0015\u0010£\u0001\u001a\u00030¢\u00018F¢\u0006\b\u001a\u0006\b¤\u0001\u0010¥\u0001R!\u0010¦\u0001\u001a\u00020W8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b§\u0001\u0010Y\"\u0005\b¨\u0001\u0010[¨\u0006Í\u0001"}, d2 = {"Ltv/danmaku/bili/ui/splash/ad/model/SplashGuideButton;", "", "<init>", "()V", "id", "", "getId", "()J", "setId", "(J)V", "x", "", "getX", "()F", "setX", "(F)V", "y", "getY", "setY", "bgColor", "", "getBgColor", "()Ljava/lang/String;", "setBgColor", "(Ljava/lang/String;)V", "textColor", "getTextColor", "setTextColor", "secondaryTextColor", "getSecondaryTextColor", "setSecondaryTextColor", "guideInstructions", "getGuideInstructions", "setGuideInstructions", "secondaryGuideInstructions", "getSecondaryGuideInstructions", "setSecondaryGuideInstructions", "guideInstructionsNew", "getGuideInstructionsNew", "setGuideInstructionsNew", "cards", "", "Ltv/danmaku/bili/ui/splash/ad/model/SplashShopCard;", "getCards", "()Ljava/util/List;", "setCards", "(Ljava/util/List;)V", "width", "getWidth", "setWidth", "fontRatio", "getFontRatio", "setFontRatio", "jumpUrl", "getJumpUrl", "setJumpUrl", PerformanceConstants.EXTRA_KEY_SCHEMA, "getSchema", "setSchema", "schemaTitle", "getSchemaTitle", "setSchemaTitle", "schemaTitleNew", "getSchemaTitleNew", "setSchemaTitleNew", "schemaPackageName", "getSchemaPackageName", "setSchemaPackageName", "schemaList", "getSchemaList", "setSchemaList", "relatedIds", "getRelatedIds", "setRelatedIds", "height", "getHeight", "setHeight", "slideThreshold", "getSlideThreshold", "setSlideThreshold", "sideBorderColor", "getSideBorderColor", "setSideBorderColor", "guideImageUrl", "getGuideImageUrl", "setGuideImageUrl", "interactStyle", "", "getInteractStyle", "()I", "setInteractStyle", "(I)V", "jumpImageUrl", "getJumpImageUrl", "setJumpImageUrl", "schemaImageUrl", "getSchemaImageUrl", "setSchemaImageUrl", "expandRatio", "getExpandRatio", "setExpandRatio", "logoUrl", "getLogoUrl", "setLogoUrl", "logoImageMD5", "getLogoImageMD5", "setLogoImageMD5", "guideImageMD5", "getGuideImageMD5", "setGuideImageMD5", "jumpImageMD5", "getJumpImageMD5", "setJumpImageMD5", "schemaImageMD5", "getSchemaImageMD5", "setSchemaImageMD5", "guideMaterialType", "getGuideMaterialType", "setGuideMaterialType", "extInteractStyle", "getExtInteractStyle", "setExtInteractStyle", "brandCardTitle", "getBrandCardTitle", "setBrandCardTitle", "brandCardDesc", "getBrandCardDesc", "setBrandCardDesc", "actualUsedImageUrl", "getActualUsedImageUrl", "setActualUsedImageUrl", "actualUsedImageHash", "getActualUsedImageHash", "setActualUsedImageHash", "twistSpeed", "getTwistSpeed", "setTwistSpeed", "twistAngle", "getTwistAngle", "setTwistAngle", "twistReverseAngle", "getTwistReverseAngle", "setTwistReverseAngle", "twistStrategy", "Ltv/danmaku/bili/ui/splash/ad/model/TwistStrategy;", "getTwistStrategy", "()Ltv/danmaku/bili/ui/splash/ad/model/TwistStrategy;", "setTwistStrategy", "(Ltv/danmaku/bili/ui/splash/ad/model/TwistStrategy;)V", "activityTime", "getActivityTime", "setActivityTime", "timeShowType", "getTimeShowType", "setTimeShowType", "sideHoleBgColor", "getSideHoleBgColor", "setSideHoleBgColor", "sideHoleBorderColor", "getSideHoleBorderColor", "setSideHoleBorderColor", "isCountDownValid", "", "disableOtherInteractWhenDowngrade", "getDisableOtherInteractWhenDowngrade", "()Z", "degradeType", "getDegradeType", "setDegradeType", "getSubTextColor", "ctx", "Landroid/content/Context;", "def", "getXPercent", "getYPercent", "getWidthPercent", "getHeightPercent", "getBorderColor", "getSlideHoleBgColor", "getSlideHoleBorderColor", "getThresholdPercent", "getExpandRatioPercent", "parseColorOrDefault", "color", "hitSlideStyle", "hitSlideCheckStyleOnly", "hitImageStyle", "jumpThird", "hitImageCheckStyleOnly", "hitTextViewStyle", "hitShakeStyle", "hitShakeCheckStyleOnly", "hitTwistStyle", "hitTwistStyleOnly", "hitShakeNormalCheckStyleOnly", "hitShakeClickCheckStyleOnly", "hitNoInteractViewCheckStyleOnly", "hitNoInteractLottieView", "hitCountDownStyleCheckStyleOnly", "hitCountDownStyle", "hitRunningBallStyle", "hitRunningBallStyleOnly", "hitWebpTwistStyle", "hitWebpSlideStyle", "Companion", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashGuideButton {
    public static final int COUNTDOWN_TYPE_DAY = 3;
    public static final int COUNTDOWN_TYPE_HOUR = 2;
    public static final int COUNTDOWN_TYPE_MINUTE = 1;
    public static final int COUNTDOWN_TYPE_SECOND = 0;
    @JSONField(name = "activity_time")
    private long activityTime;
    @JSONField(name = "bg_color")
    private String bgColor;
    @JSONField(name = "cards")
    private List<SplashShopCard> cards;
    @JSONField(name = "degrade_type")
    private int degradeType;
    @JSONField(name = "click_expand_ratio")
    private float expandRatio;
    @JSONField(name = "ext_interact_style")
    private int extInteractStyle;
    @JSONField(name = "guide_instructions")
    private String guideInstructions;
    @JSONField(name = "guide_instructions_new")
    private String guideInstructionsNew;
    @JSONField(name = "height")
    private float height;
    @JSONField(name = "id")
    private long id;
    @JSONField(name = "interact_style")
    private int interactStyle;
    @JSONField(name = "jump_url")
    private String jumpUrl;
    @JSONField(name = "related_ids")
    private List<Long> relatedIds;
    @JSONField(name = PerformanceConstants.EXTRA_KEY_SCHEMA)
    private String schema;
    @JSONField(name = "schema_list")
    private List<String> schemaList;
    @JSONField(name = "schema_package_name")
    private String schemaPackageName;
    @JSONField(name = "schema_title")
    private String schemaTitle;
    @JSONField(name = "schema_title_new")
    private String schemaTitleNew;
    @JSONField(name = "secondary_guide_instructions")
    private String secondaryGuideInstructions;
    @JSONField(name = "secondary_text_color")
    private String secondaryTextColor;
    @JSONField(name = "slide_threshold_value")
    private float slideThreshold;
    @JSONField(name = "text_color")
    private String textColor;
    @JSONField(name = "time_show_type")
    private int timeShowType;
    @JSONField(name = "twist_reverse_angle")
    private float twistReverseAngle;
    @JSONField(name = "twist_strategy")
    private TwistStrategy twistStrategy;
    @JSONField(name = "width")
    private float width;
    @JSONField(name = "x")
    private float x;
    @JSONField(name = "y")
    private float y;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JSONField(name = "font_ratio")
    private float fontRatio = 0.22f;
    @JSONField(name = "slide_border_color")
    private String sideBorderColor = "";
    @JSONField(name = "guide_image_url")
    private String guideImageUrl = "";
    @JSONField(name = "jump_image_url")
    private String jumpImageUrl = "";
    @JSONField(name = "schema_image_url")
    private String schemaImageUrl = "";
    @JSONField(name = "logo_image_url")
    private String logoUrl = "";
    @JSONField(name = "logo_image_md5")
    private String logoImageMD5 = "";
    @JSONField(name = "guide_image_md5")
    private String guideImageMD5 = "";
    @JSONField(name = "jump_image_md5")
    private String jumpImageMD5 = "";
    @JSONField(name = "schema_image_md5")
    private String schemaImageMD5 = "";
    @JSONField(name = "guide_material_type")
    private int guideMaterialType = SplashButtonMaterialType.LOTTIE.getType();
    @JSONField(name = "brand_card_title")
    private String brandCardTitle = "";
    @JSONField(name = "brand_card_desc")
    private String brandCardDesc = "";
    private String actualUsedImageUrl = "";
    private String actualUsedImageHash = "";
    @JSONField(name = "twist_speed")
    private float twistSpeed = -1.0f;
    @JSONField(name = "twist_angle")
    private float twistAngle = -1.0f;
    @JSONField(name = "slide_ball_bg_color")
    private String sideHoleBgColor = "";
    @JSONField(name = "slide_ball_border_color")
    private String sideHoleBorderColor = "";

    public final long getId() {
        return this.id;
    }

    public final void setId(long j) {
        this.id = j;
    }

    public final float getX() {
        return this.x;
    }

    public final void setX(float f) {
        this.x = f;
    }

    public final float getY() {
        return this.y;
    }

    public final void setY(float f) {
        this.y = f;
    }

    public final String getBgColor() {
        return this.bgColor;
    }

    public final void setBgColor(String str) {
        this.bgColor = str;
    }

    /* renamed from: getTextColor  reason: collision with other method in class */
    public final String m1515getTextColor() {
        return this.textColor;
    }

    public final void setTextColor(String str) {
        this.textColor = str;
    }

    public final String getSecondaryTextColor() {
        return this.secondaryTextColor;
    }

    public final void setSecondaryTextColor(String str) {
        this.secondaryTextColor = str;
    }

    public final String getGuideInstructions() {
        return this.guideInstructions;
    }

    public final void setGuideInstructions(String str) {
        this.guideInstructions = str;
    }

    public final String getSecondaryGuideInstructions() {
        return this.secondaryGuideInstructions;
    }

    public final void setSecondaryGuideInstructions(String str) {
        this.secondaryGuideInstructions = str;
    }

    public final String getGuideInstructionsNew() {
        return this.guideInstructionsNew;
    }

    public final void setGuideInstructionsNew(String str) {
        this.guideInstructionsNew = str;
    }

    public final List<SplashShopCard> getCards() {
        return EnhancedUnmodifiabilityKt.unmodifiable(this.cards);
    }

    public final void setCards(List<SplashShopCard> list) {
        this.cards = list;
    }

    public final float getWidth() {
        return this.width;
    }

    public final void setWidth(float f) {
        this.width = f;
    }

    public final float getFontRatio() {
        return this.fontRatio;
    }

    public final void setFontRatio(float f) {
        this.fontRatio = f;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final void setJumpUrl(String str) {
        this.jumpUrl = str;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final void setSchema(String str) {
        this.schema = str;
    }

    public final String getSchemaTitle() {
        return this.schemaTitle;
    }

    public final void setSchemaTitle(String str) {
        this.schemaTitle = str;
    }

    public final String getSchemaTitleNew() {
        return this.schemaTitleNew;
    }

    public final void setSchemaTitleNew(String str) {
        this.schemaTitleNew = str;
    }

    public final String getSchemaPackageName() {
        return this.schemaPackageName;
    }

    public final void setSchemaPackageName(String str) {
        this.schemaPackageName = str;
    }

    public final List<String> getSchemaList() {
        return EnhancedUnmodifiabilityKt.unmodifiable(this.schemaList);
    }

    public final void setSchemaList(List<String> list) {
        this.schemaList = list;
    }

    public final List<Long> getRelatedIds() {
        return EnhancedUnmodifiabilityKt.unmodifiable(this.relatedIds);
    }

    public final void setRelatedIds(List<Long> list) {
        this.relatedIds = list;
    }

    public final float getHeight() {
        return this.height;
    }

    public final void setHeight(float f) {
        this.height = f;
    }

    public final float getSlideThreshold() {
        return this.slideThreshold;
    }

    public final void setSlideThreshold(float f) {
        this.slideThreshold = f;
    }

    public final String getSideBorderColor() {
        return this.sideBorderColor;
    }

    public final void setSideBorderColor(String str) {
        this.sideBorderColor = str;
    }

    public final String getGuideImageUrl() {
        return this.guideImageUrl;
    }

    public final void setGuideImageUrl(String str) {
        this.guideImageUrl = str;
    }

    public final int getInteractStyle() {
        return this.interactStyle;
    }

    public final void setInteractStyle(int i) {
        this.interactStyle = i;
    }

    public final String getJumpImageUrl() {
        return this.jumpImageUrl;
    }

    public final void setJumpImageUrl(String str) {
        this.jumpImageUrl = str;
    }

    public final String getSchemaImageUrl() {
        return this.schemaImageUrl;
    }

    public final void setSchemaImageUrl(String str) {
        this.schemaImageUrl = str;
    }

    public final float getExpandRatio() {
        return this.expandRatio;
    }

    public final void setExpandRatio(float f) {
        this.expandRatio = f;
    }

    public final String getLogoUrl() {
        return this.logoUrl;
    }

    public final void setLogoUrl(String str) {
        this.logoUrl = str;
    }

    public final String getLogoImageMD5() {
        return this.logoImageMD5;
    }

    public final void setLogoImageMD5(String str) {
        this.logoImageMD5 = str;
    }

    public final String getGuideImageMD5() {
        return this.guideImageMD5;
    }

    public final void setGuideImageMD5(String str) {
        this.guideImageMD5 = str;
    }

    public final String getJumpImageMD5() {
        return this.jumpImageMD5;
    }

    public final void setJumpImageMD5(String str) {
        this.jumpImageMD5 = str;
    }

    public final String getSchemaImageMD5() {
        return this.schemaImageMD5;
    }

    public final void setSchemaImageMD5(String str) {
        this.schemaImageMD5 = str;
    }

    public final int getGuideMaterialType() {
        return this.guideMaterialType;
    }

    public final void setGuideMaterialType(int i) {
        this.guideMaterialType = i;
    }

    public final int getExtInteractStyle() {
        return this.extInteractStyle;
    }

    public final void setExtInteractStyle(int i) {
        this.extInteractStyle = i;
    }

    public final String getBrandCardTitle() {
        return this.brandCardTitle;
    }

    public final void setBrandCardTitle(String str) {
        this.brandCardTitle = str;
    }

    public final String getBrandCardDesc() {
        return this.brandCardDesc;
    }

    public final void setBrandCardDesc(String str) {
        this.brandCardDesc = str;
    }

    public final String getActualUsedImageUrl() {
        return this.actualUsedImageUrl;
    }

    public final void setActualUsedImageUrl(String str) {
        this.actualUsedImageUrl = str;
    }

    public final String getActualUsedImageHash() {
        return this.actualUsedImageHash;
    }

    public final void setActualUsedImageHash(String str) {
        this.actualUsedImageHash = str;
    }

    public final float getTwistSpeed() {
        return this.twistSpeed;
    }

    public final void setTwistSpeed(float f) {
        this.twistSpeed = f;
    }

    public final float getTwistAngle() {
        return this.twistAngle;
    }

    public final void setTwistAngle(float f) {
        this.twistAngle = f;
    }

    public final float getTwistReverseAngle() {
        return this.twistReverseAngle;
    }

    public final void setTwistReverseAngle(float f) {
        this.twistReverseAngle = f;
    }

    public final TwistStrategy getTwistStrategy() {
        return this.twistStrategy;
    }

    public final void setTwistStrategy(TwistStrategy twistStrategy) {
        this.twistStrategy = twistStrategy;
    }

    public final long getActivityTime() {
        return this.activityTime;
    }

    public final void setActivityTime(long j) {
        this.activityTime = j;
    }

    public final int getTimeShowType() {
        return this.timeShowType;
    }

    public final void setTimeShowType(int i) {
        this.timeShowType = i;
    }

    public final String getSideHoleBgColor() {
        return this.sideHoleBgColor;
    }

    public final void setSideHoleBgColor(String str) {
        this.sideHoleBgColor = str;
    }

    public final String getSideHoleBorderColor() {
        return this.sideHoleBorderColor;
    }

    public final void setSideHoleBorderColor(String str) {
        this.sideHoleBorderColor = str;
    }

    public final boolean isCountDownValid() {
        if (this.activityTime <= 0 || this.activityTime - (System.currentTimeMillis() / ((long) IjkMediaCodecInfo.RANK_MAX)) <= 0) {
            return false;
        }
        int i = this.timeShowType;
        return i >= 0 && i < 4;
    }

    public final boolean getDisableOtherInteractWhenDowngrade() {
        return this.degradeType == 1;
    }

    public final int getDegradeType() {
        return this.degradeType;
    }

    public final void setDegradeType(int i) {
        this.degradeType = i;
    }

    @JSONField(deserialize = false, serialize = false)
    public final int getTextColor() {
        return parseColorOrDefault(this.textColor, -1);
    }

    @JSONField(deserialize = false, serialize = false)
    public final int getSubTextColor() {
        return parseColorOrDefault(this.secondaryTextColor, -1);
    }

    public static /* synthetic */ int getBgColor$default(SplashGuideButton splashGuideButton, Context context, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = ContextCompat.getColor(context, R.color.black_alpha50);
        }
        return splashGuideButton.getBgColor(context, i);
    }

    @JSONField(deserialize = false, serialize = false)
    public final int getBgColor(Context context, int def) {
        Context ctx = EnhancedUnmodifiabilityKt.unmodifiable(context);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        return parseColorOrDefault(this.bgColor, def);
    }

    @JSONField(deserialize = false, serialize = false)
    public final float getXPercent() {
        return this.x / 100.0f;
    }

    @JSONField(deserialize = false, serialize = false)
    public final float getYPercent() {
        return this.y / 100.0f;
    }

    @JSONField(deserialize = false, serialize = false)
    public final float getWidthPercent() {
        return this.width / 100.0f;
    }

    @JSONField(deserialize = false, serialize = false)
    public final float getHeightPercent() {
        return this.height / 100.0f;
    }

    public static /* synthetic */ int getBorderColor$default(SplashGuideButton splashGuideButton, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = Color.parseColor("#4DFFFFFF");
        }
        return splashGuideButton.getBorderColor(i);
    }

    @JSONField(deserialize = false, serialize = false)
    public final int getBorderColor(int def) {
        return parseColorOrDefault(this.sideBorderColor, def);
    }

    public static /* synthetic */ int getSlideHoleBgColor$default(SplashGuideButton splashGuideButton, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return splashGuideButton.getSlideHoleBgColor(i);
    }

    @JSONField(deserialize = false, serialize = false)
    public final int getSlideHoleBgColor(int def) {
        return parseColorOrDefault(this.sideHoleBgColor, def);
    }

    public static /* synthetic */ int getSlideHoleBorderColor$default(SplashGuideButton splashGuideButton, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = Color.parseColor("#66FFFFFF");
        }
        return splashGuideButton.getSlideHoleBorderColor(i);
    }

    @JSONField(deserialize = false, serialize = false)
    public final int getSlideHoleBorderColor(int def) {
        return parseColorOrDefault(this.sideHoleBorderColor, def);
    }

    @JSONField(deserialize = false, serialize = false)
    public final float getThresholdPercent() {
        return this.slideThreshold / 100.0f;
    }

    @JSONField(deserialize = false, serialize = false)
    public final float getExpandRatioPercent() {
        return this.expandRatio / 100.0f;
    }

    private final int parseColorOrDefault(String color, int def) {
        try {
            return Color.parseColor(color);
        } catch (Throwable th) {
            return def;
        }
    }

    public final boolean hitSlideStyle() {
        return (this.interactStyle == 1 || this.interactStyle == 2) && BusinessSplashResHelper.isResourceExistByHash(this.logoImageMD5);
    }

    public final boolean hitSlideCheckStyleOnly() {
        return this.interactStyle == 1 || this.interactStyle == 2;
    }

    public final boolean hitImageStyle(boolean jumpThird) {
        if (this.interactStyle != 0) {
            return false;
        }
        this.actualUsedImageUrl = jumpThird ? this.schemaImageUrl : this.jumpImageUrl;
        this.actualUsedImageHash = jumpThird ? this.schemaImageMD5 : this.jumpImageMD5;
        BLog.d("[Splash]SplashGuideButton", "hitImageStyle jumpThird = " + jumpThird + ", actualImage = " + this.actualUsedImageUrl);
        return BusinessSplashResHelper.isResourceExistByHash(this.actualUsedImageHash);
    }

    public final boolean hitImageCheckStyleOnly() {
        return this.interactStyle == 0;
    }

    public final boolean hitTextViewStyle() {
        return this.interactStyle == 3;
    }

    public final boolean hitShakeStyle(boolean jumpThird) {
        if (this.interactStyle != 4 && this.interactStyle != 5) {
            return false;
        }
        this.actualUsedImageUrl = jumpThird ? this.schemaImageUrl : this.jumpImageUrl;
        this.actualUsedImageHash = jumpThird ? this.schemaImageMD5 : this.jumpImageMD5;
        BLog.d("[Splash]SplashGuideButton", "hitShakeStyle jumpThird = " + jumpThird + ", actualImage = " + this.actualUsedImageUrl);
        return BusinessSplashResHelper.isResourceExistByHash(this.actualUsedImageHash);
    }

    public final boolean hitShakeCheckStyleOnly() {
        return hitShakeNormalCheckStyleOnly() || hitShakeClickCheckStyleOnly();
    }

    public final boolean hitTwistStyle(boolean jumpThird) {
        if (this.interactStyle != 7) {
            return false;
        }
        this.actualUsedImageUrl = jumpThird ? this.schemaImageUrl : this.jumpImageUrl;
        this.actualUsedImageHash = jumpThird ? this.schemaImageMD5 : this.jumpImageMD5;
        BLog.d("[Splash]SplashGuideButton", "hitTwistStyle jumpThird = " + jumpThird + ",imageurl = " + this.actualUsedImageUrl);
        return BusinessSplashResHelper.isResourceExistByHash(this.actualUsedImageHash);
    }

    public final boolean hitTwistStyleOnly() {
        return this.interactStyle == 7;
    }

    private final boolean hitShakeNormalCheckStyleOnly() {
        return this.interactStyle == 4;
    }

    public final boolean hitShakeClickCheckStyleOnly() {
        return this.interactStyle == 5;
    }

    public final boolean hitNoInteractViewCheckStyleOnly() {
        return this.interactStyle == 6;
    }

    public final boolean hitNoInteractLottieView(boolean jumpThird) {
        this.actualUsedImageUrl = jumpThird ? this.schemaImageUrl : this.jumpImageUrl;
        this.actualUsedImageHash = jumpThird ? this.schemaImageMD5 : this.jumpImageMD5;
        return this.interactStyle == 6 && BusinessSplashResHelper.isResourceExistByHash(this.actualUsedImageHash);
    }

    public final boolean hitCountDownStyleCheckStyleOnly() {
        return this.interactStyle == 9;
    }

    public final boolean hitCountDownStyle(boolean jumpThird) {
        this.actualUsedImageUrl = jumpThird ? this.schemaImageUrl : this.jumpImageUrl;
        this.actualUsedImageHash = jumpThird ? this.schemaImageMD5 : this.jumpImageMD5;
        return this.interactStyle == 9;
    }

    public final boolean hitRunningBallStyle() {
        if (this.interactStyle != 10) {
            return false;
        }
        return BusinessSplashResHelper.isResourceExistByHash(this.logoImageMD5);
    }

    public final boolean hitRunningBallStyleOnly() {
        return this.interactStyle == 10;
    }

    public final boolean hitWebpTwistStyle(boolean jumpThird) {
        if (this.interactStyle != 17) {
            return false;
        }
        this.actualUsedImageUrl = jumpThird ? this.schemaImageUrl : this.jumpImageUrl;
        this.actualUsedImageHash = jumpThird ? this.schemaImageMD5 : this.jumpImageMD5;
        BLog.d("[Splash]SplashGuideButton", "hitWebpTwistStyle jumpThird = " + jumpThird + ",imageurl = " + this.actualUsedImageUrl);
        return BusinessSplashResHelper.isResourceExistByHash(this.actualUsedImageHash);
    }

    public final boolean hitWebpSlideStyle(boolean jumpThird) {
        if (this.interactStyle != 18) {
            return false;
        }
        this.actualUsedImageUrl = jumpThird ? this.schemaImageUrl : this.jumpImageUrl;
        this.actualUsedImageHash = jumpThird ? this.schemaImageMD5 : this.jumpImageMD5;
        return BusinessSplashResHelper.isResourceExistByHash(this.actualUsedImageHash);
    }

    /* compiled from: SplashGuideButton.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Ltv/danmaku/bili/ui/splash/ad/model/SplashGuideButton$Companion;", "", "<init>", "()V", "COUNTDOWN_TYPE_SECOND", "", "COUNTDOWN_TYPE_MINUTE", "COUNTDOWN_TYPE_HOUR", "COUNTDOWN_TYPE_DAY", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
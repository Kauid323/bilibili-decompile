package kntr.app.ad.common.model;

import java.util.List;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AdAndroidGameInfo.kt */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b@\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 s2\u00020\u0001:\u0002rsBÁ\u0001\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b!\u0010\"B·\u0001\b\u0010\u0012\u0006\u0010#\u001a\u00020\u0004\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\b\u0010$\u001a\u0004\u0018\u00010%¢\u0006\u0004\b!\u0010&J\u0011\u0010U\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u001eHÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010 HÆ\u0003JÃ\u0001\u0010d\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 HÆ\u0001J\u0013\u0010e\u001a\u00020f2\b\u0010g\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010h\u001a\u00020\u0004HÖ\u0001J\t\u0010i\u001a\u00020\u0006HÖ\u0001J%\u0010j\u001a\u00020k2\u0006\u0010l\u001a\u00020\u00002\u0006\u0010m\u001a\u00020n2\u0006\u0010o\u001a\u00020pH\u0001¢\u0006\u0002\bqR$\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010(\u001a\u0004\b,\u0010-R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010(\u001a\u0004\b/\u00100R\u001e\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b1\u0010(\u001a\u0004\b2\u00103R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b4\u0010(\u001a\u0004\b5\u00106R\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b7\u0010(\u001a\u0004\b8\u00109R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b:\u0010(\u001a\u0004\b;\u0010<R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b=\u0010(\u001a\u0004\b>\u0010?R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b@\u0010(\u001a\u0004\bA\u0010BR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bC\u0010(\u001a\u0004\bD\u0010ER\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bF\u0010(\u001a\u0004\bG\u0010HR\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bI\u0010(\u001a\u0004\bJ\u0010KR\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bL\u0010(\u001a\u0004\bM\u0010NR\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bO\u0010(\u001a\u0004\bP\u0010QR\u001e\u0010\u001f\u001a\u0004\u0018\u00010 8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bR\u0010(\u001a\u0004\bS\u0010T¨\u0006t"}, d2 = {"Lkntr/app/ad/common/model/AdAndroidGameInfo;", RoomRecommendViewModel.EMPTY_CURSOR, "moduleSeq", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "bgColor", RoomRecommendViewModel.EMPTY_CURSOR, "moduleGlance", "Lkntr/app/ad/common/model/AdGameGlanceModule;", "moduleQuality", "Lkntr/app/ad/common/model/AdGameQualityModule;", "moduleGift", "Lkntr/app/ad/common/model/AdGameGiftModule;", "moduleSummary", "Lkntr/app/ad/common/model/AdGameSummaryModule;", "moduleDesc", "Lkntr/app/ad/common/model/AdGameDescModule;", "moduleScreenShot", "Lkntr/app/ad/common/model/AdGameScreenShotModule;", "moduleTag", "Lkntr/app/ad/common/model/AdGameTagModule;", "moduleDevIntro", "Lkntr/app/ad/common/model/AdGameDevIntroModule;", "moduleLatestUpdate", "Lkntr/app/ad/common/model/AdGameLatestUpdateModule;", "moduleGrade", "Lkntr/app/ad/common/model/AdGameGradeModule;", "moduleComment", "Lkntr/app/ad/common/model/AdGameCommentModule;", "moduleApkInfo", "Lkntr/app/ad/common/model/AdGameApkInfoModule;", "moduleBookAward", "Lkntr/app/ad/common/model/AdGameBookAwardModule;", "<init>", "(Ljava/util/List;Ljava/lang/String;Lkntr/app/ad/common/model/AdGameGlanceModule;Lkntr/app/ad/common/model/AdGameQualityModule;Lkntr/app/ad/common/model/AdGameGiftModule;Lkntr/app/ad/common/model/AdGameSummaryModule;Lkntr/app/ad/common/model/AdGameDescModule;Lkntr/app/ad/common/model/AdGameScreenShotModule;Lkntr/app/ad/common/model/AdGameTagModule;Lkntr/app/ad/common/model/AdGameDevIntroModule;Lkntr/app/ad/common/model/AdGameLatestUpdateModule;Lkntr/app/ad/common/model/AdGameGradeModule;Lkntr/app/ad/common/model/AdGameCommentModule;Lkntr/app/ad/common/model/AdGameApkInfoModule;Lkntr/app/ad/common/model/AdGameBookAwardModule;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/lang/String;Lkntr/app/ad/common/model/AdGameGlanceModule;Lkntr/app/ad/common/model/AdGameQualityModule;Lkntr/app/ad/common/model/AdGameGiftModule;Lkntr/app/ad/common/model/AdGameSummaryModule;Lkntr/app/ad/common/model/AdGameDescModule;Lkntr/app/ad/common/model/AdGameScreenShotModule;Lkntr/app/ad/common/model/AdGameTagModule;Lkntr/app/ad/common/model/AdGameDevIntroModule;Lkntr/app/ad/common/model/AdGameLatestUpdateModule;Lkntr/app/ad/common/model/AdGameGradeModule;Lkntr/app/ad/common/model/AdGameCommentModule;Lkntr/app/ad/common/model/AdGameApkInfoModule;Lkntr/app/ad/common/model/AdGameBookAwardModule;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getModuleSeq$annotations", "()V", "getModuleSeq", "()Ljava/util/List;", "getBgColor$annotations", "getBgColor", "()Ljava/lang/String;", "getModuleGlance$annotations", "getModuleGlance", "()Lkntr/app/ad/common/model/AdGameGlanceModule;", "getModuleQuality$annotations", "getModuleQuality", "()Lkntr/app/ad/common/model/AdGameQualityModule;", "getModuleGift$annotations", "getModuleGift", "()Lkntr/app/ad/common/model/AdGameGiftModule;", "getModuleSummary$annotations", "getModuleSummary", "()Lkntr/app/ad/common/model/AdGameSummaryModule;", "getModuleDesc$annotations", "getModuleDesc", "()Lkntr/app/ad/common/model/AdGameDescModule;", "getModuleScreenShot$annotations", "getModuleScreenShot", "()Lkntr/app/ad/common/model/AdGameScreenShotModule;", "getModuleTag$annotations", "getModuleTag", "()Lkntr/app/ad/common/model/AdGameTagModule;", "getModuleDevIntro$annotations", "getModuleDevIntro", "()Lkntr/app/ad/common/model/AdGameDevIntroModule;", "getModuleLatestUpdate$annotations", "getModuleLatestUpdate", "()Lkntr/app/ad/common/model/AdGameLatestUpdateModule;", "getModuleGrade$annotations", "getModuleGrade", "()Lkntr/app/ad/common/model/AdGameGradeModule;", "getModuleComment$annotations", "getModuleComment", "()Lkntr/app/ad/common/model/AdGameCommentModule;", "getModuleApkInfo$annotations", "getModuleApkInfo", "()Lkntr/app/ad/common/model/AdGameApkInfoModule;", "getModuleBookAward$annotations", "getModuleBookAward", "()Lkntr/app/ad/common/model/AdGameBookAwardModule;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdAndroidGameInfo {
    private final String bgColor;
    private final AdGameApkInfoModule moduleApkInfo;
    private final AdGameBookAwardModule moduleBookAward;
    private final AdGameCommentModule moduleComment;
    private final AdGameDescModule moduleDesc;
    private final AdGameDevIntroModule moduleDevIntro;
    private final AdGameGiftModule moduleGift;
    private final AdGameGlanceModule moduleGlance;
    private final AdGameGradeModule moduleGrade;
    private final AdGameLatestUpdateModule moduleLatestUpdate;
    private final AdGameQualityModule moduleQuality;
    private final AdGameScreenShotModule moduleScreenShot;
    private final List<Integer> moduleSeq;
    private final AdGameSummaryModule moduleSummary;
    private final AdGameTagModule moduleTag;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.AdAndroidGameInfo$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = AdAndroidGameInfo._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null, null, null, null, null, null, null, null, null, null, null, null, null, null};

    public AdAndroidGameInfo() {
        this((List) null, (String) null, (AdGameGlanceModule) null, (AdGameQualityModule) null, (AdGameGiftModule) null, (AdGameSummaryModule) null, (AdGameDescModule) null, (AdGameScreenShotModule) null, (AdGameTagModule) null, (AdGameDevIntroModule) null, (AdGameLatestUpdateModule) null, (AdGameGradeModule) null, (AdGameCommentModule) null, (AdGameApkInfoModule) null, (AdGameBookAwardModule) null, 32767, (DefaultConstructorMarker) null);
    }

    @SerialName("background_color")
    public static /* synthetic */ void getBgColor$annotations() {
    }

    @SerialName("module13")
    public static /* synthetic */ void getModuleApkInfo$annotations() {
    }

    @SerialName("module14")
    public static /* synthetic */ void getModuleBookAward$annotations() {
    }

    @SerialName("module12")
    public static /* synthetic */ void getModuleComment$annotations() {
    }

    @SerialName("module6")
    public static /* synthetic */ void getModuleDesc$annotations() {
    }

    @SerialName("module9")
    public static /* synthetic */ void getModuleDevIntro$annotations() {
    }

    @SerialName("module4")
    public static /* synthetic */ void getModuleGift$annotations() {
    }

    @SerialName("module1")
    public static /* synthetic */ void getModuleGlance$annotations() {
    }

    @SerialName("module11")
    public static /* synthetic */ void getModuleGrade$annotations() {
    }

    @SerialName("module10")
    public static /* synthetic */ void getModuleLatestUpdate$annotations() {
    }

    @SerialName("module3")
    public static /* synthetic */ void getModuleQuality$annotations() {
    }

    @SerialName("module7")
    public static /* synthetic */ void getModuleScreenShot$annotations() {
    }

    @SerialName("module_seq")
    public static /* synthetic */ void getModuleSeq$annotations() {
    }

    @SerialName("module5")
    public static /* synthetic */ void getModuleSummary$annotations() {
    }

    @SerialName("module8")
    public static /* synthetic */ void getModuleTag$annotations() {
    }

    public final List<Integer> component1() {
        return this.moduleSeq;
    }

    public final AdGameDevIntroModule component10() {
        return this.moduleDevIntro;
    }

    public final AdGameLatestUpdateModule component11() {
        return this.moduleLatestUpdate;
    }

    public final AdGameGradeModule component12() {
        return this.moduleGrade;
    }

    public final AdGameCommentModule component13() {
        return this.moduleComment;
    }

    public final AdGameApkInfoModule component14() {
        return this.moduleApkInfo;
    }

    public final AdGameBookAwardModule component15() {
        return this.moduleBookAward;
    }

    public final String component2() {
        return this.bgColor;
    }

    public final AdGameGlanceModule component3() {
        return this.moduleGlance;
    }

    public final AdGameQualityModule component4() {
        return this.moduleQuality;
    }

    public final AdGameGiftModule component5() {
        return this.moduleGift;
    }

    public final AdGameSummaryModule component6() {
        return this.moduleSummary;
    }

    public final AdGameDescModule component7() {
        return this.moduleDesc;
    }

    public final AdGameScreenShotModule component8() {
        return this.moduleScreenShot;
    }

    public final AdGameTagModule component9() {
        return this.moduleTag;
    }

    public final AdAndroidGameInfo copy(List<Integer> list, String str, AdGameGlanceModule adGameGlanceModule, AdGameQualityModule adGameQualityModule, AdGameGiftModule adGameGiftModule, AdGameSummaryModule adGameSummaryModule, AdGameDescModule adGameDescModule, AdGameScreenShotModule adGameScreenShotModule, AdGameTagModule adGameTagModule, AdGameDevIntroModule adGameDevIntroModule, AdGameLatestUpdateModule adGameLatestUpdateModule, AdGameGradeModule adGameGradeModule, AdGameCommentModule adGameCommentModule, AdGameApkInfoModule adGameApkInfoModule, AdGameBookAwardModule adGameBookAwardModule) {
        return new AdAndroidGameInfo(list, str, adGameGlanceModule, adGameQualityModule, adGameGiftModule, adGameSummaryModule, adGameDescModule, adGameScreenShotModule, adGameTagModule, adGameDevIntroModule, adGameLatestUpdateModule, adGameGradeModule, adGameCommentModule, adGameApkInfoModule, adGameBookAwardModule);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdAndroidGameInfo) {
            AdAndroidGameInfo adAndroidGameInfo = (AdAndroidGameInfo) obj;
            return Intrinsics.areEqual(this.moduleSeq, adAndroidGameInfo.moduleSeq) && Intrinsics.areEqual(this.bgColor, adAndroidGameInfo.bgColor) && Intrinsics.areEqual(this.moduleGlance, adAndroidGameInfo.moduleGlance) && Intrinsics.areEqual(this.moduleQuality, adAndroidGameInfo.moduleQuality) && Intrinsics.areEqual(this.moduleGift, adAndroidGameInfo.moduleGift) && Intrinsics.areEqual(this.moduleSummary, adAndroidGameInfo.moduleSummary) && Intrinsics.areEqual(this.moduleDesc, adAndroidGameInfo.moduleDesc) && Intrinsics.areEqual(this.moduleScreenShot, adAndroidGameInfo.moduleScreenShot) && Intrinsics.areEqual(this.moduleTag, adAndroidGameInfo.moduleTag) && Intrinsics.areEqual(this.moduleDevIntro, adAndroidGameInfo.moduleDevIntro) && Intrinsics.areEqual(this.moduleLatestUpdate, adAndroidGameInfo.moduleLatestUpdate) && Intrinsics.areEqual(this.moduleGrade, adAndroidGameInfo.moduleGrade) && Intrinsics.areEqual(this.moduleComment, adAndroidGameInfo.moduleComment) && Intrinsics.areEqual(this.moduleApkInfo, adAndroidGameInfo.moduleApkInfo) && Intrinsics.areEqual(this.moduleBookAward, adAndroidGameInfo.moduleBookAward);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((this.moduleSeq == null ? 0 : this.moduleSeq.hashCode()) * 31) + (this.bgColor == null ? 0 : this.bgColor.hashCode())) * 31) + (this.moduleGlance == null ? 0 : this.moduleGlance.hashCode())) * 31) + (this.moduleQuality == null ? 0 : this.moduleQuality.hashCode())) * 31) + (this.moduleGift == null ? 0 : this.moduleGift.hashCode())) * 31) + (this.moduleSummary == null ? 0 : this.moduleSummary.hashCode())) * 31) + (this.moduleDesc == null ? 0 : this.moduleDesc.hashCode())) * 31) + (this.moduleScreenShot == null ? 0 : this.moduleScreenShot.hashCode())) * 31) + (this.moduleTag == null ? 0 : this.moduleTag.hashCode())) * 31) + (this.moduleDevIntro == null ? 0 : this.moduleDevIntro.hashCode())) * 31) + (this.moduleLatestUpdate == null ? 0 : this.moduleLatestUpdate.hashCode())) * 31) + (this.moduleGrade == null ? 0 : this.moduleGrade.hashCode())) * 31) + (this.moduleComment == null ? 0 : this.moduleComment.hashCode())) * 31) + (this.moduleApkInfo == null ? 0 : this.moduleApkInfo.hashCode())) * 31) + (this.moduleBookAward != null ? this.moduleBookAward.hashCode() : 0);
    }

    public String toString() {
        List<Integer> list = this.moduleSeq;
        String str = this.bgColor;
        AdGameGlanceModule adGameGlanceModule = this.moduleGlance;
        AdGameQualityModule adGameQualityModule = this.moduleQuality;
        AdGameGiftModule adGameGiftModule = this.moduleGift;
        AdGameSummaryModule adGameSummaryModule = this.moduleSummary;
        AdGameDescModule adGameDescModule = this.moduleDesc;
        AdGameScreenShotModule adGameScreenShotModule = this.moduleScreenShot;
        AdGameTagModule adGameTagModule = this.moduleTag;
        AdGameDevIntroModule adGameDevIntroModule = this.moduleDevIntro;
        AdGameLatestUpdateModule adGameLatestUpdateModule = this.moduleLatestUpdate;
        AdGameGradeModule adGameGradeModule = this.moduleGrade;
        AdGameCommentModule adGameCommentModule = this.moduleComment;
        AdGameApkInfoModule adGameApkInfoModule = this.moduleApkInfo;
        return "AdAndroidGameInfo(moduleSeq=" + list + ", bgColor=" + str + ", moduleGlance=" + adGameGlanceModule + ", moduleQuality=" + adGameQualityModule + ", moduleGift=" + adGameGiftModule + ", moduleSummary=" + adGameSummaryModule + ", moduleDesc=" + adGameDescModule + ", moduleScreenShot=" + adGameScreenShotModule + ", moduleTag=" + adGameTagModule + ", moduleDevIntro=" + adGameDevIntroModule + ", moduleLatestUpdate=" + adGameLatestUpdateModule + ", moduleGrade=" + adGameGradeModule + ", moduleComment=" + adGameCommentModule + ", moduleApkInfo=" + adGameApkInfoModule + ", moduleBookAward=" + this.moduleBookAward + ")";
    }

    /* compiled from: AdAndroidGameInfo.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdAndroidGameInfo$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdAndroidGameInfo;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdAndroidGameInfo> serializer() {
            return AdAndroidGameInfo$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdAndroidGameInfo(int seen0, List moduleSeq, String bgColor, AdGameGlanceModule moduleGlance, AdGameQualityModule moduleQuality, AdGameGiftModule moduleGift, AdGameSummaryModule moduleSummary, AdGameDescModule moduleDesc, AdGameScreenShotModule moduleScreenShot, AdGameTagModule moduleTag, AdGameDevIntroModule moduleDevIntro, AdGameLatestUpdateModule moduleLatestUpdate, AdGameGradeModule moduleGrade, AdGameCommentModule moduleComment, AdGameApkInfoModule moduleApkInfo, AdGameBookAwardModule moduleBookAward, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.moduleSeq = null;
        } else {
            this.moduleSeq = moduleSeq;
        }
        if ((seen0 & 2) == 0) {
            this.bgColor = null;
        } else {
            this.bgColor = bgColor;
        }
        if ((seen0 & 4) == 0) {
            this.moduleGlance = null;
        } else {
            this.moduleGlance = moduleGlance;
        }
        if ((seen0 & 8) == 0) {
            this.moduleQuality = null;
        } else {
            this.moduleQuality = moduleQuality;
        }
        if ((seen0 & 16) == 0) {
            this.moduleGift = null;
        } else {
            this.moduleGift = moduleGift;
        }
        if ((seen0 & 32) == 0) {
            this.moduleSummary = null;
        } else {
            this.moduleSummary = moduleSummary;
        }
        if ((seen0 & 64) == 0) {
            this.moduleDesc = null;
        } else {
            this.moduleDesc = moduleDesc;
        }
        if ((seen0 & 128) == 0) {
            this.moduleScreenShot = null;
        } else {
            this.moduleScreenShot = moduleScreenShot;
        }
        if ((seen0 & 256) == 0) {
            this.moduleTag = null;
        } else {
            this.moduleTag = moduleTag;
        }
        if ((seen0 & 512) == 0) {
            this.moduleDevIntro = null;
        } else {
            this.moduleDevIntro = moduleDevIntro;
        }
        if ((seen0 & 1024) == 0) {
            this.moduleLatestUpdate = null;
        } else {
            this.moduleLatestUpdate = moduleLatestUpdate;
        }
        if ((seen0 & 2048) == 0) {
            this.moduleGrade = null;
        } else {
            this.moduleGrade = moduleGrade;
        }
        if ((seen0 & 4096) == 0) {
            this.moduleComment = null;
        } else {
            this.moduleComment = moduleComment;
        }
        if ((seen0 & 8192) == 0) {
            this.moduleApkInfo = null;
        } else {
            this.moduleApkInfo = moduleApkInfo;
        }
        if ((seen0 & 16384) == 0) {
            this.moduleBookAward = null;
        } else {
            this.moduleBookAward = moduleBookAward;
        }
    }

    public AdAndroidGameInfo(List<Integer> list, String bgColor, AdGameGlanceModule moduleGlance, AdGameQualityModule moduleQuality, AdGameGiftModule moduleGift, AdGameSummaryModule moduleSummary, AdGameDescModule moduleDesc, AdGameScreenShotModule moduleScreenShot, AdGameTagModule moduleTag, AdGameDevIntroModule moduleDevIntro, AdGameLatestUpdateModule moduleLatestUpdate, AdGameGradeModule moduleGrade, AdGameCommentModule moduleComment, AdGameApkInfoModule moduleApkInfo, AdGameBookAwardModule moduleBookAward) {
        this.moduleSeq = list;
        this.bgColor = bgColor;
        this.moduleGlance = moduleGlance;
        this.moduleQuality = moduleQuality;
        this.moduleGift = moduleGift;
        this.moduleSummary = moduleSummary;
        this.moduleDesc = moduleDesc;
        this.moduleScreenShot = moduleScreenShot;
        this.moduleTag = moduleTag;
        this.moduleDevIntro = moduleDevIntro;
        this.moduleLatestUpdate = moduleLatestUpdate;
        this.moduleGrade = moduleGrade;
        this.moduleComment = moduleComment;
        this.moduleApkInfo = moduleApkInfo;
        this.moduleBookAward = moduleBookAward;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(IntSerializer.INSTANCE);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$dto_debug(AdAndroidGameInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.moduleSeq != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, (SerializationStrategy) lazyArr[0].getValue(), self.moduleSeq);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.bgColor != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.bgColor);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.moduleGlance != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, AdGameGlanceModule$$serializer.INSTANCE, self.moduleGlance);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.moduleQuality != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, AdGameQualityModule$$serializer.INSTANCE, self.moduleQuality);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.moduleGift != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, AdGameGiftModule$$serializer.INSTANCE, self.moduleGift);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.moduleSummary != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, AdGameSummaryModule$$serializer.INSTANCE, self.moduleSummary);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.moduleDesc != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, AdGameDescModule$$serializer.INSTANCE, self.moduleDesc);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.moduleScreenShot != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, AdGameScreenShotModule$$serializer.INSTANCE, self.moduleScreenShot);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.moduleTag != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, AdGameTagModule$$serializer.INSTANCE, self.moduleTag);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.moduleDevIntro != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, AdGameDevIntroModule$$serializer.INSTANCE, self.moduleDevIntro);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.moduleLatestUpdate != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, AdGameLatestUpdateModule$$serializer.INSTANCE, self.moduleLatestUpdate);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.moduleGrade != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, AdGameGradeModule$$serializer.INSTANCE, self.moduleGrade);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.moduleComment != null) {
            output.encodeNullableSerializableElement(serialDesc, 12, AdGameCommentModule$$serializer.INSTANCE, self.moduleComment);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || self.moduleApkInfo != null) {
            output.encodeNullableSerializableElement(serialDesc, 13, AdGameApkInfoModule$$serializer.INSTANCE, self.moduleApkInfo);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) || self.moduleBookAward != null) {
            output.encodeNullableSerializableElement(serialDesc, 14, AdGameBookAwardModule$$serializer.INSTANCE, self.moduleBookAward);
        }
    }

    public /* synthetic */ AdAndroidGameInfo(List list, String str, AdGameGlanceModule adGameGlanceModule, AdGameQualityModule adGameQualityModule, AdGameGiftModule adGameGiftModule, AdGameSummaryModule adGameSummaryModule, AdGameDescModule adGameDescModule, AdGameScreenShotModule adGameScreenShotModule, AdGameTagModule adGameTagModule, AdGameDevIntroModule adGameDevIntroModule, AdGameLatestUpdateModule adGameLatestUpdateModule, AdGameGradeModule adGameGradeModule, AdGameCommentModule adGameCommentModule, AdGameApkInfoModule adGameApkInfoModule, AdGameBookAwardModule adGameBookAwardModule, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : adGameGlanceModule, (i & 8) != 0 ? null : adGameQualityModule, (i & 16) != 0 ? null : adGameGiftModule, (i & 32) != 0 ? null : adGameSummaryModule, (i & 64) != 0 ? null : adGameDescModule, (i & 128) != 0 ? null : adGameScreenShotModule, (i & 256) != 0 ? null : adGameTagModule, (i & 512) != 0 ? null : adGameDevIntroModule, (i & 1024) != 0 ? null : adGameLatestUpdateModule, (i & 2048) != 0 ? null : adGameGradeModule, (i & 4096) != 0 ? null : adGameCommentModule, (i & 8192) != 0 ? null : adGameApkInfoModule, (i & 16384) == 0 ? adGameBookAwardModule : null);
    }

    public final List<Integer> getModuleSeq() {
        return this.moduleSeq;
    }

    public final String getBgColor() {
        return this.bgColor;
    }

    public final AdGameGlanceModule getModuleGlance() {
        return this.moduleGlance;
    }

    public final AdGameQualityModule getModuleQuality() {
        return this.moduleQuality;
    }

    public final AdGameGiftModule getModuleGift() {
        return this.moduleGift;
    }

    public final AdGameSummaryModule getModuleSummary() {
        return this.moduleSummary;
    }

    public final AdGameDescModule getModuleDesc() {
        return this.moduleDesc;
    }

    public final AdGameScreenShotModule getModuleScreenShot() {
        return this.moduleScreenShot;
    }

    public final AdGameTagModule getModuleTag() {
        return this.moduleTag;
    }

    public final AdGameDevIntroModule getModuleDevIntro() {
        return this.moduleDevIntro;
    }

    public final AdGameLatestUpdateModule getModuleLatestUpdate() {
        return this.moduleLatestUpdate;
    }

    public final AdGameGradeModule getModuleGrade() {
        return this.moduleGrade;
    }

    public final AdGameCommentModule getModuleComment() {
        return this.moduleComment;
    }

    public final AdGameApkInfoModule getModuleApkInfo() {
        return this.moduleApkInfo;
    }

    public final AdGameBookAwardModule getModuleBookAward() {
        return this.moduleBookAward;
    }
}
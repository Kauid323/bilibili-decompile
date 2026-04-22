package kntr.app.ad.common.model;

import java.util.List;
import kntr.app.ad.common.protocol.IAdInfo;
import kntr.app.ad.common.protocol.IExtraInfo;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
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
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AdSearchBean.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\bE\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 {2\u00020\u0001:\u0002z{B;\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fBa\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u000b\u0010\u0015J\u000b\u0010h\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010i\u001a\u00020\u0005HÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010k\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J=\u0010l\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0001J\u0013\u0010m\u001a\u00020\u00122\b\u0010n\u001a\u0004\u0018\u00010oHÖ\u0003J\t\u0010p\u001a\u00020\u0005HÖ\u0001J\t\u0010q\u001a\u00020\u0003HÖ\u0001J%\u0010r\u001a\u00020s2\u0006\u0010t\u001a\u00020\u00002\u0006\u0010u\u001a\u00020v2\u0006\u0010w\u001a\u00020xH\u0001¢\u0006\u0002\byR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0016\u0010(\u001a\u0004\u0018\u00010)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010'R\u0016\u0010-\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u0017R\u0014\u0010/\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0016\u00102\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u0010\u0017R\u0014\u00104\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b5\u00101R\u0016\u00106\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u0010\u0017R\u0014\u00108\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b9\u00101R\u0014\u0010:\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u00101R\u0014\u0010<\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b=\u00101R\u0014\u0010>\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b?\u00101R\u0014\u0010@\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bA\u0010\u001bR\u0014\u0010B\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bC\u00101R\u0014\u0010D\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bE\u0010\u001bR\u0016\u0010F\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bG\u0010\u0017R\u0014\u0010H\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bI\u00101R\u0014\u0010J\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bK\u00101R\u0014\u0010L\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bM\u00101R\u0014\u0010N\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bO\u0010\u001bR\u0016\u0010P\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010\u0017R\u0016\u0010R\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bS\u0010\u0017R\u0014\u0010T\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bU\u00101R\u0014\u0010V\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bW\u0010\u001bR\u0016\u0010X\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bY\u0010\u0017R\u0014\u0010Z\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b[\u00101R\u0014\u0010\\\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b]\u0010\u001bR\u0014\u0010^\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b_\u00101R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\u0017\"\u0004\ba\u0010\u0019R\u001a\u0010\u000f\u001a\u00020\u0010X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u00101\"\u0004\bc\u0010dR\u001a\u0010\u0011\u001a\u00020\u0012X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010'\"\u0004\bf\u0010g¨\u0006|"}, d2 = {"Lkntr/app/ad/common/model/AdSearchBean;", "Lkntr/app/ad/common/protocol/IAdInfo;", "goTo", RoomRecommendViewModel.EMPTY_CURSOR, "position", RoomRecommendViewModel.EMPTY_CURSOR, "adInfo", "Lkntr/app/ad/common/model/AdInfo;", "adVideos", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/common/model/AdSearchVideo;", "<init>", "(Ljava/lang/String;ILkntr/app/ad/common/model/AdInfo;Ljava/util/List;)V", "seen0", "cardType", "avid", RoomRecommendViewModel.EMPTY_CURSOR, "buttonShow", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ILkntr/app/ad/common/model/AdInfo;Ljava/util/List;Ljava/lang/String;JZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getGoTo", "()Ljava/lang/String;", "setGoTo", "(Ljava/lang/String;)V", "getPosition", "()I", "setPosition", "(I)V", "getAdInfo", "()Lkntr/app/ad/common/model/AdInfo;", "setAdInfo", "(Lkntr/app/ad/common/model/AdInfo;)V", "getAdVideos", "()Ljava/util/List;", "setAdVideos", "(Ljava/util/List;)V", "isAdLoc", "()Z", "extra", "Lkntr/app/ad/common/protocol/IExtraInfo;", "getExtra", "()Lkntr/app/ad/common/protocol/IExtraInfo;", "isAd", "adCb", "getAdCb", "sourceId", "getSourceId", "()J", "requestId", "getRequestId", "creativeId", "getCreativeId", ReportBuildInParam.IP, "getIp", "resourceId", "getResourceId", "index", "getIndex", "cardIndex", "getCardIndex", "serverType", "getServerType", "cmMark", "getCmMark", "creativeType", "getCreativeType", "creativeStyle", "getCreativeStyle", "track_id", "getTrack_id", "shopId", "getShopId", "upMid", "getUpMid", "productId", "getProductId", "replaceStrategy", "getReplaceStrategy", "fromTrackId", "getFromTrackId", "cmFromTrackId", "getCmFromTrackId", "itemId", "getItemId", "itemSource", "getItemSource", "extraParams", "getExtraParams", ReportBuildInParam.ID, "getId", "natureAd", "getNatureAd", "liveBookingId", "getLiveBookingId", "getCardType", "setCardType", "getAvid", "setAvid", "(J)V", "getButtonShow", "setButtonShow", "(Z)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdSearchBean implements IAdInfo {
    private AdInfo adInfo;
    private List<AdSearchVideo> adVideos;
    private long avid;
    private boolean buttonShow;
    private String cardType;
    private String goTo;
    private int position;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.AdSearchBean$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = AdSearchBean._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null, null, null};

    public AdSearchBean() {
        this(null, 0, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AdSearchBean copy$default(AdSearchBean adSearchBean, String str, int i, AdInfo adInfo, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = adSearchBean.goTo;
        }
        if ((i2 & 2) != 0) {
            i = adSearchBean.position;
        }
        if ((i2 & 4) != 0) {
            adInfo = adSearchBean.adInfo;
        }
        if ((i2 & 8) != 0) {
            list = adSearchBean.adVideos;
        }
        return adSearchBean.copy(str, i, adInfo, list);
    }

    public final String component1() {
        return this.goTo;
    }

    public final int component2() {
        return this.position;
    }

    public final AdInfo component3() {
        return this.adInfo;
    }

    public final List<AdSearchVideo> component4() {
        return this.adVideos;
    }

    public final AdSearchBean copy(String str, int i, AdInfo adInfo, List<AdSearchVideo> list) {
        return new AdSearchBean(str, i, adInfo, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdSearchBean) {
            AdSearchBean adSearchBean = (AdSearchBean) obj;
            return Intrinsics.areEqual(this.goTo, adSearchBean.goTo) && this.position == adSearchBean.position && Intrinsics.areEqual(this.adInfo, adSearchBean.adInfo) && Intrinsics.areEqual(this.adVideos, adSearchBean.adVideos);
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.goTo == null ? 0 : this.goTo.hashCode()) * 31) + this.position) * 31) + (this.adInfo == null ? 0 : this.adInfo.hashCode())) * 31) + (this.adVideos != null ? this.adVideos.hashCode() : 0);
    }

    public String toString() {
        String str = this.goTo;
        int i = this.position;
        AdInfo adInfo = this.adInfo;
        return "AdSearchBean(goTo=" + str + ", position=" + i + ", adInfo=" + adInfo + ", adVideos=" + this.adVideos + ")";
    }

    /* compiled from: AdSearchBean.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdSearchBean$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdSearchBean;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdSearchBean> serializer() {
            return new GeneratedSerializer<AdSearchBean>() { // from class: kntr.app.ad.common.model.AdSearchBean$$serializer
                private static final SerialDescriptor descriptor;

                public final SerialDescriptor getDescriptor() {
                    return descriptor;
                }

                static {
                    SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.ad.common.model.AdSearchBean", 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                          (wrap: kotlinx.serialization.KSerializer<kntr.app.ad.common.model.AdSearchBean> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.app.ad.common.model.AdSearchBean> A[REMOVE]) =  kntr.app.ad.common.model.AdSearchBean$$serializer.INSTANCE kntr.app.ad.common.model.AdSearchBean$$serializer)
                         in method: kntr.app.ad.common.model.AdSearchBean.Companion.serializer():kotlinx.serialization.KSerializer<kntr.app.ad.common.model.AdSearchBean>, file: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:309)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:272)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:296)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:275)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:377)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:306)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:272)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                        	at java.util.ArrayList.forEach(ArrayList.java:1257)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:390)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Method generation error
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:309)
                        	... 5 more
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0010: CONSTRUCTOR  (r0v1 'pluginGeneratedSerialDescriptor' kotlinx.serialization.descriptors.SerialDescriptor) = 
                          ("kntr.app.ad.common.model.AdSearchBean")
                          (wrap: kntr.app.ad.common.model.AdSearchBean$$serializer : 0x0009: SGET  (r1v0 kntr.app.ad.common.model.AdSearchBean$$serializer A[REMOVE]) =  kntr.app.ad.common.model.AdSearchBean$$serializer.INSTANCE kntr.app.ad.common.model.AdSearchBean$$serializer)
                          (7 int)
                         call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.app.ad.common.model.AdSearchBean$$serializer.<clinit>():void, file: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:309)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:272)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:296)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:275)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:377)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:306)
                        	... 5 more
                        Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.app.ad.common.model.AdSearchBean$$serializer
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:775)
                        	at jadx.core.codegen.InsnGen.staticField(InsnGen.java:224)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:491)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:144)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1097)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:765)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:417)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:302)
                        	... 15 more
                        */
                    /*
                        this = this;
                        kntr.app.ad.common.model.AdSearchBean$$serializer r0 = kntr.app.ad.common.model.AdSearchBean$$serializer.INSTANCE
                        kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kntr.app.ad.common.model.AdSearchBean.Companion.serializer():kotlinx.serialization.KSerializer");
                }
            }

            public /* synthetic */ AdSearchBean(int seen0, String goTo, int position, AdInfo adInfo, List adVideos, String cardType, long avid, boolean buttonShow, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.goTo = null;
                } else {
                    this.goTo = goTo;
                }
                boolean z = false;
                if ((seen0 & 2) == 0) {
                    this.position = 0;
                } else {
                    this.position = position;
                }
                if ((seen0 & 4) == 0) {
                    this.adInfo = null;
                } else {
                    this.adInfo = adInfo;
                }
                if ((seen0 & 8) == 0) {
                    this.adVideos = null;
                } else {
                    this.adVideos = adVideos;
                }
                if ((seen0 & 16) == 0) {
                    AdInfo adInfo2 = this.adInfo;
                    this.cardType = adInfo2 != null ? adInfo2.getCardType() : null;
                } else {
                    this.cardType = cardType;
                }
                if ((seen0 & 32) == 0) {
                    AdInfo adInfo3 = this.adInfo;
                    this.avid = adInfo3 != null ? adInfo3.getId() : 0L;
                } else {
                    this.avid = avid;
                }
                if ((seen0 & 64) != 0) {
                    this.buttonShow = buttonShow;
                    return;
                }
                AdInfo adInfo4 = this.adInfo;
                if (adInfo4 != null && adInfo4.getButtonShow()) {
                    z = true;
                }
                this.buttonShow = z;
            }

            public AdSearchBean(String goTo, int position, AdInfo adInfo, List<AdSearchVideo> list) {
                this.goTo = goTo;
                this.position = position;
                this.adInfo = adInfo;
                this.adVideos = list;
                AdInfo adInfo2 = this.adInfo;
                this.cardType = adInfo2 != null ? adInfo2.getCardType() : null;
                AdInfo adInfo3 = this.adInfo;
                this.avid = adInfo3 != null ? adInfo3.getId() : 0L;
                AdInfo adInfo4 = this.adInfo;
                boolean z = false;
                if (adInfo4 != null && adInfo4.getButtonShow()) {
                    z = true;
                }
                this.buttonShow = z;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                return new ArrayListSerializer(AdSearchVideo$$serializer.INSTANCE);
            }

            /* JADX WARN: Code restructure failed: missing block: B:73:0x00da, code lost:
                if (r2 != (r4 != null && r4.getButtonShow())) goto L33;
             */
            /* JADX WARN: Removed duplicated region for block: B:50:0x008c  */
            /* JADX WARN: Removed duplicated region for block: B:54:0x00a0  */
            /* JADX WARN: Removed duplicated region for block: B:63:0x00b8  */
            /* JADX WARN: Removed duplicated region for block: B:67:0x00c8  */
            /* JADX WARN: Removed duplicated region for block: B:76:0x00df  */
            /* JADX WARN: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
            @JvmStatic
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public static final /* synthetic */ void write$Self$dto_debug(AdSearchBean self, CompositeEncoder output, SerialDescriptor serialDesc) {
                boolean z;
                boolean z2;
                Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                boolean z3 = false;
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.goTo != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.goTo);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.position != 0) {
                    output.encodeIntElement(serialDesc, 1, self.position);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.adInfo != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, AdInfo$$serializer.INSTANCE, self.adInfo);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.adVideos != null) {
                    output.encodeNullableSerializableElement(serialDesc, 3, (SerializationStrategy) lazyArr[3].getValue(), self.adVideos);
                }
                if (!output.shouldEncodeElementDefault(serialDesc, 4)) {
                    String cardType = self.getCardType();
                    AdInfo adInfo = self.adInfo;
                    if (Intrinsics.areEqual(cardType, adInfo != null ? adInfo.getCardType() : null)) {
                        z = false;
                        if (z) {
                            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.getCardType());
                        }
                        if (!output.shouldEncodeElementDefault(serialDesc, 5)) {
                            long avid = self.getAvid();
                            AdInfo adInfo2 = self.adInfo;
                            if (avid == (adInfo2 != null ? adInfo2.getId() : 0L)) {
                                z2 = false;
                                if (z2) {
                                    output.encodeLongElement(serialDesc, 5, self.getAvid());
                                }
                                if (!output.shouldEncodeElementDefault(serialDesc, 6)) {
                                    boolean buttonShow = self.getButtonShow();
                                    AdInfo adInfo3 = self.adInfo;
                                }
                                z3 = true;
                                if (z3) {
                                    output.encodeBooleanElement(serialDesc, 6, self.getButtonShow());
                                    return;
                                }
                                return;
                            }
                        }
                        z2 = true;
                        if (z2) {
                        }
                        if (!output.shouldEncodeElementDefault(serialDesc, 6)) {
                        }
                        z3 = true;
                        if (z3) {
                        }
                    }
                }
                z = true;
                if (z) {
                }
                if (!output.shouldEncodeElementDefault(serialDesc, 5)) {
                }
                z2 = true;
                if (z2) {
                }
                if (!output.shouldEncodeElementDefault(serialDesc, 6)) {
                }
                z3 = true;
                if (z3) {
                }
            }

            public /* synthetic */ AdSearchBean(String str, int i, AdInfo adInfo, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? null : adInfo, (i2 & 8) != 0 ? null : list);
            }

            public final String getGoTo() {
                return this.goTo;
            }

            public final void setGoTo(String str) {
                this.goTo = str;
            }

            public final int getPosition() {
                return this.position;
            }

            public final void setPosition(int i) {
                this.position = i;
            }

            public final AdInfo getAdInfo() {
                return this.adInfo;
            }

            public final void setAdInfo(AdInfo adInfo) {
                this.adInfo = adInfo;
            }

            public final List<AdSearchVideo> getAdVideos() {
                return this.adVideos;
            }

            public final void setAdVideos(List<AdSearchVideo> list) {
                this.adVideos = list;
            }

            @Override // kntr.app.ad.protocol.report.IReportable
            public boolean isAdLoc() {
                AdInfo adInfo = this.adInfo;
                return adInfo != null && adInfo.isAdLoc();
            }

            @Override // kntr.app.ad.common.protocol.IAdInfo
            public IExtraInfo getExtra() {
                AdInfo adInfo = this.adInfo;
                return adInfo != null ? adInfo.getExtra() : null;
            }

            @Override // kntr.app.ad.protocol.report.IReportable
            public boolean isAd() {
                AdInfo adInfo = this.adInfo;
                if (adInfo != null) {
                    return adInfo.isAd();
                }
                return false;
            }

            @Override // kntr.app.ad.protocol.report.IReportable
            public String getAdCb() {
                AdInfo adInfo = this.adInfo;
                if (adInfo != null) {
                    return adInfo.getAdCb();
                }
                return null;
            }

            @Override // kntr.app.ad.protocol.report.IReportable
            public long getSourceId() {
                AdInfo adInfo = this.adInfo;
                if (adInfo != null) {
                    return adInfo.getSourceId();
                }
                return 0L;
            }

            @Override // kntr.app.ad.protocol.report.IReportable
            public String getRequestId() {
                AdInfo adInfo = this.adInfo;
                if (adInfo != null) {
                    return adInfo.getRequestId();
                }
                return null;
            }

            @Override // kntr.app.ad.protocol.report.IReportable
            public long getCreativeId() {
                AdInfo adInfo = this.adInfo;
                if (adInfo != null) {
                    return adInfo.getCreativeId();
                }
                return 0L;
            }

            @Override // kntr.app.ad.protocol.report.IReportable
            public String getIp() {
                AdInfo adInfo = this.adInfo;
                if (adInfo != null) {
                    return adInfo.getIp();
                }
                return null;
            }

            @Override // kntr.app.ad.protocol.report.IReportable
            public long getResourceId() {
                AdInfo adInfo = this.adInfo;
                if (adInfo != null) {
                    return adInfo.getResourceId();
                }
                return 0L;
            }

            @Override // kntr.app.ad.protocol.report.IReportable
            public long getIndex() {
                AdInfo adInfo = this.adInfo;
                if (adInfo != null) {
                    return adInfo.getIndex();
                }
                return 0L;
            }

            @Override // kntr.app.ad.protocol.report.IReportable
            public long getCardIndex() {
                AdInfo adInfo = this.adInfo;
                if (adInfo != null) {
                    return adInfo.getCardIndex();
                }
                return -1L;
            }

            @Override // kntr.app.ad.protocol.report.IReportable
            public long getServerType() {
                AdInfo adInfo = this.adInfo;
                if (adInfo != null) {
                    return adInfo.getServerType();
                }
                return -1L;
            }

            @Override // kntr.app.ad.protocol.report.IReportable
            public int getCmMark() {
                AdInfo adInfo = this.adInfo;
                if (adInfo != null) {
                    return adInfo.getCmMark();
                }
                return 0;
            }

            @Override // kntr.app.ad.protocol.report.IReportable
            public long getCreativeType() {
                AdInfo adInfo = this.adInfo;
                if (adInfo != null) {
                    return adInfo.getCreativeType();
                }
                return 0L;
            }

            @Override // kntr.app.ad.protocol.report.IReportable
            public int getCreativeStyle() {
                AdInfo adInfo = this.adInfo;
                if (adInfo != null) {
                    return adInfo.getCreativeStyle();
                }
                return 0;
            }

            @Override // kntr.app.ad.protocol.report.IReportable
            public String getTrack_id() {
                AdInfo adInfo = this.adInfo;
                if (adInfo != null) {
                    return adInfo.getTrack_id();
                }
                return null;
            }

            @Override // kntr.app.ad.protocol.report.IReportable
            public long getShopId() {
                AdInfo adInfo = this.adInfo;
                if (adInfo != null) {
                    return adInfo.getShopId();
                }
                return 0L;
            }

            @Override // kntr.app.ad.protocol.report.IReportable
            public long getUpMid() {
                AdInfo adInfo = this.adInfo;
                if (adInfo != null) {
                    return adInfo.getUpMid();
                }
                return 0L;
            }

            @Override // kntr.app.ad.protocol.report.IReportable
            public long getProductId() {
                AdInfo adInfo = this.adInfo;
                if (adInfo != null) {
                    return adInfo.getProductId();
                }
                return 0L;
            }

            @Override // kntr.app.ad.protocol.report.IReportable
            public int getReplaceStrategy() {
                AdInfo adInfo = this.adInfo;
                if (adInfo != null) {
                    return adInfo.getReplaceStrategy();
                }
                return 0;
            }

            @Override // kntr.app.ad.protocol.report.IReportable
            public String getFromTrackId() {
                AdInfo adInfo = this.adInfo;
                if (adInfo != null) {
                    return adInfo.getFromTrackId();
                }
                return null;
            }

            @Override // kntr.app.ad.protocol.report.IReportable
            public String getCmFromTrackId() {
                AdInfo adInfo = this.adInfo;
                if (adInfo != null) {
                    return adInfo.getCmFromTrackId();
                }
                return null;
            }

            @Override // kntr.app.ad.protocol.report.IReportable
            public long getItemId() {
                AdInfo adInfo = this.adInfo;
                if (adInfo != null) {
                    return adInfo.getItemId();
                }
                return 0L;
            }

            @Override // kntr.app.ad.protocol.report.IReportable
            public int getItemSource() {
                AdInfo adInfo = this.adInfo;
                if (adInfo != null) {
                    return adInfo.getItemSource();
                }
                return 0;
            }

            @Override // kntr.app.ad.protocol.report.IReportable
            public String getExtraParams() {
                AdInfo adInfo = this.adInfo;
                if (adInfo != null) {
                    return adInfo.getExtraParams();
                }
                return null;
            }

            @Override // kntr.app.ad.protocol.report.IReportable
            public long getId() {
                AdInfo adInfo = this.adInfo;
                if (adInfo != null) {
                    return adInfo.getId();
                }
                return 0L;
            }

            @Override // kntr.app.ad.protocol.report.IReportable
            public int getNatureAd() {
                AdInfo adInfo = this.adInfo;
                if (adInfo != null) {
                    return adInfo.getNatureAd();
                }
                return 0;
            }

            @Override // kntr.app.ad.protocol.report.IReportable
            public long getLiveBookingId() {
                AdInfo adInfo = this.adInfo;
                if (adInfo != null) {
                    return adInfo.getLiveBookingId();
                }
                return 0L;
            }

            @Override // kntr.app.ad.protocol.report.IReportable
            public String getCardType() {
                return this.cardType;
            }

            @Override // kntr.app.ad.protocol.report.IReportable
            public void setCardType(String str) {
                this.cardType = str;
            }

            @Override // kntr.app.ad.protocol.report.IReportable
            public long getAvid() {
                return this.avid;
            }

            @Override // kntr.app.ad.protocol.report.IReportable
            public void setAvid(long j2) {
                this.avid = j2;
            }

            @Override // kntr.app.ad.protocol.report.IReportable
            public boolean getButtonShow() {
                return this.buttonShow;
            }

            @Override // kntr.app.ad.protocol.report.IReportable
            public void setButtonShow(boolean z) {
                this.buttonShow = z;
            }
        }
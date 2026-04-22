package kntr.app.game.bean;

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
import kotlin.time.Duration;
import kotlinx.datetime.Clock;
import kotlinx.datetime.DatePeriod;
import kotlinx.datetime.Instant;
import kotlinx.datetime.LocalDate;
import kotlinx.datetime.LocalDateKt;
import kotlinx.datetime.TimeZone;
import kotlinx.datetime.TimeZoneKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: SteamDetailBean.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 E2\u00020\u0001:\u0002DEB\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0081\u0001\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012\u0012\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0012\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u0002\u0010\u0019J\u0006\u0010:\u001a\u00020\u0007J\u0006\u0010;\u001a\u00020\u0010J%\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u00002\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020BH\u0001¢\u0006\u0002\bCR\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0003\u001a\u0004\b\u001b\u0010\u001cR$\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001d\u0010\u0003\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\n\u001a\u00020\u00078\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0003\u001a\u0004\b#\u0010\u001cR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u0003\u001a\u0004\b%\u0010&R\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u0003\u001a\u0004\b(\u0010)R&\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b*\u0010\u0003\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R,\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b/\u0010\u0003\u001a\u0004\b0\u00101\"\u0004\b2\u00103R,\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b4\u0010\u0003\u001a\u0004\b5\u00101\"\u0004\b6\u00103R,\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b7\u0010\u0003\u001a\u0004\b8\u00101\"\u0004\b9\u00103¨\u0006F"}, d2 = {"Lkntr/app/game/bean/SteamDetailPageData;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "success", RoomRecommendViewModel.EMPTY_CURSOR, "lastRefreshTime", RoomRecommendViewModel.EMPTY_CURSOR, "needMakePublic", "userSteamInfo", "Lkntr/app/game/bean/UserSteamInfo;", "statisticOverview", "Lkntr/app/game/bean/StatisticOverview;", "steamFriendCode", RoomRecommendViewModel.EMPTY_CURSOR, "priceDistributionChart", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/game/bean/SteamChartData;", "playtimeDistributionChart", "list", "Lkntr/app/game/bean/SteamDetailGameItem;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZJZLkntr/app/game/bean/UserSteamInfo;Lkntr/app/game/bean/StatisticOverview;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSuccess$annotations", "getSuccess", "()Z", "getLastRefreshTime$annotations", "getLastRefreshTime", "()J", "setLastRefreshTime", "(J)V", "getNeedMakePublic$annotations", "getNeedMakePublic", "getUserSteamInfo$annotations", "getUserSteamInfo", "()Lkntr/app/game/bean/UserSteamInfo;", "getStatisticOverview$annotations", "getStatisticOverview", "()Lkntr/app/game/bean/StatisticOverview;", "getSteamFriendCode$annotations", "getSteamFriendCode", "()Ljava/lang/String;", "setSteamFriendCode", "(Ljava/lang/String;)V", "getPriceDistributionChart$annotations", "getPriceDistributionChart", "()Ljava/util/List;", "setPriceDistributionChart", "(Ljava/util/List;)V", "getPlaytimeDistributionChart$annotations", "getPlaytimeDistributionChart", "setPlaytimeDistributionChart", "getList$annotations", "getList", "setList", "isLastRefreshWithin5Min", "lastRefreshTimeDesc", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$gamebiz_debug", "$serializer", "Companion", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class SteamDetailPageData {
    private long lastRefreshTime;
    private List<SteamDetailGameItem> list;
    private final boolean needMakePublic;
    private List<SteamChartData> playtimeDistributionChart;
    private List<SteamChartData> priceDistributionChart;
    private final StatisticOverview statisticOverview;
    private String steamFriendCode;
    private final boolean success;
    private final UserSteamInfo userSteamInfo;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.game.bean.SteamDetailPageData$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = SteamDetailPageData._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.game.bean.SteamDetailPageData$$ExternalSyntheticLambda1
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$0;
            _childSerializers$_anonymous_$0 = SteamDetailPageData._childSerializers$_anonymous_$0();
            return _childSerializers$_anonymous_$0;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.game.bean.SteamDetailPageData$$ExternalSyntheticLambda2
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$1;
            _childSerializers$_anonymous_$1 = SteamDetailPageData._childSerializers$_anonymous_$1();
            return _childSerializers$_anonymous_$1;
        }
    })};

    @SerialName("last_refresh_time")
    public static /* synthetic */ void getLastRefreshTime$annotations() {
    }

    @SerialName("list")
    public static /* synthetic */ void getList$annotations() {
    }

    @SerialName("need_make_public")
    public static /* synthetic */ void getNeedMakePublic$annotations() {
    }

    @SerialName("playtime_distribution_chart")
    public static /* synthetic */ void getPlaytimeDistributionChart$annotations() {
    }

    @SerialName("price_distribution_chart")
    public static /* synthetic */ void getPriceDistributionChart$annotations() {
    }

    @SerialName("statistic_overview")
    public static /* synthetic */ void getStatisticOverview$annotations() {
    }

    @SerialName("steam_friend_code")
    public static /* synthetic */ void getSteamFriendCode$annotations() {
    }

    @SerialName("success")
    public static /* synthetic */ void getSuccess$annotations() {
    }

    @SerialName("user_steam_info")
    public static /* synthetic */ void getUserSteamInfo$annotations() {
    }

    /* compiled from: SteamDetailBean.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/game/bean/SteamDetailPageData$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/game/bean/SteamDetailPageData;", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<SteamDetailPageData> serializer() {
            return new GeneratedSerializer<SteamDetailPageData>() { // from class: kntr.app.game.bean.SteamDetailPageData$$serializer
                public static final int $stable;
                private static final SerialDescriptor descriptor;

                public final SerialDescriptor getDescriptor() {
                    return descriptor;
                }

                static {
                    SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.game.bean.SteamDetailPageData", 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                          (wrap: kotlinx.serialization.KSerializer<kntr.app.game.bean.SteamDetailPageData> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.app.game.bean.SteamDetailPageData> A[REMOVE]) =  kntr.app.game.bean.SteamDetailPageData$$serializer.INSTANCE kntr.app.game.bean.SteamDetailPageData$$serializer)
                         in method: kntr.app.game.bean.SteamDetailPageData.Companion.serializer():kotlinx.serialization.KSerializer<kntr.app.game.bean.SteamDetailPageData>, file: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0011: CONSTRUCTOR  (r0v1 'pluginGeneratedSerialDescriptor' kotlinx.serialization.descriptors.SerialDescriptor) = 
                          ("kntr.app.game.bean.SteamDetailPageData")
                          (wrap: kntr.app.game.bean.SteamDetailPageData$$serializer : 0x0009: SGET  (r1v0 kntr.app.game.bean.SteamDetailPageData$$serializer A[REMOVE]) =  kntr.app.game.bean.SteamDetailPageData$$serializer.INSTANCE kntr.app.game.bean.SteamDetailPageData$$serializer)
                          (9 int)
                         call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.app.game.bean.SteamDetailPageData$$serializer.<clinit>():void, file: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.app.game.bean.SteamDetailPageData$$serializer
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
                        kntr.app.game.bean.SteamDetailPageData$$serializer r0 = kntr.app.game.bean.SteamDetailPageData$$serializer.INSTANCE
                        kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kntr.app.game.bean.SteamDetailPageData.Companion.serializer():kotlinx.serialization.KSerializer");
                }
            }

            public SteamDetailPageData() {
                this.lastRefreshTime = -1L;
            }

            public /* synthetic */ SteamDetailPageData(int seen0, boolean success, long lastRefreshTime, boolean needMakePublic, UserSteamInfo userSteamInfo, StatisticOverview statisticOverview, String steamFriendCode, List priceDistributionChart, List playtimeDistributionChart, List list, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.success = false;
                } else {
                    this.success = success;
                }
                if ((seen0 & 2) == 0) {
                    this.lastRefreshTime = -1L;
                } else {
                    this.lastRefreshTime = lastRefreshTime;
                }
                if ((seen0 & 4) == 0) {
                    this.needMakePublic = false;
                } else {
                    this.needMakePublic = needMakePublic;
                }
                if ((seen0 & 8) == 0) {
                    this.userSteamInfo = null;
                } else {
                    this.userSteamInfo = userSteamInfo;
                }
                if ((seen0 & 16) == 0) {
                    this.statisticOverview = null;
                } else {
                    this.statisticOverview = statisticOverview;
                }
                if ((seen0 & 32) == 0) {
                    this.steamFriendCode = null;
                } else {
                    this.steamFriendCode = steamFriendCode;
                }
                if ((seen0 & 64) == 0) {
                    this.priceDistributionChart = null;
                } else {
                    this.priceDistributionChart = priceDistributionChart;
                }
                if ((seen0 & 128) == 0) {
                    this.playtimeDistributionChart = null;
                } else {
                    this.playtimeDistributionChart = playtimeDistributionChart;
                }
                if ((seen0 & 256) == 0) {
                    this.list = null;
                } else {
                    this.list = list;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                return new ArrayListSerializer(SteamChartData$$serializer.INSTANCE);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
                return new ArrayListSerializer(SteamChartData$$serializer.INSTANCE);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
                return new ArrayListSerializer(SteamDetailGameItem$$serializer.INSTANCE);
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$gamebiz_debug(SteamDetailPageData self, CompositeEncoder output, SerialDescriptor serialDesc) {
                Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.success) {
                    output.encodeBooleanElement(serialDesc, 0, self.success);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.lastRefreshTime != -1) {
                    output.encodeLongElement(serialDesc, 1, self.lastRefreshTime);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.needMakePublic) {
                    output.encodeBooleanElement(serialDesc, 2, self.needMakePublic);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.userSteamInfo != null) {
                    output.encodeNullableSerializableElement(serialDesc, 3, UserSteamInfo$$serializer.INSTANCE, self.userSteamInfo);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 4) || self.statisticOverview != null) {
                    output.encodeNullableSerializableElement(serialDesc, 4, StatisticOverview$$serializer.INSTANCE, self.statisticOverview);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 5) || self.steamFriendCode != null) {
                    output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.steamFriendCode);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 6) || self.priceDistributionChart != null) {
                    output.encodeNullableSerializableElement(serialDesc, 6, (SerializationStrategy) lazyArr[6].getValue(), self.priceDistributionChart);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 7) || self.playtimeDistributionChart != null) {
                    output.encodeNullableSerializableElement(serialDesc, 7, (SerializationStrategy) lazyArr[7].getValue(), self.playtimeDistributionChart);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 8) || self.list != null) {
                    output.encodeNullableSerializableElement(serialDesc, 8, (SerializationStrategy) lazyArr[8].getValue(), self.list);
                }
            }

            public final boolean getSuccess() {
                return this.success;
            }

            public final long getLastRefreshTime() {
                return this.lastRefreshTime;
            }

            public final void setLastRefreshTime(long j2) {
                this.lastRefreshTime = j2;
            }

            public final boolean getNeedMakePublic() {
                return this.needMakePublic;
            }

            public final UserSteamInfo getUserSteamInfo() {
                return this.userSteamInfo;
            }

            public final StatisticOverview getStatisticOverview() {
                return this.statisticOverview;
            }

            public final String getSteamFriendCode() {
                return this.steamFriendCode;
            }

            public final void setSteamFriendCode(String str) {
                this.steamFriendCode = str;
            }

            public final List<SteamChartData> getPriceDistributionChart() {
                return this.priceDistributionChart;
            }

            public final void setPriceDistributionChart(List<SteamChartData> list) {
                this.priceDistributionChart = list;
            }

            public final List<SteamChartData> getPlaytimeDistributionChart() {
                return this.playtimeDistributionChart;
            }

            public final void setPlaytimeDistributionChart(List<SteamChartData> list) {
                this.playtimeDistributionChart = list;
            }

            public final List<SteamDetailGameItem> getList() {
                return this.list;
            }

            public final void setList(List<SteamDetailGameItem> list) {
                this.list = list;
            }

            public final boolean isLastRefreshWithin5Min() {
                if (this.lastRefreshTime <= 0) {
                    return false;
                }
                Instant now = Clock.System.INSTANCE.now();
                Instant lastRefresh = Instant.Companion.fromEpochSeconds$default(Instant.Companion, this.lastRefreshTime, 0L, 2, (Object) null);
                long diff = now.minus-5sfh64U(lastRefresh);
                return Duration.getInWholeMinutes-impl(diff) < 5;
            }

            public final String lastRefreshTimeDesc() {
                if (this.lastRefreshTime <= 0) {
                    return RoomRecommendViewModel.EMPTY_CURSOR;
                }
                Instant now = Clock.System.INSTANCE.now();
                Instant lastRefresh = Instant.Companion.fromEpochSeconds$default(Instant.Companion, this.lastRefreshTime, 0L, 2, (Object) null);
                long diff = now.minus-5sfh64U(lastRefresh);
                long seconds = Duration.getInWholeSeconds-impl(diff);
                long minutes = Duration.getInWholeMinutes-impl(diff);
                long hours = Duration.getInWholeHours-impl(diff);
                LocalDate today = TimeZoneKt.toLocalDateTime(now, TimeZone.Companion.currentSystemDefault()).getDate();
                LocalDate lastRefreshDate = TimeZoneKt.toLocalDateTime(lastRefresh, TimeZone.Companion.currentSystemDefault()).getDate();
                LocalDate yesterday = LocalDateKt.minus(today, new DatePeriod(0, 0, 1, 3, (DefaultConstructorMarker) null));
                LocalDate yearStart = new LocalDate(today.getYear(), 1, 1);
                if (seconds < 60) {
                    return "刚刚更新";
                }
                if (minutes < 60) {
                    return minutes + "分钟前更新";
                }
                if (hours < 24) {
                    return hours + "小时前更新";
                }
                if (Intrinsics.areEqual(lastRefreshDate, yesterday)) {
                    return "昨天更新";
                }
                if (lastRefreshDate.compareTo(yearStart) > 0) {
                    int monthNumber = lastRefreshDate.getMonthNumber();
                    return monthNumber + "月" + lastRefreshDate.getDayOfMonth() + "日更新";
                }
                int year = lastRefreshDate.getYear();
                int monthNumber2 = lastRefreshDate.getMonthNumber();
                return year + "年" + monthNumber2 + "月" + lastRefreshDate.getDayOfMonth() + "日更新";
            }
        }
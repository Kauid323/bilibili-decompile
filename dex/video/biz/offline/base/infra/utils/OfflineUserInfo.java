package video.biz.offline.base.infra.utils;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: Config.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 (2\u00020\u0001:\u0002'(B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bB3\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J'\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\nHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J%\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\b&R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0004\u0010\u0013R\u001c\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011¨\u0006)"}, d2 = {"Lvideo/biz/offline/base/infra/utils/OfflineUserInfo;", "", RankRouter.BundleKey.AUTHOR_SPACE_MID, "", "isVip", "", "endTimestamp", "<init>", "(JZJ)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJZJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMid$annotations", "()V", "getMid", "()J", "isVip$annotations", "()Z", "getEndTimestamp$annotations", "getEndTimestamp", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$infra_debug", "$serializer", "Companion", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@Serializable
public final class OfflineUserInfo {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final long endTimestamp;
    private final boolean isVip;
    private final long mid;

    public OfflineUserInfo() {
        this(0L, false, 0L, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ OfflineUserInfo copy$default(OfflineUserInfo offlineUserInfo, long j, boolean z, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = offlineUserInfo.mid;
        }
        long j3 = j;
        if ((i & 2) != 0) {
            z = offlineUserInfo.isVip;
        }
        boolean z2 = z;
        if ((i & 4) != 0) {
            j2 = offlineUserInfo.endTimestamp;
        }
        return offlineUserInfo.copy(j3, z2, j2);
    }

    @SerialName("end_timestamp")
    public static /* synthetic */ void getEndTimestamp$annotations() {
    }

    @SerialName(RankRouter.BundleKey.AUTHOR_SPACE_MID)
    public static /* synthetic */ void getMid$annotations() {
    }

    @SerialName("is_vip")
    public static /* synthetic */ void isVip$annotations() {
    }

    public final long component1() {
        return this.mid;
    }

    public final boolean component2() {
        return this.isVip;
    }

    public final long component3() {
        return this.endTimestamp;
    }

    public final OfflineUserInfo copy(long j, boolean z, long j2) {
        return new OfflineUserInfo(j, z, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OfflineUserInfo) {
            OfflineUserInfo offlineUserInfo = (OfflineUserInfo) obj;
            return this.mid == offlineUserInfo.mid && this.isVip == offlineUserInfo.isVip && this.endTimestamp == offlineUserInfo.endTimestamp;
        }
        return false;
    }

    public int hashCode() {
        return (((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.mid) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isVip)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.endTimestamp);
    }

    public String toString() {
        long j = this.mid;
        boolean z = this.isVip;
        return "OfflineUserInfo(mid=" + j + ", isVip=" + z + ", endTimestamp=" + this.endTimestamp + ")";
    }

    /* compiled from: Config.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lvideo/biz/offline/base/infra/utils/OfflineUserInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lvideo/biz/offline/base/infra/utils/OfflineUserInfo;", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<OfflineUserInfo> serializer() {
            return new GeneratedSerializer<OfflineUserInfo>() { // from class: video.biz.offline.base.infra.utils.OfflineUserInfo$$serializer
                public static final int $stable;
                private static final SerialDescriptor descriptor;

                public final SerialDescriptor getDescriptor() {
                    return descriptor;
                }

                static {
                    SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("video.biz.offline.base.infra.utils.OfflineUserInfo", 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                          (wrap: kotlinx.serialization.KSerializer<video.biz.offline.base.infra.utils.OfflineUserInfo> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<video.biz.offline.base.infra.utils.OfflineUserInfo> A[REMOVE]) =  video.biz.offline.base.infra.utils.OfflineUserInfo$$serializer.INSTANCE video.biz.offline.base.infra.utils.OfflineUserInfo$$serializer)
                         in method: video.biz.offline.base.infra.utils.OfflineUserInfo.Companion.serializer():kotlinx.serialization.KSerializer<video.biz.offline.base.infra.utils.OfflineUserInfo>, file: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex
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
                          ("video.biz.offline.base.infra.utils.OfflineUserInfo")
                          (wrap: video.biz.offline.base.infra.utils.OfflineUserInfo$$serializer : 0x0009: SGET  (r1v0 video.biz.offline.base.infra.utils.OfflineUserInfo$$serializer A[REMOVE]) =  video.biz.offline.base.infra.utils.OfflineUserInfo$$serializer.INSTANCE video.biz.offline.base.infra.utils.OfflineUserInfo$$serializer)
                          (3 int)
                         call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: video.biz.offline.base.infra.utils.OfflineUserInfo$$serializer.<clinit>():void, file: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: video.biz.offline.base.infra.utils.OfflineUserInfo$$serializer
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
                        video.biz.offline.base.infra.utils.OfflineUserInfo$$serializer r0 = video.biz.offline.base.infra.utils.OfflineUserInfo$$serializer.INSTANCE
                        kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: video.biz.offline.base.infra.utils.OfflineUserInfo.Companion.serializer():kotlinx.serialization.KSerializer");
                }
            }

            public /* synthetic */ OfflineUserInfo(int seen0, long mid, boolean isVip, long endTimestamp, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.mid = 0L;
                } else {
                    this.mid = mid;
                }
                if ((seen0 & 2) == 0) {
                    this.isVip = false;
                } else {
                    this.isVip = isVip;
                }
                if ((seen0 & 4) == 0) {
                    this.endTimestamp = 0L;
                } else {
                    this.endTimestamp = endTimestamp;
                }
            }

            public OfflineUserInfo(long mid, boolean isVip, long endTimestamp) {
                this.mid = mid;
                this.isVip = isVip;
                this.endTimestamp = endTimestamp;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$infra_debug(OfflineUserInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.mid != 0) {
                    output.encodeLongElement(serialDesc, 0, self.mid);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.isVip) {
                    output.encodeBooleanElement(serialDesc, 1, self.isVip);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.endTimestamp != 0) {
                    output.encodeLongElement(serialDesc, 2, self.endTimestamp);
                }
            }

            public /* synthetic */ OfflineUserInfo(long j, boolean z, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? false : z, (i & 4) != 0 ? 0L : j2);
            }

            public final long getMid() {
                return this.mid;
            }

            public final boolean isVip() {
                return this.isVip;
            }

            public final long getEndTimestamp() {
                return this.endTimestamp;
            }
        }
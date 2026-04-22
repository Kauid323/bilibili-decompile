package kntr.app.mall.mallDynamicPage.component.business.bean;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: MallFeedsModel.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J%\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0001¢\u0006\u0002\b\u001dR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u0005¨\u0006 "}, d2 = {"Lkntr/app/mall/mallDynamicPage/component/business/bean/MallFeedsModel;", RoomRecommendViewModel.EMPTY_CURSOR, "vo", "Lkntr/app/mall/mallDynamicPage/component/business/bean/RecommendVO;", "<init>", "(Lkntr/app/mall/mallDynamicPage/component/business/bean/RecommendVO;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkntr/app/mall/mallDynamicPage/component/business/bean/RecommendVO;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getVo", "()Lkntr/app/mall/mallDynamicPage/component/business/bean/RecommendVO;", "setVo", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", RoomRecommendViewModel.EMPTY_CURSOR, "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$mallDynamicPage_debug", "$serializer", "Companion", "mallDynamicPage_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class MallFeedsModel {
    private RecommendVO vo;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public MallFeedsModel() {
        this((RecommendVO) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ MallFeedsModel copy$default(MallFeedsModel mallFeedsModel, RecommendVO recommendVO, int i, Object obj) {
        if ((i & 1) != 0) {
            recommendVO = mallFeedsModel.vo;
        }
        return mallFeedsModel.copy(recommendVO);
    }

    public final RecommendVO component1() {
        return this.vo;
    }

    public final MallFeedsModel copy(RecommendVO recommendVO) {
        return new MallFeedsModel(recommendVO);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MallFeedsModel) && Intrinsics.areEqual(this.vo, ((MallFeedsModel) obj).vo);
    }

    public int hashCode() {
        if (this.vo == null) {
            return 0;
        }
        return this.vo.hashCode();
    }

    public String toString() {
        return "MallFeedsModel(vo=" + this.vo + ")";
    }

    /* compiled from: MallFeedsModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/mallDynamicPage/component/business/bean/MallFeedsModel$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/mallDynamicPage/component/business/bean/MallFeedsModel;", "mallDynamicPage_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<MallFeedsModel> serializer() {
            return new GeneratedSerializer<MallFeedsModel>() { // from class: kntr.app.mall.mallDynamicPage.component.business.bean.MallFeedsModel$$serializer
                public static final int $stable;
                private static final SerialDescriptor descriptor;

                public final SerialDescriptor getDescriptor() {
                    return descriptor;
                }

                static {
                    SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.mallDynamicPage.component.business.bean.MallFeedsModel", 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                          (wrap: kotlinx.serialization.KSerializer<kntr.app.mall.mallDynamicPage.component.business.bean.MallFeedsModel> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.app.mall.mallDynamicPage.component.business.bean.MallFeedsModel> A[REMOVE]) =  kntr.app.mall.mallDynamicPage.component.business.bean.MallFeedsModel$$serializer.INSTANCE kntr.app.mall.mallDynamicPage.component.business.bean.MallFeedsModel$$serializer)
                         in method: kntr.app.mall.mallDynamicPage.component.business.bean.MallFeedsModel.Companion.serializer():kotlinx.serialization.KSerializer<kntr.app.mall.mallDynamicPage.component.business.bean.MallFeedsModel>, file: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex
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
                          ("kntr.app.mall.mallDynamicPage.component.business.bean.MallFeedsModel")
                          (wrap: kntr.app.mall.mallDynamicPage.component.business.bean.MallFeedsModel$$serializer : 0x0009: SGET  (r1v0 kntr.app.mall.mallDynamicPage.component.business.bean.MallFeedsModel$$serializer A[REMOVE]) =  kntr.app.mall.mallDynamicPage.component.business.bean.MallFeedsModel$$serializer.INSTANCE kntr.app.mall.mallDynamicPage.component.business.bean.MallFeedsModel$$serializer)
                          (1 int)
                         call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.app.mall.mallDynamicPage.component.business.bean.MallFeedsModel$$serializer.<clinit>():void, file: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.app.mall.mallDynamicPage.component.business.bean.MallFeedsModel$$serializer
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
                        kntr.app.mall.mallDynamicPage.component.business.bean.MallFeedsModel$$serializer r0 = kntr.app.mall.mallDynamicPage.component.business.bean.MallFeedsModel$$serializer.INSTANCE
                        kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kntr.app.mall.mallDynamicPage.component.business.bean.MallFeedsModel.Companion.serializer():kotlinx.serialization.KSerializer");
                }
            }

            public /* synthetic */ MallFeedsModel(int seen0, RecommendVO vo, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.vo = null;
                } else {
                    this.vo = vo;
                }
            }

            public MallFeedsModel(RecommendVO vo) {
                this.vo = vo;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$mallDynamicPage_debug(MallFeedsModel self, CompositeEncoder output, SerialDescriptor serialDesc) {
                boolean z = true;
                if (!output.shouldEncodeElementDefault(serialDesc, 0) && self.vo == null) {
                    z = false;
                }
                if (z) {
                    output.encodeNullableSerializableElement(serialDesc, 0, RecommendVO$$serializer.INSTANCE, self.vo);
                }
            }

            public /* synthetic */ MallFeedsModel(RecommendVO recommendVO, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : recommendVO);
            }

            public final RecommendVO getVo() {
                return this.vo;
            }

            public final void setVo(RecommendVO recommendVO) {
                this.vo = recommendVO;
            }
        }
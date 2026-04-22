package kntr.app.digital.backpack.api;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import com.bilibili.ogv.bpf.serialization.BooleanAsIntSerializer;
import java.util.List;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.digital.backpack.api.BackpackAssetBagModel;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: BackpackAssetBagModel.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0081\b\u0018\u0000 M2\u00020\u0001:\tEFGHIJKLMB\u0081\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\n¢\u0006\u0004\b\u0012\u0010\u0013B\u0089\u0001\b\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\n\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\n\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\n\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0012\u0010\u0017J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0007HÆ\u0003J\t\u00102\u001a\u00020\u0007HÆ\u0003J\u0011\u00103\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003J\u0011\u00104\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\nHÆ\u0003J\u0011\u00105\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\nHÆ\u0003J\u0011\u00106\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\nHÆ\u0003J\u0083\u0001\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\n2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\n2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\nHÆ\u0001J\u0013\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010;\u001a\u00020\u0007HÖ\u0001J\t\u0010<\u001a\u00020\u0003HÖ\u0001J%\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u00002\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0001¢\u0006\u0002\bDR\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001d\u0010\u001bR\u001c\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\u001bR\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0019\u001a\u0004\b!\u0010\"R\u001c\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u0019\u001a\u0004\b$\u0010\"R$\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u0019\u001a\u0004\b&\u0010'R$\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010\u0019\u001a\u0004\b)\u0010'R$\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u0019\u001a\u0004\b+\u0010'R$\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010\u0019\u001a\u0004\b-\u0010'¨\u0006N"}, d2 = {"Lkntr/app/digital/backpack/api/BackpackAssetBagModel;", RoomRecommendViewModel.EMPTY_CURSOR, "username", RoomRecommendViewModel.EMPTY_CURSOR, "userFace", "actYImg", "totalItemCount", RoomRecommendViewModel.EMPTY_CURSOR, "ownedItemCount", "itemList", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/digital/backpack/api/BackpackAssetBagModel$Item;", "collectList", "Lkntr/app/digital/backpack/api/BackpackAssetBagModel$Collect;", "lotterySimpleList", "Lkntr/app/digital/backpack/api/BackpackAssetBagModel$Lottery;", "subModuleList", "Lkntr/app/digital/backpack/api/BackpackAssetBagModel$SubModule;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getUsername$annotations", "()V", "getUsername", "()Ljava/lang/String;", "getUserFace$annotations", "getUserFace", "getActYImg$annotations", "getActYImg", "getTotalItemCount$annotations", "getTotalItemCount", "()I", "getOwnedItemCount$annotations", "getOwnedItemCount", "getItemList$annotations", "getItemList", "()Ljava/util/List;", "getCollectList$annotations", "getCollectList", "getLotterySimpleList$annotations", "getLotterySimpleList", "getSubModuleList$annotations", "getSubModuleList", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$backpack_debug", "Item", "Lottery", "CardItem", "SubModule", "StockInfo", "Tag", "Collect", "$serializer", "Companion", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class BackpackAssetBagModel {
    private final String actYImg;
    private final List<Collect> collectList;
    private final List<Item> itemList;
    private final List<Lottery> lotterySimpleList;
    private final int ownedItemCount;
    private final List<SubModule> subModuleList;
    private final int totalItemCount;
    private final String userFace;
    private final String username;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.digital.backpack.api.BackpackAssetBagModel$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = BackpackAssetBagModel._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.digital.backpack.api.BackpackAssetBagModel$$ExternalSyntheticLambda1
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$0;
            _childSerializers$_anonymous_$0 = BackpackAssetBagModel._childSerializers$_anonymous_$0();
            return _childSerializers$_anonymous_$0;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.digital.backpack.api.BackpackAssetBagModel$$ExternalSyntheticLambda2
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$1;
            _childSerializers$_anonymous_$1 = BackpackAssetBagModel._childSerializers$_anonymous_$1();
            return _childSerializers$_anonymous_$1;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.digital.backpack.api.BackpackAssetBagModel$$ExternalSyntheticLambda3
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$2;
            _childSerializers$_anonymous_$2 = BackpackAssetBagModel._childSerializers$_anonymous_$2();
            return _childSerializers$_anonymous_$2;
        }
    })};

    public BackpackAssetBagModel() {
        this((String) null, (String) null, (String) null, 0, 0, (List) null, (List) null, (List) null, (List) null, 511, (DefaultConstructorMarker) null);
    }

    @SerialName("act_y_img")
    public static /* synthetic */ void getActYImg$annotations() {
    }

    @SerialName("collect_list")
    public static /* synthetic */ void getCollectList$annotations() {
    }

    @SerialName("item_list")
    public static /* synthetic */ void getItemList$annotations() {
    }

    @SerialName("lottery_simple_list")
    public static /* synthetic */ void getLotterySimpleList$annotations() {
    }

    @SerialName("owned_item_cnt")
    public static /* synthetic */ void getOwnedItemCount$annotations() {
    }

    @SerialName("sub_module_list")
    public static /* synthetic */ void getSubModuleList$annotations() {
    }

    @SerialName("total_item_cnt")
    public static /* synthetic */ void getTotalItemCount$annotations() {
    }

    @SerialName("uface")
    public static /* synthetic */ void getUserFace$annotations() {
    }

    @SerialName("uname")
    public static /* synthetic */ void getUsername$annotations() {
    }

    public final String component1() {
        return this.username;
    }

    public final String component2() {
        return this.userFace;
    }

    public final String component3() {
        return this.actYImg;
    }

    public final int component4() {
        return this.totalItemCount;
    }

    public final int component5() {
        return this.ownedItemCount;
    }

    public final List<Item> component6() {
        return this.itemList;
    }

    public final List<Collect> component7() {
        return this.collectList;
    }

    public final List<Lottery> component8() {
        return this.lotterySimpleList;
    }

    public final List<SubModule> component9() {
        return this.subModuleList;
    }

    public final BackpackAssetBagModel copy(String str, String str2, String str3, int i, int i2, List<Item> list, List<Collect> list2, List<Lottery> list3, List<SubModule> list4) {
        Intrinsics.checkNotNullParameter(str, "username");
        Intrinsics.checkNotNullParameter(str2, "userFace");
        Intrinsics.checkNotNullParameter(str3, "actYImg");
        return new BackpackAssetBagModel(str, str2, str3, i, i2, list, list2, list3, list4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BackpackAssetBagModel) {
            BackpackAssetBagModel backpackAssetBagModel = (BackpackAssetBagModel) obj;
            return Intrinsics.areEqual(this.username, backpackAssetBagModel.username) && Intrinsics.areEqual(this.userFace, backpackAssetBagModel.userFace) && Intrinsics.areEqual(this.actYImg, backpackAssetBagModel.actYImg) && this.totalItemCount == backpackAssetBagModel.totalItemCount && this.ownedItemCount == backpackAssetBagModel.ownedItemCount && Intrinsics.areEqual(this.itemList, backpackAssetBagModel.itemList) && Intrinsics.areEqual(this.collectList, backpackAssetBagModel.collectList) && Intrinsics.areEqual(this.lotterySimpleList, backpackAssetBagModel.lotterySimpleList) && Intrinsics.areEqual(this.subModuleList, backpackAssetBagModel.subModuleList);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((this.username.hashCode() * 31) + this.userFace.hashCode()) * 31) + this.actYImg.hashCode()) * 31) + this.totalItemCount) * 31) + this.ownedItemCount) * 31) + (this.itemList == null ? 0 : this.itemList.hashCode())) * 31) + (this.collectList == null ? 0 : this.collectList.hashCode())) * 31) + (this.lotterySimpleList == null ? 0 : this.lotterySimpleList.hashCode())) * 31) + (this.subModuleList != null ? this.subModuleList.hashCode() : 0);
    }

    public String toString() {
        String str = this.username;
        String str2 = this.userFace;
        String str3 = this.actYImg;
        int i = this.totalItemCount;
        int i2 = this.ownedItemCount;
        List<Item> list = this.itemList;
        List<Collect> list2 = this.collectList;
        List<Lottery> list3 = this.lotterySimpleList;
        return "BackpackAssetBagModel(username=" + str + ", userFace=" + str2 + ", actYImg=" + str3 + ", totalItemCount=" + i + ", ownedItemCount=" + i2 + ", itemList=" + list + ", collectList=" + list2 + ", lotterySimpleList=" + list3 + ", subModuleList=" + this.subModuleList + ")";
    }

    /* compiled from: BackpackAssetBagModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/digital/backpack/api/BackpackAssetBagModel$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/digital/backpack/api/BackpackAssetBagModel;", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<BackpackAssetBagModel> serializer() {
            return new GeneratedSerializer<BackpackAssetBagModel>() { // from class: kntr.app.digital.backpack.api.BackpackAssetBagModel$$serializer
                public static final int $stable;
                private static final SerialDescriptor descriptor;

                public final SerialDescriptor getDescriptor() {
                    return descriptor;
                }

                static {
                    SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.digital.backpack.api.BackpackAssetBagModel", 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                          (wrap: kotlinx.serialization.KSerializer<kntr.app.digital.backpack.api.BackpackAssetBagModel> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.app.digital.backpack.api.BackpackAssetBagModel> A[REMOVE]) =  kntr.app.digital.backpack.api.BackpackAssetBagModel$$serializer.INSTANCE kntr.app.digital.backpack.api.BackpackAssetBagModel$$serializer)
                         in method: kntr.app.digital.backpack.api.BackpackAssetBagModel.Companion.serializer():kotlinx.serialization.KSerializer<kntr.app.digital.backpack.api.BackpackAssetBagModel>, file: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex
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
                          ("kntr.app.digital.backpack.api.BackpackAssetBagModel")
                          (wrap: kntr.app.digital.backpack.api.BackpackAssetBagModel$$serializer : 0x0009: SGET  (r1v0 kntr.app.digital.backpack.api.BackpackAssetBagModel$$serializer A[REMOVE]) =  kntr.app.digital.backpack.api.BackpackAssetBagModel$$serializer.INSTANCE kntr.app.digital.backpack.api.BackpackAssetBagModel$$serializer)
                          (9 int)
                         call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.app.digital.backpack.api.BackpackAssetBagModel$$serializer.<clinit>():void, file: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.app.digital.backpack.api.BackpackAssetBagModel$$serializer
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
                        kntr.app.digital.backpack.api.BackpackAssetBagModel$$serializer r0 = kntr.app.digital.backpack.api.BackpackAssetBagModel$$serializer.INSTANCE
                        kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kntr.app.digital.backpack.api.BackpackAssetBagModel.Companion.serializer():kotlinx.serialization.KSerializer");
                }
            }

            public /* synthetic */ BackpackAssetBagModel(int seen0, String username, String userFace, String actYImg, int totalItemCount, int ownedItemCount, List itemList, List collectList, List lotterySimpleList, List subModuleList, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.username = RoomRecommendViewModel.EMPTY_CURSOR;
                } else {
                    this.username = username;
                }
                if ((seen0 & 2) == 0) {
                    this.userFace = RoomRecommendViewModel.EMPTY_CURSOR;
                } else {
                    this.userFace = userFace;
                }
                if ((seen0 & 4) == 0) {
                    this.actYImg = RoomRecommendViewModel.EMPTY_CURSOR;
                } else {
                    this.actYImg = actYImg;
                }
                if ((seen0 & 8) == 0) {
                    this.totalItemCount = 0;
                } else {
                    this.totalItemCount = totalItemCount;
                }
                if ((seen0 & 16) == 0) {
                    this.ownedItemCount = 0;
                } else {
                    this.ownedItemCount = ownedItemCount;
                }
                if ((seen0 & 32) == 0) {
                    this.itemList = null;
                } else {
                    this.itemList = itemList;
                }
                if ((seen0 & 64) == 0) {
                    this.collectList = null;
                } else {
                    this.collectList = collectList;
                }
                if ((seen0 & 128) == 0) {
                    this.lotterySimpleList = null;
                } else {
                    this.lotterySimpleList = lotterySimpleList;
                }
                if ((seen0 & 256) == 0) {
                    this.subModuleList = null;
                } else {
                    this.subModuleList = subModuleList;
                }
            }

            public BackpackAssetBagModel(String username, String userFace, String actYImg, int totalItemCount, int ownedItemCount, List<Item> list, List<Collect> list2, List<Lottery> list3, List<SubModule> list4) {
                Intrinsics.checkNotNullParameter(username, "username");
                Intrinsics.checkNotNullParameter(userFace, "userFace");
                Intrinsics.checkNotNullParameter(actYImg, "actYImg");
                this.username = username;
                this.userFace = userFace;
                this.actYImg = actYImg;
                this.totalItemCount = totalItemCount;
                this.ownedItemCount = ownedItemCount;
                this.itemList = list;
                this.collectList = list2;
                this.lotterySimpleList = list3;
                this.subModuleList = list4;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                return new ArrayListSerializer(BackpackAssetBagModel$Item$$serializer.INSTANCE);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
                return new ArrayListSerializer(BackpackAssetBagModel$Collect$$serializer.INSTANCE);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
                return new ArrayListSerializer(BackpackAssetBagModel$Lottery$$serializer.INSTANCE);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$2() {
                return new ArrayListSerializer(BackpackAssetBagModel$SubModule$$serializer.INSTANCE);
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$backpack_debug(BackpackAssetBagModel self, CompositeEncoder output, SerialDescriptor serialDesc) {
                Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.username, RoomRecommendViewModel.EMPTY_CURSOR)) {
                    output.encodeStringElement(serialDesc, 0, self.username);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.userFace, RoomRecommendViewModel.EMPTY_CURSOR)) {
                    output.encodeStringElement(serialDesc, 1, self.userFace);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.actYImg, RoomRecommendViewModel.EMPTY_CURSOR)) {
                    output.encodeStringElement(serialDesc, 2, self.actYImg);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.totalItemCount != 0) {
                    output.encodeIntElement(serialDesc, 3, self.totalItemCount);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 4) || self.ownedItemCount != 0) {
                    output.encodeIntElement(serialDesc, 4, self.ownedItemCount);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 5) || self.itemList != null) {
                    output.encodeNullableSerializableElement(serialDesc, 5, (SerializationStrategy) lazyArr[5].getValue(), self.itemList);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 6) || self.collectList != null) {
                    output.encodeNullableSerializableElement(serialDesc, 6, (SerializationStrategy) lazyArr[6].getValue(), self.collectList);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 7) || self.lotterySimpleList != null) {
                    output.encodeNullableSerializableElement(serialDesc, 7, (SerializationStrategy) lazyArr[7].getValue(), self.lotterySimpleList);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 8) || self.subModuleList != null) {
                    output.encodeNullableSerializableElement(serialDesc, 8, (SerializationStrategy) lazyArr[8].getValue(), self.subModuleList);
                }
            }

            public /* synthetic */ BackpackAssetBagModel(String str, String str2, String str3, int i, int i2, List list, List list2, List list3, List list4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this((i3 & 1) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i3 & 2) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str2, (i3 & 4) == 0 ? str3 : RoomRecommendViewModel.EMPTY_CURSOR, (i3 & 8) != 0 ? 0 : i, (i3 & 16) == 0 ? i2 : 0, (i3 & 32) != 0 ? null : list, (i3 & 64) != 0 ? null : list2, (i3 & 128) != 0 ? null : list3, (i3 & 256) == 0 ? list4 : null);
            }

            public final String getUsername() {
                return this.username;
            }

            public final String getUserFace() {
                return this.userFace;
            }

            public final String getActYImg() {
                return this.actYImg;
            }

            public final int getTotalItemCount() {
                return this.totalItemCount;
            }

            public final int getOwnedItemCount() {
                return this.ownedItemCount;
            }

            public final List<Item> getItemList() {
                return this.itemList;
            }

            public final List<Collect> getCollectList() {
                return this.collectList;
            }

            public final List<Lottery> getLotterySimpleList() {
                return this.lotterySimpleList;
            }

            /* compiled from: BackpackAssetBagModel.kt */
            @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002%&B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bB3\b\u0010\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0007\u0010\fJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0013¨\u0006'"}, d2 = {"Lkntr/app/digital/backpack/api/BackpackAssetBagModel$Item;", RoomRecommendViewModel.EMPTY_CURSOR, "scarcityLevel", RoomRecommendViewModel.EMPTY_CURSOR, "cardItems", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/digital/backpack/api/BackpackAssetBagModel$CardItem;", "<init>", "(ILjava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getScarcityLevel$annotations", "()V", "getScarcityLevel", "()I", "getCardItems$annotations", "getCardItems", "()Ljava/util/List;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", RoomRecommendViewModel.EMPTY_CURSOR, "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$backpack_debug", "$serializer", "Companion", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
            @Serializable
            /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
            public static final class Item {
                private final List<CardItem> cardItems;
                private final int scarcityLevel;
                public static final Companion Companion = new Companion(null);
                public static final int $stable = 8;
                private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.digital.backpack.api.BackpackAssetBagModel$Item$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        KSerializer _childSerializers$_anonymous_;
                        _childSerializers$_anonymous_ = BackpackAssetBagModel.Item._childSerializers$_anonymous_();
                        return _childSerializers$_anonymous_;
                    }
                })};

                public Item() {
                    this(0, (List) null, 3, (DefaultConstructorMarker) null);
                }

                /* JADX WARN: Multi-variable type inference failed */
                public static /* synthetic */ Item copy$default(Item item, int i, List list, int i2, Object obj) {
                    if ((i2 & 1) != 0) {
                        i = item.scarcityLevel;
                    }
                    if ((i2 & 2) != 0) {
                        list = item.cardItems;
                    }
                    return item.copy(i, list);
                }

                @SerialName("card_items")
                public static /* synthetic */ void getCardItems$annotations() {
                }

                @SerialName("scarcity_level")
                public static /* synthetic */ void getScarcityLevel$annotations() {
                }

                public final int component1() {
                    return this.scarcityLevel;
                }

                public final List<CardItem> component2() {
                    return this.cardItems;
                }

                public final Item copy(int i, List<CardItem> list) {
                    Intrinsics.checkNotNullParameter(list, "cardItems");
                    return new Item(i, list);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj instanceof Item) {
                        Item item = (Item) obj;
                        return this.scarcityLevel == item.scarcityLevel && Intrinsics.areEqual(this.cardItems, item.cardItems);
                    }
                    return false;
                }

                public int hashCode() {
                    return (this.scarcityLevel * 31) + this.cardItems.hashCode();
                }

                public String toString() {
                    int i = this.scarcityLevel;
                    return "Item(scarcityLevel=" + i + ", cardItems=" + this.cardItems + ")";
                }

                /* compiled from: BackpackAssetBagModel.kt */
                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/digital/backpack/api/BackpackAssetBagModel$Item$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/digital/backpack/api/BackpackAssetBagModel$Item;", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
                /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    private Companion() {
                    }

                    public final KSerializer<Item> serializer() {
                        return BackpackAssetBagModel$Item$$serializer.INSTANCE;
                    }
                }

                public /* synthetic */ Item(int seen0, int scarcityLevel, List cardItems, SerializationConstructorMarker serializationConstructorMarker) {
                    if ((seen0 & 1) == 0) {
                        this.scarcityLevel = 0;
                    } else {
                        this.scarcityLevel = scarcityLevel;
                    }
                    if ((seen0 & 2) == 0) {
                        this.cardItems = CollectionsKt.emptyList();
                    } else {
                        this.cardItems = cardItems;
                    }
                }

                public Item(int scarcityLevel, List<CardItem> list) {
                    Intrinsics.checkNotNullParameter(list, "cardItems");
                    this.scarcityLevel = scarcityLevel;
                    this.cardItems = list;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                    return new ArrayListSerializer(BackpackAssetBagModel$CardItem$$serializer.INSTANCE);
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$backpack_debug(Item self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                    if (output.shouldEncodeElementDefault(serialDesc, 0) || self.scarcityLevel != 0) {
                        output.encodeIntElement(serialDesc, 0, self.scarcityLevel);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.cardItems, CollectionsKt.emptyList())) {
                        output.encodeSerializableElement(serialDesc, 1, (SerializationStrategy) lazyArr[1].getValue(), self.cardItems);
                    }
                }

                public /* synthetic */ Item(int i, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? CollectionsKt.emptyList() : list);
                }

                public final int getScarcityLevel() {
                    return this.scarcityLevel;
                }

                public final List<CardItem> getCardItems() {
                    return this.cardItems;
                }
            }

            public final List<SubModule> getSubModuleList() {
                return this.subModuleList;
            }

            /* compiled from: BackpackAssetBagModel.kt */
            @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0002$%B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B-\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\tHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J%\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001¢\u0006\u0002\b#R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0013¨\u0006&"}, d2 = {"Lkntr/app/digital/backpack/api/BackpackAssetBagModel$Lottery;", RoomRecommendViewModel.EMPTY_CURSOR, "lotteryId", RoomRecommendViewModel.EMPTY_CURSOR, "lotteryName", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(JLjava/lang/String;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getLotteryId$annotations", "()V", "getLotteryId", "()J", "getLotteryName$annotations", "getLotteryName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$backpack_debug", "$serializer", "Companion", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
            @Serializable
            /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
            public static final class Lottery {
                public static final int $stable = 0;
                public static final Companion Companion = new Companion(null);
                private final long lotteryId;
                private final String lotteryName;

                public Lottery() {
                    this(0L, (String) null, 3, (DefaultConstructorMarker) null);
                }

                public static /* synthetic */ Lottery copy$default(Lottery lottery, long j2, String str, int i, Object obj) {
                    if ((i & 1) != 0) {
                        j2 = lottery.lotteryId;
                    }
                    if ((i & 2) != 0) {
                        str = lottery.lotteryName;
                    }
                    return lottery.copy(j2, str);
                }

                @SerialName("lottery_id")
                public static /* synthetic */ void getLotteryId$annotations() {
                }

                @SerialName("lottery_name")
                public static /* synthetic */ void getLotteryName$annotations() {
                }

                public final long component1() {
                    return this.lotteryId;
                }

                public final String component2() {
                    return this.lotteryName;
                }

                public final Lottery copy(long j2, String str) {
                    Intrinsics.checkNotNullParameter(str, "lotteryName");
                    return new Lottery(j2, str);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj instanceof Lottery) {
                        Lottery lottery = (Lottery) obj;
                        return this.lotteryId == lottery.lotteryId && Intrinsics.areEqual(this.lotteryName, lottery.lotteryName);
                    }
                    return false;
                }

                public int hashCode() {
                    return (ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.lotteryId) * 31) + this.lotteryName.hashCode();
                }

                public String toString() {
                    long j2 = this.lotteryId;
                    return "Lottery(lotteryId=" + j2 + ", lotteryName=" + this.lotteryName + ")";
                }

                /* compiled from: BackpackAssetBagModel.kt */
                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/digital/backpack/api/BackpackAssetBagModel$Lottery$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/digital/backpack/api/BackpackAssetBagModel$Lottery;", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
                /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    private Companion() {
                    }

                    public final KSerializer<Lottery> serializer() {
                        return BackpackAssetBagModel$Lottery$$serializer.INSTANCE;
                    }
                }

                public /* synthetic */ Lottery(int seen0, long lotteryId, String lotteryName, SerializationConstructorMarker serializationConstructorMarker) {
                    if ((seen0 & 1) == 0) {
                        this.lotteryId = 0L;
                    } else {
                        this.lotteryId = lotteryId;
                    }
                    if ((seen0 & 2) == 0) {
                        this.lotteryName = RoomRecommendViewModel.EMPTY_CURSOR;
                    } else {
                        this.lotteryName = lotteryName;
                    }
                }

                public Lottery(long lotteryId, String lotteryName) {
                    Intrinsics.checkNotNullParameter(lotteryName, "lotteryName");
                    this.lotteryId = lotteryId;
                    this.lotteryName = lotteryName;
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$backpack_debug(Lottery self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    if (output.shouldEncodeElementDefault(serialDesc, 0) || self.lotteryId != 0) {
                        output.encodeLongElement(serialDesc, 0, self.lotteryId);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.lotteryName, RoomRecommendViewModel.EMPTY_CURSOR)) {
                        output.encodeStringElement(serialDesc, 1, self.lotteryName);
                    }
                }

                public /* synthetic */ Lottery(long j2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? 0L : j2, (i & 2) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str);
                }

                public final long getLotteryId() {
                    return this.lotteryId;
                }

                public final String getLotteryName() {
                    return this.lotteryName;
                }
            }

            /* compiled from: BackpackAssetBagModel.kt */
            @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 U2\u00020\u0001:\u0002TUB\u008d\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015B\u0091\u0001\b\u0010\u0012\u0006\u0010\u0016\u001a\u00020\b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u0014\u0010\u0019J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0005HÆ\u0003J\t\u0010;\u001a\u00020\u0005HÆ\u0003J\t\u0010<\u001a\u00020\bHÆ\u0003J\t\u0010=\u001a\u00020\bHÆ\u0003J\t\u0010>\u001a\u00020\u0005HÆ\u0003J\t\u0010?\u001a\u00020\bHÆ\u0003J\t\u0010@\u001a\u00020\u0005HÆ\u0003J\t\u0010A\u001a\u00020\bHÆ\u0003J\t\u0010B\u001a\u00020\bHÆ\u0003J\t\u0010C\u001a\u00020\u0005HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u008f\u0001\u0010F\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÆ\u0001J\u0013\u0010G\u001a\u00020H2\b\u0010I\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010J\u001a\u00020\bHÖ\u0001J\t\u0010K\u001a\u00020\u0005HÖ\u0001J%\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020\u00002\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020RH\u0001¢\u0006\u0002\bSR\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u001b\u001a\u0004\b\"\u0010 R\u001c\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u001b\u001a\u0004\b$\u0010%R\u001c\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u001b\u001a\u0004\b'\u0010%R\u001c\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010\u001b\u001a\u0004\b)\u0010 R\u001c\u0010\u000b\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u001b\u001a\u0004\b+\u0010%R\u001c\u0010\f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010\u001b\u001a\u0004\b-\u0010 R\u001c\u0010\r\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010\u001b\u001a\u0004\b/\u0010%R\u001c\u0010\u000e\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010\u001b\u001a\u0004\b\u000e\u0010%R\u001c\u0010\u000f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b1\u0010\u001b\u001a\u0004\b2\u0010 R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b3\u0010\u001b\u001a\u0004\b4\u00105R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b6\u0010\u001b\u001a\u0004\b7\u00108¨\u0006V"}, d2 = {"Lkntr/app/digital/backpack/api/BackpackAssetBagModel$CardItem;", RoomRecommendViewModel.EMPTY_CURSOR, "cardTypeId", RoomRecommendViewModel.EMPTY_CURSOR, "cardName", RoomRecommendViewModel.EMPTY_CURSOR, "cardImg", "cardType", RoomRecommendViewModel.EMPTY_CURSOR, "cardSubType", "badgeUrl", "ownedCount", "holdingRate", "cardScarcity", "isLimitedCard", "anchorId", "tag", "Lkntr/app/digital/backpack/api/BackpackAssetBagModel$Tag;", "stockInfo", "Lkntr/app/digital/backpack/api/BackpackAssetBagModel$StockInfo;", "<init>", "(JLjava/lang/String;Ljava/lang/String;IILjava/lang/String;ILjava/lang/String;IILjava/lang/String;Lkntr/app/digital/backpack/api/BackpackAssetBagModel$Tag;Lkntr/app/digital/backpack/api/BackpackAssetBagModel$StockInfo;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;Ljava/lang/String;IILjava/lang/String;ILjava/lang/String;IILjava/lang/String;Lkntr/app/digital/backpack/api/BackpackAssetBagModel$Tag;Lkntr/app/digital/backpack/api/BackpackAssetBagModel$StockInfo;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCardTypeId$annotations", "()V", "getCardTypeId", "()J", "getCardName$annotations", "getCardName", "()Ljava/lang/String;", "getCardImg$annotations", "getCardImg", "getCardType$annotations", "getCardType", "()I", "getCardSubType$annotations", "getCardSubType", "getBadgeUrl$annotations", "getBadgeUrl", "getOwnedCount$annotations", "getOwnedCount", "getHoldingRate$annotations", "getHoldingRate", "getCardScarcity$annotations", "getCardScarcity", "isLimitedCard$annotations", "getAnchorId$annotations", "getAnchorId", "getTag$annotations", "getTag", "()Lkntr/app/digital/backpack/api/BackpackAssetBagModel$Tag;", "getStockInfo$annotations", "getStockInfo", "()Lkntr/app/digital/backpack/api/BackpackAssetBagModel$StockInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$backpack_debug", "$serializer", "Companion", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
            @Serializable
            /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
            public static final class CardItem {
                public static final int $stable = 0;
                public static final Companion Companion = new Companion(null);
                private final String anchorId;
                private final String badgeUrl;
                private final String cardImg;
                private final String cardName;
                private final int cardScarcity;
                private final int cardSubType;
                private final int cardType;
                private final long cardTypeId;
                private final String holdingRate;
                private final int isLimitedCard;
                private final int ownedCount;
                private final StockInfo stockInfo;
                private final Tag tag;

                public CardItem() {
                    this(0L, (String) null, (String) null, 0, 0, (String) null, 0, (String) null, 0, 0, (String) null, (Tag) null, (StockInfo) null, 8191, (DefaultConstructorMarker) null);
                }

                @SerialName("anchor_id")
                public static /* synthetic */ void getAnchorId$annotations() {
                }

                @SerialName("badge_url")
                public static /* synthetic */ void getBadgeUrl$annotations() {
                }

                @SerialName("card_img")
                public static /* synthetic */ void getCardImg$annotations() {
                }

                @SerialName("card_name")
                public static /* synthetic */ void getCardName$annotations() {
                }

                @SerialName("card_scarcity")
                public static /* synthetic */ void getCardScarcity$annotations() {
                }

                @SerialName("card_sub_type")
                public static /* synthetic */ void getCardSubType$annotations() {
                }

                @SerialName(ReportBuildInParam.CARD_TYPE)
                public static /* synthetic */ void getCardType$annotations() {
                }

                @SerialName("card_type_id")
                public static /* synthetic */ void getCardTypeId$annotations() {
                }

                @SerialName("holding_rate")
                public static /* synthetic */ void getHoldingRate$annotations() {
                }

                @SerialName("owned_count")
                public static /* synthetic */ void getOwnedCount$annotations() {
                }

                @SerialName("stock_info")
                public static /* synthetic */ void getStockInfo$annotations() {
                }

                @SerialName("tag")
                public static /* synthetic */ void getTag$annotations() {
                }

                @SerialName("is_limited_card")
                public static /* synthetic */ void isLimitedCard$annotations() {
                }

                public final long component1() {
                    return this.cardTypeId;
                }

                public final int component10() {
                    return this.isLimitedCard;
                }

                public final String component11() {
                    return this.anchorId;
                }

                public final Tag component12() {
                    return this.tag;
                }

                public final StockInfo component13() {
                    return this.stockInfo;
                }

                public final String component2() {
                    return this.cardName;
                }

                public final String component3() {
                    return this.cardImg;
                }

                public final int component4() {
                    return this.cardType;
                }

                public final int component5() {
                    return this.cardSubType;
                }

                public final String component6() {
                    return this.badgeUrl;
                }

                public final int component7() {
                    return this.ownedCount;
                }

                public final String component8() {
                    return this.holdingRate;
                }

                public final int component9() {
                    return this.cardScarcity;
                }

                public final CardItem copy(long j2, String str, String str2, int i, int i2, String str3, int i3, String str4, int i4, int i5, String str5, Tag tag, StockInfo stockInfo) {
                    Intrinsics.checkNotNullParameter(str, "cardName");
                    Intrinsics.checkNotNullParameter(str2, "cardImg");
                    Intrinsics.checkNotNullParameter(str3, "badgeUrl");
                    Intrinsics.checkNotNullParameter(str4, "holdingRate");
                    Intrinsics.checkNotNullParameter(str5, "anchorId");
                    return new CardItem(j2, str, str2, i, i2, str3, i3, str4, i4, i5, str5, tag, stockInfo);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj instanceof CardItem) {
                        CardItem cardItem = (CardItem) obj;
                        return this.cardTypeId == cardItem.cardTypeId && Intrinsics.areEqual(this.cardName, cardItem.cardName) && Intrinsics.areEqual(this.cardImg, cardItem.cardImg) && this.cardType == cardItem.cardType && this.cardSubType == cardItem.cardSubType && Intrinsics.areEqual(this.badgeUrl, cardItem.badgeUrl) && this.ownedCount == cardItem.ownedCount && Intrinsics.areEqual(this.holdingRate, cardItem.holdingRate) && this.cardScarcity == cardItem.cardScarcity && this.isLimitedCard == cardItem.isLimitedCard && Intrinsics.areEqual(this.anchorId, cardItem.anchorId) && Intrinsics.areEqual(this.tag, cardItem.tag) && Intrinsics.areEqual(this.stockInfo, cardItem.stockInfo);
                    }
                    return false;
                }

                public int hashCode() {
                    return (((((((((((((((((((((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.cardTypeId) * 31) + this.cardName.hashCode()) * 31) + this.cardImg.hashCode()) * 31) + this.cardType) * 31) + this.cardSubType) * 31) + this.badgeUrl.hashCode()) * 31) + this.ownedCount) * 31) + this.holdingRate.hashCode()) * 31) + this.cardScarcity) * 31) + this.isLimitedCard) * 31) + this.anchorId.hashCode()) * 31) + (this.tag == null ? 0 : this.tag.hashCode())) * 31) + (this.stockInfo != null ? this.stockInfo.hashCode() : 0);
                }

                public String toString() {
                    long j2 = this.cardTypeId;
                    String str = this.cardName;
                    String str2 = this.cardImg;
                    int i = this.cardType;
                    int i2 = this.cardSubType;
                    String str3 = this.badgeUrl;
                    int i3 = this.ownedCount;
                    String str4 = this.holdingRate;
                    int i4 = this.cardScarcity;
                    int i5 = this.isLimitedCard;
                    String str5 = this.anchorId;
                    Tag tag = this.tag;
                    return "CardItem(cardTypeId=" + j2 + ", cardName=" + str + ", cardImg=" + str2 + ", cardType=" + i + ", cardSubType=" + i2 + ", badgeUrl=" + str3 + ", ownedCount=" + i3 + ", holdingRate=" + str4 + ", cardScarcity=" + i4 + ", isLimitedCard=" + i5 + ", anchorId=" + str5 + ", tag=" + tag + ", stockInfo=" + this.stockInfo + ")";
                }

                /* compiled from: BackpackAssetBagModel.kt */
                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/digital/backpack/api/BackpackAssetBagModel$CardItem$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/digital/backpack/api/BackpackAssetBagModel$CardItem;", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
                /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    private Companion() {
                    }

                    public final KSerializer<CardItem> serializer() {
                        return BackpackAssetBagModel$CardItem$$serializer.INSTANCE;
                    }
                }

                public /* synthetic */ CardItem(int seen0, long cardTypeId, String cardName, String cardImg, int cardType, int cardSubType, String badgeUrl, int ownedCount, String holdingRate, int cardScarcity, int isLimitedCard, String anchorId, Tag tag, StockInfo stockInfo, SerializationConstructorMarker serializationConstructorMarker) {
                    if ((seen0 & 1) == 0) {
                        this.cardTypeId = 0L;
                    } else {
                        this.cardTypeId = cardTypeId;
                    }
                    if ((seen0 & 2) == 0) {
                        this.cardName = RoomRecommendViewModel.EMPTY_CURSOR;
                    } else {
                        this.cardName = cardName;
                    }
                    if ((seen0 & 4) == 0) {
                        this.cardImg = RoomRecommendViewModel.EMPTY_CURSOR;
                    } else {
                        this.cardImg = cardImg;
                    }
                    if ((seen0 & 8) == 0) {
                        this.cardType = 0;
                    } else {
                        this.cardType = cardType;
                    }
                    if ((seen0 & 16) == 0) {
                        this.cardSubType = 0;
                    } else {
                        this.cardSubType = cardSubType;
                    }
                    if ((seen0 & 32) == 0) {
                        this.badgeUrl = RoomRecommendViewModel.EMPTY_CURSOR;
                    } else {
                        this.badgeUrl = badgeUrl;
                    }
                    if ((seen0 & 64) == 0) {
                        this.ownedCount = 0;
                    } else {
                        this.ownedCount = ownedCount;
                    }
                    if ((seen0 & 128) == 0) {
                        this.holdingRate = RoomRecommendViewModel.EMPTY_CURSOR;
                    } else {
                        this.holdingRate = holdingRate;
                    }
                    if ((seen0 & 256) == 0) {
                        this.cardScarcity = 0;
                    } else {
                        this.cardScarcity = cardScarcity;
                    }
                    if ((seen0 & 512) == 0) {
                        this.isLimitedCard = 0;
                    } else {
                        this.isLimitedCard = isLimitedCard;
                    }
                    if ((seen0 & 1024) == 0) {
                        this.anchorId = RoomRecommendViewModel.EMPTY_CURSOR;
                    } else {
                        this.anchorId = anchorId;
                    }
                    if ((seen0 & 2048) == 0) {
                        this.tag = null;
                    } else {
                        this.tag = tag;
                    }
                    if ((seen0 & 4096) == 0) {
                        this.stockInfo = null;
                    } else {
                        this.stockInfo = stockInfo;
                    }
                }

                public CardItem(long cardTypeId, String cardName, String cardImg, int cardType, int cardSubType, String badgeUrl, int ownedCount, String holdingRate, int cardScarcity, int isLimitedCard, String anchorId, Tag tag, StockInfo stockInfo) {
                    Intrinsics.checkNotNullParameter(cardName, "cardName");
                    Intrinsics.checkNotNullParameter(cardImg, "cardImg");
                    Intrinsics.checkNotNullParameter(badgeUrl, "badgeUrl");
                    Intrinsics.checkNotNullParameter(holdingRate, "holdingRate");
                    Intrinsics.checkNotNullParameter(anchorId, "anchorId");
                    this.cardTypeId = cardTypeId;
                    this.cardName = cardName;
                    this.cardImg = cardImg;
                    this.cardType = cardType;
                    this.cardSubType = cardSubType;
                    this.badgeUrl = badgeUrl;
                    this.ownedCount = ownedCount;
                    this.holdingRate = holdingRate;
                    this.cardScarcity = cardScarcity;
                    this.isLimitedCard = isLimitedCard;
                    this.anchorId = anchorId;
                    this.tag = tag;
                    this.stockInfo = stockInfo;
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$backpack_debug(CardItem self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    if (output.shouldEncodeElementDefault(serialDesc, 0) || self.cardTypeId != 0) {
                        output.encodeLongElement(serialDesc, 0, self.cardTypeId);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.cardName, RoomRecommendViewModel.EMPTY_CURSOR)) {
                        output.encodeStringElement(serialDesc, 1, self.cardName);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.cardImg, RoomRecommendViewModel.EMPTY_CURSOR)) {
                        output.encodeStringElement(serialDesc, 2, self.cardImg);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 3) || self.cardType != 0) {
                        output.encodeIntElement(serialDesc, 3, self.cardType);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 4) || self.cardSubType != 0) {
                        output.encodeIntElement(serialDesc, 4, self.cardSubType);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 5) || !Intrinsics.areEqual(self.badgeUrl, RoomRecommendViewModel.EMPTY_CURSOR)) {
                        output.encodeStringElement(serialDesc, 5, self.badgeUrl);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 6) || self.ownedCount != 0) {
                        output.encodeIntElement(serialDesc, 6, self.ownedCount);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 7) || !Intrinsics.areEqual(self.holdingRate, RoomRecommendViewModel.EMPTY_CURSOR)) {
                        output.encodeStringElement(serialDesc, 7, self.holdingRate);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 8) || self.cardScarcity != 0) {
                        output.encodeIntElement(serialDesc, 8, self.cardScarcity);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 9) || self.isLimitedCard != 0) {
                        output.encodeIntElement(serialDesc, 9, self.isLimitedCard);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 10) || !Intrinsics.areEqual(self.anchorId, RoomRecommendViewModel.EMPTY_CURSOR)) {
                        output.encodeStringElement(serialDesc, 10, self.anchorId);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 11) || self.tag != null) {
                        output.encodeNullableSerializableElement(serialDesc, 11, BackpackAssetBagModel$Tag$$serializer.INSTANCE, self.tag);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 12) || self.stockInfo != null) {
                        output.encodeNullableSerializableElement(serialDesc, 12, BackpackAssetBagModel$StockInfo$$serializer.INSTANCE, self.stockInfo);
                    }
                }

                public /* synthetic */ CardItem(long j2, String str, String str2, int i, int i2, String str3, int i3, String str4, int i4, int i5, String str5, Tag tag, StockInfo stockInfo, int i6, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i6 & 1) != 0 ? 0L : j2, (i6 & 2) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i6 & 4) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str2, (i6 & 8) != 0 ? 0 : i, (i6 & 16) != 0 ? 0 : i2, (i6 & 32) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str3, (i6 & 64) != 0 ? 0 : i3, (i6 & 128) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str4, (i6 & 256) != 0 ? 0 : i4, (i6 & 512) == 0 ? i5 : 0, (i6 & 1024) == 0 ? str5 : RoomRecommendViewModel.EMPTY_CURSOR, (i6 & 2048) != 0 ? null : tag, (i6 & 4096) == 0 ? stockInfo : null);
                }

                public final long getCardTypeId() {
                    return this.cardTypeId;
                }

                public final String getCardName() {
                    return this.cardName;
                }

                public final String getCardImg() {
                    return this.cardImg;
                }

                public final int getCardType() {
                    return this.cardType;
                }

                public final int getCardSubType() {
                    return this.cardSubType;
                }

                public final String getBadgeUrl() {
                    return this.badgeUrl;
                }

                public final int getOwnedCount() {
                    return this.ownedCount;
                }

                public final String getHoldingRate() {
                    return this.holdingRate;
                }

                public final int getCardScarcity() {
                    return this.cardScarcity;
                }

                public final int isLimitedCard() {
                    return this.isLimitedCard;
                }

                public final String getAnchorId() {
                    return this.anchorId;
                }

                public final Tag getTag() {
                    return this.tag;
                }

                public final StockInfo getStockInfo() {
                    return this.stockInfo;
                }
            }

            /* compiled from: BackpackAssetBagModel.kt */
            @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0003#$%B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B/\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\tHÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J%\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0001¢\u0006\u0002\b\"R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006&"}, d2 = {"Lkntr/app/digital/backpack/api/BackpackAssetBagModel$SubModule;", RoomRecommendViewModel.EMPTY_CURSOR, "type", RoomRecommendViewModel.EMPTY_CURSOR, "data", "Lkntr/app/digital/backpack/api/BackpackAssetBagModel$SubModule$Data;", "<init>", "(Ljava/lang/String;Lkntr/app/digital/backpack/api/BackpackAssetBagModel$SubModule$Data;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lkntr/app/digital/backpack/api/BackpackAssetBagModel$SubModule$Data;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getType$annotations", "()V", "getType", "()Ljava/lang/String;", "getData", "()Lkntr/app/digital/backpack/api/BackpackAssetBagModel$SubModule$Data;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$backpack_debug", "Data", "$serializer", "Companion", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
            @Serializable
            /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
            public static final class SubModule {
                public static final int $stable = 0;
                public static final Companion Companion = new Companion(null);
                private final Data data;
                private final String type;

                public SubModule() {
                    this((String) null, (Data) null, 3, (DefaultConstructorMarker) null);
                }

                public static /* synthetic */ SubModule copy$default(SubModule subModule, String str, Data data, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = subModule.type;
                    }
                    if ((i & 2) != 0) {
                        data = subModule.data;
                    }
                    return subModule.copy(str, data);
                }

                @SerialName("function_type")
                public static /* synthetic */ void getType$annotations() {
                }

                public final String component1() {
                    return this.type;
                }

                public final Data component2() {
                    return this.data;
                }

                public final SubModule copy(String str, Data data) {
                    Intrinsics.checkNotNullParameter(str, "type");
                    Intrinsics.checkNotNullParameter(data, "data");
                    return new SubModule(str, data);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj instanceof SubModule) {
                        SubModule subModule = (SubModule) obj;
                        return Intrinsics.areEqual(this.type, subModule.type) && Intrinsics.areEqual(this.data, subModule.data);
                    }
                    return false;
                }

                public int hashCode() {
                    return (this.type.hashCode() * 31) + this.data.hashCode();
                }

                public String toString() {
                    String str = this.type;
                    return "SubModule(type=" + str + ", data=" + this.data + ")";
                }

                /* compiled from: BackpackAssetBagModel.kt */
                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/digital/backpack/api/BackpackAssetBagModel$SubModule$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/digital/backpack/api/BackpackAssetBagModel$SubModule;", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
                /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    private Companion() {
                    }

                    public final KSerializer<SubModule> serializer() {
                        return BackpackAssetBagModel$SubModule$$serializer.INSTANCE;
                    }
                }

                public /* synthetic */ SubModule(int seen0, String type, Data data, SerializationConstructorMarker serializationConstructorMarker) {
                    if ((seen0 & 1) == 0) {
                        this.type = RoomRecommendViewModel.EMPTY_CURSOR;
                    } else {
                        this.type = type;
                    }
                    if ((seen0 & 2) == 0) {
                        this.data = new Data((String) null, false, 3, (DefaultConstructorMarker) null);
                    } else {
                        this.data = data;
                    }
                }

                public SubModule(String type, Data data) {
                    Intrinsics.checkNotNullParameter(type, "type");
                    Intrinsics.checkNotNullParameter(data, "data");
                    this.type = type;
                    this.data = data;
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$backpack_debug(SubModule self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.type, RoomRecommendViewModel.EMPTY_CURSOR)) {
                        output.encodeStringElement(serialDesc, 0, self.type);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.data, new Data((String) null, false, 3, (DefaultConstructorMarker) null))) {
                        output.encodeSerializableElement(serialDesc, 1, BackpackAssetBagModel$SubModule$Data$$serializer.INSTANCE, self.data);
                    }
                }

                public /* synthetic */ SubModule(String str, Data data, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i & 2) != 0 ? new Data((String) null, false, 3, (DefaultConstructorMarker) null) : data);
                }

                public final String getType() {
                    return this.type;
                }

                /* compiled from: BackpackAssetBagModel.kt */
                @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0002&'B.\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u001b\b\u0002\u0010\u0004\u001a\u00150\u0005j\u0002`\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\t0\b¢\u0006\u0004\b\n\u0010\u000bB-\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u001c\u0010\u0018\u001a\u00150\u0005j\u0002`\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\t0\bHÆ\u0003J0\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u001b\b\u0002\u0010\u0004\u001a\u00150\u0005j\u0002`\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\t0\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\rHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J%\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0001¢\u0006\u0002\b%R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R/\u0010\u0004\u001a\u00150\u0005j\u0002`\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\t0\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006("}, d2 = {"Lkntr/app/digital/backpack/api/BackpackAssetBagModel$SubModule$Data;", RoomRecommendViewModel.EMPTY_CURSOR, "url", RoomRecommendViewModel.EMPTY_CURSOR, "hasDot", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/serialization/Serializable;", "with", "Lkotlin/reflect/KClass;", "Lcom/bilibili/ogv/bpf/serialization/BooleanAsInt;", "<init>", "(Ljava/lang/String;Z)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getUrl", "()Ljava/lang/String;", "getHasDot$annotations", "()V", "getHasDot", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$backpack_debug", "$serializer", "Companion", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
                @Serializable
                /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                public static final class Data {
                    public static final int $stable = 0;
                    public static final Companion Companion = new Companion(null);
                    private final boolean hasDot;
                    private final String url;

                    public Data() {
                        this((String) null, false, 3, (DefaultConstructorMarker) null);
                    }

                    public static /* synthetic */ Data copy$default(Data data, String str, boolean z, int i, Object obj) {
                        if ((i & 1) != 0) {
                            str = data.url;
                        }
                        if ((i & 2) != 0) {
                            z = data.hasDot;
                        }
                        return data.copy(str, z);
                    }

                    @SerialName("receive_sign")
                    public static /* synthetic */ void getHasDot$annotations() {
                    }

                    public final String component1() {
                        return this.url;
                    }

                    public final boolean component2() {
                        return this.hasDot;
                    }

                    public final Data copy(String str, boolean z) {
                        Intrinsics.checkNotNullParameter(str, "url");
                        return new Data(str, z);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj instanceof Data) {
                            Data data = (Data) obj;
                            return Intrinsics.areEqual(this.url, data.url) && this.hasDot == data.hasDot;
                        }
                        return false;
                    }

                    public int hashCode() {
                        return (this.url.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.hasDot);
                    }

                    public String toString() {
                        String str = this.url;
                        return "Data(url=" + str + ", hasDot=" + this.hasDot + ")";
                    }

                    /* compiled from: BackpackAssetBagModel.kt */
                    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/digital/backpack/api/BackpackAssetBagModel$SubModule$Data$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/digital/backpack/api/BackpackAssetBagModel$SubModule$Data;", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
                    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                    public static final class Companion {
                        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                            this();
                        }

                        private Companion() {
                        }

                        public final KSerializer<Data> serializer() {
                            return BackpackAssetBagModel$SubModule$Data$$serializer.INSTANCE;
                        }
                    }

                    public /* synthetic */ Data(int seen0, String url, boolean hasDot, SerializationConstructorMarker serializationConstructorMarker) {
                        if ((seen0 & 1) == 0) {
                            this.url = RoomRecommendViewModel.EMPTY_CURSOR;
                        } else {
                            this.url = url;
                        }
                        if ((seen0 & 2) == 0) {
                            this.hasDot = false;
                        } else {
                            this.hasDot = hasDot;
                        }
                    }

                    public Data(String url, boolean hasDot) {
                        Intrinsics.checkNotNullParameter(url, "url");
                        this.url = url;
                        this.hasDot = hasDot;
                    }

                    @JvmStatic
                    public static final /* synthetic */ void write$Self$backpack_debug(Data self, CompositeEncoder output, SerialDescriptor serialDesc) {
                        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.url, RoomRecommendViewModel.EMPTY_CURSOR)) {
                            output.encodeStringElement(serialDesc, 0, self.url);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.hasDot) {
                            output.encodeSerializableElement(serialDesc, 1, BooleanAsIntSerializer.INSTANCE, Boolean.valueOf(self.hasDot));
                        }
                    }

                    public /* synthetic */ Data(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
                        this((i & 1) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i & 2) != 0 ? false : z);
                    }

                    public final String getUrl() {
                        return this.url;
                    }

                    public final boolean getHasDot() {
                        return this.hasDot;
                    }
                }

                public final Data getData() {
                    return this.data;
                }
            }

            /* compiled from: BackpackAssetBagModel.kt */
            @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B+\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0005\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000e¨\u0006$"}, d2 = {"Lkntr/app/digital/backpack/api/BackpackAssetBagModel$StockInfo;", RoomRecommendViewModel.EMPTY_CURSOR, "stock", RoomRecommendViewModel.EMPTY_CURSOR, "totalStock", "<init>", "(II)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getStock$annotations", "()V", "getStock", "()I", "getTotalStock$annotations", "getTotalStock", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", RoomRecommendViewModel.EMPTY_CURSOR, "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$backpack_debug", "$serializer", "Companion", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
            @Serializable
            /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
            public static final class StockInfo {
                public static final int $stable = 0;
                public static final Companion Companion = new Companion(null);
                private final int stock;
                private final int totalStock;

                public StockInfo() {
                    this(0, 0, 3, (DefaultConstructorMarker) null);
                }

                public static /* synthetic */ StockInfo copy$default(StockInfo stockInfo, int i, int i2, int i3, Object obj) {
                    if ((i3 & 1) != 0) {
                        i = stockInfo.stock;
                    }
                    if ((i3 & 2) != 0) {
                        i2 = stockInfo.totalStock;
                    }
                    return stockInfo.copy(i, i2);
                }

                @SerialName("stock")
                public static /* synthetic */ void getStock$annotations() {
                }

                @SerialName("total_stock")
                public static /* synthetic */ void getTotalStock$annotations() {
                }

                public final int component1() {
                    return this.stock;
                }

                public final int component2() {
                    return this.totalStock;
                }

                public final StockInfo copy(int i, int i2) {
                    return new StockInfo(i, i2);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj instanceof StockInfo) {
                        StockInfo stockInfo = (StockInfo) obj;
                        return this.stock == stockInfo.stock && this.totalStock == stockInfo.totalStock;
                    }
                    return false;
                }

                public int hashCode() {
                    return (this.stock * 31) + this.totalStock;
                }

                public String toString() {
                    int i = this.stock;
                    return "StockInfo(stock=" + i + ", totalStock=" + this.totalStock + ")";
                }

                /* compiled from: BackpackAssetBagModel.kt */
                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/digital/backpack/api/BackpackAssetBagModel$StockInfo$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/digital/backpack/api/BackpackAssetBagModel$StockInfo;", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
                /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    private Companion() {
                    }

                    public final KSerializer<StockInfo> serializer() {
                        return BackpackAssetBagModel$StockInfo$$serializer.INSTANCE;
                    }
                }

                public StockInfo(int stock, int totalStock) {
                    this.stock = stock;
                    this.totalStock = totalStock;
                }

                public /* synthetic */ StockInfo(int seen0, int stock, int totalStock, SerializationConstructorMarker serializationConstructorMarker) {
                    if ((seen0 & 1) == 0) {
                        this.stock = 0;
                    } else {
                        this.stock = stock;
                    }
                    if ((seen0 & 2) == 0) {
                        this.totalStock = 0;
                    } else {
                        this.totalStock = totalStock;
                    }
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$backpack_debug(StockInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    if (output.shouldEncodeElementDefault(serialDesc, 0) || self.stock != 0) {
                        output.encodeIntElement(serialDesc, 0, self.stock);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 1) || self.totalStock != 0) {
                        output.encodeIntElement(serialDesc, 1, self.totalStock);
                    }
                }

                public /* synthetic */ StockInfo(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
                }

                public final int getStock() {
                    return this.stock;
                }

                public final int getTotalStock() {
                    return this.totalStock;
                }
            }

            /* compiled from: BackpackAssetBagModel.kt */
            @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B/\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\bHÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000f¨\u0006$"}, d2 = {"Lkntr/app/digital/backpack/api/BackpackAssetBagModel$Tag;", RoomRecommendViewModel.EMPTY_CURSOR, "imageUrl", RoomRecommendViewModel.EMPTY_CURSOR, "content", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getImageUrl$annotations", "()V", "getImageUrl", "()Ljava/lang/String;", "getContent$annotations", "getContent", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$backpack_debug", "$serializer", "Companion", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
            @Serializable
            /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
            public static final class Tag {
                public static final int $stable = 0;
                public static final Companion Companion = new Companion(null);
                private final String content;
                private final String imageUrl;

                public Tag() {
                    this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
                }

                public static /* synthetic */ Tag copy$default(Tag tag, String str, String str2, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = tag.imageUrl;
                    }
                    if ((i & 2) != 0) {
                        str2 = tag.content;
                    }
                    return tag.copy(str, str2);
                }

                @SerialName("content")
                public static /* synthetic */ void getContent$annotations() {
                }

                @SerialName("image_url")
                public static /* synthetic */ void getImageUrl$annotations() {
                }

                public final String component1() {
                    return this.imageUrl;
                }

                public final String component2() {
                    return this.content;
                }

                public final Tag copy(String str, String str2) {
                    Intrinsics.checkNotNullParameter(str, "imageUrl");
                    Intrinsics.checkNotNullParameter(str2, "content");
                    return new Tag(str, str2);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj instanceof Tag) {
                        Tag tag = (Tag) obj;
                        return Intrinsics.areEqual(this.imageUrl, tag.imageUrl) && Intrinsics.areEqual(this.content, tag.content);
                    }
                    return false;
                }

                public int hashCode() {
                    return (this.imageUrl.hashCode() * 31) + this.content.hashCode();
                }

                public String toString() {
                    String str = this.imageUrl;
                    return "Tag(imageUrl=" + str + ", content=" + this.content + ")";
                }

                /* compiled from: BackpackAssetBagModel.kt */
                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/digital/backpack/api/BackpackAssetBagModel$Tag$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/digital/backpack/api/BackpackAssetBagModel$Tag;", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
                /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    private Companion() {
                    }

                    public final KSerializer<Tag> serializer() {
                        return BackpackAssetBagModel$Tag$$serializer.INSTANCE;
                    }
                }

                public /* synthetic */ Tag(int seen0, String imageUrl, String content, SerializationConstructorMarker serializationConstructorMarker) {
                    if ((seen0 & 1) == 0) {
                        this.imageUrl = RoomRecommendViewModel.EMPTY_CURSOR;
                    } else {
                        this.imageUrl = imageUrl;
                    }
                    if ((seen0 & 2) == 0) {
                        this.content = RoomRecommendViewModel.EMPTY_CURSOR;
                    } else {
                        this.content = content;
                    }
                }

                public Tag(String imageUrl, String content) {
                    Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
                    Intrinsics.checkNotNullParameter(content, "content");
                    this.imageUrl = imageUrl;
                    this.content = content;
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$backpack_debug(Tag self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.imageUrl, RoomRecommendViewModel.EMPTY_CURSOR)) {
                        output.encodeStringElement(serialDesc, 0, self.imageUrl);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.content, RoomRecommendViewModel.EMPTY_CURSOR)) {
                        output.encodeStringElement(serialDesc, 1, self.content);
                    }
                }

                public /* synthetic */ Tag(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i & 2) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str2);
                }

                public final String getImageUrl() {
                    return this.imageUrl;
                }

                public final String getContent() {
                    return this.content;
                }
            }

            /* compiled from: BackpackAssetBagModel.kt */
            @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 82\u00020\u0001:\u000278BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fB]\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u000b\u0010\u0010J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003JO\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u0003HÖ\u0001J\t\u0010.\u001a\u00020\u0005HÖ\u0001J%\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00002\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0001¢\u0006\u0002\b6R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0017R\u001c\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0017R\u001c\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u0014R\u001c\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0012\u001a\u0004\b\u001f\u0010\u0017R\u001c\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0012\u001a\u0004\b!\u0010\u0017¨\u00069"}, d2 = {"Lkntr/app/digital/backpack/api/BackpackAssetBagModel$Collect;", RoomRecommendViewModel.EMPTY_CURSOR, "collectId", RoomRecommendViewModel.EMPTY_CURSOR, "redeemItemId", RoomRecommendViewModel.EMPTY_CURSOR, "redeemItemName", "redeemItemImage", "ownedCount", "redeemText", "anchorId", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCollectId$annotations", "()V", "getCollectId", "()I", "getRedeemItemId$annotations", "getRedeemItemId", "()Ljava/lang/String;", "getRedeemItemName$annotations", "getRedeemItemName", "getRedeemItemImage$annotations", "getRedeemItemImage", "getOwnedCount$annotations", "getOwnedCount", "getRedeemText$annotations", "getRedeemText", "getAnchorId$annotations", "getAnchorId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$backpack_debug", "$serializer", "Companion", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
            @Serializable
            /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
            public static final class Collect {
                public static final int $stable = 0;
                public static final Companion Companion = new Companion(null);
                private final String anchorId;
                private final int collectId;
                private final int ownedCount;
                private final String redeemItemId;
                private final String redeemItemImage;
                private final String redeemItemName;
                private final String redeemText;

                public static /* synthetic */ Collect copy$default(Collect collect, int i, String str, String str2, String str3, int i2, String str4, String str5, int i3, Object obj) {
                    if ((i3 & 1) != 0) {
                        i = collect.collectId;
                    }
                    if ((i3 & 2) != 0) {
                        str = collect.redeemItemId;
                    }
                    String str6 = str;
                    if ((i3 & 4) != 0) {
                        str2 = collect.redeemItemName;
                    }
                    String str7 = str2;
                    if ((i3 & 8) != 0) {
                        str3 = collect.redeemItemImage;
                    }
                    String str8 = str3;
                    if ((i3 & 16) != 0) {
                        i2 = collect.ownedCount;
                    }
                    int i4 = i2;
                    if ((i3 & 32) != 0) {
                        str4 = collect.redeemText;
                    }
                    String str9 = str4;
                    if ((i3 & 64) != 0) {
                        str5 = collect.anchorId;
                    }
                    return collect.copy(i, str6, str7, str8, i4, str9, str5);
                }

                @SerialName("anchor_id")
                public static /* synthetic */ void getAnchorId$annotations() {
                }

                @SerialName("collect_id")
                public static /* synthetic */ void getCollectId$annotations() {
                }

                @SerialName("owned_count")
                public static /* synthetic */ void getOwnedCount$annotations() {
                }

                @SerialName("redeem_item_id")
                public static /* synthetic */ void getRedeemItemId$annotations() {
                }

                @SerialName("redeem_item_image")
                public static /* synthetic */ void getRedeemItemImage$annotations() {
                }

                @SerialName("redeem_item_name")
                public static /* synthetic */ void getRedeemItemName$annotations() {
                }

                @SerialName("redeem_text")
                public static /* synthetic */ void getRedeemText$annotations() {
                }

                public final int component1() {
                    return this.collectId;
                }

                public final String component2() {
                    return this.redeemItemId;
                }

                public final String component3() {
                    return this.redeemItemName;
                }

                public final String component4() {
                    return this.redeemItemImage;
                }

                public final int component5() {
                    return this.ownedCount;
                }

                public final String component6() {
                    return this.redeemText;
                }

                public final String component7() {
                    return this.anchorId;
                }

                public final Collect copy(int i, String str, String str2, String str3, int i2, String str4, String str5) {
                    Intrinsics.checkNotNullParameter(str, "redeemItemId");
                    Intrinsics.checkNotNullParameter(str2, "redeemItemName");
                    Intrinsics.checkNotNullParameter(str3, "redeemItemImage");
                    Intrinsics.checkNotNullParameter(str4, "redeemText");
                    Intrinsics.checkNotNullParameter(str5, "anchorId");
                    return new Collect(i, str, str2, str3, i2, str4, str5);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj instanceof Collect) {
                        Collect collect = (Collect) obj;
                        return this.collectId == collect.collectId && Intrinsics.areEqual(this.redeemItemId, collect.redeemItemId) && Intrinsics.areEqual(this.redeemItemName, collect.redeemItemName) && Intrinsics.areEqual(this.redeemItemImage, collect.redeemItemImage) && this.ownedCount == collect.ownedCount && Intrinsics.areEqual(this.redeemText, collect.redeemText) && Intrinsics.areEqual(this.anchorId, collect.anchorId);
                    }
                    return false;
                }

                public int hashCode() {
                    return (((((((((((this.collectId * 31) + this.redeemItemId.hashCode()) * 31) + this.redeemItemName.hashCode()) * 31) + this.redeemItemImage.hashCode()) * 31) + this.ownedCount) * 31) + this.redeemText.hashCode()) * 31) + this.anchorId.hashCode();
                }

                public String toString() {
                    int i = this.collectId;
                    String str = this.redeemItemId;
                    String str2 = this.redeemItemName;
                    String str3 = this.redeemItemImage;
                    int i2 = this.ownedCount;
                    String str4 = this.redeemText;
                    return "Collect(collectId=" + i + ", redeemItemId=" + str + ", redeemItemName=" + str2 + ", redeemItemImage=" + str3 + ", ownedCount=" + i2 + ", redeemText=" + str4 + ", anchorId=" + this.anchorId + ")";
                }

                /* compiled from: BackpackAssetBagModel.kt */
                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/digital/backpack/api/BackpackAssetBagModel$Collect$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/digital/backpack/api/BackpackAssetBagModel$Collect;", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
                /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    private Companion() {
                    }

                    public final KSerializer<Collect> serializer() {
                        return BackpackAssetBagModel$Collect$$serializer.INSTANCE;
                    }
                }

                public /* synthetic */ Collect(int seen0, int collectId, String redeemItemId, String redeemItemName, String redeemItemImage, int ownedCount, String redeemText, String anchorId, SerializationConstructorMarker serializationConstructorMarker) {
                    if (2 != (seen0 & 2)) {
                        PluginExceptionsKt.throwMissingFieldException(seen0, 2, BackpackAssetBagModel$Collect$$serializer.INSTANCE.getDescriptor());
                    }
                    if ((seen0 & 1) == 0) {
                        this.collectId = 0;
                    } else {
                        this.collectId = collectId;
                    }
                    this.redeemItemId = redeemItemId;
                    if ((seen0 & 4) == 0) {
                        this.redeemItemName = RoomRecommendViewModel.EMPTY_CURSOR;
                    } else {
                        this.redeemItemName = redeemItemName;
                    }
                    if ((seen0 & 8) == 0) {
                        this.redeemItemImage = RoomRecommendViewModel.EMPTY_CURSOR;
                    } else {
                        this.redeemItemImage = redeemItemImage;
                    }
                    if ((seen0 & 16) == 0) {
                        this.ownedCount = 0;
                    } else {
                        this.ownedCount = ownedCount;
                    }
                    if ((seen0 & 32) == 0) {
                        this.redeemText = RoomRecommendViewModel.EMPTY_CURSOR;
                    } else {
                        this.redeemText = redeemText;
                    }
                    if ((seen0 & 64) == 0) {
                        this.anchorId = RoomRecommendViewModel.EMPTY_CURSOR;
                    } else {
                        this.anchorId = anchorId;
                    }
                }

                public Collect(int collectId, String redeemItemId, String redeemItemName, String redeemItemImage, int ownedCount, String redeemText, String anchorId) {
                    Intrinsics.checkNotNullParameter(redeemItemId, "redeemItemId");
                    Intrinsics.checkNotNullParameter(redeemItemName, "redeemItemName");
                    Intrinsics.checkNotNullParameter(redeemItemImage, "redeemItemImage");
                    Intrinsics.checkNotNullParameter(redeemText, "redeemText");
                    Intrinsics.checkNotNullParameter(anchorId, "anchorId");
                    this.collectId = collectId;
                    this.redeemItemId = redeemItemId;
                    this.redeemItemName = redeemItemName;
                    this.redeemItemImage = redeemItemImage;
                    this.ownedCount = ownedCount;
                    this.redeemText = redeemText;
                    this.anchorId = anchorId;
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$backpack_debug(Collect self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    if (output.shouldEncodeElementDefault(serialDesc, 0) || self.collectId != 0) {
                        output.encodeIntElement(serialDesc, 0, self.collectId);
                    }
                    output.encodeStringElement(serialDesc, 1, self.redeemItemId);
                    if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.redeemItemName, RoomRecommendViewModel.EMPTY_CURSOR)) {
                        output.encodeStringElement(serialDesc, 2, self.redeemItemName);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.redeemItemImage, RoomRecommendViewModel.EMPTY_CURSOR)) {
                        output.encodeStringElement(serialDesc, 3, self.redeemItemImage);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 4) || self.ownedCount != 0) {
                        output.encodeIntElement(serialDesc, 4, self.ownedCount);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 5) || !Intrinsics.areEqual(self.redeemText, RoomRecommendViewModel.EMPTY_CURSOR)) {
                        output.encodeStringElement(serialDesc, 5, self.redeemText);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 6) || !Intrinsics.areEqual(self.anchorId, RoomRecommendViewModel.EMPTY_CURSOR)) {
                        output.encodeStringElement(serialDesc, 6, self.anchorId);
                    }
                }

                public /* synthetic */ Collect(int i, String str, String str2, String str3, int i2, String str4, String str5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i3 & 1) != 0 ? 0 : i, str, (i3 & 4) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str2, (i3 & 8) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str3, (i3 & 16) != 0 ? 0 : i2, (i3 & 32) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str4, (i3 & 64) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str5);
                }

                public final int getCollectId() {
                    return this.collectId;
                }

                public final String getRedeemItemId() {
                    return this.redeemItemId;
                }

                public final String getRedeemItemName() {
                    return this.redeemItemName;
                }

                public final String getRedeemItemImage() {
                    return this.redeemItemImage;
                }

                public final int getOwnedCount() {
                    return this.ownedCount;
                }

                public final String getRedeemText() {
                    return this.redeemText;
                }

                public final String getAnchorId() {
                    return this.anchorId;
                }
            }
        }
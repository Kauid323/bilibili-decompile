package kntr.app.ad.common.model;

import BottomSheetItemData$;
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
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AdAndroidGameInfo.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0002*+B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fBE\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u000b\u0010\u0010J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010\u001c\u001a\u00020\nHÆ\u0003J;\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0006HÖ\u0001J\t\u0010!\u001a\u00020\bHÖ\u0001J%\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0002\b)R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006,"}, d2 = {"Lkntr/app/ad/common/model/AdGameGradeModule;", RoomRecommendViewModel.EMPTY_CURSOR, "display", RoomRecommendViewModel.EMPTY_CURSOR, "starNumberList", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "commentStr", RoomRecommendViewModel.EMPTY_CURSOR, "grade", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(ZLjava/util/List;Ljava/lang/String;F)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZLjava/util/List;Ljava/lang/String;FLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getDisplay", "()Z", "getStarNumberList", "()Ljava/util/List;", "getCommentStr", "()Ljava/lang/String;", "getGrade", "()F", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdGameGradeModule {
    private final String commentStr;
    private final boolean display;
    private final float grade;
    private final List<Integer> starNumberList;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.AdGameGradeModule$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = AdGameGradeModule._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null, null};

    public AdGameGradeModule() {
        this(false, (List) null, (String) null, 0.0f, 15, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AdGameGradeModule copy$default(AdGameGradeModule adGameGradeModule, boolean z, List list, String str, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            z = adGameGradeModule.display;
        }
        if ((i & 2) != 0) {
            list = adGameGradeModule.starNumberList;
        }
        if ((i & 4) != 0) {
            str = adGameGradeModule.commentStr;
        }
        if ((i & 8) != 0) {
            f = adGameGradeModule.grade;
        }
        return adGameGradeModule.copy(z, list, str, f);
    }

    public final boolean component1() {
        return this.display;
    }

    public final List<Integer> component2() {
        return this.starNumberList;
    }

    public final String component3() {
        return this.commentStr;
    }

    public final float component4() {
        return this.grade;
    }

    public final AdGameGradeModule copy(boolean z, List<Integer> list, String str, float f) {
        return new AdGameGradeModule(z, list, str, f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdGameGradeModule) {
            AdGameGradeModule adGameGradeModule = (AdGameGradeModule) obj;
            return this.display == adGameGradeModule.display && Intrinsics.areEqual(this.starNumberList, adGameGradeModule.starNumberList) && Intrinsics.areEqual(this.commentStr, adGameGradeModule.commentStr) && Float.compare(this.grade, adGameGradeModule.grade) == 0;
        }
        return false;
    }

    public int hashCode() {
        return (((((BottomSheetItemData$.ExternalSyntheticBackport0.m(this.display) * 31) + (this.starNumberList == null ? 0 : this.starNumberList.hashCode())) * 31) + (this.commentStr != null ? this.commentStr.hashCode() : 0)) * 31) + Float.floatToIntBits(this.grade);
    }

    public String toString() {
        boolean z = this.display;
        List<Integer> list = this.starNumberList;
        String str = this.commentStr;
        return "AdGameGradeModule(display=" + z + ", starNumberList=" + list + ", commentStr=" + str + ", grade=" + this.grade + ")";
    }

    /* compiled from: AdAndroidGameInfo.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdGameGradeModule$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdGameGradeModule;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdGameGradeModule> serializer() {
            return AdGameGradeModule$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdGameGradeModule(int seen0, boolean display, List starNumberList, String commentStr, float grade, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.display = false;
        } else {
            this.display = display;
        }
        if ((seen0 & 2) == 0) {
            this.starNumberList = null;
        } else {
            this.starNumberList = starNumberList;
        }
        if ((seen0 & 4) == 0) {
            this.commentStr = null;
        } else {
            this.commentStr = commentStr;
        }
        if ((seen0 & 8) == 0) {
            this.grade = 0.0f;
        } else {
            this.grade = grade;
        }
    }

    public AdGameGradeModule(boolean display, List<Integer> list, String commentStr, float grade) {
        this.display = display;
        this.starNumberList = list;
        this.commentStr = commentStr;
        this.grade = grade;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(IntSerializer.INSTANCE);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$dto_debug(AdGameGradeModule self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.display) {
            output.encodeBooleanElement(serialDesc, 0, self.display);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.starNumberList != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, (SerializationStrategy) lazyArr[1].getValue(), self.starNumberList);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.commentStr != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.commentStr);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || Float.compare(self.grade, 0.0f) != 0) {
            output.encodeFloatElement(serialDesc, 3, self.grade);
        }
    }

    public /* synthetic */ AdGameGradeModule(boolean z, List list, String str, float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : str, (i & 8) != 0 ? 0.0f : f);
    }

    public final boolean getDisplay() {
        return this.display;
    }

    public final List<Integer> getStarNumberList() {
        return this.starNumberList;
    }

    public final String getCommentStr() {
        return this.commentStr;
    }

    public final float getGrade() {
        return this.grade;
    }
}
package kntr.app.deepsearch.base.model.biz;

import com.bilibili.blens.Lens;
import java.util.List;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeepSearchRetryChatModel.kt */
@Lens
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001d"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchTreadPopModel;", RoomRecommendViewModel.EMPTY_CURSOR, "title", RoomRecommendViewModel.EMPTY_CURSOR, "reasons", RoomRecommendViewModel.EMPTY_CURSOR, "maxCountWords", RoomRecommendViewModel.EMPTY_CURSOR, "inputPlaceholder", "<init>", "(Ljava/lang/String;Ljava/util/List;ILjava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getReasons", "()Ljava/util/List;", "getMaxCountWords", "()I", "getInputPlaceholder", "component1", "component2", "component3", "component4", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "Companion", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchTreadPopModel {
    public static final Companion Companion = new Companion(null);
    private final String inputPlaceholder;
    private final int maxCountWords;
    private final List<String> reasons;
    private final String title;

    public DeepSearchTreadPopModel() {
        this(null, null, 0, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DeepSearchTreadPopModel copy$default(DeepSearchTreadPopModel deepSearchTreadPopModel, String str, List list, int i, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = deepSearchTreadPopModel.title;
        }
        if ((i2 & 2) != 0) {
            list = deepSearchTreadPopModel.reasons;
        }
        if ((i2 & 4) != 0) {
            i = deepSearchTreadPopModel.maxCountWords;
        }
        if ((i2 & 8) != 0) {
            str2 = deepSearchTreadPopModel.inputPlaceholder;
        }
        return deepSearchTreadPopModel.copy(str, list, i, str2);
    }

    public final String component1() {
        return this.title;
    }

    public final List<String> component2() {
        return this.reasons;
    }

    public final int component3() {
        return this.maxCountWords;
    }

    public final String component4() {
        return this.inputPlaceholder;
    }

    public final DeepSearchTreadPopModel copy(String str, List<String> list, int i, String str2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(list, "reasons");
        Intrinsics.checkNotNullParameter(str2, "inputPlaceholder");
        return new DeepSearchTreadPopModel(str, list, i, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DeepSearchTreadPopModel) {
            DeepSearchTreadPopModel deepSearchTreadPopModel = (DeepSearchTreadPopModel) obj;
            return Intrinsics.areEqual(this.title, deepSearchTreadPopModel.title) && Intrinsics.areEqual(this.reasons, deepSearchTreadPopModel.reasons) && this.maxCountWords == deepSearchTreadPopModel.maxCountWords && Intrinsics.areEqual(this.inputPlaceholder, deepSearchTreadPopModel.inputPlaceholder);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.title.hashCode() * 31) + this.reasons.hashCode()) * 31) + this.maxCountWords) * 31) + this.inputPlaceholder.hashCode();
    }

    public String toString() {
        String str = this.title;
        List<String> list = this.reasons;
        int i = this.maxCountWords;
        return "DeepSearchTreadPopModel(title=" + str + ", reasons=" + list + ", maxCountWords=" + i + ", inputPlaceholder=" + this.inputPlaceholder + ")";
    }

    public DeepSearchTreadPopModel(String title, List<String> list, int maxCountWords, String inputPlaceholder) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(list, "reasons");
        Intrinsics.checkNotNullParameter(inputPlaceholder, "inputPlaceholder");
        this.title = title;
        this.reasons = list;
        this.maxCountWords = maxCountWords;
        this.inputPlaceholder = inputPlaceholder;
    }

    public /* synthetic */ DeepSearchTreadPopModel(String str, List list, int i, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i2 & 2) != 0 ? CollectionsKt.emptyList() : list, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str2);
    }

    public final String getTitle() {
        return this.title;
    }

    public final List<String> getReasons() {
        return this.reasons;
    }

    public final int getMaxCountWords() {
        return this.maxCountWords;
    }

    public final String getInputPlaceholder() {
        return this.inputPlaceholder;
    }

    /* compiled from: DeepSearchRetryChatModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchTreadPopModel$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
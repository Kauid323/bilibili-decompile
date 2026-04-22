package kntr.app.mall.mallDynamicPage.bean;

import java.util.List;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UIProtocol.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0007HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Lkntr/app/mall/mallDynamicPage/bean/UIProtocol;", RoomRecommendViewModel.EMPTY_CURSOR, "name", RoomRecommendViewModel.EMPTY_CURSOR, "options", "Lkntr/app/mall/mallDynamicPage/bean/Options;", "children", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;Lkntr/app/mall/mallDynamicPage/bean/Options;Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getOptions", "()Lkntr/app/mall/mallDynamicPage/bean/Options;", "setOptions", "(Lkntr/app/mall/mallDynamicPage/bean/Options;)V", "getChildren", "()Ljava/util/List;", "setChildren", "(Ljava/util/List;)V", "component1", "component2", "component3", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "mallDynamicPage_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UIProtocol {
    public static final int $stable = 8;
    private List<UIProtocol> children;
    private String name;
    private Options options;

    public UIProtocol() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UIProtocol copy$default(UIProtocol uIProtocol, String str, Options options, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = uIProtocol.name;
        }
        if ((i & 2) != 0) {
            options = uIProtocol.options;
        }
        if ((i & 4) != 0) {
            list = uIProtocol.children;
        }
        return uIProtocol.copy(str, options, list);
    }

    public final String component1() {
        return this.name;
    }

    public final Options component2() {
        return this.options;
    }

    public final List<UIProtocol> component3() {
        return this.children;
    }

    public final UIProtocol copy(String str, Options options, List<UIProtocol> list) {
        Intrinsics.checkNotNullParameter(str, "name");
        return new UIProtocol(str, options, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UIProtocol) {
            UIProtocol uIProtocol = (UIProtocol) obj;
            return Intrinsics.areEqual(this.name, uIProtocol.name) && Intrinsics.areEqual(this.options, uIProtocol.options) && Intrinsics.areEqual(this.children, uIProtocol.children);
        }
        return false;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + (this.options == null ? 0 : this.options.hashCode())) * 31) + (this.children != null ? this.children.hashCode() : 0);
    }

    public String toString() {
        String str = this.name;
        Options options = this.options;
        return "UIProtocol(name=" + str + ", options=" + options + ", children=" + this.children + ")";
    }

    public UIProtocol(String name, Options options, List<UIProtocol> list) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.options = options;
        this.children = list;
    }

    public /* synthetic */ UIProtocol(String str, Options options, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i & 2) != 0 ? null : options, (i & 4) != 0 ? null : list);
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final Options getOptions() {
        return this.options;
    }

    public final void setOptions(Options options) {
        this.options = options;
    }

    public final List<UIProtocol> getChildren() {
        return this.children;
    }

    public final void setChildren(List<UIProtocol> list) {
        this.children = list;
    }
}
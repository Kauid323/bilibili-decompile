package kntr.app.mall.mallDynamicPage.bean;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UIProtocol.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u001b"}, d2 = {"Lkntr/app/mall/mallDynamicPage/bean/Listener;", RoomRecommendViewModel.EMPTY_CURSOR, "click", "Lkntr/app/mall/mallDynamicPage/bean/Func;", "create", "destroy", "<init>", "(Lkntr/app/mall/mallDynamicPage/bean/Func;Lkntr/app/mall/mallDynamicPage/bean/Func;Lkntr/app/mall/mallDynamicPage/bean/Func;)V", "getClick", "()Lkntr/app/mall/mallDynamicPage/bean/Func;", "setClick", "(Lkntr/app/mall/mallDynamicPage/bean/Func;)V", "getCreate", "setCreate", "getDestroy", "setDestroy", "component1", "component2", "component3", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "mallDynamicPage_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Listener {
    public static final int $stable = 8;
    private Func click;
    private Func create;
    private Func destroy;

    public Listener() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ Listener copy$default(Listener listener, Func func, Func func2, Func func3, int i, Object obj) {
        if ((i & 1) != 0) {
            func = listener.click;
        }
        if ((i & 2) != 0) {
            func2 = listener.create;
        }
        if ((i & 4) != 0) {
            func3 = listener.destroy;
        }
        return listener.copy(func, func2, func3);
    }

    public final Func component1() {
        return this.click;
    }

    public final Func component2() {
        return this.create;
    }

    public final Func component3() {
        return this.destroy;
    }

    public final Listener copy(Func func, Func func2, Func func3) {
        return new Listener(func, func2, func3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Listener) {
            Listener listener = (Listener) obj;
            return Intrinsics.areEqual(this.click, listener.click) && Intrinsics.areEqual(this.create, listener.create) && Intrinsics.areEqual(this.destroy, listener.destroy);
        }
        return false;
    }

    public int hashCode() {
        return ((((this.click == null ? 0 : this.click.hashCode()) * 31) + (this.create == null ? 0 : this.create.hashCode())) * 31) + (this.destroy != null ? this.destroy.hashCode() : 0);
    }

    public String toString() {
        Func func = this.click;
        Func func2 = this.create;
        return "Listener(click=" + func + ", create=" + func2 + ", destroy=" + this.destroy + ")";
    }

    public Listener(Func click, Func create, Func destroy) {
        this.click = click;
        this.create = create;
        this.destroy = destroy;
    }

    public /* synthetic */ Listener(Func func, Func func2, Func func3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : func, (i & 2) != 0 ? null : func2, (i & 4) != 0 ? null : func3);
    }

    public final Func getClick() {
        return this.click;
    }

    public final void setClick(Func func) {
        this.click = func;
    }

    public final Func getCreate() {
        return this.create;
    }

    public final void setCreate(Func func) {
        this.create = func;
    }

    public final Func getDestroy() {
        return this.destroy;
    }

    public final void setDestroy(Func func) {
        this.destroy = func;
    }
}
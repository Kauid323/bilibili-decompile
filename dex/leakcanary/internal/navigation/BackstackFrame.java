package leakcanary.internal.navigation;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BackstackFrame.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u0017\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\tJ\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0010H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lleakcanary/internal/navigation/BackstackFrame;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "screen", "Lleakcanary/internal/navigation/Screen;", "(Lleakcanary/internal/navigation/Screen;)V", "view", "Landroid/view/View;", "(Lleakcanary/internal/navigation/Screen;Landroid/view/View;)V", "getScreen", "()Lleakcanary/internal/navigation/Screen;", "viewState", "Landroid/util/SparseArray;", "describeContents", "", "restore", "", "writeToParcel", "dest", "flags", "Companion", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class BackstackFrame implements Parcelable {
    private final Screen screen;
    private final SparseArray<Parcelable> viewState;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<BackstackFrame> CREATOR = new Parcelable.Creator<BackstackFrame>() { // from class: leakcanary.internal.navigation.BackstackFrame$Companion$CREATOR$1
        @Override // android.os.Parcelable.Creator
        public BackstackFrame createFromParcel(Parcel source) {
            Intrinsics.checkParameterIsNotNull(source, "source");
            return new BackstackFrame(source, (DefaultConstructorMarker) null);
        }

        @Override // android.os.Parcelable.Creator
        public BackstackFrame[] newArray(int size) {
            return new BackstackFrame[size];
        }
    };

    public /* synthetic */ BackstackFrame(Parcel source, DefaultConstructorMarker $constructor_marker) {
        this(source);
    }

    public final Screen getScreen() {
        return this.screen;
    }

    private BackstackFrame(Parcel source) {
        Serializable readSerializable = source.readSerializable();
        if (readSerializable == null) {
            throw new TypeCastException("null cannot be cast to non-null type leakcanary.internal.navigation.Screen");
        }
        this.screen = (Screen) readSerializable;
        this.viewState = source.readSparseArray(getClass().getClassLoader());
    }

    public BackstackFrame(Screen screen) {
        Intrinsics.checkParameterIsNotNull(screen, "screen");
        this.screen = screen;
        this.viewState = null;
    }

    public BackstackFrame(Screen screen, View view) {
        Intrinsics.checkParameterIsNotNull(screen, "screen");
        Intrinsics.checkParameterIsNotNull(view, "view");
        this.screen = screen;
        this.viewState = new SparseArray<>();
        view.saveHierarchyState(this.viewState);
    }

    public final void restore(View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        if (this.viewState != null) {
            view.restoreHierarchyState(this.viewState);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkParameterIsNotNull(dest, "dest");
        dest.writeSerializable(this.screen);
        dest.writeSparseArray(this.viewState);
    }

    /* compiled from: BackstackFrame.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0002¨\u0006\u0007"}, d2 = {"Lleakcanary/internal/navigation/BackstackFrame$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lleakcanary/internal/navigation/BackstackFrame;", "getCREATOR$annotations", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public static /* synthetic */ void getCREATOR$annotations() {
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}
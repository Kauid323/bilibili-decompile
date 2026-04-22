package leakcanary.internal.navigation;

import android.view.View;
import android.view.ViewGroup;
import java.io.Serializable;
import kotlin.Metadata;

/* compiled from: Screen.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lleakcanary/internal/navigation/Screen;", "Ljava/io/Serializable;", "()V", "createView", "Landroid/view/View;", "container", "Landroid/view/ViewGroup;", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public abstract class Screen implements Serializable {
    public abstract View createView(ViewGroup viewGroup);
}
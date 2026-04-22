package leakcanary.internal.activity.screen;

import android.view.View;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import leakcanary.internal.activity.db.Io;

/* compiled from: HprofExplorerScreen.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"leakcanary/internal/activity/screen/HprofExplorerScreen$createView$1$1", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", "view", "Landroid/view/View;", "onViewDetachedFromWindow", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class HprofExplorerScreen$createView$1$1 implements View.OnAttachStateChangeListener {
    final /* synthetic */ Ref.ObjectRef $closeable;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HprofExplorerScreen$createView$1$1(Ref.ObjectRef $captured_local_variable$0) {
        this.$closeable = $captured_local_variable$0;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        Io.INSTANCE.execute(new Function0<Unit>() { // from class: leakcanary.internal.activity.screen.HprofExplorerScreen$createView$1$1$onViewDetachedFromWindow$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Closeable closeable = (Closeable) HprofExplorerScreen$createView$1$1.this.$closeable.element;
                if (closeable != null) {
                    closeable.close();
                }
            }
        });
    }
}
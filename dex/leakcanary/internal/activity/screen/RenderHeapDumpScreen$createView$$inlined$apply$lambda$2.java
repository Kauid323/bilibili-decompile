package leakcanary.internal.activity.screen;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import leakcanary.internal.activity.db.Io;
import leakcanary.internal.activity.db.IoKt;

/* compiled from: RenderHeapDumpScreen.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"leakcanary/internal/activity/screen/RenderHeapDumpScreen$createView$1$2", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class RenderHeapDumpScreen$createView$$inlined$apply$lambda$2 implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ ViewGroup $container$inlined;
    final /* synthetic */ ImageView $imageView;
    final /* synthetic */ View $loadingView;
    final /* synthetic */ View $this_apply;
    final /* synthetic */ RenderHeapDumpScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RenderHeapDumpScreen$createView$$inlined$apply$lambda$2(View $receiver, ImageView $captured_local_variable$2, View $captured_local_variable$3, RenderHeapDumpScreen renderHeapDumpScreen, ViewGroup viewGroup) {
        this.$this_apply = $receiver;
        this.$imageView = $captured_local_variable$2;
        this.$loadingView = $captured_local_variable$3;
        this.this$0 = renderHeapDumpScreen;
        this.$container$inlined = viewGroup;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        IoKt.executeOnIo(this.$this_apply, new Function1<Io.OnIo, Unit>() { // from class: leakcanary.internal.activity.screen.RenderHeapDumpScreen$createView$$inlined$apply$lambda$2.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Io.OnIo onIo) {
                invoke2(onIo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Io.OnIo receiver) {
                File file;
                Intrinsics.checkParameterIsNotNull(receiver, "$receiver");
                HeapDumpRenderer heapDumpRenderer = HeapDumpRenderer.INSTANCE;
                Context context = RenderHeapDumpScreen$createView$$inlined$apply$lambda$2.this.$this_apply.getContext();
                Intrinsics.checkExpressionValueIsNotNull(context, "context");
                file = RenderHeapDumpScreen$createView$$inlined$apply$lambda$2.this.this$0.heapDumpFile;
                final Bitmap bitmap = heapDumpRenderer.render(context, file, RenderHeapDumpScreen$createView$$inlined$apply$lambda$2.this.$this_apply.getMeasuredWidth(), RenderHeapDumpScreen$createView$$inlined$apply$lambda$2.this.$this_apply.getMeasuredHeight(), 0);
                receiver.updateUi(new Function1<View, Unit>() { // from class: leakcanary.internal.activity.screen.RenderHeapDumpScreen$createView$.inlined.apply.lambda.2.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(View receiver2) {
                        Intrinsics.checkParameterIsNotNull(receiver2, "$receiver");
                        RenderHeapDumpScreen$createView$$inlined$apply$lambda$2.this.$imageView.setImageBitmap(bitmap);
                        View loadingView = RenderHeapDumpScreen$createView$$inlined$apply$lambda$2.this.$loadingView;
                        Intrinsics.checkExpressionValueIsNotNull(loadingView, "loadingView");
                        loadingView.setVisibility(8);
                        ImageView imageView = RenderHeapDumpScreen$createView$$inlined$apply$lambda$2.this.$imageView;
                        Intrinsics.checkExpressionValueIsNotNull(imageView, "imageView");
                        imageView.setVisibility(0);
                    }
                });
            }
        });
        this.$this_apply.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
}
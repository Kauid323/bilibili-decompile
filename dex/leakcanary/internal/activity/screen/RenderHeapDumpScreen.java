package leakcanary.internal.activity.screen;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.squareup.leakcanary.core.R;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import leakcanary.internal.activity.db.Io;
import leakcanary.internal.activity.db.IoKt;
import leakcanary.internal.navigation.Screen;
import leakcanary.internal.navigation.ViewsKt;
import leakcanary.internal.utils.SizeKt;

/* compiled from: RenderHeapDumpScreen.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lleakcanary/internal/activity/screen/RenderHeapDumpScreen;", "Lleakcanary/internal/navigation/Screen;", "heapDumpFile", "Ljava/io/File;", "(Ljava/io/File;)V", "createView", "Landroid/view/View;", "container", "Landroid/view/ViewGroup;", "savePng", "", "imageFile", "source", "Landroid/graphics/Bitmap;", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class RenderHeapDumpScreen extends Screen {
    private final File heapDumpFile;

    public RenderHeapDumpScreen(File heapDumpFile) {
        Intrinsics.checkParameterIsNotNull(heapDumpFile, "heapDumpFile");
        this.heapDumpFile = heapDumpFile;
    }

    @Override // leakcanary.internal.navigation.Screen
    public View createView(final ViewGroup container) {
        Intrinsics.checkParameterIsNotNull(container, "container");
        View $this$apply = ViewsKt.inflate(container, R.layout.leak_canary_heap_render);
        ViewsKt.getActivity(container).setTitle($this$apply.getResources().getString(R.string.leak_canary_loading_title));
        IoKt.executeOnIo($this$apply, new Function1<Io.OnIo, Unit>() { // from class: leakcanary.internal.activity.screen.RenderHeapDumpScreen$createView$$inlined$apply$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                file = RenderHeapDumpScreen.this.heapDumpFile;
                final String byteCount = SizeKt.humanReadableByteCount(file.length(), true);
                receiver.updateUi(new Function1<View, Unit>() { // from class: leakcanary.internal.activity.screen.RenderHeapDumpScreen$createView$$inlined$apply$lambda$1.1
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
                        ViewsKt.getActivity(container).setTitle(receiver2.getResources().getString(R.string.leak_canary_heap_dump_screen_title, byteCount));
                    }
                });
            }
        });
        View loadingView = $this$apply.findViewById(R.id.leak_canary_loading);
        ImageView imageView = (ImageView) $this$apply.findViewById(R.id.leak_canary_heap_rendering);
        $this$apply.getViewTreeObserver().addOnGlobalLayoutListener(new RenderHeapDumpScreen$createView$$inlined$apply$lambda$2($this$apply, imageView, loadingView, this, container));
        ViewsKt.onCreateOptionsMenu($this$apply, new RenderHeapDumpScreen$createView$$inlined$apply$lambda$3($this$apply, this, container));
        return $this$apply;
    }

    public final boolean savePng(File imageFile, Bitmap source) {
        Intrinsics.checkParameterIsNotNull(imageFile, "imageFile");
        Intrinsics.checkParameterIsNotNull(source, "source");
        FileOutputStream outStream = null;
        try {
            outStream = new FileOutputStream(imageFile);
            source.compress(Bitmap.CompressFormat.PNG, 100, outStream);
            outStream.close();
            return true;
        } catch (IOException e) {
            if (outStream != null) {
                outStream.close();
            }
            return false;
        } catch (Throwable th) {
            if (outStream != null) {
                outStream.close();
            }
            throw th;
        }
    }
}
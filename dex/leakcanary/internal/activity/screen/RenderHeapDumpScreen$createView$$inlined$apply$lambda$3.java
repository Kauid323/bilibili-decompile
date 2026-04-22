package leakcanary.internal.activity.screen;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.squareup.leakcanary.core.R;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import leakcanary.internal.InternalLeakCanary;
import leakcanary.internal.LeakCanaryFileProvider;
import leakcanary.internal.LeakDirectoryProvider;
import leakcanary.internal.activity.db.Io;
import leakcanary.internal.activity.db.IoKt;
import leakcanary.internal.navigation.ViewsKt;
import shark.SharkLog;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RenderHeapDumpScreen.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "menu", "Landroid/view/Menu;", "invoke", "leakcanary/internal/activity/screen/RenderHeapDumpScreen$createView$1$3"}, k = 3, mv = {1, 4, 1})
public final class RenderHeapDumpScreen$createView$$inlined$apply$lambda$3 extends Lambda implements Function1<Menu, Unit> {
    final /* synthetic */ ViewGroup $container$inlined;
    final /* synthetic */ View $this_apply;
    final /* synthetic */ RenderHeapDumpScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RenderHeapDumpScreen$createView$$inlined$apply$lambda$3(View view, RenderHeapDumpScreen renderHeapDumpScreen, ViewGroup viewGroup) {
        super(1);
        this.$this_apply = view;
        this.this$0 = renderHeapDumpScreen;
        this.$container$inlined = viewGroup;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Menu menu) {
        invoke2(menu);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Menu menu) {
        Intrinsics.checkParameterIsNotNull(menu, "menu");
        menu.add(R.string.leak_canary_options_menu_generate_hq_bitmap).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: leakcanary.internal.activity.screen.RenderHeapDumpScreen$createView$$inlined$apply$lambda$3.1
            @Override // android.view.MenuItem.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem it) {
                Intrinsics.checkParameterIsNotNull(it, "it");
                InternalLeakCanary internalLeakCanary = InternalLeakCanary.INSTANCE;
                Context context = RenderHeapDumpScreen$createView$$inlined$apply$lambda$3.this.$this_apply.getContext();
                Intrinsics.checkExpressionValueIsNotNull(context, "context");
                LeakDirectoryProvider leakDirectoryProvider = internalLeakCanary.createLeakDirectoryProvider(context);
                if (!leakDirectoryProvider.hasStoragePermission()) {
                    Toast.makeText(RenderHeapDumpScreen$createView$$inlined$apply$lambda$3.this.$this_apply.getContext(), R.string.leak_canary_options_menu_permission_toast, 1).show();
                    leakDirectoryProvider.requestWritePermissionNotification();
                } else {
                    Toast.makeText(RenderHeapDumpScreen$createView$$inlined$apply$lambda$3.this.$this_apply.getContext(), R.string.leak_canary_generating_hq_bitmap_toast_notice, 1).show();
                    IoKt.executeOnIo(RenderHeapDumpScreen$createView$$inlined$apply$lambda$3.this.$this_apply, new Function1<Io.OnIo, Unit>() { // from class: leakcanary.internal.activity.screen.RenderHeapDumpScreen$createView$.inlined.apply.lambda.3.1.1
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
                            File file2;
                            Intrinsics.checkParameterIsNotNull(receiver, "$receiver");
                            HeapDumpRenderer heapDumpRenderer = HeapDumpRenderer.INSTANCE;
                            Context context2 = RenderHeapDumpScreen$createView$$inlined$apply$lambda$3.this.$this_apply.getContext();
                            Intrinsics.checkExpressionValueIsNotNull(context2, "context");
                            file = RenderHeapDumpScreen$createView$$inlined$apply$lambda$3.this.this$0.heapDumpFile;
                            Bitmap bitmap = heapDumpRenderer.render(context2, file, 2048, 0, 4);
                            File storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                            StringBuilder sb = new StringBuilder();
                            file2 = RenderHeapDumpScreen$createView$$inlined$apply$lambda$3.this.this$0.heapDumpFile;
                            File imageFile = new File(storageDir, sb.append(file2.getName()).append(".png").toString());
                            boolean saved = RenderHeapDumpScreen$createView$$inlined$apply$lambda$3.this.this$0.savePng(imageFile, bitmap);
                            if (saved) {
                                SharkLog this_$iv = SharkLog.INSTANCE;
                                SharkLog.Logger logger$iv = this_$iv.getLogger();
                                if (logger$iv != null) {
                                    logger$iv.d("Png saved at " + imageFile);
                                }
                                imageFile.setReadable(true, false);
                                final Uri imageUri = LeakCanaryFileProvider.Companion.getUriForFile(ViewsKt.getActivity(RenderHeapDumpScreen$createView$$inlined$apply$lambda$3.this.$this_apply), "com.squareup.leakcanary.fileprovider." + ViewsKt.getActivity(RenderHeapDumpScreen$createView$$inlined$apply$lambda$3.this.$this_apply).getPackageName(), imageFile);
                                receiver.updateUi(new Function1<View, Unit>() { // from class: leakcanary.internal.activity.screen.RenderHeapDumpScreen$createView$.inlined.apply.lambda.3.1.1.1
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
                                        Intent intent = new Intent("android.intent.action.SEND");
                                        intent.setType("image/png");
                                        intent.putExtra("android.intent.extra.STREAM", imageUri);
                                        ViewsKt.getActivity(receiver2).startActivity(Intent.createChooser(intent, receiver2.getResources().getString(R.string.leak_canary_share_heap_dump_bitmap_screen_title)));
                                    }
                                });
                                return;
                            }
                            receiver.updateUi(new Function1<View, Unit>() { // from class: leakcanary.internal.activity.screen.RenderHeapDumpScreen$createView$1$3$1$1$3
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                                    invoke2(view);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                public final void invoke2(View receiver2) {
                                    Intrinsics.checkParameterIsNotNull(receiver2, "$receiver");
                                    Toast.makeText(receiver2.getContext(), R.string.leak_canary_generating_hq_bitmap_toast_failure_notice, 1).show();
                                }
                            });
                        }
                    });
                }
                return true;
            }
        });
    }
}
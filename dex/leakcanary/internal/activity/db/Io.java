package leakcanary.internal.activity.db;

import android.view.View;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import leakcanary.internal.HandlersKt;
import leakcanary.internal.activity.db.Io;
import leakcanary.internal.navigation.ViewsKt;

/* compiled from: Io.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001:\u0003\u000f\u0010\u0011B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tJ'\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00070\f¢\u0006\u0002\b\u000eR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lleakcanary/internal/activity/db/Io;", "", "()V", "serialExecutor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "execute", "", "block", "Lkotlin/Function0;", "view", "Landroid/view/View;", "Lkotlin/Function1;", "Lleakcanary/internal/activity/db/Io$OnIo;", "Lkotlin/ExtensionFunctionType;", "IoContext", "OnIo", "VolatileObjectRef", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class Io {
    public static final Io INSTANCE = new Io();
    private static final ExecutorService serialExecutor = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: leakcanary.internal.activity.db.Io$serialExecutor$1
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "LeakCanary-Activity-DB");
        }
    });

    /* compiled from: Io.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\u00020\u00032\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00030\u0004¢\u0006\u0002\b\u0006H&¨\u0006\u0007"}, d2 = {"Lleakcanary/internal/activity/db/Io$OnIo;", "", "updateUi", "", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ExtensionFunctionType;", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public interface OnIo {
        void updateUi(Function1<? super View, Unit> function1);
    }

    private Io() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Io.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J!\u0010\u0003\u001a\u00020\u00062\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0016R-\u0010\u0003\u001a\u0015\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0002\b\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lleakcanary/internal/activity/db/Io$IoContext;", "Lleakcanary/internal/activity/db/Io$OnIo;", "()V", "updateUi", "Lkotlin/Function1;", "Landroid/view/View;", "", "Lkotlin/ExtensionFunctionType;", "getUpdateUi", "()Lkotlin/jvm/functions/Function1;", "setUpdateUi", "(Lkotlin/jvm/functions/Function1;)V", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class IoContext implements OnIo {
        private Function1<? super View, Unit> updateUi;

        public final Function1<View, Unit> getUpdateUi() {
            return this.updateUi;
        }

        public final void setUpdateUi(Function1<? super View, Unit> function1) {
            this.updateUi = function1;
        }

        @Override // leakcanary.internal.activity.db.Io.OnIo
        public void updateUi(Function1<? super View, Unit> updateUi) {
            Intrinsics.checkParameterIsNotNull(updateUi, "updateUi");
            this.updateUi = updateUi;
        }
    }

    public final void execute(final Function0<Unit> block) {
        Intrinsics.checkParameterIsNotNull(block, "block");
        serialExecutor.execute(new Runnable() { // from class: leakcanary.internal.activity.db.IoKt$sam$java_lang_Runnable$0
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                Intrinsics.checkExpressionValueIsNotNull(Function0.this.invoke(), "invoke(...)");
            }
        });
    }

    public final void execute(View view, final Function1<? super OnIo, Unit> block) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        Intrinsics.checkParameterIsNotNull(block, "block");
        HandlersKt.checkMainThread();
        final VolatileObjectRef viewWrapper = new VolatileObjectRef(view);
        ViewsKt.onScreenExiting(view, new Function0<Unit>() { // from class: leakcanary.internal.activity.db.Io$execute$1
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
                Io.VolatileObjectRef.this.setElement(null);
            }
        });
        serialExecutor.execute(new Runnable() { // from class: leakcanary.internal.activity.db.Io$execute$2
            @Override // java.lang.Runnable
            /* renamed from: invoke */
            public final void run() {
                if (Io.VolatileObjectRef.this.getElement() == null) {
                    return;
                }
                Io.IoContext context = new Io.IoContext();
                block.invoke(context);
                final Function1 updateUi = context.getUpdateUi();
                if (Io.VolatileObjectRef.this.getElement() != null && updateUi != null) {
                    HandlersKt.getMainHandler().post(new Runnable() { // from class: leakcanary.internal.activity.db.Io$execute$2.1
                        @Override // java.lang.Runnable
                        /* renamed from: invoke */
                        public final void run() {
                            View attachedView = (View) Io.VolatileObjectRef.this.getElement();
                            if (attachedView == null) {
                                return;
                            }
                            updateUi.invoke(attachedView);
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Io.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0004R\u001e\u0010\u0003\u001a\u0004\u0018\u00018\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\b\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\t"}, d2 = {"Lleakcanary/internal/activity/db/Io$VolatileObjectRef;", "T", "", "element", "(Ljava/lang/Object;)V", "getElement", "()Ljava/lang/Object;", "setElement", "Ljava/lang/Object;", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class VolatileObjectRef<T> {
        private volatile T element;

        public VolatileObjectRef() {
            this(null, 1, null);
        }

        public VolatileObjectRef(T t) {
            this.element = t;
        }

        public /* synthetic */ VolatileObjectRef(Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : obj);
        }

        public final T getElement() {
            return this.element;
        }

        public final void setElement(T t) {
            this.element = t;
        }
    }
}
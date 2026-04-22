package leakcanary.internal.navigation;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import com.bilibili.lib.spy.generated.android_app_Activity;
import com.squareup.leakcanary.core.R;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NavigatingActivity.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\b \u0018\u0000 .2\u00020\u0001:\u0001.B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\nH\u0016J\u0006\u0010\u0016\u001a\u00020\u0010J\u000e\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\nJ\u0018\u0010\u0019\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\u001c\u001a\u00020\u0010H\u0016J\u0010\u0010\r\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000fH\u0016J\b\u0010\u001f\u001a\u00020\u0010H\u0014J\u0010\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\"H\u0014J\u0010\u0010#\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\nH\u0014J\u0010\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u001bH\u0016J\u0016\u0010)\u001a\b\u0012\u0004\u0012\u00020\n0*2\u0006\u0010!\u001a\u00020\"H&J\u0006\u0010+\u001a\u00020\u0010J\u000e\u0010,\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\nJ\b\u0010-\u001a\u00020\u0010H\u0002R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R&\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006/"}, d2 = {"Lleakcanary/internal/navigation/NavigatingActivity;", "Landroid/app/Activity;", "()V", "backstack", "Ljava/util/ArrayList;", "Lleakcanary/internal/navigation/BackstackFrame;", "Lkotlin/collections/ArrayList;", "container", "Landroid/view/ViewGroup;", "currentScreen", "Lleakcanary/internal/navigation/Screen;", "currentView", "Landroid/view/View;", "onCreateOptionsMenu", "Lkotlin/Function1;", "Landroid/view/Menu;", "", "getOnCreateOptionsMenu", "()Lkotlin/jvm/functions/Function1;", "setOnCreateOptionsMenu", "(Lkotlin/jvm/functions/Function1;)V", "getLauncherScreen", "goBack", "goTo", "screen", "installNavigation", "savedInstanceState", "Landroid/os/Bundle;", "onBackPressed", "", "menu", "onDestroy", "onNewIntent", "intent", "Landroid/content/Intent;", "onNewScreen", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onSaveInstanceState", "outState", "parseIntentScreens", "", "refreshCurrentScreen", "resetTo", "screenUpdated", "Companion", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public abstract class NavigatingActivity extends android_app_Activity {
    public static final Companion Companion = new Companion(null);
    private static final Function1<Menu, Unit> NO_MENU = new Function1<Menu, Unit>() { // from class: leakcanary.internal.navigation.NavigatingActivity$Companion$NO_MENU$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Menu menu) {
            invoke2(menu);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Menu it) {
            Intrinsics.checkParameterIsNotNull(it, "it");
        }
    };
    private ArrayList<BackstackFrame> backstack;
    private ViewGroup container;
    private Screen currentScreen;
    private View currentView;
    private Function1<? super Menu, Unit> onCreateOptionsMenu = NO_MENU;

    public abstract List<Screen> parseIntentScreens(Intent intent);

    public final Function1<Menu, Unit> getOnCreateOptionsMenu() {
        return this.onCreateOptionsMenu;
    }

    public final void setOnCreateOptionsMenu(Function1<? super Menu, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "<set-?>");
        this.onCreateOptionsMenu = function1;
    }

    public final void installNavigation(Bundle savedInstanceState, ViewGroup container) {
        Screen launcherScreen;
        Intrinsics.checkParameterIsNotNull(container, "container");
        this.container = container;
        if (savedInstanceState == null) {
            this.backstack = new ArrayList<>();
            Intent intent = getIntent();
            Intrinsics.checkExpressionValueIsNotNull(intent, "intent");
            List screens = parseIntentScreens(intent);
            if (!screens.isEmpty()) {
                Iterable $this$forEach$iv = CollectionsKt.dropLast(screens, 1);
                for (Object element$iv : $this$forEach$iv) {
                    Screen screen = (Screen) element$iv;
                    ArrayList<BackstackFrame> arrayList = this.backstack;
                    if (arrayList == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("backstack");
                    }
                    arrayList.add(new BackstackFrame(screen));
                }
                launcherScreen = (Screen) CollectionsKt.last((List<? extends Object>) screens);
            } else {
                launcherScreen = getLauncherScreen();
            }
            this.currentScreen = launcherScreen;
        } else {
            Serializable serializable = savedInstanceState.getSerializable("currentScreen");
            if (serializable == null) {
                throw new TypeCastException("null cannot be cast to non-null type leakcanary.internal.navigation.Screen");
            }
            this.currentScreen = (Screen) serializable;
            ArrayList<BackstackFrame> parcelableArrayList = savedInstanceState.getParcelableArrayList("backstack");
            if (parcelableArrayList == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.ArrayList<leakcanary.internal.navigation.BackstackFrame> /* = java.util.ArrayList<leakcanary.internal.navigation.BackstackFrame> */");
            }
            this.backstack = parcelableArrayList;
        }
        Screen screen2 = this.currentScreen;
        if (screen2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentScreen");
        }
        this.currentView = screen2.createView(container);
        View view = this.currentView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentView");
        }
        container.addView(view);
        ActionBar $this$run = getActionBar();
        if ($this$run != null) {
            $this$run.setHomeButtonEnabled(true);
            $this$run.setDisplayHomeAsUpEnabled(true);
        }
        screenUpdated();
    }

    protected void onNewIntent(Intent intent) {
        Intrinsics.checkParameterIsNotNull(intent, "intent");
        List screens = parseIntentScreens(intent);
        if (!screens.isEmpty()) {
            ArrayList<BackstackFrame> arrayList = this.backstack;
            if (arrayList == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backstack");
            }
            arrayList.clear();
            Iterable $this$forEach$iv = CollectionsKt.dropLast(screens, 1);
            for (Object element$iv : $this$forEach$iv) {
                Screen screen = (Screen) element$iv;
                ArrayList<BackstackFrame> arrayList2 = this.backstack;
                if (arrayList2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("backstack");
                }
                arrayList2.add(new BackstackFrame(screen));
            }
            goTo((Screen) CollectionsKt.last((List<? extends Object>) screens));
        }
    }

    public Screen getLauncherScreen() {
        throw new NotImplementedError("An operation is not implemented: Launcher activities should override getLauncherScreen()");
    }

    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkParameterIsNotNull(outState, "outState");
        super.onSaveInstanceState(outState);
        Screen screen = this.currentScreen;
        if (screen == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentScreen");
        }
        outState.putSerializable("currentScreen", screen);
        ArrayList<BackstackFrame> arrayList = this.backstack;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backstack");
        }
        outState.putParcelableArrayList("backstack", arrayList);
    }

    public void onBackPressed() {
        ArrayList<BackstackFrame> arrayList = this.backstack;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backstack");
        }
        if (arrayList.size() > 0) {
            goBack();
        } else {
            super.onBackPressed();
        }
    }

    public final void resetTo(Screen screen) {
        Intrinsics.checkParameterIsNotNull(screen, "screen");
        this.onCreateOptionsMenu = NO_MENU;
        View view = this.currentView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentView");
        }
        view.startAnimation(AnimationUtils.loadAnimation((Context) this, R.anim.leak_canary_exit_alpha));
        ViewGroup viewGroup = this.container;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("container");
        }
        View view2 = this.currentView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentView");
        }
        viewGroup.removeView(view2);
        View view3 = this.currentView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentView");
        }
        ViewsKt.notifyScreenExiting(view3);
        ArrayList<BackstackFrame> arrayList = this.backstack;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backstack");
        }
        arrayList.clear();
        this.currentScreen = screen;
        Screen screen2 = this.currentScreen;
        if (screen2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentScreen");
        }
        ViewGroup viewGroup2 = this.container;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("container");
        }
        this.currentView = screen2.createView(viewGroup2);
        View view4 = this.currentView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentView");
        }
        view4.startAnimation(AnimationUtils.loadAnimation((Context) this, R.anim.leak_canary_enter_alpha));
        ViewGroup viewGroup3 = this.container;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("container");
        }
        View view5 = this.currentView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentView");
        }
        viewGroup3.addView(view5);
        screenUpdated();
    }

    public final void goTo(Screen screen) {
        Intrinsics.checkParameterIsNotNull(screen, "screen");
        this.onCreateOptionsMenu = NO_MENU;
        View view = this.currentView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentView");
        }
        view.startAnimation(AnimationUtils.loadAnimation((Context) this, R.anim.leak_canary_exit_forward));
        ViewGroup viewGroup = this.container;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("container");
        }
        View view2 = this.currentView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentView");
        }
        viewGroup.removeView(view2);
        View view3 = this.currentView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentView");
        }
        ViewsKt.notifyScreenExiting(view3);
        Screen screen2 = this.currentScreen;
        if (screen2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentScreen");
        }
        View view4 = this.currentView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentView");
        }
        BackstackFrame backstackFrame = new BackstackFrame(screen2, view4);
        ArrayList<BackstackFrame> arrayList = this.backstack;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backstack");
        }
        arrayList.add(backstackFrame);
        this.currentScreen = screen;
        Screen screen3 = this.currentScreen;
        if (screen3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentScreen");
        }
        ViewGroup viewGroup2 = this.container;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("container");
        }
        this.currentView = screen3.createView(viewGroup2);
        View view5 = this.currentView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentView");
        }
        view5.startAnimation(AnimationUtils.loadAnimation((Context) this, R.anim.leak_canary_enter_forward));
        ViewGroup viewGroup3 = this.container;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("container");
        }
        View view6 = this.currentView;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentView");
        }
        viewGroup3.addView(view6);
        screenUpdated();
    }

    public final void refreshCurrentScreen() {
        this.onCreateOptionsMenu = NO_MENU;
        ViewGroup viewGroup = this.container;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("container");
        }
        View view = this.currentView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentView");
        }
        viewGroup.removeView(view);
        View view2 = this.currentView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentView");
        }
        ViewsKt.notifyScreenExiting(view2);
        Screen screen = this.currentScreen;
        if (screen == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentScreen");
        }
        ViewGroup viewGroup2 = this.container;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("container");
        }
        this.currentView = screen.createView(viewGroup2);
        ViewGroup viewGroup3 = this.container;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("container");
        }
        View view3 = this.currentView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentView");
        }
        viewGroup3.addView(view3);
        screenUpdated();
    }

    public final void goBack() {
        this.onCreateOptionsMenu = NO_MENU;
        View view = this.currentView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentView");
        }
        view.startAnimation(AnimationUtils.loadAnimation((Context) this, R.anim.leak_canary_exit_backward));
        ViewGroup viewGroup = this.container;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("container");
        }
        View view2 = this.currentView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentView");
        }
        viewGroup.removeView(view2);
        View view3 = this.currentView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentView");
        }
        ViewsKt.notifyScreenExiting(view3);
        ArrayList<BackstackFrame> arrayList = this.backstack;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backstack");
        }
        ArrayList<BackstackFrame> arrayList2 = this.backstack;
        if (arrayList2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backstack");
        }
        BackstackFrame remove = arrayList.remove(arrayList2.size() - 1);
        Intrinsics.checkExpressionValueIsNotNull(remove, "backstack.removeAt(backstack.size - 1)");
        BackstackFrame latest = remove;
        this.currentScreen = latest.getScreen();
        Screen screen = this.currentScreen;
        if (screen == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentScreen");
        }
        ViewGroup viewGroup2 = this.container;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("container");
        }
        this.currentView = screen.createView(viewGroup2);
        View view4 = this.currentView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentView");
        }
        view4.startAnimation(AnimationUtils.loadAnimation((Context) this, R.anim.leak_canary_enter_backward));
        ViewGroup viewGroup3 = this.container;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("container");
        }
        View view5 = this.currentView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentView");
        }
        viewGroup3.addView(view5, 0);
        View view6 = this.currentView;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentView");
        }
        latest.restore(view6);
        screenUpdated();
    }

    private final void screenUpdated() {
        invalidateOptionsMenu();
        ActionBar $this$run = getActionBar();
        if ($this$run != null) {
            ArrayList<BackstackFrame> arrayList = this.backstack;
            if (arrayList == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backstack");
            }
            boolean goBack = arrayList.size() > 0;
            int indicator = goBack ? 0 : 17301560;
            $this$run.setHomeAsUpIndicator(indicator);
        }
        Screen screen = this.currentScreen;
        if (screen == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentScreen");
        }
        onNewScreen(screen);
    }

    protected void onNewScreen(Screen screen) {
        Intrinsics.checkParameterIsNotNull(screen, "screen");
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        Intrinsics.checkParameterIsNotNull(menu, "menu");
        this.onCreateOptionsMenu.invoke(menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intrinsics.checkParameterIsNotNull(item, "item");
        switch (item.getItemId()) {
            case 16908332:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        View view = this.currentView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentView");
        }
        ViewsKt.notifyScreenExiting(view);
    }

    /* compiled from: NavigatingActivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lleakcanary/internal/navigation/NavigatingActivity$Companion;", "", "()V", "NO_MENU", "Lkotlin/Function1;", "Landroid/view/Menu;", "", "getNO_MENU", "()Lkotlin/jvm/functions/Function1;", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public final Function1<Menu, Unit> getNO_MENU() {
            return NavigatingActivity.NO_MENU;
        }
    }
}
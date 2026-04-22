package tv.danmaku.bili.ui.splash;

import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.lib.tribe.core.internal.Hooks;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SplashTestActivity.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/ui/splash/SplashTestActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashTestActivity extends AppCompatActivity {
    public static final int $stable = 8;
    private RecyclerView mRecyclerView;

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_test);
        RecyclerView findViewById = findViewById(R.id.recycler_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.mRecyclerView = findViewById;
        RecyclerView $this$onCreate_u24lambda_u240 = this.mRecyclerView;
        if ($this$onCreate_u24lambda_u240 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            $this$onCreate_u24lambda_u240 = null;
        }
        $this$onCreate_u24lambda_u240.setAdapter(new SplashTestAdapter(MenusItemsKt.getMenuItems()));
        $this$onCreate_u24lambda_u240.setLayoutManager(new GridLayoutManager($this$onCreate_u24lambda_u240.getContext(), 2));
    }
}
package tv.danmaku.bili.ui.videospace;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bilibili.app.authorspace.IAuthorSpaceHeaderPlayerService;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.BaseAppCompatActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.R;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: AuthorSpaceHeaderPlayerActivity.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/ui/videospace/AuthorSpaceHeaderPlayerActivity;", "Lcom/bilibili/lib/ui/BaseAppCompatActivity;", "<init>", "()V", "mAuthorSpaceHeaderPlayer", "Ltv/danmaku/bili/ui/videospace/AuthorSpaceHeaderPlayer;", "mModel", "Ltv/danmaku/bili/ui/videospace/AuthorSpaceHeaderVideoModel;", "mVideoContainerLayout", "Landroid/widget/FrameLayout;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onBackPressed", "onDestroy", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class AuthorSpaceHeaderPlayerActivity extends BaseAppCompatActivity {
    public static final String TAG = "AuthorSpaceHeaderPlayerActivity";
    private AuthorSpaceHeaderPlayer mAuthorSpaceHeaderPlayer;
    private AuthorSpaceHeaderVideoModel mModel;
    private FrameLayout mVideoContainerLayout;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    /* compiled from: AuthorSpaceHeaderPlayerActivity.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/ui/videospace/AuthorSpaceHeaderPlayerActivity$Companion;", "", "<init>", "()V", "TAG", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        AuthorSpaceHeaderPlayer authorSpaceHeaderPlayer;
        this.mModel = (AuthorSpaceHeaderVideoModel) new ViewModelProvider((ViewModelStoreOwner) this).get(AuthorSpaceHeaderVideoModel.class);
        AuthorSpaceHeaderVideoModel authorSpaceHeaderVideoModel = this.mModel;
        FrameLayout frameLayout = null;
        if (authorSpaceHeaderVideoModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mModel");
            authorSpaceHeaderVideoModel = null;
        }
        authorSpaceHeaderVideoModel.extractIntent((Activity) this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bili_app_activity_author_space_header_player);
        View findViewById = findViewById(R.id.author_space_header_video_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.mVideoContainerLayout = (FrameLayout) findViewById;
        this.mAuthorSpaceHeaderPlayer = new AuthorSpaceHeaderPlayer((Context) this);
        AuthorSpaceHeaderPlayer authorSpaceHeaderPlayer2 = this.mAuthorSpaceHeaderPlayer;
        if (authorSpaceHeaderPlayer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAuthorSpaceHeaderPlayer");
            authorSpaceHeaderPlayer = null;
        } else {
            authorSpaceHeaderPlayer = authorSpaceHeaderPlayer2;
        }
        FrameLayout frameLayout2 = this.mVideoContainerLayout;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoContainerLayout");
        } else {
            frameLayout = frameLayout2;
        }
        AuthorSpaceHeaderPlayer.createAndPrepareNormalPlayer$default(authorSpaceHeaderPlayer, null, frameLayout, new IAuthorSpaceHeaderPlayerService.RenderObserver() { // from class: tv.danmaku.bili.ui.videospace.AuthorSpaceHeaderPlayerActivity$onCreate$1
        }, true, false, false, 48, null);
    }

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, 0);
    }

    protected void onDestroy() {
        AuthorSpaceHeaderPlayer authorSpaceHeaderPlayer = this.mAuthorSpaceHeaderPlayer;
        if (authorSpaceHeaderPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAuthorSpaceHeaderPlayer");
            authorSpaceHeaderPlayer = null;
        }
        authorSpaceHeaderPlayer.releaseNormalPlayer();
        super.onDestroy();
    }
}
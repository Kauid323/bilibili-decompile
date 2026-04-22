package tv.danmaku.bili.ui.account.register;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import com.bilibili.app.accountui.R;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.view.legacy.ScalableImageView2;
import com.bilibili.lib.router.Router;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.BaseToolbarActivity;
import tv.danmaku.android.util.AppResUtil;
import tv.danmaku.bili.router.MainRouteUris;

public class RegisterSuccessActivity extends BaseToolbarActivity {
    static final int REQ_CODE_ANSWER = 201;

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(67108864, 67108864);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bili_app_activity_start_answer);
        ensureToolbar();
        showBackButton();
        findViewById(R.id.go_answer).setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.account.register.RegisterSuccessActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RegisterSuccessActivity.this.m1537lambda$onCreate$0$tvdanmakubiliuiaccountregisterRegisterSuccessActivity(view);
            }
        });
        ScalableImageView2 imageView2 = findViewById(R.id.answer_banner);
        BiliImageLoader.INSTANCE.with(imageView2.getContext()).url(AppResUtil.getImageUrl("accountui_answer_banner.webp")).into(imageView2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$onCreate$0$tv-danmaku-bili-ui-account-register-RegisterSuccessActivity  reason: not valid java name */
    public /* synthetic */ void m1537lambda$onCreate$0$tvdanmakubiliuiaccountregisterRegisterSuccessActivity(View v) {
        Router.global().with(this).forResult(201).open(MainRouteUris.ROUTE_URI_ANSWER);
    }

    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle((CharSequence) null);
        Drawable drawable = new ColorDrawable(0);
        actionBar.setBackgroundDrawable(drawable);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 201) {
            finish();
        }
    }

    public void onBackPressed() {
        finish();
    }

    public static Intent createIntent(Context context) {
        return new Intent(context, RegisterSuccessActivity.class);
    }
}
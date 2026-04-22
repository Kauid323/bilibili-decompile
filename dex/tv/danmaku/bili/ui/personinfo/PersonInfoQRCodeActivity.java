package tv.danmaku.bili.ui.personinfo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.bilibili.lib.basecomponent.R;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.BaseToolbarActivity;

public class PersonInfoQRCodeActivity extends BaseToolbarActivity {
    private PersonInfoQRCodeFragment fragment;

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    public static Intent createIntent(Context context) {
        return new Intent(context, PersonInfoQRCodeActivity.class);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bili_app_activity_with_toolbar);
        ensureToolbar();
        showBackButton();
        getSupportActionBar().setTitle(bili.resource.profile.R.string.profile_global_string_1);
        if (savedInstanceState == null) {
            this.fragment = new PersonInfoQRCodeFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.content_layout, this.fragment, PersonInfoQRCodeFragment.TAG).commit();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(com.bilibili.app.personinfo.R.menu.menu_qrcode, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (this.fragment == null) {
            PersonInfoQRCodeFragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(PersonInfoQRCodeFragment.TAG);
            if (findFragmentByTag instanceof PersonInfoQRCodeFragment) {
                this.fragment = findFragmentByTag;
                return this.fragment.onOptionsItemSelected(item);
            }
            return super.onOptionsItemSelected(item);
        }
        return this.fragment.onOptionsItemSelected(item);
    }
}
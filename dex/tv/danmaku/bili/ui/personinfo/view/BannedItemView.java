package tv.danmaku.bili.ui.personinfo.view;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bilibili.app.personinfo.R;
import com.bilibili.droid.H5UrlConfigHelper;
import com.bilibili.lib.router.Router;
import com.bilibili.magicasakura.widgets.TintTextView;

public class BannedItemView extends FrameLayout implements View.OnClickListener {
    public static final String TARGET_URI = "https://www.bilibili.com/blackroom/releaseexame.html?menu=0";
    public static final int TYPE_BAN_BANNING = 1;
    public static final int TYPE_BAN_EXPIRE = 2;
    public static final int TYPE_BAN_NONE = 0;
    private TintTextView mBannedEntry;
    private int mType;

    public BannedItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.bili_app_layout_ban_entry, this);
        this.mBannedEntry = findViewById(R.id.tv_banned_entry);
        setOnClickListener(this);
        setType(0);
    }

    public void setType(int type) {
        this.mType = type;
        switch (this.mType) {
            case 0:
                setVisibility(8);
                return;
            case 1:
                setVisibility(0);
                if (this.mBannedEntry != null) {
                    this.mBannedEntry.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_ban_flag, 0, 0, 0);
                    this.mBannedEntry.setText(bili.resource.profile.R.string.profile_global_string_22);
                }
                setClickable(false);
                return;
            case 2:
                setVisibility(0);
                if (this.mBannedEntry != null) {
                    this.mBannedEntry.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_ban_flag, 0, R.drawable.ic_ban_back, 0);
                    this.mBannedEntry.setText(bili.resource.profile.R.string.profile_global_string_44);
                }
                setClickable(true);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Uri uri = Uri.parse(H5UrlConfigHelper.INSTANCE.getUrl("person_info", "url_releaseexame", TARGET_URI));
        Router.global().with(getContext()).with(uri).open("activity://main/web");
    }
}
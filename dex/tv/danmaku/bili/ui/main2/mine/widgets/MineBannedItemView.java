package tv.danmaku.bili.ui.main2.mine.widgets;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bilibili.lib.router.Router;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.R;

public class MineBannedItemView extends FrameLayout implements View.OnClickListener {
    public static final String TARGET_URI = "https://www.bilibili.com/blackroom/releaseexame.html?menu=0";
    public static final int TYPE_BAN_BANNING = 1;
    public static final int TYPE_BAN_EXPIRE = 2;
    public static final int TYPE_BAN_NONE = 0;
    private View mArrowView;
    private TintTextView mBannedEntry;
    private IClickListener mClickListener;
    private int mType;

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public interface IClickListener {
        void onClick();
    }

    public MineBannedItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.bili_layout_main_user_center_banned_view, this);
        this.mBannedEntry = findViewById(R.id.tv_banned_entry);
        this.mArrowView = findViewById(R.id.ic_arrow);
        setOnClickListener(this);
        setType(0, null);
    }

    public void setType(int type, IClickListener clickListener) {
        this.mClickListener = clickListener;
        this.mType = type;
        switch (this.mType) {
            case 0:
                setVisibility(8);
                return;
            case 1:
                setVisibility(0);
                if (this.mBannedEntry != null) {
                    this.mArrowView.setVisibility(8);
                    this.mBannedEntry.setText(bili.resource.homepage.R.string.homepage_global_string_358);
                }
                setClickable(false);
                return;
            case 2:
                setVisibility(0);
                if (this.mBannedEntry != null) {
                    this.mArrowView.setVisibility(0);
                    this.mBannedEntry.setText(bili.resource.homepage.R.string.homepage_global_string_242);
                }
                setClickable(true);
                return;
            default:
                return;
        }
    }

    public void setType(int type) {
        setType(type, null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Uri uri = Uri.parse(TARGET_URI);
        Router.global().with(getContext()).with(uri).open("activity://main/web");
        if (this.mClickListener != null) {
            this.mClickListener.onClick();
        }
    }
}
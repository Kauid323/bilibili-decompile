package tv.danmaku.bili.ui.notice;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.magicasakura.widgets.TintRelativeLayout;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.IntentHelper;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.main2.reporter.MineReporter;
import tv.danmaku.bili.ui.main2.reporter.NavigationReporter;
import tv.danmaku.bili.ui.notice.api.BiliNotice;

public class CommonNoticeBar extends TintRelativeLayout implements View.OnClickListener {
    public static final String KEY_ID = "notice_id";
    private Context mContext;
    private ICloseClickListener mICloseClickListener;
    private BiliNotice notice;
    private TextView noticeContent;

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public interface ICloseClickListener {
        void onClick();
    }

    public CommonNoticeBar(Context context) {
        this(context, null);
    }

    public CommonNoticeBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CommonNoticeBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        initComponent();
    }

    private void initComponent() {
        View close = findViewById(R.id.close);
        close.setOnClickListener(this);
        this.noticeContent = (TextView) findViewById(R.id.content);
        this.noticeContent.setOnClickListener(this);
    }

    private void tryJump() {
        if (this.mContext != null && this.notice.data != null && this.notice.data.uri != null) {
            Uri uri = Uri.parse(this.notice.data.uri);
            IntentHelper.intentTo(this.mContext, AudioIntentHelper.appendFromIfCan(uri, AudioIntentHelper.FROM_ACTIVITY));
            NavigationReporter.reportNoticeClick();
        }
    }

    private boolean isValid() {
        if (this.notice.data == null) {
            return false;
        }
        long timeInSecond = System.currentTimeMillis() / 1000;
        return timeInSecond > this.notice.data.startTime && timeInSecond < this.notice.data.endTime;
    }

    public void updateNotice(BiliNotice notice) {
        if (this.mContext == null || notice == null) {
            setVisibility(8);
            return;
        }
        this.notice = notice;
        if (!isValid()) {
            setVisibility(8);
            return;
        }
        long noticeId = BiliGlobalPreferenceHelper.getInstance(this.mContext).optLongOrInteger(KEY_ID, -1L);
        if (noticeId == notice.data.id) {
            setVisibility(8);
        } else if (notice.data.content != null) {
            setVisibility(0);
            this.noticeContent.setText(notice.data.content);
        } else {
            setVisibility(8);
        }
    }

    public void updateNotice(BiliNotice notice, ICloseClickListener closeClickListener) {
        this.mICloseClickListener = closeClickListener;
        updateNotice(notice);
    }

    private void close() {
        setVisibility(8);
        if (this.mContext == null || this.notice == null || this.notice.data == null) {
            return;
        }
        BiliGlobalPreferenceHelper.getInstance(this.mContext).setLong(KEY_ID, this.notice.data.id);
        NavigationReporter.reportNoticeCloseClick();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.close) {
            close();
            if (this.mICloseClickListener != null) {
                this.mICloseClickListener.onClick();
            }
        } else if (i == R.id.content) {
            tryJump();
            MineReporter.reportMineNoticeAllClick();
        }
    }
}
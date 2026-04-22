package tv.danmaku.biliplayerv2.service.interact.biz.model.comment;

import android.os.Bundle;
import android.text.TextUtils;
import java.nio.charset.Charset;
import java.util.zip.CRC32;
import tv.danmaku.biliplayerv2.utils.DanmakuSendHelper;

public abstract class CommentItem {
    private static final int COLOR_DEFAULT = -1;
    private static final String TAG = "CommentItem";
    private static final int TEXT_SIZE_MEDIUM = 25;
    public String action;
    public String animation;
    public int attr;
    public DanmakuSendHelper.Colorful colorful;
    public long ctime;
    public long mDanmakuId;
    public int mIndex;
    public int mLineCount;
    public boolean mRecommended;
    public String mRemoteDmId;
    public boolean mSentFromMe;
    public String mText;
    public long mTimeMilli;
    public int pool;
    public String mDamakuSenderHash = null;
    public boolean mIsGuest = false;
    public int mSize = 25;
    private int mTextColor = -1;
    public int likes = 0;
    public boolean showReply = false;
    public boolean showLike = true;
    public boolean showReport = true;
    public int mReplyCount = 0;
    public int weight = 0;
    public long cid = 0;
    public Bundle mExtras = new Bundle();

    public abstract int getCommentType();

    public abstract long getDuration();

    public String getText() {
        return this.mText;
    }

    public boolean isValid() {
        return true;
    }

    public void setBody(String body) throws CommentParseException {
        if (body == null) {
            throw new CommentParseException("body is null");
        }
        this.mText = body;
        int length = this.mText.length();
        int pos = 0;
        int lineCounter = 0;
        while (pos <= length) {
            int pos2 = this.mText.indexOf(10, pos);
            if (-1 == pos2) {
                break;
            }
            lineCounter++;
            pos = pos2 + 1;
        }
        this.mLineCount = lineCounter;
    }

    public final void setTimeInMilliSeconds(long timeMS) {
        this.mTimeMilli = timeMS;
    }

    public final void setSize(String size) throws NumberFormatException {
        setSize(Integer.parseInt(size));
    }

    public final void setSize(int size) {
        this.mSize = size;
    }

    public int getViewTextColor() {
        return this.mTextColor | (-16777216);
    }

    public void setTextColor(String textColor) throws NumberFormatException {
        long color = Long.parseLong(textColor);
        setTextColor((int) color);
    }

    public void setTextColor(int color) {
        this.mTextColor = color;
    }

    public final int getLineCount() {
        return this.mLineCount;
    }

    public void setDamakuSenderHash(String idStr) {
        if (TextUtils.isEmpty(idStr)) {
            this.mIsGuest = true;
            return;
        }
        this.mIsGuest = idStr.indexOf(68) == 0;
        this.mDamakuSenderHash = idStr;
    }

    public void setDamakuSenderHash(long mid) {
        if (mid <= 0) {
            setDamakuSenderHash((String) null);
            return;
        }
        CRC32 crc32 = new CRC32();
        crc32.update(String.valueOf(mid).getBytes(Charset.defaultCharset()));
        String hex = Long.toHexString(crc32.getValue());
        setDamakuSenderHash(hex);
    }

    public void setDmId(String dmid) {
        this.mRemoteDmId = dmid;
    }

    public String getDmId() {
        return this.mRemoteDmId;
    }

    public String toString() {
        return "CommentItem{mDanmakuId=" + this.mDanmakuId + ", mRemoteDmId='" + this.mRemoteDmId + "', mText='" + this.mText + "'}";
    }
}
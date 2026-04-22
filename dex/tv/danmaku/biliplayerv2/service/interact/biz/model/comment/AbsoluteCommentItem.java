package tv.danmaku.biliplayerv2.service.interact.biz.model.comment;

import android.text.TextUtils;
import java.lang.reflect.Array;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.service.setting.Player;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

public class AbsoluteCommentItem extends CommentItem {
    public static final int BILI_PLAYER_HEIGHT = 438;
    public static final int BILI_PLAYER_WIDTH = 682;
    private static final boolean ENABLE_VERBOSE = false;
    public static final String TAG = AbsoluteCommentItem.class.getName();
    public float[][] mLinePathPoints;
    public int fromX = 0;
    public int toX = 0;
    public int fromY = 0;
    public int toY = 0;
    public boolean hasAlphaDelta = false;
    public float fromAlpha = 1.0f;
    public float toAlpha = 1.0f;
    public long durationMillis = 0;
    public int rotateAlongZ = 0;
    public int rotateAlongY = 0;
    public long moveDurationMillis = PlayerToastConfig.DURATION_4;
    public long moveDelayMillis = 0;
    public boolean isFromXposPercentage = false;
    public boolean isFromYposPercentage = false;
    public boolean isToXposPercentage = false;
    public boolean isToYposPercentage = false;

    public static String[] parseAbsoluteComment(String text) throws CommentParseException {
        int first = text.indexOf(123);
        int last = text.lastIndexOf(Player.PLAYER_QUALITY_HDR);
        if (first != -1 && last != -1 && last > first) {
            text = text.substring(first, last + 1);
        }
        try {
            Object oRoot = new JSONTokener(text).nextValue();
            if (oRoot == null || !JSONArray.class.isInstance(oRoot)) {
                throw new CommentParseException("failed to parse response");
            }
            JSONArray jRoot = (JSONArray) oRoot;
            int count = jRoot.length();
            if (count < 5) {
                throw new CommentParseException("invalid abs danmaku");
            }
            String[] valueArray = new String[count];
            for (int i = 0; i < count; i++) {
                valueArray[i] = jRoot.optString(i);
            }
            return valueArray;
        } catch (JSONException e) {
            throw new CommentParseException(e);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.model.comment.CommentItem
    public int getCommentType() {
        return 7;
    }

    private boolean isPercentagePosition(String value) {
        return !TextUtils.isEmpty(value) && value.indexOf(46) > 0;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.model.comment.CommentItem
    public void setBody(String body) throws CommentParseException {
        if (!body.startsWith("[") && !body.endsWith("]")) {
            super.setBody(body);
            return;
        }
        String[] values = parseAbsoluteComment(body);
        if (values == null) {
            throw new CommentParseException(body);
        }
        if (values.length < 5) {
            throw new CommentParseException(body);
        }
        this.isFromXposPercentage = isPercentagePosition(values[0]);
        this.isFromYposPercentage = isPercentagePosition(values[1]);
        int floatValue = (int) (this.isFromXposPercentage ? Float.valueOf(values[0]).floatValue() * 682.0f : Math.round(Float.valueOf(values[0]).floatValue()));
        this.fromX = floatValue;
        this.toX = floatValue;
        int floatValue2 = (int) (this.isFromYposPercentage ? Float.valueOf(values[1]).floatValue() * 438.0f : Math.round(Float.valueOf(values[1]).floatValue()));
        this.fromY = floatValue2;
        this.toY = floatValue2;
        setAlphaDelta(values[2]);
        this.durationMillis = Float.valueOf(values[3]).floatValue() * 1000.0f;
        super.setBody(values[4]);
        if (values.length > 5) {
            this.rotateAlongZ = Integer.parseInt(values[5]);
        }
        if (values.length > 6) {
            this.rotateAlongY = Integer.parseInt(values[6]);
        }
        if (values.length > 7) {
            this.isToXposPercentage = isPercentagePosition(values[7]);
            this.toX = (int) (this.isToXposPercentage ? Float.valueOf(values[7]).floatValue() * 682.0f : Math.round(Float.valueOf(values[7]).floatValue()));
        }
        if (values.length > 8) {
            this.isToYposPercentage = isPercentagePosition(values[8]);
            this.toY = (int) (this.isToYposPercentage ? Float.valueOf(values[8]).floatValue() * 438.0f : Math.round(Float.valueOf(values[8]).floatValue()));
        }
        if (values.length > 9) {
            this.moveDurationMillis = Float.valueOf(values[9]).floatValue();
        }
        if (values.length > 10) {
            this.moveDelayMillis = Float.valueOf(values[10]).floatValue();
        }
        int length = values.length;
        int length2 = values.length;
        int length3 = values.length;
        if (values.length >= 15 && "".equals(values[14])) {
            String motionPathString = values[14].substring(1);
            String[] pointStrArray = motionPathString.split("L");
            if (pointStrArray.length > 0) {
                float[][] points = (float[][]) Array.newInstance(Float.TYPE, pointStrArray.length, 2);
                for (int i = 0; i < pointStrArray.length; i++) {
                    String[] pointArray = pointStrArray[i].split(",");
                    points[i][0] = Float.parseFloat(pointArray[0]);
                    points[i][1] = Float.parseFloat(pointArray[1]);
                }
                this.mLinePathPoints = points;
            }
        }
    }

    public void setAlphaDelta(String alphaDelta) {
        if (alphaDelta.equals("1-1")) {
            this.fromAlpha = 1.0f;
            this.toAlpha = 1.0f;
            this.hasAlphaDelta = false;
        } else if (alphaDelta.equals("1-0")) {
            this.fromAlpha = 1.0f;
            this.toAlpha = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
            this.hasAlphaDelta = true;
        } else if (alphaDelta.equals("0-1")) {
            this.fromAlpha = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
            this.toAlpha = 1.0f;
            this.hasAlphaDelta = true;
        } else {
            String[] values = alphaDelta.split("-");
            if (values != null && values.length >= 2) {
                float fromAlpha = Float.parseFloat(values[0]);
                float toAlpha = Float.parseFloat(values[1]);
                if (fromAlpha != 1.0f && toAlpha != 1.0f) {
                    this.fromAlpha = fromAlpha;
                    this.toAlpha = toAlpha;
                    this.hasAlphaDelta = true;
                }
            }
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.model.comment.CommentItem
    public long getDuration() {
        return this.durationMillis;
    }
}
package tv.danmaku.bili.report.misaka.model;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import tv.danmaku.bili.report.biz.api.produce.model.RequestEvent;

public class MediaEvent {
    private static final String DEFAULT_PLAY_URL = "https://interface.bilibili.com/playurl";
    private static final int ERROR_CODE_PLAY = 21;
    public String eventBody;
    public String eventFrom;
    public String eventSession;
    public int eventType;
    public int httpCode;
    public int mediaCid;
    public String[] params;
    public String playUrl;
    public String realUrl;
    public int resolveCode;

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public enum FormatType {
        TYPE_PARSE,
        TYPE_PLAY
    }

    private MediaEvent() {
    }

    public static MediaEvent obtain(String[] args) {
        if (args == null || args.length == 0) {
            return null;
        }
        MediaEvent mediaEvent = new MediaEvent();
        mediaEvent.params = args;
        int i = 0;
        while (true) {
            if (i < args.length) {
                if (TextUtils.equals(args[i], "f_url") && i + 1 < args.length) {
                    mediaEvent.realUrl = args[i + 1];
                    break;
                }
                if (TextUtils.equals(args[i], "f_http_code") && i + 1 < args.length) {
                    try {
                        mediaEvent.httpCode = Integer.parseInt(args[i + 1]);
                    } catch (NumberFormatException e) {
                        mediaEvent.httpCode = 0;
                    }
                }
                i++;
            } else {
                break;
            }
        }
        return mediaEvent;
    }

    public static MediaEvent obtain(JSONObject info) {
        if (info == null) {
            return null;
        }
        try {
            MediaEvent mediaEvent = new MediaEvent();
            mediaEvent.eventFrom = info.getString("f_from");
            mediaEvent.eventBody = info.getString("f_body");
            mediaEvent.eventSession = info.getString("f_session");
            String url = info.getString("f_url");
            if (!TextUtils.isEmpty(url)) {
                mediaEvent.playUrl = url;
            }
            mediaEvent.mediaCid = info.getIntValue("f_cid");
            mediaEvent.eventType = info.getIntValue("f_event");
            mediaEvent.resolveCode = info.getIntValue("f_error");
            return mediaEvent;
        } catch (Exception e) {
            return null;
        }
    }

    public static RequestEvent transformToRequestEvent(MediaEvent mediaEvent, FormatType type) {
        String playUrl = "";
        int errorCode = 0;
        int httpCode = 0;
        if (type == FormatType.TYPE_PARSE) {
            playUrl = TextUtils.isEmpty(mediaEvent.playUrl) ? DEFAULT_PLAY_URL : mediaEvent.playUrl;
            if (mediaEvent.eventType == 4) {
                playUrl = playUrl + "/request";
                httpCode = mediaEvent.resolveCode;
            } else if (mediaEvent.eventType == 5) {
                playUrl = playUrl + "/parse";
            }
        } else if (type == FormatType.TYPE_PLAY) {
            playUrl = mediaEvent.realUrl;
            errorCode = 21;
            httpCode = mediaEvent.httpCode;
        }
        RequestEvent requestEvent = RequestEvent.obtain(playUrl);
        requestEvent.respmsg = formatInformation(mediaEvent, type);
        requestEvent.errorCode = errorCode;
        requestEvent.httpcode = httpCode;
        return requestEvent;
    }

    public static String formatInformation(MediaEvent event, FormatType type) {
        if (event == null) {
            return "";
        }
        StringBuilder builder = new StringBuilder(16);
        if (type == FormatType.TYPE_PLAY) {
            if (event.params != null) {
                int length = event.params.length;
                if (event.params.length % 2 == 1) {
                    length--;
                }
                int j = 0;
                for (int i = 0; i < length; i++) {
                    if (i % 2 == 0) {
                        if (event.params[i] == null) {
                            event.params[i] = "key null";
                        }
                        if (i != 0) {
                            builder.append("; ");
                        }
                        if (TextUtils.equals(event.params[i], "f_url") && i + 1 < length) {
                            j = i + 1;
                        } else {
                            builder.append(event.params[i]);
                        }
                    } else if (i != j) {
                        builder.append("=").append(event.params[i]);
                    }
                }
            }
        } else if (type == FormatType.TYPE_PARSE) {
            String[] tempKey = {"f_session", "f_cid", "f_event", "f_error", "f_body"};
            String[] tempValue = {event.eventSession, String.valueOf(event.mediaCid), String.valueOf(event.eventType), String.valueOf(event.resolveCode), event.eventBody};
            for (int i2 = 0; i2 < tempKey.length && i2 < tempValue.length; i2++) {
                if (i2 != 0) {
                    builder.append("; ");
                }
                builder.append(tempKey[i2]).append("=").append(tempValue[i2]);
            }
        }
        return builder.toString();
    }
}
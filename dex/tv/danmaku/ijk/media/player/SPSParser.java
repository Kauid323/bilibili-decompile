package tv.danmaku.ijk.media.player;

import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class SPSParser {
    private DataInputStream buffer;
    private int buffer_index;
    private int current_word;
    private int current_word_bits_left;
    private int total_bytes;

    public static SPS parseExtradata(String extradata_base64) {
        SPSParser parser = new SPSParser(extradata_base64);
        return parser.parseSPS();
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public class SPS {
        public int aspect_ratio;
        public int chroma_format_idc;
        public int frame_crop_bottom_offset;
        public int frame_crop_left_offset;
        public int frame_crop_right_offset;
        public int frame_crop_top_offset;
        public int frame_mbs_only_flag;
        public int pic_height_in_map_units_minus1;
        public int pic_width_in_mbs_minus1;
        public int sar_height;
        public int sar_width;
        private int[] sar_w_table = {1, 12, 10, 16, 40, 24, 20, 32, 80, 18, 15, 64, 160, 4, 3, 2};
        private int[] sar_h_table = {1, 11, 11, 11, 33, 11, 11, 11, 33, 11, 11, 33, 99, 3, 2, 1};

        public SPS() {
        }

        public int getWidth() {
            int count = 2;
            count = (this.chroma_format_idc == 0 || this.chroma_format_idc == 3) ? 1 : 1;
            return ((this.pic_width_in_mbs_minus1 + 1) * 16) - ((this.frame_crop_left_offset + this.frame_crop_right_offset) * count);
        }

        public int getHeight() {
            int count = 1;
            if (this.chroma_format_idc == 1) {
                count = 2;
            }
            return ((2 - this.frame_mbs_only_flag) * ((this.pic_height_in_map_units_minus1 + 1) * 16)) - (((this.frame_crop_top_offset + this.frame_crop_bottom_offset) * (2 - this.frame_mbs_only_flag)) * count);
        }

        public double getSarScale() {
            if (this.aspect_ratio > 0 && this.aspect_ratio <= 16) {
                double scale = this.sar_w_table[this.aspect_ratio - 1] / this.sar_h_table[this.aspect_ratio - 1];
                return scale;
            } else if (this.aspect_ratio == 255) {
                double scale2 = this.sar_width / this.sar_height;
                return scale2;
            } else {
                return 1.0d;
            }
        }

        public String toString() {
            return "Width = " + getWidth() + " Height = " + getHeight() + " SarScale= " + getSarScale();
        }
    }

    public SPSParser(String extradata_base64) {
        byte[] sps = Base64.decode(extradata_base64, 0);
        this.buffer = new DataInputStream(new ByteArrayInputStream(sps));
        this.buffer_index = 0;
        this.total_bytes = sps.length;
        this.current_word = 0;
        this.current_word_bits_left = 0;
    }

    private void fillCurrentWord() {
        int buffer_bytes_left = this.total_bytes - this.buffer_index;
        if (buffer_bytes_left <= 0) {
            return;
        }
        int bytes_read = Math.min(4, buffer_bytes_left);
        try {
            if (bytes_read == 4) {
                this.current_word = this.buffer.readInt();
            } else {
                this.current_word = 0;
                while (bytes_read != 0) {
                    this.current_word <<= 8;
                    this.current_word |= this.buffer.readUnsignedByte();
                    bytes_read--;
                }
            }
            this.buffer_index += bytes_read;
            this.current_word_bits_left = bytes_read * 8;
        } catch (IOException e) {
        }
    }

    private void skipScalingList(int count) {
        int last_scale = 8;
        int next_scale = 8;
        for (int i = 0; i < count; i++) {
            if (next_scale != 0) {
                int delta_scale = readSEG();
                next_scale = ((last_scale + delta_scale) + IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) % IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN;
            }
            last_scale = next_scale == 0 ? last_scale : next_scale;
        }
    }

    private int skipLeadingZero(int dep) {
        if (dep > 8) {
            return 0;
        }
        int i = 0;
        while (i < this.current_word_bits_left) {
            if ((this.current_word & (Integer.MIN_VALUE >>> i)) == 0) {
                i++;
            } else {
                this.current_word <<= i;
                this.current_word_bits_left -= i;
                return i;
            }
        }
        fillCurrentWord();
        return skipLeadingZero(dep + 1) + i;
    }

    private int readBits(int bits) {
        if (bits <= this.current_word_bits_left) {
            int result = this.current_word >>> (32 - bits);
            this.current_word <<= bits;
            this.current_word_bits_left -= bits;
            return result;
        }
        int result2 = 0;
        if (this.current_word_bits_left != 0) {
            result2 = this.current_word;
        }
        int result3 = result2 >>> (32 - this.current_word_bits_left);
        int bits_need_left = bits - this.current_word_bits_left;
        fillCurrentWord();
        int bits_need_next = Math.min(bits_need_left, this.current_word_bits_left);
        int result22 = this.current_word >>> (32 - bits_need_next);
        this.current_word <<= bits_need_next;
        this.current_word_bits_left -= bits_need_next;
        return (result3 << bits_need_next) | result22;
    }

    private int readUEG() {
        return readBits(skipLeadingZero(0) + 1) - 1;
    }

    private int readSEG() {
        int result = readUEG();
        if ((result & 1) == 1) {
            return (result + 1) >>> 1;
        }
        return (result >>> 1) * (-1);
    }

    private SPS parseSPS() {
        SPS sps = new SPS();
        readBits(32);
        readBits(32);
        readBits(8);
        int profile_idc = readBits(8);
        readBits(8);
        readBits(8);
        readUEG();
        if (profile_idc == 100 || profile_idc == 110 || profile_idc == 122 || profile_idc == 122 || profile_idc == 244 || profile_idc == 44 || profile_idc == 83 || profile_idc == 86 || profile_idc == 118 || profile_idc == 128 || profile_idc == 138 || profile_idc == 139 || profile_idc == 134 || profile_idc == 135) {
            sps.chroma_format_idc = readUEG();
            if (sps.chroma_format_idc == 3) {
                readBits(1);
            }
            readUEG();
            readUEG();
            readBits(1);
            if (readBits(1) != 0) {
                int i = 0;
                while (true) {
                    if (i >= (sps.chroma_format_idc != 3 ? 8 : 12)) {
                        break;
                    }
                    if (readBits(1) == 1) {
                        if (i < 6) {
                            skipScalingList(16);
                        } else {
                            skipScalingList(64);
                        }
                    }
                    i++;
                }
            }
        }
        readUEG();
        int pic_order_cnt_type = readUEG();
        if (pic_order_cnt_type == 0) {
            readUEG();
        } else if (pic_order_cnt_type == 1) {
            readBits(1);
            readSEG();
            readSEG();
            int num_ref_frames_in_pic_order_cnt_cycle = readUEG();
            for (int i2 = 0; i2 < num_ref_frames_in_pic_order_cnt_cycle; i2++) {
                readSEG();
            }
        }
        readUEG();
        readBits(1);
        sps.pic_width_in_mbs_minus1 = readUEG();
        sps.pic_height_in_map_units_minus1 = readUEG();
        sps.frame_mbs_only_flag = readBits(1);
        if (sps.frame_mbs_only_flag == 0) {
            readBits(1);
        }
        readBits(1);
        if (readBits(1) != 0) {
            sps.frame_crop_left_offset = readUEG();
            sps.frame_crop_right_offset = readUEG();
            sps.frame_crop_top_offset = readUEG();
            sps.frame_crop_bottom_offset = readUEG();
        }
        if (readBits(1) != 0) {
            if (readBits(1) != 0) {
                sps.aspect_ratio = readBits(8);
                if (sps.aspect_ratio == 255) {
                    sps.sar_width = readBits(16);
                    sps.sar_height = readBits(16);
                }
            }
        } else {
            sps.aspect_ratio = 0;
        }
        return sps;
    }
}
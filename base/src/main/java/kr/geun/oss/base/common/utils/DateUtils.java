package kr.geun.oss.base.common.utils;

import java.util.Date;

/**
 * DateUtils
 *
 * @author akageun
 * @since 2019-10-07
 */
public abstract class DateUtils extends org.apache.commons.lang3.time.DateUtils {

    public static final String YMDHMS_FOR_READONLY = "yyyy-MM-dd HH:mm:ss";

    public static Date minusDays(Date date, int amount) {
        return addDays(date, -amount);
    }
}

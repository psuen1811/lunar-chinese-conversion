package com.suanla.ziwei.lunar;

/**
 * Created by psuen on 3/22/14.
 */
public class CalendarService
{
    public final static char[] DAYS_IN_GREGORIAN_MONTH = {
            31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };

    public final static String[] STEM_NAMES = {
            "庚", "辛", "壬", "癸", "甲", "乙", "丙", "丁", "戊", "己"
    };

    public final static String[] BRANCH_NAMES = {
            "申", "酉", "戌", "亥", "子", "丑", "寅", "卯", "辰", "巳", "午", "未"
    };

    public final static String[] ANIMAL_NAMES = {
            "鼠", "牛", "虎", "兔", "龍", "蛇", "馬", "羊", "猴", "雞", "狗", "豬"
    };

    // 大閏月的閏年年份
    private final static int[] BIG_LEAP_MONTH_YEARS = {
            6, 14, 19, 25, 33, 36, 38, 41, 44, 52, 55, 79, 117, 136, 147, 150, 155, 158, 185, 193
    };

    private final static String[] CHINESE_MONTH_NAMES = {
            "正", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "十二"
    };

    private final static String[] CHINESE_NUMBER = {"一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "十二"};

    private final static String[] PRINCIPLE_TERM_NAMES = {
            "大寒", "雨水", "春分", "穀雨", "夏滿", "夏至", "大暑", "處暑", "秋分", "霜降", "小雪", "冬至"
    };

    private final static String[] SECTIONAL_TERM_NAMES = {
            "小寒", "立春", "驚蟄", "清明", "立夏", "芒種", "小暑", "立秋", "白露", "寒露", "立冬", "大雪"
    };

    // 農曆月份大小壓縮表，兩個字節表示一年。兩個字節共十六個二進制位數，
// 前四個位數表示閏月月份，後十二個位數表示十二個農曆月份的大小。
    private final static char[] CHINESE_MONTHS = {
            0x00, 0x04, 0xad, 0x08, 0x5a, 0x01, 0xd5, 0x54, 0xb4, 0x09, 0x64, 0x05, 0x59, 0x45, 0x95, 0x0a, 0xa6, 0x04, 0x55, 0x24,
            0xad, 0x08, 0x5a, 0x62, 0xda, 0x04, 0xb4, 0x05, 0xb4, 0x55, 0x52, 0x0d, 0x94, 0x0a, 0x4a, 0x2a, 0x56, 0x02, 0x6d, 0x71,
            0x6d, 0x01, 0xda, 0x02, 0xd2, 0x52, 0xa9, 0x05, 0x49, 0x0d, 0x2a, 0x45, 0x2b, 0x09, 0x56, 0x01, 0xb5, 0x20, 0x6d, 0x01,
            0x59, 0x69, 0xd4, 0x0a, 0xa8, 0x05, 0xa9, 0x56, 0xa5, 0x04, 0x2b, 0x09, 0x9e, 0x38, 0xb6, 0x08, 0xec, 0x74, 0x6c, 0x05,
            0xd4, 0x0a, 0xe4, 0x6a, 0x52, 0x05, 0x95, 0x0a, 0x5a, 0x42, 0x5b, 0x04, 0xb6, 0x04, 0xb4, 0x22, 0x6a, 0x05, 0x52, 0x75,
            0xc9, 0x0a, 0x52, 0x05, 0x35, 0x55, 0x4d, 0x0a, 0x5a, 0x02, 0x5d, 0x31, 0xb5, 0x02, 0x6a, 0x8a, 0x68, 0x05, 0xa9, 0x0a,
            0x8a, 0x6a, 0x2a, 0x05, 0x2d, 0x09, 0xaa, 0x48, 0x5a, 0x01, 0xb5, 0x09, 0xb0, 0x39, 0x64, 0x05, 0x25, 0x75, 0x95, 0x0a,
            0x96, 0x04, 0x4d, 0x54, 0xad, 0x04, 0xda, 0x04, 0xd4, 0x44, 0xb4, 0x05, 0x54, 0x85, 0x52, 0x0d, 0x92, 0x0a, 0x56, 0x6a,
            0x56, 0x02, 0x6d, 0x02, 0x6a, 0x41, 0xda, 0x02, 0xb2, 0xa1, 0xa9, 0x05, 0x49, 0x0d, 0x0a, 0x6d, 0x2a, 0x09, 0x56, 0x01,
            0xad, 0x50, 0x6d, 0x01, 0xd9, 0x02, 0xd1, 0x3a, 0xa8, 0x05, 0x29, 0x85, 0xa5, 0x0c, 0x2a, 0x09, 0x96, 0x54, 0xb6, 0x08,
            0x6c, 0x09, 0x64, 0x45, 0xd4, 0x0a, 0xa4, 0x05, 0x51, 0x25, 0x95, 0x0a, 0x2a, 0x72, 0x5b, 0x04, 0xb6, 0x04, 0xac, 0x52,
            0x6a, 0x05, 0xd2, 0x0a, 0xa2, 0x4a, 0x4a, 0x05, 0x55, 0x94, 0x2d, 0x0a, 0x5a, 0x02, 0x75, 0x61, 0xb5, 0x02, 0x6a, 0x03,
            0x61, 0x45, 0xa9, 0x0a, 0x4a, 0x05, 0x25, 0x25, 0x2d, 0x09, 0x9a, 0x68, 0xda, 0x08, 0xb4, 0x09, 0xa8, 0x59, 0x54, 0x03,
            0xa5, 0x0a, 0x91, 0x3a, 0x96, 0x04, 0xad, 0xb0, 0xad, 0x04, 0xda, 0x04, 0xf4, 0x62, 0xb4, 0x05, 0x54, 0x0b, 0x44, 0x5d,
            0x52, 0x0a, 0x95, 0x04, 0x55, 0x22, 0x6d, 0x02, 0x5a, 0x71, 0xda, 0x02, 0xaa, 0x05, 0xb2, 0x55, 0x49, 0x0b, 0x4a, 0x0a,
            0x2d, 0x39, 0x36, 0x01, 0x6d, 0x80, 0x6d, 0x01, 0xd9, 0x02, 0xe9, 0x6a, 0xa8, 0x05, 0x29, 0x0b, 0x9a, 0x4c, 0xaa, 0x08,
            0xb6, 0x08, 0xb4, 0x38, 0x6c, 0x09, 0x54, 0x75, 0xd4, 0x0a, 0xa4, 0x05, 0x45, 0x55, 0x95, 0x0a, 0x9a, 0x04, 0x55, 0x44,
            0xb5, 0x04, 0x6a, 0x82, 0x6a, 0x05, 0xd2, 0x0a, 0x92, 0x6a, 0x4a, 0x05, 0x55, 0x0a, 0x2a, 0x4a, 0x5a, 0x02, 0xb5, 0x02,
            0xb2, 0x31, 0x69, 0x03, 0x31, 0x73, 0xa9, 0x0a, 0x4a, 0x05, 0x2d, 0x55, 0x2d, 0x09, 0x5a, 0x01, 0xd5, 0x48, 0xb4, 0x09,
            0x68, 0x89, 0x54, 0x0b, 0xa4, 0x0a, 0xa5, 0x6a, 0x95, 0x04, 0xad, 0x08, 0x6a, 0x44, 0xda, 0x04, 0x74, 0x05, 0xb0, 0x25,
            0x54, 0x03
    };

    private final static char[][] SECTIONAL_TERM_MAP = {
            {
                    7, 6, 6, 6, 6, 6, 6, 6, 6, 5, 6, 6, 6, 5, 5, 6, 6, 5, 5, 5, 5, 5, 5, 5, 5, 4, 5, 5
            }, {
            5, 4, 5, 5, 5, 4, 4, 5, 5, 4, 4, 4, 4, 4, 4, 4, 4, 3, 4, 4, 4, 3, 3, 4, 4, 3, 3, 3
    }, {
            6, 6, 6, 7, 6, 6, 6, 6, 5, 6, 6, 6, 5, 5, 6, 6, 5, 5, 5, 6, 5, 5, 5, 5, 4, 5, 5, 5, 5
    }, {
            5, 5, 6, 6, 5, 5, 5, 6, 5, 5, 5, 5, 4, 5, 5, 5, 4, 4, 5, 5, 4, 4, 4, 5, 4, 4, 4, 4, 5
    }, {
            6, 6, 6, 7, 6, 6, 6, 6, 5, 6, 6, 6, 5, 5, 6, 6, 5, 5, 5, 6, 5, 5, 5, 5, 4, 5, 5, 5, 5
    }, {
            6, 6, 7, 7, 6, 6, 6, 7, 6, 6, 6, 6, 5, 6, 6, 6, 5, 5, 6, 6, 5, 5, 5, 6, 5, 5, 5, 5, 4, 5, 5, 5, 5
    }, {
            7, 8, 8, 8, 7, 7, 8, 8, 7, 7, 7, 8, 7, 7, 7, 7, 6, 7, 7, 7, 6, 6, 7, 7, 6, 6, 6, 7, 7
    }, {
            8, 8, 8, 9, 8, 8, 8, 8, 7, 8, 8, 8, 7, 7, 8, 8, 7, 7, 7, 8, 7, 7, 7, 7, 6, 7, 7, 7, 6, 6, 7, 7, 7
    }, {
            8, 8, 8, 9, 8, 8, 8, 8, 7, 8, 8, 8, 7, 7, 8, 8, 7, 7, 7, 8, 7, 7, 7, 7, 6, 7, 7, 7, 7
    }, {
            9, 9, 9, 9, 8, 9, 9, 9, 8, 8, 9, 9, 8, 8, 8, 9, 8, 8, 8, 8, 7, 8, 8, 8, 7, 7, 8, 8, 8
    }, {
            8, 8, 8, 8, 7, 8, 8, 8, 7, 7, 8, 8, 7, 7, 7, 8, 7, 7, 7, 7, 6, 7, 7, 7, 6, 6, 7, 7, 7
    }, {
            7, 8, 8, 8, 7, 7, 8, 8, 7, 7, 7, 8, 7, 7, 7, 7, 6, 7, 7, 7, 6, 6, 7, 7, 6, 6, 6, 7, 7
    }
    };

    private final static char[][] SECTIONAL_TERM_YEAR = {
            {
                    13, 49, 85, 117, 149, 185, 201, 250, 250
            }, {
            13, 45, 81, 117, 149, 185, 201, 250, 250
    }, {
            13, 48, 84, 112, 148, 184, 200, 201, 250
    }, {
            13, 45, 76, 108, 140, 172, 200, 201, 250
    }, {
            13, 44, 72, 104, 132, 168, 200, 201, 250
    }, {
            5, 33, 68, 96, 124, 152, 188, 200, 201
    }, {
            29, 57, 85, 120, 148, 176, 200, 201, 250
    }, {
            13, 48, 76, 104, 132, 168, 196, 200, 201
    }, {
            25, 60, 88, 120, 148, 184, 200, 201, 250
    }, {
            16, 44, 76, 108, 144, 172, 200, 201, 250
    }, {
            28, 60, 92, 124, 160, 192, 200, 201, 250
    }, {
            17, 53, 85, 124, 156, 188, 200, 201, 250
    }
    };

    private static char[][] principleTermMap = {
            {
                    21, 21, 21, 21, 21, 20, 21, 21, 21, 20, 20, 21, 21, 20, 20, 20, 20, 20, 20, 20, 20, 19, 20, 20, 20, 19, 19, 20
            }, {
            20, 19, 19, 20, 20, 19, 19, 19, 19, 19, 19, 19, 19, 18, 19, 19, 19, 18, 18, 19, 19, 18, 18, 18, 18, 18, 18, 18
    }, {
            21, 21, 21, 22, 21, 21, 21, 21, 20, 21, 21, 21, 20, 20, 21, 21, 20, 20, 20, 21, 20, 20, 20, 20, 19, 20, 20, 20, 20
    }, {
            20, 21, 21, 21, 20, 20, 21, 21, 20, 20, 20, 21, 20, 20, 20, 20, 19, 20, 20, 20, 19, 19, 20, 20, 19, 19, 19, 20, 20
    }, {
            21, 22, 22, 22, 21, 21, 22, 22, 21, 21, 21, 22, 21, 21, 21, 21, 20, 21, 21, 21, 20, 20, 21, 21, 20, 20, 20, 21, 21
    }, {
            22, 22, 22, 22, 21, 22, 22, 22, 21, 21, 22, 22, 21, 21, 21, 22, 21, 21, 21, 21, 20, 21, 21, 21, 20, 20, 21, 21, 21
    }, {
            23, 23, 24, 24, 23, 23, 23, 24, 23, 23, 23, 23, 22, 23, 23, 23, 22, 22, 23, 23, 22, 22, 22, 23, 22, 22, 22, 22, 23
    }, {
            23, 24, 24, 24, 23, 23, 24, 24, 23, 23, 23, 24, 23, 23, 23, 23, 22, 23, 23, 23, 22, 22, 23, 23, 22, 22, 22, 23, 23
    }, {
            23, 24, 24, 24, 23, 23, 24, 24, 23, 23, 23, 24, 23, 23, 23, 23, 22, 23, 23, 23, 22, 22, 23, 23, 22, 22, 22, 23, 23
    }, {
            24, 24, 24, 24, 23, 24, 24, 24, 23, 23, 24, 24, 23, 23, 23, 24, 23, 23, 23, 23, 22, 23, 23, 23, 22, 22, 23, 23, 23
    }, {
            23, 23, 23, 23, 22, 23, 23, 23, 22, 22, 23, 23, 22, 22, 22, 23, 22, 22, 22, 22, 21, 22, 22, 22, 21, 21, 22, 22, 22
    }, {
            22, 22, 23, 23, 22, 22, 22, 23, 22, 22, 22, 22, 21, 22, 22, 22, 21, 21, 22, 22, 21, 21, 21, 22, 21, 21, 21, 21, 22
    }
    };

    private final static char[][] PRINCIPLE_TERM_YEAR = {
            {
                    13, 45, 81, 113, 149, 185, 201
            }, {
            21, 57, 93, 125, 161, 193, 201
    }, {
            21, 56, 88, 120, 152, 188, 200, 201
    }, {
            21, 49, 81, 116, 144, 176, 200, 201
    }, {
            17, 49, 77, 112, 140, 168, 200, 201
    }, {
            28, 60, 88, 116, 148, 180, 200, 201
    }, {
            25, 53, 84, 112, 144, 172, 200, 201
    }, {
            29, 57, 89, 120, 148, 180, 200, 201
    }, {
            17, 45, 73, 108, 140, 168, 200, 201
    }, {
            28, 60, 92, 124, 160, 192, 200, 201
    }, {
            16, 44, 80, 112, 148, 180, 200, 201
    }, {
            17, 53, 88, 120, 156, 188, 200, 201
    }
    };

    private final static String[] MONTH_NAMES = {
            "一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "十二"
    };

    // 初始日，公曆農曆對應日期：
// 公曆 1901 年 1 月 1 日，對應農曆 4598 年 11 月 11 日
    private final static int BASE_YEAR = 1901;
    private final static int BASE_MONTH = 1;
    private final static int BASE_DATE = 1;
    private final static int BASE_INDEX = 0;
    private final static int BASE_CHINESE_YEAR = 4598 - 1;
    private final static int BASE_CHINESE_MONTH = 11;
    private final static int BASE_CHINESE_DATE = 11;

    private int dayOfWeek; // 週日一星期的第一天

    public CalendarService()
    {
    }

    private boolean isGregorianLeapYear(int year)
    {
        boolean isLeap = false;

        if (year % 4 == 0) {
            isLeap = true;
        }

        if (year % 100 == 0) {
            isLeap = false;
        }

        if (year % 400 == 0) {
            isLeap = true;
        }

        return isLeap;
    }

    private int daysInGregorianMonth(int y, int m)
    {
        int d = DAYS_IN_GREGORIAN_MONTH[m - 1];

        if (m == 2 && isGregorianLeapYear(y)) {
// 公曆閏年二月多一天
            d++;
        }

        return d;
    }

    private int dayOfYear(int y, int m, int d)
    {
        int c = 0;

        for (int i = 1; i < m; i++) {
            c += daysInGregorianMonth(y, i);
        }

        c += d;
        return c;
    }

    public int dayOfWeek(int y, int m, int d)
    {
        int w = 1; // 公曆一年一月一日是星期一，所以起始值為星期日
        y = (y - 1) % 400 + 1; // 公曆星期值分部 400 年循環一次
        int ly = (y - 1) / 4; // 閏年次數
        ly = ly - (y - 1) / 100;
        ly = ly + (y - 1) / 400;
        int ry = y - 1 - ly; // 常年次數
        w = w + ry; // 常年星期值增一
        w = w + 2 * ly; // 閏年星期值增二
        w = w + dayOfYear(y, m, d);
        w = (w - 1) % 7 + 1;

        return w;
    }

    public int daysInChineseMonth(int y, int m)
    {
// 注意：閏月 m < 0
        int index = y - BASE_CHINESE_YEAR + BASE_INDEX;
        int v = 0;
        int l = 0;
        int d = 30;

        if (1 <= m && m <= 8) {
            v = CHINESE_MONTHS[2 * index];
            l = m - 1;
            if (((v >> l) & 0x01) == 1)
                d = 29;
        } else if (9 <= m && m <= 12) {
            v = CHINESE_MONTHS[2 * index + 1];
            l = m - 9;
            if (((v >> l) & 0x01) == 1)
                d = 29;
        } else {
            v = CHINESE_MONTHS[2 * index + 1];
            v = (v >> 4) & 0x0F;
            if (v != Math.abs(m)) {
                d = 0;
            } else {
                d = 29;
                for (int i = 0; i < BIG_LEAP_MONTH_YEARS.length; i++) {
                    if (BIG_LEAP_MONTH_YEARS[i] == index) {
                        d = 30;
                        break;
                    }
                }
            }
        }

        return d;
    }

    public int nextChineseMonth(int y, int m)
    {
        int n = Math.abs(m) + 1;

        if (m > 0) {
            int index = y - BASE_CHINESE_YEAR + BASE_INDEX;
            int v = CHINESE_MONTHS[2 * index + 1];
            v = (v >> 4) & 0x0F;

            if (v == m) {
                n = -m;
            }
        }

        if (n == 13) {
            n = 1;
        }

        return n;
    }

    public SolarTerms computeSolarTerms(int gregorianYear, int gregorianMonth)
            throws IllegalArgumentException
    {
        if (!validGregorianYear(gregorianYear)) {
            throw new IllegalArgumentException("Gregorian Year must in between 1901 and 2100. Input Year is " + gregorianYear);
        }

        return new SolarTerms(sectionalTerm(gregorianYear, gregorianMonth), principleTerm(gregorianYear, gregorianMonth));
    }

    private int sectionalTerm(int y, int m)
    {
        if (y < 1901 || y > 2100) {
            return 0;
        }

        int index = 0;
        int ry = y - BASE_YEAR + 1;

        while (ry >= SECTIONAL_TERM_YEAR[m - 1][index]) {
            index++;
        }

        int term = SECTIONAL_TERM_MAP[m - 1][4 * index + ry % 4];

        if ((ry == 121) && (m == 4)) {
            term = 5;
        }

        if ((ry == 132) && (m == 4)) {
            term = 5;
        }

        if ((ry == 194) && (m == 6)) {
            term = 6;
        }

        return term;
    }

    private int principleTerm(int y, int m)
    {
        if (y < 1901 || y > 2100) {
            return 0;
        }

        int index = 0;
        int ry = y - BASE_YEAR + 1;

        while (ry >= PRINCIPLE_TERM_YEAR[m - 1][index]) {
            index++;
        }

        int term = principleTermMap[m - 1][4 * index + ry % 4];

        if ((ry == 171) && (m == 3)) {
            term = 21;
        }

        if ((ry == 181) && (m == 5)) {
            term = 21;
        }

        return term;
    }


    private boolean validGregorianYear(int gregorianYear)
    {
        return gregorianYear >= 1901 && gregorianYear <= 2100;
    }

    public LunarCalendar convertToLunarCalendar(int gregorianYear, int gregorianMonth, int gregorianDate)
            throws IllegalArgumentException
    {
        if (!validGregorianYear(gregorianYear)) {
            throw new IllegalArgumentException("Gregorian Year must in between 1901 and 2100. Input Year is " + gregorianYear);
        }

        int startYear = BASE_YEAR;
        int startMonth = BASE_MONTH;
        int startDate = BASE_DATE;
        int chineseYear = BASE_CHINESE_YEAR;
        int chineseMonth = BASE_CHINESE_MONTH; // 負數表示閏月
        int chineseDate = BASE_CHINESE_DATE;

        if (gregorianYear >= 2000) {
            startYear = BASE_YEAR + 99;
            startMonth = 1;
            startDate = 1;
            chineseYear = BASE_CHINESE_YEAR + 99;
            chineseMonth = 11;
            chineseDate = 25;
        }

        int daysDiff = 0;
        for (int i = startYear; i < gregorianYear; i++) {
            daysDiff += 365;

            if (isGregorianLeapYear(i)) {
// leap year
                daysDiff += 1;
            }
        }

        for (int i = startMonth; i < gregorianMonth; i++) {
            daysDiff += daysInGregorianMonth(gregorianYear, i);
        }

        daysDiff += gregorianDate - startDate;
        chineseDate += daysDiff;

        int lastDate = daysInChineseMonth(chineseYear, chineseMonth);
        int nextMonth = nextChineseMonth(chineseYear, chineseMonth);

        while (chineseDate > lastDate) {
            if (Math.abs(nextMonth) < Math.abs(chineseMonth)) {
                chineseYear++;
            }

            chineseMonth = nextMonth;
            chineseDate -= lastDate;
            lastDate = daysInChineseMonth(chineseYear, chineseMonth);
            nextMonth = nextChineseMonth(chineseYear, chineseMonth);
        }

        return new LunarCalendar(chineseYear - 2697, chineseMonth, chineseDate);
    }

    public String cyclicalm(int num) {

        return (STEM_NAMES[num % 10] + BRANCH_NAMES[num % 12]);
    }

    public String getChineseMonth(int num) {
        return CHINESE_MONTH_NAMES[num - 1];
    }

    public String getChineseDayString(int day) {
        String chineseTen[] = {"初", "十", "廿", "卅"};
        int n = day % 10 == 0 ? 9 : day % 10 - 1;
        if (day > 30)
            return "";
        if (day == 10)
            return "初十";
        else
            return chineseTen[day / 10] + CHINESE_NUMBER[n];
    }

    public String convertToChineseTime(int hour) {
        String chineseTimeString = null;

        switch(hour) {
            case 0:
                chineseTimeString = "早子";
                break;
            case 1:case 2:
                chineseTimeString = "丑";
                break;
            case 3:case 4:
                chineseTimeString = "寅";
                break;
            case 5:case 6:
                chineseTimeString = "卯";
                break;
            case 7:case 8:
                chineseTimeString = "辰";
                break;
            case 9:case 10:
                chineseTimeString = "巳";
                break;
            case 11:case 12:
                chineseTimeString = "午";
                break;
            case 13:case 14:
                chineseTimeString = "未";
                break;
            case 15:case 16:
                chineseTimeString = "申";
                break;
            case 17:case 18:
                chineseTimeString = "酉";
                break;
            case 19:case 20:
                chineseTimeString = "戌";
                break;
            case 21:case 22:
                chineseTimeString = "亥";
                break;
            case 23:
                chineseTimeString = "晚子";
                break;
        }
        return chineseTimeString;
    }
}

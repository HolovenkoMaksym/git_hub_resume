package com.holovenko.githubresume.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class MathUtils {

    public static Double calculatePercentage(long total, long target) {
        return ((double) target / total) * 100;
    }
}

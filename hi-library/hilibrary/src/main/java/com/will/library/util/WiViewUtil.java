package com.will.library.util;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import java.util.ArrayDeque;
import java.util.Deque;

public class WiViewUtil {
    /**
     * 获取指定类型的子View
     *
     * @param group ViewGroup
     * @param cls
     * @param <T>
     * @return 指定类型的View
     */
    public static <T> T findTypeView(@Nullable ViewGroup group, Class<T> cls) {
        if (null == group) {
            return null;
        }

        Deque<View> deque = new ArrayDeque<>();
        deque.add(group);
        while (!deque.isEmpty()) {
            View node = deque.removeFirst();
            if (cls.isInstance(node)) {
                return cls.cast(node);
            } else if (node instanceof ViewGroup) {
                ViewGroup container = (ViewGroup) node;
                for (int i = 0; i < container.getChildCount(); i++) {
                    deque.add(container.getChildAt(i));
                }
            }
        }

        return null;
    }
}

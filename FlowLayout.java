package com.example.fenglei.flowlayout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by fenglei on 17-9-22.
 */

public class FlowLayout extends ViewGroup {

    public FlowLayout(Context context) {
        super(context);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int widthUsed = getPaddingLeft() + getPaddingRight();
        int heightUsed = getPaddingBottom() + getPaddingTop();
        int maxChildHeight = 0;
        int childCount = getChildCount();
        for(int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            MarginLayoutParams layoutParams = (MarginLayoutParams) child.getLayoutParams();
            widthUsed += layoutParams.leftMargin + layoutParams.rightMargin;
            int childWidthMeasureSpec = getChildMeasureSpec(
                    widthMeasureSpec, widthUsed, layoutParams.width);
            int childHeightMeasureSpec = getChildMeasureSpec(
                    heightMeasureSpec, layoutParams.topMargin + layoutParams.bottomMargin,
                    layoutParams.height);
            child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
            widthUsed += child.getMeasuredWidth();
            if(maxChildHeight < child.getMeasuredHeight() +
                    layoutParams.topMargin + layoutParams.bottomMargin) {
                maxChildHeight = child.getMeasuredHeight() +
                        layoutParams.topMargin + layoutParams.bottomMargin;
            }
            if(widthUsed >= widthSize) {
                heightUsed += maxChildHeight;
                widthUsed = getPaddingLeft() + getPaddingRight();
            }
        }
        setMeasuredDimension(widthSize, heightMode == MeasureSpec.EXACTLY ? heightSize : heightUsed);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int width = getMeasuredWidth();
        int widthUsed = getPaddingLeft();
        int heightUsed = getPaddingTop();
        int childCount = getChildCount();
        for(int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            MarginLayoutParams layoutParams = (MarginLayoutParams) child.getLayoutParams();
            int left  = widthUsed + layoutParams.leftMargin;
            int top = heightUsed;
            if(left + child.getMeasuredWidth() > width) {
                left = getPaddingLeft();
                top += child.getMeasuredHeight();
            }
            child.layout(left, top, left + child.getMeasuredWidth(), top + child.getMeasuredHeight());
            widthUsed += widthUsed + getMeasuredWidth();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

}

//http://www.geeksforgeeks.org/largest-rectangular-area-in-a-histogram-set-1/
//http://www.geeksforgeeks.org/largest-rectangle-under-histogram/

package com.dataStructure_algriothm.questions;

import java.util.Stack;

public class LargestRectangularHistogram
{
    // The main function to find the maximum rectangular area under given
    // histogram with n bars
    static int getMaxArea(int hist[], int n)
    {
        // Create an empty stack. The stack holds indexes of hist[] array
        // The bars stored in stack are always in increasing order of their
        // heights.
        Stack<Integer> s = new Stack<>();

        int max_area = 0; // Initialize max area
        int tp; // To store top of stack
        int area_with_top; // To store area with top bar as the smallest bar

        // Run through all bars of given histogram
        int i= 0;
        while(i < n)
        {
            // If this bar is higher than the bar on top stack, push it to stack
            if (s.isEmpty() || hist[i] >= hist[s.peek()])
            {
                s.push(i);
                i++; // Move to next rectangle
            }
            // If this bar is lower than top of stack, then calculate area of rectangle
            // with stack top as the smallest (or minimum height) bar. 'i' is
            // 'right index' for the top and element before top in stack is 'left index'
            else
            {
                tp = s.pop();

                // Calculate the area with hist[tp] stack as smallest bar
                area_with_top = hist[tp] * (s.isEmpty() ? i : i - 1 - s.peek());

                max_area = Math.max(max_area, area_with_top);
                // Keep i as current right index to calculate all areas where stack elements are higher
                // hist[i]
            }
        }

        // Now pop the remaining bars from stack and calculate area with every
        // popped bar as the smallest bar
        while (s.empty() == false)
        {
            tp = s.peek();
            s.pop();
            area_with_top = hist[tp] * (s.empty() ? i : i - s.peek() - 1);

            if (max_area < area_with_top)
                max_area = area_with_top;
        }

        return max_area;
    }

    // Driver program to test above function
    public static void main(String[] args)
    {
        int hist[] = { 6, 2, 5, 4, 5, 1, 6 };
        System.out.println("Maximum area is " + getMaxArea(hist, hist.length));
    }
}

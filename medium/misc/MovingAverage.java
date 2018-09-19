package medium.misc;

import java.util.LinkedList;

class MovingAverage {

    int denominator = 1;
    int size = 0;
    LinkedList<Integer> ll;
    double previousSum = 0;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        ll = new LinkedList<Integer>();
        this.size=size;
    }

    public double next(int val) {
        ll.addLast(val);
        if(ll.size()>size) {
            previousSum -= ll.removeFirst();
        }
        previousSum += val;

        return previousSum/ll.size();
    }
}

class MovingAverageShort {

    int denominator = 1;
    int size = 0;
    LinkedList<Integer> ll;
    double previousSum = 0;

    /** Initialize your data structure here. */
    public MovingAverageShort(int size) {
        ll = new LinkedList<Integer>();
        this.size=size;
    }

    public double next(int val) {
        int denominator= 0;
        ll.addLast(val);
        if(ll.size()>size) {
            previousSum -= ll.removeFirst();
            denominator = size;
        }
        else
            denominator = ll.size();

        previousSum += val;

        return previousSum/denominator;
    }
}

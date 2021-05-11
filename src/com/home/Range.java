package com.home;

import java.util.ArrayList;
import java.util.List;

public class Range {

    private final int begin;
    private final int end;
    private final int width;

    /* both begin and end are inclusive */
    public Range(int begin, int end, int width) {
        this.begin = begin;
        this.end = end;
        this.width = width;

        if (this.end < this.begin) { // Allowing equality e.g. [1, 1] and the resultant pair will contain repeated 1s
            throw new RuntimeException(String.format("Invalid range: [%d,%d]", this.begin, this.end));
        }
    }

    public List<Pair> get_pairs() {
        // full pairs are pairs which cover width: e.g. in begin:1, end:104, width:100
        // there will be one full pair: [1, 100]
        int full_pair_count = (end - begin + 1) / width;

        int pair_begin = this.begin;
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < full_pair_count; ++i) {
            pairs.add(new Pair(pair_begin, pair_begin + width - 1)); // both are inclusive, hence -1
            pair_begin += width;
        }

        // there will be 4 left over values in cases like: begin:1, end:104, width:100
        // and there will be NO left overs in cases like: begin:1, end:100, width:100
        boolean left_overs = ((end - begin + 1) % width != 0);
        if (left_overs) {
            int next_pair_begin = pairs.isEmpty() ? this.begin : pairs.get(pairs.size() - 1).last + 1;
            pairs.add(new Pair(next_pair_begin, this.end));
        }

        return pairs;
    }


    static class Pair {

        /* Both first and second are inclusive */
        public Pair(int first, int last) {
            this.first = first;
            this.last = last;
        }

        public final int first;
        public final int last;

        @Override
        public String toString() {
            return "Pair{" +
                    "first=" + first +
                    ", last=" + last +
                    '}';
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null || getClass() != obj.getClass())
                return false;

            Pair other = (Pair) obj;
            return this.first == other.first && this.last == other.last;
        }
    }


    public static void main(String[] args) {
        // write your code here
    }
}

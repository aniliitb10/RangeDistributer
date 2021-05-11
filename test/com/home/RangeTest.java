package com.home;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class RangeTest {
    @Test
    public void test_get_mix_ranges() {
        Range range = new Range(1, 104, 100);
        List<Range.Pair> ranges = range.get_pairs();
        List<Range.Pair> expected = Arrays.asList(new Range.Pair(1, 100), new Range.Pair(101, 104));

        Assertions.assertIterableEquals(expected, ranges);
    }

    @Test
    public void test_get_full_ranges() {
        Range range = new Range(1, 40, 10);
        List<Range.Pair> ranges = range.get_pairs();
        List<Range.Pair> expected = Arrays.asList(new Range.Pair(1, 10), new Range.Pair(11, 20), new Range.Pair(21, 30),
                new Range.Pair(31, 40));

        Assertions.assertIterableEquals(expected, ranges);
    }

    @Test
    public void test_get_partial_ranges() {
        Range range = new Range(1, 40, 50);
        List<Range.Pair> ranges = range.get_pairs();
        List<Range.Pair> expected = Collections.singletonList(new Range.Pair(1, 40));

        Assertions.assertIterableEquals(expected, ranges);
    }

    @Test
    public void test_get_boundary_ranges() {
        Range range = new Range(1, 20, 20);
        List<Range.Pair> ranges = range.get_pairs();
        List<Range.Pair> expected = Collections.singletonList(new Range.Pair(1, 20));

        Assertions.assertIterableEquals(expected, ranges);
    }

    @Test
    public void test_get_another_mix_ranges() {
        Range range = new Range(1, 21, 20);
        List<Range.Pair> ranges = range.get_pairs();
        List<Range.Pair> expected = Arrays.asList(new Range.Pair(1, 20), new Range.Pair(21, 21));

        Assertions.assertIterableEquals(expected, ranges);
    }

    @Test
    public void test_get_another_partial_ranges() {
        Range range = new Range(1, 1, 20);
        List<Range.Pair> ranges = range.get_pairs();
        List<Range.Pair> expected = Collections.singletonList(new Range.Pair(1, 1));

        Assertions.assertIterableEquals(expected, ranges);
    }
}
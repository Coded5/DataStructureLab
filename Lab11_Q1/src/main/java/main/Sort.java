package main;

public class Sort {

    private static Pair[] mergePair(Pair[] pair1, Pair[] pair2) {
        int totalLength = pair1.length + pair2.length;
        Pair[] merged = new Pair[totalLength];

        int i = 0;
        int j = 0;
        int accum = 0;
        while (i < pair1.length && j < pair2.length) {
            if (pair1[i].isMoreThan(pair2[j]))
                merged[accum++] = pair1[i++];
            else
                merged[accum++] = pair2[j++];
        }

        while (i < pair1.length)
            merged[accum++] = pair1[i++];

        while (j < pair2.length)
            merged[accum++] = pair2[j++];

        return merged;
    }

    private static Pair[] mergeSortPair(Pair[] data) {
        if (data.length == 1) {
            return data;
        }

        int partitionLength = data.length / 2;
        Pair[] leftPairs = new Pair[partitionLength];
        Pair[] rightPairs = new Pair[data.length - partitionLength];

        for (int i = 0; i < partitionLength; i++) {
            leftPairs[i] = data[i];
        }

        for (int i = partitionLength; i < data.length; i++) {
            rightPairs[i - partitionLength] = data[i];
        }

        return mergePair(
                mergeSortPair(leftPairs),
                mergeSortPair(rightPairs));
    }

    public static int[] sortFrequency(int[] array) {
        Pair[] pairs = new Pair[10];
        int size = 0;

        for (int i : array) {
            if (pairs[i - 1] == null) {
                pairs[i - 1] = new Pair(i, 0);
                size++;
            }
            pairs[i - 1].freq++;
        }

        Pair[] actualPairs = new Pair[size];
        int current = 0;
        for (int i = 0; i < pairs.length; i++) {
            if (pairs[i] == null)
                continue;

            actualPairs[current++] = pairs[i];
        }

        Pair[] sortedPairs = mergeSortPair(actualPairs);
        int[] result = new int[sortedPairs.length];

        for (int i = 0; i < sortedPairs.length; i++) {
            result[i] = sortedPairs[i].value;
        }

        return result;
    }

}

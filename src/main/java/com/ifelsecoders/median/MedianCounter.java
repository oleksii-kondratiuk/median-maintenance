package com.ifelsecoders.median;

import com.ifelsecoders.median.model.MaxHeap;
import com.ifelsecoders.median.model.MinHeap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class MedianCounter {

    private MaxHeap leftHeap;
    private MinHeap rightHeap;

    public Integer countMediansInFile(File inputFile) {
        leftHeap = new MaxHeap();
        rightHeap = new MinHeap();
        Integer medianSum = null;
        try{
            InputStream inputFS = new FileInputStream(inputFile);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
            List<Integer> medians = br.lines()
                .map(value -> calculateMedian(Integer.valueOf(value)))
//                .mapToInt(Integer::intValue)
                .collect(Collectors.toList());
            medianSum = medians.stream().mapToInt(Integer::intValue).sum();
            br.close();
        } catch (IOException e) {
            System.out.print(e);
        }
        return medianSum;
    }

    private Integer calculateMedian(Integer value) {
        if(leftHeap.size() == 0 && rightHeap.size() == 0) {
            leftHeap.insert(value);
            return value;
        }

        if(leftHeap.checkTopValue() > value) {
            leftHeap.insert(value);
            if(leftHeap.size() - rightHeap.size() > 1) {
                rightHeap.insert(leftHeap.extractTopValue());
            }
        } else if(rightHeap.size() == 0) {
            rightHeap.insert(value);
        } else if (rightHeap.checkTopValue() < value) {
            rightHeap.insert(value);
            if(rightHeap.size() - leftHeap.size() > 1) {
                leftHeap.insert(rightHeap.extractTopValue());
            }
        } else { // if(leftHeap.size() == rightHeap.size())
            leftHeap.insert(value);
        }

        if(leftHeap.size() >= rightHeap.size()) {
            return leftHeap.checkTopValue();
        } else {
            return rightHeap.checkTopValue();
        }
    }
}

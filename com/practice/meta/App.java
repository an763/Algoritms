package com.practice.meta;

import java.util.*;
import java.util.stream.Collectors;

public class App {

    public int[] recommendMovies(int[] userHistory, int[] popularMovies, int[] unpopularMovies) {
        List<Integer> userHistoryList = Arrays.stream(userHistory).boxed().collect(Collectors.toList());
        List<Integer> popularMoviesList = Arrays.stream(userHistory).boxed().collect(Collectors.toList());
        List<Integer> unpopularMoviesList = Arrays.stream(userHistory).boxed().collect(Collectors.toList());
        popularMoviesList.removeAll(unpopularMoviesList);
        popularMoviesList.removeAll(userHistoryList);
        popularMoviesList.sort((i1,i2) -> i1-i2);
        return popularMoviesList.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public long[] optimizedReplace(long[] A, long[] B)
    {
        List<MyObject> myObjList = new ArrayList<>();
        for(int i=0; i<B.length; i++){
            myObjList.add(new MyObject(B[i], i,0));
        }
        myObjList.sort((o1, o2) -> ((int)(o1.b-o2.b)));

        for(int i=1; i<myObjList.size()-1; i++){
            myObjList.get(i).indexA = (myObjList.get(i).b - myObjList.get(i-1).b) > (myObjList.get(i+1).b - myObjList.get(i).b) ? myObjList.get(i+1).indexB : myObjList.get(i-1).indexB;
        }

        myObjList.get(0).indexA = myObjList.get(1).indexB;
        myObjList.get(B.length-1).indexA = myObjList.get(B.length-2).indexB;

        long[] C = new long[B.length];

        for(int i=0; i< B.length; i++)
        {
            C[i] = A[myObjList.get(i).indexA];
        }
        return C;
    }



}

class MyObject{

    public MyObject(long val, int index1, int index2){
        b=val;indexA=index2; indexB=index1;
    }
    long b;
    int indexB;
    int indexA;

}
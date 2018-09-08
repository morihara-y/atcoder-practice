package com.atcoder.practice.abc109.c.main;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        long xStart = sc.nextLong();
        long[] x = makeArrayAndSort(n, sc, xStart);
        long[] differenceArray = makeDifferenceArray(x);
        System.out.println(getResult(differenceArray));
    }
    
    private long[] makeArrayAndSort(int max, FastScanner sc, long xStart) {
        long[] array = new long[max + 1];
        for (int i = 0; i < max; i++) {
            array[i] = sc.nextLong();
        }
        array[max] = xStart;
        Arrays.sort(array);
        return array;
    }
    
    private long[] makeDifferenceArray(long[] x) {
        long[] differenceArray = new long[x.length - 1];
        for (int i = 0; i < x.length - 1; i++) {
            differenceArray[i] = x[i + 1] - x[i];
        }
        return differenceArray;
    }
    
    private long getResult(long[] differenceArray) {
        long min = getMin(differenceArray);
        long max = 1;
        for (long i = min; i >= 1; i--) {
            boolean isDivisible = true;
            for (int j = 0; j < differenceArray.length; j++) {
                if (differenceArray[j] % i != 0) {
                    isDivisible = false;
                    break;
                }
            }
            if (isDivisible) {
                max = Math.max(max, i);
                break;
            }
        }
        return max;
    }
    
    private long getMin(long[] array) {
        long min = array[0];
        for (int i = 1; i < array.length; i++) {
            min = Math.min(min, array[i]);
        }
        return min;
    }

    class FastScanner implements Closeable{
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1024];
        private int ptr = 0;
        private int buflen = 0;
        private boolean hasNextByte() {
            if (ptr < buflen) {
                return true;
            }else{
                ptr = 0;
                try {
                    buflen = in.read(buffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (buflen <= 0) {
                    return false;
                }
            }
            return true;
        }
        private int readByte() { if (hasNextByte()) return buffer[ptr++]; else return -1;}
        private boolean isPrintableChar(int c) { return 33 <= c && c <= 126;}
        public boolean hasNext() { while(hasNextByte() && !isPrintableChar(buffer[ptr])) ptr++; return hasNextByte();}
        public String next() {
            if (!hasNext()) throw new NoSuchElementException();
            StringBuilder sb = new StringBuilder();
            int b = readByte();
            while(isPrintableChar(b)) {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }
        public long nextLong() {
            if (!hasNext()) throw new NoSuchElementException();
            long n = 0;
            boolean minus = false;
            int b = readByte();
            if (b == '-') {
                minus = true;
                b = readByte();
            }
            if (b < '0' || '9' < b) {
                throw new NumberFormatException();
            }
            while(true){
                if ('0' <= b && b <= '9') {
                    n *= 10;
                    n += b - '0';
                }else if(b == -1 || !isPrintableChar(b)){
                    return minus ? -n : n;
                }else{
                    throw new NumberFormatException();
                }
                b = readByte();
            }
        }
        public int nextInt() {
            long nl = nextLong();
            if (nl < Integer.MIN_VALUE || nl > Integer.MAX_VALUE) throw new NumberFormatException();
            return (int) nl;
        }
        public double nextDouble() { return Double.parseDouble(next());}
        public void close() throws IOException {
            try {
                in.close();
            } catch (IOException e) {
            }
        }
    }
}

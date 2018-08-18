package com.atcoder.practice.abc106.d.main;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class FasterMain {
    public static void main(String[] args) {
        new FasterMain().run();
    }
    
    public void run() {
        FastScanner sc = new FastScanner();
        int nUp = sc.nextInt();
        int mUp = sc.nextInt();
        int qUp = sc.nextInt();
        int[][] lrArray = makeArray(mUp, sc);
        int[][] pqArray = makeArray(qUp, sc);
        for (int i = 0; i < qUp; i++) {
            int p = pqArray[i][0];
            int q = pqArray[i][1];
            int result = 0;
            for (int j = 0; j < mUp; j++) {
                int l = lrArray[j][0];
                int r = lrArray[j][1];
                if (p <= l && r <= q) {
                    result++;
                }
            }
            System.out.println(result);
        }
    }

    private int[][] makeArray(int max, FastScanner sc) {
        int[][] array = new int[max][2];
        for (int i = 0; i < max; i++) {
            array[i][0] = sc.nextInt();
            array[i][1] = sc.nextInt();
        }
        return array;
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

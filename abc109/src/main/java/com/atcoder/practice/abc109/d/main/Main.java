package com.atcoder.practice.abc109.d.main;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        FastScanner sc = new FastScanner();
        int h = sc.nextInt();
        int w = sc.nextInt();
        boolean[][] a = makeArray(h, w, sc);
        List<String> result = new ArrayList<>();
        AtomicInteger ai = new AtomicInteger(0);
        while (true) {
            int i = ai.getAndIncrement();
            if (i % 2 == 0) {
                for (int j = 0; j < w - 1; j++) {
                    if (!a[i][j]) {
                        moveRight(i, j, a, result);
                    }
                }
                if (i + 1 == h) {
                    break;
                }
                if (!a[i][w - 1]) {
                    moveDown(i, w - 1, a, result);
                }
            } else {
                for (int j = w - 1; j > 0; j--) {
                    if (!a[i][j]) {
                        moveLeft(i, j, a, result);
                    }
                }
                if (i + 1 == h) {
                    break;
                }
                if (!a[i][0]) {
                    moveDown(i, 0, a, result);
                }
            }
        }
        System.out.println(result.size());
        for (String line : result) {
            System.out.println(line);
        }
    }
    
    private void moveRight(int i, int j, boolean[][] a, List<String> result) {
        StringBuilder sb = new StringBuilder();
        makeCordinatePoint(sb, i, j);
        sb.append(" ");
        makeCordinatePoint(sb, i, j + 1);
        result.add(sb.toString());
        a[i][j] = true;
        a[i][j + 1] = !a[i][j + 1];
    }
    
    private void moveDown(int i, int j, boolean[][] a, List<String> result) {
        StringBuilder sb = new StringBuilder();
        makeCordinatePoint(sb, i, j);
        sb.append(" ");
        makeCordinatePoint(sb, i + 1, j);
        result.add(sb.toString());
        a[i][j] = true;
        a[i + 1][j] = !a[i + 1][j];
    }
    
    private void moveLeft(int i, int j, boolean[][] a, List<String> result) {
        StringBuilder sb = new StringBuilder();
        makeCordinatePoint(sb, i, j);
        sb.append(" ");
        makeCordinatePoint(sb, i, j - 1);
        result.add(sb.toString());
        a[i][j] = true;
        a[i][j - 1] = !a[i][j - 1];
    }

    private void makeCordinatePoint(StringBuilder sb, int a, int b) {
        sb.append(a + 1);
        sb.append(" ");
        sb.append(b + 1);
    }
    
    private boolean[][] makeArray(int rowMax, int columnMax, FastScanner sc) {
        boolean[][] array = new boolean[rowMax][columnMax];
        for (int i = 0; i < rowMax; i++) {
            for (int j = 0; j < columnMax; j++) {
                int a = sc.nextInt();
                array[i][j] = (a % 2 == 0);
            }
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

